package com.autonavi.gbl.lane.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.lane.LaneRenderService;
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
import com.autonavi.gbl.lane.model.LaneSRRangeFilterParam;
import com.autonavi.gbl.lane.model.LaneSideLineInfo;
import com.autonavi.gbl.lane.model.LaneSideLineStyle;
import com.autonavi.gbl.lane.model.SRObjectRenderInfos;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.lane.model.WarnInfos;
import com.autonavi.gbl.lane.observer.impl.ILaneResourceProxyImpl;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = LaneRenderService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneRenderServiceImpl {
    private static BindTable BIND_TABLE = new BindTable(ILaneRenderServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean attachMapViewNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, LaneMapViewParam laneMapViewParam);

    private static native void destroyNativeObj(long j);

    private static native boolean detachMapViewNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl);

    private static native boolean enterLaneNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native String getEngineVersionNative();

    private static native boolean getLaneCameraParamNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, int i, long j2, LaneCameraParam laneCameraParam);

    private static native boolean getSRObjectRenderInfosNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, SRObjectRenderInfos sRObjectRenderInfos);

    private static native boolean initNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, LaneRenderInitParam laneRenderInitParam);

    private static native int isInitNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl);

    private static native boolean lockPitchAngleNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean openCarUpModeNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean openDynamicLevelNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean openDynamicViewAngleNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean openFollowModeNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean openLCCNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean openLaneCameraModelNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean openLaneCarNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean openLaneChangeFocusingNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean openNaviLineFishboneNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean openNaviLineNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean openNaviLineOutlineNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean openSRRangeFilterNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean openShowRoadPolygonNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean openStaticObjectStayNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, boolean z);

    private static native boolean setCarStyleInfoNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, CarStyleInfo carStyleInfo);

    private static native boolean setDecisionDirectionStyleNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, DecisionDirectionStyle decisionDirectionStyle);

    private static native boolean setDecisionLineStyleNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, DecisionLineStyleInfo decisionLineStyleInfo);

    private static native boolean setDecisionNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, Decision decision);

    private static native boolean setDynamicViewModeNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, int i);

    private static native boolean setELKLineInfoNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, ELKLineInfo eLKLineInfo);

    private static native boolean setELKLineStyleNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, ELKLineStyle eLKLineStyle);

    private static native boolean setLDWLineInfoNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, LDWLineInfo lDWLineInfo);

    private static native boolean setLDWLineStyleNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, LDWLineStyle lDWLineStyle);

    private static native boolean setLKALineInfoNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, LKALineInfo lKALineInfo);

    private static native boolean setLKALineStyleNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, LKALineStyle lKALineStyle);

    private static native boolean setLaneCameraParamNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, int i, long j2, LaneCameraParam laneCameraParam);

    private static native boolean setLaneDynamicLevelNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, int i, float f);

    private static native boolean setLaneDynamicLevelSpeedThresholdNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, float f);

    private static native boolean setLaneLayerPriorityModeNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, int i);

    private static native boolean setLaneLayerVisibleNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, int i, boolean z);

    private static native boolean setLaneSideLineInfoNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, LaneSideLineInfo laneSideLineInfo);

    private static native boolean setLaneSideStyleNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, LaneSideLineStyle laneSideLineStyle);

    private static native boolean setNaviLineLengthNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, float f);

    private static native boolean setResourceProxyNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, ILaneResourceProxyImpl iLaneResourceProxyImpl);

    private static native boolean setSRObjectNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, SRObjects sRObjects);

    private static native boolean setSRRangeFilterParamNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, LaneSRRangeFilterParam laneSRRangeFilterParam);

    private static native boolean setWarnInfoNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl, long j2, WarnInfos warnInfos);

    private static native void unInitNative(long j, ILaneRenderServiceImpl iLaneRenderServiceImpl);

    public ILaneRenderServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILaneRenderServiceImpl) && getUID(this) == getUID((ILaneRenderServiceImpl) obj);
    }

    private static long getUID(ILaneRenderServiceImpl iLaneRenderServiceImpl) {
        long cPtr = getCPtr(iLaneRenderServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILaneRenderServiceImpl iLaneRenderServiceImpl) {
        if (iLaneRenderServiceImpl == null) {
            return 0L;
        }
        return iLaneRenderServiceImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
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

    public LaneCameraParam getLaneCameraParam(@LaneCameraParamType.LaneCameraParamType1 int i) {
        LaneCameraParam laneCameraParam = new LaneCameraParam();
        if (getLaneCameraParam(i, laneCameraParam)) {
            return laneCameraParam;
        }
        return null;
    }

    public SRObjectRenderInfos getSRObjectRenderInfos() {
        SRObjectRenderInfos sRObjectRenderInfos = new SRObjectRenderInfos();
        if (getSRObjectRenderInfos(sRObjectRenderInfos)) {
            return sRObjectRenderInfos;
        }
        return null;
    }

    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public static String getEngineVersion() {
        return getEngineVersionNative();
    }

    public boolean init(LaneRenderInitParam laneRenderInitParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, laneRenderInitParam);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    public boolean attachMapView(LaneMapViewParam laneMapViewParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return attachMapViewNative(j, this, 0L, laneMapViewParam);
    }

    public boolean detachMapView() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return detachMapViewNative(j, this);
    }

    public boolean setResourceProxy(ILaneResourceProxyImpl iLaneResourceProxyImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setResourceProxyNative(j, this, ILaneResourceProxyImpl.getCPtr(iLaneResourceProxyImpl), iLaneResourceProxyImpl);
    }

    public boolean setSRObject(SRObjects sRObjects) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setSRObjectNative(j, this, 0L, sRObjects);
    }

    public boolean setCarStyleInfo(CarStyleInfo carStyleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setCarStyleInfoNative(j, this, 0L, carStyleInfo);
    }

    public boolean setDecisionLineStyle(DecisionLineStyleInfo decisionLineStyleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setDecisionLineStyleNative(j, this, 0L, decisionLineStyleInfo);
    }

    public boolean setDecisionDirectionStyle(DecisionDirectionStyle decisionDirectionStyle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setDecisionDirectionStyleNative(j, this, 0L, decisionDirectionStyle);
    }

    public boolean setDecision(Decision decision) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setDecisionNative(j, this, 0L, decision);
    }

    public boolean setWarnInfo(WarnInfos warnInfos) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setWarnInfoNative(j, this, 0L, warnInfos);
    }

    public boolean setLaneSideStyle(LaneSideLineStyle laneSideLineStyle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLaneSideStyleNative(j, this, 0L, laneSideLineStyle);
    }

    public boolean setLaneSideLineInfo(LaneSideLineInfo laneSideLineInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLaneSideLineInfoNative(j, this, 0L, laneSideLineInfo);
    }

    public boolean setLDWLineStyle(LDWLineStyle lDWLineStyle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLDWLineStyleNative(j, this, 0L, lDWLineStyle);
    }

    public boolean setLDWLineInfo(LDWLineInfo lDWLineInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLDWLineInfoNative(j, this, 0L, lDWLineInfo);
    }

    public boolean setLKALineStyle(LKALineStyle lKALineStyle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLKALineStyleNative(j, this, 0L, lKALineStyle);
    }

    public boolean setLKALineInfo(LKALineInfo lKALineInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLKALineInfoNative(j, this, 0L, lKALineInfo);
    }

    public boolean setELKLineStyle(ELKLineStyle eLKLineStyle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setELKLineStyleNative(j, this, 0L, eLKLineStyle);
    }

    public boolean setELKLineInfo(ELKLineInfo eLKLineInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setELKLineInfoNative(j, this, 0L, eLKLineInfo);
    }

    public boolean openDynamicViewAngle(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openDynamicViewAngleNative(j, this, z);
    }

    public boolean setDynamicViewMode(@DynamicViewMode.DynamicViewMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setDynamicViewModeNative(j, this, i);
    }

    public boolean openLCC(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openLCCNative(j, this, z);
    }

    public boolean openLaneCar(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openLaneCarNative(j, this, z);
    }

    public boolean openNaviLine(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openNaviLineNative(j, this, z);
    }

    public boolean openNaviLineFishbone(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openNaviLineFishboneNative(j, this, z);
    }

    public boolean openNaviLineOutline(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openNaviLineOutlineNative(j, this, z);
    }

    public boolean setNaviLineLength(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setNaviLineLengthNative(j, this, f);
    }

    public boolean openShowRoadPolygon(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openShowRoadPolygonNative(j, this, z);
    }

    public boolean openLaneChangeFocusing(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openLaneChangeFocusingNative(j, this, z);
    }

    public boolean enterLane(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return enterLaneNative(j, this, z);
    }

    public boolean openFollowMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openFollowModeNative(j, this, z);
    }

    public boolean openDynamicLevel(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openDynamicLevelNative(j, this, z);
    }

    public boolean openCarUpMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openCarUpModeNative(j, this, z);
    }

    public boolean lockPitchAngle(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return lockPitchAngleNative(j, this, z);
    }

    public boolean setLaneDynamicLevel(@LaneDynamicLevelType.LaneDynamicLevelType1 int i, float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLaneDynamicLevelNative(j, this, i, f);
    }

    public boolean setLaneDynamicLevelSpeedThreshold(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLaneDynamicLevelSpeedThresholdNative(j, this, f);
    }

    public boolean setSRRangeFilterParam(LaneSRRangeFilterParam laneSRRangeFilterParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setSRRangeFilterParamNative(j, this, 0L, laneSRRangeFilterParam);
    }

    public boolean openSRRangeFilter(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openSRRangeFilterNative(j, this, z);
    }

    public boolean openStaticObjectStay(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openStaticObjectStayNative(j, this, z);
    }

    public boolean setLaneCameraParam(@LaneCameraParamType.LaneCameraParamType1 int i, LaneCameraParam laneCameraParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLaneCameraParamNative(j, this, i, 0L, laneCameraParam);
    }

    private boolean getLaneCameraParam(@LaneCameraParamType.LaneCameraParamType1 int i, LaneCameraParam laneCameraParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLaneCameraParamNative(j, this, i, 0L, laneCameraParam);
    }

    private boolean getSRObjectRenderInfos(SRObjectRenderInfos sRObjectRenderInfos) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSRObjectRenderInfosNative(j, this, 0L, sRObjectRenderInfos);
    }

    public boolean setLaneLayerVisible(@LaneLayerType.LaneLayerType1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLaneLayerVisibleNative(j, this, i, z);
    }

    public boolean setLaneLayerPriorityMode(@LaneLayerPriorityMode.LaneLayerPriorityMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLaneLayerPriorityModeNative(j, this, i);
    }

    public boolean openLaneCameraModel(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openLaneCameraModelNative(j, this, z);
    }
}
