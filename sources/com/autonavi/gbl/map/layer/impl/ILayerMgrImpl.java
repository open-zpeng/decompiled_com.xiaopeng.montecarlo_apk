package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.LayerMgr;
import com.autonavi.gbl.map.layer.model.ScaleInfo;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = LayerMgr.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ILayerMgrImpl {
    private static BindTable BIND_TABLE = new BindTable(ILayerMgrImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addLayerNative(long j, ILayerMgrImpl iLayerMgrImpl, long j2, BaseLayerImpl baseLayerImpl);

    private static native void destroyNativeObj(long j);

    private static native ArrayList<BaseLayerImpl> getAllLayersNative(long j, ILayerMgrImpl iLayerMgrImpl);

    private static native long getLayerByIDNative(long j, ILayerMgrImpl iLayerMgrImpl, BigInteger bigInteger);

    private static native void removeLayerNative(long j, ILayerMgrImpl iLayerMgrImpl, long j2, BaseLayerImpl baseLayerImpl);

    private static native void setAllPointLayerItemsScaleNative(long j, ILayerMgrImpl iLayerMgrImpl, long j2, ScaleInfo scaleInfo);

    private static native void sortAllLayerNative(long j, ILayerMgrImpl iLayerMgrImpl);

    private static native void updateStyleNative(long j, ILayerMgrImpl iLayerMgrImpl);

    public ILayerMgrImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILayerMgrImpl) && getUID(this) == getUID((ILayerMgrImpl) obj);
    }

    private static long getUID(ILayerMgrImpl iLayerMgrImpl) {
        long cPtr = getCPtr(iLayerMgrImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILayerMgrImpl iLayerMgrImpl) {
        if (iLayerMgrImpl == null) {
            return 0L;
        }
        return iLayerMgrImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void addLayer(BaseLayerImpl baseLayerImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addLayerNative(j, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl);
    }

    public void removeLayer(BaseLayerImpl baseLayerImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeLayerNative(j, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl);
    }

    public BaseLayerImpl getLayerByID(BigInteger bigInteger) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long layerByIDNative = getLayerByIDNative(j, this, bigInteger);
        if (layerByIDNative == 0) {
            return null;
        }
        return new BaseLayerImpl(layerByIDNative, false);
    }

    public ArrayList<BaseLayerImpl> getAllLayers() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAllLayersNative(j, this);
    }

    public void updateStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateStyleNative(j, this);
    }

    public void sortAllLayer() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        sortAllLayerNative(j, this);
    }

    public void setAllPointLayerItemsScale(ScaleInfo scaleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setAllPointLayerItemsScaleNative(j, this, 0L, scaleInfo);
    }
}
