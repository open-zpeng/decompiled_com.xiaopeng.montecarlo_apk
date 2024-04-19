package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.router.MapFpsObserverRouter;
@IntfAuto(target = MapFpsObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IMapFpsObserver {
    void onMapRenderConfigFps(int i, int i2);

    void onMapRenderRealFps(int i, int i2, int i3);

    void onMapRenderTimeOut(int i, int i2, int i3);
}
