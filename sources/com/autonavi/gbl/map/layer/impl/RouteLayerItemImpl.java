package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.RouteLayerItem;
import com.autonavi.gbl.map.layer.model.AnimationStyleParam;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.MapRouteHighLightType;
import com.autonavi.gbl.map.layer.model.MapRoutePolylineDrawType;
import com.autonavi.gbl.map.layer.model.RouteLayerDrawParam;
import com.autonavi.gbl.map.layer.model.RouteLayerParam;
import com.autonavi.gbl.map.layer.model.RouteLayerPassedColor;
import com.autonavi.gbl.map.layer.model.RouteLayerScene;
import com.autonavi.gbl.map.layer.observer.impl.ILayerItemAnimationObserverImpl;
import java.util.ArrayList;
import java.util.HashMap;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = RouteLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RouteLayerItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteLayerItemImpl_change_ownership(RouteLayerItemImpl routeLayerItemImpl, long j, boolean z);

    private static native void RouteLayerItemImpl_director_connect(RouteLayerItemImpl routeLayerItemImpl, long j, boolean z, boolean z2);

    private static native boolean addGrownAnimationObserverNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl);

    private static native boolean addGrownAnimationObserverSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl);

    private static native void addOddItemNative(long j, RouteLayerItemImpl routeLayerItemImpl, long[] jArr);

    private static native void addOddItemSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, long[] jArr);

    private static native void addRouteItemNative(long j, RouteLayerItemImpl routeLayerItemImpl, int i, int i2, byte[] bArr, short s);

    private static native void addRouteItemSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, int i, int i2, byte[] bArr, short s);

    private static native void addRouteNameNative(long j, RouteLayerItemImpl routeLayerItemImpl);

    private static native void addRouteNameSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl);

    private static native long createNativeObj(long j, IMapViewImpl iMapViewImpl);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native void getDisplayScaleNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, LayerScale layerScale);

    private static native void getDisplayScaleSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, LayerScale layerScale);

    private static native int getItemTypeNative(long j, RouteLayerItemImpl routeLayerItemImpl);

    private static native int getItemTypeSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl);

    private static native void getRouteDrawParamNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, RouteLayerDrawParam routeLayerDrawParam);

    private static native void getRouteDrawParamSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, RouteLayerDrawParam routeLayerDrawParam);

    private static native boolean getSelectStatusNative(long j, RouteLayerItemImpl routeLayerItemImpl);

    private static native boolean getSelectStatusSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl);

    private static native boolean isPathIntersectRectNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, RectDouble rectDouble);

    private static native boolean isPathIntersectRectSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, RectDouble rectDouble);

    private static native boolean removeGrownAnimationObserverNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl);

    private static native boolean removeGrownAnimationObserverSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl);

    private static native void removeRouteItemNative(long j, RouteLayerItemImpl routeLayerItemImpl);

    private static native void removeRouteItemSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl);

    private static native void removeRouteNameNative(long j, RouteLayerItemImpl routeLayerItemImpl);

    private static native void removeRouteNameSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl);

    private static native void setCar2DPositionNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, float f);

    private static native void setCar2DPositionSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, float f);

    private static native void setCar3DPositionNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, float f);

    private static native void setCar3DPositionSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, float f);

    private static native void setDisplayScaleNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, LayerScale layerScale);

    private static native void setDisplayScaleSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, LayerScale layerScale);

    private static native boolean setDrawTypeNative(long j, RouteLayerItemImpl routeLayerItemImpl, int i);

    private static native boolean setDrawTypeSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, int i);

    private static native void setFilterZoomLevelNative(long j, RouteLayerItemImpl routeLayerItemImpl, float f, float f2);

    private static native void setFilterZoomLevelSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, float f, float f2);

    private static native boolean setGrownAnimation1Native(long j, RouteLayerItemImpl routeLayerItemImpl, int i);

    private static native boolean setGrownAnimation2Native(long j, RouteLayerItemImpl routeLayerItemImpl, boolean z, int i, long j2);

    private static native boolean setGrownAnimation3Native(long j, RouteLayerItemImpl routeLayerItemImpl, boolean z, int i);

    private static native boolean setGrownAnimationNative(long j, RouteLayerItemImpl routeLayerItemImpl, int i, long j2);

    private static native boolean setGrownAnimationSwigExplicitRouteLayerItemImpl1Native(long j, RouteLayerItemImpl routeLayerItemImpl, int i);

    private static native boolean setGrownAnimationSwigExplicitRouteLayerItemImpl2Native(long j, RouteLayerItemImpl routeLayerItemImpl, boolean z, int i, long j2);

    private static native boolean setGrownAnimationSwigExplicitRouteLayerItemImpl3Native(long j, RouteLayerItemImpl routeLayerItemImpl, boolean z, int i);

    private static native boolean setGrownAnimationSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, int i, long j2);

    private static native void setHighlightTypeNative(long j, RouteLayerItemImpl routeLayerItemImpl, int i);

    private static native void setHighlightTypeSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, int i);

    private static native void setLineWidthScaleNative(long j, RouteLayerItemImpl routeLayerItemImpl, float f);

    private static native void setLineWidthScaleSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, float f);

    private static native void setOddAnimationNative(long j, RouteLayerItemImpl routeLayerItemImpl, boolean z, long j2, AnimationStyleParam animationStyleParam);

    private static native void setOddAnimationSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, boolean z, long j2, AnimationStyleParam animationStyleParam);

    private static native void setParkFloorNative(long j, RouteLayerItemImpl routeLayerItemImpl, int i);

    private static native void setParkFloorSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, int i);

    private static native void setPassedColorNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, RouteLayerPassedColor routeLayerPassedColor);

    private static native void setPassedColorSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, RouteLayerPassedColor routeLayerPassedColor);

    private static native void setRouteDrawParamNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, RouteLayerDrawParam routeLayerDrawParam);

    private static native void setRouteDrawParamSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, RouteLayerDrawParam routeLayerDrawParam);

    private static native void setRouteItemParamNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, RouteLayerParam routeLayerParam);

    private static native void setRouteItemParamSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, long j2, RouteLayerParam routeLayerParam);

    private static native void setRouteItemParamsNative(long j, RouteLayerItemImpl routeLayerItemImpl, ArrayList<RouteLayerParam> arrayList);

    private static native void setRouteItemParamsSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, ArrayList<RouteLayerParam> arrayList);

    private static native void setSelectStatusNative(long j, RouteLayerItemImpl routeLayerItemImpl, boolean z);

    private static native void setSelectStatusSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, boolean z);

    private static native void setShowNaviRouteNameCountMapNative(long j, RouteLayerItemImpl routeLayerItemImpl, HashMap<Integer, Integer> hashMap);

    private static native void setShowNaviRouteNameCountMapSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl, HashMap<Integer, Integer> hashMap);

    private static native void updateStyleNative(long j, RouteLayerItemImpl routeLayerItemImpl);

    private static native void updateStyleSwigExplicitRouteLayerItemImplNative(long j, RouteLayerItemImpl routeLayerItemImpl);

    public RouteLayerItemImpl(long j, boolean z) {
        super(RouteLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof RouteLayerItemImpl) {
            return getUID(this) == getUID((RouteLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RouteLayerItemImpl routeLayerItemImpl) {
        long cPtr = getCPtr(routeLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RouteLayerItemImpl routeLayerItemImpl) {
        if (routeLayerItemImpl == null) {
            return 0L;
        }
        return routeLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        RouteLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteLayerItemImpl(IMapViewImpl iMapViewImpl) {
        this(createNativeObj(IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl), true);
        MapLayerSvrJNI.swig_jni_init();
        RouteLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        return $explicit_getItemType();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int $explicit_getItemType() {
        if (this.swigCPtr != 0) {
            return getClass() == RouteLayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void updateStyle() {
        $explicit_updateStyle();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_updateStyle() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void setDisplayScale(LayerScale layerScale) {
        $explicit_setDisplayScale(layerScale);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_setDisplayScale(LayerScale layerScale) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            setDisplayScaleNative(this.swigCPtr, this, 0L, layerScale);
        } else {
            setDisplayScaleSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, 0L, layerScale);
        }
    }

    public void getDisplayScale(LayerScale layerScale) {
        $explicit_getDisplayScale(layerScale);
    }

    public void $explicit_getDisplayScale(LayerScale layerScale) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            getDisplayScaleNative(this.swigCPtr, this, 0L, layerScale);
        } else {
            getDisplayScaleSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, 0L, layerScale);
        }
    }

    public void setCar2DPosition(long j, float f) {
        $explicit_setCar2DPosition(j, f);
    }

    public void $explicit_setCar2DPosition(long j, float f) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            setCar2DPositionNative(this.swigCPtr, this, j, f);
        } else {
            setCar2DPositionSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, j, f);
        }
    }

    public void setCar3DPosition(long j, float f) {
        $explicit_setCar3DPosition(j, f);
    }

    public void $explicit_setCar3DPosition(long j, float f) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            setCar3DPositionNative(this.swigCPtr, this, j, f);
        } else {
            setCar3DPositionSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, j, f);
        }
    }

    public void addRouteName() {
        $explicit_addRouteName();
    }

    public void $explicit_addRouteName() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            addRouteNameNative(this.swigCPtr, this);
        } else {
            addRouteNameSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void removeRouteName() {
        $explicit_removeRouteName();
    }

    public void $explicit_removeRouteName() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            removeRouteNameNative(this.swigCPtr, this);
        } else {
            removeRouteNameSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void setLineWidthScale(float f) {
        $explicit_setLineWidthScale(f);
    }

    public void $explicit_setLineWidthScale(float f) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            setLineWidthScaleNative(this.swigCPtr, this, f);
        } else {
            setLineWidthScaleSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, f);
        }
    }

    public void setRouteItemParam(RouteLayerParam routeLayerParam) {
        $explicit_setRouteItemParam(routeLayerParam);
    }

    public void $explicit_setRouteItemParam(RouteLayerParam routeLayerParam) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            setRouteItemParamNative(this.swigCPtr, this, 0L, routeLayerParam);
        } else {
            setRouteItemParamSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, 0L, routeLayerParam);
        }
    }

    public void setRouteItemParams(ArrayList<RouteLayerParam> arrayList) {
        $explicit_setRouteItemParams(arrayList);
    }

    public void $explicit_setRouteItemParams(ArrayList<RouteLayerParam> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            setRouteItemParamsNative(this.swigCPtr, this, arrayList);
        } else {
            setRouteItemParamsSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, arrayList);
        }
    }

    public void setPassedColor(RouteLayerPassedColor routeLayerPassedColor) {
        $explicit_setPassedColor(routeLayerPassedColor);
    }

    public void $explicit_setPassedColor(RouteLayerPassedColor routeLayerPassedColor) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            setPassedColorNative(this.swigCPtr, this, 0L, routeLayerPassedColor);
        } else {
            setPassedColorSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, 0L, routeLayerPassedColor);
        }
    }

    public void setRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        $explicit_setRouteDrawParam(routeLayerDrawParam);
    }

    public void $explicit_setRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            setRouteDrawParamNative(this.swigCPtr, this, 0L, routeLayerDrawParam);
        } else {
            setRouteDrawParamSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, 0L, routeLayerDrawParam);
        }
    }

    public void getRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        $explicit_getRouteDrawParam(routeLayerDrawParam);
    }

    public void $explicit_getRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            getRouteDrawParamNative(this.swigCPtr, this, 0L, routeLayerDrawParam);
        } else {
            getRouteDrawParamSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, 0L, routeLayerDrawParam);
        }
    }

    public void addRouteItem(@RouteLayerScene.RouteLayerScene1 int i, int i2, byte[] bArr, short s) {
        $explicit_addRouteItem(i, i2, bArr, s);
    }

    public void $explicit_addRouteItem(@RouteLayerScene.RouteLayerScene1 int i, int i2, byte[] bArr, short s) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            addRouteItemNative(this.swigCPtr, this, i, i2, bArr, s);
        } else {
            addRouteItemSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, i, i2, bArr, s);
        }
    }

    public void removeRouteItem() {
        $explicit_removeRouteItem();
    }

    public void $explicit_removeRouteItem() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            removeRouteItemNative(this.swigCPtr, this);
        } else {
            removeRouteItemSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public boolean isPathIntersectRect(RectDouble rectDouble) {
        return $explicit_isPathIntersectRect(rectDouble);
    }

    public boolean $explicit_isPathIntersectRect(RectDouble rectDouble) {
        if (this.swigCPtr != 0) {
            return getClass() == RouteLayerItemImpl.class ? isPathIntersectRectNative(this.swigCPtr, this, 0L, rectDouble) : isPathIntersectRectSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, 0L, rectDouble);
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
        if (getClass() == RouteLayerItemImpl.class) {
            setHighlightTypeNative(this.swigCPtr, this, i);
        } else {
            setHighlightTypeSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, i);
        }
    }

    public void setSelectStatus(boolean z) {
        $explicit_setSelectStatus(z);
    }

    public void $explicit_setSelectStatus(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            setSelectStatusNative(this.swigCPtr, this, z);
        } else {
            setSelectStatusSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public boolean getSelectStatus() {
        return $explicit_getSelectStatus();
    }

    public boolean $explicit_getSelectStatus() {
        if (this.swigCPtr != 0) {
            return getClass() == RouteLayerItemImpl.class ? getSelectStatusNative(this.swigCPtr, this) : getSelectStatusSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this);
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
        if (getClass() == RouteLayerItemImpl.class) {
            setShowNaviRouteNameCountMapNative(this.swigCPtr, this, hashMap);
        } else {
            setShowNaviRouteNameCountMapSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, hashMap);
        }
    }

    public boolean setDrawType(@MapRoutePolylineDrawType.MapRoutePolylineDrawType1 int i) {
        return $explicit_setDrawType(i);
    }

    public boolean $explicit_setDrawType(@MapRoutePolylineDrawType.MapRoutePolylineDrawType1 int i) {
        if (this.swigCPtr != 0) {
            return getClass() == RouteLayerItemImpl.class ? setDrawTypeNative(this.swigCPtr, this, i) : setDrawTypeSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, i);
        }
        throw new NullPointerException();
    }

    public boolean setGrownAnimation(int i, long j) {
        return $explicit_setGrownAnimation(i, j);
    }

    public boolean $explicit_setGrownAnimation(int i, long j) {
        if (this.swigCPtr != 0) {
            return getClass() == RouteLayerItemImpl.class ? setGrownAnimationNative(this.swigCPtr, this, i, j) : setGrownAnimationSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, i, j);
        }
        throw new NullPointerException();
    }

    public boolean setGrownAnimation(int i) {
        return $explicit_setGrownAnimation(i);
    }

    public boolean $explicit_setGrownAnimation(int i) {
        if (this.swigCPtr != 0) {
            return getClass() == RouteLayerItemImpl.class ? setGrownAnimation1Native(this.swigCPtr, this, i) : setGrownAnimationSwigExplicitRouteLayerItemImpl1Native(this.swigCPtr, this, i);
        }
        throw new NullPointerException();
    }

    public boolean setGrownAnimation(boolean z, int i, long j) {
        return $explicit_setGrownAnimation(z, i, j);
    }

    public boolean $explicit_setGrownAnimation(boolean z, int i, long j) {
        if (this.swigCPtr != 0) {
            return getClass() == RouteLayerItemImpl.class ? setGrownAnimation2Native(this.swigCPtr, this, z, i, j) : setGrownAnimationSwigExplicitRouteLayerItemImpl2Native(this.swigCPtr, this, z, i, j);
        }
        throw new NullPointerException();
    }

    public boolean setGrownAnimation(boolean z, int i) {
        return $explicit_setGrownAnimation(z, i);
    }

    public boolean $explicit_setGrownAnimation(boolean z, int i) {
        if (this.swigCPtr != 0) {
            return getClass() == RouteLayerItemImpl.class ? setGrownAnimation3Native(this.swigCPtr, this, z, i) : setGrownAnimationSwigExplicitRouteLayerItemImpl3Native(this.swigCPtr, this, z, i);
        }
        throw new NullPointerException();
    }

    public boolean addGrownAnimationObserver(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        return $explicit_addGrownAnimationObserver(iLayerItemAnimationObserverImpl);
    }

    public boolean $explicit_addGrownAnimationObserver(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == RouteLayerItemImpl.class ? addGrownAnimationObserverNative(this.swigCPtr, this, ILayerItemAnimationObserverImpl.getCPtr(iLayerItemAnimationObserverImpl), iLayerItemAnimationObserverImpl) : addGrownAnimationObserverSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, ILayerItemAnimationObserverImpl.getCPtr(iLayerItemAnimationObserverImpl), iLayerItemAnimationObserverImpl);
        }
        throw new NullPointerException();
    }

    public boolean removeGrownAnimationObserver(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        return $explicit_removeGrownAnimationObserver(iLayerItemAnimationObserverImpl);
    }

    public boolean $explicit_removeGrownAnimationObserver(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == RouteLayerItemImpl.class ? removeGrownAnimationObserverNative(this.swigCPtr, this, ILayerItemAnimationObserverImpl.getCPtr(iLayerItemAnimationObserverImpl), iLayerItemAnimationObserverImpl) : removeGrownAnimationObserverSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, ILayerItemAnimationObserverImpl.getCPtr(iLayerItemAnimationObserverImpl), iLayerItemAnimationObserverImpl);
        }
        throw new NullPointerException();
    }

    public void setFilterZoomLevel(float f, float f2) {
        $explicit_setFilterZoomLevel(f, f2);
    }

    public void $explicit_setFilterZoomLevel(float f, float f2) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            setFilterZoomLevelNative(this.swigCPtr, this, f, f2);
        } else {
            setFilterZoomLevelSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, f, f2);
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
        if (getClass() == RouteLayerItemImpl.class) {
            addOddItemNative(this.swigCPtr, this, jArr);
        } else {
            addOddItemSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, jArr);
        }
    }

    public void setOddAnimation(boolean z, AnimationStyleParam animationStyleParam) {
        $explicit_setOddAnimation(z, animationStyleParam);
    }

    public void $explicit_setOddAnimation(boolean z, AnimationStyleParam animationStyleParam) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            setOddAnimationNative(this.swigCPtr, this, z, 0L, animationStyleParam);
        } else {
            setOddAnimationSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, z, 0L, animationStyleParam);
        }
    }

    public void setParkFloor(int i) {
        $explicit_setParkFloor(i);
    }

    public void $explicit_setParkFloor(int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteLayerItemImpl.class) {
            setParkFloorNative(this.swigCPtr, this, i);
        } else {
            setParkFloorSwigExplicitRouteLayerItemImplNative(this.swigCPtr, this, i);
        }
    }
}
