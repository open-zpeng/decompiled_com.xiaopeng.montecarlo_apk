package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.GestureAction;
import com.autonavi.gbl.map.router.MapGestureObserverRouter;
@IntfAuto(target = MapGestureObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IMapGestureObserver {
    boolean onDoublePress(long j, long j2, long j3);

    void onLongPress(long j, long j2, long j3);

    void onMotionEvent(long j, @GestureAction.GestureAction1 int i, long j2, long j3);

    void onMove(long j, long j2, long j3);

    void onMoveBegin(long j, long j2, long j3);

    void onMoveEnd(long j, long j2, long j3);

    void onMoveLocked(long j);

    void onPinchLocked(long j);

    void onScaleRotate(long j, long j2, long j3);

    void onScaleRotateBegin(long j, long j2, long j3);

    void onScaleRotateEnd(long j, long j2, long j3);

    boolean onSinglePress(long j, long j2, long j3, boolean z);

    void onSliding(long j, float f, float f2);
}
