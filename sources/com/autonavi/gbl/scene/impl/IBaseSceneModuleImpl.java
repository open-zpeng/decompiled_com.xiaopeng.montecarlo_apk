package com.autonavi.gbl.scene.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.scene.BaseSceneModule;
import com.autonavi.gbl.scene.model.ModuleInitStatus;
import com.autonavi.gbl.scene.model.SceneModuleID;
@IntfAuto(target = BaseSceneModule.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBaseSceneModuleImpl {
    private static BindTable BIND_TABLE = new BindTable(IBaseSceneModuleImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native int getModuleIDNative(long j, IBaseSceneModuleImpl iBaseSceneModuleImpl);

    private static native int isInitNative(long j, IBaseSceneModuleImpl iBaseSceneModuleImpl);

    private static native void openNative(long j, IBaseSceneModuleImpl iBaseSceneModuleImpl, boolean z);

    private static native void unInitNative(long j, IBaseSceneModuleImpl iBaseSceneModuleImpl);

    public IBaseSceneModuleImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBaseSceneModuleImpl) && getUID(this) == getUID((IBaseSceneModuleImpl) obj);
    }

    private static long getUID(IBaseSceneModuleImpl iBaseSceneModuleImpl) {
        long cPtr = getCPtr(iBaseSceneModuleImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBaseSceneModuleImpl iBaseSceneModuleImpl) {
        if (iBaseSceneModuleImpl == null) {
            return 0L;
        }
        return iBaseSceneModuleImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    @ModuleInitStatus.ModuleInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public void open(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        openNative(j, this, z);
    }

    @SceneModuleID.SceneModuleID1
    public int getModuleID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getModuleIDNative(j, this);
    }
}
