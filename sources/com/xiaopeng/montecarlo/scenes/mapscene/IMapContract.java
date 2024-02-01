package com.xiaopeng.montecarlo.scenes.mapscene;

import com.xiaopeng.montecarlo.base.IBaseLogicView;
import com.xiaopeng.montecarlo.base.IBasePresenter;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.trafficevent.TrafficEventPopParam;
/* loaded from: classes3.dex */
public interface IMapContract {

    /* loaded from: classes3.dex */
    public interface LogicView extends IBaseLogicView<MapScenePresenter> {
        void executeAfterNaviStop();

        PageType getPageType();

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
        /* renamed from: getPresenter */
        MapScenePresenter mo116getPresenter();

        MapUIStatus getUIStatus();

        void goToRootPage();

        @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
        void hide();

        void hidePoiTrafficEventPop();

        void hideVolumePanel();

        void initListener();

        boolean isRecenterBtnVisible();

        boolean isVolumePanelVisible();

        void onParallelRoadSwitchFinish();

        void onScreenOn();

        void onStateActive();

        void onStateImmersion();

        void popToastForMapModeChange(int i);

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
        void setPresenter(MapScenePresenter mapScenePresenter);

        @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
        void show();

        void showDebugSRData(boolean z);

        void showLocationInfo(boolean z);

        void showPoiTrafficEventPop(TrafficEventPopParam trafficEventPopParam);

        void showRememberVolumeTips();

        void showVolumePanel();

        void startSearchHistories();

        void startSettingScene();

        void switchHeadUp2D();

        void switchHeadUp3D();

        void switchNorthUp();

        void updateADRDebugMessage(String str);

        void updateAutoLogoStatus(int i);

        void updateCalibrationSpeedMessage(String str);

        void updateDRDebugMessage(String str);

        void updateDebugMapCenter();

        void updateDebugSRDisplaySt(int i);

        void updateDebugSRDriveMode(int i);

        void updateDebugSRFrameAveCostTime(int i);

        void updateDebugSRFrameRate(int i);

        void updateDebugSRInfoTips(int i);

        void updateDebugSRLaneSt(int i);

        void updateDebugSRLcTips(int i);

        void updateDebugSRLndsDis(int i, int i2);

        void updateDebugSRODDSt(int i);

        void updateDebugSROperateTips(int i);

        void updateDebugSRTTSSt(int i);

        void updateLocationInfo(String str);

        void updateMapAngle();

        void updateMapMode();

        void updateParallelRoadBtnStatus(boolean z);

        void updateRecenterBtnStatus(boolean z);

        void updateSRNaviGuideLineStatus(boolean z);

        void updateSRNaviSwitchStatus(int i, boolean z);

        void updateScaleText(int i, int i2);

        void updateUIStatus(MapUIStatus mapUIStatus);

        void updateVolumeBtnStatus();

        void updateVolumeProcess(int i, boolean z);

        void updateZoomInOutBtnStatus(boolean z, boolean z2);
    }

    /* loaded from: classes3.dex */
    public interface Presenter extends IBasePresenter {
        void goBackMapCenter();

        void registerAccountAsync();

        void registerAccountChangeObserver();

        void showRecenterBtnAlways(boolean z);

        void switchMapMode();

        void unregisterAccountAsync();

        void unregisterAccountChangeObserver();
    }
}
