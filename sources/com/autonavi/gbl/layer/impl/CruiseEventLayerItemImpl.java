package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.guide.model.CruiseEventInfo;
import com.autonavi.gbl.layer.CruiseEventLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = CruiseEventLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CruiseEventLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CruiseEventLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long CruiseEventLayerItemImpl_SWIGUpcast(long j);

    private static native void CruiseEventLayerItemImpl_change_ownership(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, long j, boolean z);

    private static native void CruiseEventLayerItemImpl_director_connect(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, CruiseEventInfo cruiseEventInfo);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native CruiseEventInfo mCruiseEventInfoGetNative(long j, CruiseEventLayerItemImpl cruiseEventLayerItemImpl);

    private static native void mCruiseEventInfoSetNative(long j, CruiseEventLayerItemImpl cruiseEventLayerItemImpl, long j2, CruiseEventInfo cruiseEventInfo);

    private static native boolean mShowTextGetNative(long j, CruiseEventLayerItemImpl cruiseEventLayerItemImpl);

    private static native void mShowTextSetNative(long j, CruiseEventLayerItemImpl cruiseEventLayerItemImpl, boolean z);

    public CruiseEventLayerItemImpl(long j, boolean z) {
        super(CruiseEventLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof CruiseEventLayerItemImpl) {
            return getUID(this) == getUID((CruiseEventLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        long cPtr = getCPtr(cruiseEventLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        if (cruiseEventLayerItemImpl == null) {
            return 0L;
        }
        return cruiseEventLayerItemImpl.swigCPtr;
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
        CruiseEventLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CruiseEventLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public CruiseEventLayerItemImpl(CruiseEventInfo cruiseEventInfo) {
        this(createNativeObj(0L, cruiseEventInfo), true);
        LayerSvrJNI.swig_jni_init();
        CruiseEventLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMCruiseEventInfo(CruiseEventInfo cruiseEventInfo) {
        $explicit_setMCruiseEventInfo(cruiseEventInfo);
    }

    public void $explicit_setMCruiseEventInfo(CruiseEventInfo cruiseEventInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mCruiseEventInfoSetNative(j, this, 0L, cruiseEventInfo);
    }

    public CruiseEventInfo getMCruiseEventInfo() {
        return $explicit_getMCruiseEventInfo();
    }

    public CruiseEventInfo $explicit_getMCruiseEventInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCruiseEventInfoGetNative(j, this);
    }

    public void setMShowText(boolean z) {
        $explicit_setMShowText(z);
    }

    public void $explicit_setMShowText(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mShowTextSetNative(j, this, z);
    }

    public boolean getMShowText() {
        return $explicit_getMShowText();
    }

    public boolean $explicit_getMShowText() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mShowTextGetNative(j, this);
    }
}
