package com.autonavi.gbl.guide.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.CruiseEventInfo;
import com.autonavi.gbl.guide.model.CruiseFacilityInfo;
import com.autonavi.gbl.guide.model.CruiseInfo;
import com.autonavi.gbl.guide.model.CruiseTimeAndDist;
import com.autonavi.gbl.guide.model.LaneInfo;
import com.autonavi.gbl.guide.model.SocolEventInfo;
import com.autonavi.gbl.guide.router.CruiseObserverRouter;
import java.util.ArrayList;
@IntfAuto(target = CruiseObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICruiseObserver {
    void onHideCruiseLaneInfo();

    void onShowCruiseLaneInfo(LaneInfo laneInfo);

    void onUpdateCruiseCongestionInfo(CruiseCongestionInfo cruiseCongestionInfo);

    void onUpdateCruiseEvent(CruiseEventInfo cruiseEventInfo);

    void onUpdateCruiseFacility(ArrayList<CruiseFacilityInfo> arrayList);

    void onUpdateCruiseInfo(CruiseInfo cruiseInfo);

    void onUpdateCruiseSocolEvent(SocolEventInfo socolEventInfo);

    void onUpdateCruiseTimeAndDist(CruiseTimeAndDist cruiseTimeAndDist);

    void onUpdateElecCameraInfo(ArrayList<CruiseFacilityInfo> arrayList);
}
