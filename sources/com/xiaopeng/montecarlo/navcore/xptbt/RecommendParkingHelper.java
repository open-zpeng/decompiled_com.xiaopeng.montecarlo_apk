package com.xiaopeng.montecarlo.navcore.xptbt;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.aosclient.model.GAimpoiMsg;
import com.autonavi.gbl.aosclient.model.GSendToPhoneRequestParam;
import com.autonavi.gbl.map.layer.model.LayerPriorityType;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.libconfig.ipc.bean.MessageCenterBean;
import com.xiaopeng.libconfig.ipc.bean.MessageContentBean;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.aimessage.bean.OneParkItemBean;
import com.xiaopeng.montecarlo.navcore.aos.AosServiceManager;
import com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.AIRecommendParkEvent;
import com.xiaopeng.montecarlo.navcore.event.AiMessageEvent;
import com.xiaopeng.montecarlo.navcore.event.GuideWrapperNaviEvent;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.parking.ParkingServerDataSource;
import com.xiaopeng.montecarlo.navcore.search.BaseBuilder;
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.util.NaviLogUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.bean.AiMsgSelectBean;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseLinkAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseSegmentAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPDrivePathAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.config.Configuration;
import com.xiaopeng.speech.SpeechClient;
import com.xiaopeng.speech.proxy.SpeechStateProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.validation.constraints.NotNull;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes3.dex */
public class RecommendParkingHelper {
    private static final int AI_MSG_TEXT_STYLE_BLACK = 1;
    private static final int AI_MSG_TEXT_STYLE_GRAY = 2;
    private static final int AI_RECOMMEND_TURN_DIST_THRESHOLD = 220;
    private static final int CANCEL_SPEECH_PARKING = 25000;
    private static final int DEST_IS_PARKING_PLACE_DISTANCE_THRESHOLD = 10;
    private static final int ENOUGH_PARK_COUNT = 99;
    public static final int LAST_MILE_SEND_TO_PHONE = 6;
    public static final int MAX_PARKING_NUMBER = 3;
    private static final int MAX_PARK_COUNT = 999;
    private static final int MAX_RETRY_COUNT = 3;
    private static final int PARKING_AROUND_SEARCH_TYPE_CATEGORY = 2;
    private static final int PARKING_AROUND_SEARCH_TYPE_KEYWORD = 1;
    public static final String PARKING_SEARCH_KEYWORD = "停车场";
    public static final String PARKING_SEARCH_NO_KEYWORD_CATEGORY = "150900|150903|150904|150905|150906|150907|150908|150909|41|010100|010101|010102|010103|010104|010105|010107|010108|010109|010110|010111|010112|180300|180301|180302";
    public static final String PARKING_SEARCH_NO_KEYWORD_RANGE = "100";
    public static final String PARKING_SEARCH_RANGE = "1000";
    public static final int RECOMMEND_NAV_START = 1;
    public static final int RECOMMEND_NAV_STOP = 2;
    public static final int RECOMMEND_ON_SEARCH_RESULT = 5;
    public static final int RECOMMEND_PATH_UPDATE = 0;
    public static final int RECOMMEND_START_REQUEST = 3;
    public static final int RECOMMEND_START_SHOW_PARKING = 4;
    public static final int ROUTE_REMAIN_DIST_1000 = 1000;
    public static final int ROUTE_REMAIN_DIST_1200 = 1200;
    public static final int ROUTE_REMAIN_DIST_2000 = 2000;
    public static final int ROUTE_REMAIN_DIST_800 = 800;
    private static final String SAPA_PARK_PREFIX = "服务区";
    public static final int STATUS_NAVI_STOPPED = 3;
    public static final int STATUS_NONE = -1;
    public static final int STATUS_PARK_POST_CHECKED = 2;
    public static final int STATUS_REQUESTING = 0;
    public static final int STATUS_REQUEST_FINISH = 1;
    private static final L.Tag TAG = new L.Tag("RecommendParkingHelper");
    private long mCurrentPathId;
    @Nullable
    private XPPoiInfo mDestinationPoiInfo;
    @Nullable
    private XPCoordinate2DDouble mEndPoint;
    private boolean mIsFirstSendPhone;
    private volatile int mRetryCount;
    private int mSubPoiParkingSearchIndex;
    private volatile int mTaskId;
    @NonNull
    private final List<XPPoiInfo> mRecommendParkingList = new ArrayList();
    private final Object mLock = new Object();
    private boolean mHasShowedRecommendParking = false;
    private volatile int mStatus = -1;
    private String mAiMessageId = null;
    private HashMap<Request, List<XPPoiInfo>> mRequestResultMap = new HashMap<>();
    private volatile boolean mNeedRetry = true;
    private RecommendParkingHandler mHandler = new RecommendParkingHandler(WorkThreadUtil.getInstance().getStatusThreadLooper());

    private boolean isSlipRoad(int i) {
        return i == 56 || i == 8 || i == 6;
    }

