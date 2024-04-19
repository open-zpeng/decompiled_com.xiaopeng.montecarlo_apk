package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.SearchExitEntranceLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = SearchExitEntranceLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class SearchExitEntranceLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SearchExitEntranceLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long SearchExitEntranceLayerItemImpl_SWIGUpcast(long j);

    private static native void SearchExitEntranceLayerItemImpl_change_ownership(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, long j, boolean z);

    private static native void SearchExitEntranceLayerItemImpl_director_connect(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mTypeGetNative(long j, SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl);

    private static native void mTypeSetNative(long j, SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, int i);

    public SearchExitEntranceLayerItemImpl(long j, boolean z) {
        super(SearchExitEntranceLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof SearchExitEntranceLayerItemImpl) {
            return getUID(this) == getUID((SearchExitEntranceLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        long cPtr = getCPtr(searchExitEntranceLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        if (searchExitEntranceLayerItemImpl == null) {
            return 0L;
        }
        return searchExitEntranceLayerItemImpl.swigCPtr;
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
        SearchExitEntranceLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        SearchExitEntranceLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public SearchExitEntranceLayerItemImpl(int i) {
        this(createNativeObj(i), true);
        LayerSvrJNI.swig_jni_init();
        SearchExitEntranceLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMType(int i) {
        $explicit_setMType(i);
    }

    public void $explicit_setMType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTypeSetNative(j, this, i);
    }

    public int getMType() {
        return $explicit_getMType();
    }

    public int $explicit_getMType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTypeGetNative(j, this);
    }
}
