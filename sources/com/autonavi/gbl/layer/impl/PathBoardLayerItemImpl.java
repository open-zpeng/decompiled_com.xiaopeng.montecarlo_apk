package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.PathBoardLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.BizRouteBoardStyle;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = PathBoardLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class PathBoardLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(PathBoardLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long PathBoardLayerItemImpl_SWIGUpcast(long j);

    private static native void PathBoardLayerItemImpl_change_ownership(PathBoardLayerItemImpl pathBoardLayerItemImpl, long j, boolean z);

    private static native void PathBoardLayerItemImpl_director_connect(PathBoardLayerItemImpl pathBoardLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(String str, int i, int i2);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native String mBoardNameGetNative(long j, PathBoardLayerItemImpl pathBoardLayerItemImpl);

    private static native void mBoardNameSetNative(long j, PathBoardLayerItemImpl pathBoardLayerItemImpl, String str);

    private static native int mDirectionStyleGetNative(long j, PathBoardLayerItemImpl pathBoardLayerItemImpl);

    private static native void mDirectionStyleSetNative(long j, PathBoardLayerItemImpl pathBoardLayerItemImpl, int i);

    private static native int mTypeGetNative(long j, PathBoardLayerItemImpl pathBoardLayerItemImpl);

    private static native void mTypeSetNative(long j, PathBoardLayerItemImpl pathBoardLayerItemImpl, int i);

    public PathBoardLayerItemImpl(long j, boolean z) {
        super(PathBoardLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof PathBoardLayerItemImpl) {
            return getUID(this) == getUID((PathBoardLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        long cPtr = getCPtr(pathBoardLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        if (pathBoardLayerItemImpl == null) {
            return 0L;
        }
        return pathBoardLayerItemImpl.swigCPtr;
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
        PathBoardLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        PathBoardLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public PathBoardLayerItemImpl(String str, @BizDirectionStyle.BizDirectionStyle1 int i, @BizRouteBoardStyle.BizRouteBoardStyle1 int i2) {
        this(createNativeObj(str, i, i2), true);
        LayerSvrJNI.swig_jni_init();
        PathBoardLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMBoardName(String str) {
        $explicit_setMBoardName(str);
    }

    public void $explicit_setMBoardName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mBoardNameSetNative(j, this, str);
    }

    public String getMBoardName() {
        return $explicit_getMBoardName();
    }

    public String $explicit_getMBoardName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mBoardNameGetNative(j, this);
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

    public void setMType(@BizRouteBoardStyle.BizRouteBoardStyle1 int i) {
        $explicit_setMType(i);
    }

    public void $explicit_setMType(@BizRouteBoardStyle.BizRouteBoardStyle1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTypeSetNative(j, this, i);
    }

    @BizRouteBoardStyle.BizRouteBoardStyle1
    public int getMType() {
        return $explicit_getMType();
    }

    @BizRouteBoardStyle.BizRouteBoardStyle1
    public int $explicit_getMType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTypeGetNative(j, this);
    }
}
