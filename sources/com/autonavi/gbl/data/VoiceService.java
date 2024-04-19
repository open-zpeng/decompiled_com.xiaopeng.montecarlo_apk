package com.autonavi.gbl.data;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.impl.IVoiceServiceImpl;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.OperationType;
import com.autonavi.gbl.data.model.Voice;
import com.autonavi.gbl.data.model.VoiceEngineType;
import com.autonavi.gbl.data.model.VoiceInitConfig;
import com.autonavi.gbl.data.observer.IDataInitObserver;
import com.autonavi.gbl.data.observer.IDataListObserver;
import com.autonavi.gbl.data.observer.IDownloadObserver;
import com.autonavi.gbl.data.observer.IImageObserver;
import com.autonavi.gbl.data.observer.impl.IDataInitObserverImpl;
import com.autonavi.gbl.data.observer.impl.IDataListObserverImpl;
import com.autonavi.gbl.data.observer.impl.IDownloadObserverImpl;
import com.autonavi.gbl.data.observer.impl.IImageObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IVoiceServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class VoiceService implements IService {
    private static String PACKAGE = ReflexTool.PN(VoiceService.class);
    private IVoiceServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected VoiceService(long j, boolean z) {
        this((IVoiceServiceImpl) ReflexTool.invokeDeclConstructorSafe(IVoiceServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(VoiceService.class, this, this.mControl);
        }
    }

    public VoiceService(IVoiceServiceImpl iVoiceServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iVoiceServiceImpl);
    }

    private void $constructor(IVoiceServiceImpl iVoiceServiceImpl) {
        if (iVoiceServiceImpl != null) {
            this.mControl = iVoiceServiceImpl;
            this.mTargetId = String.format("VoiceService_%s_%d", String.valueOf(IVoiceServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IVoiceServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            return iVoiceServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            return iVoiceServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            iVoiceServiceImpl.onCreate();
        }
    }

    public Voice getVoice(@DownLoadMode.DownLoadMode1 int i, int i2) {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            return iVoiceServiceImpl.getVoice(i, i2);
        }
        return null;
    }

    public ArrayList<Integer> getVoiceIdList(@DownLoadMode.DownLoadMode1 int i) {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            return iVoiceServiceImpl.getVoiceIdList(i);
        }
        return null;
    }

    public ArrayList<Integer> getVoiceIdList(@DownLoadMode.DownLoadMode1 int i, @VoiceEngineType.VoiceEngineType1 int i2) {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            return iVoiceServiceImpl.getVoiceIdList(i, i2);
        }
        return null;
    }

    @ErrorCode.ErrorCode1
    public int init(VoiceInitConfig voiceInitConfig, IDataInitObserver iDataInitObserver) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = VoiceService.class.getMethod("init", VoiceInitConfig.class, IDataInitObserver.class);
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
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.VoiceService.1
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
            if (iVoiceServiceImpl != null) {
                int init = iVoiceServiceImpl.init(voiceInitConfig, r3);
                if (init == 0 && (typeHelper = this.mTypeHelper) != null) {
                    typeHelper.unbindSet(method, 1, hashSet);
                }
                return init;
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            return iVoiceServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            iVoiceServiceImpl.unInit();
        }
    }

    public String getVersion() {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            return iVoiceServiceImpl.getVersion();
        }
        return null;
    }

    @ErrorCode.ErrorCode1
    public int requestDataListCheck(@DownLoadMode.DownLoadMode1 int i, String str, IDataListObserver iDataListObserver) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = VoiceService.class.getMethod("requestDataListCheck", Integer.TYPE, String.class, IDataListObserver.class);
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
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.VoiceService.2
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
            if (iVoiceServiceImpl != null) {
                int requestDataListCheck = iVoiceServiceImpl.requestDataListCheck(i, str, r3);
                if (requestDataListCheck == 0 && (typeHelper = this.mTypeHelper) != null) {
                    typeHelper.unbindSet(method, 2, hashSet);
                }
                return requestDataListCheck;
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    @ErrorCode.ErrorCode1
    public int abortRequestDataListCheck(@DownLoadMode.DownLoadMode1 int i) {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            return iVoiceServiceImpl.abortRequestDataListCheck(i);
        }
        return Integer.MIN_VALUE;
    }

    public void changeDiskStatus(String str, int i) {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            iVoiceServiceImpl.changeDiskStatus(str, i);
        }
    }

    @ErrorCode.ErrorCode1
    public int checkDataInDisk(@DownLoadMode.DownLoadMode1 int i, String str) {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            return iVoiceServiceImpl.checkDataInDisk(i, str);
        }
        return Integer.MIN_VALUE;
    }

    public boolean updateVersion(String str, String str2) {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            return iVoiceServiceImpl.updateVersion(str, str2);
        }
        return false;
    }

    @ErrorCode.ErrorCode1
    public int addNetDownloadObserver(IDownloadObserver iDownloadObserver) {
        try {
            Method method = VoiceService.class.getMethod("addNetDownloadObserver", IDownloadObserver.class);
            if (iDownloadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IDownloadObserverImpl) typeHelper.transfer(method, 0, iDownloadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.VoiceService.3
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
            if (iVoiceServiceImpl != null) {
                return iVoiceServiceImpl.addNetDownloadObserver(r2);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    @ErrorCode.ErrorCode1
    public int addUsbDownloadObserver(IDownloadObserver iDownloadObserver) {
        try {
            Method method = VoiceService.class.getMethod("addUsbDownloadObserver", IDownloadObserver.class);
            if (iDownloadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IDownloadObserverImpl) typeHelper.transfer(method, 0, iDownloadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.VoiceService.4
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
            if (iVoiceServiceImpl != null) {
                return iVoiceServiceImpl.addUsbDownloadObserver(r2);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public int removeDownloadObserver(@DownLoadMode.DownLoadMode1 int i, IDownloadObserver iDownloadObserver) {
        try {
            Method method = VoiceService.class.getMethod("removeDownloadObserver", Integer.TYPE, IDownloadObserver.class);
            if (iDownloadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IDownloadObserverImpl) typeHelper.transfer(method, 1, iDownloadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.VoiceService.5
                    }));
                    return 0;
                }
            }
            IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
            if (iVoiceServiceImpl != null) {
                int removeDownloadObserver = iVoiceServiceImpl.removeDownloadObserver(i, r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 1, iDownloadObserver);
                }
                return removeDownloadObserver;
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @ErrorCode.ErrorCode1
    public int removeNetDownloadObserver(IDownloadObserver iDownloadObserver) {
        int i = Integer.MIN_VALUE;
        try {
            Method method = VoiceService.class.getMethod("removeNetDownloadObserver", IDownloadObserver.class);
            if (iDownloadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IDownloadObserverImpl) typeHelper.transfer(method, 0, iDownloadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.VoiceService.6
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
            if (iVoiceServiceImpl != null) {
                i = iVoiceServiceImpl.removeNetDownloadObserver(r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iDownloadObserver);
                }
            }
            return i;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    @ErrorCode.ErrorCode1
    public int removeUsbDownloadObserver(IDownloadObserver iDownloadObserver) {
        int i = Integer.MIN_VALUE;
        try {
            Method method = VoiceService.class.getMethod("removeUsbDownloadObserver", IDownloadObserver.class);
            if (iDownloadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IDownloadObserverImpl) typeHelper.transfer(method, 0, iDownloadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.VoiceService.7
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
            if (iVoiceServiceImpl != null) {
                i = iVoiceServiceImpl.removeUsbDownloadObserver(r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iDownloadObserver);
                }
            }
            return i;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    @ErrorCode.ErrorCode1
    public int operate(@DownLoadMode.DownLoadMode1 int i, @OperationType.OperationType1 int i2, ArrayList<Integer> arrayList) {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            return iVoiceServiceImpl.operate(i, i2, arrayList);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int operateWorkingQueue(@DownLoadMode.DownLoadMode1 int i, @OperationType.OperationType1 int i2, @VoiceEngineType.VoiceEngineType1 int i3) {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            return iVoiceServiceImpl.operateWorkingQueue(i, i2, i3);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int requestDataImage(@DownLoadMode.DownLoadMode1 int i, int i2, IImageObserver iImageObserver) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = VoiceService.class.getMethod("requestDataImage", Integer.TYPE, Integer.TYPE, IImageObserver.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 2);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iImageObserver);
            if (iImageObserver != null) {
                TypeHelper typeHelper3 = this.mTypeHelper;
                r3 = typeHelper3 != null ? (IImageObserverImpl) typeHelper3.transfer(method, 2, iImageObserver) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.VoiceService.8
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
            if (iVoiceServiceImpl != null) {
                int requestDataImage = iVoiceServiceImpl.requestDataImage(i, i2, r3);
                if (requestDataImage == 0 && (typeHelper = this.mTypeHelper) != null) {
                    typeHelper.unbindSet(method, 2, hashSet);
                }
                return requestDataImage;
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    @ErrorCode.ErrorCode1
    public int abortRequestDataImage(@DownLoadMode.DownLoadMode1 int i, int i2) {
        IVoiceServiceImpl iVoiceServiceImpl = this.mControl;
        if (iVoiceServiceImpl != null) {
            return iVoiceServiceImpl.abortRequestDataImage(i, i2);
        }
        return Integer.MIN_VALUE;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.VoiceService.9
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.VoiceService.10
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.VoiceService.11
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
