package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.LightBeamLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = LightBeamLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class LightBeamLayerItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LightBeamLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long LightBeamLayerItemImpl_SWIGUpcast(long j);

    private static native void LightBeamLayerItemImpl_change_ownership(LightBeamLayerItemImpl lightBeamLayerItemImpl, long j, boolean z);

    private static native void LightBeamLayerItemImpl_director_connect(LightBeamLayerItemImpl lightBeamLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int getItemTypeNative(long j, LightBeamLayerItemImpl lightBeamLayerItemImpl);

    private static native int getItemTypeSwigExplicitLightBeamLayerItemImplNative(long j, LightBeamLayerItemImpl lightBeamLayerItemImpl);

    private static native void setPositionNative(long j, LightBeamLayerItemImpl lightBeamLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setScaleNative(long j, LightBeamLayerItemImpl lightBeamLayerItemImpl, float f, float f2);

    private static native void updateStyleNative(long j, LightBeamLayerItemImpl lightBeamLayerItemImpl);

    private static native void updateStyleSwigExplicitLightBeamLayerItemImplNative(long j, LightBeamLayerItemImpl lightBeamLayerItemImpl);

    public LightBeamLayerItemImpl(long j, boolean z) {
        super(LightBeamLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof LightBeamLayerItemImpl) {
            return getUID(this) == getUID((LightBeamLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        long cPtr = getCPtr(lightBeamLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        if (lightBeamLayerItemImpl == null) {
            return 0L;
        }
        return lightBeamLayerItemImpl.swigCPtr;
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
        LightBeamLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        LightBeamLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LightBeamLayerItemImpl() {
        this(createNativeObj(), true);
        MapLayerSvrJNI.swig_jni_init();
        LightBeamLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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
            return getClass() == LightBeamLayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitLightBeamLayerItemImplNative(this.swigCPtr, this);
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
        if (getClass() == LightBeamLayerItemImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitLightBeamLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void setScale(float f, float f2) {
        $explicit_setScale(f, f2);
    }

    public void $explicit_setScale(float f, float f2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setScaleNative(j, this, f, f2);
    }

    public void setPosition(Coord3DDouble coord3DDouble) {
        $explicit_setPosition(coord3DDouble);
    }

    public void $explicit_setPosition(Coord3DDouble coord3DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPositionNative(j, this, 0L, coord3DDouble);
    }
}
