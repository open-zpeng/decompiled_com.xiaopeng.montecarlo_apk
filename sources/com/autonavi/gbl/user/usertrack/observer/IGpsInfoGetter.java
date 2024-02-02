package com.autonavi.gbl.user.usertrack.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.user.router.GpsInfoGetterRouter;
import com.autonavi.gbl.user.usertrack.model.GpsTrackPoint;
@IntfAuto(target = GpsInfoGetterRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGpsInfoGetter {
    GpsTrackPoint getGpsTrackPoint();
}
