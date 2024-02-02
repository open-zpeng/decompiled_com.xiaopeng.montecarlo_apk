package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.guide.model.CruiseFacilityType;
import com.autonavi.gbl.layer.CruiseFacilityLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizCruiseFacilityInfo;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
import java.util.ArrayList;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = CruiseFacilityLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class CruiseFacilityLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CruiseFacilityLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long CruiseFacilityLayerItemImpl_SWIGUpcast(long j);

    private static native void CruiseFacilityLayerItemImpl_change_ownership(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, long j, boolean z);

    private static native void CruiseFacilityLayerItemImpl_director_connect(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, int i2, int i3);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int indexGetNative(long j, CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl);

    private static native void indexSetNative(long j, CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, int i);

    private static native int mDistanceGetNative(long j, CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl);

    private static native void mDistanceSetNative(long j, CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, int i);

    private static native ArrayList<BizCruiseFacilityInfo> mFacilityListGetNative(long j, CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl);

    private static native void mFacilityListSetNative(long j, CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, ArrayList<BizCruiseFacilityInfo> arrayList);

    private static native int mSpeedGetNative(long j, CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl);

    private static native void mSpeedSetNative(long j, CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, int i);

    private static native int mTypeGetNative(long j, CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl);

    private static native void mTypeSetNative(long j, CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, int i);

    public CruiseFacilityLayerItemImpl(long j, boolean z) {
        super(CruiseFacilityLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof CruiseFacilityLayerItemImpl) {
            return getUID(this) == getUID((CruiseFacilityLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        long cPtr = getCPtr(cruiseFacilityLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        if (cruiseFacilityLayerItemImpl == null) {
            return 0L;
        }
        return cruiseFacilityLayerItemImpl.swigCPtr;
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
        CruiseFacilityLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CruiseFacilityLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public CruiseFacilityLayerItemImpl(@CruiseFacilityType.CruiseFacilityType1 int i, int i2, int i3) {
        this(createNativeObj(i, i2, i3), true);
        LayerSvrJNI.swig_jni_init();
        CruiseFacilityLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMType(@CruiseFacilityType.CruiseFacilityType1 int i) {
        $explicit_setMType(i);
    }

    public void $explicit_setMType(@CruiseFacilityType.CruiseFacilityType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTypeSetNative(j, this, i);
    }

    @CruiseFacilityType.CruiseFacilityType1
    public int getMType() {
        return $explicit_getMType();
    }

    @CruiseFacilityType.CruiseFacilityType1
    public int $explicit_getMType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTypeGetNative(j, this);
    }

    public void setMSpeed(int i) {
        $explicit_setMSpeed(i);
    }

    public void $explicit_setMSpeed(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mSpeedSetNative(j, this, i);
    }

    public int getMSpeed() {
        return $explicit_getMSpeed();
    }

    public int $explicit_getMSpeed() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mSpeedGetNative(j, this);
    }

    public void setMDistance(int i) {
        $explicit_setMDistance(i);
    }

    public void $explicit_setMDistance(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mDistanceSetNative(j, this, i);
    }

    public int getMDistance() {
        return $explicit_getMDistance();
    }

    public int $explicit_getMDistance() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mDistanceGetNative(j, this);
    }

    public void setMFacilityList(ArrayList<BizCruiseFacilityInfo> arrayList) {
        $explicit_setMFacilityList(arrayList);
    }

    public void $explicit_setMFacilityList(ArrayList<BizCruiseFacilityInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mFacilityListSetNative(j, this, arrayList);
    }

    public ArrayList<BizCruiseFacilityInfo> getMFacilityList() {
        return $explicit_getMFacilityList();
    }

    public ArrayList<BizCruiseFacilityInfo> $explicit_getMFacilityList() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mFacilityListGetNative(j, this);
    }

    public void setIndex(int i) {
        $explicit_setIndex(i);
    }

    public void $explicit_setIndex(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        indexSetNative(j, this, i);
    }

    public int getIndex() {
        return $explicit_getIndex();
    }

    public int $explicit_getIndex() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return indexGetNative(j, this);
    }
}
