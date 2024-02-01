package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.NaviPointLayerItem;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.ItemMarkerInfo;
import com.autonavi.gbl.map.layer.model.LayerItemPoiAnimation;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.RotateMode;
import com.autonavi.gbl.map.layer.model.ScaleInfo;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = NaviPointLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class NaviPointLayerItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(NaviPointLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long NaviPointLayerItemImpl_SWIGUpcast(long j);

    private static native void NaviPointLayerItemImpl_change_ownership(NaviPointLayerItemImpl naviPointLayerItemImpl, long j, boolean z);

    private static native void NaviPointLayerItemImpl_director_connect(NaviPointLayerItemImpl naviPointLayerItemImpl, long j, boolean z, boolean z2);

    private static native boolean addMarkerNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, ItemMarkerInfo itemMarkerInfo);

    private static native boolean addMarkerSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, ItemMarkerInfo itemMarkerInfo);

    private static native void addPoiFilterNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl);

    private static native void addPoiFilterSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl);

    private static native void clearAllMarkersNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl);

    private static native void clearAllMarkersSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean getBillboardNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl);

    private static native boolean getBillboardSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl);

    private static native ArrayList<PixelPoint> getBoundNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl);

    private static native ArrayList<PixelPoint> getBoundSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl);

    private static native String getClassTypeNameNative();

    private static native void getFocusStyleNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, PointLayerItemStyle pointLayerItemStyle);

    private static native void getFocusStyleSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, PointLayerItemStyle pointLayerItemStyle);

    private static native void getItemIgnoreRegionNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, ItemIgnoreRegion itemIgnoreRegion);

    private static native void getItemIgnoreRegionSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, ItemIgnoreRegion itemIgnoreRegion);

    private static native int getItemTypeNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl);

    private static native int getItemTypeSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl);

    private static native void getItemVisibleRegionNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, RectInt rectInt);

    private static native void getItemVisibleRegionSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, RectInt rectInt);

    private static native void getNormalStyleNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, PointLayerItemStyle pointLayerItemStyle);

    private static native void getNormalStyleSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, PointLayerItemStyle pointLayerItemStyle);

    private static native void getPosition3DNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void getPosition3DSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void getPositionNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void getPositionSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void getRotateCenter3DNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void getRotateCenter3DSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void getScaleNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, ScaleInfo scaleInfo);

    private static native void getScaleSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, ScaleInfo scaleInfo);

    private static native void getVisible3VNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Visible3V visible3V);

    private static native void getVisible3VSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Visible3V visible3V);

    private static native void removePoiFilterNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl);

    private static native void removePoiFilterSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl);

    private static native void setAnimationNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, int i, int i2);

    private static native void setAnimationSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, int i, int i2);

    private static native void setBillboardNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, boolean z);

    private static native void setBillboardSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, boolean z);

    private static native void setDepthMaskNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, boolean z);

    private static native void setDepthMaskSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, boolean z);

    private static native void setItemIgnoreRegionNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, ItemIgnoreRegion itemIgnoreRegion);

    private static native void setItemIgnoreRegionSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, ItemIgnoreRegion itemIgnoreRegion);

    private static native void setItemVisibleRegionNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, RectInt rectInt);

    private static native void setItemVisibleRegionSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, RectInt rectInt);

    private static native void setPosition3DNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setPosition3DSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setPositionNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setPositionSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setResolveConflictNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, boolean z);

    private static native void setResolveConflictSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, boolean z);

    private static native void setRotateCenter3DNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setRotateCenter3DSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setRotateCenterNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setRotateCenterSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setRotateModeNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, int i);

    private static native void setRotateModeSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, int i);

    private static native void setScaleFactorNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, float[] fArr);

    private static native void setScaleFactorSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, float[] fArr);

    private static native void setScaleNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, ScaleInfo scaleInfo);

    private static native void setScaleSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, ScaleInfo scaleInfo);

    private static native void setVisible3VNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Visible3V visible3V);

    private static native void setVisible3VSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl, long j2, Visible3V visible3V);

    private static native void updateStyleNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl);

    private static native void updateStyleSwigExplicitNaviPointLayerItemImplNative(long j, NaviPointLayerItemImpl naviPointLayerItemImpl);

    public NaviPointLayerItemImpl(long j, boolean z) {
        super(NaviPointLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof NaviPointLayerItemImpl) {
            return getUID(this) == getUID((NaviPointLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        long cPtr = getCPtr(naviPointLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        if (naviPointLayerItemImpl == null) {
            return 0L;
        }
        return naviPointLayerItemImpl.swigCPtr;
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
        NaviPointLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        NaviPointLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public NaviPointLayerItemImpl() {
        this(createNativeObj(), true);
        MapLayerSvrJNI.swig_jni_init();
        NaviPointLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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
            return getClass() == NaviPointLayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setDepthMask(boolean z) {
        $explicit_setDepthMask(z);
    }

    public void $explicit_setDepthMask(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            setDepthMaskNative(this.swigCPtr, this, z);
        } else {
            setDepthMaskSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public void setResolveConflict(boolean z) {
        $explicit_setResolveConflict(z);
    }

    public void $explicit_setResolveConflict(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            setResolveConflictNative(this.swigCPtr, this, z);
        } else {
            setResolveConflictSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public void setVisible3V(Visible3V visible3V) {
        $explicit_setVisible3V(visible3V);
    }

    public void $explicit_setVisible3V(Visible3V visible3V) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            setVisible3VNative(this.swigCPtr, this, 0L, visible3V);
        } else {
            setVisible3VSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, visible3V);
        }
    }

    public void getVisible3V(Visible3V visible3V) {
        $explicit_getVisible3V(visible3V);
    }

    public void $explicit_getVisible3V(Visible3V visible3V) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            getVisible3VNative(this.swigCPtr, this, 0L, visible3V);
        } else {
            getVisible3VSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, visible3V);
        }
    }

    public void setBillboard(boolean z) {
        $explicit_setBillboard(z);
    }

    public void $explicit_setBillboard(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            setBillboardNative(this.swigCPtr, this, z);
        } else {
            setBillboardSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public boolean getBillboard() {
        return $explicit_getBillboard();
    }

    public boolean $explicit_getBillboard() {
        if (this.swigCPtr != 0) {
            return getClass() == NaviPointLayerItemImpl.class ? getBillboardNative(this.swigCPtr, this) : getBillboardSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setPosition3D(Coord3DDouble coord3DDouble) {
        $explicit_setPosition3D(coord3DDouble);
    }

    public void $explicit_setPosition3D(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            setPosition3DNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            setPosition3DSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void getPosition3D(Coord3DDouble coord3DDouble) {
        $explicit_getPosition3D(coord3DDouble);
    }

    public void $explicit_getPosition3D(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            getPosition3DNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            getPosition3DSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void setRotateCenter3D(Coord3DDouble coord3DDouble) {
        $explicit_setRotateCenter3D(coord3DDouble);
    }

    public void $explicit_setRotateCenter3D(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            setRotateCenter3DNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            setRotateCenter3DSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $explicit_getRotateCenter3D(coord3DDouble);
    }

    public void $explicit_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            getRotateCenter3DNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            getRotateCenter3DSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void setPosition(Coord3DDouble coord3DDouble) {
        $explicit_setPosition(coord3DDouble);
    }

    public void $explicit_setPosition(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            setPositionNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            setPositionSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void getPosition(Coord3DDouble coord3DDouble) {
        $explicit_getPosition(coord3DDouble);
    }

    public void $explicit_getPosition(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            getPositionNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            getPositionSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void setRotateCenter(Coord3DDouble coord3DDouble) {
        $explicit_setRotateCenter(coord3DDouble);
    }

    public void $explicit_setRotateCenter(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            setRotateCenterNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            setRotateCenterSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void getNormalStyle(PointLayerItemStyle pointLayerItemStyle) {
        $explicit_getNormalStyle(pointLayerItemStyle);
    }

    public void $explicit_getNormalStyle(PointLayerItemStyle pointLayerItemStyle) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            getNormalStyleNative(this.swigCPtr, this, 0L, pointLayerItemStyle);
        } else {
            getNormalStyleSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, pointLayerItemStyle);
        }
    }

    public void getFocusStyle(PointLayerItemStyle pointLayerItemStyle) {
        $explicit_getFocusStyle(pointLayerItemStyle);
    }

    public void $explicit_getFocusStyle(PointLayerItemStyle pointLayerItemStyle) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            getFocusStyleNative(this.swigCPtr, this, 0L, pointLayerItemStyle);
        } else {
            getFocusStyleSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, pointLayerItemStyle);
        }
    }

    public void setItemVisibleRegion(RectInt rectInt) {
        $explicit_setItemVisibleRegion(rectInt);
    }

    public void $explicit_setItemVisibleRegion(RectInt rectInt) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            setItemVisibleRegionNative(this.swigCPtr, this, 0L, rectInt);
        } else {
            setItemVisibleRegionSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, rectInt);
        }
    }

    public void getItemVisibleRegion(RectInt rectInt) {
        $explicit_getItemVisibleRegion(rectInt);
    }

    public void $explicit_getItemVisibleRegion(RectInt rectInt) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            getItemVisibleRegionNative(this.swigCPtr, this, 0L, rectInt);
        } else {
            getItemVisibleRegionSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, rectInt);
        }
    }

    public void setItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        $explicit_setItemIgnoreRegion(itemIgnoreRegion);
    }

    public void $explicit_setItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            setItemIgnoreRegionNative(this.swigCPtr, this, 0L, itemIgnoreRegion);
        } else {
            setItemIgnoreRegionSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, itemIgnoreRegion);
        }
    }

    public void getItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        $explicit_getItemIgnoreRegion(itemIgnoreRegion);
    }

    public void $explicit_getItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            getItemIgnoreRegionNative(this.swigCPtr, this, 0L, itemIgnoreRegion);
        } else {
            getItemIgnoreRegionSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, itemIgnoreRegion);
        }
    }

    public void setScaleFactor(float[] fArr) {
        $explicit_setScaleFactor(fArr);
    }

    public void $explicit_setScaleFactor(float[] fArr) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            setScaleFactorNative(this.swigCPtr, this, fArr);
        } else {
            setScaleFactorSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, fArr);
        }
    }

    public void setScale(ScaleInfo scaleInfo) {
        $explicit_setScale(scaleInfo);
    }

    public void $explicit_setScale(ScaleInfo scaleInfo) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            setScaleNative(this.swigCPtr, this, 0L, scaleInfo);
        } else {
            setScaleSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, scaleInfo);
        }
    }

    public void getScale(ScaleInfo scaleInfo) {
        $explicit_getScale(scaleInfo);
    }

    public void $explicit_getScale(ScaleInfo scaleInfo) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            getScaleNative(this.swigCPtr, this, 0L, scaleInfo);
        } else {
            getScaleSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, scaleInfo);
        }
    }

    public void setRotateMode(@RotateMode.RotateMode1 int i) {
        $explicit_setRotateMode(i);
    }

    public void $explicit_setRotateMode(@RotateMode.RotateMode1 int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            setRotateModeNative(this.swigCPtr, this, i);
        } else {
            setRotateModeSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, i);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void setAnimation(@LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        $explicit_setAnimation(i, i2);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_setAnimation(@LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            setAnimationNative(this.swigCPtr, this, i, i2);
        } else {
            setAnimationSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, i, i2);
        }
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
        if (getClass() == NaviPointLayerItemImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void addPoiFilter() {
        $explicit_addPoiFilter();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_addPoiFilter() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            addPoiFilterNative(this.swigCPtr, this);
        } else {
            addPoiFilterSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void removePoiFilter() {
        $explicit_removePoiFilter();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_removePoiFilter() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            removePoiFilterNative(this.swigCPtr, this);
        } else {
            removePoiFilterSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        return $explicit_getBound();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public ArrayList<PixelPoint> $explicit_getBound() {
        if (this.swigCPtr != 0) {
            return getClass() == NaviPointLayerItemImpl.class ? getBoundNative(this.swigCPtr, this) : getBoundSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public boolean addMarker(ItemMarkerInfo itemMarkerInfo) {
        return $explicit_addMarker(itemMarkerInfo);
    }

    public boolean $explicit_addMarker(ItemMarkerInfo itemMarkerInfo) {
        if (this.swigCPtr != 0) {
            return getClass() == NaviPointLayerItemImpl.class ? addMarkerNative(this.swigCPtr, this, 0L, itemMarkerInfo) : addMarkerSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this, 0L, itemMarkerInfo);
        }
        throw new NullPointerException();
    }

    public void clearAllMarkers() {
        $explicit_clearAllMarkers();
    }

    public void $explicit_clearAllMarkers() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == NaviPointLayerItemImpl.class) {
            clearAllMarkersNative(this.swigCPtr, this);
        } else {
            clearAllMarkersSwigExplicitNaviPointLayerItemImplNative(this.swigCPtr, this);
        }
    }
}
