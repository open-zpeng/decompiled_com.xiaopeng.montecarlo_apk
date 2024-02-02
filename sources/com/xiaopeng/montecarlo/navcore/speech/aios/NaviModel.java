package com.xiaopeng.montecarlo.navcore.speech.aios;

import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.speech.SpeechClient;
import com.xiaopeng.speech.overall.SpeechResult;
import com.xiaopeng.speech.protocol.SpeechUtils;
import com.xiaopeng.speech.protocol.bean.recommend.RecommendBean;
import com.xiaopeng.speech.protocol.node.avatar.AvatarListener;
import com.xiaopeng.speech.protocol.node.avatar.AvatarNode;
import com.xiaopeng.speech.protocol.node.context.ContextNode;
import com.xiaopeng.speech.protocol.node.dialog.DialogNode;
import com.xiaopeng.speech.protocol.node.navi.NaviNode;
import com.xiaopeng.speech.protocol.node.navi.bean.AddressBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import com.xiaopeng.speech.protocol.node.navi.bean.RouteSelectBean;
import com.xiaopeng.speech.protocol.node.navi.bean.SelectRouteBean;
import com.xiaopeng.speech.protocol.query.navi.MapQuery;
import java.util.List;
/* loaded from: classes2.dex */
public class NaviModel {
    public static final String POI_SOURCE_AICLOUD_AMAP = "AICloud_AMAP";
    public static final String POI_SOURCE_BLSDK = "BLSDK";
    private static final L.Tag TAG = new L.Tag("NaviModel");
    private static final NaviModel sNaviModel = new NaviModel();
    private static final String[] sEndFilters = {"command://navi.control.start", "command://navi.control.waypoint.start", "command://navi.route.select", "command://navi.address.pending.route"};
    private NaviNode mNaviNode = new NaviNode();
    private DialogListenerImpl mUserSpeechListener = new DialogListenerImpl(this);
    private ContextListenerImpl mContextListener = new ContextListenerImpl(this);
    private MapQueryCallerImpl mNaviInfoListener = new MapQueryCallerImpl(this);
    private NaviListenerImpl mNaviListener = new NaviListenerImpl(this);
    private AvatarListener mSpeechDialogListener = new AvatarListenerImpl(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public NaviNode getNaviNode() {
        return this.mNaviNode;
    }

    @NonNull
    public static NaviModel getInstance() {
        return sNaviModel;
    }

    public void subscribe() {
        this.mNaviListener.addListener();
        SpeechUtils.subscribe(DialogNode.class, this.mUserSpeechListener);
        SpeechUtils.subscribe(ContextNode.class, this.mContextListener);
        if (!CarFeatureManager.INSTANCE.isApirouterGlobalVoice()) {
            SpeechUtils.subscribe(NaviNode.class, this.mNaviListener);
            SpeechUtils.subscribe(MapQuery.class, this.mNaviInfoListener);
            SpeechUtils.subscribe(AvatarNode.class, this.mSpeechDialogListener);
        }
        VoiceFusionUtil.getInstance().registerSystemUIValueContentObserver();
    }

    public void unsubscribe() {
        this.mNaviListener.removeListener();
        SpeechUtils.unsubscribe(DialogNode.class, this.mUserSpeechListener);
        SpeechUtils.unsubscribe(ContextNode.class, this.mContextListener);
        if (!CarFeatureManager.INSTANCE.isApirouterGlobalVoice()) {
            SpeechUtils.unsubscribe(NaviNode.class, this.mNaviListener);
            SpeechUtils.unsubscribe(MapQuery.class);
            SpeechUtils.unsubscribe(AvatarNode.class, this.mSpeechDialogListener);
        }
        VoiceFusionUtil.getInstance().stopFocusChangeTimer();
        VoiceFusionUtil.getInstance().unregisterSystemUIValueContentObserver();
    }

    public void syncRoute(List<RouteSelectBean> list, String str, boolean z) {
        this.mContextListener.syncRoute(list, str, z);
    }

    public boolean isShowingDialog() {
        return this.mUserSpeechListener.isShowSpeechDialog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canHandleVoiceCommand() {
        return canHandleVoiceCommand(null, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canHandleVoiceCommand(String str, boolean z) {
        if (z && !VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            L.Tag tag = TAG;
            L.i(tag, "isVoiceFusionEnable=false, isNeedCheckCarType=" + z + ",carType:" + CarServiceManager.getInstance().getCarType());
            return false;
        }
        if (-1 != SpeechClient.instance().getSpeechState().getOOBEStatus()) {
            L.Tag tag2 = TAG;
            L.i(tag2, "getOOBEStatus=" + SpeechClient.instance().getSpeechState().getOOBEStatus());
            return false;
        } else if (TextUtils.isEmpty(str) || !RootUtil.getPackageName().equals(str)) {
            return true;
        } else {
            L.Tag tag3 = TAG;
            L.i(tag3, "source=" + str + ", RootUtil.getPackageName()=" + RootUtil.getPackageName());
            return false;
        }
    }

    public void stopSpeechDialog() {
        this.mContextListener.stopSpeechDialog();
    }

    public void startSpeechDialog() {
        this.mContextListener.startSpeechDialog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDialogEndFilter(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = sEndFilters;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (strArr[i].equals(str)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            L.i(TAG, "isDialogEndFilter event:" + str);
        }
        return z;
    }

    public void postAddressGetResult(boolean z, boolean z2, PoiBean poiBean) {
        this.mNaviInfoListener.postAddressGetResult(z, z2, poiBean);
    }

    public void onSelectRouteCount(@Nullable SelectRouteBean selectRouteBean) {
        this.mContextListener.onSelectRouteCount(selectRouteBean);
    }

    public void onControlClose(String str, String str2) {
        this.mNaviNode.onControlClose(str, str2);
    }

    public void onMapZoomIn(String str, String str2) {
        this.mNaviNode.onMapZoomIn(str, str2);
    }

    public void onMapZoomOut(String str, String str2) {
        this.mNaviNode.onMapZoomOut(str, str2);
    }

    public void onOpenTraffic(String str, String str2) {
        this.mNaviNode.onOpenTraffic(str, str2);
    }

    public void onCloseTraffic(String str, String str2) {
        this.mNaviNode.onCloseTraffic(str, str2);
    }

    public void onControlOverviewOpen(String str, String str2) {
        this.mNaviNode.onControlOverviewOpen(str, str2);
    }

    public void onControlOverviewClose(String str, String str2) {
        this.mNaviNode.onControlOverviewClose(str, str2);
    }

    public void onMapOverview(String str, String str2) {
        this.mNaviNode.onMapOverview(str, str2);
    }

    public void onControlFavoriteOpen(String str, String str2) {
        this.mNaviNode.onControlFavoriteOpen(str, str2);
    }

    public void onControlFavoriteClose(String str, String str2) {
        this.mNaviNode.onControlFavoriteClose(str, str2);
    }

    public void onControlSettingsOpen(String str, String str2) {
        this.mNaviNode.onControlSettingsOpen(str, str2);
    }

    public void onControlChargeOpen(String str, String str2) {
        this.mNaviNode.onControlChargeOpen(str, str2);
    }

    public void onControlChargeClose(String str, String str2) {
        this.mNaviNode.onControlChargeClose(str, str2);
    }

    public void onDriveAvoidCongestion(String str, String str2) {
        this.mNaviNode.onDriveAvoidCongestion(str, str2);
    }

    public void onDriveAvoidCongestionOff(String str, String str2) {
        this.mNaviNode.onDriveAvoidCongestionOff(str, str2);
    }

    public void onDriveAvoidCharge(String str, String str2) {
        this.mNaviNode.onDriveAvoidCharge(str, str2);
    }

    public void onDriveAvoidChargeOff(String str, String str2) {
        this.mNaviNode.onDriveAvoidChargeOff(str, str2);
    }

    public void onDriveHighwayFirstOff(String str, String str2) {
        this.mNaviNode.onDriveHighwayFirstOff(str, str2);
    }

    public void onDriveAvoidControls(String str, String str2) {
        this.mNaviNode.onDriveAvoidControls(str, str2);
    }

    public void onDriveAvoidControlsOff(String str, String str2) {
        this.mNaviNode.onDriveAvoidControlsOff(str, str2);
    }

    public void onDriveRadarRoute(String str, String str2) {
        this.mNaviNode.onDriveRadarRoute(str, str2);
    }

    public void onDriveRadarRouteOff(String str, String str2) {
        this.mNaviNode.onDriveRadarRouteOff(str, str2);
    }

    public void onControlSpeechSuperSimple(String str, String str2) {
        this.mNaviNode.onControlSpeechSuperSimple(str, str2);
    }

    public void onControlSpeechGeneral(String str, String str2) {
        this.mNaviNode.onControlSpeechGeneral(str, str2);
    }

    public void onControlSpeechEye(String str, String str2) {
        this.mNaviNode.onControlSpeechEye(str, str2);
    }

    public void onControlSpeechEyeOff(String str, String str2) {
        this.mNaviNode.onControlSpeechEyeOff(str, str2);
    }

    public void onControlSmartScale(String str, String str2) {
        this.mNaviNode.onControlSmartScale(str, str2);
    }

    public void onControlSmartScaleOff(String str, String str2) {
        this.mNaviNode.onControlSmartScaleOff(str, str2);
    }

    public void onControlSecurityRemind(String str, String str2) {
        this.mNaviNode.onControlSecurityRemind(str, str2);
    }

    public void onControlSecurityRemindOff(String str, String str2) {
        this.mNaviNode.onControlSecurityRemindOff(str, str2);
    }

    public void onControlRoadAhead(String str, String str2) {
        this.mNaviNode.onControlRoadAhead(str, str2);
    }

    public void onControlRoadAheadOff(String str, String str2) {
        this.mNaviNode.onControlRoadAheadOff(str, str2);
    }

    public void onDriveHighwayNo(String str, String str2) {
        this.mNaviNode.onDriveHighwayNo(str, str2);
    }

    public void onDriveHighwayNoOff(String str, String str2) {
        this.mNaviNode.onDriveHighwayNoOff(str, str2);
    }

    public void onDriveHighwayFirst(String str, String str2) {
        this.mNaviNode.onDriveHighwayFirst(str, str2);
    }

    public void onNavigatingGet(String str, String str2) {
        this.mNaviNode.onNavigatingGet(str, str2);
    }

    public void onMapEnterFindPath(String str, String str2) {
        this.mNaviNode.onMapEnterFindPath(str, str2);
    }

    public void onMapExitFindPath(String str, String str2) {
        this.mNaviNode.onMapExitFindPath(str, str2);
    }

    public void onSearchClose(String str, String str2) {
        this.mNaviNode.onSearchClose(str, str2);
    }

    public void onMainRoad(String str, String str2) {
        this.mNaviNode.onMainRoad(str, str2);
    }

    public void onSideRoad(String str, String str2) {
        this.mNaviNode.onSideRoad(str, str2);
    }

    public void onMapZoominMax(String str, String str2) {
        this.mNaviNode.onMapZoominMax(str, str2);
    }

    public void onMapZoomoutMin(String str, String str2) {
        this.mNaviNode.onMapZoomoutMin(str, str2);
    }

    public void onAddressSet(String str, String str2) {
        this.mNaviNode.onAddressSet(str, str2);
    }

    public void onControlSpeechSimple(String str, String str2) {
        this.mNaviNode.onControlSpeechSimple(str, str2);
    }

    public void onControlSpeechDetail(String str, String str2) {
        this.mNaviNode.onControlSpeechDetail(str, str2);
    }

    public void onControlDisPlayNorth(String str, String str2) {
        this.mNaviNode.onControlDisPlayNorth(str, str2);
    }

    public void onControlDisPlayCar(String str, String str2) {
        this.mNaviNode.onControlDisPlayCar(str, str2);
    }

    public void onControlDisplay3D(String str, String str2) {
        this.mNaviNode.onControlDisplay3D(str, str2);
    }

    public void onControlVolOn(String str, String str2) {
        this.mNaviNode.onControlVolOn(str, str2);
    }

    public void onControlVolOff(String str, String str2) {
        this.mNaviNode.onControlVolOff(str, str2);
    }

    public void onConfirmOk(String str, String str2) {
        this.mNaviNode.onConfirmOk(str, str2);
    }

    public void onConfirmCancel(String str, String str2) {
        this.mNaviNode.onConfirmCancel(str, str2);
    }

    public void onControlOpenSmallMap(String str, String str2) {
        this.mNaviNode.onControlOpenSmallMap(str, str2);
    }

    public void onControlCloseSmallMap(String str, String str2) {
        this.mNaviNode.onControlCloseSmallMap(str, str2);
    }

    public void onControlOpenRibbonMap(String str, String str2) {
        this.mNaviNode.onControlOpenRibbonMap(str, str2);
    }

    public void onControlCloseRibbonMap(String str, String str2) {
        this.mNaviNode.onControlCloseRibbonMap(str, str2);
    }

    public void onControlHistory(String str, String str2) {
        this.mNaviNode.onControlHistory(str, str2);
    }

    public void onGetSettingsInfo(String str, String str2) {
        this.mNaviNode.onGetSettingsInfo(str, str2);
    }

    public void isCruise(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Boolean.valueOf(this.mNaviInfoListener.isCruise())).toString()).build());
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "remote exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void isExplorePath(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Boolean.valueOf(this.mNaviInfoListener.isExplorePath())).toString()).build());
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "remote exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void isNavigation(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Boolean.valueOf(this.mNaviInfoListener.isNavigation())).toString()).build());
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "remote exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void isCalculatePath(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Boolean.valueOf(this.mNaviInfoListener.isCalculatePath())).toString()).build());
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "remote exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void getFavoriteOpenStatus(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Integer.valueOf(this.mNaviInfoListener.getFavoriteOpenStatus())).toString()).build());
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "remote exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void getOpenControlStatus(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Integer.valueOf(this.mNaviInfoListener.getOpenControlStatus())).toString()).build());
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "remote exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void getSwitchMainRoadStatus(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Integer.valueOf(this.mNaviInfoListener.getSwitchMainRoadStatus())).toString()).build());
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "remote exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void getSwitchSideRoadStatus(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Integer.valueOf(this.mNaviInfoListener.getSwitchSideRoadStatus())).toString()).build());
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "remote exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void getCommonAddress(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, this.mNaviInfoListener.getCommonAddress((AddressBean) GsonUtil.fromJson(str2, (Class<Object>) AddressBean.class))).toString()).build());
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "remote exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void getNavigationInfo(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, this.mNaviInfoListener.getNavigationInfo()).toString()).build());
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "remote exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void isZoominMax(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Boolean.valueOf(this.mNaviInfoListener.isZoominMax())).toString()).build());
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "remote exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void isZoomoutMin(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Boolean.valueOf(this.mNaviInfoListener.isZoomoutMin())).toString()).build());
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "remote exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void onPoiSearch(String str, String str2) {
        this.mNaviNode.onPoiSearch(str, str2);
    }

    public void onNearbySearch(String str, String str2) {
        this.mNaviNode.onNearbySearch(str, str2);
    }

    public void onAddressGet(String str, String str2) {
        this.mNaviNode.onAddressGet(str, str2);
    }

    public void onControlStart(String str, String str2) {
        this.mNaviNode.onControlStart(str, str2);
    }

    public void onRouteNearbySearch(String str, String str2) {
        this.mNaviNode.onRouteNearbySearch(str, str2);
    }

    public void onParkingSelect(String str, String str2) {
        this.mNaviNode.onParkingSelect(str, str2);
    }

    public void onRouteSelect(String str, String str2) {
        this.mNaviNode.onRouteSelect(str, str2);
    }

    public void onSelectParkingCount(String str, String str2) {
        this.mNaviNode.onSelectParkingCount(str, str2);
    }

    public void onSelectRouteCount(String str, String str2) {
        this.mNaviNode.onSelectRouteCount(str, str2);
    }

    public void onWaypointSearch(String str, String str2) {
        this.mNaviNode.onWaypointSearch(str, str2);
    }

    public void onControlWaypointStart(String str, String str2) {
        this.mNaviNode.onControlWaypointStart(str, str2);
    }

    public void onAddressPendingRoute(String str, String str2) {
        this.mNaviNode.onAddressPendingRoute(str, str2);
    }

    public void onControlParkRecommendOn(String str, String str2) {
        this.mNaviNode.onControlParkRecommendOn(str, str2);
    }

    public void onControlParkRecommendOff(String str, String str2) {
        this.mNaviNode.onControlParkRecommendOff(str, str2);
    }

    public void onRouteSelect(SelectRouteBean selectRouteBean) {
        this.mNaviListener.onRouteSelect(selectRouteBean);
    }

    public void onSetScaleLevel(String str, String str2) {
        L.Tag tag = TAG;
        L.i(tag, "onSetScaleLevel, event = " + str + ", data = " + str2);
        this.mNaviNode.onSetScaleLevel(str, str2);
    }

    public void getCurrentScaleLevel(String str, String str2, String str3) {
        L.Tag tag = TAG;
        L.i(tag, "getCurrentScaleLvel, event = " + str + ", data = " + str2 + ", callback = " + str3);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Integer.valueOf(this.mNaviInfoListener.getCurrentScaleLevel())).toString()).build());
        } catch (RemoteException e) {
            L.Tag tag2 = TAG;
            L.e(tag2, "remote exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void isLaneMode(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Boolean.valueOf(this.mNaviInfoListener.isSRMap())).toString()).build());
        } catch (RemoteException e) {
            L.Tag tag = TAG;
            L.e(tag, "remote exception : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
