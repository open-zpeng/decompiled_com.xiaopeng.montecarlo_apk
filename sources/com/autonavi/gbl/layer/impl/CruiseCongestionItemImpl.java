package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.TrafficStatus;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.layer.CruiseCongestionItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.LineLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = CruiseCongestionItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CruiseCongestionItemImpl extends LineLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CruiseCongestionItemImpl.class);
    private transient long swigCPtr;

    private static native long CruiseCongestionItemImpl_SWIGUpcast(long j);

    private static native void CruiseCongestionItemImpl_change_ownership(CruiseCongestionItemImpl cruiseCongestionItemImpl, long j, boolean z);

    private static native void CruiseCongestionItemImpl_director_connect(CruiseCongestionItemImpl cruiseCongestionItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native CruiseCongestionInfo mInfoGetNative(long j, CruiseCongestionItemImpl cruiseCongestionItemImpl);

    private static native void mInfoSetNative(long j, CruiseCongestionItemImpl cruiseCongestionItemImpl, long j2, CruiseCongestionInfo cruiseCongestionInfo);

    private static native int mStatusGetNative(long j, CruiseCongestionItemImpl cruiseCongestionItemImpl);

    private static native void mStatusSetNative(long j, CruiseCongestionItemImpl cruiseCongestionItemImpl, int i);

    public CruiseCongestionItemImpl(long j, boolean z) {
        super(CruiseCongestionItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof CruiseCongestionItemImpl) {
            return getUID(this) == getUID((CruiseCongestionItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        long cPtr = getCPtr(cruiseCongestionItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        if (cruiseCongestionItemImpl == null) {
            return 0L;
        }
        return cruiseCongestionItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        CruiseCongestionItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CruiseCongestionItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public CruiseCongestionItemImpl() {
        this(createNativeObj(), true);
        LayerSvrJNI.swig_jni_init();
        CruiseCongestionItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMStatus(@TrafficStatus.TrafficStatus1 int i) {
        $explicit_setMStatus(i);
    }

    public void $explicit_setMStatus(@TrafficStatus.TrafficStatus1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mStatusSetNative(j, this, i);
    }

    @TrafficStatus.TrafficStatus1
    public int getMStatus() {
        return $explicit_getMStatus();
    }

    @TrafficStatus.TrafficStatus1
    public int $explicit_getMStatus() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mStatusGetNative(j, this);
    }

    public void setMInfo(CruiseCongestionInfo cruiseCongestionInfo) {
        $explicit_setMInfo(cruiseCongestionInfo);
    }

    public void $explicit_setMInfo(CruiseCongestionInfo cruiseCongestionInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mInfoSetNative(j, this, 0L, cruiseCongestionInfo);
    }

    public CruiseCongestionInfo getMInfo() {
        return $explicit_getMInfo();
    }

    public CruiseCongestionInfo $explicit_getMInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mInfoGetNative(j, this);
    }
}
