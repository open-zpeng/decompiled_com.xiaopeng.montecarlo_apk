package com.autonavi.gbl.lane;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.impl.ILaneMockServiceImpl;
import com.autonavi.gbl.lane.impl.ILaneServiceImpl;
import com.autonavi.gbl.lane.impl.ILaneServicePlayerImpl;
import com.autonavi.gbl.lane.impl.ILaneServiceRecorderImpl;
import com.autonavi.gbl.lane.impl.ILaneServiceToolImpl;
import com.autonavi.gbl.lane.model.CarStyleInfo;
import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.DecisionDirectionStyle;
import com.autonavi.gbl.lane.model.DecisionLineStyleInfo;
import com.autonavi.gbl.lane.model.DynamicViewMode;
import com.autonavi.gbl.lane.model.LDWInfo;
import com.autonavi.gbl.lane.model.LDWLineStyleInfo;
import com.autonavi.gbl.lane.model.LaneCameraParam;
import com.autonavi.gbl.lane.model.LaneCameraParamType;
import com.autonavi.gbl.lane.model.LaneDynamicLevelType;
import com.autonavi.gbl.lane.model.LaneInitParam;
import com.autonavi.gbl.lane.model.LaneMapViewParam;
import com.autonavi.gbl.lane.model.LndsDataPriority;
import com.autonavi.gbl.lane.model.SRObjectRenderInfos;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.lane.model.WarnInfos;
import com.autonavi.gbl.lane.observer.ILaneObserver;
import com.autonavi.gbl.lane.observer.ILaneResourceProxy;
import com.autonavi.gbl.lane.observer.impl.ILaneObserverImpl;
import com.autonavi.gbl.lane.observer.impl.ILaneResourceProxyImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
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

    public LaneCameraParam getLaneCameraParam(@LaneCameraParamType.LaneCameraParamType1 int i) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.getLaneCameraParam(i);
        }
        return null;
    }

    public SRObjectRenderInfos getSRObjectRenderInfos() {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.getSRObjectRenderInfos();
        }
        return null;
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

    public boolean attachMapView(LaneMapViewParam laneMapViewParam) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.attachMapView(laneMapViewParam);
        }
        return false;
    }

    public boolean detachMapView() {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.detachMapView();
        }
        return false;
    }

    public boolean setResourceProxy(ILaneResourceProxy iLaneResourceProxy) {
        try {
            Method method = LaneService.class.getMethod("setResourceProxy", ILaneResourceProxy.class);
            if (iLaneResourceProxy != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILaneResourceProxyImpl) typeHelper.transfer(method, 0, iLaneResourceProxy) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $proxy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.1
                    }));
                    return false;
                }
            }
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null) {
                return iLaneServiceImpl.setResourceProxy(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean setSRObject(SRObjects sRObjects) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setSRObject(sRObjects);
        }
        return false;
    }

    public boolean setCarStyleInfo(CarStyleInfo carStyleInfo) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setCarStyleInfo(carStyleInfo);
        }
        return false;
    }

    public boolean setDecisionLineStyle(DecisionLineStyleInfo decisionLineStyleInfo) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setDecisionLineStyle(decisionLineStyleInfo);
        }
        return false;
    }

    public boolean setDecisionDirectionStyle(DecisionDirectionStyle decisionDirectionStyle) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setDecisionDirectionStyle(decisionDirectionStyle);
        }
        return false;
    }

    public boolean setDecision(Decision decision) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setDecision(decision);
        }
        return false;
    }

    public boolean setWarnInfo(WarnInfos warnInfos) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setWarnInfo(warnInfos);
        }
        return false;
    }

    public boolean setLDWLineStyle(LDWLineStyleInfo lDWLineStyleInfo) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setLDWLineStyle(lDWLineStyleInfo);
        }
        return false;
    }

    public boolean setLDWInfo(LDWInfo lDWInfo) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setLDWInfo(lDWInfo);
        }
        return false;
    }

    public boolean openDynamicViewAngle(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openDynamicViewAngle(z);
        }
        return false;
    }

    public boolean openTunnelViewAngle(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openTunnelViewAngle(z);
        }
        return false;
    }

    public boolean setDynamicViewMode(@DynamicViewMode.DynamicViewMode1 int i) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setDynamicViewMode(i);
        }
        return false;
    }

    public boolean openLCC(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openLCC(z);
        }
        return false;
    }

    public boolean openLNDSDataDownload(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openLNDSDataDownload(z);
        }
        return false;
    }

    public boolean openLaneWork(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openLaneWork(z);
        }
        return false;
    }

    public boolean enterLane(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.enterLane(z);
        }
        return false;
    }

    public boolean openShowOccpyLane(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openShowOccpyLane(z);
        }
        return false;
    }

    public boolean openNaviLine(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openNaviLine(z);
        }
        return false;
    }

    public boolean openNaviLineFishbone(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openNaviLineFishbone(z);
        }
        return false;
    }

    public boolean openNaviLineOutline(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openNaviLineOutline(z);
        }
        return false;
    }

    public boolean setNaviLineLength(float f) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setNaviLineLength(f);
        }
        return false;
    }

    public boolean openLaneCar(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openLaneCar(z);
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

    public boolean setPersonNum(int i) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setPersonNum(i);
        }
        return false;
    }

    public boolean openFollowMode(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openFollowMode(z);
        }
        return false;
    }

    public boolean openDynamicLevel(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openDynamicLevel(z);
        }
        return false;
    }

    public boolean openCarUpMode(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openCarUpMode(z);
        }
        return false;
    }

    public boolean lockPitchAngle(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.lockPitchAngle(z);
        }
        return false;
    }

    public boolean setLaneDynamicLevel(@LaneDynamicLevelType.LaneDynamicLevelType1 int i, float f) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setLaneDynamicLevel(i, f);
        }
        return false;
    }

    public boolean openCalcRoadPolygon(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openCalcRoadPolygon(z);
        }
        return false;
    }

    public boolean openShowRoadPolygon(boolean z) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.openShowRoadPolygon(z);
        }
        return false;
    }

    public boolean setLaneCameraParam(@LaneCameraParamType.LaneCameraParamType1 int i, LaneCameraParam laneCameraParam) {
        ILaneServiceImpl iLaneServiceImpl = this.mControl;
        if (iLaneServiceImpl != null) {
            return iLaneServiceImpl.setLaneCameraParam(i, laneCameraParam);
        }
        return false;
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

    public LaneServicePlayer getLaneServicePlayer() {
        ILaneServicePlayerImpl laneServicePlayer;
        try {
            Method method = LaneService.class.getMethod("getLaneServicePlayer", new Class[0]);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null && (laneServicePlayer = iLaneServiceImpl.getLaneServicePlayer()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (LaneServicePlayer) typeHelper.transfer(method, -1, (Object) laneServicePlayer, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.3
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

    public LaneMockService getLaneMockService() {
        ILaneMockServiceImpl laneMockService;
        try {
            Method method = LaneService.class.getMethod("getLaneMockService", new Class[0]);
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null && (laneMockService = iLaneServiceImpl.getLaneMockService()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (LaneMockService) typeHelper.transfer(method, -1, (Object) laneMockService, true) : null;
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

    public void addLaneObserver(ILaneObserver iLaneObserver) {
        try {
            Method method = LaneService.class.getMethod("addLaneObserver", ILaneObserver.class);
            if (iLaneObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILaneObserverImpl) typeHelper.transfer(method, 0, iLaneObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.6
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
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.7
                    }));
                }
            }
            ILaneServiceImpl iLaneServiceImpl = this.mControl;
            if (iLaneServiceImpl != null) {
                iLaneServiceImpl.removeLaneObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.8
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.9
        }));
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneService.10
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
