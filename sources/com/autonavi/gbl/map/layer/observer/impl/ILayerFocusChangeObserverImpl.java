package com.autonavi.gbl.map.layer.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver;
@IntfAuto(target = ILayerFocusChangeObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILayerFocusChangeObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ILayerFocusChangeObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILayerFocusChangeObserverImpl_change_ownership(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl, long j, boolean z);

    private static native void ILayerFocusChangeObserverImpl_director_connect(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onNotifyFocusChangeNative(long j, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, boolean z);

    public ILayerFocusChangeObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILayerFocusChangeObserverImpl) && getUID(this) == getUID((ILayerFocusChangeObserverImpl) obj);
    }

    private static long getUID(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        long cPtr = getCPtr(iLayerFocusChangeObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        if (iLayerFocusChangeObserverImpl == null) {
            return 0L;
        }
        return iLayerFocusChangeObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
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
        ILayerFocusChangeObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILayerFocusChangeObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onNotifyFocusChange(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onNotifyFocusChangeNative(j, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, z);
    }

    public ILayerFocusChangeObserverImpl() {
        this(createNativeObj(), true);
        MapLayerObserverJNI.swig_jni_init();
        ILayerFocusChangeObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
