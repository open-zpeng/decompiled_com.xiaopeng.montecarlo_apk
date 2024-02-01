package com.autonavi.gbl.lane;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.impl.ILaneRenderServiceImpl;
import com.autonavi.gbl.lane.model.CarStyleInfo;
import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.DecisionDirectionStyle;
import com.autonavi.gbl.lane.model.DecisionLineStyleInfo;
import com.autonavi.gbl.lane.model.DynamicViewMode;
import com.autonavi.gbl.lane.model.ELKLineInfo;
import com.autonavi.gbl.lane.model.ELKLineStyle;
import com.autonavi.gbl.lane.model.LDWLineInfo;
import com.autonavi.gbl.lane.model.LDWLineStyle;
import com.autonavi.gbl.lane.model.LKALineInfo;
import com.autonavi.gbl.lane.model.LKALineStyle;
import com.autonavi.gbl.lane.model.LaneCameraParam;
import com.autonavi.gbl.lane.model.LaneCameraParamType;
import com.autonavi.gbl.lane.model.LaneDynamicLevelType;
import com.autonavi.gbl.lane.model.LaneLayerPriorityMode;
import com.autonavi.gbl.lane.model.LaneLayerType;
import com.autonavi.gbl.lane.model.LaneMapViewParam;
import com.autonavi.gbl.lane.model.LaneRenderInitParam;
import com.autonavi.gbl.lane.model.LaneRenderParamType;
import com.autonavi.gbl.lane.model.LaneSRRangeFilterParam;
import com.autonavi.gbl.lane.model.LaneSideLineInfo;
import com.autonavi.gbl.lane.model.LaneSideLineStyle;
import com.autonavi.gbl.lane.model.LaneTMCShowStatus;
import com.autonavi.gbl.lane.model.LaneViewRect;
import com.autonavi.gbl.lane.model.SRObjectRenderInfos;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.lane.model.WarnInfos;
import com.autonavi.gbl.lane.observer.ILaneResourceProxy;
import com.autonavi.gbl.lane.observer.impl.ILaneResourceProxyImpl;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
@IntfAuto(target = ILaneRenderServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class LaneRenderService {
    private static String PACKAGE = ReflexTool.PN(LaneRenderService.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private ILaneRenderServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected LaneRenderService(long j, boolean z) {
        this(new ILaneRenderServiceImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LaneRenderService.class, this, this.mControl);
        }
    }

    public LaneRenderService(ILaneRenderServiceImpl iLaneRenderServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iLaneRenderServiceImpl);
    }

    private void $constructor(ILaneRenderServiceImpl iLaneRenderServiceImpl) {
        if (iLaneRenderServiceImpl != null) {
            this.mControl = iLaneRenderServiceImpl;
            this.mTargetId = String.format("LaneRenderService_%s_%d", String.valueOf(ILaneRenderServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ILaneRenderServiceImpl getControl() {
        return this.mControl;
    }

    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    @Deprecated
    public static String getEngineVersion() {
        return ILaneRenderServiceImpl.getEngineVersion();
    }

    public boolean init(LaneRenderInitParam laneRenderInitParam) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.init(laneRenderInitParam);
        }
        return false;
    }

    public void unInit() {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            iLaneRenderServiceImpl.unInit();
        }
    }

    public boolean attachMapView(LaneMapViewParam laneMapViewParam) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.attachMapView(laneMapViewParam);
        }
        return false;
    }

    public boolean detachMapView() {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.detachMapView();
        }
        return false;
    }

    public boolean setResourceProxy(ILaneResourceProxy iLaneResourceProxy) {
        TypeHelper typeHelper;
        try {
            Method method = LaneRenderService.class.getMethod("setResourceProxy", ILaneResourceProxy.class);
            ILaneResourceProxyImpl iLaneResourceProxyImpl = null;
            if (iLaneResourceProxy != null && (typeHelper = this.mTypeHelper) != null) {
                iLaneResourceProxyImpl = (ILaneResourceProxyImpl) typeHelper.transfer(method, 0, iLaneResourceProxy);
            }
            ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
            if (iLaneRenderServiceImpl != null) {
                return iLaneRenderServiceImpl.setResourceProxy(iLaneResourceProxyImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean setSRObject(SRObjects sRObjects) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setSRObject(sRObjects);
        }
        return false;
    }

    public boolean setCarStyleInfo(CarStyleInfo carStyleInfo) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setCarStyleInfo(carStyleInfo);
        }
        return false;
    }

    public boolean setDecisionLineStyle(DecisionLineStyleInfo decisionLineStyleInfo) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setDecisionLineStyle(decisionLineStyleInfo);
        }
        return false;
    }

    public boolean setDecisionDirectionStyle(DecisionDirectionStyle decisionDirectionStyle) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setDecisionDirectionStyle(decisionDirectionStyle);
        }
        return false;
    }

    public boolean setDecision(Decision decision) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setDecision(decision);
        }
        return false;
    }

    public boolean setWarnInfo(WarnInfos warnInfos) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setWarnInfo(warnInfos);
        }
        return false;
    }

    public boolean setLaneSideStyle(LaneSideLineStyle laneSideLineStyle) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setLaneSideStyle(laneSideLineStyle);
        }
        return false;
    }

    public boolean setLaneSideLineInfo(LaneSideLineInfo laneSideLineInfo) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setLaneSideLineInfo(laneSideLineInfo);
        }
        return false;
    }

    @Deprecated
    public boolean setLDWLineStyle(LDWLineStyle lDWLineStyle) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setLDWLineStyle(lDWLineStyle);
        }
        return false;
    }

    @Deprecated
    public boolean setLDWLineInfo(LDWLineInfo lDWLineInfo) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setLDWLineInfo(lDWLineInfo);
        }
        return false;
    }

    @Deprecated
    public boolean setLKALineStyle(LKALineStyle lKALineStyle) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setLKALineStyle(lKALineStyle);
        }
        return false;
    }

    @Deprecated
    public boolean setLKALineInfo(LKALineInfo lKALineInfo) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setLKALineInfo(lKALineInfo);
        }
        return false;
    }

    @Deprecated
    public boolean setELKLineStyle(ELKLineStyle eLKLineStyle) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setELKLineStyle(eLKLineStyle);
        }
        return false;
    }

    @Deprecated
    public boolean setELKLineInfo(ELKLineInfo eLKLineInfo) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setELKLineInfo(eLKLineInfo);
        }
        return false;
    }

    public boolean openDynamicViewAngle(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.openDynamicViewAngle(z);
        }
        return false;
    }

    public boolean setDynamicViewMode(@DynamicViewMode.DynamicViewMode1 int i) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setDynamicViewMode(i);
        }
        return false;
    }

    public boolean openLCC(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.openLCC(z);
        }
        return false;
    }

    @Deprecated
    public boolean openLaneCar(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.openLaneCar(z);
        }
        return false;
    }

    @Deprecated
    public boolean openNaviLine(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.openNaviLine(z);
        }
        return false;
    }

    @Deprecated
    public boolean openNaviLineFishbone(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.openNaviLineFishbone(z);
        }
        return false;
    }

    @Deprecated
    public boolean openNaviLineOutline(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.openNaviLineOutline(z);
        }
        return false;
    }

    @Deprecated
    public boolean setNaviLineLength(float f) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setNaviLineLength(f);
        }
        return false;
    }

    public boolean openShowRoadPolygon(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.openShowRoadPolygon(z);
        }
        return false;
    }

    public boolean setTMCShowStatus(@LaneTMCShowStatus.LaneTMCShowStatus1 int i) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setTMCShowStatus(i);
        }
        return false;
    }

    public boolean openLaneChangeFocusing(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.openLaneChangeFocusing(z);
        }
        return false;
    }

    public boolean enterLane(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.enterLane(z);
        }
        return false;
    }

    public boolean openFollowMode(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.openFollowMode(z);
        }
        return false;
    }

    public boolean openDynamicLevel(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.openDynamicLevel(z);
        }
        return false;
    }

    public boolean openCarUpMode(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.openCarUpMode(z);
        }
        return false;
    }

    public boolean lockPitchAngle(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.lockPitchAngle(z);
        }
        return false;
    }

    public boolean setLaneDynamicLevel(@LaneDynamicLevelType.LaneDynamicLevelType1 int i, float f) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setLaneDynamicLevel(i, f);
        }
        return false;
    }

    public boolean setLaneDynamicLevelSpeedThreshold(float f) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setLaneDynamicLevelSpeedThreshold(f);
        }
        return false;
    }

    public boolean setSRRangeFilterParam(LaneSRRangeFilterParam laneSRRangeFilterParam) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setSRRangeFilterParam(laneSRRangeFilterParam);
        }
        return false;
    }

    public boolean setLaneLogicViewRect(LaneViewRect laneViewRect) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setLaneLogicViewRect(laneViewRect);
        }
        return false;
    }

    public boolean openSRRangeFilter(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.openSRRangeFilter(z);
        }
        return false;
    }

    public boolean openStaticObjectStay(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.openStaticObjectStay(z);
        }
        return false;
    }

    public boolean setLaneCameraParam(@LaneCameraParamType.LaneCameraParamType1 int i, LaneCameraParam laneCameraParam) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setLaneCameraParam(i, laneCameraParam);
        }
        return false;
    }

    public LaneCameraParam getLaneCameraParam(@LaneCameraParamType.LaneCameraParamType1 int i) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.getLaneCameraParam(i);
        }
        return null;
    }

    public SRObjectRenderInfos getSRObjectRenderInfos() {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.getSRObjectRenderInfos();
        }
        return null;
    }

    @Deprecated
    public boolean setLaneLayerVisible(@LaneLayerType.LaneLayerType1 int i, boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setLaneLayerVisible(i, z);
        }
        return false;
    }

    @Deprecated
    public boolean setLaneLayerPriorityMode(@LaneLayerPriorityMode.LaneLayerPriorityMode1 int i) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setLaneLayerPriorityMode(i);
        }
        return false;
    }

    @Deprecated
    public boolean openLaneCameraModel(boolean z) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.openLaneCameraModel(z);
        }
        return false;
    }

    public int setParam(@LaneRenderParamType.LaneRenderParamType1 int i, String str) {
        ILaneRenderServiceImpl iLaneRenderServiceImpl = this.mControl;
        if (iLaneRenderServiceImpl != null) {
            return iLaneRenderServiceImpl.setParam(i, str);
        }
        return Integer.MIN_VALUE;
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
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
