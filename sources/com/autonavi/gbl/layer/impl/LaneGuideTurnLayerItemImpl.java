package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.LaneGuideTurnLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = LaneGuideTurnLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class LaneGuideTurnLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideTurnLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long LaneGuideTurnLayerItemImpl_SWIGUpcast(long j);

    private static native void LaneGuideTurnLayerItemImpl_change_ownership(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, long j, boolean z);

    private static native void LaneGuideTurnLayerItemImpl_director_connect(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mDirectionTypeGetNative(long j, LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl);

    private static native void mDirectionTypeSetNative(long j, LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, int i);

    private static native short mMainActionGetNative(long j, LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl);

    private static native void mMainActionSetNative(long j, LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, short s);

    private static native long mPathIDGetNative(long j, LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl);

    private static native void mPathIDSetNative(long j, LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, long j2);

    private static native long mRemainDistGetNative(long j, LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl);

    private static native void mRemainDistSetNative(long j, LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, long j2);

    private static native int mSegmentIDGetNative(long j, LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl);

    private static native void mSegmentIDSetNative(long j, LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, int i);

    public LaneGuideTurnLayerItemImpl(long j, boolean z) {
        super(LaneGuideTurnLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof LaneGuideTurnLayerItemImpl) {
            return getUID(this) == getUID((LaneGuideTurnLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        long cPtr = getCPtr(laneGuideTurnLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        if (laneGuideTurnLayerItemImpl == null) {
            return 0L;
        }
        return laneGuideTurnLayerItemImpl.swigCPtr;
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
        LaneGuideTurnLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        LaneGuideTurnLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LaneGuideTurnLayerItemImpl() {
        this(createNativeObj(), true);
        LayerLaneSvrJNI.swig_jni_init();
        LaneGuideTurnLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
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

    public void setMSegmentID(int i) {
        $explicit_setMSegmentID(i);
    }

    public void $explicit_setMSegmentID(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mSegmentIDSetNative(j, this, i);
    }

    public int getMSegmentID() {
        return $explicit_getMSegmentID();
    }

    public int $explicit_getMSegmentID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mSegmentIDGetNative(j, this);
    }

    public void setMMainAction(short s) {
        $explicit_setMMainAction(s);
    }

    public void $explicit_setMMainAction(short s) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mMainActionSetNative(j, this, s);
    }

    public short getMMainAction() {
        return $explicit_getMMainAction();
    }

    public short $explicit_getMMainAction() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mMainActionGetNative(j, this);
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
