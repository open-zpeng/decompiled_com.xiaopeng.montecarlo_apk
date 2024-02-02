package com.autonavi.gbl.data;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.impl.IMapDataServiceImpl;
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
import com.autonavi.gbl.data.observer.IDataDeletionObserver;
import com.autonavi.gbl.data.observer.IDataInitObserver;
import com.autonavi.gbl.data.observer.IDataListObserver;
import com.autonavi.gbl.data.observer.IDownloadObserver;
import com.autonavi.gbl.data.observer.IEHPDataObserver;
import com.autonavi.gbl.data.observer.IErrorDataObserver;
import com.autonavi.gbl.data.observer.IMergedStatusInfoObserver;
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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IMapDataServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class MapDataService implements IService {
    private static String PACKAGE = ReflexTool.PN(MapDataService.class);
    private IMapDataServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected MapDataService(long j, boolean z) {
        this((IMapDataServiceImpl) ReflexTool.invokeDeclConstructorSafe(IMapDataServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(MapDataService.class, this, this.mControl);
        }
    }

    public MapDataService(IMapDataServiceImpl iMapDataServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iMapDataServiceImpl);
    }

    private void $constructor(IMapDataServiceImpl iMapDataServiceImpl) {
        if (iMapDataServiceImpl != null) {
            this.mControl = iMapDataServiceImpl;
            this.mTargetId = String.format("MapDataService_%s_%d", String.valueOf(IMapDataServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IMapDataServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            iMapDataServiceImpl.onCreate();
        }
    }

    public Area getArea(@DownLoadMode.DownLoadMode1 int i, int i2) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getArea(i, i2);
        }
        return null;
    }

    public CityDownLoadItem getCityDownLoadItem(@DownLoadMode.DownLoadMode1 int i, int i2) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getCityDownLoadItem(i, i2);
        }
        return null;
    }

    public int init(InitConfig initConfig, IDataInitObserver iDataInitObserver) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = MapDataService.class.getMethod("init", InitConfig.class, IDataInitObserver.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 1);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iDataInitObserver);
            if (iDataInitObserver != null) {
                TypeHelper typeHelper3 = this.mTypeHelper;
                r3 = typeHelper3 != null ? (IDataInitObserverImpl) typeHelper3.transfer(method, 1, iDataInitObserver) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.MapDataService.1
                    }));
                    return 0;
                }
            }
            IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
            if (iMapDataServiceImpl != null) {
                int init = iMapDataServiceImpl.init(initConfig, r3);
                if (init == 1 && (typeHelper = this.mTypeHelper) != null) {
                    typeHelper.unbindSet(method, 1, hashSet);
                }
                return init;
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            iMapDataServiceImpl.unInit();
        }
    }

    public String getVersion() {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getVersion();
        }
        return null;
    }

    public void logSwitch(int i) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            iMapDataServiceImpl.logSwitch(i);
        }
    }

    public String getEngineVersion() {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getEngineVersion();
        }
        return null;
    }

    public String getDataFileVersion(int i, @MapDataFileType.MapDataFileType1 int i2) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getDataFileVersion(i, i2);
        }
        return null;
    }

    public int getAdcodeByLonLat(double d, double d2) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getAdcodeByLonLat(d, d2);
        }
        return 0;
    }

    public int getTownAdcodeByLonLat(double d, double d2) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getTownAdcodeByLonLat(d, d2);
        }
        return 0;
    }

    public int getUrcode(int i) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getUrcode(i);
        }
        return 0;
    }

    public int getAdcode(int i) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getAdcode(i);
        }
        return 0;
    }

    public void setCurrentCityAdcode(int i) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            iMapDataServiceImpl.setCurrentCityAdcode(i);
        }
    }

    public boolean setEHPDataObserver(IEHPDataObserver iEHPDataObserver) {
        HashSet hashSet;
        try {
            Method method = MapDataService.class.getMethod("setEHPDataObserver", IEHPDataObserver.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                hashSet = (HashSet) typeHelper.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iEHPDataObserver);
            if (iEHPDataObserver != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r4 = typeHelper2 != null ? (IEHPDataObserverImpl) typeHelper2.transfer(method, 0, iEHPDataObserver) : null;
                if (r4 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.MapDataService.2
                    }));
                    return false;
                }
            }
            IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
            if (iMapDataServiceImpl != null) {
                boolean eHPDataObserver = iMapDataServiceImpl.setEHPDataObserver(r4);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
                return eHPDataObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void changeDiskStatus(String str, int i) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            iMapDataServiceImpl.changeDiskStatus(str, i);
        }
    }

    @ErrorCode.ErrorCode1
    public int checkDataInDisk(@DownLoadMode.DownLoadMode1 int i, String str) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.checkDataInDisk(i, str);
        }
        return Integer.MIN_VALUE;
    }

    public int requestDataListCheck(@DownLoadMode.DownLoadMode1 int i, String str, IDataListObserver iDataListObserver) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = MapDataService.class.getMethod("requestDataListCheck", Integer.TYPE, String.class, IDataListObserver.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 2);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iDataListObserver);
            if (iDataListObserver != null) {
                TypeHelper typeHelper3 = this.mTypeHelper;
                r3 = typeHelper3 != null ? (IDataListObserverImpl) typeHelper3.transfer(method, 2, iDataListObserver) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.MapDataService.3
                    }));
                    return 0;
                }
            }
            IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
            if (iMapDataServiceImpl != null) {
                int requestDataListCheck = iMapDataServiceImpl.requestDataListCheck(i, str, r3);
                if (requestDataListCheck == 1 && (typeHelper = this.mTypeHelper) != null) {
                    typeHelper.unbindSet(method, 2, hashSet);
                }
                return requestDataListCheck;
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public void abortRequestDataListCheck(@DownLoadMode.DownLoadMode1 int i) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            iMapDataServiceImpl.abortRequestDataListCheck(i);
        }
    }

    public int setIMergedStatusInfoObserver(IMergedStatusInfoObserver iMergedStatusInfoObserver) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = MapDataService.class.getMethod("setIMergedStatusInfoObserver", IMergedStatusInfoObserver.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iMergedStatusInfoObserver);
            if (iMergedStatusInfoObserver != null) {
                TypeHelper typeHelper3 = this.mTypeHelper;
                r4 = typeHelper3 != null ? (IMergedStatusInfoObserverImpl) typeHelper3.transfer(method, 0, iMergedStatusInfoObserver) : null;
                if (r4 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.MapDataService.4
                    }));
                    return 0;
                }
            }
            IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
            if (iMapDataServiceImpl != null) {
                int iMergedStatusInfoObserver2 = iMapDataServiceImpl.setIMergedStatusInfoObserver(r4);
                if (iMergedStatusInfoObserver2 == 1 && (typeHelper = this.mTypeHelper) != null) {
                    typeHelper.unbindSet(method, 0, hashSet);
                }
                return iMergedStatusInfoObserver2;
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public ArrayList<CityItemInfo> getCityInfoList() {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getCityInfoList();
        }
        return null;
    }

    public ArrayList<ProvinceInfo> getProvinceInfoList() {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getProvinceInfoList();
        }
        return null;
    }

    public CityItemInfo getCityInfo(int i) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getCityInfo(i);
        }
        return null;
    }

    public ProvinceInfo getProvinceInfo(int i) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getProvinceInfo(i);
        }
        return null;
    }

    public ArrayList<Integer> searchAdcode(String str) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.searchAdcode(str);
        }
        return null;
    }

    public AreaExtraInfo getAreaExtraInfo(AdminCode adminCode) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getAreaExtraInfo(adminCode);
        }
        return null;
    }

    public ArrayList<Integer> getAdcodeList(@DownLoadMode.DownLoadMode1 int i, @AreaType.AreaType1 int i2) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getAdcodeList(i, i2);
        }
        return null;
    }

    public ArrayList<Integer> getAdcodeList(@DownLoadMode.DownLoadMode1 int i, String str) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getAdcodeList(i, str);
        }
        return null;
    }

    public ArrayList<Integer> getWorkingQueueAdcodeList(@DownLoadMode.DownLoadMode1 int i) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.getWorkingQueueAdcodeList(i);
        }
        return null;
    }

    public boolean isLocalDragUpdate(@DownLoadMode.DownLoadMode1 int i) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.isLocalDragUpdate(i);
        }
        return false;
    }

    public boolean isDataUpdatedOnServer(@DownLoadMode.DownLoadMode1 int i) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.isDataUpdatedOnServer(i);
        }
        return false;
    }

    public boolean hasZipFile(int i) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.hasZipFile(i);
        }
        return false;
    }

    public int addNetDownloadObserver(IDownloadObserver iDownloadObserver) {
        try {
            Method method = MapDataService.class.getMethod("addNetDownloadObserver", IDownloadObserver.class);
            if (iDownloadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IDownloadObserverImpl) typeHelper.transfer(method, 0, iDownloadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.MapDataService.5
                    }));
                    return 0;
                }
            }
            IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
            if (iMapDataServiceImpl != null) {
                return iMapDataServiceImpl.addNetDownloadObserver(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int addUsbDownloadObserver(IDownloadObserver iDownloadObserver) {
        try {
            Method method = MapDataService.class.getMethod("addUsbDownloadObserver", IDownloadObserver.class);
            if (iDownloadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IDownloadObserverImpl) typeHelper.transfer(method, 0, iDownloadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.MapDataService.6
                    }));
                    return 0;
                }
            }
            IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
            if (iMapDataServiceImpl != null) {
                return iMapDataServiceImpl.addUsbDownloadObserver(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int removeDownloadObserver(@DownLoadMode.DownLoadMode1 int i, IDownloadObserver iDownloadObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MapDataService.class.getMethod("removeDownloadObserver", Integer.TYPE, IDownloadObserver.class);
            if (iDownloadObserver != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r2 = typeHelper2 != null ? (IDownloadObserverImpl) typeHelper2.transfer(method, 1, iDownloadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.MapDataService.7
                    }));
                    return 0;
                }
            }
            IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
            if (iMapDataServiceImpl != null) {
                int removeDownloadObserver = iMapDataServiceImpl.removeDownloadObserver(i, r2);
                if (removeDownloadObserver == 1 && (typeHelper = this.mTypeHelper) != null) {
                    typeHelper.unbind(method, 1, iDownloadObserver);
                }
                return removeDownloadObserver;
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int removeNetDownloadObserver(IDownloadObserver iDownloadObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MapDataService.class.getMethod("removeNetDownloadObserver", IDownloadObserver.class);
            if (iDownloadObserver != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r2 = typeHelper2 != null ? (IDownloadObserverImpl) typeHelper2.transfer(method, 0, iDownloadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.MapDataService.8
                    }));
                    return 0;
                }
            }
            IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
            if (iMapDataServiceImpl != null) {
                int removeNetDownloadObserver = iMapDataServiceImpl.removeNetDownloadObserver(r2);
                if (removeNetDownloadObserver == 1 && (typeHelper = this.mTypeHelper) != null) {
                    typeHelper.unbind(method, 0, iDownloadObserver);
                }
                return removeNetDownloadObserver;
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int removeUsbDownloadObserver(IDownloadObserver iDownloadObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MapDataService.class.getMethod("removeUsbDownloadObserver", IDownloadObserver.class);
            if (iDownloadObserver != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r2 = typeHelper2 != null ? (IDownloadObserverImpl) typeHelper2.transfer(method, 0, iDownloadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.MapDataService.9
                    }));
                    return 0;
                }
            }
            IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
            if (iMapDataServiceImpl != null) {
                int removeUsbDownloadObserver = iMapDataServiceImpl.removeUsbDownloadObserver(r2);
                if (removeUsbDownloadObserver == 1 && (typeHelper = this.mTypeHelper) != null) {
                    typeHelper.unbind(method, 0, iDownloadObserver);
                }
                return removeUsbDownloadObserver;
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public void operate(@DownLoadMode.DownLoadMode1 int i, @OperationType.OperationType1 int i2, ArrayList<Integer> arrayList) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            iMapDataServiceImpl.operate(i, i2, arrayList);
        }
    }

    public void operateWorkingQueue(@DownLoadMode.DownLoadMode1 int i, @OperationType.OperationType1 int i2) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            iMapDataServiceImpl.operateWorkingQueue(i, i2);
        }
    }

    @ErrorCode.ErrorCode1
    public int preload(ArrayList<Integer> arrayList, ArrayList<Boolean> arrayList2) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.preload(arrayList, arrayList2);
        }
        return Integer.MIN_VALUE;
    }

    public boolean beforeOfflineUpdate(int i, @OfflineMapDataType.OfflineMapDataType1 int i2, @MapDataAction.MapDataAction1 int i3) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.beforeOfflineUpdate(i, i2, i3);
        }
        return false;
    }

    public boolean afterOfflineUpdate(int i, @OfflineMapDataType.OfflineMapDataType1 int i2, @MapDataAction.MapDataAction1 int i3, String str, boolean z) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.afterOfflineUpdate(i, i2, i3, str, z);
        }
        return false;
    }

    public boolean afterOfflineUpdate(int i, @OfflineMapDataType.OfflineMapDataType1 int i2, @MapDataAction.MapDataAction1 int i3, String str) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.afterOfflineUpdate(i, i2, i3, str);
        }
        return false;
    }

    public boolean syncDataVersion(int i, ArrayList<MapDataVersion> arrayList) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            return iMapDataServiceImpl.syncDataVersion(i, arrayList);
        }
        return false;
    }

    public void setErrorDataObserver(IErrorDataObserver iErrorDataObserver) {
        HashSet hashSet;
        try {
            Method method = MapDataService.class.getMethod("setErrorDataObserver", IErrorDataObserver.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                hashSet = (HashSet) typeHelper.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iErrorDataObserver);
            if (iErrorDataObserver != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r3 = typeHelper2 != null ? (IErrorDataObserverImpl) typeHelper2.transfer(method, 0, iErrorDataObserver) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.MapDataService.10
                    }));
                }
            }
            IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
            if (iMapDataServiceImpl != null) {
                iMapDataServiceImpl.setErrorDataObserver(r3);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void deleteErrorData(int i) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            iMapDataServiceImpl.deleteErrorData(i);
        }
    }

    public void addDataDeletionObserver(@DownLoadMode.DownLoadMode1 int i, IDataDeletionObserver iDataDeletionObserver) {
        try {
            Method method = MapDataService.class.getMethod("addDataDeletionObserver", Integer.TYPE, IDataDeletionObserver.class);
            if (iDataDeletionObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IDataDeletionObserverImpl) typeHelper.transfer(method, 1, iDataDeletionObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.MapDataService.11
                    }));
                }
            }
            IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
            if (iMapDataServiceImpl != null) {
                iMapDataServiceImpl.addDataDeletionObserver(i, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeDataDeletionObserver(@DownLoadMode.DownLoadMode1 int i) {
        IMapDataServiceImpl iMapDataServiceImpl = this.mControl;
        if (iMapDataServiceImpl != null) {
            iMapDataServiceImpl.removeDataDeletionObserver(i);
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.MapDataService.12
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.MapDataService.13
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.data.observer.IDownloadObserver")).iterator();
            while (it.hasNext()) {
                removeNetDownloadObserver((IDownloadObserver) it.next());
            }
        }
        TypeHelper typeHelper2 = this.mTypeHelper;
        if (typeHelper2 != null) {
            Iterator it2 = ((HashSet) typeHelper2.getBindSet("com.autonavi.gbl.data.observer.IDownloadObserver")).iterator();
            while (it2.hasNext()) {
                removeUsbDownloadObserver((IDownloadObserver) it2.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.MapDataService.14
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
