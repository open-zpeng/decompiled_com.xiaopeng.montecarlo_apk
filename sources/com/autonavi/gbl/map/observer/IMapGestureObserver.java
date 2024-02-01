package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.GestureAction;
import com.autonavi.gbl.map.router.MapGestureObserverRouter;
@IntfAuto(target = MapGestureObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IMapGestureObserver {
    boolean onDoublePress(long j, long j2, long j3);

    default void onLongPress(long j, long j2, long j3) {
    }

    default void onMotionEvent(long j, @GestureAction.GestureAction1 int i, long j2, long j3) {
    }

    default void onMove(long j, long j2, long j3) {
    }

    default void onMoveBegin(long j, long j2, long j3) {
    }

    default void onMoveEnd(long j, long j2, long j3) {
    }

    default void onMoveLocked(long j) {
    }

    default void onPinchLocked(long j) {
    }

    default void onScaleRotate(long j, long j2, long j3) {
    }

    default void onScaleRotateBegin(long j, long j2, long j3) {
    }

    default void onScaleRotateEnd(long j, long j2, long j3) {
    }

    boolean onSinglePress(long j, long j2, long j3, boolean z);

    default void onSliding(long j, float f, float f2) {
    }
}
