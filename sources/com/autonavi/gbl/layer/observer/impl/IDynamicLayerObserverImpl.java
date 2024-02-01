package com.autonavi.gbl.layer.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.DynamicLayerObserverParam;
import com.autonavi.gbl.layer.observer.IDynamicLayerObserver;
@IntfAuto(target = IDynamicLayerObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IDynamicLayerObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IDynamicLayerObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IDynamicLayerObserverImpl_change_ownership(IDynamicLayerObserverImpl iDynamicLayerObserverImpl, long j, boolean z);

    private static native void IDynamicLayerObserverImpl_director_connect(IDynamicLayerObserverImpl iDynamicLayerObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native float getPointMarkerScaleFactorNative(long j, IDynamicLayerObserverImpl iDynamicLayerObserverImpl);

    private static native float getPointMarkerScaleFactorSwigExplicitIDynamicLayerObserverImplNative(long j, IDynamicLayerObserverImpl iDynamicLayerObserverImpl);

    private static native boolean isNightModeNative(long j, IDynamicLayerObserverImpl iDynamicLayerObserverImpl);

    private static native boolean isNightModeSwigExplicitIDynamicLayerObserverImplNative(long j, IDynamicLayerObserverImpl iDynamicLayerObserverImpl);

    private static native void onFocusChangeNative(long j, IDynamicLayerObserverImpl iDynamicLayerObserverImpl, long j2, DynamicLayerObserverParam dynamicLayerObserverParam, boolean z);

    private static native void onFocusChangeSwigExplicitIDynamicLayerObserverImplNative(long j, IDynamicLayerObserverImpl iDynamicLayerObserverImpl, long j2, DynamicLayerObserverParam dynamicLayerObserverParam, boolean z);

    private static native void onNotifyClickNative(long j, IDynamicLayerObserverImpl iDynamicLayerObserverImpl, long j2, DynamicLayerObserverParam dynamicLayerObserverParam);

    private static native void onNotifyClickSwigExplicitIDynamicLayerObserverImplNative(long j, IDynamicLayerObserverImpl iDynamicLayerObserverImpl, long j2, DynamicLayerObserverParam dynamicLayerObserverParam);

    public IDynamicLayerObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IDynamicLayerObserverImpl) && getUID(this) == getUID((IDynamicLayerObserverImpl) obj);
    }

    private static long getUID(IDynamicLayerObserverImpl iDynamicLayerObserverImpl) {
        long cPtr = getCPtr(iDynamicLayerObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDynamicLayerObserverImpl iDynamicLayerObserverImpl) {
        if (iDynamicLayerObserverImpl == null) {
            return 0L;
        }
        return iDynamicLayerObserverImpl.swigCPtr;
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
        IDynamicLayerObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IDynamicLayerObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public IDynamicLayerObserverImpl() {
        this(createNativeObj(), true);
        LayerObserverJNI.swig_jni_init();
        IDynamicLayerObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public float getPointMarkerScaleFactor() {
        if (this.swigCPtr != 0) {
            return getClass() == IDynamicLayerObserverImpl.class ? getPointMarkerScaleFactorNative(this.swigCPtr, this) : getPointMarkerScaleFactorSwigExplicitIDynamicLayerObserverImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public boolean isNightMode() {
        if (this.swigCPtr != 0) {
            return getClass() == IDynamicLayerObserverImpl.class ? isNightModeNative(this.swigCPtr, this) : isNightModeSwigExplicitIDynamicLayerObserverImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void onNotifyClick(DynamicLayerObserverParam dynamicLayerObserverParam) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IDynamicLayerObserverImpl.class) {
            onNotifyClickNative(this.swigCPtr, this, 0L, dynamicLayerObserverParam);
        } else {
            onNotifyClickSwigExplicitIDynamicLayerObserverImplNative(this.swigCPtr, this, 0L, dynamicLayerObserverParam);
        }
    }

    public void onFocusChange(DynamicLayerObserverParam dynamicLayerObserverParam, boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IDynamicLayerObserverImpl.class) {
            onFocusChangeNative(this.swigCPtr, this, 0L, dynamicLayerObserverParam, z);
        } else {
            onFocusChangeSwigExplicitIDynamicLayerObserverImplNative(this.swigCPtr, this, 0L, dynamicLayerObserverParam, z);
        }
    }
}
