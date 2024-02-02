package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.SearchChargeStationLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizChargeStationInfo;
import com.autonavi.gbl.layer.model.BizSearchChargeStationInfo;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = SearchChargeStationLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class SearchChargeStationLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SearchChargeStationLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long SearchChargeStationLayerItemImpl_SWIGUpcast(long j);

    private static native void SearchChargeStationLayerItemImpl_change_ownership(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, long j, boolean z);

    private static native void SearchChargeStationLayerItemImpl_director_connect(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, BizSearchChargeStationInfo bizSearchChargeStationInfo);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native BizChargeStationInfo mChargeStationInfoGetNative(long j, SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl);

    private static native void mChargeStationInfoSetNative(long j, SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, long j2, BizChargeStationInfo bizChargeStationInfo);

    public SearchChargeStationLayerItemImpl(long j, boolean z) {
        super(SearchChargeStationLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof SearchChargeStationLayerItemImpl) {
            return getUID(this) == getUID((SearchChargeStationLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        long cPtr = getCPtr(searchChargeStationLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        if (searchChargeStationLayerItemImpl == null) {
            return 0L;
        }
        return searchChargeStationLayerItemImpl.swigCPtr;
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
        SearchChargeStationLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        SearchChargeStationLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public SearchChargeStationLayerItemImpl(BizSearchChargeStationInfo bizSearchChargeStationInfo) {
        this(createNativeObj(0L, bizSearchChargeStationInfo), true);
        LayerSvrJNI.swig_jni_init();
        SearchChargeStationLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMChargeStationInfo(BizChargeStationInfo bizChargeStationInfo) {
        $explicit_setMChargeStationInfo(bizChargeStationInfo);
    }

    public void $explicit_setMChargeStationInfo(BizChargeStationInfo bizChargeStationInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mChargeStationInfoSetNative(j, this, 0L, bizChargeStationInfo);
    }

    public BizChargeStationInfo getMChargeStationInfo() {
        return $explicit_getMChargeStationInfo();
    }

    public BizChargeStationInfo $explicit_getMChargeStationInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mChargeStationInfoGetNative(j, this);
    }
}
