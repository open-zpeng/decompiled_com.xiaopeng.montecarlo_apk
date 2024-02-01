package com.autonavi.gbl.guide.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.CruiseEventInfo;
import com.autonavi.gbl.guide.model.CruiseFacilityInfo;
import com.autonavi.gbl.guide.model.CruiseInfo;
import com.autonavi.gbl.guide.model.CruisePredictiveLaneInfo;
import com.autonavi.gbl.guide.model.CruiseTimeAndDist;
import com.autonavi.gbl.guide.model.LaneInfo;
import com.autonavi.gbl.guide.model.SocolEventInfo;
import com.autonavi.gbl.guide.router.CruiseObserverRouter;
import java.util.ArrayList;
@IntfAuto(target = CruiseObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICruiseObserver {
    default void onHideCruiseLaneInfo() {
    }

    default void onHideCruisePredictiveLaneInfo() {
    }

    default void onShowCruiseLaneInfo(LaneInfo laneInfo) {
    }

    default void onShowCruisePredictiveLaneInfo(CruisePredictiveLaneInfo cruisePredictiveLaneInfo) {
    }

    default void onUpdateCruiseCongestionInfo(CruiseCongestionInfo cruiseCongestionInfo) {
    }

    default void onUpdateCruiseEvent(CruiseEventInfo cruiseEventInfo) {
    }

    default void onUpdateCruiseFacility(ArrayList<CruiseFacilityInfo> arrayList) {
    }

    default void onUpdateCruiseInfo(CruiseInfo cruiseInfo) {
    }

    default void onUpdateCruiseSocolEvent(SocolEventInfo socolEventInfo) {
    }

    default void onUpdateCruiseTimeAndDist(CruiseTimeAndDist cruiseTimeAndDist) {
    }

    default void onUpdateElecCameraInfo(ArrayList<CruiseFacilityInfo> arrayList) {
    }
}
