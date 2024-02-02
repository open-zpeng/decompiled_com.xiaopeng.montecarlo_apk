package com.autonavi.gbl.layer.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.card.model.CustomTextureParam;
import com.autonavi.gbl.layer.model.PrepareLayerMarkerParam;
import com.autonavi.gbl.layer.observer.PrepareLayerParamInner;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.model.MapEngineID;
@IntfAuto(target = PrepareLayerParamInner.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class PrepareLayerParamInnerImpl extends IPrepareLayerParamImpl {
    private static BindTable BIND_TABLE = new BindTable(PrepareLayerParamInnerImpl.class);
    private transient long swigCPtr;

    private static native long PrepareLayerParamInnerImpl_SWIGUpcast(long j);

    private static native void PrepareLayerParamInnerImpl_change_ownership(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, long j, boolean z);

    private static native void PrepareLayerParamInnerImpl_director_connect(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i);

    private static native void destroyNativeObj(long j);

    private static native int get3DModelIdNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, String str);

    private static native int get3DModelIdSwigExplicitPrepareLayerParamInnerImplNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, String str);

    private static native boolean getNewStaticMarkerIdNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ItemStyleInfo itemStyleInfo, String[] strArr);

    private static native boolean getNewStaticMarkerIdSwigExplicitPrepareLayerParamInnerImplNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ItemStyleInfo itemStyleInfo, String[] strArr);

    private static native float getPointMarkerScaleFactorNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl);

    private static native float getPointMarkerScaleFactorSwigExplicitPrepareLayerParamInnerImplNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl);

    private static native boolean getPrepareLayerParamNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, long j2, LayerItemImpl layerItemImpl, long j3, PrepareLayerMarkerParam prepareLayerMarkerParam);

    private static native boolean getPrepareLayerParamSwigExplicitPrepareLayerParamInnerImplNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, long j2, LayerItemImpl layerItemImpl, long j3, PrepareLayerMarkerParam prepareLayerMarkerParam);

    private static native float getRouteWidthScaleFactorNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, int i);

    private static native float getRouteWidthScaleFactorSwigExplicitPrepareLayerParamInnerImplNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, int i);

    private static native boolean isDynamicMarkerNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, String str);

    private static native boolean isDynamicMarkerSwigExplicitPrepareLayerParamInnerImplNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, String str);

    private static native boolean isEnglishNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl);

    private static native boolean isEnglishSwigExplicitPrepareLayerParamInnerImplNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl);

    private static native boolean isInForegroundNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl);

    private static native boolean isInForegroundSwigExplicitPrepareLayerParamInnerImplNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl);

    private static native boolean isNightModeNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl);

    private static native boolean isNightModeSwigExplicitPrepareLayerParamInnerImplNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl);

    private static native boolean isRouteCacheStyleEnabledNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl);

    private static native boolean isRouteCacheStyleEnabledSwigExplicitPrepareLayerParamInnerImplNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl);

    private static native boolean isRouteStyleNightModeNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl);

    private static native boolean isRouteStyleNightModeSwigExplicitPrepareLayerParamInnerImplNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl);

    private static native boolean isStaticMarkerNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, String str);

    private static native boolean isStaticMarkerSwigExplicitPrepareLayerParamInnerImplNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, String str);

    private static native boolean updateCardContentNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ItemStyleInfo itemStyleInfo, long j5, CustomTextureParam customTextureParam);

    private static native boolean updateCardContentSwigExplicitPrepareLayerParamInnerImplNative(long j, PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ItemStyleInfo itemStyleInfo, long j5, CustomTextureParam customTextureParam);

    public PrepareLayerParamInnerImpl(long j, boolean z) {
        super(PrepareLayerParamInnerImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean equals(Object obj) {
        if (obj instanceof PrepareLayerParamInnerImpl) {
            return getUID(this) == getUID((PrepareLayerParamInnerImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl) {
        long cPtr = getCPtr(prepareLayerParamInnerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl) {
        if (prepareLayerParamInnerImpl == null) {
            return 0L;
        }
        return prepareLayerParamInnerImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        PrepareLayerParamInnerImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        PrepareLayerParamInnerImpl_change_ownership(this, this.swigCPtr, true);
    }

    public PrepareLayerParamInnerImpl(@MapEngineID.MapEngineID1 int i) {
        this(createNativeObj(i), true);
        LayerObserverJNI.swig_jni_init();
        PrepareLayerParamInnerImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean updateCardContent(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, CustomTextureParam customTextureParam) {
        return $explicit_updateCardContent(baseLayerImpl, layerItemImpl, itemStyleInfo, customTextureParam);
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean $explicit_updateCardContent(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, CustomTextureParam customTextureParam) {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerParamInnerImpl.class ? updateCardContentNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, itemStyleInfo, 0L, customTextureParam) : updateCardContentSwigExplicitPrepareLayerParamInnerImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, itemStyleInfo, 0L, customTextureParam);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean getPrepareLayerParam(LayerItemImpl layerItemImpl, PrepareLayerMarkerParam prepareLayerMarkerParam) {
        return $explicit_getPrepareLayerParam(layerItemImpl, prepareLayerMarkerParam);
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean $explicit_getPrepareLayerParam(LayerItemImpl layerItemImpl, PrepareLayerMarkerParam prepareLayerMarkerParam) {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerParamInnerImpl.class ? getPrepareLayerParamNative(this.swigCPtr, this, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, prepareLayerMarkerParam) : getPrepareLayerParamSwigExplicitPrepareLayerParamInnerImplNative(this.swigCPtr, this, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, prepareLayerMarkerParam);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean isRouteCacheStyleEnabled() {
        return $explicit_isRouteCacheStyleEnabled();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean $explicit_isRouteCacheStyleEnabled() {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerParamInnerImpl.class ? isRouteCacheStyleEnabledNative(this.swigCPtr, this) : isRouteCacheStyleEnabledSwigExplicitPrepareLayerParamInnerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean isRouteStyleNightMode() {
        return $explicit_isRouteStyleNightMode();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean $explicit_isRouteStyleNightMode() {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerParamInnerImpl.class ? isRouteStyleNightModeNative(this.swigCPtr, this) : isRouteStyleNightModeSwigExplicitPrepareLayerParamInnerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean isStaticMarker(String str) {
        return $explicit_isStaticMarker(str);
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean $explicit_isStaticMarker(String str) {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerParamInnerImpl.class ? isStaticMarkerNative(this.swigCPtr, this, str) : isStaticMarkerSwigExplicitPrepareLayerParamInnerImplNative(this.swigCPtr, this, str);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean isDynamicMarker(String str) {
        return $explicit_isDynamicMarker(str);
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean $explicit_isDynamicMarker(String str) {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerParamInnerImpl.class ? isDynamicMarkerNative(this.swigCPtr, this, str) : isDynamicMarkerSwigExplicitPrepareLayerParamInnerImplNative(this.swigCPtr, this, str);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean getNewStaticMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, String[] strArr) {
        return $explicit_getNewStaticMarkerId(baseLayerImpl, layerItemImpl, itemStyleInfo, strArr);
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean $explicit_getNewStaticMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, String[] strArr) {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerParamInnerImpl.class ? getNewStaticMarkerIdNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, itemStyleInfo, strArr) : getNewStaticMarkerIdSwigExplicitPrepareLayerParamInnerImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, itemStyleInfo, strArr);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public int get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        return $explicit_get3DModelId(baseLayerImpl, layerItemImpl, str);
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public int $explicit_get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerParamInnerImpl.class ? get3DModelIdNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, str) : get3DModelIdSwigExplicitPrepareLayerParamInnerImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, str);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public float getPointMarkerScaleFactor() {
        return $explicit_getPointMarkerScaleFactor();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public float $explicit_getPointMarkerScaleFactor() {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerParamInnerImpl.class ? getPointMarkerScaleFactorNative(this.swigCPtr, this) : getPointMarkerScaleFactorSwigExplicitPrepareLayerParamInnerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean isNightMode() {
        return $explicit_isNightMode();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean $explicit_isNightMode() {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerParamInnerImpl.class ? isNightModeNative(this.swigCPtr, this) : isNightModeSwigExplicitPrepareLayerParamInnerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean isEnglish() {
        return $explicit_isEnglish();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean $explicit_isEnglish() {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerParamInnerImpl.class ? isEnglishNative(this.swigCPtr, this) : isEnglishSwigExplicitPrepareLayerParamInnerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public float getRouteWidthScaleFactor(int i) {
        return $explicit_getRouteWidthScaleFactor(i);
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public float $explicit_getRouteWidthScaleFactor(int i) {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerParamInnerImpl.class ? getRouteWidthScaleFactorNative(this.swigCPtr, this, i) : getRouteWidthScaleFactorSwigExplicitPrepareLayerParamInnerImplNative(this.swigCPtr, this, i);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean isInForeground() {
        return $explicit_isInForeground();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean $explicit_isInForeground() {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerParamInnerImpl.class ? isInForegroundNative(this.swigCPtr, this) : isInForegroundSwigExplicitPrepareLayerParamInnerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }
}
