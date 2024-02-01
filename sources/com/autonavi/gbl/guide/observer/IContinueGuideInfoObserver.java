package com.autonavi.gbl.guide.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.guide.router.ContinueGuideInfoObserverRouter;
@IntfAuto(target = ContinueGuideInfoObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IContinueGuideInfoObserver {
    default void continueGuideStartNotify() {
    }

    default void exitContinueGuideNotify() {
    }
}
