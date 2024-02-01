package com.xiaopeng.montecarlo.base;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.base.scene.XPHandler;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorManager;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract;
import com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener;
import com.xiaopeng.montecarlo.scenes.mapscene.MapUIStatus;
import com.xiaopeng.montecarlo.scenes.mapscene.SceneMapEvent;
import com.xiaopeng.montecarlo.speech.command.ISpeechEvent;
import com.xiaopeng.montecarlo.views.mapmode.DrawModeType;
import javax.validation.constraints.NotNull;
/* loaded from: classes.dex */
public interface IMainContext {
    void addRoutePointsOverlay(IBaseScene iBaseScene);

    void addSceneMapListener(SceneMapEvent.SceneMapListener sceneMapListener);

    void enableLccGeoFenceTest(boolean z);

    void finishActivity();

    @NonNull
    AiMsgManager getAiMsgManager();

    @Nullable
    default ICruiseContract.CheckAndMoveCarGreetingListner getCheckAndMoveCarGreetingListner() {
        return null;
    }

    Activity getCurrentActivity();

    IBaseScene getCurrentScene();

    DecoratorManager getDecoratorManager();

    IBaseScene getEmptyScene();

    View getMapSceneView();

    MapViewWrapper getMapView();

    int getRoadChangeStatus();

    XPHandler getRunTimeHandler();

    ScenesManager getScenesManager();

    ISpeechEvent getSpeechEvent();

    MapUIStatus getUIStatus();

    boolean isLocationInfoShow();

    boolean isMapPoiLocked();

    void lockMapPoiEvent();

    void lockMapTouchEvent();

    void onChargeSettingChanged(boolean z);

    void onDestroy();

    void onScratchSpotChanged(boolean z);

    void onStateActive();

    void onStateImmersion();

    void removeSceneMapFragmentListener(ISceneMapFragmentListener iSceneMapFragmentListener);

    void removeSceneMapListener(SceneMapEvent.SceneMapListener sceneMapListener);

    void runOnUiThread(@NonNull IBaseScene iBaseScene, Runnable runnable, int i);

    void runOnUiThreadDelayed(@NonNull IBaseScene iBaseScene, Runnable runnable, int i, long j);

    void runOnUiThreadRelyMap(Runnable runnable);

    default void setCheckAndMoveCarGreetingListner(@NotNull ICruiseContract.CheckAndMoveCarGreetingListner checkAndMoveCarGreetingListner) {
    }

    void setDecoratorManager(DecoratorManager decoratorManager);

    boolean setMapTouchEnable(boolean z);

    void setSceneMapFragmentListener(ISceneMapFragmentListener iSceneMapFragmentListener);

    void showCameraDegree(boolean z);

    void showCaptureBtn(boolean z);

    void showLaneRecordPlayBtn(boolean z);

    default void showLocationInfo(boolean z) {
    }

    void showPrompt(String str);

    void showProtoPlayBtn(boolean z);

    void showRecenterBtnAlways(boolean z);

    default void showSRData(boolean z) {
    }

    void startScene(BaseBridge baseBridge, int i);

    void startScene(IBaseScene iBaseScene, BaseBridge baseBridge, int i);

    void startTakeOverWeakAnim();

    void stopTakeOverWeakAnim();

    void switchMapModeForVui(DrawModeType drawModeType);

    void switchMapOverviewForVui(View view);

    void switchMapScaleForVui(int i);

    void switchRoadChangeForVui(View view);

    void unlockMapPoiEvent();

    void unlockMapTouchEvent();

    void updateAutoLogoStatus(int i);

    void updateRecenterBtn();

    void updateRecenterShowStatus(boolean z);

    void updateRecenterShowTag(boolean z);

    void updateSRNaviGuideLineStatus(boolean z);

    void updateSRNaviSwitchStatus(int i, boolean z);

    void updateUIStatus(@NonNull MapUIStatus mapUIStatus);
}
