package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.map.router.DayStatusSystemUtilRouter;
import com.autonavi.gbl.util.model.DateTime;
@IntfAuto(target = DayStatusSystemUtilRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IDayStatusSystemUtil {
    boolean getDateTime(DateTime dateTime);

    Coord2DDouble getLonLat();
}
