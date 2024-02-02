package com.autonavi.gbl.lane.observer.impl;

import com.autonavi.gbl.lane.model.CarHWInfo;
import com.autonavi.gbl.lane.model.CarStyleInfo;
import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.DecisionDirectionStyle;
import com.autonavi.gbl.lane.model.DecisionLineStyleInfo;
import com.autonavi.gbl.lane.model.LDWInfo;
import com.autonavi.gbl.lane.model.LDWLineStyleInfo;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.lane.model.WarnInfos;
import com.autonavi.gbl.pos.model.LocSignData;
/* loaded from: classes.dex */
public class LaneServicePlayerObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onPlayProgress(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j, long j2, String str, long j3, long j4) {
        return iLaneServicePlayerObserverImpl.onPlayProgress(j, j2, str, j3, j4);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onLocSignData(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, LocSignData locSignData) {
        return iLaneServicePlayerObserverImpl.onLocSignData(locSignData);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onSRObject(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, SRObjects sRObjects) {
        return iLaneServicePlayerObserverImpl.onSRObject(sRObjects);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onCarHW(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, CarHWInfo carHWInfo) {
        return iLaneServicePlayerObserverImpl.onCarHW(carHWInfo);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onCarStyle(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, CarStyleInfo carStyleInfo) {
        return iLaneServicePlayerObserverImpl.onCarStyle(carStyleInfo);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onDecisionLineStyle(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, DecisionLineStyleInfo decisionLineStyleInfo) {
        return iLaneServicePlayerObserverImpl.onDecisionLineStyle(decisionLineStyleInfo);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onDecisionDirectionStyle(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, DecisionDirectionStyle decisionDirectionStyle) {
        return iLaneServicePlayerObserverImpl.onDecisionDirectionStyle(decisionDirectionStyle);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onDecision(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, Decision decision) {
        return iLaneServicePlayerObserverImpl.onDecision(decision);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onWarn(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, WarnInfos warnInfos) {
        return iLaneServicePlayerObserverImpl.onWarn(warnInfos);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onLDWLineStyle(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, LDWLineStyleInfo lDWLineStyleInfo) {
        return iLaneServicePlayerObserverImpl.onLDWLineStyle(lDWLineStyleInfo);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onLDW(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, LDWInfo lDWInfo) {
        return iLaneServicePlayerObserverImpl.onLDW(lDWInfo);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onOpenDynamicViewAngle(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, boolean z) {
        return iLaneServicePlayerObserverImpl.onOpenDynamicViewAngle(z);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onOpenLCC(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, boolean z) {
        return iLaneServicePlayerObserverImpl.onOpenLCC(z);
    }

    public static boolean SwigDirector_ILaneServicePlayerObserverImpl_onOpenLNDSDataDownload(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, boolean z) {
        return iLaneServicePlayerObserverImpl.onOpenLNDSDataDownload(z);
    }
}
