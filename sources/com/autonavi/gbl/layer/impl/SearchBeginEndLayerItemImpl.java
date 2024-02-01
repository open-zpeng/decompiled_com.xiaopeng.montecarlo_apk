package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.SearchBeginEndLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = SearchBeginEndLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class SearchBeginEndLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SearchBeginEndLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long SearchBeginEndLayerItemImpl_SWIGUpcast(long j);

    private static native void SearchBeginEndLayerItemImpl_change_ownership(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, long j, boolean z);

    private static native void SearchBeginEndLayerItemImpl_director_connect(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, int i2);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mPointCountGetNative(long j, SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl);

    private static native void mPointCountSetNative(long j, SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, int i);

    private static native int mPointTypeGetNative(long j, SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl);

    private static native void mPointTypeSetNative(long j, SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, int i);

    public SearchBeginEndLayerItemImpl(long j, boolean z) {
        super(SearchBeginEndLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof SearchBeginEndLayerItemImpl) {
            return getUID(this) == getUID((SearchBeginEndLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        long cPtr = getCPtr(searchBeginEndLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        if (searchBeginEndLayerItemImpl == null) {
            return 0L;
        }
        return searchBeginEndLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        SearchBeginEndLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        SearchBeginEndLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public SearchBeginEndLayerItemImpl(int i, int i2) {
        this(createNativeObj(i, i2), true);
        LayerSvrJNI.swig_jni_init();
        SearchBeginEndLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMPointType(int i) {
        $explicit_setMPointType(i);
    }

    public void $explicit_setMPointType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mPointTypeSetNative(j, this, i);
    }

    public int getMPointType() {
        return $explicit_getMPointType();
    }

    public int $explicit_getMPointType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mPointTypeGetNative(j, this);
    }

    public void setMPointCount(int i) {
        $explicit_setMPointCount(i);
    }

    public void $explicit_setMPointCount(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mPointCountSetNative(j, this, i);
    }

    public int getMPointCount() {
        return $explicit_getMPointCount();
    }

    public int $explicit_getMPointCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mPointCountGetNative(j, this);
    }
}
