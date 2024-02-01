package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.router.MapEventObserverRouter;
@IntfAuto(target = MapEventObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IMapEventObserver {
    boolean onMapMoveEnd();

    boolean onMapMoveStart();
}
