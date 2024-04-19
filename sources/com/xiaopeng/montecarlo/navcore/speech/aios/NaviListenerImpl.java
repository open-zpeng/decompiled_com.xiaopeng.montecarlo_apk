package com.xiaopeng.montecarlo.navcore.speech.aios;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.speech.data.SpeechCacheData;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.navcore.speech.utils.NaviSpeechUtils;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.util.AudioManagerWrapper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.speech.SpeechClient;
import com.xiaopeng.speech.actorapi.ResultActor;
import com.xiaopeng.speech.protocol.SpeechUtils;
import com.xiaopeng.speech.protocol.node.navi.AbsNaviListener;
import com.xiaopeng.speech.protocol.node.navi.bean.AddressBean;
import com.xiaopeng.speech.protocol.node.navi.bean.NearbySearchBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PathBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiSearchBean;
import com.xiaopeng.speech.protocol.node.navi.bean.SelectParkingBean;
import com.xiaopeng.speech.protocol.node.navi.bean.SelectRouteBean;
import com.xiaopeng.speech.protocol.node.navi.bean.StartNaviBean;
import com.xiaopeng.speech.protocol.node.navi.bean.WaypointSearchBean;
/* loaded from: classes3.dex */
public class NaviListenerImpl extends AbsNaviListener {
    private static final L.Tag TAG = new L.Tag("NaviModel_ListenerImpl");
    private NaviModel mNaviModel;

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onConfirmCancel() {
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDriveAdvoidTrafficControl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NaviListenerImpl(NaviModel naviModel) {
        this.mNaviModel = naviModel;
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlClose() {
        L.i(TAG, "onControlClose");
        SpeechRequestFactory.getInstance().postRequest(1, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onMapZoomIn() {
        L.i(TAG, "onDataMapZoominTts");
        SpeechRequestFactory.getInstance().postRequest(41, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onMapZoomOut() {
        L.i(TAG, "onDataMapZoomoutTts");
        SpeechRequestFactory.getInstance().postRequest(42, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onOpenTraffic() {
        L.i(TAG, "onOpenTraffic");
        SpeechRequestFactory.getInstance().postRequest(4, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onCloseTraffic() {
        L.i(TAG, "onCloseTraffic");
        SpeechRequestFactory.getInstance().postRequest(5, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlOverviewOpen() {
        L.i(TAG, "onControlOverviewOpen");
        SpeechRequestFactory.getInstance().postRequest(6, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlOverviewClose() {
        L.i(TAG, "onControlOverviewClose");
        SpeechRequestFactory.getInstance().postRequest(7, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onMapOverview() {
        L.i(TAG, "onMapOverview");
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlFavoriteOpen() {
        L.i(TAG, "onControlFavoriteOpen");
        SpeechRequestFactory.getInstance().postRequest(9, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlFavoriteClose() {
        L.i(TAG, "onControlFavoriteClose");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_FAVORITE_CLOSE, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlSettingsOpen() {
        L.i(TAG, "onControlSettingsOpen");
        SpeechRequestFactory.getInstance().postRequest(10, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlChargeOpen() {
        L.i(TAG, "onControlChargeOpen");
        SpeechRequestFactory.getInstance().postRequest(11, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlChargeClose() {
        L.i(TAG, "onControlChargeClose");
        SpeechRequestFactory.getInstance().postRequest(12, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDriveAvoidCongestion() {
        L.i(TAG, "onDriveAvoidCongestion");
        SpeechRequestFactory.getInstance().postRequest(13, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDriveAvoidCongestionOff() {
        L.i(TAG, "onDriveAvoidCongestionOff");
        SpeechRequestFactory.getInstance().postRequest(20004, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDriveAvoidCharge() {
        L.i(TAG, "onDriveAvoidCharge");
        SpeechRequestFactory.getInstance().postRequest(14, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDriveAvoidChargeOff() {
        L.i(TAG, "onDriveAvoidChargeOff");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_AVOID_CHARGE_OFF, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDriveHighwayNo() {
        L.i(TAG, "onDriveHighwayNo");
        SpeechRequestFactory.getInstance().postRequest(15, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDriveHighwayNoOff() {
        L.i(TAG, "onDriveHighwayNoOff");
        SpeechRequestFactory.getInstance().postRequest(20005, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDriveHighwayFirst() {
        L.i(TAG, "onDriveHighwayFirst");
        SpeechRequestFactory.getInstance().postRequest(16, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDriveHighwayFirstOff() {
        L.i(TAG, "onDriveHighwayFirstOff");
        SpeechRequestFactory.getInstance().postRequest(20006, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDriveAvoidControls() {
        L.i(TAG, "onDriveAvoidControls");
        SpeechRequestFactory.getInstance().postRequest(20007, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDriveAvoidControlsOff() {
        L.i(TAG, "onDriveAvoidControlsOff");
        SpeechRequestFactory.getInstance().postRequest(20008, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDriveRadarRoute() {
        L.i(TAG, "onDriveRadarRoute");
        SpeechRequestFactory.getInstance().postRequest(20009, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDriveRadarRouteOff() {
        L.i(TAG, "onDriveRadarRouteOff");
        SpeechRequestFactory.getInstance().postRequest(20010, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public boolean onNavigatingGet() {
        boolean isNavigation = NaviSpeechUtils.isNavigation();
        L.Tag tag = TAG;
        L.i(tag, "onNavigatingGet " + isNavigation);
        SpeechUtils.replySupport("native://navi.navigating.get", isNavigation);
        SpeechStatProxy.getInstance().sendStatDataForSpeech(17, 2);
        return isNavigation;
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onPoiSearch(PoiSearchBean poiSearchBean) {
        L.Tag tag = TAG;
        L.i(tag, "onPoiSearch: " + poiSearchBean);
        SpeechRequestFactory.getInstance().postRequest(18, GsonUtil.toJson(poiSearchBean));
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onNearbySearch(NearbySearchBean nearbySearchBean) {
        L.Tag tag = TAG;
        L.i(tag, "onNearbySearch: " + nearbySearchBean);
        SpeechRequestFactory.getInstance().postRequest(19, GsonUtil.toJson(nearbySearchBean));
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onAddressGet(@NonNull AddressBean addressBean) {
        String addressType = addressBean.getAddressType();
        if (AddressBean.ADDRESS_FROM_NOT_CORRECTBIGDATA_.equals(addressBean.getFrom())) {
            SpeechCacheData.getInstance().feedbackToCloud(addressType);
        }
        L.Tag tag = TAG;
        L.i(tag, "onAddressGet AddressBean: " + addressType);
        if (AddressBean.ADDRESS_TYPE_HOME.equals(addressType)) {
            SpeechRequestFactory.getInstance().postRequest(47);
        }
        if (AddressBean.ADDRESS_TYPE_COMPANY.equals(addressType)) {
            SpeechRequestFactory.getInstance().postRequest(48);
        }
        SpeechStatProxy.getInstance().sendStatDataForSpeech(20, 2);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onAddressSet(@NonNull AddressBean addressBean, PoiBean poiBean) {
        boolean z = -1 != SpeechClient.instance().getSpeechState().getOOBEStatus();
        String addressType = addressBean.getAddressType();
        L.Tag tag = TAG;
        L.i(tag, "onAddressSet " + addressType + " " + poiBean);
        if (AddressBean.ADDRESS_TYPE_HOME.equals(addressType)) {
            SpeechRequestFactory.getInstance().postRequest(45, GsonUtil.toJson(poiBean), z);
        }
        if (AddressBean.ADDRESS_TYPE_COMPANY.equals(addressType)) {
            SpeechRequestFactory.getInstance().postRequest(46, GsonUtil.toJson(poiBean), z);
        }
        SpeechStatProxy.getInstance().sendStatDataForSpeech(22, 2);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlStart(@Nullable StartNaviBean startNaviBean) {
        L.Tag tag = TAG;
        L.i(tag, "onControlStart: " + startNaviBean);
        if (startNaviBean == null || startNaviBean.getPoiBean() == null) {
            SpeechRequestFactory.getInstance().postRequest(38, String.valueOf(NaviSpeechUtils.getPathIndex()), false);
            return;
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "onControlStart current status:" + TBTManager.getInstance().getCurrentStatus() + ",naviType:" + startNaviBean.getNaviType());
        if (1 == TBTManager.getInstance().getCurrentStatus() && startNaviBean.getNaviType() == 2) {
            L.i(TAG, "onControlStart exchange to explore not supported in navi");
            this.mNaviModel.stopSpeechDialog();
            TTSProxy.getInstance().speakByUrgent(ContextUtils.getString(R.string.speech_start_type_can_not_change_in_navi), null);
            VoiceFusionUtil.getInstance().onDialogEnd();
            return;
        }
        SpeechRequestFactory.getInstance().postRequest(22, GsonUtil.toJson(startNaviBean), false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlSpeechSuperSimple() {
        L.i(TAG, "onControlSpeechSuperSimple");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_SPEECH_SUPER_SIMPLE, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlWaypointStart(PathBean pathBean) {
        L.Tag tag = TAG;
        L.i(tag, "onControlWaypointStart: " + pathBean);
        L.Tag tag2 = TAG;
        L.i(tag2, "onControlWaypointStart current status:" + TBTManager.getInstance().getCurrentStatus() + ",naviType:" + pathBean.getNaviType());
        if (1 == TBTManager.getInstance().getCurrentStatus() && pathBean.getNaviType() == 2) {
            L.i(TAG, "onControlWaypointStart exchange to explore not supported in navi");
            this.mNaviModel.stopSpeechDialog();
            TTSProxy.getInstance().speakByUrgent(ContextUtils.getString(R.string.speech_start_type_can_not_change_in_navi), null);
            return;
        }
        SpeechRequestFactory.getInstance().postRequest(23, GsonUtil.toJson(pathBean), false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onMapEnterFindPath() {
        L.i(TAG, "onMapEnterFindPath");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_START_EXPLORE, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onMapExitFindPath() {
        L.i(TAG, "onMapExitFindPath");
        onControlClose();
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onSearchClose() {
        L.i(TAG, "onSearchClose");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_SEARCH_CLOSE, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onMainRoad() {
        L.i(TAG, "onMainRoad");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_SWITCH_TO_MAIN_ROAD, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onSideRoad() {
        L.i(TAG, "onMainRoad");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_SWITCH_TO_SLID_ROAD, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlSpeechSimple() {
        L.i(TAG, "onControlSpeechSimple");
        SpeechRequestFactory.getInstance().postRequest(24, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlSpeechGeneral() {
        L.i(TAG, "onControlSpeechGeneral");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_SPEECH_GENERAL, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlSpeechDetail() {
        L.i(TAG, "onControlSpeechDetail");
        SpeechRequestFactory.getInstance().postRequest(25, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlSpeechEye() {
        L.i(TAG, "onControlSpeechEye");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_SPEECH_EYE_ON, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlSpeechEyeOff() {
        L.i(TAG, "onControlSpeechEye");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_SPEECH_EYE_OFF, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlSmartScale() {
        L.i(TAG, "onControlSmartScale");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_SMART_SCALE_ON, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlSmartScaleOff() {
        L.i(TAG, "onControlSmartScaleOff");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_SMART_SCALE_OFF, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlParkRecommendOn() {
        L.i(TAG, "onControlParkRecommendOn");
        if (CarFeatureManager.INSTANCE.isRecommendParkSwitchEnable()) {
            SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_RECOMMEND_PARK_ON, false);
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlParkRecommendOff() {
        L.i(TAG, "onControlParkRecommendOff");
        if (CarFeatureManager.INSTANCE.isRecommendParkSwitchEnable()) {
            SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_RECOMMEND_PARK_OFF, false);
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlSecurityRemind() {
        L.i(TAG, "onControlSecurityRemind");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_SECURITY_REMIND_ON, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlSecurityRemindOff() {
        L.i(TAG, "onControlSecurityRemindOff");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_SECURITY_REMIND_OFF, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlRoadAhead() {
        L.i(TAG, "onControlRoadAhead");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_ROAD_AHEAD_ON, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlRoadAheadOff() {
        L.i(TAG, "onControlRoadAheadOff");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_ROAD_AHEAD_OFF, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlDisPlayNorth() {
        L.i(TAG, "onControlDisPlayNorth");
        SpeechRequestFactory.getInstance().postRequest(31, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlDisPlayCar() {
        L.i(TAG, "onControlDisPlayCar");
        SpeechRequestFactory.getInstance().postRequest(30, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlDisplay3D() {
        L.i(TAG, "onControlDisplay3D");
        SpeechRequestFactory.getInstance().postRequest(29, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlVolOn(boolean z, int i) {
        L.Tag tag = TAG;
        L.i(tag, "onControlVolOnpullUpNavi : " + z + " mode: " + i);
        if (AudioManagerWrapper.getInstance().isMuteNaviIfNeed(false, i)) {
            SpeechRequestFactory.getInstance().postRequest(32, !z);
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlVolOff(boolean z, int i) {
        L.Tag tag = TAG;
        L.i(tag, "onControlVolOffpullUpNavi : " + z + " mode: " + i);
        if (AudioManagerWrapper.getInstance().isMuteNaviIfNeed(true, i)) {
            SpeechRequestFactory.getInstance().postRequest(33, !z);
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDataControlDisplay3dTts() {
        L.i(TAG, "onDataControlDisplay3dTts");
        SpeechRequestFactory.getInstance().postRequest(29, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDataControlDisplayCarTts() {
        L.i(TAG, "onDataControlDisplayCarTts");
        SpeechRequestFactory.getInstance().postRequest(30, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onDataControlDisplayNorthTts() {
        L.i(TAG, "onDataControlDisplayNorthTts");
        SpeechRequestFactory.getInstance().postRequest(31, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onRouteNearbySearch(@NonNull NearbySearchBean nearbySearchBean) {
        String destination = nearbySearchBean.getDestination();
        String destinationType = nearbySearchBean.getDestinationType();
        if (TextUtils.isEmpty(destination)) {
            destination = destinationType;
        }
        if (destination != null) {
            SpeechRequestFactory.getInstance().postRequest(34, GsonUtil.toJson(nearbySearchBean));
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onConfirmOk() {
        L.i(TAG, "onConfirmOk");
        SpeechRequestFactory.getInstance().postRequest(36);
    }

    public void selectParking(String str) {
        L.Tag tag = TAG;
        L.i(tag, "selectParking:" + str);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onParkingSelect(@NonNull SelectParkingBean selectParkingBean) {
        L.Tag tag = TAG;
        L.i(tag, "onParkingSelect:" + selectParkingBean.getNum());
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onSelectParkingCount(@NonNull SelectParkingBean selectParkingBean) {
        if (NaviSpeechUtils.isSelectRecommendParkEnable(selectParkingBean.getNum())) {
            L.i(TAG, "onSelectParkingCount:true");
            SpeechUtils.replySupport("native://navi.select.parking.count", true);
            return;
        }
        L.i(TAG, "onSelectParkingCount:false");
        SpeechUtils.replySupport("native://navi.select.parking.count", false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onRouteSelect(@NonNull final SelectRouteBean selectRouteBean) {
        WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.speech.aios.NaviListenerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                L.Tag tag = NaviListenerImpl.TAG;
                L.i(tag, "SelectRouteBean:" + selectRouteBean.getNum());
                SpeechRequestFactory.getInstance().postRequest(38, String.valueOf(selectRouteBean.getNum() + (-1)));
            }
        });
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onSelectRouteCount(@Nullable SelectRouteBean selectRouteBean) {
        this.mNaviModel.onSelectRouteCount(selectRouteBean);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onWaypointSearch(WaypointSearchBean waypointSearchBean) {
        L.Tag tag = TAG;
        L.i(tag, "onWaypointSearch " + waypointSearchBean);
        SpeechRequestFactory.getInstance().postRequest(44, GsonUtil.toJson(waypointSearchBean), false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onMapZoomoutMin() {
        L.i(TAG, "onMapZoomoutMin");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_ZOOM_OUT_MIN, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlOpenSmallMap() {
        L.i(TAG, "onControlOpenSmallMap");
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlCloseSmallMap() {
        L.i(TAG, "onControlCloseSmallMap");
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlOpenRibbonMap() {
        L.i(TAG, "onControlOpenRibbonMap");
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlCloseRibbonMap() {
        L.i(TAG, "onControlCloseRibbonMap");
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onControlHistory() {
        L.i(TAG, "onControlHistory");
        SpeechRequestFactory.getInstance().postRequest(55, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onMapZoominMax() {
        L.i(TAG, "onMapZoominMax");
        SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_ZOOM_IN_MAX, false);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onGetSettingsInfo() {
        L.i(TAG, "onGetSettingsInfo");
        ResultActor resultActor = new ResultActor("native://navi.settings.info");
        resultActor.setResult((String) SpeechRequestFactory.getInstance().postRequestForResult(10013));
        SpeechClient.instance().getActorBridge().send(resultActor);
    }

    @Override // com.xiaopeng.speech.protocol.node.navi.AbsNaviListener, com.xiaopeng.speech.protocol.node.navi.NaviListener
    public void onSetScaleLevel(int i) {
        if (CarFeatureManager.INSTANCE.isVoiceControlNaviScaleLevelEnable()) {
            L.Tag tag = TAG;
            L.i(tag, "onSetScaleLevel to " + i);
            SpeechRequestFactory.getInstance().postRequest(SpeechRequestFactory.SPEECH_CMD_CONTROL_SET_SCALE_LEVEL, GsonUtil.toJson(Integer.valueOf(i)), false);
            return;
        }
        L.i(TAG, "Current car type doesn't support onSetScaleLevel");
    }

    public void addListener() {
        this.mNaviModel.getNaviNode().addListener(this);
    }

    public void removeListener() {
        this.mNaviModel.getNaviNode().removeListener(this);
    }
}
