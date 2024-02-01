package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.BizSceneContext;
import com.autonavi.gbl.layer.model.SceneOperateType;
import com.autonavi.gbl.map.model.MapEngineID;
@IntfAuto(target = BizSceneContext.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class BizSceneContextImpl {
    private static BindTable BIND_TABLE = new BindTable(BizSceneContextImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj(String str, int i);

    private static native void destroyNativeObj(long j);

    private static native int getMapEngineIdNative(long j, BizSceneContextImpl bizSceneContextImpl);

    private static native int getOperateTypeNative(long j, BizSceneContextImpl bizSceneContextImpl);

    private static native String getSceneNameNative(long j, BizSceneContextImpl bizSceneContextImpl);

    private static native void setMapEngineIdNative(long j, BizSceneContextImpl bizSceneContextImpl, int i);

    public BizSceneContextImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof BizSceneContextImpl) && getUID(this) == getUID((BizSceneContextImpl) obj);
    }

    private static long getUID(BizSceneContextImpl bizSceneContextImpl) {
        long cPtr = getCPtr(bizSceneContextImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(BizSceneContextImpl bizSceneContextImpl) {
        if (bizSceneContextImpl == null) {
            return 0L;
        }
        return bizSceneContextImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public BizSceneContextImpl(String str, @SceneOperateType.SceneOperateType1 int i) {
        this(createNativeObj(str, i), true);
    }

    public String getSceneName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSceneNameNative(j, this);
    }

    @SceneOperateType.SceneOperateType1
    public int getOperateType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getOperateTypeNative(j, this);
    }

    public void setMapEngineId(@MapEngineID.MapEngineID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapEngineIdNative(j, this, i);
    }

    @MapEngineID.MapEngineID1
    public int getMapEngineId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapEngineIdNative(j, this);
    }
}
