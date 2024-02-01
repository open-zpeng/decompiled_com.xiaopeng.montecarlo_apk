package com.xiaopeng.montecarlo.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.base.scene.FragmentRunnable;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.base.scene.ISceneRunnable;
import com.xiaopeng.montecarlo.base.scene.SceneRunnable;
import com.xiaopeng.montecarlo.base.scene.XPHandler;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorManager;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract;
import com.xiaopeng.montecarlo.scenes.debugscene.CameraDegreeHelper;
import com.xiaopeng.montecarlo.scenes.debugscene.CaptureHelper;
import com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener;
import com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter;
import com.xiaopeng.montecarlo.scenes.mapscene.MapUIStatus;
import com.xiaopeng.montecarlo.scenes.mapscene.SceneMapEvent;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.speech.command.ISpeechEvent;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.mapmode.DrawModeType;
import com.xiaopeng.speech.jarvisproto.DMWait;
import com.xiaopeng.xui.app.XToast;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MainContextImpl implements IMainContext {
    private static final L.Tag TAG = new L.Tag("MainContextImpl");
    private ICruiseContract.CheckAndMoveCarGreetingListner mCheckAndMoveCarGreetingListner;
    private DecoratorManager mDecoratorManager;
    private final MapFragment mMapFragment;
    private final ScenesManager mScenesManager;
    private ISpeechEvent mSpeechEvent = new ISpeechEvent() { // from class: com.xiaopeng.montecarlo.base.MainContextImpl.1
        @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
        public boolean onInterceptSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
            int i = speechNaviEvent.what;
            boolean z = i == 104 || i == 107 || i == 1110;
            String[] strArr = new String[1];
            strArr[0] = z ? "intercept" : "do nothing";
            speechNaviEvent.record("MainContextImpl", "onInterceptSpeechEvent", strArr);
            return z;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
        @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onSpeechEvent(com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent r4, com.xiaopeng.montecarlo.speech.command.ICommandCallback r5) {
            /*
                r3 = this;
                int r5 = r4.what
                r0 = 104(0x68, float:1.46E-43)
                r1 = 1
                r2 = 0
                if (r5 == r0) goto L3d
                r0 = 107(0x6b, float:1.5E-43)
                if (r5 == r0) goto L25
                r0 = 1110(0x456, float:1.555E-42)
                if (r5 == r0) goto L12
                r5 = r2
                goto L55
            L12:
                com.xiaopeng.montecarlo.root.util.L$Tag r5 = com.xiaopeng.montecarlo.base.MainContextImpl.access$000()
                java.lang.String r0 = "SPEECH_SCRATCH_SPOT_BROADCAST"
                com.xiaopeng.montecarlo.root.util.L.i(r5, r0)
                com.xiaopeng.montecarlo.base.MainContextImpl r5 = com.xiaopeng.montecarlo.base.MainContextImpl.this
                boolean r0 = r4.getSwitchState()
                r5.onScratchSpotChanged(r0)
                goto L54
            L25:
                com.xiaopeng.montecarlo.root.util.L$Tag r5 = com.xiaopeng.montecarlo.base.MainContextImpl.access$000()
                java.lang.String r0 = "SPEECH_OPEN_SETTING_MAP_DOWNLOAD"
                com.xiaopeng.montecarlo.root.util.L.i(r5, r0)
                com.xiaopeng.montecarlo.base.MainContextImpl r5 = com.xiaopeng.montecarlo.base.MainContextImpl.this
                com.xiaopeng.montecarlo.bridge.MapDownloadBridge r0 = new com.xiaopeng.montecarlo.bridge.MapDownloadBridge
                r0.<init>()
                com.xiaopeng.montecarlo.base.BaseBridge r0 = r0.enableOverMode()
                r5.startScene(r0, r2)
                goto L54
            L3d:
                com.xiaopeng.montecarlo.root.util.L$Tag r5 = com.xiaopeng.montecarlo.base.MainContextImpl.access$000()
                java.lang.String r0 = "SPEECH_OPEN_DEBUG"
                com.xiaopeng.montecarlo.root.util.L.i(r5, r0)
                com.xiaopeng.montecarlo.base.MainContextImpl r5 = com.xiaopeng.montecarlo.base.MainContextImpl.this
                com.xiaopeng.montecarlo.bridge.DebugBridge r0 = new com.xiaopeng.montecarlo.bridge.DebugBridge
                r0.<init>()
                com.xiaopeng.montecarlo.base.BaseBridge r0 = r0.enableOverMode()
                r5.startScene(r0, r2)
            L54:
                r5 = r1
            L55:
                java.lang.String[] r0 = new java.lang.String[r1]
                if (r5 == 0) goto L5c
                java.lang.String r1 = "consume"
                goto L5e
            L5c:
                java.lang.String r1 = ""
            L5e:
                r0[r2] = r1
                java.lang.String r1 = "MainContextImpl"
                java.lang.String r2 = "onSpeechEvent"
                r4.record(r1, r2, r0)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.base.MainContextImpl.AnonymousClass1.onSpeechEvent(com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent, com.xiaopeng.montecarlo.speech.command.ICommandCallback):boolean");
        }

        @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
        public boolean dispatchSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
            speechNaviEvent.record("MainContextImpl", "dispatchSpeechEvent", "start");
            if (L.ENABLE) {
                L.Tag tag = MainContextImpl.TAG;
                L.d(tag, "dispatchSpeechEvent " + speechNaviEvent.what);
            }
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                if (MainContextImpl.this.mMapFragment != null) {
                    if (MainContextImpl.this.mMapFragment.onInterceptSpeechEvent(speechNaviEvent, iCommandCallback)) {
                        return MainContextImpl.this.mMapFragment.onSpeechEvent(speechNaviEvent, iCommandCallback);
                    }
                    if (!(MainContextImpl.this.mScenesManager.getSpeechEvent() != null ? MainContextImpl.this.mScenesManager.getSpeechEvent().dispatchSpeechEvent(speechNaviEvent, iCommandCallback) : false)) {
                        boolean onSpeechEvent = MainContextImpl.this.mMapFragment.onSpeechEvent(speechNaviEvent, iCommandCallback);
                        String[] strArr = new String[2];
                        strArr[0] = DMWait.STATUS_END;
                        strArr[1] = onSpeechEvent ? "consume" : "";
                        speechNaviEvent.record("MainContextImpl", "dispatchSpeechEvent", strArr);
                        return onSpeechEvent || onSpeechEvent(speechNaviEvent, iCommandCallback);
                    }
                    speechNaviEvent.record("MainContextImpl", "dispatchSpeechEvent", "end by ScenesManager");
                    return true;
                }
                speechNaviEvent.record("MainContextImpl", "dispatchSpeechEvent", "error happened, mMapFragment is null");
                return false;
            }
            throw new RuntimeException("dispatchSpeechEvent should be run in MainThread");
        }
    };
    private final AiMsgManager mAiMsgManager = new AiMsgManager();

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void onDestroy() {
    }

    public MainContextImpl(MapFragment mapFragment, ScenesManager scenesManager) {
        this.mMapFragment = mapFragment;
        this.mScenesManager = scenesManager;
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public ICruiseContract.CheckAndMoveCarGreetingListner getCheckAndMoveCarGreetingListner() {
        return this.mCheckAndMoveCarGreetingListner;
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void setCheckAndMoveCarGreetingListner(ICruiseContract.CheckAndMoveCarGreetingListner checkAndMoveCarGreetingListner) {
        this.mCheckAndMoveCarGreetingListner = checkAndMoveCarGreetingListner;
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void updateUIStatus(@NonNull MapUIStatus mapUIStatus) {
        this.mMapFragment.updateUIStatus(mapUIStatus);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public MapUIStatus getUIStatus() {
        return this.mMapFragment.getUIStatus();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public IBaseScene getCurrentScene() {
        return this.mScenesManager.getCurrentScene();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void lockMapTouchEvent() {
        this.mMapFragment.lockMapTouchEvent();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void unlockMapTouchEvent() {
        this.mMapFragment.unlockMapTouchEvent();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void lockMapPoiEvent() {
        this.mMapFragment.lockMapPoiEvent();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public boolean isMapPoiLocked() {
        return this.mMapFragment.isMapPoiLocked();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void unlockMapPoiEvent() {
        this.mMapFragment.unlockMapPoiEvent();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void updateRecenterShowTag(boolean z) {
        this.mMapFragment.updateRecenterShowTag(z);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void updateRecenterShowStatus(boolean z) {
        this.mMapFragment.updateRecenterShowStatus(z);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void updateRecenterBtn() {
        this.mMapFragment.mo116getPresenter().updateRecenterStatus();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void showRecenterBtnAlways(boolean z) {
        this.mMapFragment.showRecenterBtnAlways(z);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void updateSRNaviSwitchStatus(int i, boolean z) {
        this.mMapFragment.updateSRNaviSwitchStatus(i, z);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void updateSRNaviGuideLineStatus(boolean z) {
        this.mMapFragment.updateSRNaviGuideLineStatus(z);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void updateAutoLogoStatus(int i) {
        this.mMapFragment.updateAutoLogoStatus(i);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void switchMapModeForVui(DrawModeType drawModeType) {
        MapScenePresenter mo116getPresenter = this.mMapFragment.mo116getPresenter();
        if (mo116getPresenter != null) {
            if (drawModeType == null) {
                mo116getPresenter.switchMapMode();
            } else if (drawModeType == DrawModeType.NORTHUP) {
                mo116getPresenter.executeSpeechCmdMapModeNorthUp();
            } else if (drawModeType == DrawModeType.HEADUP_2D) {
                mo116getPresenter.executeSpeechCmdMapModeHeadUp2D();
            } else if (drawModeType == DrawModeType.HEADUP_3D) {
                mo116getPresenter.executeSpeechCmdMapModeHeadUp3D();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void switchMapScaleForVui(int i) {
        if (i == 19) {
            this.mMapFragment.mo116getPresenter().zoomInToMax();
        } else if (i == 3) {
            this.mMapFragment.mo116getPresenter().zoomOutToMin();
        } else {
            this.mMapFragment.mo116getPresenter().zoom(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void switchMapOverviewForVui(View view) {
        this.mMapFragment.onClickOverView(view);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void switchRoadChangeForVui(View view) {
        this.mMapFragment.onClickRoadChange(view);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public int getRoadChangeStatus() {
        return this.mMapFragment.getRoadChangeStatus();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public View getMapSceneView() {
        return this.mMapFragment.getMapSceneView();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void startScene(@NonNull IBaseScene iBaseScene, BaseBridge baseBridge, int i) {
        if (baseBridge != null) {
            ScenesManager scenesManager = this.mScenesManager;
            if (scenesManager != null) {
                scenesManager.setStartScene(iBaseScene);
            }
            if (Utils.isCruiseScene(iBaseScene)) {
                baseBridge.startSceneForResult(this.mScenesManager, i, 10);
            } else {
                baseBridge.startSceneForResult(this.mScenesManager, i, iBaseScene != null ? iBaseScene.getSceneId() : 0);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void startScene(BaseBridge baseBridge, int i) {
        if (baseBridge != null) {
            baseBridge.startSceneForResult(this.mScenesManager, i, 10);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void showLocationInfo(final boolean z) {
        runOnUiThreadRelyMap(new Runnable() { // from class: com.xiaopeng.montecarlo.base.MainContextImpl.2
            @Override // java.lang.Runnable
            public void run() {
                MainContextImpl.this.mMapFragment.mo116getPresenter().showLocationInfo(z);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void showSRData(final boolean z) {
        runOnUiThreadRelyMap(new Runnable() { // from class: com.xiaopeng.montecarlo.base.MainContextImpl.3
            @Override // java.lang.Runnable
            public void run() {
                MainContextImpl.this.mMapFragment.mo116getPresenter().showSRData(z);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void showCaptureBtn(final boolean z) {
        final CaptureHelper captureHelper = this.mMapFragment.getCaptureHelper();
        if (captureHelper == null) {
            return;
        }
        runOnUiThreadRelyMap(new Runnable() { // from class: com.xiaopeng.montecarlo.base.MainContextImpl.4
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    captureHelper.showCaptureBtn();
                } else {
                    captureHelper.hideCaptureBtn();
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void showProtoPlayBtn(boolean z) {
        MapFragment mapFragment = this.mMapFragment;
        if (mapFragment != null) {
            mapFragment.showProtoPlayBtn(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void enableLccGeoFenceTest(boolean z) {
        MapFragment mapFragment = this.mMapFragment;
        if (mapFragment != null) {
            mapFragment.enableLccGeoFenceTest(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void showLaneRecordPlayBtn(boolean z) {
        MapFragment mapFragment = this.mMapFragment;
        if (mapFragment != null) {
            mapFragment.showLaneRecordPlayBtn(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void showCameraDegree(final boolean z) {
        final CameraDegreeHelper cameraDegreeHelper = this.mMapFragment.getCameraDegreeHelper();
        if (cameraDegreeHelper == null) {
            return;
        }
        runOnUiThreadRelyMap(new Runnable() { // from class: com.xiaopeng.montecarlo.base.MainContextImpl.5
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    cameraDegreeHelper.showCameraDegreeBtn();
                } else {
                    cameraDegreeHelper.hideCameraDegreeBtn();
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public boolean isLocationInfoShow() {
        return this.mMapFragment.mo116getPresenter().isLocationInfoShow();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void addSceneMapListener(SceneMapEvent.SceneMapListener sceneMapListener) {
        this.mMapFragment.addSceneMapListener(sceneMapListener);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void removeSceneMapListener(SceneMapEvent.SceneMapListener sceneMapListener) {
        this.mMapFragment.removeSceneMapListener(sceneMapListener);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void setSceneMapFragmentListener(ISceneMapFragmentListener iSceneMapFragmentListener) {
        this.mMapFragment.setSceneMapFragmentListener(iSceneMapFragmentListener);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void removeSceneMapFragmentListener(ISceneMapFragmentListener iSceneMapFragmentListener) {
        this.mMapFragment.removeSceneMapFragmentListener(iSceneMapFragmentListener);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public XPHandler getRunTimeHandler() {
        ScenesManager scenesManager = this.mScenesManager;
        if (scenesManager != null) {
            return scenesManager.getRunTimeHandler();
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public IBaseScene getEmptyScene() {
        ScenesManager scenesManager = this.mScenesManager;
        if (scenesManager != null) {
            return scenesManager.getEmptyScene();
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void onChargeSettingChanged(boolean z) {
        this.mMapFragment.mo116getPresenter().setChargeEnable(z);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void onScratchSpotChanged(boolean z) {
        this.mMapFragment.mo116getPresenter().setScratchSpotEnable(z);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public MapViewWrapper getMapView() {
        return this.mMapFragment.getMapView();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void addRoutePointsOverlay(IBaseScene iBaseScene) {
        RouteDataModel routeData = TBTManager.getInstance().getRouteData(TBTManager.getInstance().getCurrentRouteRequestId());
        if (routeData == null || routeData.mRouteParams == null) {
            return;
        }
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.add(routeData.mRouteParams.mStartInfo);
        bundle.putParcelableArrayList(BaseMapDecorator.KEY_POI_LIST, arrayList);
        this.mDecoratorManager.showMapDecorator(iBaseScene, DecoratorType.START_POINT, bundle);
        Bundle bundle2 = new Bundle();
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        arrayList2.add(routeData.mRouteParams.mEndInfo);
        bundle2.putParcelableArrayList(BaseMapDecorator.KEY_POI_LIST, arrayList2);
        this.mDecoratorManager.showMapDecorator(iBaseScene, DecoratorType.END_POINT, bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putParcelableArrayList(BaseMapDecorator.KEY_POI_LIST, NaviUtil.transformXPViaPointToXPPoiInfo(routeData.mRouteParams.mViaInfos));
        this.mDecoratorManager.showMapDecorator(iBaseScene, DecoratorType.WAY_POINT, bundle3);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    @NonNull
    public AiMsgManager getAiMsgManager() {
        return this.mAiMsgManager;
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void onStateImmersion() {
        this.mMapFragment.onStateImmersion();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void onStateActive() {
        this.mMapFragment.onStateActive();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void finishActivity() {
        MapFragment mapFragment = this.mMapFragment;
        if (mapFragment == null || mapFragment.getActivity() == null) {
            return;
        }
        this.mMapFragment.getActivity().finish();
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public Activity getCurrentActivity() {
        MapFragment mapFragment = this.mMapFragment;
        if (mapFragment != null) {
            return mapFragment.getActivity();
        }
        return null;
    }

    private void runOnUiThread(@NonNull ISceneRunnable iSceneRunnable, @NonNull XPHandler xPHandler) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Object token = iSceneRunnable.getToken();
            if (token != null) {
                xPHandler.postAtTime(iSceneRunnable.getRunnable(), token, SystemClock.uptimeMillis());
                return;
            }
            return;
        }
        iSceneRunnable.getRunnable().run();
    }

    private void runOnUiThreadDelayed(@NonNull ISceneRunnable iSceneRunnable, @NonNull XPHandler xPHandler, long j) {
        Object token = iSceneRunnable.getToken();
        if (j < 0) {
            j = 0;
        }
        if (token != null) {
            xPHandler.postAtTime(iSceneRunnable.getRunnable(), token, SystemClock.uptimeMillis() + j);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public final void runOnUiThread(@NonNull IBaseScene iBaseScene, Runnable runnable, int i) {
        ScenesManager scenesManager;
        ISceneRunnable sceneRunnable;
        FragmentActivity activity = this.mMapFragment.getActivity();
        if (activity == null || activity.isDestroyed() || (scenesManager = this.mScenesManager) == null) {
            return;
        }
        XPHandler runTimeHandler = scenesManager.getRunTimeHandler();
        if (iBaseScene.getBridge().getMode() == StatusConst.Mode.EMPTY) {
            sceneRunnable = new FragmentRunnable(this.mMapFragment, runnable, i);
        } else {
            sceneRunnable = new SceneRunnable(iBaseScene, runnable, i);
        }
        runOnUiThread(sceneRunnable, runTimeHandler);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void runOnUiThreadDelayed(@NonNull IBaseScene iBaseScene, Runnable runnable, int i, long j) {
        ScenesManager scenesManager;
        ISceneRunnable sceneRunnable;
        FragmentActivity activity = this.mMapFragment.getActivity();
        if (activity == null || activity.isDestroyed() || (scenesManager = this.mScenesManager) == null) {
            return;
        }
        XPHandler runTimeHandler = scenesManager.getRunTimeHandler();
        if (iBaseScene.getBridge().getMode() == StatusConst.Mode.EMPTY) {
            sceneRunnable = new FragmentRunnable(this.mMapFragment, runnable, i);
        } else {
            sceneRunnable = new SceneRunnable(iBaseScene, runnable, i);
        }
        runOnUiThreadDelayed(sceneRunnable, runTimeHandler, j);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void runOnUiThreadRelyMap(Runnable runnable) {
        this.mMapFragment.runOnUiThread(runnable);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public DecoratorManager getDecoratorManager() {
        return this.mDecoratorManager;
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public void setDecoratorManager(DecoratorManager decoratorManager) {
        this.mDecoratorManager = decoratorManager;
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public ISpeechEvent getSpeechEvent() {
        return this.mSpeechEvent;
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public boolean setMapTouchEnable(boolean z) {
        return this.mMapFragment.setMapTouchEnable(z);
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    public ScenesManager getScenesManager() {
        return this.mScenesManager;
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    @MainThread
    /* renamed from: showPrompt */
    public void lambda$showPrompt$0$MainContextImpl(final String str) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MainContextImpl$9TCpLSG1TRaAKsuQBJZF05wNzsc
                @Override // java.lang.Runnable
                public final void run() {
                    MainContextImpl.this.lambda$showPrompt$0$MainContextImpl(str);
                }
            });
        } else {
            XToast.show(str);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    @MainThread
    public void startTakeOverWeakAnim() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.base.MainContextImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    MainContextImpl.this.mMapFragment.startTakeOverWeakAnim();
                }
            });
        } else {
            this.mMapFragment.startTakeOverWeakAnim();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IMainContext
    @MainThread
    public void stopTakeOverWeakAnim() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.base.MainContextImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    MainContextImpl.this.mMapFragment.stopTakeOverWeakAnim();
                }
            });
        } else {
            this.mMapFragment.stopTakeOverWeakAnim();
        }
    }
}
