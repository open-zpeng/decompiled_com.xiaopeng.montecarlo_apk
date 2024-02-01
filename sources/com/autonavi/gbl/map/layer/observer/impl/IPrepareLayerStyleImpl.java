package com.autonavi.gbl.map.layer.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.layer.model.RouteLayerStyle;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
@IntfAuto(target = IPrepareLayerStyle.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPrepareLayerStyleImpl {
    private static BindTable BIND_TABLE = new BindTable(IPrepareLayerStyleImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPrepareLayerStyleImpl_change_ownership(IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j, boolean z);

    private static native void IPrepareLayerStyleImpl_director_connect(IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j, boolean z, boolean z2);

    private static native void clearLayerItemNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl);

    private static native void clearLayerItemSwigExplicitIPrepareLayerStyleImplNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl);

    private static native void clearLayerItemsNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j2, BaseLayerImpl baseLayerImpl);

    private static native void clearLayerItemsSwigExplicitIPrepareLayerStyleImplNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j2, BaseLayerImpl baseLayerImpl);

    private static native void clearLayerStyleNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl);

    private static native void clearLayerStyleSwigExplicitIPrepareLayerStyleImplNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int get3DModelIdNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, String str);

    private static native int get3DModelIdSwigExplicitIPrepareLayerStyleImplNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, String str);

    private static native String getCommonInfoNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, String str);

    private static native String getCommonInfoSwigExplicitIPrepareLayerStyleImplNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, String str);

    private static native String getLayerStyleNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, boolean z);

    private static native String getLayerStyleSwigExplicitIPrepareLayerStyleImplNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, boolean z);

    private static native int getMarkerIdNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ItemStyleInfo itemStyleInfo);

    private static native int getMarkerIdSwigExplicitIPrepareLayerStyleImplNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, ItemStyleInfo itemStyleInfo);

    private static native boolean getRouteLayerStyleNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, RouteLayerStyle routeLayerStyle);

    private static native boolean getRouteLayerStyleSwigExplicitIPrepareLayerStyleImplNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, long j2, BaseLayerImpl baseLayerImpl, long j3, LayerItemImpl layerItemImpl, long j4, RouteLayerStyle routeLayerStyle);

    private static native boolean isRouteCacheStyleEnabledNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native boolean isRouteCacheStyleEnabledSwigExplicitIPrepareLayerStyleImplNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native boolean isRouteStyleNightModeNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native boolean isRouteStyleNightModeSwigExplicitIPrepareLayerStyleImplNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native boolean switchStyleNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, int i);

    private static native boolean switchStyleSwigExplicitIPrepareLayerStyleImplNative(long j, IPrepareLayerStyleImpl iPrepareLayerStyleImpl, int i);

    public IPrepareLayerStyleImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPrepareLayerStyleImpl) && getUID(this) == getUID((IPrepareLayerStyleImpl) obj);
    }

    private static long getUID(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        long cPtr = getCPtr(iPrepareLayerStyleImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        if (iPrepareLayerStyleImpl == null) {
            return 0L;
        }
        return iPrepareLayerStyleImpl.swigCPtr;
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
        IPrepareLayerStyleImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPrepareLayerStyleImpl_change_ownership(this, this.swigCPtr, true);
    }

    public IPrepareLayerStyleImpl() {
        this(createNativeObj(), true);
        MapLayerObserverJNI.swig_jni_init();
        IPrepareLayerStyleImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public int getMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo) {
        if (this.swigCPtr != 0) {
            return getClass() == IPrepareLayerStyleImpl.class ? getMarkerIdNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, itemStyleInfo) : getMarkerIdSwigExplicitIPrepareLayerStyleImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, itemStyleInfo);
        }
        throw new NullPointerException();
    }

    public int get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        if (this.swigCPtr != 0) {
            return getClass() == IPrepareLayerStyleImpl.class ? get3DModelIdNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, str) : get3DModelIdSwigExplicitIPrepareLayerStyleImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, str);
        }
        throw new NullPointerException();
    }

    public String getLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, boolean z) {
        if (this.swigCPtr != 0) {
            return getClass() == IPrepareLayerStyleImpl.class ? getLayerStyleNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, z) : getLayerStyleSwigExplicitIPrepareLayerStyleImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, z);
        }
        throw new NullPointerException();
    }

    public boolean getRouteLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, RouteLayerStyle routeLayerStyle) {
        if (this.swigCPtr != 0) {
            return getClass() == IPrepareLayerStyleImpl.class ? getRouteLayerStyleNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, routeLayerStyle) : getRouteLayerStyleSwigExplicitIPrepareLayerStyleImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl, 0L, routeLayerStyle);
        }
        throw new NullPointerException();
    }

    public boolean isRouteCacheStyleEnabled() {
        if (this.swigCPtr != 0) {
            return getClass() == IPrepareLayerStyleImpl.class ? isRouteCacheStyleEnabledNative(this.swigCPtr, this) : isRouteCacheStyleEnabledSwigExplicitIPrepareLayerStyleImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public boolean isRouteStyleNightMode() {
        if (this.swigCPtr != 0) {
            return getClass() == IPrepareLayerStyleImpl.class ? isRouteStyleNightModeNative(this.swigCPtr, this) : isRouteStyleNightModeSwigExplicitIPrepareLayerStyleImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void clearLayerItems(BaseLayerImpl baseLayerImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IPrepareLayerStyleImpl.class) {
            clearLayerItemsNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl);
        } else {
            clearLayerItemsSwigExplicitIPrepareLayerStyleImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl);
        }
    }

    public void clearLayerItem(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IPrepareLayerStyleImpl.class) {
            clearLayerItemNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl);
        } else {
            clearLayerItemSwigExplicitIPrepareLayerStyleImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl);
        }
    }

    public void clearLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IPrepareLayerStyleImpl.class) {
            clearLayerStyleNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl);
        } else {
            clearLayerStyleSwigExplicitIPrepareLayerStyleImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl);
        }
    }

    public String getCommonInfo(String str) {
        if (this.swigCPtr != 0) {
            return getClass() == IPrepareLayerStyleImpl.class ? getCommonInfoNative(this.swigCPtr, this, str) : getCommonInfoSwigExplicitIPrepareLayerStyleImplNative(this.swigCPtr, this, str);
        }
        throw new NullPointerException();
    }

    public boolean switchStyle(int i) {
        if (this.swigCPtr != 0) {
            return getClass() == IPrepareLayerStyleImpl.class ? switchStyleNative(this.swigCPtr, this, i) : switchStyleSwigExplicitIPrepareLayerStyleImplNative(this.swigCPtr, this, i);
        }
        throw new NullPointerException();
    }
}
