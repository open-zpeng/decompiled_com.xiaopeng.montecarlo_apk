package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.EGLColorBits;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.EGLDeviceRenderStatus;
import com.autonavi.gbl.map.router.DeviceObserverRouter;
@IntfAuto(target = DeviceObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IDeviceObserver {
    default void onDeviceCreated(int i) {
    }

    default void onDeviceDestroyed(int i) {
    }

    default void onDeviceRender(int i, @EGLDeviceRenderStatus.EGLDeviceRenderStatus1 int i2) {
    }

    default void onEGLDoRender(@EGLDeviceID.EGLDeviceID1 int i) {
    }

    default void onSurfaceChanged(int i, int i2, int i3, @EGLColorBits.EGLColorBits1 int i4) {
    }

    default void onSurfaceCreated(int i, int i2, int i3, @EGLColorBits.EGLColorBits1 int i4) {
    }

    default void onSurfaceDestroyed(int i, int i2, int i3, @EGLColorBits.EGLColorBits1 int i4) {
    }
}
