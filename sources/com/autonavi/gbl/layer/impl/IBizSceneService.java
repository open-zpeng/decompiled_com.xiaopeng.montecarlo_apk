package com.autonavi.gbl.layer.impl;

import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
/* loaded from: classes.dex */
public class IBizSceneService implements IService {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native int getServiceIDNative(long j, IBizSceneService iBizSceneService);

    private static native String getVersionNative(long j, IBizSceneService iBizSceneService);

    private static native int initNative(long j, IBizSceneService iBizSceneService, String str);

    private static native int invokeSceneNative(long j, IBizSceneService iBizSceneService, long j2, BizSceneContext bizSceneContext);

    private static native int isInitNative(long j, IBizSceneService iBizSceneService);

    private static native void unInitNative(long j, IBizSceneService iBizSceneService);

    private static native int updateConfigNative(long j, IBizSceneService iBizSceneService, long j2, SceneConfigOption sceneConfigOption);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IBizSceneService(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(IBizSceneService iBizSceneService) {
        if (iBizSceneService == null) {
            return 0L;
        }
        return iBizSceneService.swigCPtr;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        return this.swigCPtr;
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

    public int init(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, str);
    }

    public int invokeScene(BizSceneContext bizSceneContext) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return invokeSceneNative(j, this, BizSceneContext.getCPtr(bizSceneContext), bizSceneContext);
    }

    public int updateConfig(SceneConfigOption sceneConfigOption) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateConfigNative(j, this, SceneConfigOption.getCPtr(sceneConfigOption), sceneConfigOption);
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
