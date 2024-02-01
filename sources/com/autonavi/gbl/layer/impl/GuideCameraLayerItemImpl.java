package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.SubCameraExtType;
import com.autonavi.gbl.guide.model.NaviSubCameraExt;
import com.autonavi.gbl.layer.GuideCameraLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.BizGuideCameraInfo;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import java.util.ArrayList;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = GuideCameraLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class GuideCameraLayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideCameraLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long GuideCameraLayerItemImpl_SWIGUpcast(long j);

    private static native void GuideCameraLayerItemImpl_change_ownership(GuideCameraLayerItemImpl guideCameraLayerItemImpl, long j, boolean z);

    private static native void GuideCameraLayerItemImpl_director_connect(GuideCameraLayerItemImpl guideCameraLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, BizGuideCameraInfo bizGuideCameraInfo, int i, int i2);

    private static native long createNativeObj1(int i, long j, long j2, BizGuideCameraInfo bizGuideCameraInfo, int i2, int i3);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native ArrayList<NaviSubCameraExt> mAggregatedExtsGetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl);

    private static native void mAggregatedExtsSetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl, ArrayList<NaviSubCameraExt> arrayList);

    private static native int mCameraExtTypeGetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl);

    private static native void mCameraExtTypeSetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl, int i);

    private static native long mCameraIdGetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl);

    private static native void mCameraIdSetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl, long j2);

    private static native int mCameraSpeedGetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl);

    private static native void mCameraSpeedSetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl, int i);

    private static native int mDirectionStyleGetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl);

    private static native void mDirectionStyleSetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl, int i);

    private static native int mDistanceGetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl);

    private static native void mDistanceSetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl, int i);

    private static native boolean mNeedShowNewCameraGetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl);

    private static native void mNeedShowNewCameraSetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl, boolean z);

    private static native boolean mNeedShowPenaltyGetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl);

    private static native void mNeedShowPenaltySetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl, boolean z);

    private static native Coord3DDouble mPositionGetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl);

    private static native void mPositionSetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native boolean mRunTimeShowNewCameraGetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl);

    private static native void mRunTimeShowNewCameraSetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl, boolean z);

    private static native boolean mRunTimeShowPenaltyGetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl);

    private static native void mRunTimeShowPenaltySetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl, boolean z);

    private static native int mWantDirectionStyleGetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl);

    private static native void mWantDirectionStyleSetNative(long j, GuideCameraLayerItemImpl guideCameraLayerItemImpl, int i);

    public GuideCameraLayerItemImpl(long j, boolean z) {
        super(GuideCameraLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof GuideCameraLayerItemImpl) {
            return getUID(this) == getUID((GuideCameraLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        long cPtr = getCPtr(guideCameraLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        if (guideCameraLayerItemImpl == null) {
            return 0L;
        }
        return guideCameraLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        GuideCameraLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GuideCameraLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public GuideCameraLayerItemImpl(BizGuideCameraInfo bizGuideCameraInfo, @BizDirectionStyle.BizDirectionStyle1 int i, int i2) {
        this(createNativeObj(0L, bizGuideCameraInfo, i, i2), true);
        LayerSvrJNI.swig_jni_init();
        GuideCameraLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public GuideCameraLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j, BizGuideCameraInfo bizGuideCameraInfo, @BizDirectionStyle.BizDirectionStyle1 int i2, int i3) {
        this(createNativeObj1(i, j, 0L, bizGuideCameraInfo, i2, i3), true);
        LayerSvrJNI.swig_jni_init();
        GuideCameraLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMCameraExtType(@SubCameraExtType.SubCameraExtType1 int i) {
        $explicit_setMCameraExtType(i);
    }

    public void $explicit_setMCameraExtType(@SubCameraExtType.SubCameraExtType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mCameraExtTypeSetNative(j, this, i);
    }

    @SubCameraExtType.SubCameraExtType1
    public int getMCameraExtType() {
        return $explicit_getMCameraExtType();
    }

    @SubCameraExtType.SubCameraExtType1
    public int $explicit_getMCameraExtType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCameraExtTypeGetNative(j, this);
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

    public void setMCameraSpeed(int i) {
        $explicit_setMCameraSpeed(i);
    }

    public void $explicit_setMCameraSpeed(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mCameraSpeedSetNative(j, this, i);
    }

    public int getMCameraSpeed() {
        return $explicit_getMCameraSpeed();
    }

    public int $explicit_getMCameraSpeed() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCameraSpeedGetNative(j, this);
    }

    public void setMPosition(Coord3DDouble coord3DDouble) {
        $explicit_setMPosition(coord3DDouble);
    }

    public void $explicit_setMPosition(Coord3DDouble coord3DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mPositionSetNative(j, this, 0L, coord3DDouble);
    }

    public Coord3DDouble getMPosition() {
        return $explicit_getMPosition();
    }

    public Coord3DDouble $explicit_getMPosition() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mPositionGetNative(j, this);
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

    public void setMNeedShowPenalty(boolean z) {
        $explicit_setMNeedShowPenalty(z);
    }

    public void $explicit_setMNeedShowPenalty(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mNeedShowPenaltySetNative(j, this, z);
    }

    public boolean getMNeedShowPenalty() {
        return $explicit_getMNeedShowPenalty();
    }

    public boolean $explicit_getMNeedShowPenalty() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mNeedShowPenaltyGetNative(j, this);
    }

    public void setMWantDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        $explicit_setMWantDirectionStyle(i);
    }

    public void $explicit_setMWantDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mWantDirectionStyleSetNative(j, this, i);
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int getMWantDirectionStyle() {
        return $explicit_getMWantDirectionStyle();
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int $explicit_getMWantDirectionStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mWantDirectionStyleGetNative(j, this);
    }

    public void setMNeedShowNewCamera(boolean z) {
        $explicit_setMNeedShowNewCamera(z);
    }

    public void $explicit_setMNeedShowNewCamera(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mNeedShowNewCameraSetNative(j, this, z);
    }

    public boolean getMNeedShowNewCamera() {
        return $explicit_getMNeedShowNewCamera();
    }

    public boolean $explicit_getMNeedShowNewCamera() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mNeedShowNewCameraGetNative(j, this);
    }

    public void setMCameraId(long j) {
        $explicit_setMCameraId(j);
    }

    public void $explicit_setMCameraId(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        mCameraIdSetNative(j2, this, j);
    }

    public long getMCameraId() {
        return $explicit_getMCameraId();
    }

    public long $explicit_getMCameraId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCameraIdGetNative(j, this);
    }

    public void setMRunTimeShowPenalty(boolean z) {
        $explicit_setMRunTimeShowPenalty(z);
    }

    public void $explicit_setMRunTimeShowPenalty(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mRunTimeShowPenaltySetNative(j, this, z);
    }

    public boolean getMRunTimeShowPenalty() {
        return $explicit_getMRunTimeShowPenalty();
    }

    public boolean $explicit_getMRunTimeShowPenalty() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mRunTimeShowPenaltyGetNative(j, this);
    }

    public void setMRunTimeShowNewCamera(boolean z) {
        $explicit_setMRunTimeShowNewCamera(z);
    }

    public void $explicit_setMRunTimeShowNewCamera(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mRunTimeShowNewCameraSetNative(j, this, z);
    }

    public boolean getMRunTimeShowNewCamera() {
        return $explicit_getMRunTimeShowNewCamera();
    }

    public boolean $explicit_getMRunTimeShowNewCamera() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mRunTimeShowNewCameraGetNative(j, this);
    }

    public void setMAggregatedExts(ArrayList<NaviSubCameraExt> arrayList) {
        $explicit_setMAggregatedExts(arrayList);
    }

    public void $explicit_setMAggregatedExts(ArrayList<NaviSubCameraExt> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mAggregatedExtsSetNative(j, this, arrayList);
    }

    public ArrayList<NaviSubCameraExt> getMAggregatedExts() {
        return $explicit_getMAggregatedExts();
    }

    public ArrayList<NaviSubCameraExt> $explicit_getMAggregatedExts() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mAggregatedExtsGetNative(j, this);
    }
}
