package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.router.BLMapBusinessDataObserverRouter;
@IntfAuto(target = BLMapBusinessDataObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IBLMapBusinessDataObserver {
    boolean onBusinessDataObserver(int i, long j, long j2);
}
