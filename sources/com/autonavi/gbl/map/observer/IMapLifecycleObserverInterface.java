package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.MapDevice;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.router.MapLifecycleObserverInterfaceRouter;
@IntfAuto(target = MapLifecycleObserverInterfaceRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IMapLifecycleObserverInterface {
    void beforeEGLDeviceCreate(MapDevice mapDevice);

    void beforeEGLMapViewCreate(MapView mapView);
}
