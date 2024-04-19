package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.SearchParentLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.PoiParentType;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = SearchParentLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class SearchParentLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SearchParentLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long SearchParentLayerItemImpl_SWIGUpcast(long j);

    private static native void SearchParentLayerItemImpl_change_ownership(SearchParentLayerItemImpl searchParentLayerItemImpl, long j, boolean z);

    private static native void SearchParentLayerItemImpl_director_connect(SearchParentLayerItemImpl searchParentLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, int i2, int i3, String str, String str2, String str3);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mIndexGetNative(long j, SearchParentLayerItemImpl searchParentLayerItemImpl);

    private static native void mIndexSetNative(long j, SearchParentLayerItemImpl searchParentLayerItemImpl, int i);

    private static native String mMarkerBGResGetNative(long j, SearchParentLayerItemImpl searchParentLayerItemImpl);

    private static native void mMarkerBGResSetNative(long j, SearchParentLayerItemImpl searchParentLayerItemImpl, String str);

    private static native String mTextGetNative(long j, SearchParentLayerItemImpl searchParentLayerItemImpl);

    private static native void mTextSetNative(long j, SearchParentLayerItemImpl searchParentLayerItemImpl, String str);

    private static native String poiNameGetNative(long j, SearchParentLayerItemImpl searchParentLayerItemImpl);

    private static native void poiNameSetNative(long j, SearchParentLayerItemImpl searchParentLayerItemImpl, String str);

    private static native int poiTypeGetNative(long j, SearchParentLayerItemImpl searchParentLayerItemImpl);

    private static native void poiTypeSetNative(long j, SearchParentLayerItemImpl searchParentLayerItemImpl, int i);

    private static native int typeCodeGetNative(long j, SearchParentLayerItemImpl searchParentLayerItemImpl);

    private static native void typeCodeSetNative(long j, SearchParentLayerItemImpl searchParentLayerItemImpl, int i);

    public SearchParentLayerItemImpl(long j, boolean z) {
        super(SearchParentLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof SearchParentLayerItemImpl) {
            return getUID(this) == getUID((SearchParentLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        long cPtr = getCPtr(searchParentLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        if (searchParentLayerItemImpl == null) {
            return 0L;
        }
        return searchParentLayerItemImpl.swigCPtr;
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
        SearchParentLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        SearchParentLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public SearchParentLayerItemImpl(@PoiParentType.PoiParentType1 int i, int i2, int i3, String str, String str2, String str3) {
        this(createNativeObj(i, i2, i3, str, str2, str3), true);
        LayerSvrJNI.swig_jni_init();
        SearchParentLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setPoiType(@PoiParentType.PoiParentType1 int i) {
        $explicit_setPoiType(i);
    }

    public void $explicit_setPoiType(@PoiParentType.PoiParentType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        poiTypeSetNative(j, this, i);
    }

    @PoiParentType.PoiParentType1
    public int getPoiType() {
        return $explicit_getPoiType();
    }

    @PoiParentType.PoiParentType1
    public int $explicit_getPoiType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return poiTypeGetNative(j, this);
    }

    public void setTypeCode(int i) {
        $explicit_setTypeCode(i);
    }

    public void $explicit_setTypeCode(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        typeCodeSetNative(j, this, i);
    }

    public int getTypeCode() {
        return $explicit_getTypeCode();
    }

    public int $explicit_getTypeCode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return typeCodeGetNative(j, this);
    }

    public void setMIndex(int i) {
        $explicit_setMIndex(i);
    }

    public void $explicit_setMIndex(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mIndexSetNative(j, this, i);
    }

    public int getMIndex() {
        return $explicit_getMIndex();
    }

    public int $explicit_getMIndex() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mIndexGetNative(j, this);
    }

    public void setMText(String str) {
        $explicit_setMText(str);
    }

    public void $explicit_setMText(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTextSetNative(j, this, str);
    }

    public String getMText() {
        return $explicit_getMText();
    }

    public String $explicit_getMText() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTextGetNative(j, this);
    }

    public void setPoiName(String str) {
        $explicit_setPoiName(str);
    }

    public void $explicit_setPoiName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        poiNameSetNative(j, this, str);
    }

    public String getPoiName() {
        return $explicit_getPoiName();
    }

    public String $explicit_getPoiName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return poiNameGetNative(j, this);
    }

    public void setMMarkerBGRes(String str) {
        $explicit_setMMarkerBGRes(str);
    }

    public void $explicit_setMMarkerBGRes(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mMarkerBGResSetNative(j, this, str);
    }

    public String getMMarkerBGRes() {
        return $explicit_getMMarkerBGRes();
    }

    public String $explicit_getMMarkerBGRes() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mMarkerBGResGetNative(j, this);
    }
}