    public void onNaviStart() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        IVariantPath currentNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
        if (currentNaviVariantPath != null) {
            this.mCurrentPathId = currentNaviVariantPath.getPathId();
        }
        updateStatus(-1);
        L.Tag tag = TAG;
        L.i(tag, "onNaviStart pathId: " + this.mCurrentPathId);
    }

    public void onNaviUpdate() {
        IVariantPath currentNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
        long pathId = currentNaviVariantPath != null ? currentNaviVariantPath.getPathId() : -1L;
        L.Tag tag = TAG;
        L.i(tag, "onNaviUpdate old: " + this.mCurrentPathId + ", new: " + pathId);
        if (TBTManager.getInstance().getCurrentStatus() == 0 || pathId == this.mCurrentPathId) {
            return;
        }
        this.mCurrentPathId = pathId;
        if (ignoreShowIfReRoute()) {
            return;
        }
        breakRequestProcess();
        this.mHandler.sendEmptyMessage(0);
    }

    public void onStopNavi() {
        L.i(TAG, "onStopNavi");
        breakRequestProcess();
        this.mHandler.sendEmptyMessage(2);
        EventBus.getDefault().unregister(this);
        this.mIsFirstSendPhone = false;
    }

    public void onNaviInfoUpdate(@NonNull XPNaviInfo xPNaviInfo) {
        if (TBTManager.getInstance().getCurrentStatus() == 2 || !SettingWrapper.isRecommendParkEnabled()) {
            return;
        }
        if (xPNaviInfo.mRouteRemainDist <= 2000.0d && this.mStatus == -1) {
            L.i(TAG, "left distance less than 2000");
            if (!ignoreShowIfReRoute()) {
                this.mHandler.sendEmptyMessage(3);
            }
        }
        if (xPNaviInfo.mRouteRemainDist <= 1200.0d && this.mStatus == 0) {
            L.i(TAG, "left distance less than 1200 ");
            this.mNeedRetry = false;
        }
        if (xPNaviInfo.mRouteRemainDist <= 1000.0d && this.mStatus == 1) {
            L.i(TAG, "left distance less than 1000 ");
            if (!ignoreShowIfReRoute()) {
                Message obtainMessage = this.mHandler.obtainMessage();
                obtainMessage.obj = xPNaviInfo;
                obtainMessage.what = 4;
                this.mHandler.sendMessage(obtainMessage);
            }
        }
        if (!XPAccountServiceWrapper.getInstance().isLoginXp() || !SettingWrapper.getBindAMapStatus() || this.mIsFirstSendPhone || xPNaviInfo.mRouteRemainDist > 700.0d) {
            return;
        }
        L.i(TAG, "left distance less than 700 meters ");
        if (NavCoreUtil.isHomeOrCompanyScope(1000.0d)) {
            return;
        }
        this.mHandler.sendEmptyMessage(6);
        this.mIsFirstSendPhone = true;
    }

    private boolean inAIRecommendParkingCheckRange(@NonNull XPNaviInfo xPNaviInfo) {
        return xPNaviInfo.mRouteRemainDist <= 1000.0d && xPNaviInfo.mRouteRemainDist >= 800.0d;
    }

    private void breakRequestProcess() {
        boolean z = this.mStatus == 0;
        updateStatus(3);
        if (z) {
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        L.i(TAG, "reset");
        hideRecommendParkingPop();
        this.mRecommendParkingList.clear();
        this.mSubPoiParkingSearchIndex = 0;
        updateStatus(-1);
        this.mRetryCount = 0;
        this.mNeedRetry = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecommendRequest() {
        L.i(TAG, "request parking START >>>> ");
        hideRecommendParkingPop();
        updateStatus(0);
        this.mDestinationPoiInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentNaviId());
        this.mEndPoint = TBTManager.getInstance().getRouteLastPoint(TBTManager.getInstance().getCurrentNaviId(), TBTManager.getInstance().getCurrentRoutePathIndex());
        IVariantPath currentNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
        if ((currentNaviVariantPath != null ? currentNaviVariantPath.getPathLength() : 0L) <= 1000) {
            L.i(TAG, "route distance under 1000 m, do not recommend parking");
        } else if (this.mDestinationPoiInfo == null) {
            L.e(TAG, "startRequestRecommendParking destination is null!");
        } else {
            startRequestRecommendParkingFromServer();
            if (CollectionUtils.isEmpty(this.mRecommendParkingList)) {
                startRequestRecommendParkingFromLocal();
            }
            if (this.mStatus == 3) {
                return;
            }
            updateStatus(1);
            L.i(TAG, ">>>>> request parking END");
        }
    }

    private void startRequestRecommendParkingFromServer() {
        List<XPPoiInfo> fetchParking;
        L.Tag tag = TAG;
        L.i(tag, "request parking from SERVER START >>> destination : " + NaviLogUtil.dumpXPPOIInfo(this.mDestinationPoiInfo));
        do {
            L.Tag tag2 = TAG;
            L.i(tag2, "fetchParking mRetryCount: " + this.mRetryCount + ", mNeedRetry : " + this.mNeedRetry);
            this.mRetryCount = this.mRetryCount + 1;
            fetchParking = ParkingServerDataSource.getInstance().fetchParking(this.mDestinationPoiInfo);
            if (fetchParking != null || this.mRetryCount >= 3) {
                break;
            }
        } while (this.mNeedRetry);
        if (!CollectionUtils.isEmpty(fetchParking)) {
            this.mRecommendParkingList.clear();
            this.mRecommendParkingList.addAll(fetchParking);
        }
        StringBuilder sb = new StringBuilder(">>> request parking from SERVER END, parking list:");
        sb.append(GsonUtil.toJson(this.mRecommendParkingList));
        sb.append(", mRetryCount: " + this.mRetryCount);
        sb.append(", mNeedRetry : " + this.mNeedRetry);
        sb.append(", mStatus : " + this.mStatus);
        L.i(TAG, sb.toString());
    }

    private void startRequestRecommendParkingFromLocal() {
        String str;
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("startRequestRecommendParkingFromLocal destination: ");
        sb.append(NaviLogUtil.dumpXPPOIInfo(this.mDestinationPoiInfo));
        sb.append(", endPoint: ");
        if (this.mEndPoint != null) {
            str = this.mEndPoint.mLat + ", " + this.mEndPoint.mLon;
        } else {
            str = "null";
        }
        sb.append(str);
        L.i(tag, sb.toString());
        if (FavoriteDataManager.getInstance().isCompany(this.mDestinationPoiInfo) || FavoriteDataManager.getInstance().isHome(this.mDestinationPoiInfo)) {
            L.i(TAG, "destination is home or company, do not recommend");
            return;
        }
        IVariantPath currentNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
        if (currentNaviVariantPath != null && !matchRoadTypeRule(currentNaviVariantPath)) {
            L.i(TAG, "not match road type rule, do not recommend");
        } else if (!matchAOIRule(this.mDestinationPoiInfo)) {
            L.i(TAG, "not match AOI rule, do not recommend");
        } else if (matchOnlyOneParkingPlaceRule(this.mDestinationPoiInfo)) {
            L.i(TAG, "not match only one parking place rule, do not recommend");
        } else {
            int category = this.mDestinationPoiInfo.getCategory();
            if (category > 0) {
                if (!XPPoiCategory.isRecommendParking(category)) {
                    L.i(TAG, "destination is park, charge or gas, SAPA, do not recommend");
                    return;
                } else {
                    requestParkingOfDestination();
                    return;
                }
            }
            L.i(TAG, "destination has no category, check if has park, service area, gas station in 100m");
            searchAroundDestination();
        }
    }

    private boolean matchOnlyOneParkingPlaceRule(XPPoiInfo xPPoiInfo) {
        ArrayList<XPPoiInfo> park = xPPoiInfo.getPark();
        if (park != null && park.size() <= 1) {
            XPPoiInfo xPPoiInfo2 = park.get(0);
            if (LocationUtils.getDistance(xPPoiInfo2, xPPoiInfo) <= 10.0d || isNearPoi(xPPoiInfo2.getEnters(), new XPCoordinate2DDouble(xPPoiInfo.getDisplayLon(), xPPoiInfo.getDisplayLat()))) {
                return true;
            }
        }
        return false;
    }

    private boolean isNearPoi(ArrayList<XPCoordinate2DDouble> arrayList, XPCoordinate2DDouble xPCoordinate2DDouble) {
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (LocationUtils.getDistance(arrayList.get(i), xPCoordinate2DDouble) <= 10.0d) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean matchAOIRule(XPPoiInfo xPPoiInfo) {
        int category = xPPoiInfo.getCategory();
        return category <= 0 || XPPoiCategory.isRecommendParking(category) || !xPPoiInfo.isInAOI();
    }

    private boolean matchRoadTypeRule(IVariantPath iVariantPath) {
        XPDrivePathAccessor drivePathAccessor;
        if (iVariantPath == null || (drivePathAccessor = iVariantPath.getDrivePathAccessor()) == null) {
            return false;
        }
        XPBaseSegmentAccessor segmentAccessor = drivePathAccessor.getSegmentAccessor(drivePathAccessor.getSegmentCount() - 1);
        if (segmentAccessor == null) {
            drivePathAccessor.recycle();
            return false;
        }
        XPBaseLinkAccessor linkAccessor = segmentAccessor.getLinkAccessor(segmentAccessor.getLinkCount() - 1);
        if (linkAccessor == null) {
            drivePathAccessor.recycle();
            return false;
        }
        int roadClass = linkAccessor.getRoadClass();
        int linkType = linkAccessor.getLinkType();
        int formway = linkAccessor.getFormway();
        drivePathAccessor.recycle();
        return (roadClass == 0 || roadClass == 6 || linkType == 2 || isSlipRoad(formway)) ? false : true;
    }

    private void showRecommendParkingPop(boolean z) {
        StringBuilder sb = new StringBuilder("showRecommendParkingPop  parking list:");
        sb.append(GsonUtil.toJson(this.mRecommendParkingList));
        sb.append("; \n destination: ");
        XPPoiInfo xPPoiInfo = this.mDestinationPoiInfo;
        String str = "null";
        sb.append(xPPoiInfo == null ? "null" : NaviLogUtil.dumpXPPOIInfo(xPPoiInfo));
        sb.append("; \n endPoint: ");
        if (this.mEndPoint != null) {
            str = this.mEndPoint.mLat + "," + this.mEndPoint.mLon;
        }
        sb.append(str);
        sb.append(", isShowAI: ");
        sb.append(z);
        L.i(TAG, sb.toString());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mRecommendParkingList);
        EventBus.getDefault().post(new GuideWrapperNaviEvent.Builder(23).setList(arrayList).setBooleanValue(z).build());
        if (!Configuration.Dependency.AIASSISTANT_ENABLE || z) {
            return;
        }
        TTSProxy.getInstance().speak(ContextUtils.getString(R.string.recommend_parking_speech_alert), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lastMileSend2Phone() {
        L.i(TAG, "lastmile lastMileSend2Phone start");
        GSendToPhoneRequestParam gSendToPhoneRequestParam = new GSendToPhoneRequestParam();
        gSendToPhoneRequestParam.isReliable = true;
        gSendToPhoneRequestParam.bizType = "aimpoi";
        gSendToPhoneRequestParam.expiration = LayerPriorityType.LayerPriorityRouteArrow;
        gSendToPhoneRequestParam.sourceId = "xpnav";
        gSendToPhoneRequestParam.message = "";
        XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentNaviId());
        GAimpoiMsg gAimpoiMsg = gSendToPhoneRequestParam.aimpoiMsg;
        if (gAimpoiMsg != null && endInfo != null) {
            gAimpoiMsg.address = endInfo.getAddress();
            gAimpoiMsg.lat = endInfo.getDisplayLat();
            gAimpoiMsg.lon = endInfo.getDisplayLon();
            gAimpoiMsg.name = endInfo.getName();
            gSendToPhoneRequestParam.message = "{\"address\":\"" + endInfo.getAddress() + "\",\"lon\":" + endInfo.getDisplayLon() + ",\"lat\":" + endInfo.getDisplayLat() + ",\"name\":\"" + endInfo.getName() + "\"}";
        }
        L.Tag tag = TAG;
        L.i(tag, "lastmile phoneRequestParam = " + GsonUtil.toJson(gSendToPhoneRequestParam));
        AosServiceManager.getInstance().requestSendToPhone(gSendToPhoneRequestParam);
        if (endInfo != null) {
            XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
            xPCoordinate2DDouble.mLat = endInfo.getNaviLat();
            xPCoordinate2DDouble.mLon = endInfo.getNaviLon();
            PageType pageType = PageType.NAVI_MESSAGE_NAVI_SYNC;
            BtnType btnType = BtnType.NAVI_GUIDER_AMAP_LAST_MILE_SEND2PHONE;
            Object[] objArr = new Object[4];
            objArr[0] = TextUtils.isEmpty(endInfo.getPoiId()) ? "" : endInfo.getPoiId();
            objArr[1] = Integer.valueOf(endInfo.getType());
            objArr[2] = TextUtils.isEmpty(endInfo.getBlCategory()) ? "" : endInfo.getBlCategory();
            objArr[3] = xPCoordinate2DDouble;
            DataLogUtil.sendStatData(pageType, btnType, objArr);
        }
    }

    public int getRecommendParkingNum() {
        List<XPPoiInfo> list = this.mRecommendParkingList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<XPPoiInfo> getRecommendParks() {
        return this.mRecommendParkingList;
    }

    private void speechRecommendParkingWithAiMsg(@NonNull Context context) {
        String format;
        L.i(TAG, "speechRecommendParkingWithAiMsg " + ContextUtils.getContext().getPackageName());
        if (this.mRecommendParkingList.isEmpty()) {
            return;
        }
        MessageContentBean createContent = MessageContentBean.createContent();
        createContent.setType(14);
        for (int i = 0; i < this.mRecommendParkingList.size(); i++) {
            createContent.addButton(MessageContentBean.MsgButton.create(createOneAiButtonForPark(this.mRecommendParkingList.get(i)), ContextUtils.getContext().getPackageName(), createOneAiButtonCallbackForPark(i)));
        }
        if (1 == TBTManager.getInstance().getRecommendParkingNum()) {
            format = context.getString(R.string.speech_recommend_park3_single);
        } else {
            format = String.format(context.getString(R.string.speech_recommend_park3_multiple), Integer.valueOf(TBTManager.getInstance().getRecommendParkingNum()));
        }
        createContent.setTts(format);
        MessageCenterBean create = MessageCenterBean.create(2, createContent);
        create.setScene(AiMessageEvent.SCENE_RECOMMEND_PARK);
        this.mAiMessageId = create.getMessageId();
        L.i(TAG, "create messageId=" + this.mAiMessageId);
        create.getContentObject().setPosition(2);
        create.setRead_state(1);
        Bundle bundle = new Bundle();
        bundle.putString(IpcConfig.IPCKey.STRING_MSG, GsonUtil.toJson(create));
        if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
            IpcRouterUtil.sendData(10009, bundle, "com.xiaopeng.aiassistant");
        } else {
            ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(10009, bundle, IpcConfig.App.MESSAGE_CENTER);
        }
    }

    private String createOneAiButtonForPark(XPPoiInfo xPPoiInfo) {
        OneParkItemBean oneParkItemBean = new OneParkItemBean();
        oneParkItemBean.setName(xPPoiInfo.getName());
        XPCoordinate2DDouble routeLastPoint = TBTManager.getInstance().getRouteLastPoint(TBTManager.getInstance().getCurrentNaviId(), TBTManager.getInstance().getCurrentNaviPathIndex());
        if (routeLastPoint != null) {
            oneParkItemBean.setDistance(NavCoreUtil.getDistanceString(LocationUtils.getDistance(new XPCoordinate2DDouble(xPPoiInfo), routeLastPoint)));
        }
        int parkTotal = xPPoiInfo.getParkTotal();
        if (parkTotal > 0) {
            OneParkItemBean.LabelBean labelBean = new OneParkItemBean.LabelBean();
            OneParkItemBean.LabelBean labelBean2 = new OneParkItemBean.LabelBean();
            int parkRemain = xPPoiInfo.getParkRemain();
            int chargeNums = NavCoreUtil.getChargeNums(xPPoiInfo, 1);
            int chargeNums2 = NavCoreUtil.getChargeNums(xPPoiInfo, 2);
            int chargeNums3 = NavCoreUtil.getChargeNums(xPPoiInfo, 3);
            int chargeNums4 = NavCoreUtil.getChargeNums(xPPoiInfo, 4);
            if (parkRemain == 0) {
                labelBean.setName(ContextUtils.getString(R.string.ai_message_no_parking_remain));
                labelBean.setColor(OneParkItemBean.COLOR_GRAY);
                oneParkItemBean.setLabel1(labelBean);
                if (parkTotal > 999) {
                    labelBean2.setName(ContextUtils.getString(R.string.ai_message_max_parking_remain));
                    labelBean2.setColor(OneParkItemBean.COLOR_GRAY);
                    oneParkItemBean.setLabel2(labelBean2);
                } else {
                    labelBean2.setName(String.format(Locale.CHINA, ContextUtils.getString(R.string.ai_message_total_parking_num), Integer.valueOf(parkTotal)));
                    labelBean2.setColor(OneParkItemBean.COLOR_GRAY);
                    oneParkItemBean.setLabel2(labelBean2);
                }
            } else if (parkRemain > 0) {
                if (parkRemain > 99) {
                    labelBean.setName(ContextUtils.getString(R.string.ai_message_enough_parking_remain));
                    labelBean.setColor(OneParkItemBean.COLOR_BLUE);
                    oneParkItemBean.setLabel1(labelBean);
                } else {
                    labelBean.setName(String.format(Locale.CHINA, ContextUtils.getString(R.string.ai_message_remain_parking_num), Integer.valueOf(parkRemain)));
                    labelBean.setColor(OneParkItemBean.COLOR_BLUE);
                    oneParkItemBean.setLabel1(labelBean);
                }
                if (chargeNums > 0) {
                    labelBean2.setName(String.format(Locale.CHINA, ContextUtils.getString(R.string.ai_message_fast_charge_parking_num), Integer.valueOf(chargeNums2)));
                    labelBean2.setColor(OneParkItemBean.COLOR_YELLOW);
                    oneParkItemBean.setLabel2(labelBean2);
                } else if (chargeNums3 > 0) {
                    labelBean2.setName(String.format(Locale.CHINA, ContextUtils.getString(R.string.ai_message_normal_charge_parking_num), Integer.valueOf(chargeNums4)));
                    labelBean2.setColor(OneParkItemBean.COLOR_GREEN);
                    oneParkItemBean.setLabel2(labelBean2);
                }
            }
        }
        return GsonUtil.toJson(oneParkItemBean);
    }

    private String createOneAiButtonCallbackForPark(int i) {
        AiMsgSelectBean aiMsgSelectBean = new AiMsgSelectBean();
        aiMsgSelectBean.setType(14);
        aiMsgSelectBean.setIndex(i);
        return GsonUtil.toJson(aiMsgSelectBean);
    }

    private void closeAIAssistant() {
        L.Tag tag = TAG;
        L.i(tag, "closeAIAssistant " + this.mAiMessageId);
        Bundle bundle = new Bundle();
        bundle.putString(IpcConfig.IPCKey.STRING_MSG, this.mAiMessageId);
        if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
            IpcRouterUtil.sendData((int) IpcConfig.AIAssistantConfig.IPC_MESSAGE_CLOSE, bundle, "com.xiaopeng.aiassistant");
        } else {
            ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(IpcConfig.AIAssistantConfig.IPC_MESSAGE_CLOSE, bundle, "com.xiaopeng.aiassistant");
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEvent(IIpcService.IpcMessageEvent ipcMessageEvent) {
        L.Tag tag = TAG;
        L.i(tag, "onEvent msgID = " + ipcMessageEvent.getMsgID());
        handleRecommandParkMessageEvent(ipcMessageEvent.getMsgID(), ipcMessageEvent.getPayloadData());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEvent(IpcRouterUtil.IpcRouterEvent ipcRouterEvent) {
        if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
            L.Tag tag = TAG;
            L.i(tag, "onEvent msgID = " + ipcRouterEvent.getMsgID());
            handleRecommandParkMessageEvent(ipcRouterEvent.getMsgID(), ipcRouterEvent.getPayloadData());
        }
    }

    private void handleRecommandParkMessageEvent(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (i == 10011) {
            String string = bundle.getString(IpcConfig.IPCKey.STRING_MSG);
            L.Tag tag = TAG;
            L.i(tag, "onEvent messageContent = " + string);
            AiMsgSelectBean aiMsgSelectBean = (AiMsgSelectBean) GsonUtil.fromJson(string, (Class<Object>) AiMsgSelectBean.class);
            L.Tag tag2 = TAG;
            L.i(tag2, "onEvent, callback = " + aiMsgSelectBean);
            if (aiMsgSelectBean != null && "for_map".equals(aiMsgSelectBean.getTag()) && 14 == aiMsgSelectBean.getType()) {
                int index = aiMsgSelectBean.getIndex();
                L.Tag tag3 = TAG;
                L.i(tag3, "onEvent select park = " + index);
                TTSProxy.getInstance().speak(ContextUtils.getString(R.string.speech_reply_ok), null);
                selectRecommendParking(index);
            }
        }
        if (i == 11014) {
            L.Tag tag4 = TAG;
            L.i(tag4, "mAiMessageId=" + this.mAiMessageId + " PayloadData=" + bundle.getString(IpcConfig.IPCKey.STRING_MSG));
            String str = this.mAiMessageId;
            if (str != null) {
                str.equals(bundle.getString(IpcConfig.IPCKey.STRING_MSG));
            }
        }
    }

    public void selectRecommendParking(int i) {
        L.Tag tag = TAG;
        L.i(tag, "onEvent select park = " + i);
        if (i > this.mRecommendParkingList.size()) {
            L.Tag tag2 = TAG;
            L.i(tag2, "max park index is " + this.mRecommendParkingList.size());
        } else if (i < 0) {
        } else {
            if (!RootUtil.isTabletApp() && !this.mRecommendParkingList.isEmpty()) {
                XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
                XPPoiInfo xPPoiInfo = this.mRecommendParkingList.get(i);
                if (xPPoiInfo != null) {
                    EventBus.getDefault().post(new AIRecommendParkEvent(startPOIFromCurrent, xPPoiInfo));
                } else {
                    L.w(TAG, "no such park");
                }
            } else if (L.ENABLE) {
                L.Tag tag3 = TAG;
                L.d(tag3, "onEvent, mRecommendParkingList.size=" + this.mRecommendParkingList.size() + ", isTabletApp=" + RootUtil.isTabletApp());
            }
        }
    }

    public void hideRecommendParkingPop() {
        if (this.mHasShowedRecommendParking) {
            EventBus.getDefault().post(new GuideWrapperNaviEvent.Builder(24).build());
            this.mHasShowedRecommendParking = false;
            L.i(TAG, "hideRecommendParkingPop");
            DataLogUtil.sendStatData(PageType.NAVI_GUIDANCE, BtnType.RECOMMEND_PARK_HIDE, new Object[0]);
        }
        closeAIAssistant();
    }

    private void requestRecommendParking() {
        Request buildAroundSearchRequest = buildAroundSearchRequest(1, PARKING_SEARCH_KEYWORD, PARKING_SEARCH_RANGE);
        if (parkingSearch(buildAroundSearchRequest)) {
            List<XPPoiInfo> remove = this.mRequestResultMap.remove(buildAroundSearchRequest);
            if (CollectionUtils.isNotEmpty(remove)) {
                addParkingFromDestinationAround(remove);
            }
        }
    }

    private void searchAroundDestination() {
        Request buildAroundSearchRequest = buildAroundSearchRequest(2, PARKING_SEARCH_NO_KEYWORD_CATEGORY, "100");
        if (parkingSearch(buildAroundSearchRequest)) {
            List<XPPoiInfo> remove = this.mRequestResultMap.remove(buildAroundSearchRequest);
            if (CollectionUtils.isEmpty(remove)) {
                requestParkingOfDestination();
                return;
            }
            L.Tag tag = TAG;
            L.i(tag, "Destination around 100m have park, service area or toll station ,don't recommend park: " + GsonUtil.toJson(remove));
        }
    }

    private void requestParkingOfDestination() {
        this.mRecommendParkingList.clear();
        XPPoiInfo xPPoiInfo = this.mDestinationPoiInfo;
        if (xPPoiInfo != null) {
            Request buildKeywordPoiSearchRequest = buildKeywordPoiSearchRequest(xPPoiInfo.getPoiId(), this.mDestinationPoiInfo.getDisplayLon(), this.mDestinationPoiInfo.getDisplayLat());
            if (parkingSearch(buildKeywordPoiSearchRequest)) {
                List<XPPoiInfo> remove = this.mRequestResultMap.remove(buildKeywordPoiSearchRequest);
                if (CollectionUtils.isNotEmpty(remove)) {
                    addParkingFromDestinationSubPoi(remove.get(0));
                    return;
                }
                L.i(TAG, "requestParkingOfDestination no search result, start requestRecommendParking");
                requestRecommendParking();
            }
        }
    }

    private boolean checkCallBackOutDated(Request request) {
        return (this.mTaskId == request.getRequestId() && this.mStatus == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchResult(@NotNull Request request, XPSearchResult xPSearchResult) {
        L.Tag tag = TAG;
        L.i(tag, "response of taskId: " + request.getRequestId());
        if (checkCallBackOutDated(request)) {
            L.Tag tag2 = TAG;
            L.w(tag2, "outdated response of taskId " + request.getRequestId());
        }
        List<XPPoiInfo> list = this.mRequestResultMap.get(request);
        if (xPSearchResult != null && CollectionUtils.isNotEmpty(xPSearchResult.getXPPoiInfos()) && list != null) {
            list.addAll(xPSearchResult.getXPPoiInfos());
        }
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }

    private void requestDestinationParkingDeepInfo(int i) {
        int i2;
        if (i < 0 || i > this.mRecommendParkingList.size() - 1) {
            return;
        }
        XPPoiInfo xPPoiInfo = this.mRecommendParkingList.get(i);
        L.i(TAG, "requestDestinationParkingDeepInfo " + NaviLogUtil.dumpXPPOIInfo(xPPoiInfo));
        Request buildKeywordPoiSearchRequest = buildKeywordPoiSearchRequest(xPPoiInfo.getPoiId(), xPPoiInfo.getDisplayLon(), xPPoiInfo.getDisplayLat());
        if (parkingSearch(buildKeywordPoiSearchRequest)) {
            List<XPPoiInfo> remove = this.mRequestResultMap.remove(buildKeywordPoiSearchRequest);
            XPPoiInfo xPPoiInfo2 = CollectionUtils.isNotEmpty(remove) ? remove.get(0) : null;
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("deep info result for subPoi ");
            sb.append(this.mSubPoiParkingSearchIndex);
            sb.append(", total: ");
            sb.append(this.mRecommendParkingList.size());
            sb.append(", ===> ");
            sb.append(xPPoiInfo2 != null ? NaviLogUtil.dumpXPPOIInfo(xPPoiInfo2) : " null ");
            L.i(tag, sb.toString());
            if (xPPoiInfo2 != null && (i2 = this.mSubPoiParkingSearchIndex) > -1 && i2 < this.mRecommendParkingList.size()) {
                this.mRecommendParkingList.set(this.mSubPoiParkingSearchIndex, xPPoiInfo2);
                this.mSubPoiParkingSearchIndex++;
                requestDestinationParkingDeepInfo(this.mSubPoiParkingSearchIndex);
            }
        }
    }

    private boolean parkingSearch(Request request) {
        if (request == null) {
            L.w(TAG, "parkingSearch, null request");
            return false;
        }
        this.mRequestResultMap.put(request, new ArrayList());
        L.Tag tag = TAG;
        L.i(tag, "parkingSearch start: " + request.getRequestId());
        SearchClient.getInstance().enqueue(request, new ResponseCallback() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.RecommendParkingHelper.1
            @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
            public void onResponse(Request request2, XPSearchResult xPSearchResult) {
                RecommendParkingHelper.this.setSearchResult(request2, xPSearchResult);
            }
        });
        try {
            synchronized (this.mLock) {
                this.mLock.wait();
            }
        } catch (InterruptedException e) {
            L.Tag tag2 = TAG;
            L.e(tag2, "interrupt parkingSearch error: " + request.getRequestId());
            e.fillInStackTrace();
        }
        if (this.mStatus != 0) {
            L.Tag tag3 = TAG;
            L.w(tag3, "parkingSearch not STATUS_REQUESTING, mStatus: " + this.mStatus + ", " + request.getRequestId());
            return false;
        }
        return true;
    }

    private Request buildKeywordPoiSearchRequest(String str, double d, double d2) {
        this.mTaskId = SearchClient.getInstance().getRequestId();
        L.Tag tag = TAG;
        L.i(tag, "buildKeywordPoiSearchRequest, mTaskId: " + this.mTaskId + ", [" + d2 + "], [" + d + "], poiId: " + str);
        return new RequestFactory(1).newBuilder().requestId(this.mTaskId).searchType(KeywordSearchType.KEYWORD_SEARCH_TYPE_POI).poiId(str).poiLocation(new XPCoordinate2DDouble(d, d2)).build();
    }

    private Request buildAroundSearchRequest(int i, String str, String str2) {
        BaseBuilder category;
        if (this.mEndPoint == null) {
            L.e(TAG, "buildAroundSearchRequest startPoiInfo or endPoiInfo is NULL, recommend park failure");
            return null;
        }
        this.mTaskId = SearchClient.getInstance().getRequestId();
        L.Tag tag = TAG;
        L.i(tag, "buildAroundSearchRequest searchType = [" + i + "], condition = [" + str + "], range = [" + str2 + "], mTaskId = [" + this.mTaskId + "]");
        BaseBuilder poiLocation = new RequestFactory(1).newBuilder().requestId(this.mTaskId).searchType(KeywordSearchType.KEYWORD_SEARCH_TYPE_AROUND).radius(str2).poiLocation(new XPCoordinate2DDouble(this.mEndPoint.mLon, this.mEndPoint.mLat));
        if (i == 2) {
            category = poiLocation.category(str);
        } else {
            category = poiLocation.keyword(str);
        }
        return category.build();
    }

    private boolean isPoiInRecommendRange(@Nullable XPPoiInfo xPPoiInfo, @Nullable XPCoordinate2DDouble xPCoordinate2DDouble) {
        return (xPCoordinate2DDouble == null || xPPoiInfo == null || LocationUtils.getDistance(xPCoordinate2DDouble, new XPCoordinate2DDouble(xPPoiInfo)) > Double.valueOf(PARKING_SEARCH_RANGE).doubleValue()) ? false : true;
    }

    private void sortByDistance(@NonNull List<XPPoiInfo> list) {
        if (!CollectionUtils.isNotEmpty(list) || this.mEndPoint == null) {
            return;
        }
        Collections.sort(list, new Comparator<XPPoiInfo>() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.RecommendParkingHelper.2
            @Override // java.util.Comparator
            public int compare(@NonNull XPPoiInfo xPPoiInfo, @NonNull XPPoiInfo xPPoiInfo2) {
                if (RecommendParkingHelper.this.mEndPoint != null) {
                    double distance = LocationUtils.getDistance(RecommendParkingHelper.this.mEndPoint, new XPCoordinate2DDouble(xPPoiInfo));
                    double distance2 = LocationUtils.getDistance(RecommendParkingHelper.this.mEndPoint, new XPCoordinate2DDouble(xPPoiInfo2));
                    if (distance > distance2) {
                        return 1;
                    }
                    if (distance < distance2) {
                        return -1;
                    }
                }
                return 0;
            }
        });
    }

    private void addParkingFromDestinationSubPoi(@Nullable XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo != null && CollectionUtils.isNotEmpty(xPPoiInfo.getChild())) {
            ArrayList arrayList = new ArrayList();
            ArrayList<XPPoiInfo> child = xPPoiInfo.getChild();
            sortByDistance(child);
            for (int i = 0; i < child.size(); i++) {
                XPPoiInfo xPPoiInfo2 = child.get(i);
                int category = xPPoiInfo2.getCategory();
                if (category > 1 && XPPoiCategory.isParking(category) && arrayList.size() < 3) {
                    arrayList.add(xPPoiInfo2);
                }
            }
            L.i(TAG, "addParkingFromDestinationSubPoi, sub poi size: " + arrayList.size());
            if (arrayList.size() < 1) {
                requestRecommendParking();
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                XPPoiInfo xPPoiInfo3 = (XPPoiInfo) it.next();
                if (isPoiInRecommendRange(xPPoiInfo3, this.mEndPoint) && !isSAPAPark(xPPoiInfo3)) {
                    this.mRecommendParkingList.add(xPPoiInfo3);
                }
            }
            L.i(TAG, "sub poi in nav location range size: " + this.mRecommendParkingList.size());
            if (CollectionUtils.isNotEmpty(this.mRecommendParkingList)) {
                this.mSubPoiParkingSearchIndex = 0;
                requestDestinationParkingDeepInfo(0);
                return;
            }
            return;
        }
        L.i(TAG, "addParkingFromDestinationSubPoi destination has no sub poi, start requestRecommendParking");
        requestRecommendParking();
    }

    private void addParkingFromDestinationAround(@NonNull List<XPPoiInfo> list) {
        sortByDistance(list);
        for (int i = 0; i < list.size(); i++) {
            XPPoiInfo xPPoiInfo = list.get(i);
            if (XPPoiCategory.isParking(xPPoiInfo.getCategory()) && this.mRecommendParkingList.size() < 3 && !isSAPAPark(xPPoiInfo)) {
                this.mRecommendParkingList.add(xPPoiInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStatus(int i) {
        L.Tag tag = TAG;
        L.i(tag, "update status to: " + i);
        this.mStatus = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRecommendParking(XPNaviInfo xPNaviInfo) {
        boolean z = false;
        if (CollectionUtils.isNotEmpty(this.mRecommendParkingList) && !this.mHasShowedRecommendParking) {
            if (Configuration.Dependency.AIASSISTANT_ENABLE && inAIRecommendParkingCheckRange(xPNaviInfo)) {
                z = matchAIRecommendCondition(xPNaviInfo);
                if (!z) {
                    return;
                }
                speechRecommendParkingWithAiMsg(ContextUtils.getContext());
            }
            showRecommendParkingPop(z);
            this.mHasShowedRecommendParking = true;
        }
    }

    public boolean isMatchAIRecommendCondition(XPNaviInfo xPNaviInfo) {
        if (Configuration.Dependency.AIASSISTANT_ENABLE && xPNaviInfo != null && inAIRecommendParkingCheckRange(xPNaviInfo)) {
            return matchAIRecommendCondition(xPNaviInfo);
        }
        return false;
    }

    public boolean isShowRecommendRark() {
        return CollectionUtils.isNotEmpty(this.mRecommendParkingList) && this.mHasShowedRecommendParking;
    }

    private boolean matchAIRecommendCondition(XPNaviInfo xPNaviInfo) {
        if (RootUtil.isTabletApp()) {
            return false;
        }
        SpeechClient instance = SpeechClient.instance();
        SpeechStateProxy speechState = instance != null ? instance.getSpeechState() : null;
        return (speechState == null || !speechState.isDMStarted()) && ((xPNaviInfo.mNaviInfoData == null || xPNaviInfo.mNaviInfoData.length <= 0) ? 0 : xPNaviInfo.mNaviInfoData[xPNaviInfo.mNaviInfoFlag].mSegmentRemainDist) >= 220;
    }

    private boolean isSAPAPark(XPPoiInfo xPPoiInfo) {
        return (xPPoiInfo == null || TextUtils.isEmpty(xPPoiInfo.getName()) || !xPPoiInfo.getName().contains(SAPA_PARK_PREFIX)) ? false : true;
    }

    private boolean ignoreShowIfReRoute() {
        if (isShowRecommendRark()) {
            TBTManager tBTManager = TBTManager.getInstance();
            if (NavCoreUtil.isSamePOI(this.mDestinationPoiInfo, tBTManager.getEndInfo(tBTManager.getCurrentNaviId())) && NavCoreUtil.isSameXPPosition(this.mEndPoint, tBTManager.getRouteLastPoint(tBTManager.getCurrentNaviId(), tBTManager.getCurrentRoutePathIndex()))) {
                L.i(TAG, "new destPoi & endinfo info is equal last destPoi & endinfo info, and recommend park has show, ignore");
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class RecommendParkingHandler extends Handler {
        public RecommendParkingHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i != 0) {
                if (i == 6) {
                    RecommendParkingHelper.this.lastMileSend2Phone();
                    return;
                } else if (i != 2) {
                    if (i != 3) {
                        if (i == 4 && RecommendParkingHelper.this.mStatus != 3) {
                            RecommendParkingHelper.this.doRecommendParking((XPNaviInfo) message.obj);
                            RecommendParkingHelper.this.updateStatus(2);
                            return;
                        }
                        return;
                    }
                    RecommendParkingHelper.this.startRecommendRequest();
                    return;
                }
            }
            RecommendParkingHelper.this.reset();
        }
    }
}
