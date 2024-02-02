package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.model.TrafficStatus;
import com.autonavi.gbl.layer.CruiseCongestionPromptLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = CruiseCongestionPromptLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class CruiseCongestionPromptLayerItemImpl extends QuadrantLayerItem {
    private static BindTable BIND_TABLE = new BindTable(CruiseCongestionPromptLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long CruiseCongestionPromptLayerItemImpl_SWIGUpcast(long j);

    private static native void CruiseCongestionPromptLayerItemImpl_change_ownership(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, long j, boolean z);

    private static native void CruiseCongestionPromptLayerItemImpl_director_connect(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, long j);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native String mCongestionDetailGetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl);

    private static native void mCongestionDetailSetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, String str);

    private static native Coord2DDouble mCongestionEndPosGetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl);

    private static native void mCongestionEndPosSetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, long j2, Coord2DDouble coord2DDouble);

    private static native int mCongestionStatusGetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl);

    private static native void mCongestionStatusSetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, int i);

    private static native int mDirectionStyleGetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl);

    private static native void mDirectionStyleSetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, int i);

    private static native Coord2DDouble mEnterCarPosGetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl);

    private static native void mEnterCarPosSetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, long j2, Coord2DDouble coord2DDouble);

    private static native long mEnterTimeGetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl);

    private static native void mEnterTimeSetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, long j2);

    private static native int mEtaTimeGetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl);

    private static native void mEtaTimeSetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, int i);

    private static native int mLengthGetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl);

    private static native void mLengthSetNative(long j, CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, int i);

    public CruiseCongestionPromptLayerItemImpl(long j, boolean z) {
        super(CruiseCongestionPromptLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof CruiseCongestionPromptLayerItemImpl) {
            return getUID(this) == getUID((CruiseCongestionPromptLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        long cPtr = getCPtr(cruiseCongestionPromptLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        if (cruiseCongestionPromptLayerItemImpl == null) {
            return 0L;
        }
        return cruiseCongestionPromptLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        CruiseCongestionPromptLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CruiseCongestionPromptLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public CruiseCongestionPromptLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j) {
        this(createNativeObj(i, j), true);
        LayerSvrJNI.swig_jni_init();
        CruiseCongestionPromptLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void setMEtaTime(int i) {
        $explicit_setMEtaTime(i);
    }

    public void $explicit_setMEtaTime(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mEtaTimeSetNative(j, this, i);
    }

    public int getMEtaTime() {
        return $explicit_getMEtaTime();
    }

    public int $explicit_getMEtaTime() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mEtaTimeGetNative(j, this);
    }

    public void setMLength(int i) {
        $explicit_setMLength(i);
    }

    public void $explicit_setMLength(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mLengthSetNative(j, this, i);
    }

    public int getMLength() {
        return $explicit_getMLength();
    }

    public int $explicit_getMLength() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mLengthGetNative(j, this);
    }

    public void setMEnterTime(long j) {
        $explicit_setMEnterTime(j);
    }

    public void $explicit_setMEnterTime(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        mEnterTimeSetNative(j2, this, j);
    }

    public long getMEnterTime() {
        return $explicit_getMEnterTime();
    }

    public long $explicit_getMEnterTime() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mEnterTimeGetNative(j, this);
    }

    public void setMEnterCarPos(Coord2DDouble coord2DDouble) {
        $explicit_setMEnterCarPos(coord2DDouble);
    }

    public void $explicit_setMEnterCarPos(Coord2DDouble coord2DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mEnterCarPosSetNative(j, this, 0L, coord2DDouble);
    }

    public Coord2DDouble getMEnterCarPos() {
        return $explicit_getMEnterCarPos();
    }

    public Coord2DDouble $explicit_getMEnterCarPos() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mEnterCarPosGetNative(j, this);
    }

    public void setMCongestionEndPos(Coord2DDouble coord2DDouble) {
        $explicit_setMCongestionEndPos(coord2DDouble);
    }

    public void $explicit_setMCongestionEndPos(Coord2DDouble coord2DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mCongestionEndPosSetNative(j, this, 0L, coord2DDouble);
    }

    public Coord2DDouble getMCongestionEndPos() {
        return $explicit_getMCongestionEndPos();
    }

    public Coord2DDouble $explicit_getMCongestionEndPos() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCongestionEndPosGetNative(j, this);
    }

    public void setMCongestionStatus(@TrafficStatus.TrafficStatus1 int i) {
        $explicit_setMCongestionStatus(i);
    }

    public void $explicit_setMCongestionStatus(@TrafficStatus.TrafficStatus1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mCongestionStatusSetNative(j, this, i);
    }

    @TrafficStatus.TrafficStatus1
    public int getMCongestionStatus() {
        return $explicit_getMCongestionStatus();
    }

    @TrafficStatus.TrafficStatus1
    public int $explicit_getMCongestionStatus() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCongestionStatusGetNative(j, this);
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

    public void setMCongestionDetail(String str) {
        $explicit_setMCongestionDetail(str);
    }

    public void $explicit_setMCongestionDetail(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mCongestionDetailSetNative(j, this, str);
    }

    public String getMCongestionDetail() {
        return $explicit_getMCongestionDetail();
    }

    public String $explicit_getMCongestionDetail() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCongestionDetailGetNative(j, this);
    }
}
