package com.autonavi.gbl.layer.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.card.impl.ICardServiceImpl;
import com.autonavi.gbl.layer.model.InnerStyleParam;
import com.autonavi.gbl.layer.observer.PrepareLayerStyleInner;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.layer.model.RouteLayerStyle;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
@IntfAuto(target = PrepareLayerStyleInner.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class PrepareLayerStyleInnerImpl extends IPrepareLayerStyleImpl {
    private static BindTable BIND_TABLE = new BindTable(PrepareLayerStyleInnerImpl.class);
    private transient long swigCPtr;

    private static native long PrepareLayerStyleInnerImpl_SWIGUpcast(long j);

    private static native void PrepareLayerStyleInnerImpl_change_ownership(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j, boolean z);

    private static native void PrepareLayerStyleInnerImpl_director_connect(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j, boolean z, boolean z2);

    private static native void clearLayerItemNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl);

    private static native void clearLayerItemSwigExplicitPrepareLayerStyleInnerImplNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl);

    private static native void clearLayerItemsNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl);

    private static native void clearLayerItemsSwigExplicitPrepareLayerStyleInnerImplNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl);

    private static native void clearLayerStyleNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl);

    private static native void clearLayerStyleSwigExplicitPrepareLayerStyleInnerImplNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl);

    private static native long createNativeObj(long j, IMapViewImpl iMapViewImpl, long j2, ICardServiceImpl iCardServiceImpl, long j3, IPrepareLayerParamImpl iPrepareLayerParamImpl, long j4, InnerStyleParam innerStyleParam);

    private static native void destroyNativeObj(long j);

    private static native int get3DModelIdNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, String str);

    private static native int get3DModelIdSwigExplicitPrepareLayerStyleInnerImplNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, String str);

    private static native String getCommonInfoNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, String str);

    private static native String getCommonInfoSwigExplicitPrepareLayerStyleInnerImplNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, String str);

    private static native int getInnerMarkerIdNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ItemStyleInfo itemStyleInfo);

    private static native int getInnerMarkerIdSwigExplicitPrepareLayerStyleInnerImplNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ItemStyleInfo itemStyleInfo);

    private static native String getLayerStyleNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, boolean z);

    private static native String getLayerStyleSwigExplicitPrepareLayerStyleInnerImplNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, boolean z);

    private static native int getMarkerIdNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ItemStyleInfo itemStyleInfo);

    private static native int getMarkerIdSwigExplicitPrepareLayerStyleInnerImplNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ItemStyleInfo itemStyleInfo);

    private static native boolean getRouteLayerStyleNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, RouteLayerStyle routeLayerStyle);

    private static native boolean getRouteLayerStyleSwigExplicitPrepareLayerStyleInnerImplNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, RouteLayerStyle routeLayerStyle);

    private static native boolean isRouteCacheStyleEnabledNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl);

    private static native boolean isRouteCacheStyleEnabledSwigExplicitPrepareLayerStyleInnerImplNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl);

    private static native boolean isRouteStyleNightModeNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl);

    private static native boolean isRouteStyleNightModeSwigExplicitPrepareLayerStyleInnerImplNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl);

    private static native void setParamNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, IPrepareLayerParamImpl iPrepareLayerParamImpl);

    private static native void setParamSwigExplicitPrepareLayerStyleInnerImplNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, long j2, IPrepareLayerParamImpl iPrepareLayerParamImpl);

    private static native boolean switchStyleNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, int i);

    private static native boolean switchStyleSwigExplicitPrepareLayerStyleInnerImplNative(long j, PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, int i);

    public PrepareLayerStyleInnerImpl(long j, boolean z) {
        super(PrepareLayerStyleInnerImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public boolean equals(Object obj) {
        if (obj instanceof PrepareLayerStyleInnerImpl) {
            return getUID(this) == getUID((PrepareLayerStyleInnerImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl) {
        long cPtr = getCPtr(prepareLayerStyleInnerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl) {
        if (prepareLayerStyleInnerImpl == null) {
            return 0L;
        }
        return prepareLayerStyleInnerImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
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

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        PrepareLayerStyleInnerImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        PrepareLayerStyleInnerImpl_change_ownership(this, this.swigCPtr, true);
    }

    public PrepareLayerStyleInnerImpl(IMapViewImpl iMapViewImpl, ICardServiceImpl iCardServiceImpl, IPrepareLayerParamImpl iPrepareLayerParamImpl, InnerStyleParam innerStyleParam) {
        this(createNativeObj(IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl, ICardServiceImpl.getCPtr(iCardServiceImpl), iCardServiceImpl, IPrepareLayerParamImpl.getCPtr(iPrepareLayerParamImpl), iPrepareLayerParamImpl, 0L, innerStyleParam), true);
        LayerObserverJNI.swig_jni_init();
        PrepareLayerStyleInnerImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void setParam(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        $explicit_setParam(iPrepareLayerParamImpl);
    }

    public void $explicit_setParam(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PrepareLayerStyleInnerImpl.class) {
            setParamNative(this.swigCPtr, this, IPrepareLayerParamImpl.getCPtr(iPrepareLayerParamImpl), iPrepareLayerParamImpl);
        } else {
            setParamSwigExplicitPrepareLayerStyleInnerImplNative(this.swigCPtr, this, IPrepareLayerParamImpl.getCPtr(iPrepareLayerParamImpl), iPrepareLayerParamImpl);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public int getMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo) {
        return $explicit_getMarkerId(baseLayerImpl, layerItemImpl, itemStyleInfo);
    }

    public int $explicit_getMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo) {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerStyleInnerImpl.class ? getMarkerIdNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, itemStyleInfo) : getMarkerIdSwigExplicitPrepareLayerStyleInnerImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, itemStyleInfo);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public int get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        return $explicit_get3DModelId(baseLayerImpl, layerItemImpl, str);
    }

    public int $explicit_get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerStyleInnerImpl.class ? get3DModelIdNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, str) : get3DModelIdSwigExplicitPrepareLayerStyleInnerImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, str);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public String getLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, boolean z) {
        return $explicit_getLayerStyle(baseLayerImpl, layerItemImpl, z);
    }

    public String $explicit_getLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, boolean z) {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerStyleInnerImpl.class ? getLayerStyleNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, z) : getLayerStyleSwigExplicitPrepareLayerStyleInnerImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, z);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public boolean getRouteLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, RouteLayerStyle routeLayerStyle) {
        return $explicit_getRouteLayerStyle(baseLayerImpl, layerItemImpl, routeLayerStyle);
    }

    public boolean $explicit_getRouteLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, RouteLayerStyle routeLayerStyle) {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerStyleInnerImpl.class ? getRouteLayerStyleNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, routeLayerStyle) : getRouteLayerStyleSwigExplicitPrepareLayerStyleInnerImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, routeLayerStyle);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void clearLayerItems(BaseLayerImpl baseLayerImpl) {
        $explicit_clearLayerItems(baseLayerImpl);
    }

    public void $explicit_clearLayerItems(BaseLayerImpl baseLayerImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PrepareLayerStyleInnerImpl.class) {
            clearLayerItemsNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl);
        } else {
            clearLayerItemsSwigExplicitPrepareLayerStyleInnerImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void clearLayerItem(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        $explicit_clearLayerItem(baseLayerImpl, layerItemImpl);
    }

    public void $explicit_clearLayerItem(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PrepareLayerStyleInnerImpl.class) {
            clearLayerItemNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl);
        } else {
            clearLayerItemSwigExplicitPrepareLayerStyleInnerImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void clearLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        $explicit_clearLayerStyle(baseLayerImpl, layerItemImpl);
    }

    public void $explicit_clearLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PrepareLayerStyleInnerImpl.class) {
            clearLayerStyleNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl);
        } else {
            clearLayerStyleSwigExplicitPrepareLayerStyleInnerImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public boolean isRouteCacheStyleEnabled() {
        return $explicit_isRouteCacheStyleEnabled();
    }

    public boolean $explicit_isRouteCacheStyleEnabled() {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerStyleInnerImpl.class ? isRouteCacheStyleEnabledNative(this.swigCPtr, this) : isRouteCacheStyleEnabledSwigExplicitPrepareLayerStyleInnerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public boolean isRouteStyleNightMode() {
        return $explicit_isRouteStyleNightMode();
    }

    public boolean $explicit_isRouteStyleNightMode() {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerStyleInnerImpl.class ? isRouteStyleNightModeNative(this.swigCPtr, this) : isRouteStyleNightModeSwigExplicitPrepareLayerStyleInnerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public String getCommonInfo(String str) {
        return $explicit_getCommonInfo(str);
    }

    public String $explicit_getCommonInfo(String str) {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerStyleInnerImpl.class ? getCommonInfoNative(this.swigCPtr, this, str) : getCommonInfoSwigExplicitPrepareLayerStyleInnerImplNative(this.swigCPtr, this, str);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public boolean switchStyle(int i) {
        return $explicit_switchStyle(i);
    }

    public boolean $explicit_switchStyle(int i) {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerStyleInnerImpl.class ? switchStyleNative(this.swigCPtr, this, i) : switchStyleSwigExplicitPrepareLayerStyleInnerImplNative(this.swigCPtr, this, i);
        }
        throw new NullPointerException();
    }

    public int getInnerMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo) {
        return $explicit_getInnerMarkerId(baseLayerImpl, layerItemImpl, itemStyleInfo);
    }

    public int $explicit_getInnerMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo) {
        if (this.swigCPtr != 0) {
            return getClass() == PrepareLayerStyleInnerImpl.class ? getInnerMarkerIdNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, itemStyleInfo) : getInnerMarkerIdSwigExplicitPrepareLayerStyleInnerImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, itemStyleInfo);
        }
        throw new NullPointerException();
    }
}
