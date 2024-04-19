package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.router.MapRunnableRouter;
@IntfAuto(target = MapRunnableRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IMapRunnable {
    void run();
}
