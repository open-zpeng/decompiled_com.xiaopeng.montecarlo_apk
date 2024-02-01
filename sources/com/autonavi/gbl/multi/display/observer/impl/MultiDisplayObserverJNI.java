package com.autonavi.gbl.multi.display.observer.impl;

import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.model.ChannelMessageType;
import com.autonavi.gbl.map.model.DAY_STATUS;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
import com.autonavi.gbl.map.model.MapSkyboxParam;
import com.autonavi.gbl.multi.display.impl.IDisplayCropImpl;
import com.autonavi.gbl.multi.display.impl.IDisplayImpl;
import com.autonavi.gbl.multi.display.model.DisplayType;
/* loaded from: classes2.dex */
public class MultiDisplayObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static int SwigDirector_IDisplayDataProviderImpl_onFetchDeviceAttr(IDisplayDataProviderImpl iDisplayDataProviderImpl, @DisplayType.DisplayType1 int i, DeviceAttribute deviceAttribute) {
        return iDisplayDataProviderImpl.onFetchDeviceAttr(i, deviceAttribute);
    }

    public static int SwigDirector_IDisplayDataProviderImpl_onFetchSurfaceAttr(IDisplayDataProviderImpl iDisplayDataProviderImpl, @DisplayType.DisplayType1 int i, EGLSurfaceAttr eGLSurfaceAttr) {
        return iDisplayDataProviderImpl.onFetchSurfaceAttr(i, eGLSurfaceAttr);
    }

    public static int SwigDirector_IDisplayDataProviderImpl_onFetchSkyBox(IDisplayDataProviderImpl iDisplayDataProviderImpl, @DisplayType.DisplayType1 int i, @DAY_STATUS.DAY_STATUS1 int i2, MapSkyboxParam mapSkyboxParam) {
        return iDisplayDataProviderImpl.onFetchSkyBox(i, i2, mapSkyboxParam);
    }

    public static void SwigDirector_IRemoteDisplayObserverImpl_onRemoteDisplayCreated(IRemoteDisplayObserverImpl iRemoteDisplayObserverImpl, int i, @DisplayType.DisplayType1 int i2) {
        iRemoteDisplayObserverImpl.onRemoteDisplayCreated(i, i2);
    }

    public static void SwigDirector_IRemoteDisplayObserverImpl_onRemoteDisplayDestroyed(IRemoteDisplayObserverImpl iRemoteDisplayObserverImpl, int i, @DisplayType.DisplayType1 int i2) {
        iRemoteDisplayObserverImpl.onRemoteDisplayDestroyed(i, i2);
    }

    public static void SwigDirector_IMapDisplayObserverImpl_onDisplayCreated(IMapDisplayObserverImpl iMapDisplayObserverImpl, int i, @DisplayType.DisplayType1 int i2) {
        iMapDisplayObserverImpl.onDisplayCreated(i, i2);
    }

    public static void SwigDirector_IMapDisplayObserverImpl_onDisplayCropCustom(IMapDisplayObserverImpl iMapDisplayObserverImpl, IDisplayImpl iDisplayImpl, IDisplayCropImpl iDisplayCropImpl) {
        iMapDisplayObserverImpl.onDisplayCropCustom(iDisplayImpl, iDisplayCropImpl);
    }

    public static void SwigDirector_IMapDisplayObserverImpl_onMapFirstPaint(IMapDisplayObserverImpl iMapDisplayObserverImpl, int i, @DisplayType.DisplayType1 int i2) {
        iMapDisplayObserverImpl.onMapFirstPaint(i, i2);
    }

    public static void SwigDirector_IMapDisplayObserverImpl_onMainDisplayCreated(IMapDisplayObserverImpl iMapDisplayObserverImpl, int i) {
        iMapDisplayObserverImpl.onMainDisplayCreated(i);
    }

    public static void SwigDirector_IMapDisplayObserverImpl_beforeEGLDevCreated(IMapDisplayObserverImpl iMapDisplayObserverImpl, IDisplayImpl iDisplayImpl) {
        iMapDisplayObserverImpl.beforeEGLDevCreated(iDisplayImpl);
    }

    public static void SwigDirector_IMapDisplayObserverImpl_beforeEGLMapCreated(IMapDisplayObserverImpl iMapDisplayObserverImpl, IDisplayImpl iDisplayImpl) {
        iMapDisplayObserverImpl.beforeEGLMapCreated(iDisplayImpl);
    }

    public static void SwigDirector_IMapDisplayObserverImpl_onMapDoRender(IMapDisplayObserverImpl iMapDisplayObserverImpl, int i, @DisplayType.DisplayType1 int i2) {
        iMapDisplayObserverImpl.onMapDoRender(i, i2);
    }

    public static boolean SwigDirector_IMapDisplayObserverImpl_onCheckSyncAllowed(IMapDisplayObserverImpl iMapDisplayObserverImpl, int i, int i2, int i3) {
        return iMapDisplayObserverImpl.onCheckSyncAllowed(i, i2, i3);
    }

    public static boolean SwigDirector_IMapDisplayObserverImpl_onProcessCustomInComeMsg(IMapDisplayObserverImpl iMapDisplayObserverImpl, int i, @ChannelMessageType.ChannelMessageType1 int i2, int i3, ChannelParcelImpl channelParcelImpl) {
        return iMapDisplayObserverImpl.onProcessCustomInComeMsg(i, i2, i3, channelParcelImpl);
    }
}
