package com.autonavi.gbl.lane;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
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
import com.autonavi.gbl.lane.observer.ILaneObserver;
import com.autonavi.gbl.lane.observer.ILaneResourceProxy;
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
        try {
            Method method = LaneService.class.getMethod("setResourceProxy", ILaneResourceProxy.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                hashSet = (HashSet) typeHelper.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iLaneResourceProxy);
            if (iLaneResourceProxy != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r4 = typeHelper2 != null ? (ILaneResourceProxyImpl) typeHelper2.transfer(method, 0, iLaneResourceProxy) : null;
                if (r4 == null) {
                    DebugTool.e("%s: $proxy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.1
                    }));
                    return false;
                }
            }
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null) {
                boolean resourceProxy = iLaneServiceImpl.setResourceProxy(r4);
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
        try {
            Method method = LaneService.class.getMethod("createLaneRenderService", LaneRenderParam.class);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null && (createLaneRenderService = iLaneServiceImpl.createLaneRenderService(laneRenderParam)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (LaneRenderService) typeHelper.transfer(method, -1, (Object) createLaneRenderService, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.2
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean destroyLaneRenderService(LaneRenderService laneRenderService) {
        try {
            Method method = LaneService.class.getMethod("destroyLaneRenderService", LaneRenderService.class);
            if (laneRenderService != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILaneRenderServiceImpl) typeHelper.transfer(method, 0, laneRenderService) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pService == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.3
                    }));
                    return false;
                }
            }
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null) {
                return iLaneServiceImpl.destroyLaneRenderService(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public LaneRenderService getLaneRenderService(@LaneRenderScreen.LaneRenderScreen1 int i) {
        ILaneRenderServiceImpl laneRenderService;
        try {
            Method method = LaneService.class.getMethod("getLaneRenderService", Integer.TYPE);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null && (laneRenderService = iLaneServiceImpl.getLaneRenderService(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (LaneRenderService) typeHelper.transfer(method, -1, (Object) laneRenderService, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.4
                    }));
                }
            }
            return r0;
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

    public boolean setLNDSDataLimit(boolean z, int i) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setLNDSDataLimit(z, i);
        }
        return false;
    }

    public boolean setLNDSDataLimit(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setLNDSDataLimit(z);
        }
        return false;
    }

    public boolean setOnlineTileLimit(@LaneTileType.LaneTileType1 int i, int i2) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setOnlineTileLimit(i, i2);
        }
        return false;
    }

    public boolean setLNDSAutoDownloadMode(@LaneLndsAutoDownloadMode.LaneLndsAutoDownloadMode1 int i) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setLNDSAutoDownloadMode(i);
        }
        return false;
    }

    public boolean setLoadDataPriority(@LndsDataPriority.LndsDataPriority1 int i) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setLoadDataPriority(i);
        }
        return false;
    }

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
        try {
            Method method = LaneService.class.getMethod("getLaneNaviService", new Class[0]);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null && (laneNaviService = iLaneServiceImpl.getLaneNaviService()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (LaneNaviService) typeHelper.transfer(method, -1, (Object) laneNaviService, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.5
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public LaneServiceRecorder getLaneServiceRecorder() {
        ILaneServiceRecorderImpl laneServiceRecorder;
        try {
            Method method = LaneService.class.getMethod("getLaneServiceRecorder", new Class[0]);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null && (laneServiceRecorder = iLaneServiceImpl.getLaneServiceRecorder()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (LaneServiceRecorder) typeHelper.transfer(method, -1, (Object) laneServiceRecorder, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.6
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public LaneServicePlayer getLaneServicePlayer() {
        ILaneServicePlayerImpl laneServicePlayer;
        try {
            Method method = LaneService.class.getMethod("getLaneServicePlayer", new Class[0]);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null && (laneServicePlayer = iLaneServiceImpl.getLaneServicePlayer()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (LaneServicePlayer) typeHelper.transfer(method, -1, (Object) laneServicePlayer, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.7
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public LaneServiceTool getLaneServiceTool() {
        ILaneServiceToolImpl laneServiceTool;
        try {
            Method method = LaneService.class.getMethod("getLaneServiceTool", new Class[0]);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null && (laneServiceTool = iLaneServiceImpl.getLaneServiceTool()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (LaneServiceTool) typeHelper.transfer(method, -1, (Object) laneServiceTool, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.8
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public LaneMockService getLaneMockService() {
        ILaneMockServiceImpl laneMockService;
        try {
            Method method = LaneService.class.getMethod("getLaneMockService", new Class[0]);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null && (laneMockService = iLaneServiceImpl.getLaneMockService()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (LaneMockService) typeHelper.transfer(method, -1, (Object) laneMockService, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.9
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void addLaneObserver(ILaneObserver iLaneObserver) {
        try {
            Method method = LaneService.class.getMethod("addLaneObserver", ILaneObserver.class);
            if (iLaneObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILaneObserverImpl) typeHelper.transfer(method, 0, iLaneObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.10
                    }));
                }
            }
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null) {
                iLaneServiceImpl.addLaneObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeLaneObserver(ILaneObserver iLaneObserver) {
        try {
            Method method = LaneService.class.getMethod("removeLaneObserver", ILaneObserver.class);
            if (iLaneObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILaneObserverImpl) typeHelper.transfer(method, 0, iLaneObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.11
                    }));
                }
            }
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null) {
                iLaneServiceImpl.removeLaneObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLaneObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.12
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.13
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.lane.observer.ILaneObserver")).iterator();
            while (it.hasNext()) {
                removeLaneObserver((ILaneObserver) it.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.14
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
