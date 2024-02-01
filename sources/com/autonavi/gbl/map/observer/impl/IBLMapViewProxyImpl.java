package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.observer.IBLMapViewProxy;
@IntfAuto(target = IBLMapViewProxy.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBLMapViewProxyImpl extends IBLMapEngineProxyImpl {
    private static BindTable BIND_TABLE = new BindTable(IBLMapViewProxyImpl.class);
    private transient long swigCPtr;

    private static native long IBLMapViewProxyImpl_SWIGUpcast(long j);

    private static native void IBLMapViewProxyImpl_change_ownership(IBLMapViewProxyImpl iBLMapViewProxyImpl, long j, boolean z);

    private static native void IBLMapViewProxyImpl_director_connect(IBLMapViewProxyImpl iBLMapViewProxyImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void reloadMapResourceNative(long j, IBLMapViewProxyImpl iBLMapViewProxyImpl, long j2, byte[] bArr, int i);

    private static native void requireMapRenderNative(long j, IBLMapViewProxyImpl iBLMapViewProxyImpl, long j2, int i, int i2);

    private static native void requireMapRenderSwigExplicitIBLMapViewProxyImplNative(long j, IBLMapViewProxyImpl iBLMapViewProxyImpl, long j2, int i, int i2);

    public IBLMapViewProxyImpl(long j, boolean z) {
        super(IBLMapViewProxyImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public boolean equals(Object obj) {
        if (obj instanceof IBLMapViewProxyImpl) {
            return getUID(this) == getUID((IBLMapViewProxyImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBLMapViewProxyImpl iBLMapViewProxyImpl) {
        long cPtr = getCPtr(iBLMapViewProxyImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBLMapViewProxyImpl iBLMapViewProxyImpl) {
        if (iBLMapViewProxyImpl == null) {
            return 0L;
        }
        return iBLMapViewProxyImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        IBLMapViewProxyImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IBLMapViewProxyImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void reloadMapResource(long j, byte[] bArr, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        reloadMapResourceNative(j2, this, j, bArr, i);
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public void requireMapRender(long j, int i, int i2) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IBLMapViewProxyImpl.class) {
            requireMapRenderNative(this.swigCPtr, this, j, i, i2);
        } else {
            requireMapRenderSwigExplicitIBLMapViewProxyImplNative(this.swigCPtr, this, j, i, i2);
        }
    }

    public IBLMapViewProxyImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IBLMapViewProxyImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
