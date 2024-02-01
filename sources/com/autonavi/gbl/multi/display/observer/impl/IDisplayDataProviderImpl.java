package com.autonavi.gbl.multi.display.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.DAY_STATUS;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
import com.autonavi.gbl.map.model.MapSkyboxParam;
import com.autonavi.gbl.multi.display.model.DisplayType;
import com.autonavi.gbl.multi.display.observer.IDisplayDataProvider;
@IntfAuto(target = IDisplayDataProvider.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IDisplayDataProviderImpl {
    private static BindTable BIND_TABLE = new BindTable(IDisplayDataProviderImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IDisplayDataProviderImpl_change_ownership(IDisplayDataProviderImpl iDisplayDataProviderImpl, long j, boolean z);

    private static native void IDisplayDataProviderImpl_director_connect(IDisplayDataProviderImpl iDisplayDataProviderImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int onFetchDeviceAttrNative(long j, IDisplayDataProviderImpl iDisplayDataProviderImpl, int i, long j2, DeviceAttribute deviceAttribute);

    private static native int onFetchSkyBoxNative(long j, IDisplayDataProviderImpl iDisplayDataProviderImpl, int i, int i2, long j2, MapSkyboxParam mapSkyboxParam);

    private static native int onFetchSurfaceAttrNative(long j, IDisplayDataProviderImpl iDisplayDataProviderImpl, int i, long j2, EGLSurfaceAttr eGLSurfaceAttr);

    public IDisplayDataProviderImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IDisplayDataProviderImpl) && getUID(this) == getUID((IDisplayDataProviderImpl) obj);
    }

    private static long getUID(IDisplayDataProviderImpl iDisplayDataProviderImpl) {
        long cPtr = getCPtr(iDisplayDataProviderImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDisplayDataProviderImpl iDisplayDataProviderImpl) {
        if (iDisplayDataProviderImpl == null) {
            return 0L;
        }
        return iDisplayDataProviderImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        IDisplayDataProviderImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IDisplayDataProviderImpl_change_ownership(this, this.swigCPtr, true);
    }

    public IDisplayDataProviderImpl() {
        this(createNativeObj(), true);
        MultiDisplayObserverJNI.swig_jni_init();
        IDisplayDataProviderImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public int onFetchDeviceAttr(@DisplayType.DisplayType1 int i, DeviceAttribute deviceAttribute) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onFetchDeviceAttrNative(j, this, i, 0L, deviceAttribute);
    }

    public int onFetchSurfaceAttr(@DisplayType.DisplayType1 int i, EGLSurfaceAttr eGLSurfaceAttr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onFetchSurfaceAttrNative(j, this, i, 0L, eGLSurfaceAttr);
    }

    public int onFetchSkyBox(@DisplayType.DisplayType1 int i, @DAY_STATUS.DAY_STATUS1 int i2, MapSkyboxParam mapSkyboxParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onFetchSkyBoxNative(j, this, i, i2, 0L, mapSkyboxParam);
    }
}
