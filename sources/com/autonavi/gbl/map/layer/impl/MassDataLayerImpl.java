package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.creflex.BaseLayerCRfxProto;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.MassDataLayer;
import com.autonavi.gbl.map.layer.model.MassDataCircleInfo;
import com.autonavi.gbl.map.layer.model.MassDataPointInfo;
import com.autonavi.gbl.map.layer.model.MassDataPolygonInfo;
import com.autonavi.gbl.map.layer.model.MassDataPolylineInfo;
import java.util.ArrayList;
import java.util.HashMap;
@IntfAuto(enableCRfx = true, protoOfCRfx = BaseLayerCRfxProto.class, target = MassDataLayer.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class MassDataLayerImpl extends BaseLayerImpl {
    private static BindTable BIND_TABLE = new BindTable(MassDataLayerImpl.class);
    private transient long swigCPtr;

    private static native long MassDataLayerImpl_SWIGUpcast(long j);

    private static native void MassDataLayerImpl_change_ownership(MassDataLayerImpl massDataLayerImpl, long j, boolean z);

    private static native void MassDataLayerImpl_director_connect(MassDataLayerImpl massDataLayerImpl, long j, boolean z, boolean z2);

    private static native void addCircleDataNative(long j, MassDataLayerImpl massDataLayerImpl, ArrayList<MassDataCircleInfo> arrayList);

    private static native void addCircleDataSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl, ArrayList<MassDataCircleInfo> arrayList);

    private static native void addPointDataNative(long j, MassDataLayerImpl massDataLayerImpl, ArrayList<MassDataPointInfo> arrayList);

    private static native void addPointDataSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl, ArrayList<MassDataPointInfo> arrayList);

    private static native void addPolygonDataNative(long j, MassDataLayerImpl massDataLayerImpl, ArrayList<MassDataPolygonInfo> arrayList);

    private static native void addPolygonDataSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl, ArrayList<MassDataPolygonInfo> arrayList);

    private static native void addPolylineDataNative(long j, MassDataLayerImpl massDataLayerImpl, ArrayList<MassDataPolylineInfo> arrayList);

    private static native void addPolylineDataSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl, ArrayList<MassDataPolylineInfo> arrayList);

    private static native long createNativeObj(String str, long j, IMapViewImpl iMapViewImpl);

    private static native void destroyNativeObj(long j);

    private static native void enableCollisionNative(long j, MassDataLayerImpl massDataLayerImpl, boolean z);

    private static native void enableCollisionSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl, boolean z);

    private static native long getAllDataCountNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native long getAllDataCountSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native RectDouble getBoundNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native RectDouble getBoundSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native long getCircleDataCountNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native long getCircleDataCountSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native String getClassTypeNameNative();

    private static native long getPointDataCountNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native long getPointDataCountSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native long getPolygonDataCountNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native long getPolygonDataCountSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native long getPolylineDataCountNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native long getPolylineDataCountSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native void removeAllCircleDataNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native void removeAllCircleDataSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native void removeAllDataNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native void removeAllDataSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native void removeAllPointDataNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native void removeAllPointDataSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native void removeAllPolygonDataNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native void removeAllPolygonDataSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native void removeAllPolylineDataNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native void removeAllPolylineDataSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl);

    private static native void removeCircleDataNative(long j, MassDataLayerImpl massDataLayerImpl, String[] strArr);

    private static native void removeCircleDataSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl, String[] strArr);

    private static native void removePointDataNative(long j, MassDataLayerImpl massDataLayerImpl, String[] strArr);

    private static native void removePointDataSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl, String[] strArr);

    private static native void removePolygonDataNative(long j, MassDataLayerImpl massDataLayerImpl, String[] strArr);

    private static native void removePolygonDataSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl, String[] strArr);

    private static native void removePolylineDataNative(long j, MassDataLayerImpl massDataLayerImpl, String[] strArr);

    private static native void removePolylineDataSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl, String[] strArr);

    private static native void setDisplayScaleCount1Native(long j, MassDataLayerImpl massDataLayerImpl, int i, int i2);

    private static native void setDisplayScaleCountNative(long j, MassDataLayerImpl massDataLayerImpl, HashMap<Integer, Integer> hashMap);

    private static native void setDisplayScaleCountSwigExplicitMassDataLayerImpl1Native(long j, MassDataLayerImpl massDataLayerImpl, int i, int i2);

    private static native void setDisplayScaleCountSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl, HashMap<Integer, Integer> hashMap);

    private static native void setLengthOfCenterChangedNative(long j, MassDataLayerImpl massDataLayerImpl, long j2);

    private static native void setLengthOfCenterChangedSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl, long j2);

    private static native void setRollAngleOfCenterChangedNative(long j, MassDataLayerImpl massDataLayerImpl, long j2);

    private static native void setRollAngleOfCenterChangedSwigExplicitMassDataLayerImplNative(long j, MassDataLayerImpl massDataLayerImpl, long j2);

    public MassDataLayerImpl(long j, boolean z) {
        super(MassDataLayerImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof MassDataLayerImpl) {
            return getUID(this) == getUID((MassDataLayerImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(MassDataLayerImpl massDataLayerImpl) {
        long cPtr = getCPtr(massDataLayerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(MassDataLayerImpl massDataLayerImpl) {
        if (massDataLayerImpl == null) {
            return 0L;
        }
        return massDataLayerImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        MassDataLayerImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        MassDataLayerImpl_change_ownership(this, this.swigCPtr, true);
    }

    public MassDataLayerImpl(String str, IMapViewImpl iMapViewImpl) {
        this(createNativeObj(str, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl), true);
        MapLayerSvrJNI.swig_jni_init();
        MassDataLayerImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl
    public void enableCollision(boolean z) {
        $explicit_enableCollision(z);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void $explicit_enableCollision(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            enableCollisionNative(this.swigCPtr, this, z);
        } else {
            enableCollisionSwigExplicitMassDataLayerImplNative(this.swigCPtr, this, z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public RectDouble getBound() {
        return $explicit_getBound();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl
    public RectDouble $explicit_getBound() {
        if (this.swigCPtr != 0) {
            return getClass() == MassDataLayerImpl.class ? getBoundNative(this.swigCPtr, this) : getBoundSwigExplicitMassDataLayerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setDisplayScaleCount(HashMap<Integer, Integer> hashMap) {
        $explicit_setDisplayScaleCount(hashMap);
    }

    public void $explicit_setDisplayScaleCount(HashMap<Integer, Integer> hashMap) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            setDisplayScaleCountNative(this.swigCPtr, this, hashMap);
        } else {
            setDisplayScaleCountSwigExplicitMassDataLayerImplNative(this.swigCPtr, this, hashMap);
        }
    }

    public void setDisplayScaleCount(int i, int i2) {
        $explicit_setDisplayScaleCount(i, i2);
    }

    public void $explicit_setDisplayScaleCount(int i, int i2) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            setDisplayScaleCount1Native(this.swigCPtr, this, i, i2);
        } else {
            setDisplayScaleCountSwigExplicitMassDataLayerImpl1Native(this.swigCPtr, this, i, i2);
        }
    }

    public void setLengthOfCenterChanged(long j) {
        $explicit_setLengthOfCenterChanged(j);
    }

    public void $explicit_setLengthOfCenterChanged(long j) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            setLengthOfCenterChangedNative(this.swigCPtr, this, j);
        } else {
            setLengthOfCenterChangedSwigExplicitMassDataLayerImplNative(this.swigCPtr, this, j);
        }
    }

    public void setRollAngleOfCenterChanged(long j) {
        $explicit_setRollAngleOfCenterChanged(j);
    }

    public void $explicit_setRollAngleOfCenterChanged(long j) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            setRollAngleOfCenterChangedNative(this.swigCPtr, this, j);
        } else {
            setRollAngleOfCenterChangedSwigExplicitMassDataLayerImplNative(this.swigCPtr, this, j);
        }
    }

    public void addPointData(ArrayList<MassDataPointInfo> arrayList) {
        $explicit_addPointData(arrayList);
    }

    public void $explicit_addPointData(ArrayList<MassDataPointInfo> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            addPointDataNative(this.swigCPtr, this, arrayList);
        } else {
            addPointDataSwigExplicitMassDataLayerImplNative(this.swigCPtr, this, arrayList);
        }
    }

    public void addPolylineData(ArrayList<MassDataPolylineInfo> arrayList) {
        $explicit_addPolylineData(arrayList);
    }

    public void $explicit_addPolylineData(ArrayList<MassDataPolylineInfo> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            addPolylineDataNative(this.swigCPtr, this, arrayList);
        } else {
            addPolylineDataSwigExplicitMassDataLayerImplNative(this.swigCPtr, this, arrayList);
        }
    }

    public void addPolygonData(ArrayList<MassDataPolygonInfo> arrayList) {
        $explicit_addPolygonData(arrayList);
    }

    public void $explicit_addPolygonData(ArrayList<MassDataPolygonInfo> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            addPolygonDataNative(this.swigCPtr, this, arrayList);
        } else {
            addPolygonDataSwigExplicitMassDataLayerImplNative(this.swigCPtr, this, arrayList);
        }
    }

    public void addCircleData(ArrayList<MassDataCircleInfo> arrayList) {
        $explicit_addCircleData(arrayList);
    }

    public void $explicit_addCircleData(ArrayList<MassDataCircleInfo> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            addCircleDataNative(this.swigCPtr, this, arrayList);
        } else {
            addCircleDataSwigExplicitMassDataLayerImplNative(this.swigCPtr, this, arrayList);
        }
    }

    public void removePointData(String[] strArr) {
        $explicit_removePointData(strArr);
    }

    public void $explicit_removePointData(String[] strArr) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            removePointDataNative(this.swigCPtr, this, strArr);
        } else {
            removePointDataSwigExplicitMassDataLayerImplNative(this.swigCPtr, this, strArr);
        }
    }

    public void removePolylineData(String[] strArr) {
        $explicit_removePolylineData(strArr);
    }

    public void $explicit_removePolylineData(String[] strArr) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            removePolylineDataNative(this.swigCPtr, this, strArr);
        } else {
            removePolylineDataSwigExplicitMassDataLayerImplNative(this.swigCPtr, this, strArr);
        }
    }

    public void removePolygonData(String[] strArr) {
        $explicit_removePolygonData(strArr);
    }

    public void $explicit_removePolygonData(String[] strArr) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            removePolygonDataNative(this.swigCPtr, this, strArr);
        } else {
            removePolygonDataSwigExplicitMassDataLayerImplNative(this.swigCPtr, this, strArr);
        }
    }

    public void removeCircleData(String[] strArr) {
        $explicit_removeCircleData(strArr);
    }

    public void $explicit_removeCircleData(String[] strArr) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            removeCircleDataNative(this.swigCPtr, this, strArr);
        } else {
            removeCircleDataSwigExplicitMassDataLayerImplNative(this.swigCPtr, this, strArr);
        }
    }

    public void removeAllPointData() {
        $explicit_removeAllPointData();
    }

    public void $explicit_removeAllPointData() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            removeAllPointDataNative(this.swigCPtr, this);
        } else {
            removeAllPointDataSwigExplicitMassDataLayerImplNative(this.swigCPtr, this);
        }
    }

    public void removeAllPolylineData() {
        $explicit_removeAllPolylineData();
    }

    public void $explicit_removeAllPolylineData() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            removeAllPolylineDataNative(this.swigCPtr, this);
        } else {
            removeAllPolylineDataSwigExplicitMassDataLayerImplNative(this.swigCPtr, this);
        }
    }

    public void removeAllPolygonData() {
        $explicit_removeAllPolygonData();
    }

    public void $explicit_removeAllPolygonData() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            removeAllPolygonDataNative(this.swigCPtr, this);
        } else {
            removeAllPolygonDataSwigExplicitMassDataLayerImplNative(this.swigCPtr, this);
        }
    }

    public void removeAllCircleData() {
        $explicit_removeAllCircleData();
    }

    public void $explicit_removeAllCircleData() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            removeAllCircleDataNative(this.swigCPtr, this);
        } else {
            removeAllCircleDataSwigExplicitMassDataLayerImplNative(this.swigCPtr, this);
        }
    }

    public void removeAllData() {
        $explicit_removeAllData();
    }

    public void $explicit_removeAllData() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == MassDataLayerImpl.class) {
            removeAllDataNative(this.swigCPtr, this);
        } else {
            removeAllDataSwigExplicitMassDataLayerImplNative(this.swigCPtr, this);
        }
    }

    public long getPointDataCount() {
        return $explicit_getPointDataCount();
    }

    public long $explicit_getPointDataCount() {
        if (this.swigCPtr != 0) {
            return getClass() == MassDataLayerImpl.class ? getPointDataCountNative(this.swigCPtr, this) : getPointDataCountSwigExplicitMassDataLayerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public long getPolylineDataCount() {
        return $explicit_getPolylineDataCount();
    }

    public long $explicit_getPolylineDataCount() {
        if (this.swigCPtr != 0) {
            return getClass() == MassDataLayerImpl.class ? getPolylineDataCountNative(this.swigCPtr, this) : getPolylineDataCountSwigExplicitMassDataLayerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public long getPolygonDataCount() {
        return $explicit_getPolygonDataCount();
    }

    public long $explicit_getPolygonDataCount() {
        if (this.swigCPtr != 0) {
            return getClass() == MassDataLayerImpl.class ? getPolygonDataCountNative(this.swigCPtr, this) : getPolygonDataCountSwigExplicitMassDataLayerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public long getCircleDataCount() {
        return $explicit_getCircleDataCount();
    }

    public long $explicit_getCircleDataCount() {
        if (this.swigCPtr != 0) {
            return getClass() == MassDataLayerImpl.class ? getCircleDataCountNative(this.swigCPtr, this) : getCircleDataCountSwigExplicitMassDataLayerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public long getAllDataCount() {
        return $explicit_getAllDataCount();
    }

    public long $explicit_getAllDataCount() {
        if (this.swigCPtr != 0) {
            return getClass() == MassDataLayerImpl.class ? getAllDataCountNative(this.swigCPtr, this) : getAllDataCountSwigExplicitMassDataLayerImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }
}
