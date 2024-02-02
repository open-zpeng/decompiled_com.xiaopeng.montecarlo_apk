package com.autonavi.gbl.lane.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.CarHWInfo;
import com.autonavi.gbl.lane.model.CarStyleInfo;
import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.DecisionDirectionStyle;
import com.autonavi.gbl.lane.model.DecisionLineStyleInfo;
import com.autonavi.gbl.lane.model.LDWInfo;
import com.autonavi.gbl.lane.model.LDWLineStyleInfo;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.lane.model.WarnInfos;
import com.autonavi.gbl.lane.router.LaneServicePlayerObserverRouter;
import com.autonavi.gbl.pos.model.LocSignData;
@IntfAuto(target = LaneServicePlayerObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILaneServicePlayerObserver {
    boolean onCarHW(CarHWInfo carHWInfo);

    boolean onCarStyle(CarStyleInfo carStyleInfo);

    boolean onDecision(Decision decision);

    boolean onDecisionDirectionStyle(DecisionDirectionStyle decisionDirectionStyle);

    boolean onDecisionLineStyle(DecisionLineStyleInfo decisionLineStyleInfo);

    boolean onLDW(LDWInfo lDWInfo);

    boolean onLDWLineStyle(LDWLineStyleInfo lDWLineStyleInfo);

    boolean onLocSignData(LocSignData locSignData);

    boolean onOpenDynamicViewAngle(boolean z);

    boolean onOpenLCC(boolean z);

    boolean onOpenLNDSDataDownload(boolean z);

    boolean onPlayProgress(long j, long j2, String str, long j3, long j4);

    boolean onSRObject(SRObjects sRObjects);

    boolean onWarn(WarnInfos warnInfos);
}
