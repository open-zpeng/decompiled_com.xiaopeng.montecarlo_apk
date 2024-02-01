package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.creflex.BaseLayerCRfxProto;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.RoutePathLayer;
import com.autonavi.gbl.map.layer.model.AnimationStyleParam;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.MapRouteHighLightType;
import com.autonavi.gbl.map.layer.model.MapRoutePolylineDrawType;
import com.autonavi.gbl.map.layer.model.RouteLayerDrawParam;
import com.autonavi.gbl.map.layer.model.RouteLayerParam;
import com.autonavi.gbl.map.layer.model.RouteLayerPassedColor;
import com.autonavi.gbl.map.layer.model.RouteLayerScene;
import com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerFocusChangeObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerItemAnimationObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import java.util.ArrayList;
import java.util.HashMap;
@IntfAuto(enableCRfx = true, protoOfCRfx = BaseLayerCRfxProto.class, target = RoutePathLayer.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RoutePathLayerImpl extends BaseLayerImpl {
    private static BindTable BIND_TABLE = new BindTable(RoutePathLayerImpl.class);
    private transient long swigCPtr;

    private static native long RoutePathLayerImpl_SWIGUpcast(long j);

    private static native void RoutePathLayerImpl_change_ownership(RoutePathLayerImpl routePathLayerImpl, long j, boolean z);

    private static native void RoutePathLayerImpl_director_connect(RoutePathLayerImpl routePathLayerImpl, long j, boolean z, boolean z2);

    private static native void addClickObserverNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void addClickObserverSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void addFocusChangeObserverNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl);

    private static native void addFocusChangeObserverSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl);

    private static native boolean addGrownAnimationObserverNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl);

    private static native boolean addGrownAnimationObserverSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl);

    private static native void addOddItemNative(long j, RoutePathLayerImpl routePathLayerImpl, long[] jArr);

    private static native void addRouteItemNative(long j, RoutePathLayerImpl routePathLayerImpl, int i, int i2, byte[] bArr, short s);

    private static native void addRouteItemSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, int i, int i2, byte[] bArr, short s);

    private static native void addRouteNameNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native void addRouteNameSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native long createNativeObj(String str, String str2, long j, IMapViewImpl iMapViewImpl);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native boolean getClickableNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native boolean getClickableSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native void getDisplayScaleNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, LayerScale layerScale);

    private static native void getDisplayScaleSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, LayerScale layerScale);

    private static native boolean getOddVisibleNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native long getPathIDNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native void getPriorityNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, LayerPriority layerPriority);

    private static native void getPrioritySwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, LayerPriority layerPriority);

    private static native void getRouteDrawParamNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, RouteLayerDrawParam routeLayerDrawParam);

    private static native void getRouteDrawParamSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, RouteLayerDrawParam routeLayerDrawParam);

    private static native boolean getSelectStatusNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native boolean getSelectStatusSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native boolean getVisibleNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native boolean getVisibleSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native boolean isPathIntersectRectNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, RectDouble rectDouble);

    private static native boolean isPathIntersectRectSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, RectDouble rectDouble);

    private static native void removeClickObserverNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void removeClickObserverSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void removeFocusChangeObserverNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl);

    private static native void removeFocusChangeObserverSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl);

    private static native boolean removeGrownAnimationObserverNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl);

    private static native boolean removeGrownAnimationObserverSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl);

    private static native void removeRouteItemNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native void removeRouteItemSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native void removeRouteNameNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native void removeRouteNameSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native void restoreVisibleNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native void restoreVisibleSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native void saveVisibleNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native void saveVisibleSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native void setBusinessTypeNative(long j, RoutePathLayerImpl routePathLayerImpl, int i);

    private static native void setBusinessTypeSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, int i);

    private static native void setCar2DPositionNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, float f);

    private static native void setCar2DPositionSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, float f);

    private static native void setCar3DPositionNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, float f);

    private static native void setCar3DPositionSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, float f);

    private static native void setClickableNative(long j, RoutePathLayerImpl routePathLayerImpl, boolean z);

    private static native void setClickableSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, boolean z);

    private static native void setDisplayScaleNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, LayerScale layerScale);

    private static native void setDisplayScaleSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, LayerScale layerScale);

    private static native boolean setDrawTypeNative(long j, RoutePathLayerImpl routePathLayerImpl, int i);

    private static native boolean setDrawTypeSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, int i);

    private static native void setFilterZoomLevelNative(long j, RoutePathLayerImpl routePathLayerImpl, float f, float f2);

    private static native void setFilterZoomLevelSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, float f, float f2);

    private static native boolean setGrownAnimation1Native(long j, RoutePathLayerImpl routePathLayerImpl, int i);

    private static native boolean setGrownAnimation2Native(long j, RoutePathLayerImpl routePathLayerImpl, boolean z, int i, long j2);

    private static native boolean setGrownAnimation3Native(long j, RoutePathLayerImpl routePathLayerImpl, boolean z, int i);

    private static native boolean setGrownAnimationNative(long j, RoutePathLayerImpl routePathLayerImpl, int i, long j2);

    private static native boolean setGrownAnimationSwigExplicitRoutePathLayerImpl1Native(long j, RoutePathLayerImpl routePathLayerImpl, int i);

    private static native boolean setGrownAnimationSwigExplicitRoutePathLayerImpl2Native(long j, RoutePathLayerImpl routePathLayerImpl, boolean z, int i, long j2);

    private static native boolean setGrownAnimationSwigExplicitRoutePathLayerImpl3Native(long j, RoutePathLayerImpl routePathLayerImpl, boolean z, int i);

    private static native boolean setGrownAnimationSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, int i, long j2);

    private static native void setHighlightTypeNative(long j, RoutePathLayerImpl routePathLayerImpl, int i);

    private static native void setHighlightTypeSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, int i);

    private static native void setLineWidthScaleNative(long j, RoutePathLayerImpl routePathLayerImpl, float f);

    private static native void setLineWidthScaleSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, float f);

    private static native void setOddAnimationNative(long j, RoutePathLayerImpl routePathLayerImpl, boolean z, long j2, AnimationStyleParam animationStyleParam);

    private static native void setOddDisplayScaleNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, LayerScale layerScale);

    private static native void setOddVisibleNative(long j, RoutePathLayerImpl routePathLayerImpl, boolean z);

    private static native void setParkFloorNative(long j, RoutePathLayerImpl routePathLayerImpl, int i);

    private static native void setParkFloorSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, int i);

    private static native void setPassedColorNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, RouteLayerPassedColor routeLayerPassedColor);

    private static native void setPassedColorSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, RouteLayerPassedColor routeLayerPassedColor);

    private static native void setPathIDNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2);

    private static native void setPriorityNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, LayerPriority layerPriority);

    private static native void setPrioritySwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, LayerPriority layerPriority);

    private static native void setRouteDrawParamNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, RouteLayerDrawParam routeLayerDrawParam);

    private static native void setRouteDrawParamSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, RouteLayerDrawParam routeLayerDrawParam);

    private static native void setRouteItemParamNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, RouteLayerParam routeLayerParam);

    private static native void setRouteItemParamSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, RouteLayerParam routeLayerParam);

    private static native void setRouteItemParamsNative(long j, RoutePathLayerImpl routePathLayerImpl, ArrayList<RouteLayerParam> arrayList);

    private static native void setRouteItemParamsSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, ArrayList<RouteLayerParam> arrayList);

    private static native void setSelectStatusNative(long j, RoutePathLayerImpl routePathLayerImpl, boolean z);

    private static native void setSelectStatusSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, boolean z);

    private static native void setShowNaviRouteNameCountMapNative(long j, RoutePathLayerImpl routePathLayerImpl, HashMap<Integer, Integer> hashMap);

    private static native void setShowNaviRouteNameCountMapSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, HashMap<Integer, Integer> hashMap);

    private static native void setStyleNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setStyleSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setVisibleNative(long j, RoutePathLayerImpl routePathLayerImpl, boolean z);

    private static native void setVisibleSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl, boolean z);

    private static native void updateOddLineGreyNative(long j, RoutePathLayerImpl routePathLayerImpl, long j2, long j3, float f);

    private static native void updateStyleNative(long j, RoutePathLayerImpl routePathLayerImpl);

    private static native void updateStyleSwigExplicitRoutePathLayerImplNative(long j, RoutePathLayerImpl routePathLayerImpl);

    public RoutePathLayerImpl(long j, boolean z) {
        super(RoutePathLayerImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof RoutePathLayerImpl) {
            return getUID(this) == getUID((RoutePathLayerImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RoutePathLayerImpl routePathLayerImpl) {
        long cPtr = getCPtr(routePathLayerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RoutePathLayerImpl routePathLayerImpl) {
        if (routePathLayerImpl == null) {
            return 0L;
        }
        return routePathLayerImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        RoutePathLayerImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RoutePathLayerImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RoutePathLayerImpl(String str, String str2, IMapViewImpl iMapViewImpl) {
        this(createNativeObj(str, str2, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl), true);
        MapLayerSvrJNI.swig_jni_init();
        RoutePathLayerImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setBusinessType(int i) {
        $explicit_setBusinessType(i);
    }

    public void $explicit_setBusinessType(int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setBusinessTypeNative(this.swigCPtr, this, i);
        } else {
            setBusinessTypeSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, i);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void setStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        $explicit_setStyle(iPrepareLayerStyleImpl);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void $explicit_setStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setStyleNative(this.swigCPtr, this, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
        } else {
            setStyleSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void updateStyle() {
        $explicit_updateStyle();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void $explicit_updateStyle() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getVisible() {
        return $explicit_getVisible();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean $explicit_getVisible() {
        if (this.swigCPtr != 0) {
            return getClass() == RoutePathLayerImpl.class ? getVisibleNative(this.swigCPtr, this) : getVisibleSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void setVisible(boolean z) {
        $explicit_setVisible(z);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void $explicit_setVisible(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setVisibleNative(this.swigCPtr, this, z);
        } else {
            setVisibleSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void saveVisible() {
        $explicit_saveVisible();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void $explicit_saveVisible() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            saveVisibleNative(this.swigCPtr, this);
        } else {
            saveVisibleSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void restoreVisible() {
        $explicit_restoreVisible();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void $explicit_restoreVisible() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            restoreVisibleNative(this.swigCPtr, this);
        } else {
            restoreVisibleSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void setClickable(boolean z) {
        $explicit_setClickable(z);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void $explicit_setClickable(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setClickableNative(this.swigCPtr, this, z);
        } else {
            setClickableSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean getClickable() {
        return $explicit_getClickable();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public boolean $explicit_getClickable() {
        if (this.swigCPtr != 0) {
            return getClass() == RoutePathLayerImpl.class ? getClickableNative(this.swigCPtr, this) : getClickableSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void setPriority(LayerPriority layerPriority) {
        $explicit_setPriority(layerPriority);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void $explicit_setPriority(LayerPriority layerPriority) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setPriorityNative(this.swigCPtr, this, 0L, layerPriority);
        } else {
            setPrioritySwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, 0L, layerPriority);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void getPriority(LayerPriority layerPriority) {
        $explicit_getPriority(layerPriority);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void $explicit_getPriority(LayerPriority layerPriority) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            getPriorityNative(this.swigCPtr, this, 0L, layerPriority);
        } else {
            getPrioritySwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, 0L, layerPriority);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void setDisplayScale(LayerScale layerScale) {
        $explicit_setDisplayScale(layerScale);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void $explicit_setDisplayScale(LayerScale layerScale) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setDisplayScaleNative(this.swigCPtr, this, 0L, layerScale);
        } else {
            setDisplayScaleSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, 0L, layerScale);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void getDisplayScale(LayerScale layerScale) {
        $explicit_getDisplayScale(layerScale);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void $explicit_getDisplayScale(LayerScale layerScale) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            getDisplayScaleNative(this.swigCPtr, this, 0L, layerScale);
        } else {
            getDisplayScaleSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, 0L, layerScale);
        }
    }

    public void setPathID(long j) {
        $explicit_setPathID(j);
    }

    public void $explicit_setPathID(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setPathIDNative(j2, this, j);
    }

    public long getPathID() {
        return $explicit_getPathID();
    }

    public long $explicit_getPathID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPathIDNative(j, this);
    }

    public void setCar2DPosition(long j, float f) {
        $explicit_setCar2DPosition(j, f);
    }

    public void $explicit_setCar2DPosition(long j, float f) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setCar2DPositionNative(this.swigCPtr, this, j, f);
        } else {
            setCar2DPositionSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, j, f);
        }
    }

    public void setCar3DPosition(long j, float f) {
        $explicit_setCar3DPosition(j, f);
    }

    public void $explicit_setCar3DPosition(long j, float f) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setCar3DPositionNative(this.swigCPtr, this, j, f);
        } else {
            setCar3DPositionSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, j, f);
        }
    }

    public void addRouteName() {
        $explicit_addRouteName();
    }

    public void $explicit_addRouteName() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            addRouteNameNative(this.swigCPtr, this);
        } else {
            addRouteNameSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this);
        }
    }

    public void removeRouteName() {
        $explicit_removeRouteName();
    }

    public void $explicit_removeRouteName() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            removeRouteNameNative(this.swigCPtr, this);
        } else {
            removeRouteNameSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this);
        }
    }

    public void setLineWidthScale(float f) {
        $explicit_setLineWidthScale(f);
    }

    public void $explicit_setLineWidthScale(float f) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setLineWidthScaleNative(this.swigCPtr, this, f);
        } else {
            setLineWidthScaleSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, f);
        }
    }

    public void setRouteItemParam(RouteLayerParam routeLayerParam) {
        $explicit_setRouteItemParam(routeLayerParam);
    }

    public void $explicit_setRouteItemParam(RouteLayerParam routeLayerParam) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setRouteItemParamNative(this.swigCPtr, this, 0L, routeLayerParam);
        } else {
            setRouteItemParamSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, 0L, routeLayerParam);
        }
    }

    public void setRouteItemParams(ArrayList<RouteLayerParam> arrayList) {
        $explicit_setRouteItemParams(arrayList);
    }

    public void $explicit_setRouteItemParams(ArrayList<RouteLayerParam> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setRouteItemParamsNative(this.swigCPtr, this, arrayList);
        } else {
            setRouteItemParamsSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, arrayList);
        }
    }

    public void setPassedColor(RouteLayerPassedColor routeLayerPassedColor) {
        $explicit_setPassedColor(routeLayerPassedColor);
    }

    public void $explicit_setPassedColor(RouteLayerPassedColor routeLayerPassedColor) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setPassedColorNative(this.swigCPtr, this, 0L, routeLayerPassedColor);
        } else {
            setPassedColorSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, 0L, routeLayerPassedColor);
        }
    }

    public void setRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        $explicit_setRouteDrawParam(routeLayerDrawParam);
    }

    public void $explicit_setRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setRouteDrawParamNative(this.swigCPtr, this, 0L, routeLayerDrawParam);
        } else {
            setRouteDrawParamSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, 0L, routeLayerDrawParam);
        }
    }

    public void getRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        $explicit_getRouteDrawParam(routeLayerDrawParam);
    }

    public void $explicit_getRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            getRouteDrawParamNative(this.swigCPtr, this, 0L, routeLayerDrawParam);
        } else {
            getRouteDrawParamSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, 0L, routeLayerDrawParam);
        }
    }

    public void addRouteItem(@RouteLayerScene.RouteLayerScene1 int i, int i2, byte[] bArr, short s) {
        $explicit_addRouteItem(i, i2, bArr, s);
    }

    public void $explicit_addRouteItem(@RouteLayerScene.RouteLayerScene1 int i, int i2, byte[] bArr, short s) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            addRouteItemNative(this.swigCPtr, this, i, i2, bArr, s);
        } else {
            addRouteItemSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, i, i2, bArr, s);
        }
    }

    public void removeRouteItem() {
        $explicit_removeRouteItem();
    }

    public void $explicit_removeRouteItem() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            removeRouteItemNative(this.swigCPtr, this);
        } else {
            removeRouteItemSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this);
        }
    }

    public boolean isPathIntersectRect(RectDouble rectDouble) {
        return $explicit_isPathIntersectRect(rectDouble);
    }

    public boolean $explicit_isPathIntersectRect(RectDouble rectDouble) {
        if (this.swigCPtr != 0) {
            return getClass() == RoutePathLayerImpl.class ? isPathIntersectRectNative(this.swigCPtr, this, 0L, rectDouble) : isPathIntersectRectSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, 0L, rectDouble);
        }
        throw new NullPointerException();
    }

    public void setHighlightType(@MapRouteHighLightType.MapRouteHighLightType1 int i) {
        $explicit_setHighlightType(i);
    }

    public void $explicit_setHighlightType(@MapRouteHighLightType.MapRouteHighLightType1 int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setHighlightTypeNative(this.swigCPtr, this, i);
        } else {
            setHighlightTypeSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, i);
        }
    }

    public void setSelectStatus(boolean z) {
        $explicit_setSelectStatus(z);
    }

    public void $explicit_setSelectStatus(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setSelectStatusNative(this.swigCPtr, this, z);
        } else {
            setSelectStatusSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, z);
        }
    }

    public boolean getSelectStatus() {
        return $explicit_getSelectStatus();
    }

    public boolean $explicit_getSelectStatus() {
        if (this.swigCPtr != 0) {
            return getClass() == RoutePathLayerImpl.class ? getSelectStatusNative(this.swigCPtr, this) : getSelectStatusSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setShowNaviRouteNameCountMap(HashMap<Integer, Integer> hashMap) {
        $explicit_setShowNaviRouteNameCountMap(hashMap);
    }

    public void $explicit_setShowNaviRouteNameCountMap(HashMap<Integer, Integer> hashMap) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setShowNaviRouteNameCountMapNative(this.swigCPtr, this, hashMap);
        } else {
            setShowNaviRouteNameCountMapSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, hashMap);
        }
    }

    public boolean setDrawType(@MapRoutePolylineDrawType.MapRoutePolylineDrawType1 int i) {
        return $explicit_setDrawType(i);
    }

    public boolean $explicit_setDrawType(@MapRoutePolylineDrawType.MapRoutePolylineDrawType1 int i) {
        if (this.swigCPtr != 0) {
            return getClass() == RoutePathLayerImpl.class ? setDrawTypeNative(this.swigCPtr, this, i) : setDrawTypeSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, i);
        }
        throw new NullPointerException();
    }

    public boolean setGrownAnimation(int i, long j) {
        return $explicit_setGrownAnimation(i, j);
    }

    public boolean $explicit_setGrownAnimation(int i, long j) {
        if (this.swigCPtr != 0) {
            return getClass() == RoutePathLayerImpl.class ? setGrownAnimationNative(this.swigCPtr, this, i, j) : setGrownAnimationSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, i, j);
        }
        throw new NullPointerException();
    }

    public boolean setGrownAnimation(int i) {
        return $explicit_setGrownAnimation(i);
    }

    public boolean $explicit_setGrownAnimation(int i) {
        if (this.swigCPtr != 0) {
            return getClass() == RoutePathLayerImpl.class ? setGrownAnimation1Native(this.swigCPtr, this, i) : setGrownAnimationSwigExplicitRoutePathLayerImpl1Native(this.swigCPtr, this, i);
        }
        throw new NullPointerException();
    }

    public boolean setGrownAnimation(boolean z, int i, long j) {
        return $explicit_setGrownAnimation(z, i, j);
    }

    public boolean $explicit_setGrownAnimation(boolean z, int i, long j) {
        if (this.swigCPtr != 0) {
            return getClass() == RoutePathLayerImpl.class ? setGrownAnimation2Native(this.swigCPtr, this, z, i, j) : setGrownAnimationSwigExplicitRoutePathLayerImpl2Native(this.swigCPtr, this, z, i, j);
        }
        throw new NullPointerException();
    }

    public boolean setGrownAnimation(boolean z, int i) {
        return $explicit_setGrownAnimation(z, i);
    }

    public boolean $explicit_setGrownAnimation(boolean z, int i) {
        if (this.swigCPtr != 0) {
            return getClass() == RoutePathLayerImpl.class ? setGrownAnimation3Native(this.swigCPtr, this, z, i) : setGrownAnimationSwigExplicitRoutePathLayerImpl3Native(this.swigCPtr, this, z, i);
        }
        throw new NullPointerException();
    }

    public boolean addGrownAnimationObserver(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        return $explicit_addGrownAnimationObserver(iLayerItemAnimationObserverImpl);
    }

    public boolean $explicit_addGrownAnimationObserver(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == RoutePathLayerImpl.class ? addGrownAnimationObserverNative(this.swigCPtr, this, ILayerItemAnimationObserverImpl.getCPtr(iLayerItemAnimationObserverImpl), iLayerItemAnimationObserverImpl) : addGrownAnimationObserverSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, ILayerItemAnimationObserverImpl.getCPtr(iLayerItemAnimationObserverImpl), iLayerItemAnimationObserverImpl);
        }
        throw new NullPointerException();
    }

    public boolean removeGrownAnimationObserver(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        return $explicit_removeGrownAnimationObserver(iLayerItemAnimationObserverImpl);
    }

    public boolean $explicit_removeGrownAnimationObserver(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == RoutePathLayerImpl.class ? removeGrownAnimationObserverNative(this.swigCPtr, this, ILayerItemAnimationObserverImpl.getCPtr(iLayerItemAnimationObserverImpl), iLayerItemAnimationObserverImpl) : removeGrownAnimationObserverSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, ILayerItemAnimationObserverImpl.getCPtr(iLayerItemAnimationObserverImpl), iLayerItemAnimationObserverImpl);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void addClickObserver(ILayerClickObserverImpl iLayerClickObserverImpl) {
        $explicit_addClickObserver(iLayerClickObserverImpl);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void $explicit_addClickObserver(ILayerClickObserverImpl iLayerClickObserverImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            addClickObserverNative(this.swigCPtr, this, ILayerClickObserverImpl.getCPtr(iLayerClickObserverImpl), iLayerClickObserverImpl);
        } else {
            addClickObserverSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, ILayerClickObserverImpl.getCPtr(iLayerClickObserverImpl), iLayerClickObserverImpl);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void removeClickObserver(ILayerClickObserverImpl iLayerClickObserverImpl) {
        $explicit_removeClickObserver(iLayerClickObserverImpl);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void $explicit_removeClickObserver(ILayerClickObserverImpl iLayerClickObserverImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            removeClickObserverNative(this.swigCPtr, this, ILayerClickObserverImpl.getCPtr(iLayerClickObserverImpl), iLayerClickObserverImpl);
        } else {
            removeClickObserverSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, ILayerClickObserverImpl.getCPtr(iLayerClickObserverImpl), iLayerClickObserverImpl);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void addFocusChangeObserver(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        $explicit_addFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void $explicit_addFocusChangeObserver(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            addFocusChangeObserverNative(this.swigCPtr, this, ILayerFocusChangeObserverImpl.getCPtr(iLayerFocusChangeObserverImpl), iLayerFocusChangeObserverImpl);
        } else {
            addFocusChangeObserverSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, ILayerFocusChangeObserverImpl.getCPtr(iLayerFocusChangeObserverImpl), iLayerFocusChangeObserverImpl);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void removeFocusChangeObserver(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        $explicit_removeFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void $explicit_removeFocusChangeObserver(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            removeFocusChangeObserverNative(this.swigCPtr, this, ILayerFocusChangeObserverImpl.getCPtr(iLayerFocusChangeObserverImpl), iLayerFocusChangeObserverImpl);
        } else {
            removeFocusChangeObserverSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, ILayerFocusChangeObserverImpl.getCPtr(iLayerFocusChangeObserverImpl), iLayerFocusChangeObserverImpl);
        }
    }

    public void setFilterZoomLevel(float f, float f2) {
        $explicit_setFilterZoomLevel(f, f2);
    }

    public void $explicit_setFilterZoomLevel(float f, float f2) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setFilterZoomLevelNative(this.swigCPtr, this, f, f2);
        } else {
            setFilterZoomLevelSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, f, f2);
        }
    }

    public void addOddItem(ArrayList<LineLayerItemImpl> arrayList) {
        $explicit_addOddItem(arrayList);
    }

    public void $explicit_addOddItem(ArrayList<LineLayerItemImpl> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        long[] jArr = null;
        if (arrayList != null) {
            int size = arrayList.size();
            long[] jArr2 = new long[size];
            for (int i = 0; i < size; i++) {
                jArr2[i] = LineLayerItemImpl.getCPtr(arrayList.get(i));
            }
            jArr = jArr2;
        }
        addOddItemNative(this.swigCPtr, this, jArr);
    }

    public void updateOddLineGrey(long j, long j2, float f) {
        $explicit_updateOddLineGrey(j, j2, f);
    }

    public void $explicit_updateOddLineGrey(long j, long j2, float f) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        updateOddLineGreyNative(j3, this, j, j2, f);
    }

    public void setOddAnimation(boolean z, AnimationStyleParam animationStyleParam) {
        $explicit_setOddAnimation(z, animationStyleParam);
    }

    public void $explicit_setOddAnimation(boolean z, AnimationStyleParam animationStyleParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setOddAnimationNative(j, this, z, 0L, animationStyleParam);
    }

    public void setOddVisible(boolean z) {
        $explicit_setOddVisible(z);
    }

    public void $explicit_setOddVisible(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setOddVisibleNative(j, this, z);
    }

    public boolean getOddVisible() {
        return $explicit_getOddVisible();
    }

    public boolean $explicit_getOddVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getOddVisibleNative(j, this);
    }

    public void setOddDisplayScale(LayerScale layerScale) {
        $explicit_setOddDisplayScale(layerScale);
    }

    public void $explicit_setOddDisplayScale(LayerScale layerScale) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setOddDisplayScaleNative(j, this, 0L, layerScale);
    }

    public void setParkFloor(int i) {
        $explicit_setParkFloor(i);
    }

    public void $explicit_setParkFloor(int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RoutePathLayerImpl.class) {
            setParkFloorNative(this.swigCPtr, this, i);
        } else {
            setParkFloorSwigExplicitRoutePathLayerImplNative(this.swigCPtr, this, i);
        }
    }
}
