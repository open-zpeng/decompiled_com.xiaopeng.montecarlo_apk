package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.path.model.TrafficStatus;
import com.autonavi.gbl.guide.model.CongestExtend;
import com.autonavi.gbl.layer.GuideCongestionLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = GuideCongestionLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class GuideCongestionLayerItemImpl extends QuadrantLayerItem {
    private static BindTable BIND_TABLE = new BindTable(GuideCongestionLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long GuideCongestionLayerItemImpl_SWIGUpcast(long j);

    private static native void GuideCongestionLayerItemImpl_change_ownership(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, long j, boolean z);

    private static native void GuideCongestionLayerItemImpl_director_connect(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, long j);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native CongestExtend mCongestExtendGetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl);

    private static native void mCongestExtendSetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, long j2, CongestExtend congestExtend);

    private static native int mCongestionStatusGetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl);

    private static native void mCongestionStatusSetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, int i);

    private static native int mDirectionStyleGetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl);

    private static native void mDirectionStyleSetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, int i);

    private static native int mLayerTagGetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl);

    private static native void mLayerTagSetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, int i);

    private static native long mRemainDistGetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl);

    private static native void mRemainDistSetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, long j2);

    private static native String mTimeInfoGetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl);

    private static native void mTimeInfoSetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, String str);

    private static native long mTotalRemainDistGetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl);

    private static native void mTotalRemainDistSetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, long j2);

    private static native long mTotalTimeOfSecondsGetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl);

    private static native void mTotalTimeOfSecondsSetNative(long j, GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, long j2);

    public GuideCongestionLayerItemImpl(long j, boolean z) {
        super(GuideCongestionLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof GuideCongestionLayerItemImpl) {
            return getUID(this) == getUID((GuideCongestionLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        long cPtr = getCPtr(guideCongestionLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        if (guideCongestionLayerItemImpl == null) {
            return 0L;
        }
        return guideCongestionLayerItemImpl.swigCPtr;
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
        GuideCongestionLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GuideCongestionLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public GuideCongestionLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j) {
        this(createNativeObj(i, j), true);
        LayerSvrJNI.swig_jni_init();
        GuideCongestionLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
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

    public void setMTimeInfo(String str) {
        $explicit_setMTimeInfo(str);
    }

    public void $explicit_setMTimeInfo(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTimeInfoSetNative(j, this, str);
    }

    public String getMTimeInfo() {
        return $explicit_getMTimeInfo();
    }

    public String $explicit_getMTimeInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTimeInfoGetNative(j, this);
    }

    public void setMCongestExtend(CongestExtend congestExtend) {
        $explicit_setMCongestExtend(congestExtend);
    }

    public void $explicit_setMCongestExtend(CongestExtend congestExtend) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mCongestExtendSetNative(j, this, 0L, congestExtend);
    }

    public CongestExtend getMCongestExtend() {
        return $explicit_getMCongestExtend();
    }

    public CongestExtend $explicit_getMCongestExtend() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCongestExtendGetNative(j, this);
    }

    public void setMLayerTag(int i) {
        $explicit_setMLayerTag(i);
    }

    public void $explicit_setMLayerTag(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mLayerTagSetNative(j, this, i);
    }

    public int getMLayerTag() {
        return $explicit_getMLayerTag();
    }

    public int $explicit_getMLayerTag() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mLayerTagGetNative(j, this);
    }

    public void setMRemainDist(long j) {
        $explicit_setMRemainDist(j);
    }

    public void $explicit_setMRemainDist(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        mRemainDistSetNative(j2, this, j);
    }

    public long getMRemainDist() {
        return $explicit_getMRemainDist();
    }

    public long $explicit_getMRemainDist() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mRemainDistGetNative(j, this);
    }

    public void setMTotalTimeOfSeconds(long j) {
        $explicit_setMTotalTimeOfSeconds(j);
    }

    public void $explicit_setMTotalTimeOfSeconds(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        mTotalTimeOfSecondsSetNative(j2, this, j);
    }

    public long getMTotalTimeOfSeconds() {
        return $explicit_getMTotalTimeOfSeconds();
    }

    public long $explicit_getMTotalTimeOfSeconds() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTotalTimeOfSecondsGetNative(j, this);
    }

    public void setMTotalRemainDist(long j) {
        $explicit_setMTotalRemainDist(j);
    }

    public void $explicit_setMTotalRemainDist(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        mTotalRemainDistSetNative(j2, this, j);
    }

    public long getMTotalRemainDist() {
        return $explicit_getMTotalRemainDist();
    }

    public long $explicit_getMTotalRemainDist() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTotalRemainDistGetNative(j, this);
    }
}
