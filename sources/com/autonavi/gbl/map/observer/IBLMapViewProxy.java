package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.router.BLMapViewProxyRouter;
@IntfAuto(target = BLMapViewProxyRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IBLMapViewProxy extends IBLMapEngineProxy {
    void reloadMapResource(long j, byte[] bArr, int i);

    @Override // com.autonavi.gbl.map.observer.IBLMapEngineProxy
    void requireMapRender(long j, int i, int i2);
}
