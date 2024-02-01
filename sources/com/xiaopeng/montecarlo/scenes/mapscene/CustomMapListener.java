package com.xiaopeng.montecarlo.scenes.mapscene;

import androidx.annotation.NonNull;
import com.autonavi.gbl.map.model.IndoorBuilding;
import com.autonavi.gbl.map.model.MapLabelItem;
import com.autonavi.gbl.map.model.MapRoadTip;
import com.autonavi.gbl.map.model.PointD;
import com.autonavi.gbl.map.model.ScenicInfo;
import com.autonavi.gbl.map.model.ScreenShotDataInfo;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.sr.LaneServiceManager;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.OddDataHelper;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.mapscene.SceneMapEvent;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class CustomMapListener implements IMapListener {
    private static final L.Tag TAG = new L.Tag("CustomMapListener");
    private static boolean sDump = false;
    private Disposable mMapCenterChangedDisposable;
    private Disposable mMapLevelChangedDisposable;
    protected MapScenePresenter mMapPresenter;
    private List<SceneMapEvent.SceneMapListener> mSceneMapListeners = new CopyOnWriteArrayList();
    private int mMapTouchEventLockCount = 0;
    private int mMapPoiLockCount = 0;
    private PublishSubject mMapLevelChangedSubject = PublishSubject.create();
    private PublishSubject mMapCenterChangedSubject = PublishSubject.create();
    private Object mMapLevelChangedSubjectLock = new Object();
    private Object mMapCenterChangedSubjectLock = new Object();
    private boolean mIsLaneServiceAttachInvoked = false;

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onCheckIngDataRenderComplete(long j, long j2) {
    }

    @Override // com.autonavi.gbl.map.observer.IEGLScreenshotObserver
    public void onEGLScreenshot(int i, byte[] bArr, ScreenShotDataInfo screenShotDataInfo, int i2, long j) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onIndoorBuildingActivity(long j, IndoorBuilding indoorBuilding) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapHeatActive(long j, boolean z) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapSizeChanged(long j) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapViewDestory(long j) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapVisibleIndoor(long j, ArrayList<IndoorBuilding> arrayList, ArrayList<IndoorBuilding> arrayList2) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMotionFinished(long j, int i) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onMoveLocked(long j) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onPinchLocked(long j) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onPitchAngle(long j, float f) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onPreDrawFrame(long j) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onRealCityAnimationFinished(long j) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onRenderEnter(long j) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onRollAngle(long j, float f) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onRouteBoardData(long j, ArrayList<MapRoadTip> arrayList) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onScaleRotate(long j, long j2, long j3) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onScaleRotateBegin(long j, long j2, long j3) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onScaleRotateEnd(long j, long j2, long j3) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onScenicActive(long j, ScenicInfo scenicInfo) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onSelectSubWayActive(long j, long[] jArr) {
    }

    public CustomMapListener(@NonNull MapScenePresenter mapScenePresenter) {
        this.mMapPresenter = mapScenePresenter;
        initSubject();
    }

    public static void dumpMapOpenGL() {
        sDump = true;
    }

    private void initSubject() {
        this.mMapLevelChangedDisposable = subscribeSubject(this.mMapLevelChangedSubject, 500L);
        this.mMapCenterChangedDisposable = subscribeSubject(this.mMapCenterChangedSubject, 500L);
    }

    private Disposable subscribeSubject(Subject subject, long j) {
        return subject.throttleLast(j, TimeUnit.MILLISECONDS).subscribe(new Consumer<Runnable>() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.CustomMapListener.1
            @Override // io.reactivex.functions.Consumer
            public void accept(Runnable runnable) throws Exception {
                if (L.ENABLE) {
                    L.d(CustomMapListener.TAG, "ready to run");
                }
                runnable.run();
            }
        });
    }

    public void destroy() {
        Disposable disposable = this.mMapLevelChangedDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.mMapCenterChangedDisposable;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        synchronized (this.mMapLevelChangedSubjectLock) {
            this.mMapLevelChangedSubject = null;
        }
        synchronized (this.mMapCenterChangedSubjectLock) {
            this.mMapCenterChangedSubject = null;
        }
    }

    public void addSceneMapListener(SceneMapEvent.SceneMapListener sceneMapListener) {
        CollectionUtils.listAdd(this.mSceneMapListeners, sceneMapListener);
    }

    public void removeSceneMapListener(SceneMapEvent.SceneMapListener sceneMapListener) {
        this.mSceneMapListeners.remove(sceneMapListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lockMapTouchEvent() {
        this.mMapTouchEventLockCount++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unlockMapTouchEvent() {
        this.mMapTouchEventLockCount--;
        if (this.mMapTouchEventLockCount < 0) {
            this.mMapTouchEventLockCount = 0;
        }
    }

    private boolean isMapTouchLocked() {
        boolean z = this.mMapTouchEventLockCount > 0;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isMapTouchLocked flag:" + z);
        }
        return z;
    }

    public void lockMapPoiEvent() {
        this.mMapPoiLockCount++;
    }

    public void unlockMapPoiEvent() {
        this.mMapPoiLockCount--;
        if (this.mMapPoiLockCount < 0) {
            this.mMapPoiLockCount = 0;
        }
    }

    public boolean isMapPoiLocked() {
        return this.mMapPoiLockCount > 0;
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onMotionEvent(long j, int i, long j2, long j3) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onMotionEvent: engineId = [" + j + "], px = [" + j2 + "], py = [" + j3 + "]");
        }
        MapViewWrapper mapViewWrapper = this.mMapPresenter.mMapViewWrapper;
        if (mapViewWrapper != null && mapViewWrapper.isLaneMode()) {
            if (L.ENABLE) {
                L.d(TAG, "onMotionEvent isLaneMode:");
            }
            if (i == 0 || i == 5) {
                DataLogUtil.sendStatData(PageType.NAVI_SR_PAGE_OPERATION, BtnType.SR_PAGE_TWO_POINTER_ON_SR, new Object[0]);
            }
            StateManager.getInstance().switchActiveState();
        } else if (!isMapTouchLocked()) {
            doMapLevelChanged(false);
            for (SceneMapEvent.SceneMapListener sceneMapListener : this.mSceneMapListeners) {
                sceneMapListener.onMapEvent(SceneMapEvent.obtainMotion());
            }
            StateManager.getInstance().switchActiveState();
            this.mMapPresenter.onMotionEvent(j, i, j2, j3);
        }
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onMoveBegin(long j, long j2, long j3) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onMoveBegin: engineId = [" + j + "], px = [" + j2 + "], py = [" + j3 + "]");
        }
        if (isMapTouchLocked()) {
            return;
        }
        this.mMapPresenter.setFollowMode(false);
        this.mMapPresenter.onMoveBegin(j2, j3);
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onMoveEnd(long j, long j2, long j3) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onMoveEnd: engineId = [" + j + "], px = [" + j2 + "], py = [" + j3 + "]");
        }
        if (isMapTouchLocked()) {
            return;
        }
        this.mMapPresenter.onMoveEnd(j2, j3);
        doMapLevelChanged(false);
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onMove(long j, long j2, long j3) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onMove: engineId = [" + j + "], px = [" + j2 + "], py = [" + j3 + "]");
        }
        if (isMapTouchLocked()) {
            return;
        }
        for (SceneMapEvent.SceneMapListener sceneMapListener : this.mSceneMapListeners) {
            sceneMapListener.onMapEvent(SceneMapEvent.obtainMove());
        }
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onLongPress(long j, long j2, long j3) {
        PointD screenToMap;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onLongPress: engineId = [" + j + "], px = [" + j2 + "], py = [" + j3 + "]");
        }
        if (isMapTouchLocked()) {
            return;
        }
        for (SceneMapEvent.SceneMapListener sceneMapListener : this.mSceneMapListeners) {
            sceneMapListener.onMapEvent(SceneMapEvent.obtainLongPress(j2, j3));
        }
        this.mMapPresenter.onLongPress(j2, j3);
        MapViewWrapper mapViewWrapper = this.mMapPresenter.mMapViewWrapper;
        if (mapViewWrapper == null || mapViewWrapper.isLaneMode() || (screenToMap = mapViewWrapper.screenToMap(j2, j3)) == null) {
            return;
        }
        this.mMapPresenter.showRgcPoiPop(isMapPoiLocked(), (int) screenToMap.x, (int) screenToMap.y);
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public boolean onDoublePress(long j, long j2, long j3) {
        if (isMapTouchLocked()) {
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public boolean onSinglePress(long j, long j2, long j3, boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onSinglePress: engineId = [" + j + "], px = [" + j2 + "], py = [" + j3 + "]");
        }
        if (isMapTouchLocked()) {
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onSliding(long j, float f, float f2) {
        if (isMapTouchLocked()) {
        }
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapCenterChanged(long j, double d, double d2) {
        doMapCenterChanged(j, d, d2);
        if (TBTManager.getInstance().isMiniMapEnable()) {
            RootUtil.updateMapOperationTimeTick();
        }
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapLevelChanged(long j, boolean z) {
        doMapLevelChanged(true);
        if (TBTManager.getInstance().isMiniMapEnable()) {
            RootUtil.updateMapOperationTimeTick();
        }
        OddDataHelper.getInstance().onMapLevelChange();
    }

    private void doMapLevelChanged(final boolean z) {
        synchronized (this.mMapLevelChangedSubjectLock) {
            if (this.mMapLevelChangedSubject != null) {
                this.mMapLevelChangedSubject.onNext(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.CustomMapListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        CustomMapListener.this.mMapPresenter.onMapLevelChanged(false, z);
                        for (SceneMapEvent.SceneMapListener sceneMapListener : CustomMapListener.this.mSceneMapListeners) {
                            sceneMapListener.onMapEvent(SceneMapEvent.obtainMapLevelChanged());
                        }
                    }
                });
            }
        }
        this.mMapPresenter.onMapLevelChanged(true, z);
    }

    private void doMapCenterChanged(final long j, final double d, final double d2) {
        synchronized (this.mMapCenterChangedSubjectLock) {
            if (this.mMapCenterChangedSubject != null) {
                this.mMapCenterChangedSubject.onNext(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.CustomMapListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (L.ENABLE) {
                            L.Tag tag = CustomMapListener.TAG;
                            L.d(tag, "onMapCenterChanged: engineId = [" + j + "], px = [" + d + "], py = [" + d2 + "]");
                        }
                        CustomMapListener.this.mMapPresenter.onMapCenterChanged(d, d2, false);
                        for (SceneMapEvent.SceneMapListener sceneMapListener : CustomMapListener.this.mSceneMapListeners) {
                            sceneMapListener.onMapEvent(SceneMapEvent.obtainMapCenterChanged(d, d2));
                        }
                    }
                });
            }
        }
        this.mMapPresenter.onMapCenterChanged(d, d2, true);
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapModeChanged(long j, int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onMapModeChanged: engineId = [" + j + "], view mode = [" + i + "]");
        }
        this.mMapPresenter.onMapModeChanged(i);
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapPreviewEnter(long j) {
        this.mMapPresenter.setFollowMode(false);
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapPreviewExit(long j) {
        if (this.mMapPresenter.getCurrentSceneMode().equals(StatusConst.Mode.ROUTE)) {
            this.mMapPresenter.setFollowMode(false);
        } else {
            this.mMapPresenter.setFollowMode(true);
        }
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onClickLabel(long j, ArrayList<MapLabelItem> arrayList) {
        if (L.ENABLE && arrayList != null) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("CustomMapListener.onClickLabel: ");
            sb.append(arrayList.size());
            sb.append((arrayList.size() <= 0 || arrayList.get(0) == null) ? "name" : arrayList.get(0).name);
            L.d(tag, sb.toString());
        }
        if (isMapTouchLocked()) {
            return;
        }
        MapViewWrapper mapViewWrapper = this.mMapPresenter.mMapViewWrapper;
        if ((mapViewWrapper == null || !mapViewWrapper.isLaneMode()) && arrayList != null && arrayList.size() > 0) {
            this.mMapPresenter.onMapLabelClick(arrayList, isMapPoiLocked());
        }
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onClickBlank(long j, float f, float f2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onClickBlank: " + f + ", " + f2);
        }
        if (isMapTouchLocked()) {
            return;
        }
        this.mMapPresenter.collapsePoiDecorator();
        this.mMapPresenter.notifyOnClickBlank(j, f, f2);
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onRenderMap(final long j, int i) {
        if (!this.mIsLaneServiceAttachInvoked && i > 0 && CarServiceManager.getInstance().hasXpuForNgp()) {
            this.mIsLaneServiceAttachInvoked = true;
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.CustomMapListener.4
                @Override // java.lang.Runnable
                public void run() {
                    LaneServiceManager.getInstance().attachToMapView(j);
                }
            });
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (2 == i && sDump) {
            sDump = false;
            RootUtil.dumpOpenGLBuffer();
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 8000) {
            L.Tag tag = TAG;
            L.i(tag, "onRenderMap cost " + currentTimeMillis2 + " ms to render");
        }
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapAnimationFinished(long j, long j2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onMapAnimationFinished: " + j2);
        }
        this.mMapPresenter.onMapAnimationFinished(j2);
    }

    @Override // com.xiaopeng.montecarlo.navcore.IMapListener
    public void onMapFollowModeChanged(boolean z) {
        this.mMapPresenter.updateRecenterStatus();
    }

    @Override // com.xiaopeng.montecarlo.navcore.IMapListener
    public void onCarOutOfScreen() {
        this.mMapPresenter.updateRecenterStatus();
    }

    @Override // com.xiaopeng.montecarlo.navcore.IMapListener
    public void onFreeTrafficLayerStateUpdate(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onFreeTrafficLayerStateUpdate: " + z);
        }
        this.mMapPresenter.onFreeTrafficLayerStateUpdate(z);
    }
}
