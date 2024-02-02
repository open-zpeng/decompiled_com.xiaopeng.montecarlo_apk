package com.autonavi.gbl.data.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.data.MapDataService;
import com.autonavi.gbl.data.model.AdminCode;
import com.autonavi.gbl.data.model.Area;
import com.autonavi.gbl.data.model.AreaExtraInfo;
import com.autonavi.gbl.data.model.AreaType;
import com.autonavi.gbl.data.model.CityDownLoadItem;
import com.autonavi.gbl.data.model.CityItemInfo;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.InitConfig;
import com.autonavi.gbl.data.model.MapDataAction;
import com.autonavi.gbl.data.model.MapDataFileType;
import com.autonavi.gbl.data.model.MapDataVersion;
import com.autonavi.gbl.data.model.OfflineMapDataType;
import com.autonavi.gbl.data.model.OperationType;
import com.autonavi.gbl.data.model.ProvinceInfo;
import com.autonavi.gbl.data.observer.impl.IDataDeletionObserverImpl;
import com.autonavi.gbl.data.observer.impl.IDataInitObserverImpl;
import com.autonavi.gbl.data.observer.impl.IDataListObserverImpl;
import com.autonavi.gbl.data.observer.impl.IDownloadObserverImpl;
import com.autonavi.gbl.data.observer.impl.IEHPDataObserverImpl;
import com.autonavi.gbl.data.observer.impl.IErrorDataObserverImpl;
import com.autonavi.gbl.data.observer.impl.IMergedStatusInfoObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = MapDataService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IMapDataServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IMapDataServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void abortRequestDataListCheckNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i);

    private static native void addDataDeletionObserverNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, long j2, IDataDeletionObserverImpl iDataDeletionObserverImpl);

    private static native int addNetDownloadObserverNative(long j, IMapDataServiceImpl iMapDataServiceImpl, long j2, IDownloadObserverImpl iDownloadObserverImpl);

    private static native int addUsbDownloadObserverNative(long j, IMapDataServiceImpl iMapDataServiceImpl, long j2, IDownloadObserverImpl iDownloadObserverImpl);

    private static native boolean afterOfflineUpdate1Native(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, int i2, int i3, String str);

    private static native boolean afterOfflineUpdateNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, int i2, int i3, String str, boolean z);

    private static native boolean beforeOfflineUpdateNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, int i2, int i3);

    private static native void changeDiskStatusNative(long j, IMapDataServiceImpl iMapDataServiceImpl, String str, int i);

    private static native int checkDataInDiskNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, String str);

    private static native void deleteErrorDataNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i);

    private static native void destroyNativeObj(long j);

    private static native int getAdcodeByLonLatNative(long j, IMapDataServiceImpl iMapDataServiceImpl, double d, double d2);

    private static native ArrayList<Integer> getAdcodeList1Native(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, String str);

    private static native ArrayList<Integer> getAdcodeListNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, int i2);

    private static native int getAdcodeNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i);

    private static native AreaExtraInfo getAreaExtraInfoNative(long j, IMapDataServiceImpl iMapDataServiceImpl, long j2, AdminCode adminCode);

    private static native boolean getAreaNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, int i2, long j2, Area area);

    private static native boolean getCityDownLoadItemNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, int i2, long j2, CityDownLoadItem cityDownLoadItem);

    private static native ArrayList<CityItemInfo> getCityInfoListNative(long j, IMapDataServiceImpl iMapDataServiceImpl);

    private static native CityItemInfo getCityInfoNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i);

    private static native String getDataFileVersionNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, int i2);

    private static native String getEngineVersionNative(long j, IMapDataServiceImpl iMapDataServiceImpl);

    private static native ArrayList<ProvinceInfo> getProvinceInfoListNative(long j, IMapDataServiceImpl iMapDataServiceImpl);

    private static native ProvinceInfo getProvinceInfoNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i);

    private static native int getTownAdcodeByLonLatNative(long j, IMapDataServiceImpl iMapDataServiceImpl, double d, double d2);

    private static native int getUrcodeNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i);

    private static native String getVersionNative(long j, IMapDataServiceImpl iMapDataServiceImpl);

    private static native ArrayList<Integer> getWorkingQueueAdcodeListNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i);

    private static native boolean hasZipFileNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i);

    private static native int initNative(long j, IMapDataServiceImpl iMapDataServiceImpl, long j2, InitConfig initConfig, long j3, IDataInitObserverImpl iDataInitObserverImpl);

    private static native boolean isDataUpdatedOnServerNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i);

    private static native int isInitNative(long j, IMapDataServiceImpl iMapDataServiceImpl);

    private static native boolean isLocalDragUpdateNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i);

    private static native void logSwitchNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i);

    private static native void operateNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, int i2, ArrayList<Integer> arrayList);

    private static native void operateWorkingQueueNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, int i2);

    private static native int preloadNative(long j, IMapDataServiceImpl iMapDataServiceImpl, ArrayList<Integer> arrayList, ArrayList<Boolean> arrayList2);

    private static native void removeDataDeletionObserverNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i);

    private static native int removeDownloadObserverNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, long j2, IDownloadObserverImpl iDownloadObserverImpl);

    private static native int removeNetDownloadObserverNative(long j, IMapDataServiceImpl iMapDataServiceImpl, long j2, IDownloadObserverImpl iDownloadObserverImpl);

    private static native int removeUsbDownloadObserverNative(long j, IMapDataServiceImpl iMapDataServiceImpl, long j2, IDownloadObserverImpl iDownloadObserverImpl);

    private static native int requestDataListCheckNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, String str, long j2, IDataListObserverImpl iDataListObserverImpl);

    private static native ArrayList<Integer> searchAdcodeNative(long j, IMapDataServiceImpl iMapDataServiceImpl, String str);

    private static native void setCurrentCityAdcodeNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i);

    private static native boolean setEHPDataObserverNative(long j, IMapDataServiceImpl iMapDataServiceImpl, long j2, IEHPDataObserverImpl iEHPDataObserverImpl);

    private static native void setErrorDataObserverNative(long j, IMapDataServiceImpl iMapDataServiceImpl, long j2, IErrorDataObserverImpl iErrorDataObserverImpl);

    private static native int setIMergedStatusInfoObserverNative(long j, IMapDataServiceImpl iMapDataServiceImpl, long j2, IMergedStatusInfoObserverImpl iMergedStatusInfoObserverImpl);

    private static native boolean syncDataVersionNative(long j, IMapDataServiceImpl iMapDataServiceImpl, int i, ArrayList<MapDataVersion> arrayList);

    private static native void unInitNative(long j, IMapDataServiceImpl iMapDataServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IMapDataServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMapDataServiceImpl) && getUID(this) == getUID((IMapDataServiceImpl) obj);
    }

    private static long getUID(IMapDataServiceImpl iMapDataServiceImpl) {
        long cPtr = getCPtr(iMapDataServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMapDataServiceImpl iMapDataServiceImpl) {
        if (iMapDataServiceImpl == null) {
            return 0L;
        }
        return iMapDataServiceImpl.swigCPtr;
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

    public Area getArea(@DownLoadMode.DownLoadMode1 int i, int i2) {
        Area area = new Area();
        if (getArea(i, i2, area)) {
            return area;
        }
        return null;
    }

    public CityDownLoadItem getCityDownLoadItem(@DownLoadMode.DownLoadMode1 int i, int i2) {
        CityDownLoadItem cityDownLoadItem = new CityDownLoadItem();
        if (getCityDownLoadItem(i, i2, cityDownLoadItem)) {
            return cityDownLoadItem;
        }
        return null;
    }

    public int init(InitConfig initConfig, IDataInitObserverImpl iDataInitObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, initConfig, IDataInitObserverImpl.getCPtr(iDataInitObserverImpl), iDataInitObserverImpl);
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

    public String getEngineVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getEngineVersionNative(j, this);
    }

    public String getDataFileVersion(int i, @MapDataFileType.MapDataFileType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDataFileVersionNative(j, this, i, i2);
    }

    public int getAdcodeByLonLat(double d, double d2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAdcodeByLonLatNative(j, this, d, d2);
    }

    public int getTownAdcodeByLonLat(double d, double d2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTownAdcodeByLonLatNative(j, this, d, d2);
    }

    public int getUrcode(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getUrcodeNative(j, this, i);
    }

    public int getAdcode(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAdcodeNative(j, this, i);
    }

    public void setCurrentCityAdcode(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCurrentCityAdcodeNative(j, this, i);
    }

    public boolean setEHPDataObserver(IEHPDataObserverImpl iEHPDataObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setEHPDataObserverNative(j, this, IEHPDataObserverImpl.getCPtr(iEHPDataObserverImpl), iEHPDataObserverImpl);
    }

    public void changeDiskStatus(String str, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        changeDiskStatusNative(j, this, str, i);
    }

    @ErrorCode.ErrorCode1
    public int checkDataInDisk(@DownLoadMode.DownLoadMode1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return checkDataInDiskNative(j, this, i, str);
    }

    public int requestDataListCheck(@DownLoadMode.DownLoadMode1 int i, String str, IDataListObserverImpl iDataListObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestDataListCheckNative(j, this, i, str, IDataListObserverImpl.getCPtr(iDataListObserverImpl), iDataListObserverImpl);
    }

    public void abortRequestDataListCheck(@DownLoadMode.DownLoadMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortRequestDataListCheckNative(j, this, i);
    }

    public int setIMergedStatusInfoObserver(IMergedStatusInfoObserverImpl iMergedStatusInfoObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setIMergedStatusInfoObserverNative(j, this, IMergedStatusInfoObserverImpl.getCPtr(iMergedStatusInfoObserverImpl), iMergedStatusInfoObserverImpl);
    }

    public ArrayList<CityItemInfo> getCityInfoList() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCityInfoListNative(j, this);
    }

    public ArrayList<ProvinceInfo> getProvinceInfoList() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getProvinceInfoListNative(j, this);
    }

    public CityItemInfo getCityInfo(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCityInfoNative(j, this, i);
    }

    public ProvinceInfo getProvinceInfo(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getProvinceInfoNative(j, this, i);
    }

    public ArrayList<Integer> searchAdcode(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return searchAdcodeNative(j, this, str);
    }

    public AreaExtraInfo getAreaExtraInfo(AdminCode adminCode) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAreaExtraInfoNative(j, this, 0L, adminCode);
    }

    private boolean getArea(@DownLoadMode.DownLoadMode1 int i, int i2, Area area) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAreaNative(j, this, i, i2, 0L, area);
    }

    private boolean getCityDownLoadItem(@DownLoadMode.DownLoadMode1 int i, int i2, CityDownLoadItem cityDownLoadItem) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCityDownLoadItemNative(j, this, i, i2, 0L, cityDownLoadItem);
    }

    public ArrayList<Integer> getAdcodeList(@DownLoadMode.DownLoadMode1 int i, @AreaType.AreaType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAdcodeListNative(j, this, i, i2);
    }

    public ArrayList<Integer> getAdcodeList(@DownLoadMode.DownLoadMode1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAdcodeList1Native(j, this, i, str);
    }

    public ArrayList<Integer> getWorkingQueueAdcodeList(@DownLoadMode.DownLoadMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getWorkingQueueAdcodeListNative(j, this, i);
    }

    public boolean isLocalDragUpdate(@DownLoadMode.DownLoadMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isLocalDragUpdateNative(j, this, i);
    }

    public boolean isDataUpdatedOnServer(@DownLoadMode.DownLoadMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isDataUpdatedOnServerNative(j, this, i);
    }

    public boolean hasZipFile(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return hasZipFileNative(j, this, i);
    }

    public int addNetDownloadObserver(IDownloadObserverImpl iDownloadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addNetDownloadObserverNative(j, this, IDownloadObserverImpl.getCPtr(iDownloadObserverImpl), iDownloadObserverImpl);
    }

    public int addUsbDownloadObserver(IDownloadObserverImpl iDownloadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addUsbDownloadObserverNative(j, this, IDownloadObserverImpl.getCPtr(iDownloadObserverImpl), iDownloadObserverImpl);
    }

    public int removeDownloadObserver(@DownLoadMode.DownLoadMode1 int i, IDownloadObserverImpl iDownloadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeDownloadObserverNative(j, this, i, IDownloadObserverImpl.getCPtr(iDownloadObserverImpl), iDownloadObserverImpl);
    }

    public int removeNetDownloadObserver(IDownloadObserverImpl iDownloadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeNetDownloadObserverNative(j, this, IDownloadObserverImpl.getCPtr(iDownloadObserverImpl), iDownloadObserverImpl);
    }

    public int removeUsbDownloadObserver(IDownloadObserverImpl iDownloadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeUsbDownloadObserverNative(j, this, IDownloadObserverImpl.getCPtr(iDownloadObserverImpl), iDownloadObserverImpl);
    }

    public void operate(@DownLoadMode.DownLoadMode1 int i, @OperationType.OperationType1 int i2, ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        operateNative(j, this, i, i2, arrayList);
    }

    public void operateWorkingQueue(@DownLoadMode.DownLoadMode1 int i, @OperationType.OperationType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        operateWorkingQueueNative(j, this, i, i2);
    }

    @ErrorCode.ErrorCode1
    public int preload(ArrayList<Integer> arrayList, ArrayList<Boolean> arrayList2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return preloadNative(j, this, arrayList, arrayList2);
    }

    public boolean beforeOfflineUpdate(int i, @OfflineMapDataType.OfflineMapDataType1 int i2, @MapDataAction.MapDataAction1 int i3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return beforeOfflineUpdateNative(j, this, i, i2, i3);
    }

    public boolean afterOfflineUpdate(int i, @OfflineMapDataType.OfflineMapDataType1 int i2, @MapDataAction.MapDataAction1 int i3, String str, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return afterOfflineUpdateNative(j, this, i, i2, i3, str, z);
    }

    public boolean afterOfflineUpdate(int i, @OfflineMapDataType.OfflineMapDataType1 int i2, @MapDataAction.MapDataAction1 int i3, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return afterOfflineUpdate1Native(j, this, i, i2, i3, str);
    }

    public boolean syncDataVersion(int i, ArrayList<MapDataVersion> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return syncDataVersionNative(j, this, i, arrayList);
    }

    public void setErrorDataObserver(IErrorDataObserverImpl iErrorDataObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setErrorDataObserverNative(j, this, IErrorDataObserverImpl.getCPtr(iErrorDataObserverImpl), iErrorDataObserverImpl);
    }

    public void deleteErrorData(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        deleteErrorDataNative(j, this, i);
    }

    public void addDataDeletionObserver(@DownLoadMode.DownLoadMode1 int i, IDataDeletionObserverImpl iDataDeletionObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addDataDeletionObserverNative(j, this, i, IDataDeletionObserverImpl.getCPtr(iDataDeletionObserverImpl), iDataDeletionObserverImpl);
    }

    public void removeDataDeletionObserver(@DownLoadMode.DownLoadMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeDataDeletionObserverNative(j, this, i);
    }
}
