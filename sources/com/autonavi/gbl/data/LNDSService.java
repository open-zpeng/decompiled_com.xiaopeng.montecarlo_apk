package com.autonavi.gbl.data;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.data.impl.ILNDSServiceImpl;
import com.autonavi.gbl.data.model.LNDSCityData;
import com.autonavi.gbl.data.model.LNDSInitConfig;
import com.autonavi.gbl.data.model.LndsSourceDataType;
import com.autonavi.gbl.data.model.TaskStatusCode;
import com.autonavi.gbl.data.observer.IErrorDataObserver;
import com.autonavi.gbl.data.observer.ILNDSCityDownloadObserver;
import com.autonavi.gbl.data.observer.ILNDSDataVersionObserver;
import com.autonavi.gbl.data.observer.ILNDSGlobalFileUpdateObserver;
import com.autonavi.gbl.data.observer.ILNDSNearCityListObserver;
import com.autonavi.gbl.data.observer.ILndsDataDeleteObserver;
import com.autonavi.gbl.data.observer.impl.IErrorDataObserverImpl;
import com.autonavi.gbl.data.observer.impl.ILNDSCityDownloadObserverImpl;
import com.autonavi.gbl.data.observer.impl.ILNDSDataVersionObserverImpl;
import com.autonavi.gbl.data.observer.impl.ILNDSGlobalFileUpdateObserverImpl;
import com.autonavi.gbl.data.observer.impl.ILNDSNearCityListObserverImpl;
import com.autonavi.gbl.data.observer.impl.ILndsDataDeleteObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = ILNDSServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class LNDSService implements IService {
    private static String PACKAGE = ReflexTool.PN(LNDSService.class);
    private ILNDSServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LNDSService(long j, boolean z) {
        this((ILNDSServiceImpl) ReflexTool.invokeDeclConstructorSafe(ILNDSServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LNDSService.class, this, this.mControl);
        }
    }

    public LNDSService(ILNDSServiceImpl iLNDSServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iLNDSServiceImpl);
    }

    private void $constructor(ILNDSServiceImpl iLNDSServiceImpl) {
        if (iLNDSServiceImpl != null) {
            this.mControl = iLNDSServiceImpl;
            this.mTargetId = String.format("LNDSService_%s_%d", String.valueOf(ILNDSServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ILNDSServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            return iLNDSServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            return iLNDSServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            iLNDSServiceImpl.onCreate();
        }
    }

    @TaskStatusCode.TaskStatusCode1
    public int getCityDataStatus(int i, @LndsSourceDataType.LndsSourceDataType1 int i2) {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            return iLNDSServiceImpl.getCityDataStatus(i, i2);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int init(LNDSInitConfig lNDSInitConfig) {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            return iLNDSServiceImpl.init(lNDSInitConfig);
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            return iLNDSServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            iLNDSServiceImpl.unInit();
        }
    }

    public String getVersion() {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            return iLNDSServiceImpl.getVersion();
        }
        return null;
    }

    public void logSwitch(int i) {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            iLNDSServiceImpl.logSwitch(i);
        }
    }

    public boolean addErrorDataObserver(IErrorDataObserver iErrorDataObserver) {
        try {
            Method method = LNDSService.class.getMethod("addErrorDataObserver", IErrorDataObserver.class);
            if (iErrorDataObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IErrorDataObserverImpl) typeHelper.transfer(method, 0, iErrorDataObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.1
                    }));
                    return false;
                }
            }
            ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
            if (iLNDSServiceImpl != null) {
                return iLNDSServiceImpl.addErrorDataObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeErrorDataObserver(IErrorDataObserver iErrorDataObserver) {
        try {
            Method method = LNDSService.class.getMethod("removeErrorDataObserver", IErrorDataObserver.class);
            if (iErrorDataObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IErrorDataObserverImpl) typeHelper.transfer(method, 0, iErrorDataObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.2
                    }));
                    return false;
                }
            }
            ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
            if (iLNDSServiceImpl != null) {
                boolean removeErrorDataObserver = iLNDSServiceImpl.removeErrorDataObserver(r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iErrorDataObserver);
                }
                return removeErrorDataObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean addNearCityListObserver(ILNDSNearCityListObserver iLNDSNearCityListObserver) {
        try {
            Method method = LNDSService.class.getMethod("addNearCityListObserver", ILNDSNearCityListObserver.class);
            if (iLNDSNearCityListObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILNDSNearCityListObserverImpl) typeHelper.transfer(method, 0, iLNDSNearCityListObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.3
                    }));
                    return false;
                }
            }
            ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
            if (iLNDSServiceImpl != null) {
                return iLNDSServiceImpl.addNearCityListObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeNearCityListObserver(ILNDSNearCityListObserver iLNDSNearCityListObserver) {
        try {
            Method method = LNDSService.class.getMethod("removeNearCityListObserver", ILNDSNearCityListObserver.class);
            if (iLNDSNearCityListObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILNDSNearCityListObserverImpl) typeHelper.transfer(method, 0, iLNDSNearCityListObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.4
                    }));
                    return false;
                }
            }
            ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
            if (iLNDSServiceImpl != null) {
                boolean removeNearCityListObserver = iLNDSServiceImpl.removeNearCityListObserver(r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLNDSNearCityListObserver);
                }
                return removeNearCityListObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean addDataVersionObserver(ILNDSDataVersionObserver iLNDSDataVersionObserver) {
        try {
            Method method = LNDSService.class.getMethod("addDataVersionObserver", ILNDSDataVersionObserver.class);
            if (iLNDSDataVersionObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILNDSDataVersionObserverImpl) typeHelper.transfer(method, 0, iLNDSDataVersionObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.5
                    }));
                    return false;
                }
            }
            ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
            if (iLNDSServiceImpl != null) {
                return iLNDSServiceImpl.addDataVersionObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeDataVersionObserver(ILNDSDataVersionObserver iLNDSDataVersionObserver) {
        try {
            Method method = LNDSService.class.getMethod("removeDataVersionObserver", ILNDSDataVersionObserver.class);
            if (iLNDSDataVersionObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILNDSDataVersionObserverImpl) typeHelper.transfer(method, 0, iLNDSDataVersionObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.6
                    }));
                    return false;
                }
            }
            ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
            if (iLNDSServiceImpl != null) {
                boolean removeDataVersionObserver = iLNDSServiceImpl.removeDataVersionObserver(r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLNDSDataVersionObserver);
                }
                return removeDataVersionObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean addGlobalFileUpdateObserver(ILNDSGlobalFileUpdateObserver iLNDSGlobalFileUpdateObserver) {
        try {
            Method method = LNDSService.class.getMethod("addGlobalFileUpdateObserver", ILNDSGlobalFileUpdateObserver.class);
            if (iLNDSGlobalFileUpdateObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILNDSGlobalFileUpdateObserverImpl) typeHelper.transfer(method, 0, iLNDSGlobalFileUpdateObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.7
                    }));
                    return false;
                }
            }
            ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
            if (iLNDSServiceImpl != null) {
                return iLNDSServiceImpl.addGlobalFileUpdateObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeGlobalFileUpdateObserver(ILNDSGlobalFileUpdateObserver iLNDSGlobalFileUpdateObserver) {
        try {
            Method method = LNDSService.class.getMethod("removeGlobalFileUpdateObserver", ILNDSGlobalFileUpdateObserver.class);
            if (iLNDSGlobalFileUpdateObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILNDSGlobalFileUpdateObserverImpl) typeHelper.transfer(method, 0, iLNDSGlobalFileUpdateObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.8
                    }));
                    return false;
                }
            }
            ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
            if (iLNDSServiceImpl != null) {
                boolean removeGlobalFileUpdateObserver = iLNDSServiceImpl.removeGlobalFileUpdateObserver(r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLNDSGlobalFileUpdateObserver);
                }
                return removeGlobalFileUpdateObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean addCityDownloadObserver(ILNDSCityDownloadObserver iLNDSCityDownloadObserver) {
        try {
            Method method = LNDSService.class.getMethod("addCityDownloadObserver", ILNDSCityDownloadObserver.class);
            if (iLNDSCityDownloadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILNDSCityDownloadObserverImpl) typeHelper.transfer(method, 0, iLNDSCityDownloadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.9
                    }));
                    return false;
                }
            }
            ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
            if (iLNDSServiceImpl != null) {
                return iLNDSServiceImpl.addCityDownloadObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeCityDownloadObserver(ILNDSCityDownloadObserver iLNDSCityDownloadObserver) {
        try {
            Method method = LNDSService.class.getMethod("removeCityDownloadObserver", ILNDSCityDownloadObserver.class);
            if (iLNDSCityDownloadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILNDSCityDownloadObserverImpl) typeHelper.transfer(method, 0, iLNDSCityDownloadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.10
                    }));
                    return false;
                }
            }
            ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
            if (iLNDSServiceImpl != null) {
                boolean removeCityDownloadObserver = iLNDSServiceImpl.removeCityDownloadObserver(r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLNDSCityDownloadObserver);
                }
                return removeCityDownloadObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean addDeleteObserver(ILndsDataDeleteObserver iLndsDataDeleteObserver) {
        try {
            Method method = LNDSService.class.getMethod("addDeleteObserver", ILndsDataDeleteObserver.class);
            if (iLndsDataDeleteObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILndsDataDeleteObserverImpl) typeHelper.transfer(method, 0, iLndsDataDeleteObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.11
                    }));
                    return false;
                }
            }
            ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
            if (iLNDSServiceImpl != null) {
                return iLNDSServiceImpl.addDeleteObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeDeleteObserver(ILndsDataDeleteObserver iLndsDataDeleteObserver) {
        try {
            Method method = LNDSService.class.getMethod("removeDeleteObserver", ILndsDataDeleteObserver.class);
            if (iLndsDataDeleteObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILndsDataDeleteObserverImpl) typeHelper.transfer(method, 0, iLndsDataDeleteObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.12
                    }));
                    return false;
                }
            }
            ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
            if (iLNDSServiceImpl != null) {
                boolean removeDeleteObserver = iLNDSServiceImpl.removeDeleteObserver(r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLndsDataDeleteObserver);
                }
                return removeDeleteObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public BigInteger requestNearCitys(Coord3DDouble coord3DDouble, String str, String str2) {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            return iLNDSServiceImpl.requestNearCitys(coord3DDouble, str, str2);
        }
        return null;
    }

    public BigInteger requestDataVersion(String str) {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            return iLNDSServiceImpl.requestDataVersion(str);
        }
        return null;
    }

    public BigInteger requestGlobalFile(String str, String str2, @LndsSourceDataType.LndsSourceDataType1 int i) {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            return iLNDSServiceImpl.requestGlobalFile(str, str2, i);
        }
        return null;
    }

    @ErrorCode.ErrorCode1
    public int getCompleteCityList(ArrayList<LNDSCityData> arrayList, @LndsSourceDataType.LndsSourceDataType1 int i) {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            return iLNDSServiceImpl.getCompleteCityList(arrayList, i);
        }
        return Integer.MIN_VALUE;
    }

    public void startDownloadList(ArrayList<Integer> arrayList, String str, String str2, @LndsSourceDataType.LndsSourceDataType1 int i) {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            iLNDSServiceImpl.startDownloadList(arrayList, str, str2, i);
        }
    }

    public void pauseDownloadList(ArrayList<Integer> arrayList, @LndsSourceDataType.LndsSourceDataType1 int i) {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            iLNDSServiceImpl.pauseDownloadList(arrayList, i);
        }
    }

    public void cancelDownloadList(ArrayList<Integer> arrayList, @LndsSourceDataType.LndsSourceDataType1 int i) {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            iLNDSServiceImpl.cancelDownloadList(arrayList, i);
        }
    }

    public void cancelAllDownloadList(@LndsSourceDataType.LndsSourceDataType1 int i) {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            iLNDSServiceImpl.cancelAllDownloadList(i);
        }
    }

    public void deleteDownloadList(ArrayList<Integer> arrayList, @LndsSourceDataType.LndsSourceDataType1 int i) {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            iLNDSServiceImpl.deleteDownloadList(arrayList, i);
        }
    }

    public boolean requestTileDataVersion(String str) {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            return iLNDSServiceImpl.requestTileDataVersion(str);
        }
        return false;
    }

    public boolean requestTileGlobalFile(String str, String str2, @LndsSourceDataType.LndsSourceDataType1 int i) {
        ILNDSServiceImpl iLNDSServiceImpl = this.mControl;
        if (iLNDSServiceImpl != null) {
            return iLNDSServiceImpl.requestTileGlobalFile(str, str2, i);
        }
        return false;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.13
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.14
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.data.observer.IErrorDataObserver")).iterator();
            while (it.hasNext()) {
                removeErrorDataObserver((IErrorDataObserver) it.next());
            }
        }
        TypeHelper typeHelper2 = this.mTypeHelper;
        if (typeHelper2 != null) {
            Iterator it2 = ((HashSet) typeHelper2.getBindSet("com.autonavi.gbl.data.observer.ILNDSNearCityListObserver")).iterator();
            while (it2.hasNext()) {
                removeNearCityListObserver((ILNDSNearCityListObserver) it2.next());
            }
        }
        TypeHelper typeHelper3 = this.mTypeHelper;
        if (typeHelper3 != null) {
            Iterator it3 = ((HashSet) typeHelper3.getBindSet("com.autonavi.gbl.data.observer.ILNDSDataVersionObserver")).iterator();
            while (it3.hasNext()) {
                removeDataVersionObserver((ILNDSDataVersionObserver) it3.next());
            }
        }
        TypeHelper typeHelper4 = this.mTypeHelper;
        if (typeHelper4 != null) {
            Iterator it4 = ((HashSet) typeHelper4.getBindSet("com.autonavi.gbl.data.observer.ILNDSGlobalFileUpdateObserver")).iterator();
            while (it4.hasNext()) {
                removeGlobalFileUpdateObserver((ILNDSGlobalFileUpdateObserver) it4.next());
            }
        }
        TypeHelper typeHelper5 = this.mTypeHelper;
        if (typeHelper5 != null) {
            Iterator it5 = ((HashSet) typeHelper5.getBindSet("com.autonavi.gbl.data.observer.ILNDSCityDownloadObserver")).iterator();
            while (it5.hasNext()) {
                removeCityDownloadObserver((ILNDSCityDownloadObserver) it5.next());
            }
        }
        TypeHelper typeHelper6 = this.mTypeHelper;
        if (typeHelper6 != null) {
            Iterator it6 = ((HashSet) typeHelper6.getBindSet("com.autonavi.gbl.data.observer.ILndsDataDeleteObserver")).iterator();
            while (it6.hasNext()) {
                removeDeleteObserver((ILndsDataDeleteObserver) it6.next());
            }
        }
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.LNDSService.15
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
