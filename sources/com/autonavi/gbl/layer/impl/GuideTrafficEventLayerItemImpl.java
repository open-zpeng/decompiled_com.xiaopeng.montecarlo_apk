package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.GuideTrafficEventLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = GuideTrafficEventLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class GuideTrafficEventLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideTrafficEventLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long GuideTrafficEventLayerItemImpl_SWIGUpcast(long j);

    private static native void GuideTrafficEventLayerItemImpl_change_ownership(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, long j, boolean z);

    private static native void GuideTrafficEventLayerItemImpl_director_connect(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mDirectionStyleGetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl);

    private static native void mDirectionStyleSetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, int i);

    private static native int mIdGetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl);

    private static native void mIdSetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, int i);

    private static native int mIndexGetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl);

    private static native void mIndexSetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, int i);

    private static native boolean mIsPreviewGetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl);

    private static native void mIsPreviewSetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, boolean z);

    private static native String mLaneGetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl);

    private static native void mLaneSetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, String str);

    private static native int mLayerGetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl);

    private static native void mLayerSetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, int i);

    private static native int mLayerTagGetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl);

    private static native void mLayerTagSetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, int i);

    private static native long pathIdGetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl);

    private static native void pathIdSetNative(long j, GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, long j2);

    public GuideTrafficEventLayerItemImpl(long j, boolean z) {
        super(GuideTrafficEventLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof GuideTrafficEventLayerItemImpl) {
            return getUID(this) == getUID((GuideTrafficEventLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        long cPtr = getCPtr(guideTrafficEventLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        if (guideTrafficEventLayerItemImpl == null) {
            return 0L;
        }
        return guideTrafficEventLayerItemImpl.swigCPtr;
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
        GuideTrafficEventLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GuideTrafficEventLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public GuideTrafficEventLayerItemImpl() {
        this(createNativeObj(), true);
        LayerSvrJNI.swig_jni_init();
        GuideTrafficEventLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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

    public void setMIsPreview(boolean z) {
        $explicit_setMIsPreview(z);
    }

    public void $explicit_setMIsPreview(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mIsPreviewSetNative(j, this, z);
    }

    public boolean getMIsPreview() {
        return $explicit_getMIsPreview();
    }

    public boolean $explicit_getMIsPreview() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mIsPreviewGetNative(j, this);
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
}
