package com.autonavi.gbl.route.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.route.model.ChargingStationID;
import com.autonavi.gbl.route.router.ChargingStationIDObserverRouter;
import java.util.ArrayList;
@IntfAuto(target = ChargingStationIDObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IChargingStationIDObserver {
    void onChargingStationIDUpdated(ArrayList<ChargingStationID> arrayList);
}
