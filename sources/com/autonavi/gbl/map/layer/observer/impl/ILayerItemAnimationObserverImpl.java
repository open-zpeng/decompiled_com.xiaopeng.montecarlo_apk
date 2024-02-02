package com.autonavi.gbl.map.layer.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.AnimationEvent;
import com.autonavi.gbl.map.layer.observer.ILayerItemAnimationObserver;
@IntfAuto(target = ILayerItemAnimationObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILayerItemAnimationObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ILayerItemAnimationObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILayerItemAnimationObserverImpl_change_ownership(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl, long j, boolean z);

    private static native void ILayerItemAnimationObserverImpl_director_connect(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onProcessAnimationEventNative(long j, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, AnimationEvent animationEvent);

    public ILayerItemAnimationObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILayerItemAnimationObserverImpl) && getUID(this) == getUID((ILayerItemAnimationObserverImpl) obj);
    }

    private static long getUID(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        long cPtr = getCPtr(iLayerItemAnimationObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        if (iLayerItemAnimationObserverImpl == null) {
            return 0L;
        }
        return iLayerItemAnimationObserverImpl.swigCPtr;
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
        ILayerItemAnimationObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILayerItemAnimationObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onProcessAnimationEvent(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, AnimationEvent animationEvent) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onProcessAnimationEventNative(j, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, animationEvent);
    }

    public ILayerItemAnimationObserverImpl() {
        this(createNativeObj(), true);
        MapLayerObserverJNI.swig_jni_init();
        ILayerItemAnimationObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
