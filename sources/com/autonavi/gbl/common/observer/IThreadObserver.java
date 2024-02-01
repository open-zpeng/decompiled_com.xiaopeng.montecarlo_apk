package com.autonavi.gbl.common.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.router.ThreadObserverRouter;
@IntfAuto(target = ThreadObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IThreadObserver {
    void threadCallback(long j, byte b);
}
