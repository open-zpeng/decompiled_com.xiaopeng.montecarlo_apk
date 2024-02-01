package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.CruiseCongestionEventLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizSocolEventInfo;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = CruiseCongestionEventLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CruiseCongestionEventLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CruiseCongestionEventLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long CruiseCongestionEventLayerItemImpl_SWIGUpcast(long j);

    private static native void CruiseCongestionEventLayerItemImpl_change_ownership(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, long j, boolean z);

    private static native void CruiseCongestionEventLayerItemImpl_director_connect(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native BizSocolEventInfo mSocolEventInfoGetNative(long j, CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl);

    private static native void mSocolEventInfoSetNative(long j, CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, long j2, BizSocolEventInfo bizSocolEventInfo);

    public CruiseCongestionEventLayerItemImpl(long j, boolean z) {
        super(CruiseCongestionEventLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof CruiseCongestionEventLayerItemImpl) {
            return getUID(this) == getUID((CruiseCongestionEventLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        long cPtr = getCPtr(cruiseCongestionEventLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        if (cruiseCongestionEventLayerItemImpl == null) {
            return 0L;
        }
        return cruiseCongestionEventLayerItemImpl.swigCPtr;
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
        CruiseCongestionEventLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CruiseCongestionEventLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public CruiseCongestionEventLayerItemImpl() {
        this(createNativeObj(), true);
        LayerSvrJNI.swig_jni_init();
        CruiseCongestionEventLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMSocolEventInfo(BizSocolEventInfo bizSocolEventInfo) {
        $explicit_setMSocolEventInfo(bizSocolEventInfo);
    }

    public void $explicit_setMSocolEventInfo(BizSocolEventInfo bizSocolEventInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mSocolEventInfoSetNative(j, this, 0L, bizSocolEventInfo);
    }

    public BizSocolEventInfo getMSocolEventInfo() {
        return $explicit_getMSocolEventInfo();
    }

    public BizSocolEventInfo $explicit_getMSocolEventInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mSocolEventInfoGetNative(j, this);
    }
}
