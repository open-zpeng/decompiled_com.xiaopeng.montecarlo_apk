package com.autonavi.gbl.data.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.data.LNDSService;
import com.autonavi.gbl.data.model.LNDSInitConfig;
import com.autonavi.gbl.data.observer.impl.IErrorDataObserverImpl;
import com.autonavi.gbl.data.observer.impl.ILNDSCityDownloadObserverImpl;
import com.autonavi.gbl.data.observer.impl.ILNDSDataVersionObserverImpl;
import com.autonavi.gbl.data.observer.impl.ILNDSGlobalFileUpdateObserverImpl;
import com.autonavi.gbl.data.observer.impl.ILNDSNearCityListObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = LNDSService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILNDSServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(ILNDSServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean addCityDownloadObserverNative(long j, ILNDSServiceImpl iLNDSServiceImpl, long j2, ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl);

    private static native boolean addDataVersionObserverNative(long j, ILNDSServiceImpl iLNDSServiceImpl, long j2, ILNDSDataVersionObserverImpl iLNDSDataVersionObserverImpl);

    private static native boolean addErrorDataObserverNative(long j, ILNDSServiceImpl iLNDSServiceImpl, long j2, IErrorDataObserverImpl iErrorDataObserverImpl);

    private static native boolean addGlobalFileUpdateObserverNative(long j, ILNDSServiceImpl iLNDSServiceImpl, long j2, ILNDSGlobalFileUpdateObserverImpl iLNDSGlobalFileUpdateObserverImpl);

    private static native boolean addNearCityListObserverNative(long j, ILNDSServiceImpl iLNDSServiceImpl, long j2, ILNDSNearCityListObserverImpl iLNDSNearCityListObserverImpl);

    private static native void cancelAllDownloadListNative(long j, ILNDSServiceImpl iLNDSServiceImpl);

    private static native void cancelDownloadListNative(long j, ILNDSServiceImpl iLNDSServiceImpl, ArrayList<Integer> arrayList);

    private static native void deleteDownloadListNative(long j, ILNDSServiceImpl iLNDSServiceImpl, ArrayList<Integer> arrayList);

    private static native void destroyNativeObj(long j);

    private static native int getCityDataStatusNative(long j, ILNDSServiceImpl iLNDSServiceImpl, int i, int[] iArr);

    private static native String getVersionNative(long j, ILNDSServiceImpl iLNDSServiceImpl);

    private static native int initNative(long j, ILNDSServiceImpl iLNDSServiceImpl, long j2, LNDSInitConfig lNDSInitConfig);

    private static native int isInitNative(long j, ILNDSServiceImpl iLNDSServiceImpl);

    private static native void logSwitchNative(long j, ILNDSServiceImpl iLNDSServiceImpl, int i);

    private static native void pauseDownloadListNative(long j, ILNDSServiceImpl iLNDSServiceImpl, ArrayList<Integer> arrayList);

    private static native boolean removeCityDownloadObserverNative(long j, ILNDSServiceImpl iLNDSServiceImpl, long j2, ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl);

    private static native boolean removeDataVersionObserverNative(long j, ILNDSServiceImpl iLNDSServiceImpl, long j2, ILNDSDataVersionObserverImpl iLNDSDataVersionObserverImpl);

    private static native boolean removeErrorDataObserverNative(long j, ILNDSServiceImpl iLNDSServiceImpl, long j2, IErrorDataObserverImpl iErrorDataObserverImpl);

    private static native boolean removeGlobalFileUpdateObserverNative(long j, ILNDSServiceImpl iLNDSServiceImpl, long j2, ILNDSGlobalFileUpdateObserverImpl iLNDSGlobalFileUpdateObserverImpl);

    private static native boolean removeNearCityListObserverNative(long j, ILNDSServiceImpl iLNDSServiceImpl, long j2, ILNDSNearCityListObserverImpl iLNDSNearCityListObserverImpl);

    private static native BigInteger requestDataVersionNative(long j, ILNDSServiceImpl iLNDSServiceImpl);

    private static native BigInteger requestGlobalFileNative(long j, ILNDSServiceImpl iLNDSServiceImpl, String str);

    private static native BigInteger requestNearCitysNative(long j, ILNDSServiceImpl iLNDSServiceImpl, long j2, Coord3DDouble coord3DDouble, String str);

    private static native boolean requestTileDataVersionNative(long j, ILNDSServiceImpl iLNDSServiceImpl);

    private static native boolean requestTileGlobalFileNative(long j, ILNDSServiceImpl iLNDSServiceImpl, String str);

    private static native void startDownloadListNative(long j, ILNDSServiceImpl iLNDSServiceImpl, ArrayList<Integer> arrayList, String str);

    private static native void unInitNative(long j, ILNDSServiceImpl iLNDSServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected ILNDSServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILNDSServiceImpl) && getUID(this) == getUID((ILNDSServiceImpl) obj);
    }

    private static long getUID(ILNDSServiceImpl iLNDSServiceImpl) {
        long cPtr = getCPtr(iLNDSServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILNDSServiceImpl iLNDSServiceImpl) {
        if (iLNDSServiceImpl == null) {
            return 0L;
        }
        return iLNDSServiceImpl.swigCPtr;
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
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    @ErrorCode.ErrorCode1
    public int init(LNDSInitConfig lNDSInitConfig) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, lNDSInitConfig);
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

    public void logSwitch(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        logSwitchNative(j, this, i);
    }

    public boolean addErrorDataObserver(IErrorDataObserverImpl iErrorDataObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addErrorDataObserverNative(j, this, IErrorDataObserverImpl.getCPtr(iErrorDataObserverImpl), iErrorDataObserverImpl);
    }

    public boolean removeErrorDataObserver(IErrorDataObserverImpl iErrorDataObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeErrorDataObserverNative(j, this, IErrorDataObserverImpl.getCPtr(iErrorDataObserverImpl), iErrorDataObserverImpl);
    }

    public boolean addNearCityListObserver(ILNDSNearCityListObserverImpl iLNDSNearCityListObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addNearCityListObserverNative(j, this, ILNDSNearCityListObserverImpl.getCPtr(iLNDSNearCityListObserverImpl), iLNDSNearCityListObserverImpl);
    }

    public boolean removeNearCityListObserver(ILNDSNearCityListObserverImpl iLNDSNearCityListObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeNearCityListObserverNative(j, this, ILNDSNearCityListObserverImpl.getCPtr(iLNDSNearCityListObserverImpl), iLNDSNearCityListObserverImpl);
    }

    public boolean addDataVersionObserver(ILNDSDataVersionObserverImpl iLNDSDataVersionObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addDataVersionObserverNative(j, this, ILNDSDataVersionObserverImpl.getCPtr(iLNDSDataVersionObserverImpl), iLNDSDataVersionObserverImpl);
    }

    public boolean removeDataVersionObserver(ILNDSDataVersionObserverImpl iLNDSDataVersionObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeDataVersionObserverNative(j, this, ILNDSDataVersionObserverImpl.getCPtr(iLNDSDataVersionObserverImpl), iLNDSDataVersionObserverImpl);
    }

    public boolean addGlobalFileUpdateObserver(ILNDSGlobalFileUpdateObserverImpl iLNDSGlobalFileUpdateObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addGlobalFileUpdateObserverNative(j, this, ILNDSGlobalFileUpdateObserverImpl.getCPtr(iLNDSGlobalFileUpdateObserverImpl), iLNDSGlobalFileUpdateObserverImpl);
    }

    public boolean removeGlobalFileUpdateObserver(ILNDSGlobalFileUpdateObserverImpl iLNDSGlobalFileUpdateObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeGlobalFileUpdateObserverNative(j, this, ILNDSGlobalFileUpdateObserverImpl.getCPtr(iLNDSGlobalFileUpdateObserverImpl), iLNDSGlobalFileUpdateObserverImpl);
    }

    public boolean addCityDownloadObserver(ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addCityDownloadObserverNative(j, this, ILNDSCityDownloadObserverImpl.getCPtr(iLNDSCityDownloadObserverImpl), iLNDSCityDownloadObserverImpl);
    }

    public boolean removeCityDownloadObserver(ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeCityDownloadObserverNative(j, this, ILNDSCityDownloadObserverImpl.getCPtr(iLNDSCityDownloadObserverImpl), iLNDSCityDownloadObserverImpl);
    }

    public BigInteger requestNearCitys(Coord3DDouble coord3DDouble, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestNearCitysNative(j, this, 0L, coord3DDouble, str);
    }

    public BigInteger requestDataVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestDataVersionNative(j, this);
    }

    public BigInteger requestGlobalFile(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestGlobalFileNative(j, this, str);
    }

    @ErrorCode.ErrorCode1
    public int getCityDataStatus(int i, int[] iArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCityDataStatusNative(j, this, i, iArr);
    }

    public void startDownloadList(ArrayList<Integer> arrayList, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        startDownloadListNative(j, this, arrayList, str);
    }

    public void pauseDownloadList(ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        pauseDownloadListNative(j, this, arrayList);
    }

    public void cancelDownloadList(ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        cancelDownloadListNative(j, this, arrayList);
    }

    public void cancelAllDownloadList() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        cancelAllDownloadListNative(j, this);
    }

    public void deleteDownloadList(ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        deleteDownloadListNative(j, this, arrayList);
    }

    public boolean requestTileDataVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestTileDataVersionNative(j, this);
    }

    public boolean requestTileGlobalFile(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestTileGlobalFileNative(j, this, str);
    }
}
