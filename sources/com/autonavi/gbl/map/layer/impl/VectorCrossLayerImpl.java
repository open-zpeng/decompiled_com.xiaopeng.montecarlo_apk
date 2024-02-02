package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.creflex.BaseLayerCRfxProto;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.layer.VectorCrossLayer;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.VectorCrossViewPostureEvent;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = BaseLayerCRfxProto.class, target = VectorCrossLayer.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class VectorCrossLayerImpl extends BaseLayerImpl {
    private static BindTable BIND_TABLE = new BindTable(VectorCrossLayerImpl.class);
    private transient long swigCPtr;

    private static native long VectorCrossLayerImpl_SWIGUpcast(long j);

    private static native void VectorCrossLayerImpl_change_ownership(VectorCrossLayerImpl vectorCrossLayerImpl, long j, boolean z);

    private static native void VectorCrossLayerImpl_director_connect(VectorCrossLayerImpl vectorCrossLayerImpl, long j, boolean z, boolean z2);

    private static native void clearAllItemsNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl);

    private static native void clearAllItemsSwigExplicitVectorCrossLayerImplNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl);

    private static native long createNativeObj(String str, long j, MapViewImpl mapViewImpl);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native void setBusinessTypeNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl, int i);

    private static native void setBusinessTypeSwigExplicitVectorCrossLayerImplNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl, int i);

    private static native void setPriorityNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl, long j2, LayerPriority layerPriority);

    private static native void setPrioritySwigExplicitVectorCrossLayerImplNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl, long j2, LayerPriority layerPriority);

    private static native void setStyleNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setStyleSwigExplicitVectorCrossLayerImplNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setVectorCarNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl, long j2, Coord3DDouble coord3DDouble, int i);

    private static native void setVectorCarSwigExplicitVectorCrossLayerImplNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl, long j2, Coord3DDouble coord3DDouble, int i);

    private static native void setViewPostureEventNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl, int i);

    private static native void setViewPostureEventSwigExplicitVectorCrossLayerImplNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl, int i);

    private static native void setVisibleNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl, boolean z);

    private static native void setVisibleSwigExplicitVectorCrossLayerImplNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl, boolean z);

    private static native int showVectorCrossNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl, byte[] bArr);

    private static native int showVectorCrossSwigExplicitVectorCrossLayerImplNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl, byte[] bArr);

    private static native void updateStyleNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl);

    private static native void updateStyleSwigExplicitVectorCrossLayerImplNative(long j, VectorCrossLayerImpl vectorCrossLayerImpl);

    public VectorCrossLayerImpl(long j, boolean z) {
        super(VectorCrossLayerImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean equals(Object obj) {
        if (obj instanceof VectorCrossLayerImpl) {
            return getUID(this) == getUID((VectorCrossLayerImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(VectorCrossLayerImpl vectorCrossLayerImpl) {
        long cPtr = getCPtr(vectorCrossLayerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(VectorCrossLayerImpl vectorCrossLayerImpl) {
        if (vectorCrossLayerImpl == null) {
            return 0L;
        }
        return vectorCrossLayerImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        VectorCrossLayerImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        VectorCrossLayerImpl_change_ownership(this, this.swigCPtr, true);
    }

    public VectorCrossLayerImpl(String str, MapViewImpl mapViewImpl) {
        this(createNativeObj(str, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl), true);
        MapLayerSvrJNI.swig_jni_init();
        VectorCrossLayerImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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
        if (getClass() == VectorCrossLayerImpl.class) {
            setBusinessTypeNative(this.swigCPtr, this, i);
        } else {
            setBusinessTypeSwigExplicitVectorCrossLayerImplNative(this.swigCPtr, this, i);
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
        if (getClass() == VectorCrossLayerImpl.class) {
            setStyleNative(this.swigCPtr, this, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
        } else {
            setStyleSwigExplicitVectorCrossLayerImplNative(this.swigCPtr, this, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
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
        if (getClass() == VectorCrossLayerImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitVectorCrossLayerImplNative(this.swigCPtr, this);
        }
    }

    public void setVectorCar(Coord3DDouble coord3DDouble, int i) {
        $explicit_setVectorCar(coord3DDouble, i);
    }

    public void $explicit_setVectorCar(Coord3DDouble coord3DDouble, int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == VectorCrossLayerImpl.class) {
            setVectorCarNative(this.swigCPtr, this, 0L, coord3DDouble, i);
        } else {
            setVectorCarSwigExplicitVectorCrossLayerImplNative(this.swigCPtr, this, 0L, coord3DDouble, i);
        }
    }

    public int showVectorCross(byte[] bArr) {
        return $explicit_showVectorCross(bArr);
    }

    public int $explicit_showVectorCross(byte[] bArr) {
        if (this.swigCPtr != 0) {
            return getClass() == VectorCrossLayerImpl.class ? showVectorCrossNative(this.swigCPtr, this, bArr) : showVectorCrossSwigExplicitVectorCrossLayerImplNative(this.swigCPtr, this, bArr);
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
        if (getClass() == VectorCrossLayerImpl.class) {
            setPriorityNative(this.swigCPtr, this, 0L, layerPriority);
        } else {
            setPrioritySwigExplicitVectorCrossLayerImplNative(this.swigCPtr, this, 0L, layerPriority);
        }
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
        if (getClass() == VectorCrossLayerImpl.class) {
            setVisibleNative(this.swigCPtr, this, z);
        } else {
            setVisibleSwigExplicitVectorCrossLayerImplNative(this.swigCPtr, this, z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void clearAllItems() {
        $explicit_clearAllItems();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public void $explicit_clearAllItems() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == VectorCrossLayerImpl.class) {
            clearAllItemsNative(this.swigCPtr, this);
        } else {
            clearAllItemsSwigExplicitVectorCrossLayerImplNative(this.swigCPtr, this);
        }
    }

    public void setViewPostureEvent(@VectorCrossViewPostureEvent.VectorCrossViewPostureEvent1 int i) {
        $explicit_setViewPostureEvent(i);
    }

    public void $explicit_setViewPostureEvent(@VectorCrossViewPostureEvent.VectorCrossViewPostureEvent1 int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == VectorCrossLayerImpl.class) {
            setViewPostureEventNative(this.swigCPtr, this, i);
        } else {
            setViewPostureEventSwigExplicitVectorCrossLayerImplNative(this.swigCPtr, this, i);
        }
    }
}
