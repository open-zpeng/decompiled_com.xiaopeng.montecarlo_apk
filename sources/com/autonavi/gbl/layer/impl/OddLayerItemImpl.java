package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.OddLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizOddInfo;
import com.autonavi.gbl.layer.model.ODDPointType;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = OddLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class OddLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(OddLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long OddLayerItemImpl_SWIGUpcast(long j);

    private static native void OddLayerItemImpl_change_ownership(OddLayerItemImpl oddLayerItemImpl, long j, boolean z);

    private static native void OddLayerItemImpl_director_connect(OddLayerItemImpl oddLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, long j, BizOddInfo bizOddInfo, long j2, RectDouble rectDouble);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native BizOddInfo mOddInfoGetNative(long j, OddLayerItemImpl oddLayerItemImpl);

    private static native void mOddInfoSetNative(long j, OddLayerItemImpl oddLayerItemImpl, long j2, BizOddInfo bizOddInfo);

    private static native int mPointTypeGetNative(long j, OddLayerItemImpl oddLayerItemImpl);

    private static native void mPointTypeSetNative(long j, OddLayerItemImpl oddLayerItemImpl, int i);

    private static native RectDouble mRectGetNative(long j, OddLayerItemImpl oddLayerItemImpl);

    private static native void mRectSetNative(long j, OddLayerItemImpl oddLayerItemImpl, long j2, RectDouble rectDouble);

    public OddLayerItemImpl(long j, boolean z) {
        super(OddLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof OddLayerItemImpl) {
            return getUID(this) == getUID((OddLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(OddLayerItemImpl oddLayerItemImpl) {
        long cPtr = getCPtr(oddLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(OddLayerItemImpl oddLayerItemImpl) {
        if (oddLayerItemImpl == null) {
            return 0L;
        }
        return oddLayerItemImpl.swigCPtr;
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
        OddLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        OddLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public OddLayerItemImpl(@ODDPointType.ODDPointType1 int i, BizOddInfo bizOddInfo, RectDouble rectDouble) {
        this(createNativeObj(i, 0L, bizOddInfo, 0L, rectDouble), true);
        LayerSvrJNI.swig_jni_init();
        OddLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMPointType(@ODDPointType.ODDPointType1 int i) {
        $explicit_setMPointType(i);
    }

    public void $explicit_setMPointType(@ODDPointType.ODDPointType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mPointTypeSetNative(j, this, i);
    }

    @ODDPointType.ODDPointType1
    public int getMPointType() {
        return $explicit_getMPointType();
    }

    @ODDPointType.ODDPointType1
    public int $explicit_getMPointType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mPointTypeGetNative(j, this);
    }

    public void setMOddInfo(BizOddInfo bizOddInfo) {
        $explicit_setMOddInfo(bizOddInfo);
    }

    public void $explicit_setMOddInfo(BizOddInfo bizOddInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mOddInfoSetNative(j, this, 0L, bizOddInfo);
    }

    public BizOddInfo getMOddInfo() {
        return $explicit_getMOddInfo();
    }

    public BizOddInfo $explicit_getMOddInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mOddInfoGetNative(j, this);
    }

    public void setMRect(RectDouble rectDouble) {
        $explicit_setMRect(rectDouble);
    }

    public void $explicit_setMRect(RectDouble rectDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mRectSetNative(j, this, 0L, rectDouble);
    }

    public RectDouble getMRect() {
        return $explicit_getMRect();
    }

    public RectDouble $explicit_getMRect() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mRectGetNative(j, this);
    }
}
