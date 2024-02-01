package com.xiaopeng.montecarlo.scenes.restrictscene;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import com.autonavi.gbl.aosclient.model.GReStrictedAreaDataRes;
import com.autonavi.gbl.aosclient.model.GReStrictedAreaResponseParam;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.bridge.RestrictBridge;
import com.xiaopeng.montecarlo.bridge.SettingLicencePlateBridge;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPGReStrictedAreaDataRuleRes;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPGRestrictCity;
import com.xiaopeng.montecarlo.navcore.event.RouteAosEvent;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPRestrictionInfo;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.settingscene.SettingLicencePlatePresenter;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.RestrictPopView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes3.dex */
public class RestrictHelper implements RestrictPopView.IRestrictPopActionListener, RestrictPopView.IRestrictVbChangedListener {
    private static final L.Tag TAG = new L.Tag("RestrictHelper");
    private WeakReference<IRestrictEventCallback> mCallback;
    private Context mContext;
    private RestrictInfo mRestrictInfo;
    private RestrictPopView mRestrictPopView;
    private IRestrictView mRestrictView;
    public String mCityName = "";
    public String mCityCode = "";
    private short mType = 0;
    private long mRequestRef = -1;
    private XPGReStrictedAreaDataRuleRes mDataRule = null;
    private BaseScene mCurrentScene = null;

    /* loaded from: classes3.dex */
    public interface IRestrictEventCallback {
        @MainThread
        void onResponseError(long j, int i);

        @MainThread
        boolean onShowRestrictGuide(short s);
    }

    /* loaded from: classes3.dex */
    public interface IRestrictView {
        RelativeLayout.LayoutParams getPopPos();

        BaseScene getSceneForRestrict();

        void hideRestrictedPop();

        void onRestrictViewVisibilityChanged(int i);

        void requestRestrictReroute();

        void showRestrictedPop(int i, String str, String str2, ArrayList<XPGRestrictCity> arrayList, String str3, RestrictPopView.IRestrictPopActionListener iRestrictPopActionListener);
    }

    public static boolean isCheckHistory(int i) {
        return i == 1 || i == 2;
    }

    public boolean isNeedRequestRestrict(int i) {
        return i == 1 || i == 9 || i == 3 || i == 4;
    }

    public RestrictHelper(Context context, IRestrictView iRestrictView) {
        this.mRestrictView = null;
        this.mContext = context;
        this.mRestrictView = iRestrictView;
    }

    public static boolean getRestrictTipStatusByAdCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Map map = (Map) GsonUtil.fromJson(DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_RESTRICT_NAME, ""), new TypeToken<Map<String, Boolean>>() { // from class: com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.1
        }.getType());
        if (CollectionUtils.isEmpty(map) || map.get(str) == null) {
            return false;
        }
        return ((Boolean) map.get(str)).booleanValue();
    }

    public static Map<String, Boolean> getTipRestrictBoolean(ArrayList<XPGRestrictCity> arrayList) {
        HashMap hashMap = new HashMap();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) != null && !TextUtils.isEmpty(arrayList.get(size).mCityName)) {
                hashMap.put(arrayList.get(size).mCityName, Boolean.valueOf(getRestrictTipStatusByAdCode(String.valueOf(arrayList.get(size).mCityCode))));
            }
        }
        return hashMap;
    }

    public static Map<String, String> getCityMap(ArrayList<XPGRestrictCity> arrayList) {
        HashMap hashMap = new HashMap();
        Iterator<XPGRestrictCity> it = arrayList.iterator();
        while (it.hasNext()) {
            XPGRestrictCity next = it.next();
            if (next != null && !TextUtils.isEmpty(next.mCityName)) {
                hashMap.put(next.mCityName, String.valueOf(next.mCityCode));
            }
        }
        return hashMap;
    }

    public void init() {
        EventBus.getDefault().register(this);
        this.mCurrentScene = this.mRestrictView.getSceneForRestrict();
    }

    public void unInit() {
        EventBus.getDefault().unregister(this);
        hideRestrictedPop();
        abortRequest();
        this.mCallback = null;
    }

    @Override // com.xiaopeng.montecarlo.views.RestrictPopView.IRestrictPopActionListener
    public void setPlateLicense() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(SystemConst.IS_FROM_RESTRICT_TYPE_KEY, true);
        this.mCurrentScene.startScene(new SettingLicencePlateBridge().setStartMode(1).setBundle(bundle), 2);
    }

    @Override // com.xiaopeng.montecarlo.views.RestrictPopView.IRestrictPopActionListener
    public void openRestrictSwitch() {
        SettingWrapper.openPlateSwitch();
        this.mRestrictView.requestRestrictReroute();
    }

    @Override // com.xiaopeng.montecarlo.views.RestrictPopView.IRestrictPopActionListener
    public void showDetailRestrict() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(RestrictUtils.KEY_RESTRICT, getRules());
        this.mCurrentScene.startScene(new RestrictBridge().enableSingleMode().setBundle(bundle), 0);
    }

    @Override // com.xiaopeng.montecarlo.views.RestrictPopView.IRestrictVbChangedListener
    public void onRestrictViewVisibilityChanged(int i) {
        IRestrictView iRestrictView = this.mRestrictView;
        if (iRestrictView != null) {
            iRestrictView.onRestrictViewVisibilityChanged(i);
        }
    }

    public void requestRestrict(IRestrictEventCallback iRestrictEventCallback, long j) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "requestRestrict from " + this.mCurrentScene);
        }
        this.mCallback = new WeakReference<>(iRestrictEventCallback);
        RestrictManager.getInstance().requestRestrictedRule(j);
    }

    public int abortRequest() {
        return RestrictManager.getInstance().abortRequest(this.mRequestRef);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onAosEvent(RouteAosEvent routeAosEvent) {
        if (this.mCurrentScene.isSceneLegal()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, " onAosEvent from " + this.mCurrentScene);
            }
            if (routeAosEvent.getParam() instanceof GReStrictedAreaResponseParam) {
                handleRestrictEvent((GReStrictedAreaResponseParam) routeAosEvent.getParam());
            }
        }
    }

    private void callbackWhenNodata(final short s) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, " callbackWhenNodata " + this.mCurrentScene);
        }
        WeakReference<IRestrictEventCallback> weakReference = this.mCallback;
        if (weakReference == null) {
            return;
        }
        if (weakReference.get() != null && this.mCurrentScene.isSceneLegal()) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    IRestrictEventCallback iRestrictEventCallback;
                    if (RestrictHelper.this.mCallback == null || (iRestrictEventCallback = (IRestrictEventCallback) RestrictHelper.this.mCallback.get()) == null) {
                        return;
                    }
                    iRestrictEventCallback.onShowRestrictGuide(s);
                }
            });
        }
        if (s == 0) {
            handleRestrictPopNotShow();
        }
    }

    private synchronized void handleRestrictEvent(GReStrictedAreaResponseParam gReStrictedAreaResponseParam) {
        this.mRequestRef = gReStrictedAreaResponseParam.mReqHandle;
        final int i = gReStrictedAreaResponseParam.mNetErrorCode;
        if (this.mRequestRef < 0 && this.mCurrentScene != null && this.mCurrentScene.isSceneLegal()) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    IRestrictEventCallback iRestrictEventCallback;
                    if (RestrictHelper.this.mCallback == null || (iRestrictEventCallback = (IRestrictEventCallback) RestrictHelper.this.mCallback.get()) == null) {
                        return;
                    }
                    iRestrictEventCallback.onResponseError(RestrictHelper.this.mRequestRef, i);
                }
            });
            return;
        }
        GReStrictedAreaDataRes gReStrictedAreaDataRes = gReStrictedAreaResponseParam.data;
        if (gReStrictedAreaDataRes == null) {
            this.mType = (short) 0;
            callbackWhenNodata(this.mType);
            return;
        }
        this.mDataRule = new XPGReStrictedAreaDataRuleRes(gReStrictedAreaDataRes.mDataRule);
        if (this.mDataRule != null && !CollectionUtils.isEmpty(this.mDataRule.mCities)) {
            XPGRestrictCity xPGRestrictCity = this.mDataRule.mCities.get(this.mDataRule.mCities.size() - 1);
            if (xPGRestrictCity == null) {
                this.mType = (short) 0;
                callbackWhenNodata(this.mType);
                return;
            }
            final String str = xPGRestrictCity.mCityName;
            final String valueOf = String.valueOf(xPGRestrictCity.mCityCode);
            RestrictManager restrictManager = RestrictManager.getInstance();
            final String str2 = "";
            if (restrictManager.isSetLicencePlate()) {
                if (restrictManager.isOpenVehicleRestriction()) {
                    XPRestrictionInfo restrictInfoByCurrentPath = restrictManager.getRestrictInfoByCurrentPath();
                    if (restrictInfoByCurrentPath == null) {
                        if (L.ENABLE) {
                            L.d(TAG, " mRestrictInfo = null");
                        }
                        this.mType = (short) 0;
                        callbackWhenNodata(this.mType);
                        return;
                    }
                    str2 = restrictInfoByCurrentPath.mTitle;
                    if (L.ENABLE) {
                        StringBuilder sb = new StringBuilder("");
                        sb.append("[title=");
                        sb.append(restrictInfoByCurrentPath.mTitle);
                        sb.append(",");
                        sb.append("desc=");
                        sb.append(restrictInfoByCurrentPath.mDesc);
                        sb.append(",");
                        sb.append("tips=");
                        sb.append(restrictInfoByCurrentPath.mTips);
                        sb.append(",");
                        sb.append("type=");
                        sb.append((int) restrictInfoByCurrentPath.mType);
                        sb.append(",");
                        sb.append("titletype=");
                        sb.append(restrictInfoByCurrentPath.mTitleType);
                        sb.append(",");
                        if (CollectionUtils.isNotEmpty(restrictInfoByCurrentPath.mRuleIDs)) {
                            sb.append("rulenum=");
                            sb.append(restrictInfoByCurrentPath.mRuleIDs.size());
                        }
                        sb.append("]");
                        L.d(TAG, sb.toString());
                    }
                    if (restrictManager.isRouteIsRestrict(restrictInfoByCurrentPath.mTitleType)) {
                        this.mType = (short) 3;
                    } else {
                        this.mType = (short) 4;
                    }
                } else {
                    this.mType = (short) 2;
                }
            } else {
                this.mType = (short) 1;
            }
            if (isTipRestrict(this.mType, this.mDataRule.mCities)) {
                this.mType = (short) 0;
            }
            if (this.mRestrictView != null && this.mCurrentScene != null && this.mCurrentScene.isSceneLegal()) {
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.4
                    @Override // java.lang.Runnable
                    public void run() {
                        IRestrictEventCallback iRestrictEventCallback;
                        if (RestrictHelper.this.mCallback == null || (iRestrictEventCallback = (IRestrictEventCallback) RestrictHelper.this.mCallback.get()) == null || !iRestrictEventCallback.onShowRestrictGuide(RestrictHelper.this.mType)) {
                            return;
                        }
                        RestrictHelper.this.mRestrictView.showRestrictedPop(RestrictHelper.this.mType, str, valueOf, RestrictHelper.this.mDataRule.mCities, str2, RestrictHelper.this);
                    }
                });
            }
            return;
        }
        this.mType = (short) 0;
        callbackWhenNodata(this.mType);
    }

    private void handleRestrictPopNotShow() {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.5
            @Override // java.lang.Runnable
            public void run() {
                if (RestrictHelper.this.mRestrictView == null) {
                    return;
                }
                RestrictHelper.this.mRestrictView.hideRestrictedPop();
            }
        });
    }

    public void saveCityRestrict(String str) {
        L.Tag tag = TAG;
        L.i(tag, "save cityCode: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map map = (Map) GsonUtil.fromJson(DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_RESTRICT_NAME, ""), new TypeToken<Map<String, Boolean>>() { // from class: com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.6
        }.getType());
        if (map == null) {
            map = new HashMap();
        }
        map.put(str, true);
        String json = GsonUtil.toJson(map);
        if (TextUtils.isEmpty(json)) {
            return;
        }
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_RESTRICT_NAME, json);
    }

    public boolean hasTipRestrict(ArrayList<XPGRestrictCity> arrayList) {
        if (CollectionUtils.isEmpty(arrayList)) {
            return false;
        }
        Map<String, Boolean> tipRestrictBoolean = getTipRestrictBoolean(arrayList);
        if (CollectionUtils.isEmpty(tipRestrictBoolean)) {
            return false;
        }
        for (Map.Entry<String, Boolean> entry : tipRestrictBoolean.entrySet()) {
            if (entry != null && !entry.getValue().booleanValue()) {
                this.mCityName = entry.getKey();
                if (!CollectionUtils.isEmpty(getCityMap(arrayList)) && !TextUtils.isEmpty(this.mCityName)) {
                    this.mCityCode = getCityMap(arrayList).get(this.mCityName);
                }
                return entry.getValue().booleanValue();
            }
        }
        return true;
    }

    public boolean isTipRestrict(int i, ArrayList<XPGRestrictCity> arrayList) {
        return isCheckHistory(i) && hasTipRestrict(arrayList);
    }

    public XPGReStrictedAreaDataRuleRes getRules() {
        return this.mDataRule;
    }

    public short getType() {
        return this.mType;
    }

    public RelativeLayout.LayoutParams getDefaultPopPos() {
        RestrictPopView restrictPopView = this.mRestrictPopView;
        if (restrictPopView == null || this.mContext == null) {
            return null;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) restrictPopView.getLayoutParams();
        layoutParams.addRule(14, -1);
        return layoutParams;
    }

    public RelativeLayout.LayoutParams getPopLayoutParams() {
        RestrictPopView restrictPopView = this.mRestrictPopView;
        if (restrictPopView == null || this.mContext == null) {
            return null;
        }
        return (RelativeLayout.LayoutParams) restrictPopView.getLayoutParams();
    }

    public void updatePopLayout() {
        RestrictPopView restrictPopView = this.mRestrictPopView;
        if (restrictPopView == null || this.mContext == null || !restrictPopView.isShown()) {
            return;
        }
        this.mRestrictPopView.setLayoutParams(this.mRestrictView.getPopPos());
    }

    public void onBackResult(int i, Bundle bundle) {
        if (i != 2 || bundle == null || TextUtils.isEmpty(bundle.getString(SettingLicencePlatePresenter.KEY_SAVE_LICENCE_PLATE))) {
            return;
        }
        this.mRestrictView.hideRestrictedPop();
        this.mRestrictView.requestRestrictReroute();
    }

    public void setRestrictInfoForUncomingPop(int i, String str, String str2, ArrayList<XPGRestrictCity> arrayList, String str3, RestrictPopView.IRestrictPopActionListener iRestrictPopActionListener, boolean z) {
        if (this.mRestrictInfo == null) {
            this.mRestrictInfo = new RestrictInfo();
        }
        this.mRestrictInfo.update(i, str, str2, arrayList, str3, iRestrictPopActionListener, z);
    }

    public void showRestrictedPop(int i, String str, String str2, ArrayList<XPGRestrictCity> arrayList, String str3, RestrictPopView.IRestrictPopActionListener iRestrictPopActionListener, boolean z) {
        RestrictPopView restrictPopView;
        RestrictPopView restrictPopView2;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, " showRestrictedPop from " + this.mCurrentScene + ", mode : " + i + ", cityName : " + str + ", cityCode : " + str2 + ", title : " + str3 + ", mCityName : " + this.mCityName + ", mCityCode : " + this.mCityCode);
        }
        this.mRestrictInfo = null;
        if (i <= 0 || i > 4 || !this.mCurrentScene.isSceneLegal()) {
            return;
        }
        boolean z2 = false;
        try {
            try {
                if (this.mRestrictPopView == null) {
                    z2 = true;
                    this.mRestrictPopView = new RestrictPopView(this.mContext, null);
                    this.mRestrictPopView.setVbChangeListener(this);
                    RelativeLayout relativeLayout = (RelativeLayout) this.mCurrentScene.getSceneContentView();
                    if (relativeLayout == null) {
                        RestrictPopView restrictPopView3 = this.mRestrictPopView;
                        if (restrictPopView3 != null) {
                            VoiceFullScenesUtil.updateScene(this.mCurrentScene, restrictPopView3);
                            return;
                        }
                        return;
                    }
                    relativeLayout.addView(this.mRestrictPopView);
                }
                this.mRestrictPopView.setSceneMode(this.mCurrentScene.getMode());
                this.mRestrictPopView.setUseBgImage(z);
                RestrictPopView restrictPopView4 = this.mRestrictPopView;
                if (this.mCityName != null && !this.mCityName.isEmpty()) {
                    str = this.mCityName;
                }
                restrictPopView4.setData(i, str3, str);
                this.mRestrictPopView.setActionListener(iRestrictPopActionListener);
                this.mRestrictPopView.setGravity(z ? 16 : 48);
                this.mRestrictPopView.setLayoutParams(this.mRestrictView.getPopPos());
                this.mRestrictPopView.setVuiLabel(MqttTopic.MULTI_LEVEL_WILDCARD);
                this.mRestrictPopView.show();
                if (isCheckHistory(i)) {
                    if (this.mCityCode != null && !this.mCityCode.isEmpty()) {
                        str2 = this.mCityCode;
                    }
                    saveCityRestrict(str2);
                }
                if (!z2 || (restrictPopView2 = this.mRestrictPopView) == null) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (!z2 || (restrictPopView2 = this.mRestrictPopView) == null) {
                    return;
                }
            }
            VoiceFullScenesUtil.updateScene(this.mCurrentScene, restrictPopView2);
        } catch (Throwable th) {
            if (z2 && (restrictPopView = this.mRestrictPopView) != null) {
                VoiceFullScenesUtil.updateScene(this.mCurrentScene, restrictPopView);
            }
            throw th;
        }
    }

    public boolean restoreShowRestrictPop() {
        RestrictInfo restrictInfo = this.mRestrictInfo;
        if (restrictInfo != null) {
            showRestrictedPop(restrictInfo.mMode, this.mRestrictInfo.mCityName, this.mRestrictInfo.mCityCode, this.mRestrictInfo.mCities, this.mRestrictInfo.mTitle, this.mRestrictInfo.mAction, this.mRestrictInfo.mIsUseBgImg);
            return true;
        }
        RestrictPopView restrictPopView = this.mRestrictPopView;
        if (restrictPopView != null) {
            restrictPopView.setLayoutParams(this.mRestrictView.getPopPos());
            return this.mRestrictPopView.restoreShow();
        }
        return false;
    }

    public boolean isRestrictedPopShow() {
        RestrictPopView restrictPopView = this.mRestrictPopView;
        return restrictPopView != null && restrictPopView.getVisibility() == 0;
    }

    public void hideRestrictedPop() {
        RestrictPopView restrictPopView = this.mRestrictPopView;
        if (restrictPopView != null) {
            restrictPopView.hide(false);
        }
    }

    public void hideRestrictedPop(boolean z) {
        RestrictPopView restrictPopView = this.mRestrictPopView;
        if (restrictPopView != null) {
            restrictPopView.hide(false, z);
        }
    }

    public boolean isRestrictVisible() {
        RestrictPopView restrictPopView = this.mRestrictPopView;
        return restrictPopView != null && restrictPopView.getVisibility() == 0;
    }

    public int getRestrictViewBottom() {
        RestrictPopView restrictPopView = this.mRestrictPopView;
        if (restrictPopView == null || restrictPopView.getVisibility() != 0) {
            return 0;
        }
        return Utils.getViewBottomInWindow(this.mRestrictPopView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class RestrictInfo {
        public RestrictPopView.IRestrictPopActionListener mAction;
        public ArrayList<XPGRestrictCity> mCities;
        public String mCityCode;
        public String mCityName;
        public boolean mIsUseBgImg;
        public int mMode;
        public String mTitle;

        RestrictInfo() {
        }

        public void update(int i, String str, String str2, ArrayList<XPGRestrictCity> arrayList, String str3, RestrictPopView.IRestrictPopActionListener iRestrictPopActionListener, boolean z) {
            this.mMode = i;
            this.mCityName = str;
            this.mCities = arrayList;
            this.mTitle = str3;
            this.mAction = iRestrictPopActionListener;
            this.mIsUseBgImg = z;
        }
    }
}
