package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.SectorLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.SectorAngles;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = SectorLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class SectorLayerItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SectorLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long SectorLayerItemImpl_SWIGUpcast(long j);

    private static native void SectorLayerItemImpl_change_ownership(SectorLayerItemImpl sectorLayerItemImpl, long j, boolean z);

    private static native void SectorLayerItemImpl_director_connect(SectorLayerItemImpl sectorLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native long getColorNative(long j, SectorLayerItemImpl sectorLayerItemImpl);

    private static native long getColorSwigExplicitSectorLayerItemImplNative(long j, SectorLayerItemImpl sectorLayerItemImpl);

    private static native int getItemTypeNative(long j, SectorLayerItemImpl sectorLayerItemImpl);

    private static native int getItemTypeSwigExplicitSectorLayerItemImplNative(long j, SectorLayerItemImpl sectorLayerItemImpl);

    private static native double getRadiusNative(long j, SectorLayerItemImpl sectorLayerItemImpl);

    private static native double getRadiusSwigExplicitSectorLayerItemImplNative(long j, SectorLayerItemImpl sectorLayerItemImpl);

    private static native void getSectorAnglesNative(long j, SectorLayerItemImpl sectorLayerItemImpl, long j2, SectorAngles sectorAngles);

    private static native void getSectorAnglesSwigExplicitSectorLayerItemImplNative(long j, SectorLayerItemImpl sectorLayerItemImpl, long j2, SectorAngles sectorAngles);

    private static native void setColorNative(long j, SectorLayerItemImpl sectorLayerItemImpl, long j2);

    private static native void setColorSwigExplicitSectorLayerItemImplNative(long j, SectorLayerItemImpl sectorLayerItemImpl, long j2);

    private static native void setPositionNative(long j, SectorLayerItemImpl sectorLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setPositionSwigExplicitSectorLayerItemImplNative(long j, SectorLayerItemImpl sectorLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setRadiusNative(long j, SectorLayerItemImpl sectorLayerItemImpl, double d);

    private static native void setRadiusSwigExplicitSectorLayerItemImplNative(long j, SectorLayerItemImpl sectorLayerItemImpl, double d);

    private static native void setSectorAnglesNative(long j, SectorLayerItemImpl sectorLayerItemImpl, long j2, SectorAngles sectorAngles);

    private static native void setSectorAnglesSwigExplicitSectorLayerItemImplNative(long j, SectorLayerItemImpl sectorLayerItemImpl, long j2, SectorAngles sectorAngles);

    private static native void updateStyleNative(long j, SectorLayerItemImpl sectorLayerItemImpl);

    private static native void updateStyleSwigExplicitSectorLayerItemImplNative(long j, SectorLayerItemImpl sectorLayerItemImpl);

    public SectorLayerItemImpl(long j, boolean z) {
        super(SectorLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof SectorLayerItemImpl) {
            return getUID(this) == getUID((SectorLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(SectorLayerItemImpl sectorLayerItemImpl) {
        long cPtr = getCPtr(sectorLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(SectorLayerItemImpl sectorLayerItemImpl) {
        if (sectorLayerItemImpl == null) {
            return 0L;
        }
        return sectorLayerItemImpl.swigCPtr;
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
        SectorLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        SectorLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public SectorLayerItemImpl() {
        this(createNativeObj(), true);
        MapLayerSvrJNI.swig_jni_init();
        SectorLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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
            return getClass() == SectorLayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitSectorLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setPosition(Coord3DDouble coord3DDouble) {
        $explicit_setPosition(coord3DDouble);
    }

    public void $explicit_setPosition(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SectorLayerItemImpl.class) {
            setPositionNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            setPositionSwigExplicitSectorLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void setRadius(double d) {
        $explicit_setRadius(d);
    }

    public void $explicit_setRadius(double d) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SectorLayerItemImpl.class) {
            setRadiusNative(this.swigCPtr, this, d);
        } else {
            setRadiusSwigExplicitSectorLayerItemImplNative(this.swigCPtr, this, d);
        }
    }

    public void setSectorAngles(SectorAngles sectorAngles) {
        $explicit_setSectorAngles(sectorAngles);
    }

    public void $explicit_setSectorAngles(SectorAngles sectorAngles) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SectorLayerItemImpl.class) {
            setSectorAnglesNative(this.swigCPtr, this, 0L, sectorAngles);
        } else {
            setSectorAnglesSwigExplicitSectorLayerItemImplNative(this.swigCPtr, this, 0L, sectorAngles);
        }
    }

    public void setColor(long j) {
        $explicit_setColor(j);
    }

    public void $explicit_setColor(long j) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SectorLayerItemImpl.class) {
            setColorNative(this.swigCPtr, this, j);
        } else {
            setColorSwigExplicitSectorLayerItemImplNative(this.swigCPtr, this, j);
        }
    }

    public double getRadius() {
        return $explicit_getRadius();
    }

    public double $explicit_getRadius() {
        if (this.swigCPtr != 0) {
            return getClass() == SectorLayerItemImpl.class ? getRadiusNative(this.swigCPtr, this) : getRadiusSwigExplicitSectorLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void getSectorAngles(SectorAngles sectorAngles) {
        $explicit_getSectorAngles(sectorAngles);
    }

    public void $explicit_getSectorAngles(SectorAngles sectorAngles) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SectorLayerItemImpl.class) {
            getSectorAnglesNative(this.swigCPtr, this, 0L, sectorAngles);
        } else {
            getSectorAnglesSwigExplicitSectorLayerItemImplNative(this.swigCPtr, this, 0L, sectorAngles);
        }
    }

    public long getColor() {
        return $explicit_getColor();
    }

    public long $explicit_getColor() {
        if (this.swigCPtr != 0) {
            return getClass() == SectorLayerItemImpl.class ? getColorNative(this.swigCPtr, this) : getColorSwigExplicitSectorLayerItemImplNative(this.swigCPtr, this);
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
        if (getClass() == SectorLayerItemImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitSectorLayerItemImplNative(this.swigCPtr, this);
        }
    }
}
