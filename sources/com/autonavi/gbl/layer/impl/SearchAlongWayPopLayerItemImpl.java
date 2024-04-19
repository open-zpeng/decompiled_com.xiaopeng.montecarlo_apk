package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.SearchAlongWayPopLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.AlongWayLabelType;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.BizSearchAlongWayPoint;
import com.autonavi.gbl.layer.model.SearchAlongWayExtraData;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = SearchAlongWayPopLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class SearchAlongWayPopLayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SearchAlongWayPopLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long SearchAlongWayPopLayerItemImpl_SWIGUpcast(long j);

    private static native void SearchAlongWayPopLayerItemImpl_change_ownership(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, long j, boolean z);

    private static native void SearchAlongWayPopLayerItemImpl_director_connect(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, long j, long j2, BizSearchAlongWayPoint bizSearchAlongWayPoint, int i2);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mDirectionStyleGetNative(long j, SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl);

    private static native void mDirectionStyleSetNative(long j, SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, int i);

    private static native SearchAlongWayExtraData mExtraDataGetNative(long j, SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl);

    private static native void mExtraDataSetNative(long j, SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, long j2, SearchAlongWayExtraData searchAlongWayExtraData);

    private static native int mLabelTypeGetNative(long j, SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl);

    private static native void mLabelTypeSetNative(long j, SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, int i);

    private static native String mNameGetNative(long j, SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl);

    private static native void mNameSetNative(long j, SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, String str);

    private static native int mSearchTypeGetNative(long j, SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl);

    private static native void mSearchTypeSetNative(long j, SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, int i);

    private static native int mTypeCodeGetNative(long j, SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl);

    private static native void mTypeCodeSetNative(long j, SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, int i);

    public SearchAlongWayPopLayerItemImpl(long j, boolean z) {
        super(SearchAlongWayPopLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof SearchAlongWayPopLayerItemImpl) {
            return getUID(this) == getUID((SearchAlongWayPopLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        long cPtr = getCPtr(searchAlongWayPopLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        if (searchAlongWayPopLayerItemImpl == null) {
            return 0L;
        }
        return searchAlongWayPopLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        SearchAlongWayPopLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        SearchAlongWayPopLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public SearchAlongWayPopLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j, BizSearchAlongWayPoint bizSearchAlongWayPoint, @AlongWayLabelType.AlongWayLabelType1 int i2) {
        this(createNativeObj(i, j, 0L, bizSearchAlongWayPoint, i2), true);
        LayerSvrJNI.swig_jni_init();
        SearchAlongWayPopLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMSearchType(int i) {
        $explicit_setMSearchType(i);
    }

    public void $explicit_setMSearchType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mSearchTypeSetNative(j, this, i);
    }

    public int getMSearchType() {
        return $explicit_getMSearchType();
    }

    public int $explicit_getMSearchType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mSearchTypeGetNative(j, this);
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

    public void setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        $explicit_setMDirectionStyle(i);
    }

    public void $explicit_setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mDirectionStyleSetNative(j, this, i);
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        return $explicit_getMDirectionStyle();
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int $explicit_getMDirectionStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mDirectionStyleGetNative(j, this);
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
