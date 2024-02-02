package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.FavoritePointLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
import com.autonavi.gbl.user.behavior.model.FavoriteType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = FavoritePointLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class FavoritePointLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(FavoritePointLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long FavoritePointLayerItemImpl_SWIGUpcast(long j);

    private static native void FavoritePointLayerItemImpl_change_ownership(FavoritePointLayerItemImpl favoritePointLayerItemImpl, long j, boolean z);

    private static native void FavoritePointLayerItemImpl_director_connect(FavoritePointLayerItemImpl favoritePointLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mFavoriteTypeGetNative(long j, FavoritePointLayerItemImpl favoritePointLayerItemImpl);

    private static native void mFavoriteTypeSetNative(long j, FavoritePointLayerItemImpl favoritePointLayerItemImpl, int i);

    public FavoritePointLayerItemImpl(long j, boolean z) {
        super(FavoritePointLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof FavoritePointLayerItemImpl) {
            return getUID(this) == getUID((FavoritePointLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        long cPtr = getCPtr(favoritePointLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        if (favoritePointLayerItemImpl == null) {
            return 0L;
        }
        return favoritePointLayerItemImpl.swigCPtr;
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
        FavoritePointLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        FavoritePointLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void setMFavoriteType(@FavoriteType.FavoriteType1 int i) {
        $explicit_setMFavoriteType(i);
    }

    public void $explicit_setMFavoriteType(@FavoriteType.FavoriteType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mFavoriteTypeSetNative(j, this, i);
    }

    @FavoriteType.FavoriteType1
    public int getMFavoriteType() {
        return $explicit_getMFavoriteType();
    }

    @FavoriteType.FavoriteType1
    public int $explicit_getMFavoriteType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mFavoriteTypeGetNative(j, this);
    }

    public FavoritePointLayerItemImpl(@FavoriteType.FavoriteType1 int i) {
        this(createNativeObj(i), true);
        LayerSvrJNI.swig_jni_init();
        FavoritePointLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }
}
