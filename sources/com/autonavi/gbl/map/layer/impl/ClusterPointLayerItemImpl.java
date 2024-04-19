package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.ClusterPointLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import java.util.ArrayList;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = ClusterPointLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ClusterPointLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(ClusterPointLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long ClusterPointLayerItemImpl_SWIGUpcast(long j);

    private static native void ClusterPointLayerItemImpl_change_ownership(ClusterPointLayerItemImpl clusterPointLayerItemImpl, long j, boolean z);

    private static native void ClusterPointLayerItemImpl_director_connect(ClusterPointLayerItemImpl clusterPointLayerItemImpl, long j, boolean z, boolean z2);

    private static native int clusterPointSizeGetNative(long j, ClusterPointLayerItemImpl clusterPointLayerItemImpl);

    private static native void clusterPointSizeSetNative(long j, ClusterPointLayerItemImpl clusterPointLayerItemImpl, int i);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int getItemTypeNative(long j, ClusterPointLayerItemImpl clusterPointLayerItemImpl);

    private static native int getItemTypeSwigExplicitClusterPointLayerItemImplNative(long j, ClusterPointLayerItemImpl clusterPointLayerItemImpl);

    private static native ArrayList<String> vecOriginalItemIDGetNative(long j, ClusterPointLayerItemImpl clusterPointLayerItemImpl);

    private static native void vecOriginalItemIDSetNative(long j, ClusterPointLayerItemImpl clusterPointLayerItemImpl, ArrayList<String> arrayList);

    public ClusterPointLayerItemImpl(long j, boolean z) {
        super(ClusterPointLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof ClusterPointLayerItemImpl) {
            return getUID(this) == getUID((ClusterPointLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        long cPtr = getCPtr(clusterPointLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        if (clusterPointLayerItemImpl == null) {
            return 0L;
        }
        return clusterPointLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        ClusterPointLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ClusterPointLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public ClusterPointLayerItemImpl() {
        this(createNativeObj(), true);
        MapLayerSvrJNI.swig_jni_init();
        ClusterPointLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        return $explicit_getItemType();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int $explicit_getItemType() {
        if (this.swigCPtr != 0) {
            return getClass() == ClusterPointLayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitClusterPointLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setClusterPointSize(int i) {
        $explicit_setClusterPointSize(i);
    }

    public void $explicit_setClusterPointSize(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clusterPointSizeSetNative(j, this, i);
    }

    public int getClusterPointSize() {
        return $explicit_getClusterPointSize();
    }

    public int $explicit_getClusterPointSize() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return clusterPointSizeGetNative(j, this);
    }

    public void setVecOriginalItemID(ArrayList<String> arrayList) {
        $explicit_setVecOriginalItemID(arrayList);
    }

    public void $explicit_setVecOriginalItemID(ArrayList<String> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        vecOriginalItemIDSetNative(j, this, arrayList);
    }

    public ArrayList<String> getVecOriginalItemID() {
        return $explicit_getVecOriginalItemID();
    }

    public ArrayList<String> $explicit_getVecOriginalItemID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return vecOriginalItemIDGetNative(j, this);
    }
}
