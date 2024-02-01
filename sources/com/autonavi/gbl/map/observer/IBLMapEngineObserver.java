package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.MapFuncActiveParam;
import com.autonavi.gbl.map.router.BLMapEngineObserverRouter;
@IntfAuto(target = BLMapEngineObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IBLMapEngineObserver {
    default void onMapAnimationFinished(long j) {
    }

    default void onMapFunctionActivity(long j, MapFuncActiveParam mapFuncActiveParam) {
    }

    default void onMapOfflineError(long j, String str, int i) {
    }

    default void onMapOrthoRender(long j) {
    }

    default void onMapRender(long j, int i) {
    }

    default void onMapTransferParam(long j, int[] iArr) {
    }

    default void onMapViewDestroyed(long j) {
    }
}
