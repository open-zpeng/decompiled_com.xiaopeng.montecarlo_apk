package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.AnmCallbackParam;
import com.autonavi.gbl.map.router.AnimationObserverRouter;
@IntfAuto(target = AnimationObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IAnimationObserver {
    void processMapAnimationFinished(long j, AnmCallbackParam anmCallbackParam);
}
