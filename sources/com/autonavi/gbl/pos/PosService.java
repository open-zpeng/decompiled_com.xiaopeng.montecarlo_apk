package com.autonavi.gbl.pos;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
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
import com.autonavi.gbl.pos.observer.IPosAttitudeAngleObserver;
import com.autonavi.gbl.pos.observer.IPosDiagnosisInfoObserver;
import com.autonavi.gbl.pos.observer.IPosDrInfoObserver;
import com.autonavi.gbl.pos.observer.IPosGraspRoadResultObserver;
import com.autonavi.gbl.pos.observer.IPosLocInfoObserver;
import com.autonavi.gbl.pos.observer.IPosMapMatchFeedbackObserver;
import com.autonavi.gbl.pos.observer.IPosParallelRoadObserver;
import com.autonavi.gbl.pos.observer.IPosSensorParaObserver;
import com.autonavi.gbl.pos.observer.IPosSignInfoObserver;
import com.autonavi.gbl.pos.observer.IPosSwitchParallelRoadObserver;
import com.autonavi.gbl.pos.observer.impl.IPosAttitudeAngleObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosDiagnosisInfoObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosDrInfoObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosGraspRoadResultObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosLocInfoObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosMapMatchFeedbackObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosParallelRoadObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosSensorParaObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosSignInfoObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosSwitchParallelRoadObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
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

    public static String getEngineVersion() {
        return IPosServiceImpl.getEngineVersion();
    }

    public static int regenerateLocStorageFromOldVersion(String str, String str2, @PosVersion.PosVersion1 int i) {
        return IPosServiceImpl.regenerateLocStorageFromOldVersion(str, str2, i);
    }

    @Deprecated
    public int init(PosWorkPath posWorkPath, LocModeType locModeType, IThreadObserver iThreadObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("init", PosWorkPath.class, LocModeType.class, IThreadObserver.class);
            IThreadObserverImpl iThreadObserverImpl = null;
            if (iThreadObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iThreadObserverImpl = (IThreadObserverImpl) typeHelper.transfer(method, 2, iThreadObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                return iPosServiceImpl.init(posWorkPath, locModeType, iThreadObserverImpl);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public int init(PosWorkPath posWorkPath, LocModeType locModeType) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            return iPosServiceImpl.init(posWorkPath, locModeType);
        }
        return Integer.MIN_VALUE;
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

    public static Coord3DDouble encryptLonLat(Coord3DDouble coord3DDouble) {
        return IPosServiceImpl.encryptLonLat(coord3DDouble);
    }

    public void addLocInfoObserver(IPosLocInfoObserver iPosLocInfoObserver, int i) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("addLocInfoObserver", IPosLocInfoObserver.class, Integer.TYPE);
            IPosLocInfoObserverImpl iPosLocInfoObserverImpl = null;
            if (iPosLocInfoObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosLocInfoObserverImpl = (IPosLocInfoObserverImpl) typeHelper.transfer(method, 0, iPosLocInfoObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addLocInfoObserver(iPosLocInfoObserverImpl, i);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeLocInfoObserver(IPosLocInfoObserver iPosLocInfoObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("removeLocInfoObserver", IPosLocInfoObserver.class);
            IPosLocInfoObserverImpl iPosLocInfoObserverImpl = null;
            if (iPosLocInfoObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosLocInfoObserverImpl = (IPosLocInfoObserverImpl) typeHelper.transfer(method, 0, iPosLocInfoObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeLocInfoObserver(iPosLocInfoObserverImpl);
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
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("addParallelRoadObserver", IPosParallelRoadObserver.class);
            IPosParallelRoadObserverImpl iPosParallelRoadObserverImpl = null;
            if (iPosParallelRoadObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosParallelRoadObserverImpl = (IPosParallelRoadObserverImpl) typeHelper.transfer(method, 0, iPosParallelRoadObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addParallelRoadObserver(iPosParallelRoadObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeParallelRoadObserver(IPosParallelRoadObserver iPosParallelRoadObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("removeParallelRoadObserver", IPosParallelRoadObserver.class);
            IPosParallelRoadObserverImpl iPosParallelRoadObserverImpl = null;
            if (iPosParallelRoadObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosParallelRoadObserverImpl = (IPosParallelRoadObserverImpl) typeHelper.transfer(method, 0, iPosParallelRoadObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeParallelRoadObserver(iPosParallelRoadObserverImpl);
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
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("addSwitchParallelRoadObserver", IPosSwitchParallelRoadObserver.class);
            IPosSwitchParallelRoadObserverImpl iPosSwitchParallelRoadObserverImpl = null;
            if (iPosSwitchParallelRoadObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosSwitchParallelRoadObserverImpl = (IPosSwitchParallelRoadObserverImpl) typeHelper.transfer(method, 0, iPosSwitchParallelRoadObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addSwitchParallelRoadObserver(iPosSwitchParallelRoadObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeSwitchParallelRoadObserver(IPosSwitchParallelRoadObserver iPosSwitchParallelRoadObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("removeSwitchParallelRoadObserver", IPosSwitchParallelRoadObserver.class);
            IPosSwitchParallelRoadObserverImpl iPosSwitchParallelRoadObserverImpl = null;
            if (iPosSwitchParallelRoadObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosSwitchParallelRoadObserverImpl = (IPosSwitchParallelRoadObserverImpl) typeHelper.transfer(method, 0, iPosSwitchParallelRoadObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeSwitchParallelRoadObserver(iPosSwitchParallelRoadObserverImpl);
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
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("addSignInfoObserver", IPosSignInfoObserver.class);
            IPosSignInfoObserverImpl iPosSignInfoObserverImpl = null;
            if (iPosSignInfoObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosSignInfoObserverImpl = (IPosSignInfoObserverImpl) typeHelper.transfer(method, 0, iPosSignInfoObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addSignInfoObserver(iPosSignInfoObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeSignInfoObserver(IPosSignInfoObserver iPosSignInfoObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("removeSignInfoObserver", IPosSignInfoObserver.class);
            IPosSignInfoObserverImpl iPosSignInfoObserverImpl = null;
            if (iPosSignInfoObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosSignInfoObserverImpl = (IPosSignInfoObserverImpl) typeHelper.transfer(method, 0, iPosSignInfoObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeSignInfoObserver(iPosSignInfoObserverImpl);
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
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("addMapMatchFeedbackObserver", IPosMapMatchFeedbackObserver.class);
            IPosMapMatchFeedbackObserverImpl iPosMapMatchFeedbackObserverImpl = null;
            if (iPosMapMatchFeedbackObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosMapMatchFeedbackObserverImpl = (IPosMapMatchFeedbackObserverImpl) typeHelper.transfer(method, 0, iPosMapMatchFeedbackObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addMapMatchFeedbackObserver(iPosMapMatchFeedbackObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeMapMatchFeedbackObserver(IPosMapMatchFeedbackObserver iPosMapMatchFeedbackObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("removeMapMatchFeedbackObserver", IPosMapMatchFeedbackObserver.class);
            IPosMapMatchFeedbackObserverImpl iPosMapMatchFeedbackObserverImpl = null;
            if (iPosMapMatchFeedbackObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosMapMatchFeedbackObserverImpl = (IPosMapMatchFeedbackObserverImpl) typeHelper.transfer(method, 0, iPosMapMatchFeedbackObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeMapMatchFeedbackObserver(iPosMapMatchFeedbackObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iPosMapMatchFeedbackObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addSensorParaObserver(IPosSensorParaObserver iPosSensorParaObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("addSensorParaObserver", IPosSensorParaObserver.class);
            IPosSensorParaObserverImpl iPosSensorParaObserverImpl = null;
            if (iPosSensorParaObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosSensorParaObserverImpl = (IPosSensorParaObserverImpl) typeHelper.transfer(method, 0, iPosSensorParaObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addSensorParaObserver(iPosSensorParaObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeSensorParaObserver(IPosSensorParaObserver iPosSensorParaObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("removeSensorParaObserver", IPosSensorParaObserver.class);
            IPosSensorParaObserverImpl iPosSensorParaObserverImpl = null;
            if (iPosSensorParaObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosSensorParaObserverImpl = (IPosSensorParaObserverImpl) typeHelper.transfer(method, 0, iPosSensorParaObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeSensorParaObserver(iPosSensorParaObserverImpl);
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
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("addPosDrInfoObserver", IPosDrInfoObserver.class);
            IPosDrInfoObserverImpl iPosDrInfoObserverImpl = null;
            if (iPosDrInfoObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosDrInfoObserverImpl = (IPosDrInfoObserverImpl) typeHelper.transfer(method, 0, iPosDrInfoObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addPosDrInfoObserver(iPosDrInfoObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removePosDrInfoObserver(IPosDrInfoObserver iPosDrInfoObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("removePosDrInfoObserver", IPosDrInfoObserver.class);
            IPosDrInfoObserverImpl iPosDrInfoObserverImpl = null;
            if (iPosDrInfoObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosDrInfoObserverImpl = (IPosDrInfoObserverImpl) typeHelper.transfer(method, 0, iPosDrInfoObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removePosDrInfoObserver(iPosDrInfoObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iPosDrInfoObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addAttitudeAngleObserver(IPosAttitudeAngleObserver iPosAttitudeAngleObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("addAttitudeAngleObserver", IPosAttitudeAngleObserver.class);
            IPosAttitudeAngleObserverImpl iPosAttitudeAngleObserverImpl = null;
            if (iPosAttitudeAngleObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosAttitudeAngleObserverImpl = (IPosAttitudeAngleObserverImpl) typeHelper.transfer(method, 0, iPosAttitudeAngleObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addAttitudeAngleObserver(iPosAttitudeAngleObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeAttitudeAngleObserver(IPosAttitudeAngleObserver iPosAttitudeAngleObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("removeAttitudeAngleObserver", IPosAttitudeAngleObserver.class);
            IPosAttitudeAngleObserverImpl iPosAttitudeAngleObserverImpl = null;
            if (iPosAttitudeAngleObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosAttitudeAngleObserverImpl = (IPosAttitudeAngleObserverImpl) typeHelper.transfer(method, 0, iPosAttitudeAngleObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeAttitudeAngleObserver(iPosAttitudeAngleObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iPosAttitudeAngleObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addGraspRoadResultObserver(IPosGraspRoadResultObserver iPosGraspRoadResultObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("addGraspRoadResultObserver", IPosGraspRoadResultObserver.class);
            IPosGraspRoadResultObserverImpl iPosGraspRoadResultObserverImpl = null;
            if (iPosGraspRoadResultObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosGraspRoadResultObserverImpl = (IPosGraspRoadResultObserverImpl) typeHelper.transfer(method, 0, iPosGraspRoadResultObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addGraspRoadResultObserver(iPosGraspRoadResultObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeGraspRoadResultObserver(IPosGraspRoadResultObserver iPosGraspRoadResultObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("removeGraspRoadResultObserver", IPosGraspRoadResultObserver.class);
            IPosGraspRoadResultObserverImpl iPosGraspRoadResultObserverImpl = null;
            if (iPosGraspRoadResultObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosGraspRoadResultObserverImpl = (IPosGraspRoadResultObserverImpl) typeHelper.transfer(method, 0, iPosGraspRoadResultObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removeGraspRoadResultObserver(iPosGraspRoadResultObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iPosGraspRoadResultObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addPosDiagnosisInfoObserver(IPosDiagnosisInfoObserver iPosDiagnosisInfoObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("addPosDiagnosisInfoObserver", IPosDiagnosisInfoObserver.class);
            IPosDiagnosisInfoObserverImpl iPosDiagnosisInfoObserverImpl = null;
            if (iPosDiagnosisInfoObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosDiagnosisInfoObserverImpl = (IPosDiagnosisInfoObserverImpl) typeHelper.transfer(method, 0, iPosDiagnosisInfoObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.addPosDiagnosisInfoObserver(iPosDiagnosisInfoObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removePosDiagnosisInfoObserver(IPosDiagnosisInfoObserver iPosDiagnosisInfoObserver) {
        TypeHelper typeHelper;
        try {
            Method method = PosService.class.getMethod("removePosDiagnosisInfoObserver", IPosDiagnosisInfoObserver.class);
            IPosDiagnosisInfoObserverImpl iPosDiagnosisInfoObserverImpl = null;
            if (iPosDiagnosisInfoObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPosDiagnosisInfoObserverImpl = (IPosDiagnosisInfoObserverImpl) typeHelper.transfer(method, 0, iPosDiagnosisInfoObserver);
            }
            IPosServiceImpl iPosServiceImpl = this.mControl;
            if (iPosServiceImpl != null) {
                iPosServiceImpl.removePosDiagnosisInfoObserver(iPosDiagnosisInfoObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iPosDiagnosisInfoObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
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

    public LocGPSHistory getGPSHistory() {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            return iPosServiceImpl.getGPSHistory();
        }
        return null;
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

    public void setDiagnosisSwitch(boolean z) {
        IPosServiceImpl iPosServiceImpl = this.mControl;
        if (iPosServiceImpl != null) {
            iPosServiceImpl.setDiagnosisSwitch(z);
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
            Iterator it6 = ((HashSet) typeHelper6.getBindSet("com.autonavi.gbl.pos.observer.IPosSensorParaObserver")).iterator();
            while (it6.hasNext()) {
                removeSensorParaObserver((IPosSensorParaObserver) it6.next());
            }
        }
        TypeHelper typeHelper7 = this.mTypeHelper;
        if (typeHelper7 != null) {
            Iterator it7 = ((HashSet) typeHelper7.getBindSet("com.autonavi.gbl.pos.observer.IPosDrInfoObserver")).iterator();
            while (it7.hasNext()) {
                removePosDrInfoObserver((IPosDrInfoObserver) it7.next());
            }
        }
        TypeHelper typeHelper8 = this.mTypeHelper;
        if (typeHelper8 != null) {
            Iterator it8 = ((HashSet) typeHelper8.getBindSet("com.autonavi.gbl.pos.observer.IPosAttitudeAngleObserver")).iterator();
            while (it8.hasNext()) {
                removeAttitudeAngleObserver((IPosAttitudeAngleObserver) it8.next());
            }
        }
        TypeHelper typeHelper9 = this.mTypeHelper;
        if (typeHelper9 != null) {
            Iterator it9 = ((HashSet) typeHelper9.getBindSet("com.autonavi.gbl.pos.observer.IPosGraspRoadResultObserver")).iterator();
            while (it9.hasNext()) {
                removeGraspRoadResultObserver((IPosGraspRoadResultObserver) it9.next());
            }
        }
        TypeHelper typeHelper10 = this.mTypeHelper;
        if (typeHelper10 != null) {
            Iterator it10 = ((HashSet) typeHelper10.getBindSet("com.autonavi.gbl.pos.observer.IPosDiagnosisInfoObserver")).iterator();
            while (it10.hasNext()) {
                removePosDiagnosisInfoObserver((IPosDiagnosisInfoObserver) it10.next());
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
