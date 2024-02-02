package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.SearchChildLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = SearchChildLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class SearchChildLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SearchChildLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long SearchChildLayerItemImpl_SWIGUpcast(long j);

    private static native void SearchChildLayerItemImpl_change_ownership(SearchChildLayerItemImpl searchChildLayerItemImpl, long j, boolean z);

    private static native void SearchChildLayerItemImpl_director_connect(SearchChildLayerItemImpl searchChildLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, String str);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mChildTypeGetNative(long j, SearchChildLayerItemImpl searchChildLayerItemImpl);

    private static native void mChildTypeSetNative(long j, SearchChildLayerItemImpl searchChildLayerItemImpl, int i);

    private static native String mShortNameGetNative(long j, SearchChildLayerItemImpl searchChildLayerItemImpl);

    private static native void mShortNameSetNative(long j, SearchChildLayerItemImpl searchChildLayerItemImpl, String str);

    public SearchChildLayerItemImpl(long j, boolean z) {
        super(SearchChildLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof SearchChildLayerItemImpl) {
            return getUID(this) == getUID((SearchChildLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        long cPtr = getCPtr(searchChildLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        if (searchChildLayerItemImpl == null) {
            return 0L;
        }
        return searchChildLayerItemImpl.swigCPtr;
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
        SearchChildLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        SearchChildLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public SearchChildLayerItemImpl(int i, String str) {
        this(createNativeObj(i, str), true);
        LayerSvrJNI.swig_jni_init();
        SearchChildLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMChildType(int i) {
        $explicit_setMChildType(i);
    }

    public void $explicit_setMChildType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mChildTypeSetNative(j, this, i);
    }

    public int getMChildType() {
        return $explicit_getMChildType();
    }

    public int $explicit_getMChildType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mChildTypeGetNative(j, this);
    }

    public void setMShortName(String str) {
        $explicit_setMShortName(str);
    }

    public void $explicit_setMShortName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mShortNameSetNative(j, this, str);
    }

    public String getMShortName() {
        return $explicit_getMShortName();
    }

    public String $explicit_getMShortName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mShortNameGetNative(j, this);
    }
}
