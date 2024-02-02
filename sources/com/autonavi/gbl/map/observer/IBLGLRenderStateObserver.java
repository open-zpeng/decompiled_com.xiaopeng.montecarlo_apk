package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.router.BLGLRenderStateObserverRouter;
@IntfAuto(target = BLGLRenderStateObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IBLGLRenderStateObserver {
    void onMapGLRender(long j, int i);
}
