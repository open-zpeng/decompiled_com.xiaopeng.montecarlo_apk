package com.autonavi.gbl.map.layer.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
@IntfAuto(target = ILayerClickObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILayerClickObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ILayerClickObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILayerClickObserverImpl_change_ownership(ILayerClickObserverImpl iLayerClickObserverImpl, long j, boolean z);

    private static native void ILayerClickObserverImpl_director_connect(ILayerClickObserverImpl iLayerClickObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onAfterNotifyClickNative(long j, ILayerClickObserverImpl iLayerClickObserverImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ClickViewIdInfo clickViewIdInfo);

    private static native void onAfterNotifyClickSwigExplicitILayerClickObserverImplNative(long j, ILayerClickObserverImpl iLayerClickObserverImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ClickViewIdInfo clickViewIdInfo);

    private static native void onBeforeNotifyClickNative(long j, ILayerClickObserverImpl iLayerClickObserverImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ClickViewIdInfo clickViewIdInfo);

    private static native void onBeforeNotifyClickSwigExplicitILayerClickObserverImplNative(long j, ILayerClickObserverImpl iLayerClickObserverImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ClickViewIdInfo clickViewIdInfo);

    private static native void onNotifyClickNative(long j, ILayerClickObserverImpl iLayerClickObserverImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ClickViewIdInfo clickViewIdInfo);

    public ILayerClickObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILayerClickObserverImpl) && getUID(this) == getUID((ILayerClickObserverImpl) obj);
    }

    private static long getUID(ILayerClickObserverImpl iLayerClickObserverImpl) {
        long cPtr = getCPtr(iLayerClickObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILayerClickObserverImpl iLayerClickObserverImpl) {
        if (iLayerClickObserverImpl == null) {
            return 0L;
        }
        return iLayerClickObserverImpl.swigCPtr;
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
        ILayerClickObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILayerClickObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onBeforeNotifyClick(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ClickViewIdInfo clickViewIdInfo) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == ILayerClickObserverImpl.class) {
            onBeforeNotifyClickNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, ClickViewIdInfo.getCPtr(clickViewIdInfo), clickViewIdInfo);
        } else {
            onBeforeNotifyClickSwigExplicitILayerClickObserverImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, ClickViewIdInfo.getCPtr(clickViewIdInfo), clickViewIdInfo);
        }
    }

    public void onNotifyClick(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ClickViewIdInfo clickViewIdInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onNotifyClickNative(j, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, ClickViewIdInfo.getCPtr(clickViewIdInfo), clickViewIdInfo);
    }

    public void onAfterNotifyClick(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ClickViewIdInfo clickViewIdInfo) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == ILayerClickObserverImpl.class) {
            onAfterNotifyClickNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, ClickViewIdInfo.getCPtr(clickViewIdInfo), clickViewIdInfo);
        } else {
            onAfterNotifyClickSwigExplicitILayerClickObserverImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, ClickViewIdInfo.getCPtr(clickViewIdInfo), clickViewIdInfo);
        }
    }

    public ILayerClickObserverImpl() {
        this(createNativeObj(), true);
        MapLayerObserverJNI.swig_jni_init();
        ILayerClickObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
