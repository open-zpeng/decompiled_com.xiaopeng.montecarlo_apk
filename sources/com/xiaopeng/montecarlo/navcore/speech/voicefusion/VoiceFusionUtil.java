package com.xiaopeng.montecarlo.navcore.speech.voicefusion;

import android.provider.Settings;
import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.speech.aios.NaviModel;
import com.xiaopeng.montecarlo.navcore.speech.bean.SpeechData;
import com.xiaopeng.montecarlo.navcore.speech.bean.SpeechDataContentItem;
import com.xiaopeng.montecarlo.navcore.speech.bean.SpeechDataContentItemExtra;
import com.xiaopeng.montecarlo.navcore.speech.bean.SpeechDataExtra;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
import com.xiaopeng.montecarlo.navcore.xptbt.XUIServiceManager;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.speech.SpeechClient;
import com.xiaopeng.speech.jarvisproto.FeedUIEvent;
import com.xiaopeng.speech.protocol.bean.FeedListUIValue;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class VoiceFusionUtil {
    private static final String DATA_TYPE_NAVI = "navi";
    private static final String DATA_TYPE_NAVI_ROUTE = "navi_route";
    public static final String DOMAIN_NAVIGATION = "navigation";
    private static final int EVENT_NAVI_CLICK_NOTICE_INTERVAL = 500;
    public static final int FUN_TYPE_ROUTE = 1;
    public static final int FUN_TYPE_SEARCH_RESULT = 0;
    private static final int INFOFLOW_CARD_FOCUS_NOTICE_PER_DELAY = 500;
    public static final String INTENT_NAME_ONWAY = "navigation_search_onway";
    private static final int INVALID_INDEX = -1;
    public static final String KEY_CENTER_POI = "center_poi";
    public static final String KEY_DATA = "data";
    public static final String KEY_DATA_TYPE = "data_type";
    public static final String KEY_IS_DATA_LEGAL = "is_data_legal";
    public static final String KEY_IS_ONWAY = "is_onway";
    public static final String KEY_KEYWORD = "keyword";
    public static final String STATUS_QUIT = "quit";
    private static final L.Tag TAG = new L.Tag("VoiceFusionUtil");
    public static final int INFOFLOW_TOP_OFFSET_BACK_TO_LIST = ContextUtils.getDimensionPixelSize(R.dimen.voice_fusion_top_offset_back_to_list);
    private static volatile VoiceFusionUtil sInstance = new VoiceFusionUtil();
    private final Hashtable<String, Boolean> mVoiceData = new Hashtable<>();
    private boolean mIsVoiceSearchFusionMode = false;
    private int mFocusIndex = -1;
    private Timer mFocusChangeTimer = null;
    private TimerTask mFocusChangeTimerTask = null;
    private String mScriptId = null;
    private SystemUIValueContentObserver mObserver = new SystemUIValueContentObserver(UiHandlerUtil.getInstance());
    private long mLastNaviClickEventTime = 0;

    /* loaded from: classes3.dex */
    public interface OnVoiceFusionDataAnalysisListener {
        void onError(Exception exc);

        void onSuccess(Map<String, Object> map);
    }

    public static VoiceFusionUtil getInstance() {
        return sInstance;
    }

    public void registerSystemUIValueContentObserver() {
        L.i(TAG, "registerSystemUIValueContentObserver");
        ContextUtils.getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor(SystemUIValueContentObserver.KEY_INFOFLOW_CARD_HEIGHT), true, this.mObserver);
    }

    public void unregisterSystemUIValueContentObserver() {
        L.i(TAG, "unregisterSystemUIValueContentObserver");
        ContextUtils.getContext().getContentResolver().unregisterContentObserver(this.mObserver);
    }

    private void startFocusChangeTimer() {
        stopFocusChangeTimer();
        L.i(TAG, "startFocusChangeTimer");
        if (this.mFocusChangeTimer == null) {
            this.mFocusChangeTimer = new Timer();
        }
        if (this.mFocusChangeTimerTask == null) {
            this.mFocusChangeTimerTask = new TimerTask() { // from class: com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (-1 != VoiceFusionUtil.this.mFocusIndex) {
                        L.Tag tag = VoiceFusionUtil.TAG;
                        L.i(tag, "SPEECH_CMD_VOICE_SEARCH_DATA_ITEM_FOCUSED mFocusIndex:" + VoiceFusionUtil.this.mFocusIndex);
                        SpeechRequestFactory.getInstance().postRequest(20003, String.valueOf(VoiceFusionUtil.this.mFocusIndex), false);
                        VoiceFusionUtil.this.mFocusIndex = -1;
                    }
                }
            };
        }
        this.mFocusChangeTimer.schedule(this.mFocusChangeTimerTask, 500L);
    }

    public void stopFocusChangeTimer() {
        L.i(TAG, "stopFocusChangeTimer");
        TimerTask timerTask = this.mFocusChangeTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.mFocusChangeTimerTask = null;
        }
        Timer timer = this.mFocusChangeTimer;
        if (timer != null) {
            timer.purge();
            this.mFocusChangeTimer.cancel();
            this.mFocusChangeTimer = null;
        }
    }

    public void enterVoiceSearchFusionMode() {
        this.mIsVoiceSearchFusionMode = true;
    }

    public void exitVoiceSearchFusionMode() {
        this.mIsVoiceSearchFusionMode = false;
    }

    public boolean isInVoiceSearchFusionMode() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isInVoiceSearchFusionMode:" + this.mIsVoiceSearchFusionMode);
        }
        return this.mIsVoiceSearchFusionMode;
    }

    public void analysisVoiceFusionData(String str, OnVoiceFusionDataAnalysisListener onVoiceFusionDataAnalysisListener) {
        SpeechDataExtra extra;
        if (TextUtils.isEmpty(str)) {
            L.e(TAG, "analysis voice fusion data but data is null");
            return;
        }
        try {
            SpeechData speechData = (SpeechData) GsonUtil.fromJson(str, (Class<Object>) SpeechData.class);
            if (speechData == null || speechData.getCount() <= 0 || (extra = speechData.getExtra()) == null || !"navi".equals(extra.getExtraType())) {
                return;
            }
            List<SpeechDataContentItem> content = speechData.getContent();
            if (CollectionUtils.isNotEmpty(content)) {
                ArrayList arrayList = new ArrayList();
                for (SpeechDataContentItem speechDataContentItem : content) {
                    SpeechDataContentItemExtra exta = speechDataContentItem.getExta();
                    if (exta != null) {
                        PoiBean fromJson = PoiBean.fromJson(exta.getNavi());
                        XPPoiInfo xPPoiInfo = new XPPoiInfo();
                        xPPoiInfo.setName(fromJson.getName());
                        xPPoiInfo.setDistrictName(fromJson.getDstName());
                        xPPoiInfo.setPoiId(fromJson.getPoiId());
                        xPPoiInfo.setDisplayLat(fromJson.getLatitude());
                        xPPoiInfo.setDisplayLon(fromJson.getLongitude());
                        xPPoiInfo.setAddress(fromJson.getAddress());
                        xPPoiInfo.setDistance(fromJson.getDistance());
                        xPPoiInfo.setTel(fromJson.getTelephone());
                        xPPoiInfo.setCityName(fromJson.getCityName());
                        xPPoiInfo.setNaviLat(fromJson.getNaviLat());
                        xPPoiInfo.setNaviLon(fromJson.getNaviLon());
                        xPPoiInfo.setCategory(fromJson.getCategory());
                        arrayList.add(xPPoiInfo);
                    }
                }
                Map<String, Object> hashMap = new HashMap<>();
                hashMap.put(KEY_KEYWORD, speechData.getSearchText());
                hashMap.put("data", arrayList);
                hashMap.put(KEY_IS_ONWAY, Boolean.valueOf(INTENT_NAME_ONWAY.equals(speechData.getIntentName())));
                hashMap.put(KEY_CENTER_POI, speechData.getCenterPoi());
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "analysisVoiceFusionData result:" + hashMap);
                }
                noticeAnalysisSuccess(onVoiceFusionDataAnalysisListener, hashMap);
            }
        } catch (Exception e) {
            noticeAnalysisError(onVoiceFusionDataAnalysisListener, e);
            e.printStackTrace();
            L.e(TAG, e.getMessage());
        }
    }

    public Map<String, Object> checkVoiceSearchFusionData(String str) {
        SpeechDataExtra extra;
        HashMap hashMap = new HashMap();
        try {
            SpeechData speechData = (SpeechData) GsonUtil.fromJson(str, (Class<Object>) SpeechData.class);
            if (speechData != null && speechData.getCount() > 0 && (extra = speechData.getExtra()) != null) {
                if ("navi".equals(extra.getExtraType())) {
                    String widgetId = speechData.getWidgetId();
                    Boolean bool = this.mVoiceData.get(widgetId);
                    L.Tag tag = TAG;
                    L.i(tag, "analysisVoiceFusionData widgetId = " + widgetId + ", isExist: " + bool);
                    if (!TextUtils.isEmpty(widgetId)) {
                        if (Boolean.TRUE.equals(bool)) {
                            hashMap.put(KEY_IS_DATA_LEGAL, false);
                            return hashMap;
                        }
                        hashMap.put(KEY_IS_DATA_LEGAL, true);
                        this.mVoiceData.put(widgetId, true);
                        clearOtherVoiceMapTableData(widgetId);
                        hashMap.put("data_type", "navi");
                    }
                } else if ("navi_route".equals(extra.getExtraType())) {
                    hashMap.put(KEY_IS_DATA_LEGAL, true);
                    hashMap.put("data_type", "navi_route");
                } else {
                    L.e(TAG, "checkVoiceSearchFusionData is not navi data");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            L.Tag tag2 = TAG;
            L.e(tag2, "checkVoiceSearchFusionData e:" + e.getMessage());
        }
        return hashMap;
    }

    private void noticeAnalysisError(final OnVoiceFusionDataAnalysisListener onVoiceFusionDataAnalysisListener, final Exception exc) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil.2
            @Override // java.lang.Runnable
            public void run() {
                OnVoiceFusionDataAnalysisListener onVoiceFusionDataAnalysisListener2 = onVoiceFusionDataAnalysisListener;
                if (onVoiceFusionDataAnalysisListener2 != null) {
                    onVoiceFusionDataAnalysisListener2.onError(exc);
                }
            }
        });
    }

    private void noticeAnalysisSuccess(final OnVoiceFusionDataAnalysisListener onVoiceFusionDataAnalysisListener, final Map<String, Object> map) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil.3
            @Override // java.lang.Runnable
            public void run() {
                OnVoiceFusionDataAnalysisListener onVoiceFusionDataAnalysisListener2 = onVoiceFusionDataAnalysisListener;
                if (onVoiceFusionDataAnalysisListener2 != null) {
                    onVoiceFusionDataAnalysisListener2.onSuccess(map);
                }
            }
        });
    }

    public void noticeStopSpeechDialog() {
        NaviModel.getInstance().stopSpeechDialog();
    }

    public void clear() {
        Hashtable<String, Boolean> hashtable = this.mVoiceData;
        if (hashtable != null) {
            hashtable.clear();
        }
        this.mScriptId = null;
        this.mLastNaviClickEventTime = 0L;
    }

    private void clearOtherVoiceMapTableData(String str) {
        Hashtable<String, Boolean> hashtable = this.mVoiceData;
        if (hashtable != null) {
            for (String str2 : hashtable.keySet()) {
                if (!str2.equals(str)) {
                    this.mVoiceData.put(str2, false);
                }
            }
        }
    }

    public void onScript(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            L.Tag tag = TAG;
            L.w(tag, "onScript domain or scriptId is null,domain:" + str + ",scriptId:" + str2);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "onScript domain:" + str + ",scriptId:" + str2);
        }
        if ("navigation".equals(str)) {
            this.mScriptId = str2;
            L.Tag tag3 = TAG;
            L.i(tag3, "onScript navigation domain mScriptId:" + this.mScriptId);
        }
    }

    public void onScriptStatus(String str, String str2) {
        if (isInVoiceSearchFusionMode()) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                L.Tag tag = TAG;
                L.w(tag, "onScriptStatus scriptId or status is null,scriptId:" + str + ",status:" + str2);
                return;
            }
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "onScriptStatus scriptId:" + str + ",status:" + str2 + ",mScriptId:" + this.mScriptId);
            }
            if (str.equals(this.mScriptId) && STATUS_QUIT.equals(str2)) {
                L.Tag tag3 = TAG;
                L.i(tag3, "onScriptStatus quit:" + this.mScriptId);
                onDialogEnd();
            }
        }
    }

    public void onWidgetListExpend(String str) {
        if (isInVoiceSearchFusionMode()) {
            SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_ON_WIDGET_LIST_EXPAND, false);
        }
    }

    public void onInfoflowCardHeightChanged(int i) {
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_INFOFLOW_CARD_HEIGHT_CHANGED, String.valueOf(i), false);
    }

    public void onWidgetCancel(String str, String str2) {
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_ON_WIDGET_CANCEL, false);
    }

    public void onWidgetList(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, Object> checkVoiceSearchFusionData = checkVoiceSearchFusionData(str);
        if (checkVoiceSearchFusionData == null) {
            L.w(TAG, "onWidgetList check map is null");
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onWidgetList checkMap:" + checkVoiceSearchFusionData);
        }
        Object obj = checkVoiceSearchFusionData.get(KEY_IS_DATA_LEGAL);
        Object obj2 = checkVoiceSearchFusionData.get("data_type");
        boolean booleanValue = obj == null ? false : ((Boolean) obj).booleanValue();
        String str2 = obj2 == null ? null : (String) obj2;
        if (!booleanValue) {
            L.w(TAG, "onWidgetList is illegal voice search data called");
            return;
        }
        enterVoiceSearchFusionMode();
        if ("navi".equals(str2)) {
            SpeechRequestFactory.getInstance().postRequest(20002, str, false);
        }
    }

    public void onDialogStart() {
        exitVoiceSearchFusion();
    }

    public void onDialogEnd() {
        exitVoiceSearchFusion();
    }

    private void exitVoiceSearchFusion() {
        if (isInVoiceSearchFusionMode()) {
            exitVoiceSearchFusionMode();
            clear();
            if (-1 != SpeechClient.instance().getSpeechState().getOOBEStatus()) {
                return;
            }
        }
        SpeechRequestFactory.getInstance().postRequest(20001, true);
    }

    public void onWidgetListFocus(String str, int i) {
        if (!isInVoiceSearchFusionMode()) {
            L.w(TAG, "onWidgetListFocus execute failure not is voice search fusion mode");
            return;
        }
        this.mFocusIndex = i;
        startFocusChangeTimer();
    }

    public void onWidgetScroll(String str, final int i) {
        if (isInVoiceSearchFusionMode()) {
            UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil.4
                @Override // java.lang.Runnable
                public void run() {
                    SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_INFOFLOW_SCROLL_END, String.valueOf(i), false);
                }
            }, 1000L);
        }
    }

    public boolean isVoiceFusionSupported() {
        return CarFeatureManager.INSTANCE.isVoiceFusionEnable();
    }

    public boolean isCarSpeechDialogShowing() {
        boolean isShowingDialog = NaviModel.getInstance().isShowingDialog();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isCarSpeechDialogShowing isShowing:" + isShowingDialog);
        }
        return isShowingDialog;
    }

    public int getDefaultInfoflowCardHeight(int i) {
        int dimensionPixelSize;
        if (i == 0) {
            dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.default_voice_fusion_infoflow_card_height_in_search);
        } else {
            dimensionPixelSize = i != 1 ? 0 : ContextUtils.getDimensionPixelSize(R.dimen.default_voice_fusion_infoflow_card_height_in_route);
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getInfoflowCardHeight height:" + dimensionPixelSize + ",carType:" + CarServiceManager.getInstance().getCarType());
        }
        return dimensionPixelSize;
    }

    public void closeCancelableDialog() {
        XUIServiceManager.getInstance().closeCancelableDialog();
    }

    public void sendGUIEventWhenItemFocused(final int i, final String str) {
        WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil.5
            @Override // java.lang.Runnable
            public void run() {
                if (VoiceFusionUtil.this.isInVoiceSearchFusionMode()) {
                    if (L.ENABLE) {
                        L.Tag tag = VoiceFusionUtil.TAG;
                        L.d(tag, "sendGUIEventWhenItemFocused index:" + i);
                    }
                    FeedListUIValue feedListUIValue = new FeedListUIValue();
                    feedListUIValue.source = str;
                    feedListUIValue.index = i;
                    SpeechClient.instance().getAgent().sendUIEvent(FeedUIEvent.LIST_ITEM_FOCUS, GsonUtil.toJson(feedListUIValue));
                }
            }
        });
    }

    public void sendGUIEventWhenItemunFocused(final int i, final String str) {
        WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil.6
            @Override // java.lang.Runnable
            public void run() {
                if (VoiceFusionUtil.this.isInVoiceSearchFusionMode()) {
                    if (L.ENABLE) {
                        L.Tag tag = VoiceFusionUtil.TAG;
                        L.d(tag, "sendGUIEventWhenItemunFocused index:" + i);
                    }
                    FeedListUIValue feedListUIValue = new FeedListUIValue();
                    feedListUIValue.source = str;
                    feedListUIValue.index = i;
                    SpeechClient.instance().getAgent().sendUIEvent(FeedUIEvent.LIST_ITEM_CANCEL_FOCUS, GsonUtil.toJson(feedListUIValue));
                }
            }
        });
    }

    public void sendGUIEventWhenMapOperation() {
        sendGUIEventWhenMapOperation(false);
    }

    public void sendGUIEventWhenMapOperation(final boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mLastNaviClickEventTime;
        if (j == 0 || currentTimeMillis - j >= 500) {
            this.mLastNaviClickEventTime = currentTimeMillis;
            WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil.7
                @Override // java.lang.Runnable
                public void run() {
                    if (L.ENABLE) {
                        L.Tag tag = VoiceFusionUtil.TAG;
                        L.d(tag, "sendGUIEventWhenMapOperation isInVoiceSearchFusionMode:" + VoiceFusionUtil.this.mIsVoiceSearchFusionMode + ",isVoiceNavi:" + z);
                    }
                    if (VoiceFusionUtil.this.isInVoiceSearchFusionMode() || z) {
                        if (L.ENABLE) {
                            L.d(VoiceFusionUtil.TAG, "sendGUIEventWhenMapOperation");
                        }
                        SpeechClient.instance().getAgent().sendUIEvent(FeedUIEvent.NAVI_CLICK, null);
                    }
                }
            });
        }
    }

    public void sendGUIEventWhenBackPressed() {
        WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil.8
            @Override // java.lang.Runnable
            public void run() {
                if (L.ENABLE) {
                    L.d(VoiceFusionUtil.TAG, "sendGUIEventWhenBackPressed");
                }
                SpeechClient.instance().getAgent().sendUIEvent(FeedUIEvent.BACK_PRESSED, null);
            }
        });
    }

    public void sendPoiListExpandUIEvent(final String str) {
        WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil.9
            @Override // java.lang.Runnable
            public void run() {
                if (VoiceFusionUtil.this.isInVoiceSearchFusionMode()) {
                    if (L.ENABLE) {
                        L.d(VoiceFusionUtil.TAG, "sendPoiListExpandUIEvent");
                    }
                    FeedListUIValue feedListUIValue = new FeedListUIValue();
                    feedListUIValue.source = str;
                    SpeechClient.instance().getAgent().sendUIEvent(FeedUIEvent.POI_LIST_EXPEND, GsonUtil.toJson(feedListUIValue));
                }
            }
        });
    }

    public void sendPoiListFoldUIEvent(final String str) {
        WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil.10
            @Override // java.lang.Runnable
            public void run() {
                if (VoiceFusionUtil.this.isInVoiceSearchFusionMode()) {
                    if (L.ENABLE) {
                        L.d(VoiceFusionUtil.TAG, "sendPoiListFoldUIEvent");
                    }
                    FeedListUIValue feedListUIValue = new FeedListUIValue();
                    feedListUIValue.source = str;
                    SpeechClient.instance().getAgent().sendUIEvent(FeedUIEvent.POI_LIST_FOLD, GsonUtil.toJson(feedListUIValue));
                }
            }
        });
    }
}
