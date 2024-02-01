package com.autonavi.gbl.layer.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.card.model.CustomTextureParam;
import com.autonavi.gbl.layer.model.PrepareLayerMarkerParam;
import com.autonavi.gbl.layer.observer.PrepareLayerParam;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.model.MapEngineID;
@IntfAuto(target = PrepareLayerParam.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPrepareLayerParamImpl {
    private static BindTable BIND_TABLE = new BindTable(IPrepareLayerParamImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPrepareLayerParamImpl_change_ownership(IPrepareLayerParamImpl iPrepareLayerParamImpl, long j, boolean z);

    private static native void IPrepareLayerParamImpl_director_connect(IPrepareLayerParamImpl iPrepareLayerParamImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i);

    private static native void destroyNativeObj(long j);

    private static native int get3DModelIdNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, String str);

    private static native int get3DModelIdSwigExplicitIPrepareLayerParamImplNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, String str);

    private static native boolean getNewStaticMarkerIdNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ItemStyleInfo itemStyleInfo, String[] strArr);

    private static native boolean getNewStaticMarkerIdSwigExplicitIPrepareLayerParamImplNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ItemStyleInfo itemStyleInfo, String[] strArr);

    private static native float getPointMarkerScaleFactorNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl);

    private static native boolean getPrepareLayerParamNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl, long j2, LayerItemImpl layerItemImpl, long j3, PrepareLayerMarkerParam prepareLayerMarkerParam);

    private static native boolean getPrepareLayerParamSwigExplicitIPrepareLayerParamImplNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl, long j2, LayerItemImpl layerItemImpl, long j3, PrepareLayerMarkerParam prepareLayerMarkerParam);

    private static native float getRouteWidthScaleFactorNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl, int i);

    private static native boolean isDynamicMarkerNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl, String str);

    private static native boolean isEnglishNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl);

    private static native boolean isInForegroundNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl);

    private static native boolean isNightModeNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl);

    private static native boolean isRouteCacheStyleEnabledNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl);

    private static native boolean isRouteStyleNightModeNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl);

    private static native boolean isStaticMarkerNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl, String str);

    private static native boolean updateCardContentNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ItemStyleInfo itemStyleInfo, long j5, CustomTextureParam customTextureParam);

    private static native boolean updateCardContentSwigExplicitIPrepareLayerParamImplNative(long j, IPrepareLayerParamImpl iPrepareLayerParamImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ItemStyleInfo itemStyleInfo, long j5, CustomTextureParam customTextureParam);

    public IPrepareLayerParamImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPrepareLayerParamImpl) && getUID(this) == getUID((IPrepareLayerParamImpl) obj);
    }

    private static long getUID(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        long cPtr = getCPtr(iPrepareLayerParamImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        if (iPrepareLayerParamImpl == null) {
            return 0L;
        }
        return iPrepareLayerParamImpl.swigCPtr;
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
        IPrepareLayerParamImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPrepareLayerParamImpl_change_ownership(this, this.swigCPtr, true);
    }

    public IPrepareLayerParamImpl(@MapEngineID.MapEngineID1 int i) {
        this(createNativeObj(i), true);
        LayerObserverJNI.swig_jni_init();
        IPrepareLayerParamImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public boolean updateCardContent(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, CustomTextureParam customTextureParam) {
        return $explicit_updateCardContent(baseLayerImpl, layerItemImpl, itemStyleInfo, customTextureParam);
    }

    public boolean $explicit_updateCardContent(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, CustomTextureParam customTextureParam) {
        if (this.swigCPtr != 0) {
            return getClass() == IPrepareLayerParamImpl.class ? updateCardContentNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, itemStyleInfo, 0L, customTextureParam) : updateCardContentSwigExplicitIPrepareLayerParamImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, itemStyleInfo, 0L, customTextureParam);
        }
        throw new NullPointerException();
    }

    public boolean getPrepareLayerParam(LayerItemImpl layerItemImpl, PrepareLayerMarkerParam prepareLayerMarkerParam) {
        return $explicit_getPrepareLayerParam(layerItemImpl, prepareLayerMarkerParam);
    }

    public boolean $explicit_getPrepareLayerParam(LayerItemImpl layerItemImpl, PrepareLayerMarkerParam prepareLayerMarkerParam) {
        if (this.swigCPtr != 0) {
            return getClass() == IPrepareLayerParamImpl.class ? getPrepareLayerParamNative(this.swigCPtr, this, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, prepareLayerMarkerParam) : getPrepareLayerParamSwigExplicitIPrepareLayerParamImplNative(this.swigCPtr, this, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, prepareLayerMarkerParam);
        }
        throw new NullPointerException();
    }

    public boolean isRouteCacheStyleEnabled() {
        return $explicit_isRouteCacheStyleEnabled();
    }

    public boolean $explicit_isRouteCacheStyleEnabled() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isRouteCacheStyleEnabledNative(j, this);
    }

    public boolean isRouteStyleNightMode() {
        return $explicit_isRouteStyleNightMode();
    }

    public boolean $explicit_isRouteStyleNightMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isRouteStyleNightModeNative(j, this);
    }

    public boolean isStaticMarker(String str) {
        return $explicit_isStaticMarker(str);
    }

    public boolean $explicit_isStaticMarker(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isStaticMarkerNative(j, this, str);
    }

    public boolean isDynamicMarker(String str) {
        return $explicit_isDynamicMarker(str);
    }

    public boolean $explicit_isDynamicMarker(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isDynamicMarkerNative(j, this, str);
    }

    public boolean getNewStaticMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, String[] strArr) {
        return $explicit_getNewStaticMarkerId(baseLayerImpl, layerItemImpl, itemStyleInfo, strArr);
    }

    public boolean $explicit_getNewStaticMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, String[] strArr) {
        if (this.swigCPtr != 0) {
            return getClass() == IPrepareLayerParamImpl.class ? getNewStaticMarkerIdNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, itemStyleInfo, strArr) : getNewStaticMarkerIdSwigExplicitIPrepareLayerParamImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, itemStyleInfo, strArr);
        }
        throw new NullPointerException();
    }

    public int get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        return $explicit_get3DModelId(baseLayerImpl, layerItemImpl, str);
    }

    public int $explicit_get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        if (this.swigCPtr != 0) {
            return getClass() == IPrepareLayerParamImpl.class ? get3DModelIdNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, str) : get3DModelIdSwigExplicitIPrepareLayerParamImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, str);
        }
        throw new NullPointerException();
    }

    public float getPointMarkerScaleFactor() {
        return $explicit_getPointMarkerScaleFactor();
    }

    public float $explicit_getPointMarkerScaleFactor() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPointMarkerScaleFactorNative(j, this);
    }

    public boolean isNightMode() {
        return $explicit_isNightMode();
    }

    public boolean $explicit_isNightMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isNightModeNative(j, this);
    }

    public boolean isEnglish() {
        return $explicit_isEnglish();
    }

    public boolean $explicit_isEnglish() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isEnglishNative(j, this);
    }

    public float getRouteWidthScaleFactor(int i) {
        return $explicit_getRouteWidthScaleFactor(i);
    }

    public float $explicit_getRouteWidthScaleFactor(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRouteWidthScaleFactorNative(j, this, i);
    }

    public boolean isInForeground() {
        return $explicit_isInForeground();
    }

    public boolean $explicit_isInForeground() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInForegroundNative(j, this);
    }
}
