package com.autonavi.gbl.util.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.router.TimeSourceRouter;
@IntfAuto(target = TimeSourceRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ITimeSource {
    long getLocalTimeUS();

    long getTickCountUS();
}
