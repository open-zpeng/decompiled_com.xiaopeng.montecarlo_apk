package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.MapModelLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.ModelDescInfo;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = MapModelLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class MapModelLayerItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(MapModelLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long MapModelLayerItemImpl_SWIGUpcast(long j);

    private static native void MapModelLayerItemImpl_change_ownership(MapModelLayerItemImpl mapModelLayerItemImpl, long j, boolean z);

    private static native void MapModelLayerItemImpl_director_connect(MapModelLayerItemImpl mapModelLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native boolean getDepthMaskNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl);

    private static native boolean getDepthMaskSwigExplicitMapModelLayerItemImplNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl);

    private static native int getItemTypeNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl);

    private static native int getItemTypeSwigExplicitMapModelLayerItemImplNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl);

    private static native int getModelIDNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl);

    private static native int getModelIDSwigExplicitMapModelLayerItemImplNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl);

    private static native void setDepthMaskNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl, boolean z);

    private static native void setDepthMaskSwigExplicitMapModelLayerItemImplNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl, boolean z);

    private static native void setMaxPitchAxisOffsetNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl, float f);

    private static native void setMaxPitchAxisOffsetSwigExplicitMapModelLayerItemImplNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl, float f);

    private static native void setModelDescInfoNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl, long j2, ModelDescInfo modelDescInfo);

    private static native void setModelDescInfoSwigExplicitMapModelLayerItemImplNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl, long j2, ModelDescInfo modelDescInfo);

    private static native void setPos3DNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setPos3DSwigExplicitMapModelLayerItemImplNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setPosNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setPosSwigExplicitMapModelLayerItemImplNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setResolveConflictNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl, boolean z);

    private static native void setResolveConflictSwigExplicitMapModelLayerItemImplNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl, boolean z);

    private static native void setScaleNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl, float f);

    private static native void setScaleSwigExplicitMapModelLayerItemImplNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl, float f);

    private static native void updateStyleNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl);

    private static native void updateStyleSwigExplicitMapModelLayerItemImplNative(long j, MapModelLayerItemImpl mapModelLayerItemImpl);

    public MapModelLayerItemImpl(long j, boolean z) {
        super(MapModelLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof MapModelLayerItemImpl) {
            return getUID(this) == getUID((MapModelLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(MapModelLayerItemImpl mapModelLayerItemImpl) {
        long cPtr = getCPtr(mapModelLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(MapModelLayerItemImpl mapModelLayerItemImpl) {
        if (mapModelLayerItemImpl == null) {
            return 0L;
        }
        return mapModelLayerItemImpl.swigCPtr;
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
        MapModelLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        MapModelLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public MapModelLayerItemImpl() {
        this(createNativeObj(), true);
        MapLayerSvrJNI.swig_jni_init();
        MapModelLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
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
        if (getClass() == MapModelLayerItemImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitMapModelLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public int getModelID() {
        return $explicit_getModelID();
    }

    public int $explicit_getModelID() {
        if (this.swigCPtr != 0) {
            return getClass() == MapModelLayerItemImpl.class ? getModelIDNative(this.swigCPtr, this) : getModelIDSwigExplicitMapModelLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
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
            return getClass() == MapModelLayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitMapModelLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setModelDescInfo(ModelDescInfo modelDescInfo) {
        $explicit_setModelDescInfo(modelDescInfo);
    }

    public void $explicit_setModelDescInfo(ModelDescInfo modelDescInfo) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MapModelLayerItemImpl.class) {
            setModelDescInfoNative(this.swigCPtr, this, 0L, modelDescInfo);
        } else {
            setModelDescInfoSwigExplicitMapModelLayerItemImplNative(this.swigCPtr, this, 0L, modelDescInfo);
        }
    }

    public void setPos(Coord3DDouble coord3DDouble) {
        $explicit_setPos(coord3DDouble);
    }

    public void $explicit_setPos(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MapModelLayerItemImpl.class) {
            setPosNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            setPosSwigExplicitMapModelLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void setPos3D(Coord3DDouble coord3DDouble) {
        $explicit_setPos3D(coord3DDouble);
    }

    public void $explicit_setPos3D(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MapModelLayerItemImpl.class) {
            setPos3DNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            setPos3DSwigExplicitMapModelLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void setScale(float f) {
        $explicit_setScale(f);
    }

    public void $explicit_setScale(float f) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MapModelLayerItemImpl.class) {
            setScaleNative(this.swigCPtr, this, f);
        } else {
            setScaleSwigExplicitMapModelLayerItemImplNative(this.swigCPtr, this, f);
        }
    }

    public void setDepthMask(boolean z) {
        $explicit_setDepthMask(z);
    }

    public void $explicit_setDepthMask(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MapModelLayerItemImpl.class) {
            setDepthMaskNative(this.swigCPtr, this, z);
        } else {
            setDepthMaskSwigExplicitMapModelLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public boolean getDepthMask() {
        return $explicit_getDepthMask();
    }

    public boolean $explicit_getDepthMask() {
        if (this.swigCPtr != 0) {
            return getClass() == MapModelLayerItemImpl.class ? getDepthMaskNative(this.swigCPtr, this) : getDepthMaskSwigExplicitMapModelLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setResolveConflict(boolean z) {
        $explicit_setResolveConflict(z);
    }

    public void $explicit_setResolveConflict(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MapModelLayerItemImpl.class) {
            setResolveConflictNative(this.swigCPtr, this, z);
        } else {
            setResolveConflictSwigExplicitMapModelLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public void setMaxPitchAxisOffset(float f) {
        $explicit_setMaxPitchAxisOffset(f);
    }

    public void $explicit_setMaxPitchAxisOffset(float f) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MapModelLayerItemImpl.class) {
            setMaxPitchAxisOffsetNative(this.swigCPtr, this, f);
        } else {
            setMaxPitchAxisOffsetSwigExplicitMapModelLayerItemImplNative(this.swigCPtr, this, f);
        }
    }
}
