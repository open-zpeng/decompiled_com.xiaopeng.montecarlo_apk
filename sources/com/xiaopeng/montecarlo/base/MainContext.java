package com.xiaopeng.montecarlo.base;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.base.scene.XPHandler;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorManager;
import com.xiaopeng.montecarlo.navcore.account.INavcoreContextInterface;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract;
import com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener;
import com.xiaopeng.montecarlo.scenes.mapscene.MapUIStatus;
import com.xiaopeng.montecarlo.scenes.mapscene.SceneMapEvent;
import com.xiaopeng.montecarlo.speech.command.ISpeechEvent;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.mapmode.DrawModeType;
/* loaded from: classes.dex */
public final class MainContext implements INavcoreContextInterface {
    private static final L.Tag TAG = new L.Tag("MainContext");
    private final IMainContext mMainContextProxy;

    public MainContext(@NonNull IMainContext iMainContext) {
        this.mMainContextProxy = iMainContext;
    }

    public void onDestroy() {
        if (getDecoratorManager() != null) {
            getDecoratorManager().unInit();
        }
        this.mMainContextProxy.onDestroy();
    }

    @NonNull
    public AiMsgManager getAiMsgManager() {
        return this.mMainContextProxy.getAiMsgManager();
    }

    public MapViewWrapper getMapView() {
        return this.mMainContextProxy.getMapView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateUIStatus(MapUIStatus mapUIStatus) {
        this.mMainContextProxy.updateUIStatus(mapUIStatus);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapUIStatus getUIStatus() {
        return this.mMainContextProxy.getUIStatus();
    }

    public IBaseScene getCurrentScene() {
        return this.mMainContextProxy.getCurrentScene();
    }

    public IBaseScene getEmptyScene() {
        return this.mMainContextProxy.getEmptyScene();
    }

    public void addSceneMapListener(SceneMapEvent.SceneMapListener sceneMapListener) {
        this.mMainContextProxy.addSceneMapListener(sceneMapListener);
    }

    public void removeSceneMapListener(SceneMapEvent.SceneMapListener sceneMapListener) {
        this.mMainContextProxy.removeSceneMapListener(sceneMapListener);
    }

    public void setSceneMapFragmentListener(ISceneMapFragmentListener iSceneMapFragmentListener) {
        this.mMainContextProxy.setSceneMapFragmentListener(iSceneMapFragmentListener);
    }

    public void removeSceneMapFragmentListener(ISceneMapFragmentListener iSceneMapFragmentListener) {
        this.mMainContextProxy.removeSceneMapFragmentListener(iSceneMapFragmentListener);
    }

    public void updateRecenterShowTag(boolean z) {
        this.mMainContextProxy.updateRecenterShowTag(z);
    }

    public void updateRecenterShowStatus(boolean z) {
        this.mMainContextProxy.updateRecenterShowStatus(z);
    }

    public void updateRecenterBtn() {
        this.mMainContextProxy.updateRecenterBtn();
    }

    public void addRoutePointsOverlay(IBaseScene iBaseScene) {
        this.mMainContextProxy.addRoutePointsOverlay(iBaseScene);
    }

    public void lockMapTouchEvent() {
        this.mMainContextProxy.lockMapTouchEvent();
    }

    public boolean setMapTouchEnable(boolean z) {
        return this.mMainContextProxy.setMapTouchEnable(z);
    }

    public void unlockMapTouchEvent() {
        this.mMainContextProxy.unlockMapTouchEvent();
    }

    public void lockMapPoiEvent() {
        this.mMainContextProxy.lockMapPoiEvent();
    }

    public void unlockMapPoiEvent() {
        this.mMainContextProxy.unlockMapPoiEvent();
    }

    public void startScene(IBaseScene iBaseScene, BaseBridge baseBridge, int i) {
        this.mMainContextProxy.startScene(iBaseScene, baseBridge, i);
    }

    public void startScene(BaseBridge baseBridge, int i) {
        this.mMainContextProxy.startScene(baseBridge, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void runOnUiThread(@NonNull IBaseScene iBaseScene, Runnable runnable, int i) {
        this.mMainContextProxy.runOnUiThread(iBaseScene, runnable, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void runOnUiThreadDelayed(@NonNull IBaseScene iBaseScene, Runnable runnable, int i, long j) {
        this.mMainContextProxy.runOnUiThreadDelayed(iBaseScene, runnable, i, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void runOnUiThreadRelyMap(Runnable runnable) {
        this.mMainContextProxy.runOnUiThreadRelyMap(runnable);
    }

    public void showLocationInfo(boolean z) {
        this.mMainContextProxy.showLocationInfo(z);
    }

    public void showSRData(boolean z) {
        this.mMainContextProxy.showSRData(z);
    }

    public void enableLccGeoFenceTest(boolean z) {
        this.mMainContextProxy.enableLccGeoFenceTest(z);
    }

    public void showCaptureBtn(boolean z) {
        this.mMainContextProxy.showCaptureBtn(z);
    }

    public void showProtoPlayBtn(boolean z) {
        this.mMainContextProxy.showProtoPlayBtn(z);
    }

    public void showLaneRecordPlayBtn(boolean z) {
        this.mMainContextProxy.showLaneRecordPlayBtn(z);
    }

    public void showCameraDegree(boolean z) {
        this.mMainContextProxy.showCameraDegree(z);
    }

    public boolean isLocationInfoShow() {
        return this.mMainContextProxy.isLocationInfoShow();
    }

    public boolean isMapPoiLocked() {
        return this.mMainContextProxy.isMapPoiLocked();
    }

    public XPHandler getRunTimeHandler() {
        return this.mMainContextProxy.getRunTimeHandler();
    }

    public void onChargeEnableChanged(boolean z) {
        this.mMainContextProxy.onChargeSettingChanged(z);
    }

    public void onScratchSpotChanged(boolean z) {
        this.mMainContextProxy.onScratchSpotChanged(z);
    }

    public void onStateImmersion() {
        this.mMainContextProxy.onStateImmersion();
    }

    public void onStateActive() {
        this.mMainContextProxy.onStateActive();
    }

    public DecoratorManager getDecoratorManager() {
        return this.mMainContextProxy.getDecoratorManager();
    }

    public void setDecoratorManager(DecoratorManager decoratorManager) {
        this.mMainContextProxy.setDecoratorManager(decoratorManager);
    }

    public void finishActivity() {
        this.mMainContextProxy.finishActivity();
    }

    @Override // com.xiaopeng.montecarlo.navcore.account.INavcoreContextInterface
    public Activity getCurrentActivity() {
        return this.mMainContextProxy.getCurrentActivity();
    }

    public ISpeechEvent getSpeechEvent() {
        return this.mMainContextProxy.getSpeechEvent();
    }

    public ScenesManager getScenesManager() {
        return this.mMainContextProxy.getScenesManager();
    }

    public void showRecenterBtnAlways(boolean z) {
        this.mMainContextProxy.showRecenterBtnAlways(z);
    }

    public ICruiseContract.CheckAndMoveCarGreetingListner getCheckAndMoveCarGreetingListner() {
        return this.mMainContextProxy.getCheckAndMoveCarGreetingListner();
    }

    public void setCheckAndMoveCarGreetingListner(ICruiseContract.CheckAndMoveCarGreetingListner checkAndMoveCarGreetingListner) {
        this.mMainContextProxy.setCheckAndMoveCarGreetingListner(checkAndMoveCarGreetingListner);
    }

    public void updateVuiScene(View view) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("updateVuiScene view:" + view));
        }
        VoiceFullScenesUtil.updateScene(getCurrentScene(), view);
    }

    public void switchMapModeForVui(DrawModeType drawModeType) {
        L.Tag tag = TAG;
        L.i(tag, "switchMapModeForVui type:" + drawModeType);
        this.mMainContextProxy.switchMapModeForVui(drawModeType);
    }

    public void switchMapScaleForVui(int i) {
        L.Tag tag = TAG;
        L.i(tag, "switchMapScaleForVui level:" + i);
        this.mMainContextProxy.switchMapScaleForVui(i);
    }

    public void switchMapOverviewForVui(View view) {
        L.Tag tag = TAG;
        L.i(tag, "switchMapOverviewForVui view:" + view);
        this.mMainContextProxy.switchMapOverviewForVui(view);
    }

    public int getRoadChangeStatus() {
        int roadChangeStatus = this.mMainContextProxy.getRoadChangeStatus();
        L.Tag tag = TAG;
        L.i(tag, "getRoadChangeStatus flag:" + roadChangeStatus);
        return roadChangeStatus;
    }

    public void showPrompt(int i) {
        showPrompt(ContextUtils.getString(i));
    }

    public void showPrompt(String str) {
        L.Tag tag = TAG;
        L.i(tag, "showPrompt text:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mMainContextProxy.showPrompt(str);
    }

    public View getMapSceneView() {
        return this.mMainContextProxy.getMapSceneView();
    }

    public void switchRoadChangeForVui(View view) {
        this.mMainContextProxy.switchRoadChangeForVui(view);
    }

    public void updateSRNaviSwitchStatus(int i, boolean z) {
        this.mMainContextProxy.updateSRNaviSwitchStatus(i, z);
    }

    public void updateSRNaviGuideLineStatus(boolean z) {
        this.mMainContextProxy.updateSRNaviGuideLineStatus(z);
    }

    public void updateAutoLogoStatus(int i) {
        this.mMainContextProxy.updateAutoLogoStatus(i);
    }

    public void startTakeOverWeakAnim() {
        this.mMainContextProxy.startTakeOverWeakAnim();
    }

    public void stopTakeOverWeakAnim() {
        this.mMainContextProxy.stopTakeOverWeakAnim();
    }
}
