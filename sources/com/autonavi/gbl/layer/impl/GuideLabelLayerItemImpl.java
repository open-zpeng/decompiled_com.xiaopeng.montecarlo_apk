package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.Formway;
import com.autonavi.gbl.layer.GuideLabelLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = GuideLabelLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class GuideLabelLayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideLabelLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long GuideLabelLayerItemImpl_SWIGUpcast(long j);

    private static native void GuideLabelLayerItemImpl_change_ownership(GuideLabelLayerItemImpl guideLabelLayerItemImpl, long j, boolean z);

    private static native void GuideLabelLayerItemImpl_director_connect(GuideLabelLayerItemImpl guideLabelLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, long j);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mAlterPathIndxGetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl);

    private static native void mAlterPathIndxSetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl, int i);

    private static native int mBoardStyleGetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl);

    private static native void mBoardStyleSetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl, int i);

    private static native int mCostDiffGetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl);

    private static native void mCostDiffSetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl, int i);

    private static native int mDistanceDiffGetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl);

    private static native void mDistanceDiffSetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl, int i);

    private static native boolean mIsFasterGetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl);

    private static native void mIsFasterSetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl, boolean z);

    private static native String mLabelContentGetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl);

    private static native void mLabelContentSetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl, String str);

    private static native int mLabelIndexGetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl);

    private static native void mLabelIndexSetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl, int i);

    private static native long mPathCostGetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl);

    private static native void mPathCostSetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl, long j2);

    private static native long mPathIdGetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl);

    private static native void mPathIdSetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl, long j2);

    private static native boolean mPreviewModeGetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl);

    private static native void mPreviewModeSetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl, boolean z);

    private static native int mRoadFormwayGetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl);

    private static native void mRoadFormwaySetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl, int i);

    private static native String mRoadNameGetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl);

    private static native void mRoadNameSetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl, String str);

    private static native int mTrafficLightDiffGetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl);

    private static native void mTrafficLightDiffSetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl, int i);

    private static native int mTravelTimeDiffGetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl);

    private static native void mTravelTimeDiffSetNative(long j, GuideLabelLayerItemImpl guideLabelLayerItemImpl, int i);

    public GuideLabelLayerItemImpl(long j, boolean z) {
        super(GuideLabelLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof GuideLabelLayerItemImpl) {
            return getUID(this) == getUID((GuideLabelLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        long cPtr = getCPtr(guideLabelLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        if (guideLabelLayerItemImpl == null) {
            return 0L;
        }
        return guideLabelLayerItemImpl.swigCPtr;
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
        GuideLabelLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GuideLabelLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public GuideLabelLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j) {
        this(createNativeObj(i, j), true);
        LayerSvrJNI.swig_jni_init();
        GuideLabelLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMLabelIndex(int i) {
        $explicit_setMLabelIndex(i);
    }

    public void $explicit_setMLabelIndex(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mLabelIndexSetNative(j, this, i);
    }

    public int getMLabelIndex() {
        return $explicit_getMLabelIndex();
    }

    public int $explicit_getMLabelIndex() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mLabelIndexGetNative(j, this);
    }

    public void setMPathCost(long j) {
        $explicit_setMPathCost(j);
    }

    public void $explicit_setMPathCost(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        mPathCostSetNative(j2, this, j);
    }

    public long getMPathCost() {
        return $explicit_getMPathCost();
    }

    public long $explicit_getMPathCost() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mPathCostGetNative(j, this);
    }

    public void setMAlterPathIndx(int i) {
        $explicit_setMAlterPathIndx(i);
    }

    public void $explicit_setMAlterPathIndx(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mAlterPathIndxSetNative(j, this, i);
    }

    public int getMAlterPathIndx() {
        return $explicit_getMAlterPathIndx();
    }

    public int $explicit_getMAlterPathIndx() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mAlterPathIndxGetNative(j, this);
    }

    public void setMPathId(long j) {
        $explicit_setMPathId(j);
    }

    public void $explicit_setMPathId(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        mPathIdSetNative(j2, this, j);
    }

    public long getMPathId() {
        return $explicit_getMPathId();
    }

    public long $explicit_getMPathId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mPathIdGetNative(j, this);
    }

    public void setMCostDiff(int i) {
        $explicit_setMCostDiff(i);
    }

    public void $explicit_setMCostDiff(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mCostDiffSetNative(j, this, i);
    }

    public int getMCostDiff() {
        return $explicit_getMCostDiff();
    }

    public int $explicit_getMCostDiff() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCostDiffGetNative(j, this);
    }

    public void setMDistanceDiff(int i) {
        $explicit_setMDistanceDiff(i);
    }

    public void $explicit_setMDistanceDiff(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mDistanceDiffSetNative(j, this, i);
    }

    public int getMDistanceDiff() {
        return $explicit_getMDistanceDiff();
    }

    public int $explicit_getMDistanceDiff() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mDistanceDiffGetNative(j, this);
    }

    public void setMTravelTimeDiff(int i) {
        $explicit_setMTravelTimeDiff(i);
    }

    public void $explicit_setMTravelTimeDiff(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTravelTimeDiffSetNative(j, this, i);
    }

    public int getMTravelTimeDiff() {
        return $explicit_getMTravelTimeDiff();
    }

    public int $explicit_getMTravelTimeDiff() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTravelTimeDiffGetNative(j, this);
    }

    public void setMTrafficLightDiff(int i) {
        $explicit_setMTrafficLightDiff(i);
    }

    public void $explicit_setMTrafficLightDiff(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTrafficLightDiffSetNative(j, this, i);
    }

    public int getMTrafficLightDiff() {
        return $explicit_getMTrafficLightDiff();
    }

    public int $explicit_getMTrafficLightDiff() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTrafficLightDiffGetNative(j, this);
    }

    public void setMBoardStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        $explicit_setMBoardStyle(i);
    }

    public void $explicit_setMBoardStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mBoardStyleSetNative(j, this, i);
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int getMBoardStyle() {
        return $explicit_getMBoardStyle();
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int $explicit_getMBoardStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mBoardStyleGetNative(j, this);
    }

    public void setMRoadName(String str) {
        $explicit_setMRoadName(str);
    }

    public void $explicit_setMRoadName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mRoadNameSetNative(j, this, str);
    }

    public String getMRoadName() {
        return $explicit_getMRoadName();
    }

    public String $explicit_getMRoadName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mRoadNameGetNative(j, this);
    }

    public void setMRoadFormway(@Formway.Formway1 int i) {
        $explicit_setMRoadFormway(i);
    }

    public void $explicit_setMRoadFormway(@Formway.Formway1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mRoadFormwaySetNative(j, this, i);
    }

    @Formway.Formway1
    public int getMRoadFormway() {
        return $explicit_getMRoadFormway();
    }

    @Formway.Formway1
    public int $explicit_getMRoadFormway() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mRoadFormwayGetNative(j, this);
    }

    public void setMPreviewMode(boolean z) {
        $explicit_setMPreviewMode(z);
    }

    public void $explicit_setMPreviewMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mPreviewModeSetNative(j, this, z);
    }

    public boolean getMPreviewMode() {
        return $explicit_getMPreviewMode();
    }

    public boolean $explicit_getMPreviewMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mPreviewModeGetNative(j, this);
    }

    public void setMIsFaster(boolean z) {
        $explicit_setMIsFaster(z);
    }

    public void $explicit_setMIsFaster(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mIsFasterSetNative(j, this, z);
    }

    public boolean getMIsFaster() {
        return $explicit_getMIsFaster();
    }

    public boolean $explicit_getMIsFaster() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mIsFasterGetNative(j, this);
    }

    public void setMLabelContent(String str) {
        $explicit_setMLabelContent(str);
    }

    public void $explicit_setMLabelContent(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mLabelContentSetNative(j, this, str);
    }

    public String getMLabelContent() {
        return $explicit_getMLabelContent();
    }

    public String $explicit_getMLabelContent() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mLabelContentGetNative(j, this);
    }
}
