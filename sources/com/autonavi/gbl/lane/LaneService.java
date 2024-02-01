package com.autonavi.gbl.lane;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.impl.ILaneMockServiceImpl;
import com.autonavi.gbl.lane.impl.ILaneNaviServiceImpl;
import com.autonavi.gbl.lane.impl.ILaneRenderServiceImpl;
import com.autonavi.gbl.lane.impl.ILaneServiceImpl;
import com.autonavi.gbl.lane.impl.ILaneServicePlayerImpl;
import com.autonavi.gbl.lane.impl.ILaneServiceRecorderImpl;
import com.autonavi.gbl.lane.impl.ILaneServiceToolImpl;
import com.autonavi.gbl.lane.model.AutopilotData;
import com.autonavi.gbl.lane.model.LaneDriveMode;
import com.autonavi.gbl.lane.model.LaneInitParam;
import com.autonavi.gbl.lane.model.LaneLndsAutoDownloadMode;
import com.autonavi.gbl.lane.model.LaneRenderParam;
import com.autonavi.gbl.lane.model.LaneRenderScreen;
import com.autonavi.gbl.lane.model.LaneTileType;
import com.autonavi.gbl.lane.model.LndsDataPriority;
import com.autonavi.gbl.lane.observer.ILaneDiagnosisObserver;
import com.autonavi.gbl.lane.observer.ILaneObserver;
import com.autonavi.gbl.lane.observer.ILaneResourceProxy;
import com.autonavi.gbl.lane.observer.impl.ILaneDiagnosisObserverImpl;
import com.autonavi.gbl.lane.observer.impl.ILaneObserverImpl;
import com.autonavi.gbl.lane.observer.impl.ILaneResourceProxyImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = ILaneServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class LaneService implements IService {
    private static String PACKAGE = ReflexTool.PN(LaneService.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private ILaneServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneService(long j, boolean z) {
        this((ILaneServiceImpl) ReflexTool.invokeDeclConstructorSafe(ILaneServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LaneService.class, this, this.mControl);
        }
    }

    public LaneService(ILaneServiceImpl iLaneServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iLaneServiceImpl);
    }

    private void $constructor(ILaneServiceImpl iLaneServiceImpl) {
        if (iLaneServiceImpl != null) {
            this.mControl = iLaneServiceImpl;
            this.mTargetId = String.format("LaneService_%s_%d", String.valueOf(ILaneServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ILaneServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            iLaneServiceImpl.onCreate();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public String getVersion() {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.getVersion();
        }
        return null;
    }

    public static String getEngineVersion() {
        return ILaneServiceImpl.getEngineVersion();
    }

    public boolean setResourceProxy(ILaneResourceProxy iLaneResourceProxy) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = LaneService.class.getMethod("setResourceProxy", ILaneResourceProxy.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iLaneResourceProxy);
            ILaneResourceProxyImpl iLaneResourceProxyImpl = null;
            if (iLaneResourceProxy != null && (typeHelper = this.mTypeHelper) != null) {
                iLaneResourceProxyImpl = (ILaneResourceProxyImpl) typeHelper.transfer(method, 0, iLaneResourceProxy);
            }
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null) {
                boolean resourceProxy = iLaneServiceImpl.setResourceProxy(iLaneResourceProxyImpl);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
                return resourceProxy;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean init(LaneInitParam laneInitParam) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.init(laneInitParam);
        }
        return false;
    }

    public void unInit() {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            iLaneServiceImpl.unInit();
        }
    }

    public void logSwitch(int i) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            iLaneServiceImpl.logSwitch(i);
        }
    }

    public LaneRenderService createLaneRenderService(LaneRenderParam laneRenderParam) {
        ILaneRenderServiceImpl createLaneRenderService;
        TypeHelper typeHelper;
        try {
            Method method = LaneService.class.getMethod("createLaneRenderService", LaneRenderParam.class);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl == null || (createLaneRenderService = iLaneServiceImpl.createLaneRenderService(laneRenderParam)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (LaneRenderService) typeHelper.transfer(method, -1, (Object) createLaneRenderService, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean destroyLaneRenderService(LaneRenderService laneRenderService) {
        TypeHelper typeHelper;
        try {
            Method method = LaneService.class.getMethod("destroyLaneRenderService", LaneRenderService.class);
            ILaneRenderServiceImpl iLaneRenderServiceImpl = null;
            if (laneRenderService != null && (typeHelper = this.mTypeHelper) != null) {
                iLaneRenderServiceImpl = (ILaneRenderServiceImpl) typeHelper.transfer(method, 0, laneRenderService);
            }
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null) {
                return iLaneServiceImpl.destroyLaneRenderService(iLaneRenderServiceImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public LaneRenderService getLaneRenderService(@LaneRenderScreen.LaneRenderScreen1 int i) {
        ILaneRenderServiceImpl laneRenderService;
        TypeHelper typeHelper;
        try {
            Method method = LaneService.class.getMethod("getLaneRenderService", Integer.TYPE);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl == null || (laneRenderService = iLaneServiceImpl.getLaneRenderService(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (LaneRenderService) typeHelper.transfer(method, -1, (Object) laneRenderService, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean openLNDSDataDownload(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openLNDSDataDownload(z);
        }
        return false;
    }

    @Deprecated
    public boolean setLNDSDataLimit(boolean z, int i) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setLNDSDataLimit(z, i);
        }
        return false;
    }

    @Deprecated
    public boolean setLNDSDataLimit(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setLNDSDataLimit(z);
        }
        return false;
    }

    @Deprecated
    public boolean setOnlineTileLimit(@LaneTileType.LaneTileType1 int i, int i2) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setOnlineTileLimit(i, i2);
        }
        return false;
    }

    @Deprecated
    public boolean setLNDSAutoDownloadMode(@LaneLndsAutoDownloadMode.LaneLndsAutoDownloadMode1 int i) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setLNDSAutoDownloadMode(i);
        }
        return false;
    }

    @Deprecated
    public boolean setLoadDataPriority(@LndsDataPriority.LndsDataPriority1 int i) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setLoadDataPriority(i);
        }
        return false;
    }

    @Deprecated
    public boolean setAutopilotData(AutopilotData autopilotData) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setAutopilotData(autopilotData);
        }
        return false;
    }

    public boolean setDriveMode(@LaneDriveMode.LaneDriveMode1 int i) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setDriveMode(i);
        }
        return false;
    }

    public LaneNaviService getLaneNaviService() {
        ILaneNaviServiceImpl laneNaviService;
        TypeHelper typeHelper;
        try {
            Method method = LaneService.class.getMethod("getLaneNaviService", new Class[0]);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl == null || (laneNaviService = iLaneServiceImpl.getLaneNaviService()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (LaneNaviService) typeHelper.transfer(method, -1, (Object) laneNaviService, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public LaneServiceRecorder getLaneServiceRecorder() {
        ILaneServiceRecorderImpl laneServiceRecorder;
        TypeHelper typeHelper;
        try {
            Method method = LaneService.class.getMethod("getLaneServiceRecorder", new Class[0]);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl == null || (laneServiceRecorder = iLaneServiceImpl.getLaneServiceRecorder()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (LaneServiceRecorder) typeHelper.transfer(method, -1, (Object) laneServiceRecorder, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public LaneServicePlayer getLaneServicePlayer() {
        ILaneServicePlayerImpl laneServicePlayer;
        TypeHelper typeHelper;
        try {
            Method method = LaneService.class.getMethod("getLaneServicePlayer", new Class[0]);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl == null || (laneServicePlayer = iLaneServiceImpl.getLaneServicePlayer()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (LaneServicePlayer) typeHelper.transfer(method, -1, (Object) laneServicePlayer, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public LaneServiceTool getLaneServiceTool() {
        ILaneServiceToolImpl laneServiceTool;
        TypeHelper typeHelper;
        try {
            Method method = LaneService.class.getMethod("getLaneServiceTool", new Class[0]);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl == null || (laneServiceTool = iLaneServiceImpl.getLaneServiceTool()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (LaneServiceTool) typeHelper.transfer(method, -1, (Object) laneServiceTool, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public LaneMockService getLaneMockService() {
        ILaneMockServiceImpl laneMockService;
        TypeHelper typeHelper;
        try {
            Method method = LaneService.class.getMethod("getLaneMockService", new Class[0]);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl == null || (laneMockService = iLaneServiceImpl.getLaneMockService()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (LaneMockService) typeHelper.transfer(method, -1, (Object) laneMockService, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void addLaneObserver(ILaneObserver iLaneObserver) {
        TypeHelper typeHelper;
        try {
            Method method = LaneService.class.getMethod("addLaneObserver", ILaneObserver.class);
            ILaneObserverImpl iLaneObserverImpl = null;
            if (iLaneObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLaneObserverImpl = (ILaneObserverImpl) typeHelper.transfer(method, 0, iLaneObserver);
            }
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null) {
                iLaneServiceImpl.addLaneObserver(iLaneObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeLaneObserver(ILaneObserver iLaneObserver) {
        TypeHelper typeHelper;
        try {
            Method method = LaneService.class.getMethod("removeLaneObserver", ILaneObserver.class);
            ILaneObserverImpl iLaneObserverImpl = null;
            if (iLaneObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLaneObserverImpl = (ILaneObserverImpl) typeHelper.transfer(method, 0, iLaneObserver);
            }
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null) {
                iLaneServiceImpl.removeLaneObserver(iLaneObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLaneObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addLaneDiagnosisObserver(ILaneDiagnosisObserver iLaneDiagnosisObserver) {
        TypeHelper typeHelper;
        try {
            Method method = LaneService.class.getMethod("addLaneDiagnosisObserver", ILaneDiagnosisObserver.class);
            ILaneDiagnosisObserverImpl iLaneDiagnosisObserverImpl = null;
            if (iLaneDiagnosisObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLaneDiagnosisObserverImpl = (ILaneDiagnosisObserverImpl) typeHelper.transfer(method, 0, iLaneDiagnosisObserver);
            }
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null) {
                iLaneServiceImpl.addLaneDiagnosisObserver(iLaneDiagnosisObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeLaneDiagnosisObserver(ILaneDiagnosisObserver iLaneDiagnosisObserver) {
        TypeHelper typeHelper;
        try {
            Method method = LaneService.class.getMethod("removeLaneDiagnosisObserver", ILaneDiagnosisObserver.class);
            ILaneDiagnosisObserverImpl iLaneDiagnosisObserverImpl = null;
            if (iLaneDiagnosisObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLaneDiagnosisObserverImpl = (ILaneDiagnosisObserverImpl) typeHelper.transfer(method, 0, iLaneDiagnosisObserver);
            }
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null) {
                iLaneServiceImpl.removeLaneDiagnosisObserver(iLaneDiagnosisObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLaneDiagnosisObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    protected void unbind() {
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
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.lane.observer.ILaneObserver")).iterator();
            while (it.hasNext()) {
                removeLaneObserver((ILaneObserver) it.next());
            }
        }
        TypeHelper typeHelper2 = this.mTypeHelper;
        if (typeHelper2 != null) {
            Iterator it2 = ((HashSet) typeHelper2.getBindSet("com.autonavi.gbl.lane.observer.ILaneDiagnosisObserver")).iterator();
            while (it2.hasNext()) {
                removeLaneDiagnosisObserver((ILaneDiagnosisObserver) it2.next());
            }
        }
    }

    protected synchronized void delete() {
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
