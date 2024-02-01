package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.LaneGuideTrafficEventLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = LaneGuideTrafficEventLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class LaneGuideTrafficEventLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideTrafficEventLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long LaneGuideTrafficEventLayerItemImpl_SWIGUpcast(long j);

    private static native void LaneGuideTrafficEventLayerItemImpl_change_ownership(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, long j, boolean z);

    private static native void LaneGuideTrafficEventLayerItemImpl_director_connect(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native String laneDetailGetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl);

    private static native void laneDetailSetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, String str);

    private static native int lengthGetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl);

    private static native void lengthSetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, int i);

    private static native int mDirectionTypeGetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl);

    private static native void mDirectionTypeSetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, int i);

    private static native int mIdGetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl);

    private static native void mIdSetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, int i);

    private static native int mIndexGetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl);

    private static native void mIndexSetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, int i);

    private static native String mLaneGetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl);

    private static native void mLaneSetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, String str);

    private static native int mLayerGetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl);

    private static native void mLayerSetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, int i);

    private static native int mLayerTagGetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl);

    private static native void mLayerTagSetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, int i);

    private static native long pathIdGetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl);

    private static native void pathIdSetNative(long j, LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, long j2);

    public LaneGuideTrafficEventLayerItemImpl(long j, boolean z) {
        super(LaneGuideTrafficEventLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof LaneGuideTrafficEventLayerItemImpl) {
            return getUID(this) == getUID((LaneGuideTrafficEventLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        long cPtr = getCPtr(laneGuideTrafficEventLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        if (laneGuideTrafficEventLayerItemImpl == null) {
            return 0L;
        }
        return laneGuideTrafficEventLayerItemImpl.swigCPtr;
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
        LaneGuideTrafficEventLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        LaneGuideTrafficEventLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LaneGuideTrafficEventLayerItemImpl() {
        this(createNativeObj(), true);
        LayerLaneSvrJNI.swig_jni_init();
        LaneGuideTrafficEventLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMIndex(int i) {
        $explicit_setMIndex(i);
    }

    public void $explicit_setMIndex(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mIndexSetNative(j, this, i);
    }

    public int getMIndex() {
        return $explicit_getMIndex();
    }

    public int $explicit_getMIndex() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mIndexGetNative(j, this);
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

    public void setMLane(String str) {
        $explicit_setMLane(str);
    }

    public void $explicit_setMLane(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mLaneSetNative(j, this, str);
    }

    public String getMLane() {
        return $explicit_getMLane();
    }

    public String $explicit_getMLane() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mLaneGetNative(j, this);
    }

    public void setMLayer(int i) {
        $explicit_setMLayer(i);
    }

    public void $explicit_setMLayer(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mLayerSetNative(j, this, i);
    }

    public int getMLayer() {
        return $explicit_getMLayer();
    }

    public int $explicit_getMLayer() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mLayerGetNative(j, this);
    }

    public void setPathId(long j) {
        $explicit_setPathId(j);
    }

    public void $explicit_setPathId(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        pathIdSetNative(j2, this, j);
    }

    public long getPathId() {
        return $explicit_getPathId();
    }

    public long $explicit_getPathId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return pathIdGetNative(j, this);
    }

    public void setMId(int i) {
        $explicit_setMId(i);
    }

    public void $explicit_setMId(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mIdSetNative(j, this, i);
    }

    public int getMId() {
        return $explicit_getMId();
    }

    public int $explicit_getMId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mIdGetNative(j, this);
    }

    public void setLength(int i) {
        $explicit_setLength(i);
    }

    public void $explicit_setLength(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lengthSetNative(j, this, i);
    }

    public int getLength() {
        return $explicit_getLength();
    }

    public int $explicit_getLength() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return lengthGetNative(j, this);
    }

    public void setLaneDetail(String str) {
        $explicit_setLaneDetail(str);
    }

    public void $explicit_setLaneDetail(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        laneDetailSetNative(j, this, str);
    }

    public String getLaneDetail() {
        return $explicit_getLaneDetail();
    }

    public String $explicit_getLaneDetail() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return laneDetailGetNative(j, this);
    }
}
