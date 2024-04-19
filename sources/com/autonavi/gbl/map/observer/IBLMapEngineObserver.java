package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.MapFuncActiveParam;
import com.autonavi.gbl.map.router.BLMapEngineObserverRouter;
@IntfAuto(target = BLMapEngineObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IBLMapEngineObserver {
    void onMapAnimationFinished(long j);

    void onMapFunctionActivity(long j, MapFuncActiveParam mapFuncActiveParam);

    void onMapOfflineError(long j, String str, int i);

    void onMapOrthoRender(long j);

    void onMapRender(long j, int i);

    void onMapTransferParam(long j, int[] iArr);

    void onMapViewDestroyed(long j);
}
