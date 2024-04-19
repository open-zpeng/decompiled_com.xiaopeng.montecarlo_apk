package com.autonavi.gbl.pos.observer.impl;

import com.autonavi.gbl.pos.model.DrInfo;
import com.autonavi.gbl.pos.model.GraspRoadResult;
import com.autonavi.gbl.pos.model.LocInfo;
import com.autonavi.gbl.pos.model.LocMMFeedbackInfo;
import com.autonavi.gbl.pos.model.LocParallelRoadInfo;
import com.autonavi.gbl.pos.model.LocSignData;
import com.autonavi.gbl.pos.model.NgmDiff;
import com.autonavi.gbl.pos.model.RawAttitudeAngle;
/* loaded from: classes2.dex */
public class PosObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IPosLocInfoObserverImpl_onLocInfoUpdate(IPosLocInfoObserverImpl iPosLocInfoObserverImpl, LocInfo locInfo) {
        iPosLocInfoObserverImpl.onLocInfoUpdate(locInfo);
    }

    public static void SwigDirector_IPosParallelRoadObserverImpl_onParallelRoadUpdate(IPosParallelRoadObserverImpl iPosParallelRoadObserverImpl, LocParallelRoadInfo locParallelRoadInfo) {
        iPosParallelRoadObserverImpl.onParallelRoadUpdate(locParallelRoadInfo);
    }

    public static void SwigDirector_IPosSwitchParallelRoadObserverImpl_onSwitchParallelRoadFinished(IPosSwitchParallelRoadObserverImpl iPosSwitchParallelRoadObserverImpl) {
        iPosSwitchParallelRoadObserverImpl.onSwitchParallelRoadFinished();
    }

    public static void SwigDirector_IPosSignInfoObserverImpl_onSignInfoUpdate(IPosSignInfoObserverImpl iPosSignInfoObserverImpl, LocSignData locSignData) {
        iPosSignInfoObserverImpl.onSignInfoUpdate(locSignData);
    }

    public static void SwigDirector_IPosMapMatchFeedbackObserverImpl_onMapMatchFeedbackUpdate(IPosMapMatchFeedbackObserverImpl iPosMapMatchFeedbackObserverImpl, LocMMFeedbackInfo locMMFeedbackInfo) {
        iPosMapMatchFeedbackObserverImpl.onMapMatchFeedbackUpdate(locMMFeedbackInfo);
    }

    public static void SwigDirector_INgmInfoObserverImpl_onNgmInfoUpdate(INgmInfoObserverImpl iNgmInfoObserverImpl, NgmDiff ngmDiff) {
        iNgmInfoObserverImpl.onNgmInfoUpdate(ngmDiff);
    }

    public static void SwigDirector_IPosSensorParaObserverImpl_onSensorParaUpdate(IPosSensorParaObserverImpl iPosSensorParaObserverImpl, String str) {
        iPosSensorParaObserverImpl.onSensorParaUpdate(str);
    }

    public static void SwigDirector_IPosDrInfoObserverImpl_onDrInfoUpdate(IPosDrInfoObserverImpl iPosDrInfoObserverImpl, DrInfo drInfo) {
        iPosDrInfoObserverImpl.onDrInfoUpdate(drInfo);
    }

    public static void SwigDirector_IPosAttitudeAngleObserverImpl_onAttitudeAngleUpdate(IPosAttitudeAngleObserverImpl iPosAttitudeAngleObserverImpl, RawAttitudeAngle rawAttitudeAngle) {
        iPosAttitudeAngleObserverImpl.onAttitudeAngleUpdate(rawAttitudeAngle);
    }

    public static void SwigDirector_IPosGraspRoadResultObserverImpl_onGraspRoadResult(IPosGraspRoadResultObserverImpl iPosGraspRoadResultObserverImpl, GraspRoadResult graspRoadResult) {
        iPosGraspRoadResultObserverImpl.onGraspRoadResult(graspRoadResult);
    }
}
