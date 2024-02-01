package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.BizSceneService;
import com.autonavi.gbl.layer.model.SceneConfigOption;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = BizSceneService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizSceneServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IBizSceneServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native int getServiceIDNative(long j, IBizSceneServiceImpl iBizSceneServiceImpl);

    private static native String getVersionNative(long j, IBizSceneServiceImpl iBizSceneServiceImpl);

    private static native int initNative(long j, IBizSceneServiceImpl iBizSceneServiceImpl, String str);

    private static native int invokeSceneNative(long j, IBizSceneServiceImpl iBizSceneServiceImpl, long j2, BizSceneContextImpl bizSceneContextImpl);

    private static native int isInitNative(long j, IBizSceneServiceImpl iBizSceneServiceImpl);

    private static native void unInitNative(long j, IBizSceneServiceImpl iBizSceneServiceImpl);

    private static native int updateConfigNative(long j, IBizSceneServiceImpl iBizSceneServiceImpl, long j2, SceneConfigOption sceneConfigOption);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IBizSceneServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBizSceneServiceImpl) && getUID(this) == getUID((IBizSceneServiceImpl) obj);
    }

    private static long getUID(IBizSceneServiceImpl iBizSceneServiceImpl) {
        long cPtr = getCPtr(iBizSceneServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizSceneServiceImpl iBizSceneServiceImpl) {
        if (iBizSceneServiceImpl == null) {
            return 0L;
        }
        return iBizSceneServiceImpl.swigCPtr;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        return this.swigCPtr;
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

    public int init(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, str);
    }

    public int invokeScene(BizSceneContextImpl bizSceneContextImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return invokeSceneNative(j, this, BizSceneContextImpl.getCPtr(bizSceneContextImpl), bizSceneContextImpl);
    }

    public int updateConfig(SceneConfigOption sceneConfigOption) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateConfigNative(j, this, 0L, sceneConfigOption);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    public String getVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVersionNative(j, this);
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public int getServiceID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getServiceIDNative(j, this);
    }
}
