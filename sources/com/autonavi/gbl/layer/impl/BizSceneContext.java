package com.autonavi.gbl.layer.impl;

import com.autonavi.gbl.layer.model.SceneOperateType;
import com.autonavi.gbl.map.model.MapEngineID;
/* loaded from: classes.dex */
public class BizSceneContext {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj(String str, int i);

    private static native void destroyNativeObj(long j);

    private static native int getMapEngineIdNative(long j, BizSceneContext bizSceneContext);

    private static native int getOperateTypeNative(long j, BizSceneContext bizSceneContext);

    private static native String getSceneNameNative(long j, BizSceneContext bizSceneContext);

    private static native void setMapEngineIdNative(long j, BizSceneContext bizSceneContext, int i);

    public BizSceneContext(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(BizSceneContext bizSceneContext) {
        if (bizSceneContext == null) {
            return 0L;
        }
        return bizSceneContext.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public BizSceneContext(String str, @SceneOperateType.SceneOperateType1 int i) {
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
