package com.autonavi.gbl.lane.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.option.RouteOption;
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
import com.autonavi.gbl.lane.model.LaneRenderScreen;
import com.autonavi.gbl.lane.model.LaneSRRangeFilterParam;
import com.autonavi.gbl.lane.model.LaneSideLineInfo;
import com.autonavi.gbl.lane.model.LaneSideLineStyle;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.lane.model.WarnInfos;
import com.autonavi.gbl.lane.router.LaneServicePlayerObserverRouter;
import com.autonavi.gbl.pos.model.LocSignData;
@IntfAuto(target = LaneServicePlayerObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILaneServicePlayerObserver {
    @Deprecated
    boolean onAutopilotData(AutopilotData autopilotData);

    @Deprecated
    boolean onCarHW(@LaneRenderScreen.LaneRenderScreen1 int i, CarHWInfo carHWInfo);

    @Deprecated
    boolean onCarStyle(@LaneRenderScreen.LaneRenderScreen1 int i, CarStyleInfo carStyleInfo);

    @Deprecated
    boolean onDecision(@LaneRenderScreen.LaneRenderScreen1 int i, Decision decision);

    @Deprecated
    boolean onDecisionDirectionStyle(@LaneRenderScreen.LaneRenderScreen1 int i, DecisionDirectionStyle decisionDirectionStyle);

    @Deprecated
    boolean onDecisionLineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, DecisionLineStyleInfo decisionLineStyleInfo);

    @Deprecated
    boolean onELKLineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, ELKLineInfo eLKLineInfo);

    @Deprecated
    boolean onELKLineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, ELKLineStyle eLKLineStyle);

    @Deprecated
    boolean onLDWLineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, LDWLineInfo lDWLineInfo);

    @Deprecated
    boolean onLDWLineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, LDWLineStyle lDWLineStyle);

    @Deprecated
    boolean onLKALineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, LKALineInfo lKALineInfo);

    @Deprecated
    boolean onLKALineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, LKALineStyle lKALineStyle);

    @Deprecated
    boolean onLaneChangeFocusing(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z);

    @Deprecated
    boolean onLaneSideLineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, LaneSideLineInfo laneSideLineInfo);

    @Deprecated
    boolean onLaneSideStyle(@LaneRenderScreen.LaneRenderScreen1 int i, LaneSideLineStyle laneSideLineStyle);

    @Deprecated
    boolean onLocSignData(LocSignData locSignData);

    @Deprecated
    boolean onOpenDynamicViewAngle(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z);

    @Deprecated
    boolean onOpenLCC(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z);

    @Deprecated
    boolean onOpenLNDSDataDownload(boolean z);

    boolean onPlayProgress(long j, long j2, String str, long j3, long j4);

    @Deprecated
    boolean onRequestRoute(RouteOption routeOption);

    @Deprecated
    boolean onSRObject(@LaneRenderScreen.LaneRenderScreen1 int i, SRObjects sRObjects);

    @Deprecated
    boolean onSRRangeFilterParam(@LaneRenderScreen.LaneRenderScreen1 int i, LaneSRRangeFilterParam laneSRRangeFilterParam);

    @Deprecated
    boolean onShowNaviLine(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z);

    @Deprecated
    boolean onShowNaviLineFishbone(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z);

    @Deprecated
    boolean onShowNaviLineOutline(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z);

    @Deprecated
    boolean onWarn(@LaneRenderScreen.LaneRenderScreen1 int i, WarnInfos warnInfos);
}
