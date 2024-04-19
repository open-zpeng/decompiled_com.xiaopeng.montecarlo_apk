package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.PointLayerItem;
import com.autonavi.gbl.map.layer.model.ForeshorteningCoefParam;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.ItemMarkerInfo;
import com.autonavi.gbl.map.layer.model.LayerItemPoiAnimation;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.PointLayerItemType;
import com.autonavi.gbl.map.layer.model.RotateMode;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.ScaleInfo;
import com.autonavi.gbl.map.layer.model.ScalePriority;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = PointLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class PointLayerItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(PointLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long PointLayerItemImpl_SWIGUpcast(long j);

    private static native void PointLayerItemImpl_change_ownership(PointLayerItemImpl pointLayerItemImpl, long j, boolean z);

    private static native void PointLayerItemImpl_director_connect(PointLayerItemImpl pointLayerItemImpl, long j, boolean z, boolean z2);

    private static native boolean addMarkerNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, ItemMarkerInfo itemMarkerInfo);

    private static native boolean addMarkerSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, ItemMarkerInfo itemMarkerInfo);

    private static native void addPoiFilterNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native void addPoiFilterSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native void clearAllMarkersNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native void clearAllMarkersSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native long createNativeObj();

    private static native long createNativeObj1(int i);

    private static native void destroyNativeObj(long j);

    private static native boolean getBillboardNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native boolean getBillboardSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native ArrayList<PixelPoint> getBoundNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native ArrayList<PixelPoint> getBoundSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native String getClassTypeNameNative();

    private static native void getFocusStyleNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, PointLayerItemStyle pointLayerItemStyle);

    private static native void getFocusStyleSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, PointLayerItemStyle pointLayerItemStyle);

    private static native float getForeshorteningCoefNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native float getForeshorteningCoefSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native void getItemIgnoreRegionNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, ItemIgnoreRegion itemIgnoreRegion);

    private static native void getItemIgnoreRegionSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, ItemIgnoreRegion itemIgnoreRegion);

    private static native int getItemTypeNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native int getItemTypeSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native void getNormalStyleNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, PointLayerItemStyle pointLayerItemStyle);

    private static native void getNormalStyleSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, PointLayerItemStyle pointLayerItemStyle);

    private static native String getPointTypeCodeNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native String getPointTypeCodeSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native void getPositionNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void getPositionSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void getRotateCenter3DNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void getRotateCenter3DSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void getScaleNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, ScaleAttribute scaleAttribute);

    private static native void getScaleSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, ScaleAttribute scaleAttribute);

    private static native void getVisible3VNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Visible3V visible3V);

    private static native void getVisible3VSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Visible3V visible3V);

    private static native void removePoiFilterNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native void removePoiFilterSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native void setAnimationNative(long j, PointLayerItemImpl pointLayerItemImpl, int i, int i2);

    private static native void setAnimationSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, int i, int i2);

    private static native void setBillboardNative(long j, PointLayerItemImpl pointLayerItemImpl, boolean z);

    private static native void setBillboardSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, boolean z);

    private static native void setForeshorteningCoefNative(long j, PointLayerItemImpl pointLayerItemImpl, boolean z, long j2, ForeshorteningCoefParam foreshorteningCoefParam);

    private static native void setForeshorteningCoefSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, boolean z, long j2, ForeshorteningCoefParam foreshorteningCoefParam);

    private static native void setItemIgnoreRegionNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, ItemIgnoreRegion itemIgnoreRegion);

    private static native void setItemIgnoreRegionSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, ItemIgnoreRegion itemIgnoreRegion);

    private static native void setItemVisibleRegionNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, RectInt rectInt);

    private static native void setItemVisibleRegionSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, RectInt rectInt);

    private static native void setPointTypeCodeNative(long j, PointLayerItemImpl pointLayerItemImpl, String str);

    private static native void setPointTypeCodeSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, String str);

    private static native void setPosition3DNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setPosition3DSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setPositionNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setPositionSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setRotateCenter3DNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setRotateCenter3DSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setRotateCenterNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setRotateCenterSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setRotateModeNative(long j, PointLayerItemImpl pointLayerItemImpl, int i);

    private static native void setRotateModeSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, int i);

    private static native void setScaleFactorNative(long j, PointLayerItemImpl pointLayerItemImpl, float[] fArr);

    private static native void setScaleFactorSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, float[] fArr);

    private static native void setScaleNative(long j, PointLayerItemImpl pointLayerItemImpl, int i, long j2, ScaleInfo scaleInfo);

    private static native void setScaleSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, int i, long j2, ScaleInfo scaleInfo);

    private static native void setVisible3VNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Visible3V visible3V);

    private static native void setVisible3VSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl, long j2, Visible3V visible3V);

    private static native void updateStyle1Native(long j, PointLayerItemImpl pointLayerItemImpl, long j2, LayerItemImpl layerItemImpl);

    private static native void updateStyleNative(long j, PointLayerItemImpl pointLayerItemImpl);

    private static native void updateStyleSwigExplicitPointLayerItemImpl1Native(long j, PointLayerItemImpl pointLayerItemImpl, long j2, LayerItemImpl layerItemImpl);

    private static native void updateStyleSwigExplicitPointLayerItemImplNative(long j, PointLayerItemImpl pointLayerItemImpl);

    public PointLayerItemImpl(long j, boolean z) {
        super(PointLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof PointLayerItemImpl) {
            return getUID(this) == getUID((PointLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(PointLayerItemImpl pointLayerItemImpl) {
        long cPtr = getCPtr(pointLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(PointLayerItemImpl pointLayerItemImpl) {
        if (pointLayerItemImpl == null) {
            return 0L;
        }
        return pointLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        PointLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        PointLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public PointLayerItemImpl() {
        this(createNativeObj(), true);
        MapLayerSvrJNI.swig_jni_init();
        PointLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public PointLayerItemImpl(@PointLayerItemType.PointLayerItemType1 int i) {
        this(createNativeObj1(i), true);
        MapLayerSvrJNI.swig_jni_init();
        PointLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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
            return getClass() == PointLayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitPointLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setVisible3V(Visible3V visible3V) {
        $explicit_setVisible3V(visible3V);
    }

    public void $explicit_setVisible3V(Visible3V visible3V) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            setVisible3VNative(this.swigCPtr, this, 0L, visible3V);
        } else {
            setVisible3VSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, visible3V);
        }
    }

    public void getVisible3V(Visible3V visible3V) {
        $explicit_getVisible3V(visible3V);
    }

    public void $explicit_getVisible3V(Visible3V visible3V) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            getVisible3VNative(this.swigCPtr, this, 0L, visible3V);
        } else {
            getVisible3VSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, visible3V);
        }
    }

    public void setBillboard(boolean z) {
        $explicit_setBillboard(z);
    }

    public void $explicit_setBillboard(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            setBillboardNative(this.swigCPtr, this, z);
        } else {
            setBillboardSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public boolean getBillboard() {
        return $explicit_getBillboard();
    }

    public boolean $explicit_getBillboard() {
        if (this.swigCPtr != 0) {
            return getClass() == PointLayerItemImpl.class ? getBillboardNative(this.swigCPtr, this) : getBillboardSwigExplicitPointLayerItemImplNative(this.swigCPtr, this);
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
        if (getClass() == PointLayerItemImpl.class) {
            setPosition3DNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            setPosition3DSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void setRotateCenter3D(Coord3DDouble coord3DDouble) {
        $explicit_setRotateCenter3D(coord3DDouble);
    }

    public void $explicit_setRotateCenter3D(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            setRotateCenter3DNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            setRotateCenter3DSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void getRotateCenter3D(Coord3DDouble coord3DDouble) {
        $explicit_getRotateCenter3D(coord3DDouble);
    }

    public void $explicit_getRotateCenter3D(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            getRotateCenter3DNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            getRotateCenter3DSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void setPosition(Coord3DDouble coord3DDouble) {
        $explicit_setPosition(coord3DDouble);
    }

    public void $explicit_setPosition(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            setPositionNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            setPositionSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void getPosition(Coord3DDouble coord3DDouble) {
        $explicit_getPosition(coord3DDouble);
    }

    public void $explicit_getPosition(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            getPositionNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            getPositionSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void setRotateCenter(Coord3DDouble coord3DDouble) {
        $explicit_setRotateCenter(coord3DDouble);
    }

    public void $explicit_setRotateCenter(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            setRotateCenterNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            setRotateCenterSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void getNormalStyle(PointLayerItemStyle pointLayerItemStyle) {
        $explicit_getNormalStyle(pointLayerItemStyle);
    }

    public void $explicit_getNormalStyle(PointLayerItemStyle pointLayerItemStyle) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            getNormalStyleNative(this.swigCPtr, this, 0L, pointLayerItemStyle);
        } else {
            getNormalStyleSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, pointLayerItemStyle);
        }
    }

    public void getFocusStyle(PointLayerItemStyle pointLayerItemStyle) {
        $explicit_getFocusStyle(pointLayerItemStyle);
    }

    public void $explicit_getFocusStyle(PointLayerItemStyle pointLayerItemStyle) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            getFocusStyleNative(this.swigCPtr, this, 0L, pointLayerItemStyle);
        } else {
            getFocusStyleSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, pointLayerItemStyle);
        }
    }

    public void setItemVisibleRegion(RectInt rectInt) {
        $explicit_setItemVisibleRegion(rectInt);
    }

    public void $explicit_setItemVisibleRegion(RectInt rectInt) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            setItemVisibleRegionNative(this.swigCPtr, this, 0L, rectInt);
        } else {
            setItemVisibleRegionSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, rectInt);
        }
    }

    public void setItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        $explicit_setItemIgnoreRegion(itemIgnoreRegion);
    }

    public void $explicit_setItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            setItemIgnoreRegionNative(this.swigCPtr, this, 0L, itemIgnoreRegion);
        } else {
            setItemIgnoreRegionSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, itemIgnoreRegion);
        }
    }

    public void getItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        $explicit_getItemIgnoreRegion(itemIgnoreRegion);
    }

    public void $explicit_getItemIgnoreRegion(ItemIgnoreRegion itemIgnoreRegion) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            getItemIgnoreRegionNative(this.swigCPtr, this, 0L, itemIgnoreRegion);
        } else {
            getItemIgnoreRegionSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, itemIgnoreRegion);
        }
    }

    public void setScale(@ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        $explicit_setScale(i, scaleInfo);
    }

    public void $explicit_setScale(@ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            setScaleNative(this.swigCPtr, this, i, 0L, scaleInfo);
        } else {
            setScaleSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, i, 0L, scaleInfo);
        }
    }

    public void getScale(ScaleAttribute scaleAttribute) {
        $explicit_getScale(scaleAttribute);
    }

    public void $explicit_getScale(ScaleAttribute scaleAttribute) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            getScaleNative(this.swigCPtr, this, 0L, scaleAttribute);
        } else {
            getScaleSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, scaleAttribute);
        }
    }

    public void setPointTypeCode(String str) {
        $explicit_setPointTypeCode(str);
    }

    public void $explicit_setPointTypeCode(String str) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            setPointTypeCodeNative(this.swigCPtr, this, str);
        } else {
            setPointTypeCodeSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, str);
        }
    }

    public String getPointTypeCode() {
        return $explicit_getPointTypeCode();
    }

    public String $explicit_getPointTypeCode() {
        if (this.swigCPtr != 0) {
            return getClass() == PointLayerItemImpl.class ? getPointTypeCodeNative(this.swigCPtr, this) : getPointTypeCodeSwigExplicitPointLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setScaleFactor(float[] fArr) {
        $explicit_setScaleFactor(fArr);
    }

    public void $explicit_setScaleFactor(float[] fArr) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            setScaleFactorNative(this.swigCPtr, this, fArr);
        } else {
            setScaleFactorSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, fArr);
        }
    }

    public void setRotateMode(@RotateMode.RotateMode1 int i) {
        $explicit_setRotateMode(i);
    }

    public void $explicit_setRotateMode(@RotateMode.RotateMode1 int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            setRotateModeNative(this.swigCPtr, this, i);
        } else {
            setRotateModeSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, i);
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
        if (getClass() == PointLayerItemImpl.class) {
            setAnimationNative(this.swigCPtr, this, i, i2);
        } else {
            setAnimationSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, i, i2);
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
        if (getClass() == PointLayerItemImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitPointLayerItemImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void updateStyle(LayerItemImpl layerItemImpl) {
        $explicit_updateStyle(layerItemImpl);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_updateStyle(LayerItemImpl layerItemImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            updateStyle1Native(this.swigCPtr, this, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl);
        } else {
            updateStyleSwigExplicitPointLayerItemImpl1Native(this.swigCPtr, this, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl);
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
        if (getClass() == PointLayerItemImpl.class) {
            addPoiFilterNative(this.swigCPtr, this);
        } else {
            addPoiFilterSwigExplicitPointLayerItemImplNative(this.swigCPtr, this);
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
        if (getClass() == PointLayerItemImpl.class) {
            removePoiFilterNative(this.swigCPtr, this);
        } else {
            removePoiFilterSwigExplicitPointLayerItemImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        return $explicit_getBound();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public ArrayList<PixelPoint> $explicit_getBound() {
        if (this.swigCPtr != 0) {
            return getClass() == PointLayerItemImpl.class ? getBoundNative(this.swigCPtr, this) : getBoundSwigExplicitPointLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public boolean addMarker(ItemMarkerInfo itemMarkerInfo) {
        return $explicit_addMarker(itemMarkerInfo);
    }

    public boolean $explicit_addMarker(ItemMarkerInfo itemMarkerInfo) {
        if (this.swigCPtr != 0) {
            return getClass() == PointLayerItemImpl.class ? addMarkerNative(this.swigCPtr, this, 0L, itemMarkerInfo) : addMarkerSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, 0L, itemMarkerInfo);
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
        if (getClass() == PointLayerItemImpl.class) {
            clearAllMarkersNative(this.swigCPtr, this);
        } else {
            clearAllMarkersSwigExplicitPointLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void setForeshorteningCoef(boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        $explicit_setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public void $explicit_setForeshorteningCoef(boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PointLayerItemImpl.class) {
            setForeshorteningCoefNative(this.swigCPtr, this, z, 0L, foreshorteningCoefParam);
        } else {
            setForeshorteningCoefSwigExplicitPointLayerItemImplNative(this.swigCPtr, this, z, 0L, foreshorteningCoefParam);
        }
    }

    public float getForeshorteningCoef() {
        return $explicit_getForeshorteningCoef();
    }

    public float $explicit_getForeshorteningCoef() {
        if (this.swigCPtr != 0) {
            return getClass() == PointLayerItemImpl.class ? getForeshorteningCoefNative(this.swigCPtr, this) : getForeshorteningCoefSwigExplicitPointLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }
}
