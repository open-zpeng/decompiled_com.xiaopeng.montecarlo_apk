package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.SearchAlongWayLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.AlongWayLabelType;
import com.autonavi.gbl.layer.model.SearchAlongWayExtraData;
import com.autonavi.gbl.layer.model.SearchAlongwayType;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = SearchAlongWayLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class SearchAlongWayLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SearchAlongWayLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long SearchAlongWayLayerItemImpl_SWIGUpcast(long j);

    private static native void SearchAlongWayLayerItemImpl_change_ownership(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, long j, boolean z);

    private static native void SearchAlongWayLayerItemImpl_director_connect(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, SearchAlongWayExtraData searchAlongWayExtraData, int i, int i2, int i3, String str);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native SearchAlongWayExtraData mExtraDataGetNative(long j, SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl);

    private static native void mExtraDataSetNative(long j, SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, long j2, SearchAlongWayExtraData searchAlongWayExtraData);

    private static native int mLabelTypeGetNative(long j, SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl);

    private static native void mLabelTypeSetNative(long j, SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, int i);

    private static native String mNameGetNative(long j, SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl);

    private static native void mNameSetNative(long j, SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, String str);

    private static native int mSearchTypeGetNative(long j, SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl);

    private static native void mSearchTypeSetNative(long j, SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, int i);

    private static native int mTypeCodeGetNative(long j, SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl);

    private static native void mTypeCodeSetNative(long j, SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, int i);

    public SearchAlongWayLayerItemImpl(long j, boolean z) {
        super(SearchAlongWayLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof SearchAlongWayLayerItemImpl) {
            return getUID(this) == getUID((SearchAlongWayLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        long cPtr = getCPtr(searchAlongWayLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        if (searchAlongWayLayerItemImpl == null) {
            return 0L;
        }
        return searchAlongWayLayerItemImpl.swigCPtr;
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
        SearchAlongWayLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        SearchAlongWayLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public SearchAlongWayLayerItemImpl(SearchAlongWayExtraData searchAlongWayExtraData, @SearchAlongwayType.SearchAlongwayType1 int i, @AlongWayLabelType.AlongWayLabelType1 int i2, int i3, String str) {
        this(createNativeObj(0L, searchAlongWayExtraData, i, i2, i3, str), true);
        LayerSvrJNI.swig_jni_init();
        SearchAlongWayLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMSearchType(@SearchAlongwayType.SearchAlongwayType1 int i) {
        $explicit_setMSearchType(i);
    }

    public void $explicit_setMSearchType(@SearchAlongwayType.SearchAlongwayType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mSearchTypeSetNative(j, this, i);
    }

    @SearchAlongwayType.SearchAlongwayType1
    public int getMSearchType() {
        return $explicit_getMSearchType();
    }

    @SearchAlongwayType.SearchAlongwayType1
    public int $explicit_getMSearchType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mSearchTypeGetNative(j, this);
    }

    public void setMLabelType(@AlongWayLabelType.AlongWayLabelType1 int i) {
        $explicit_setMLabelType(i);
    }

    public void $explicit_setMLabelType(@AlongWayLabelType.AlongWayLabelType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mLabelTypeSetNative(j, this, i);
    }

    @AlongWayLabelType.AlongWayLabelType1
    public int getMLabelType() {
        return $explicit_getMLabelType();
    }

    @AlongWayLabelType.AlongWayLabelType1
    public int $explicit_getMLabelType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mLabelTypeGetNative(j, this);
    }

    public void setMTypeCode(int i) {
        $explicit_setMTypeCode(i);
    }

    public void $explicit_setMTypeCode(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTypeCodeSetNative(j, this, i);
    }

    public int getMTypeCode() {
        return $explicit_getMTypeCode();
    }

    public int $explicit_getMTypeCode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTypeCodeGetNative(j, this);
    }

    public void setMName(String str) {
        $explicit_setMName(str);
    }

    public void $explicit_setMName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mNameSetNative(j, this, str);
    }

    public String getMName() {
        return $explicit_getMName();
    }

    public String $explicit_getMName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mNameGetNative(j, this);
    }

    public void setMExtraData(SearchAlongWayExtraData searchAlongWayExtraData) {
        $explicit_setMExtraData(searchAlongWayExtraData);
    }

    public void $explicit_setMExtraData(SearchAlongWayExtraData searchAlongWayExtraData) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mExtraDataSetNative(j, this, 0L, searchAlongWayExtraData);
    }

    public SearchAlongWayExtraData getMExtraData() {
        return $explicit_getMExtraData();
    }

    public SearchAlongWayExtraData $explicit_getMExtraData() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mExtraDataGetNative(j, this);
    }
}
