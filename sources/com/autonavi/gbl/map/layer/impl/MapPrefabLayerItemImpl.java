package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.MapPrefabLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = MapPrefabLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class MapPrefabLayerItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(MapPrefabLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long MapPrefabLayerItemImpl_SWIGUpcast(long j);

    private static native void MapPrefabLayerItemImpl_change_ownership(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, long j, boolean z);

    private static native void MapPrefabLayerItemImpl_director_connect(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(String str);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int getItemTypeNative(long j, MapPrefabLayerItemImpl mapPrefabLayerItemImpl);

    private static native int getItemTypeSwigExplicitMapPrefabLayerItemImplNative(long j, MapPrefabLayerItemImpl mapPrefabLayerItemImpl);

    private static native boolean getItemVisibleNative(long j, MapPrefabLayerItemImpl mapPrefabLayerItemImpl);

    private static native boolean reloadNative(long j, MapPrefabLayerItemImpl mapPrefabLayerItemImpl);

    private static native void setConfigDataNative(long j, MapPrefabLayerItemImpl mapPrefabLayerItemImpl, byte[] bArr, int i);

    private static native void setItemVisibleNative(long j, MapPrefabLayerItemImpl mapPrefabLayerItemImpl, boolean z);

    private static native void setPositionNative(long j, MapPrefabLayerItemImpl mapPrefabLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    public MapPrefabLayerItemImpl(long j, boolean z) {
        super(MapPrefabLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof MapPrefabLayerItemImpl) {
            return getUID(this) == getUID((MapPrefabLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        long cPtr = getCPtr(mapPrefabLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        if (mapPrefabLayerItemImpl == null) {
            return 0L;
        }
        return mapPrefabLayerItemImpl.swigCPtr;
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
        MapPrefabLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        MapPrefabLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public MapPrefabLayerItemImpl(String str) {
        this(createNativeObj(str), true);
        MapLayerSvrJNI.swig_jni_init();
        MapPrefabLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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
            return getClass() == MapPrefabLayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitMapPrefabLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
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

    public void setItemVisible(boolean z) {
        $explicit_setItemVisible(z);
    }

    public void $explicit_setItemVisible(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setItemVisibleNative(j, this, z);
    }

    public boolean getItemVisible() {
        return $explicit_getItemVisible();
    }

    public boolean $explicit_getItemVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getItemVisibleNative(j, this);
    }

    public void setConfigData(byte[] bArr, int i) {
        $explicit_setConfigData(bArr, i);
    }

    public void $explicit_setConfigData(byte[] bArr, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setConfigDataNative(j, this, bArr, i);
    }

    public boolean reload() {
        return $explicit_reload();
    }

    public boolean $explicit_reload() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return reloadNative(j, this);
    }
}
