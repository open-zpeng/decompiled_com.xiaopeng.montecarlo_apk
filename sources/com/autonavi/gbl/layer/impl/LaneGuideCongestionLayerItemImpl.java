package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.guide.model.CongestExtend;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.LaneGuideCongestionLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = LaneGuideCongestionLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class LaneGuideCongestionLayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideCongestionLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long LaneGuideCongestionLayerItemImpl_SWIGUpcast(long j);

    private static native void LaneGuideCongestionLayerItemImpl_change_ownership(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, long j, boolean z);

    private static native void LaneGuideCongestionLayerItemImpl_director_connect(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, long j);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native CongestExtend mCongestExtendGetNative(long j, LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl);

    private static native void mCongestExtendSetNative(long j, LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, long j2, CongestExtend congestExtend);

    private static native int mDirectionTypeGetNative(long j, LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl);

    private static native void mDirectionTypeSetNative(long j, LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, int i);

    private static native long mPathIDGetNative(long j, LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl);

    private static native void mPathIDSetNative(long j, LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, long j2);

    private static native long mTotalRemainDistGetNative(long j, LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl);

    private static native void mTotalRemainDistSetNative(long j, LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, long j2);

    private static native long mTotalTimeOfSecondsGetNative(long j, LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl);

    private static native void mTotalTimeOfSecondsSetNative(long j, LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, long j2);

    private static native void onVisibleNative(long j, LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, boolean z);

    private static native void onVisibleSwigExplicitLaneGuideCongestionLayerItemImplNative(long j, LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, boolean z);

    private static native void resetOnVisibleNative(long j, LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, boolean z);

    private static native void resetOnVisibleSwigExplicitLaneGuideCongestionLayerItemImplNative(long j, LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, boolean z);

    public LaneGuideCongestionLayerItemImpl(long j, boolean z) {
        super(LaneGuideCongestionLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof LaneGuideCongestionLayerItemImpl) {
            return getUID(this) == getUID((LaneGuideCongestionLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        long cPtr = getCPtr(laneGuideCongestionLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        if (laneGuideCongestionLayerItemImpl == null) {
            return 0L;
        }
        return laneGuideCongestionLayerItemImpl.swigCPtr;
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
        LaneGuideCongestionLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        LaneGuideCongestionLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LaneGuideCongestionLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j) {
        this(createNativeObj(i, j), true);
        LayerLaneSvrJNI.swig_jni_init();
        LaneGuideCongestionLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        $explicit_resetOnVisible(z);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_resetOnVisible(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LaneGuideCongestionLayerItemImpl.class) {
            resetOnVisibleNative(this.swigCPtr, this, z);
        } else {
            resetOnVisibleSwigExplicitLaneGuideCongestionLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        $explicit_onVisible(z);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_onVisible(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LaneGuideCongestionLayerItemImpl.class) {
            onVisibleNative(this.swigCPtr, this, z);
        } else {
            onVisibleSwigExplicitLaneGuideCongestionLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public void setMPathID(long j) {
        $explicit_setMPathID(j);
    }

    public void $explicit_setMPathID(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        mPathIDSetNative(j2, this, j);
    }

    public long getMPathID() {
        return $explicit_getMPathID();
    }

    public long $explicit_getMPathID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mPathIDGetNative(j, this);
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

    public void setMDirectionType(@BubbleDirectionType.BubbleDirectionType1 int i) {
        $explicit_setMDirectionType(i);
    }

    public void $explicit_setMDirectionType(@BubbleDirectionType.BubbleDirectionType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mDirectionTypeSetNative(j, this, i);
    }

    @BubbleDirectionType.BubbleDirectionType1
    public int getMDirectionType() {
        return $explicit_getMDirectionType();
    }

    @BubbleDirectionType.BubbleDirectionType1
    public int $explicit_getMDirectionType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mDirectionTypeGetNative(j, this);
    }
}
