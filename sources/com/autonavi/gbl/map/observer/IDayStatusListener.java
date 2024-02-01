package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.DAY_STATUS;
import com.autonavi.gbl.map.router.DayStatusListenerRouter;
@IntfAuto(target = DayStatusListenerRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IDayStatusListener {
    boolean onDayStatus(@DAY_STATUS.DAY_STATUS1 int i);
}
