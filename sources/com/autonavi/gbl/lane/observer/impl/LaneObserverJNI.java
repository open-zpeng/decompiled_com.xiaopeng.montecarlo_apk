package com.autonavi.gbl.lane.observer.impl;

import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.lane.model.AnchorScaleTime;
import com.autonavi.gbl.lane.model.AutopilotData;
import com.autonavi.gbl.lane.model.CarHWInfo;
import com.autonavi.gbl.lane.model.CarStyleInfo;
import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.DecisionDirectionStyle;
import com.autonavi.gbl.lane.model.DecisionLineStyleInfo;
import com.autonavi.gbl.lane.model.ELKLineInfo;
import com.autonavi.gbl.lane.model.ELKLineStyle;
import com.autonavi.gbl.lane.model.LDWLineInfo;
import com.autonavi.gbl.lane.model.LDWLineStyle;
import com.autonavi.gbl.lane.model.LKALineInfo;
import com.autonavi.gbl.lane.model.LKALineStyle;
import com.autonavi.gbl.lane.model.LaneNaviCamera;
import com.autonavi.gbl.lane.model.LaneNaviCongestionInfo;
import com.autonavi.gbl.lane.model.LaneNaviStatus;
import com.autonavi.gbl.lane.model.LanePathTrafficEventInfo;
import com.autonavi.gbl.lane.model.LanePositionStatus;
import com.autonavi.gbl.lane.model.LaneRenderScreen;
import com.autonavi.gbl.lane.model.LaneResourceRequest;
import com.autonavi.gbl.lane.model.LaneResourceRequestFile;
import com.autonavi.gbl.lane.model.LaneResourceResponse;
import com.autonavi.gbl.lane.model.LaneSRRangeFilterParam;
import com.autonavi.gbl.lane.model.LaneSideLineInfo;
import com.autonavi.gbl.lane.model.LaneSideLineStyle;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.lane.model.TravelPoint;
import com.autonavi.gbl.lane.model.TurnBubbleInfo;
import com.autonavi.gbl.lane.model.WarnInfos;
import com.autonavi.gbl.pos.model.LocSignData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LaneObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_ILaneObserverImpl_onAnchorScaleChange(ILaneObserverImpl iLaneObserverImpl, @AnchorScaleTime.AnchorScaleTime1 int i) {
        iLaneObserverImpl.onAnchorScaleChange(i);
    }

    public static void SwigDirector_ILaneObserverImpl_onLanePositionStatus(ILaneObserverImpl iLaneObserverImpl, @LanePositionStatus.LanePositionStatus1 int i) {
        iLaneObserverImpl.onLanePositionStatus(i);
    }

    public static void SwigDirector_ILaneObserverImpl_onLaneNaviStatus(ILaneObserverImpl iLaneObserverImpl, @LaneNaviStatus.LaneNaviStatus1 int i) {
        iLaneObserverImpl.onLaneNaviStatus(i);
    }

    public static void SwigDirector_ILaneObserverImpl_onLaneNaviEnterPointDistance(ILaneObserverImpl iLaneObserverImpl, float f) {
        iLaneObserverImpl.onLaneNaviEnterPointDistance(f);
    }

    public static void SwigDirector_ILaneObserverImpl_onLaneLndsDataDistance(ILaneObserverImpl iLaneObserverImpl, float f) {
        iLaneObserverImpl.onLaneLndsDataDistance(f);
    }

    public static LaneResourceResponse SwigDirector_ILaneResourceProxyImpl_onRequestResource(ILaneResourceProxyImpl iLaneResourceProxyImpl, LaneResourceRequest laneResourceRequest) {
        return iLaneResourceProxyImpl.onRequestResource(laneResourceRequest);
    }

    public static LaneResourceResponse SwigDirector_ILaneResourceProxyImpl_onRequestResourceFile(ILaneResourceProxyImpl iLaneResourceProxyImpl, LaneResourceRequestFile laneResourceRequestFile) {
        return iLaneResourceProxyImpl.onRequestResourceFile(laneResourceRequestFile);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onPlayProgress(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j, long j2, String str, long j3, long j4) {
        return iLaneServicePlayerObserverImpl.onPlayProgress(j, j2, str, j3, j4);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onLocSignData(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, LocSignData locSignData) {
        return iLaneServicePlayerObserverImpl.onLocSignData(locSignData);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onSRObject(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, SRObjects sRObjects) {
        return iLaneServicePlayerObserverImpl.onSRObject(i, sRObjects);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onCarHW(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, CarHWInfo carHWInfo) {
        return iLaneServicePlayerObserverImpl.onCarHW(i, carHWInfo);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onCarStyle(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, CarStyleInfo carStyleInfo) {
        return iLaneServicePlayerObserverImpl.onCarStyle(i, carStyleInfo);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onDecisionLineStyle(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, DecisionLineStyleInfo decisionLineStyleInfo) {
        return iLaneServicePlayerObserverImpl.onDecisionLineStyle(i, decisionLineStyleInfo);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onDecisionDirectionStyle(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, DecisionDirectionStyle decisionDirectionStyle) {
        return iLaneServicePlayerObserverImpl.onDecisionDirectionStyle(i, decisionDirectionStyle);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onDecision(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, Decision decision) {
        return iLaneServicePlayerObserverImpl.onDecision(i, decision);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onWarn(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, WarnInfos warnInfos) {
        return iLaneServicePlayerObserverImpl.onWarn(i, warnInfos);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onOpenDynamicViewAngle(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        return iLaneServicePlayerObserverImpl.onOpenDynamicViewAngle(i, z);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onOpenLCC(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        return iLaneServicePlayerObserverImpl.onOpenLCC(i, z);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onOpenLNDSDataDownload(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, boolean z) {
        return iLaneServicePlayerObserverImpl.onOpenLNDSDataDownload(z);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onLaneSideStyle(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, LaneSideLineStyle laneSideLineStyle) {
        return iLaneServicePlayerObserverImpl.onLaneSideStyle(i, laneSideLineStyle);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onLaneSideLineInfo(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, LaneSideLineInfo laneSideLineInfo) {
        return iLaneServicePlayerObserverImpl.onLaneSideLineInfo(i, laneSideLineInfo);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onLKALineStyle(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, LKALineStyle lKALineStyle) {
        return iLaneServicePlayerObserverImpl.onLKALineStyle(i, lKALineStyle);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onLKALineInfo(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, LKALineInfo lKALineInfo) {
        return iLaneServicePlayerObserverImpl.onLKALineInfo(i, lKALineInfo);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onLDWLineStyle(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, LDWLineStyle lDWLineStyle) {
        return iLaneServicePlayerObserverImpl.onLDWLineStyle(i, lDWLineStyle);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onLDWLineInfo(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, LDWLineInfo lDWLineInfo) {
        return iLaneServicePlayerObserverImpl.onLDWLineInfo(i, lDWLineInfo);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onELKLineStyle(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, ELKLineStyle eLKLineStyle) {
        return iLaneServicePlayerObserverImpl.onELKLineStyle(i, eLKLineStyle);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onELKLineInfo(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, ELKLineInfo eLKLineInfo) {
        return iLaneServicePlayerObserverImpl.onELKLineInfo(i, eLKLineInfo);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onAutopilotData(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, AutopilotData autopilotData) {
        return iLaneServicePlayerObserverImpl.onAutopilotData(autopilotData);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onRequestRoute(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, IRouteOptionImpl iRouteOptionImpl) {
        return iLaneServicePlayerObserverImpl.onRequestRoute(iRouteOptionImpl);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onShowNaviLine(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        return iLaneServicePlayerObserverImpl.onShowNaviLine(i, z);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onShowNaviLineFishbone(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        return iLaneServicePlayerObserverImpl.onShowNaviLineFishbone(i, z);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onShowNaviLineOutline(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        return iLaneServicePlayerObserverImpl.onShowNaviLineOutline(i, z);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onLaneChangeFocusing(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        return iLaneServicePlayerObserverImpl.onLaneChangeFocusing(i, z);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onSRRangeFilterParam(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, @LaneRenderScreen.LaneRenderScreen1 int i, LaneSRRangeFilterParam laneSRRangeFilterParam) {
        return iLaneServicePlayerObserverImpl.onSRRangeFilterParam(i, laneSRRangeFilterParam);
    }

    public static void SwigDirector_ILaneNaviObserverImpl_onShowNaviCamera(ILaneNaviObserverImpl iLaneNaviObserverImpl, ArrayList<LaneNaviCamera> arrayList, int i) {
        iLaneNaviObserverImpl.onShowNaviCamera(arrayList, i);
    }

    public static void SwigDirector_ILaneNaviObserverImpl_onUpdateTMCCongestionInfo(ILaneNaviObserverImpl iLaneNaviObserverImpl, LaneNaviCongestionInfo laneNaviCongestionInfo, int i) {
        iLaneNaviObserverImpl.onUpdateTMCCongestionInfo(laneNaviCongestionInfo, i);
    }

    public static void SwigDirector_ILaneNaviObserverImpl_onUpdateTREvent(ILaneNaviObserverImpl iLaneNaviObserverImpl, LanePathTrafficEventInfo lanePathTrafficEventInfo, int i) {
        iLaneNaviObserverImpl.onUpdateTREvent(lanePathTrafficEventInfo, i);
    }

    public static void SwigDirector_ILaneNaviObserverImpl_onUpdateTurnBubbleInfo(ILaneNaviObserverImpl iLaneNaviObserverImpl, TurnBubbleInfo turnBubbleInfo) {
        iLaneNaviObserverImpl.onUpdateTurnBubbleInfo(turnBubbleInfo);
    }

    public static void SwigDirector_ILaneNaviObserverImpl_onUpdateTravelPointInfo(ILaneNaviObserverImpl iLaneNaviObserverImpl, ArrayList<TravelPoint> arrayList, int i) {
        iLaneNaviObserverImpl.onUpdateTravelPointInfo(arrayList, i);
    }
}
