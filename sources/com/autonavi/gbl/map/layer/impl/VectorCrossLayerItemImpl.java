package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.VectorCrossLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.VectorCrossViewPostureEvent;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = VectorCrossLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class VectorCrossLayerItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(VectorCrossLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long VectorCrossLayerItemImpl_SWIGUpcast(long j);

    private static native void VectorCrossLayerItemImpl_change_ownership(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, long j, boolean z);

    private static native void VectorCrossLayerItemImpl_director_connect(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, long j, boolean z, boolean z2);

    private static native void clearAllNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl);

    private static native void clearAllSwigExplicitVectorCrossLayerItemImplNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int getItemTypeNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl);

    private static native int getItemTypeSwigExplicitVectorCrossLayerItemImplNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl);

    private static native void setPriorityNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl, long j2, LayerPriority layerPriority);

    private static native void setPrioritySwigExplicitVectorCrossLayerItemImplNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl, long j2, LayerPriority layerPriority);

    private static native void setVectorCarNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl, long j2, Coord3DDouble coord3DDouble, int i);

    private static native void setVectorCarSwigExplicitVectorCrossLayerItemImplNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl, long j2, Coord3DDouble coord3DDouble, int i);

    private static native void setViewPostureEventNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl, int i);

    private static native void setViewPostureEventSwigExplicitVectorCrossLayerItemImplNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl, int i);

    private static native void setVisibleNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl, boolean z);

    private static native void setVisibleSwigExplicitVectorCrossLayerItemImplNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl, boolean z);

    private static native int showVectorCrossNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl, byte[] bArr);

    private static native int showVectorCrossSwigExplicitVectorCrossLayerItemImplNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl, byte[] bArr);

    private static native void updateStyleNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl);

    private static native void updateStyleSwigExplicitVectorCrossLayerItemImplNative(long j, VectorCrossLayerItemImpl vectorCrossLayerItemImpl);

    public VectorCrossLayerItemImpl(long j, boolean z) {
        super(VectorCrossLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof VectorCrossLayerItemImpl) {
            return getUID(this) == getUID((VectorCrossLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        long cPtr = getCPtr(vectorCrossLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        if (vectorCrossLayerItemImpl == null) {
            return 0L;
        }
        return vectorCrossLayerItemImpl.swigCPtr;
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
        VectorCrossLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        VectorCrossLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public VectorCrossLayerItemImpl() {
        this(createNativeObj(), true);
        MapLayerSvrJNI.swig_jni_init();
        VectorCrossLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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
            return getClass() == VectorCrossLayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitVectorCrossLayerItemImplNative(this.swigCPtr, this);
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
        if (getClass() == VectorCrossLayerItemImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitVectorCrossLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void setVectorCar(Coord3DDouble coord3DDouble, int i) {
        $explicit_setVectorCar(coord3DDouble, i);
    }

    public void $explicit_setVectorCar(Coord3DDouble coord3DDouble, int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == VectorCrossLayerItemImpl.class) {
            setVectorCarNative(this.swigCPtr, this, 0L, coord3DDouble, i);
        } else {
            setVectorCarSwigExplicitVectorCrossLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble, i);
        }
    }

    public int showVectorCross(byte[] bArr) {
        return $explicit_showVectorCross(bArr);
    }

    public int $explicit_showVectorCross(byte[] bArr) {
        if (this.swigCPtr != 0) {
            return getClass() == VectorCrossLayerItemImpl.class ? showVectorCrossNative(this.swigCPtr, this, bArr) : showVectorCrossSwigExplicitVectorCrossLayerItemImplNative(this.swigCPtr, this, bArr);
        }
        throw new NullPointerException();
    }

    public void setPriority(LayerPriority layerPriority) {
        $explicit_setPriority(layerPriority);
    }

    public void $explicit_setPriority(LayerPriority layerPriority) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == VectorCrossLayerItemImpl.class) {
            setPriorityNative(this.swigCPtr, this, 0L, layerPriority);
        } else {
            setPrioritySwigExplicitVectorCrossLayerItemImplNative(this.swigCPtr, this, 0L, layerPriority);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void setVisible(boolean z) {
        $explicit_setVisible(z);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_setVisible(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == VectorCrossLayerItemImpl.class) {
            setVisibleNative(this.swigCPtr, this, z);
        } else {
            setVisibleSwigExplicitVectorCrossLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public void clearAll() {
        $explicit_clearAll();
    }

    public void $explicit_clearAll() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == VectorCrossLayerItemImpl.class) {
            clearAllNative(this.swigCPtr, this);
        } else {
            clearAllSwigExplicitVectorCrossLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void setViewPostureEvent(@VectorCrossViewPostureEvent.VectorCrossViewPostureEvent1 int i) {
        $explicit_setViewPostureEvent(i);
    }

    public void $explicit_setViewPostureEvent(@VectorCrossViewPostureEvent.VectorCrossViewPostureEvent1 int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == VectorCrossLayerItemImpl.class) {
            setViewPostureEventNative(this.swigCPtr, this, i);
        } else {
            setViewPostureEventSwigExplicitVectorCrossLayerItemImplNative(this.swigCPtr, this, i);
        }
    }
}
