package com.xiaopeng.montecarlo.service.minimap;

import com.autonavi.gbl.map.model.IndoorBuilding;
import com.autonavi.gbl.map.model.MapLabelItem;
import com.autonavi.gbl.map.model.MapRoadTip;
import com.autonavi.gbl.map.model.ScenicInfo;
import com.autonavi.gbl.map.model.ScreenShotDataInfo;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.sr.LaneServiceManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MiniMapListener implements IMapListener {
    private boolean mIsInitLaneServiceInvoked = false;
    private MiniMapServiceHelper mMiniMapServiceHelper;

    @Override // com.xiaopeng.montecarlo.navcore.IMapListener
    public void onCarOutOfScreen() {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onCheckIngDataRenderComplete(long j, long j2) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onClickBlank(long j, float f, float f2) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onClickLabel(long j, ArrayList<MapLabelItem> arrayList) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public boolean onDoublePress(long j, long j2, long j3) {
        return false;
    }

    @Override // com.autonavi.gbl.map.observer.IEGLScreenshotObserver
    public void onEGLScreenshot(int i, byte[] bArr, ScreenShotDataInfo screenShotDataInfo, int i2, long j) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.IMapListener
    public void onFreeTrafficLayerStateUpdate(boolean z) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onIndoorBuildingActivity(long j, IndoorBuilding indoorBuilding) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onLongPress(long j, long j2, long j3) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapAnimationFinished(long j, long j2) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapCenterChanged(long j, double d, double d2) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.IMapListener
    public void onMapFollowModeChanged(boolean z) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapHeatActive(long j, boolean z) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapLevelChanged(long j, boolean z) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapPreviewEnter(long j) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapPreviewExit(long j) {
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

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onMotionEvent(long j, int i, long j2, long j3) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMotionFinished(long j, int i) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onMove(long j, long j2, long j3) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onMoveBegin(long j, long j2, long j3) {
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onMoveEnd(long j, long j2, long j3) {
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

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public boolean onSinglePress(long j, long j2, long j3, boolean z) {
        return false;
    }

    @Override // com.autonavi.gbl.map.observer.IMapGestureObserver
    public void onSliding(long j, float f, float f2) {
    }

    public MiniMapListener(MiniMapServiceHelper miniMapServiceHelper) {
        this.mMiniMapServiceHelper = miniMapServiceHelper;
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onMapModeChanged(long j, int i) {
        MiniMapServiceHelper miniMapServiceHelper = this.mMiniMapServiceHelper;
        if (miniMapServiceHelper != null) {
            miniMapServiceHelper.onMapModeChanged(i);
        }
    }

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    public void onRenderMap(final long j, int i) {
        if (this.mIsInitLaneServiceInvoked || i <= 0 || !CarServiceManager.getInstance().hasXpuForNgp()) {
            return;
        }
        this.mIsInitLaneServiceInvoked = true;
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapListener.1
            @Override // java.lang.Runnable
            public void run() {
                LaneServiceManager.getInstance().attachToMapView(j);
            }
        });
    }
}
