package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.RasterImageLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerTexture;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = RasterImageLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RasterImageLayerItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RasterImageLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RasterImageLayerItemImpl_SWIGUpcast(long j);

    private static native void RasterImageLayerItemImpl_change_ownership(RasterImageLayerItemImpl rasterImageLayerItemImpl, long j, boolean z);

    private static native void RasterImageLayerItemImpl_director_connect(RasterImageLayerItemImpl rasterImageLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int getItemTypeNative(long j, RasterImageLayerItemImpl rasterImageLayerItemImpl);

    private static native int getItemTypeSwigExplicitRasterImageLayerItemImplNative(long j, RasterImageLayerItemImpl rasterImageLayerItemImpl);

    private static native void setArrowColorNative(long j, RasterImageLayerItemImpl rasterImageLayerItemImpl, boolean z, int i);

    private static native void setArrowColorSwigExplicitRasterImageLayerItemImplNative(long j, RasterImageLayerItemImpl rasterImageLayerItemImpl, boolean z, int i);

    private static native void setPlaneViewRectNative(long j, RasterImageLayerItemImpl rasterImageLayerItemImpl, long j2, RectInt rectInt);

    private static native void setPlaneViewRectSwigExplicitRasterImageLayerItemImplNative(long j, RasterImageLayerItemImpl rasterImageLayerItemImpl, long j2, RectInt rectInt);

    private static native void setRasterImageDataNative(long j, RasterImageLayerItemImpl rasterImageLayerItemImpl, long j2, LayerTexture layerTexture, long j3, LayerTexture layerTexture2);

    private static native void setRasterImageDataSwigExplicitRasterImageLayerItemImplNative(long j, RasterImageLayerItemImpl rasterImageLayerItemImpl, long j2, LayerTexture layerTexture, long j3, LayerTexture layerTexture2);

    private static native void updateStyleNative(long j, RasterImageLayerItemImpl rasterImageLayerItemImpl);

    private static native void updateStyleSwigExplicitRasterImageLayerItemImplNative(long j, RasterImageLayerItemImpl rasterImageLayerItemImpl);

    public RasterImageLayerItemImpl(long j, boolean z) {
        super(RasterImageLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof RasterImageLayerItemImpl) {
            return getUID(this) == getUID((RasterImageLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        long cPtr = getCPtr(rasterImageLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        if (rasterImageLayerItemImpl == null) {
            return 0L;
        }
        return rasterImageLayerItemImpl.swigCPtr;
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
        RasterImageLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RasterImageLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RasterImageLayerItemImpl() {
        this(createNativeObj(), true);
        MapLayerSvrJNI.swig_jni_init();
        RasterImageLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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
            return getClass() == RasterImageLayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitRasterImageLayerItemImplNative(this.swigCPtr, this);
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
        if (getClass() == RasterImageLayerItemImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitRasterImageLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void setArrowColor(boolean z, int i) {
        $explicit_setArrowColor(z, i);
    }

    public void $explicit_setArrowColor(boolean z, int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RasterImageLayerItemImpl.class) {
            setArrowColorNative(this.swigCPtr, this, z, i);
        } else {
            setArrowColorSwigExplicitRasterImageLayerItemImplNative(this.swigCPtr, this, z, i);
        }
    }

    public void setRasterImageData(LayerTexture layerTexture, LayerTexture layerTexture2) {
        $explicit_setRasterImageData(layerTexture, layerTexture2);
    }

    public void $explicit_setRasterImageData(LayerTexture layerTexture, LayerTexture layerTexture2) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RasterImageLayerItemImpl.class) {
            setRasterImageDataNative(this.swigCPtr, this, 0L, layerTexture, 0L, layerTexture2);
        } else {
            setRasterImageDataSwigExplicitRasterImageLayerItemImplNative(this.swigCPtr, this, 0L, layerTexture, 0L, layerTexture2);
        }
    }

    public void setPlaneViewRect(RectInt rectInt) {
        $explicit_setPlaneViewRect(rectInt);
    }

    public void $explicit_setPlaneViewRect(RectInt rectInt) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RasterImageLayerItemImpl.class) {
            setPlaneViewRectNative(this.swigCPtr, this, 0L, rectInt);
        } else {
            setPlaneViewRectSwigExplicitRasterImageLayerItemImplNative(this.swigCPtr, this, 0L, rectInt);
        }
    }
}
