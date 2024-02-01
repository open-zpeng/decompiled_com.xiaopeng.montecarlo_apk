package com.autonavi.gbl.recorder.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.recorder.model.PlayProgress;
import com.autonavi.gbl.recorder.router.PlayerObserverRouter;
@IntfAuto(target = PlayerObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPlayerObserver {
    void onPlayProgress(PlayProgress playProgress);
}
