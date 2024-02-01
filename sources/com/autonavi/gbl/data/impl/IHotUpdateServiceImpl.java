package com.autonavi.gbl.data.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.HotUpdateService;
import com.autonavi.gbl.data.model.HotUpdateCheckParam;
import com.autonavi.gbl.data.model.HotUpdateFileType;
import com.autonavi.gbl.data.model.MapNum;
import com.autonavi.gbl.data.model.impl.DetailListParserImpl;
import com.autonavi.gbl.data.observer.impl.IHotUpdateCheckObserverImpl;
import com.autonavi.gbl.data.observer.impl.IHotUpdateFileObserverImpl;
import com.autonavi.gbl.data.observer.impl.IMapNumObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = HotUpdateService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IHotUpdateServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IHotUpdateServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void abortRequestHotUpdateNative(long j, IHotUpdateServiceImpl iHotUpdateServiceImpl, int i);

    private static native void abortRequestMapNumNative(long j, IHotUpdateServiceImpl iHotUpdateServiceImpl);

    private static native void destroyNativeObj(long j);

    private static native String getVersionNative(long j, IHotUpdateServiceImpl iHotUpdateServiceImpl);

    private static native long initDataFillNative(long j, IHotUpdateServiceImpl iHotUpdateServiceImpl, String str);

    private static native int initNative(long j, IHotUpdateServiceImpl iHotUpdateServiceImpl);

    private static native int isInitNative(long j, IHotUpdateServiceImpl iHotUpdateServiceImpl);

    private static native void logSwitchNative(long j, IHotUpdateServiceImpl iHotUpdateServiceImpl, int i);

    private static native int requestCheckHotUpdateNative(long j, IHotUpdateServiceImpl iHotUpdateServiceImpl, long j2, HotUpdateCheckParam hotUpdateCheckParam, long j3, IHotUpdateCheckObserverImpl iHotUpdateCheckObserverImpl);

    private static native int requestHotUpdateFileNative(long j, IHotUpdateServiceImpl iHotUpdateServiceImpl, int i, String str, long j2, IHotUpdateFileObserverImpl iHotUpdateFileObserverImpl);

    private static native int requestMapNumNative(long j, IHotUpdateServiceImpl iHotUpdateServiceImpl, long j2, MapNum mapNum, long j3, IMapNumObserverImpl iMapNumObserverImpl);

    private static native int resetFileVersionNative(long j, IHotUpdateServiceImpl iHotUpdateServiceImpl, int i);

    private static native int saveHotUpdateFileNative(long j, IHotUpdateServiceImpl iHotUpdateServiceImpl, int i, String str);

    private static native void unInitNative(long j, IHotUpdateServiceImpl iHotUpdateServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IHotUpdateServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IHotUpdateServiceImpl) && getUID(this) == getUID((IHotUpdateServiceImpl) obj);
    }

    private static long getUID(IHotUpdateServiceImpl iHotUpdateServiceImpl) {
        long cPtr = getCPtr(iHotUpdateServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IHotUpdateServiceImpl iHotUpdateServiceImpl) {
        if (iHotUpdateServiceImpl == null) {
            return 0L;
        }
        return iHotUpdateServiceImpl.swigCPtr;
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

    public int init() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this);
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

    public void logSwitch(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        logSwitchNative(j, this, i);
    }

    public DetailListParserImpl initDataFill(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long initDataFillNative = initDataFillNative(j, this, str);
        if (initDataFillNative == 0) {
            return null;
        }
        return new DetailListParserImpl(initDataFillNative, false);
    }

    public void abortRequestMapNum() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortRequestMapNumNative(j, this);
    }

    public int requestMapNum(MapNum mapNum, IMapNumObserverImpl iMapNumObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestMapNumNative(j, this, 0L, mapNum, IMapNumObserverImpl.getCPtr(iMapNumObserverImpl), iMapNumObserverImpl);
    }

    public void abortRequestHotUpdate(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortRequestHotUpdateNative(j, this, i);
    }

    public int requestCheckHotUpdate(HotUpdateCheckParam hotUpdateCheckParam, IHotUpdateCheckObserverImpl iHotUpdateCheckObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestCheckHotUpdateNative(j, this, 0L, hotUpdateCheckParam, IHotUpdateCheckObserverImpl.getCPtr(iHotUpdateCheckObserverImpl), iHotUpdateCheckObserverImpl);
    }

    public int requestHotUpdateFile(@HotUpdateFileType.HotUpdateFileType1 int i, String str, IHotUpdateFileObserverImpl iHotUpdateFileObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestHotUpdateFileNative(j, this, i, str, IHotUpdateFileObserverImpl.getCPtr(iHotUpdateFileObserverImpl), iHotUpdateFileObserverImpl);
    }

    public int saveHotUpdateFile(@HotUpdateFileType.HotUpdateFileType1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return saveHotUpdateFileNative(j, this, i, str);
    }

    public int resetFileVersion(@HotUpdateFileType.HotUpdateFileType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return resetFileVersionNative(j, this, i);
    }
}
