package com.autonavi.gbl.scene.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.scene.SceneModuleService;
import com.autonavi.gbl.scene.model.InitSceneModuleParam;
import com.autonavi.gbl.scene.model.SceneModuleID;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = SceneModuleService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ISceneModuleServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(ISceneModuleServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native int getModuleByTypeNative(long j, ISceneModuleServiceImpl iSceneModuleServiceImpl, int i, ArrayList<IBaseSceneModuleImpl> arrayList);

    private static native String getVersionNative(long j, ISceneModuleServiceImpl iSceneModuleServiceImpl);

    private static native int initNative(long j, ISceneModuleServiceImpl iSceneModuleServiceImpl, long j2, InitSceneModuleParam initSceneModuleParam);

    private static native int isInitNative(long j, ISceneModuleServiceImpl iSceneModuleServiceImpl);

    private static native void unInitNative(long j, ISceneModuleServiceImpl iSceneModuleServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected ISceneModuleServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ISceneModuleServiceImpl) && getUID(this) == getUID((ISceneModuleServiceImpl) obj);
    }

    private static long getUID(ISceneModuleServiceImpl iSceneModuleServiceImpl) {
        long cPtr = getCPtr(iSceneModuleServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ISceneModuleServiceImpl iSceneModuleServiceImpl) {
        if (iSceneModuleServiceImpl == null) {
            return 0L;
        }
        return iSceneModuleServiceImpl.swigCPtr;
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

    public int init(InitSceneModuleParam initSceneModuleParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, initSceneModuleParam);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
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

    public String getVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVersionNative(j, this);
    }

    public IBaseSceneModuleImpl getModuleByType(@SceneModuleID.SceneModuleID1 int i) {
        ArrayList<IBaseSceneModuleImpl> arrayList = new ArrayList<>();
        Integer.valueOf(getModuleByType(i, arrayList));
        if (arrayList.size() > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    private int getModuleByType(@SceneModuleID.SceneModuleID1 int i, ArrayList<IBaseSceneModuleImpl> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getModuleByTypeNative(j, this, i, arrayList);
    }
}
