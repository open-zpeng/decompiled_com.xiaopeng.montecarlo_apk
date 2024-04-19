package com.autonavi.gbl.pos;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.observer.IThreadObserver;
import com.autonavi.gbl.common.observer.impl.IThreadObserverImpl;
import com.autonavi.gbl.pos.impl.IPosServiceImpl;
import com.autonavi.gbl.pos.model.EUserDevInfo;
import com.autonavi.gbl.pos.model.EventTrackHistory;
import com.autonavi.gbl.pos.model.LocGPSHistory;
import com.autonavi.gbl.pos.model.LocLogConf;
import com.autonavi.gbl.pos.model.LocModeType;
import com.autonavi.gbl.pos.model.LocSignData;
import com.autonavi.gbl.pos.model.LocSwitchRoadType;
import com.autonavi.gbl.pos.model.PosVersion;
import com.autonavi.gbl.pos.model.PosWorkPath;
import com.autonavi.gbl.pos.observer.INgmInfoObserver;
import com.autonavi.gbl.pos.observer.IPosAttitudeAngleObserver;
import com.autonavi.gbl.pos.observer.IPosDrInfoObserver;
import com.autonavi.gbl.pos.observer.IPosGraspRoadResultObserver;
import com.autonavi.gbl.pos.observer.IPosLocInfoObserver;
import com.autonavi.gbl.pos.observer.IPosMapMatchFeedbackObserver;
import com.autonavi.gbl.pos.observer.IPosParallelRoadObserver;
import com.autonavi.gbl.pos.observer.IPosSensorParaObserver;
import com.autonavi.gbl.pos.observer.IPosSignInfoObserver;
import com.autonavi.gbl.pos.observer.IPosSwitchParallelRoadObserver;
import com.autonavi.gbl.pos.observer.impl.INgmInfoObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosAttitudeAngleObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosDrInfoObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosGraspRoadResultObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosLocInfoObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosMapMatchFeedbackObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosParallelRoadObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosSensorParaObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosSignInfoObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosSwitchParallelRoadObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IPosServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class PosService implements IService {
    private static String PACKAGE = ReflexTool.PN(PosService.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IPosServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected PosService(long j, boolean z) {
        this((IPosServiceImpl) ReflexTool.invokeDeclConstructorSafe(IPosServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(PosService.class, this, this.mControl);
        }
    }

    public PosService(IPosServiceImpl iPosServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iPosServiceImpl);
    }

    private void $constructor(IPosServiceImpl iPosServiceImpl) {
        if (iPosServiceImpl != null) {
            this.mControl = iPosServiceImpl;
            this.mTargetId = String.format("PosService_%s_%d", String.valueOf(IPosServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IPosServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            return iPosServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            return iPosServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.onCreate();
        }
    }

    public static Coord3DDouble encryptLonLat(Coord3DDouble coord3DDouble) {
        return IPosServiceImpl.encryptLonLat(coord3DDouble);
    }

    public LocGPSHistory getGPSHistory() {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            return iPosServiceImpl.getGPSHistory();
        }
        return null;
    }

    public static String getEngineVersion() {
        return IPosServiceImpl.getEngineVersion();
    }

    public static int regenerateLocStorageFromOldVersion(String str, String str2, @PosVersion.PosVersion1 int i) {
        return IPosServiceImpl.regenerateLocStorageFromOldVersion(str, str2, i);
    }

    @ErrorCode.ErrorCode1
    public int init(PosWorkPath posWorkPath, LocModeType locModeType, IThreadObserver iThreadObserver) {
        try {
            Method method = PosService.class.getMethod("init", PosWorkPath.class, LocModeType.class, IThreadObserver.class);
            if (iThreadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IThreadObserverImpl) typeHelper.transfer(method, 2, iThreadObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $threadObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.1
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                return iPosServiceImpl.init(posWorkPath, locModeType, r2);
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
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            return iPosServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public void setSignInfo(LocSignData locSignData) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.setSignInfo(locSignData);
        }
    }

    public void switchParallelRoad(@LocSwitchRoadType.LocSwitchRoadType1 int i, BigInteger bigInteger) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.switchParallelRoad(i, bigInteger);
        }
    }

    public void saveLocStorage() {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.saveLocStorage();
        }
    }

    public void signalRecordSwitch(boolean z, LocLogConf locLogConf) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.signalRecordSwitch(z, locLogConf);
        }
    }

    public boolean requestCallBackPos(int i) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            return iPosServiceImpl.requestCallBackPos(i);
        }
        return false;
    }

    public void setDefaultPos(Coord3DDouble coord3DDouble) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.setDefaultPos(coord3DDouble);
        }
    }

    public void setContextPos(Coord3DDouble coord3DDouble, float f) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.setContextPos(coord3DDouble, f);
        }
    }

    public void setIssueSubmitInfo(String str) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.setIssueSubmitInfo(str);
        }
    }

    public void addLocInfoObserver(IPosLocInfoObserver iPosLocInfoObserver, int i) {
        try {
            Method method = PosService.class.getMethod("addLocInfoObserver", IPosLocInfoObserver.class, Integer.TYPE);
            if (iPosLocInfoObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosLocInfoObserverImpl) typeHelper.transfer(method, 0, iPosLocInfoObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.2
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addLocInfoObserver(r1, i);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeLocInfoObserver(IPosLocInfoObserver iPosLocInfoObserver) {
        try {
            Method method = PosService.class.getMethod("removeLocInfoObserver", IPosLocInfoObserver.class);
            if (iPosLocInfoObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosLocInfoObserverImpl) typeHelper.transfer(method, 0, iPosLocInfoObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.3
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeLocInfoObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iPosLocInfoObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addParallelRoadObserver(IPosParallelRoadObserver iPosParallelRoadObserver) {
        try {
            Method method = PosService.class.getMethod("addParallelRoadObserver", IPosParallelRoadObserver.class);
            if (iPosParallelRoadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosParallelRoadObserverImpl) typeHelper.transfer(method, 0, iPosParallelRoadObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.4
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addParallelRoadObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeParallelRoadObserver(IPosParallelRoadObserver iPosParallelRoadObserver) {
        try {
            Method method = PosService.class.getMethod("removeParallelRoadObserver", IPosParallelRoadObserver.class);
            if (iPosParallelRoadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosParallelRoadObserverImpl) typeHelper.transfer(method, 0, iPosParallelRoadObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.5
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeParallelRoadObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iPosParallelRoadObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addSwitchParallelRoadObserver(IPosSwitchParallelRoadObserver iPosSwitchParallelRoadObserver) {
        try {
            Method method = PosService.class.getMethod("addSwitchParallelRoadObserver", IPosSwitchParallelRoadObserver.class);
            if (iPosSwitchParallelRoadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosSwitchParallelRoadObserverImpl) typeHelper.transfer(method, 0, iPosSwitchParallelRoadObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.6
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addSwitchParallelRoadObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeSwitchParallelRoadObserver(IPosSwitchParallelRoadObserver iPosSwitchParallelRoadObserver) {
        try {
            Method method = PosService.class.getMethod("removeSwitchParallelRoadObserver", IPosSwitchParallelRoadObserver.class);
            if (iPosSwitchParallelRoadObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosSwitchParallelRoadObserverImpl) typeHelper.transfer(method, 0, iPosSwitchParallelRoadObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.7
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeSwitchParallelRoadObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iPosSwitchParallelRoadObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addSignInfoObserver(IPosSignInfoObserver iPosSignInfoObserver) {
        try {
            Method method = PosService.class.getMethod("addSignInfoObserver", IPosSignInfoObserver.class);
            if (iPosSignInfoObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosSignInfoObserverImpl) typeHelper.transfer(method, 0, iPosSignInfoObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.8
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addSignInfoObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeSignInfoObserver(IPosSignInfoObserver iPosSignInfoObserver) {
        try {
            Method method = PosService.class.getMethod("removeSignInfoObserver", IPosSignInfoObserver.class);
            if (iPosSignInfoObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosSignInfoObserverImpl) typeHelper.transfer(method, 0, iPosSignInfoObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.9
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeSignInfoObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iPosSignInfoObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addMapMatchFeedbackObserver(IPosMapMatchFeedbackObserver iPosMapMatchFeedbackObserver) {
        try {
            Method method = PosService.class.getMethod("addMapMatchFeedbackObserver", IPosMapMatchFeedbackObserver.class);
            if (iPosMapMatchFeedbackObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosMapMatchFeedbackObserverImpl) typeHelper.transfer(method, 0, iPosMapMatchFeedbackObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.10
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addMapMatchFeedbackObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeMapMatchFeedbackObserver(IPosMapMatchFeedbackObserver iPosMapMatchFeedbackObserver) {
        try {
            Method method = PosService.class.getMethod("removeMapMatchFeedbackObserver", IPosMapMatchFeedbackObserver.class);
            if (iPosMapMatchFeedbackObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosMapMatchFeedbackObserverImpl) typeHelper.transfer(method, 0, iPosMapMatchFeedbackObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.11
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeMapMatchFeedbackObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iPosMapMatchFeedbackObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addNgmInfoObserver(INgmInfoObserver iNgmInfoObserver) {
        try {
            Method method = PosService.class.getMethod("addNgmInfoObserver", INgmInfoObserver.class);
            if (iNgmInfoObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (INgmInfoObserverImpl) typeHelper.transfer(method, 0, iNgmInfoObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.12
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addNgmInfoObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeNgmInfoObserver(INgmInfoObserver iNgmInfoObserver) {
        try {
            Method method = PosService.class.getMethod("removeNgmInfoObserver", INgmInfoObserver.class);
            if (iNgmInfoObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (INgmInfoObserverImpl) typeHelper.transfer(method, 0, iNgmInfoObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.13
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeNgmInfoObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iNgmInfoObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addSensorParaObserver(IPosSensorParaObserver iPosSensorParaObserver) {
        try {
            Method method = PosService.class.getMethod("addSensorParaObserver", IPosSensorParaObserver.class);
            if (iPosSensorParaObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosSensorParaObserverImpl) typeHelper.transfer(method, 0, iPosSensorParaObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.14
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addSensorParaObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeSensorParaObserver(IPosSensorParaObserver iPosSensorParaObserver) {
        try {
            Method method = PosService.class.getMethod("removeSensorParaObserver", IPosSensorParaObserver.class);
            if (iPosSensorParaObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosSensorParaObserverImpl) typeHelper.transfer(method, 0, iPosSensorParaObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.15
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeSensorParaObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iPosSensorParaObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addPosDrInfoObserver(IPosDrInfoObserver iPosDrInfoObserver) {
        try {
            Method method = PosService.class.getMethod("addPosDrInfoObserver", IPosDrInfoObserver.class);
            if (iPosDrInfoObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosDrInfoObserverImpl) typeHelper.transfer(method, 0, iPosDrInfoObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.16
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addPosDrInfoObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removePosDrInfoObserver(IPosDrInfoObserver iPosDrInfoObserver) {
        try {
            Method method = PosService.class.getMethod("removePosDrInfoObserver", IPosDrInfoObserver.class);
            if (iPosDrInfoObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosDrInfoObserverImpl) typeHelper.transfer(method, 0, iPosDrInfoObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.17
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removePosDrInfoObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addAttitudeAngleObserver(IPosAttitudeAngleObserver iPosAttitudeAngleObserver) {
        try {
            Method method = PosService.class.getMethod("addAttitudeAngleObserver", IPosAttitudeAngleObserver.class);
            if (iPosAttitudeAngleObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosAttitudeAngleObserverImpl) typeHelper.transfer(method, 0, iPosAttitudeAngleObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.18
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addAttitudeAngleObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeAttitudeAngleObserver(IPosAttitudeAngleObserver iPosAttitudeAngleObserver) {
        try {
            Method method = PosService.class.getMethod("removeAttitudeAngleObserver", IPosAttitudeAngleObserver.class);
            if (iPosAttitudeAngleObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosAttitudeAngleObserverImpl) typeHelper.transfer(method, 0, iPosAttitudeAngleObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.19
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeAttitudeAngleObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addGraspRoadResultObserver(IPosGraspRoadResultObserver iPosGraspRoadResultObserver) {
        try {
            Method method = PosService.class.getMethod("addGraspRoadResultObserver", IPosGraspRoadResultObserver.class);
            if (iPosGraspRoadResultObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosGraspRoadResultObserverImpl) typeHelper.transfer(method, 0, iPosGraspRoadResultObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.20
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addGraspRoadResultObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeGraspRoadResultObserver(IPosGraspRoadResultObserver iPosGraspRoadResultObserver) {
        try {
            Method method = PosService.class.getMethod("removeGraspRoadResultObserver", IPosGraspRoadResultObserver.class);
            if (iPosGraspRoadResultObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPosGraspRoadResultObserverImpl) typeHelper.transfer(method, 0, iPosGraspRoadResultObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.21
                    }));
                }
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeGraspRoadResultObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public String getDebugInfo(int i) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            return iPosServiceImpl.getDebugInfo(i);
        }
        return null;
    }

    public void setOverheadSwitch(boolean z) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.setOverheadSwitch(z);
        }
    }

    public void setViaductRecognizeSwitch(boolean z) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.setViaductRecognizeSwitch(z);
        }
    }

    public void setUserDevInfo(@EUserDevInfo.EUserDevInfo1 int i, String str) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.setUserDevInfo(i, str);
        }
    }

    public void setLaneSwitch(boolean z) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.setLaneSwitch(z);
        }
    }

    public void setLaneRes4Debug(boolean z, int i, int i2, int i3) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.setLaneRes4Debug(z, i, i2, i3);
        }
    }

    public void setEventTrackHistory(EventTrackHistory eventTrackHistory) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.setEventTrackHistory(eventTrackHistory);
        }
    }

    public void setHDLaneMockRange(double d) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.setHDLaneMockRange(d);
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.22
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.23
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.pos.observer.IPosLocInfoObserver")).iterator();
            while (it.hasNext()) {
                removeLocInfoObserver((IPosLocInfoObserver) it.next());
            }
        }
        TypeHelper typeHelper2 = this.mTypeHelper;
        if (typeHelper2 != null) {
            Iterator it2 = ((HashSet) typeHelper2.getBindSet("com.autonavi.gbl.pos.observer.IPosParallelRoadObserver")).iterator();
            while (it2.hasNext()) {
                removeParallelRoadObserver((IPosParallelRoadObserver) it2.next());
            }
        }
        TypeHelper typeHelper3 = this.mTypeHelper;
        if (typeHelper3 != null) {
            Iterator it3 = ((HashSet) typeHelper3.getBindSet("com.autonavi.gbl.pos.observer.IPosSwitchParallelRoadObserver")).iterator();
            while (it3.hasNext()) {
                removeSwitchParallelRoadObserver((IPosSwitchParallelRoadObserver) it3.next());
            }
        }
        TypeHelper typeHelper4 = this.mTypeHelper;
        if (typeHelper4 != null) {
            Iterator it4 = ((HashSet) typeHelper4.getBindSet("com.autonavi.gbl.pos.observer.IPosSignInfoObserver")).iterator();
            while (it4.hasNext()) {
                removeSignInfoObserver((IPosSignInfoObserver) it4.next());
            }
        }
        TypeHelper typeHelper5 = this.mTypeHelper;
        if (typeHelper5 != null) {
            Iterator it5 = ((HashSet) typeHelper5.getBindSet("com.autonavi.gbl.pos.observer.IPosMapMatchFeedbackObserver")).iterator();
            while (it5.hasNext()) {
                removeMapMatchFeedbackObserver((IPosMapMatchFeedbackObserver) it5.next());
            }
        }
        TypeHelper typeHelper6 = this.mTypeHelper;
        if (typeHelper6 != null) {
            Iterator it6 = ((HashSet) typeHelper6.getBindSet("com.autonavi.gbl.pos.observer.INgmInfoObserver")).iterator();
            while (it6.hasNext()) {
                removeNgmInfoObserver((INgmInfoObserver) it6.next());
            }
        }
        TypeHelper typeHelper7 = this.mTypeHelper;
        if (typeHelper7 != null) {
            Iterator it7 = ((HashSet) typeHelper7.getBindSet("com.autonavi.gbl.pos.observer.IPosSensorParaObserver")).iterator();
            while (it7.hasNext()) {
                removeSensorParaObserver((IPosSensorParaObserver) it7.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.PosService.24
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
