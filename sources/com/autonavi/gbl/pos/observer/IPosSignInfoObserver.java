package com.autonavi.gbl.pos.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.model.LocSignData;
import com.autonavi.gbl.pos.router.PosSignInfoObserverRouter;
@IntfAuto(target = PosSignInfoObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPosSignInfoObserver {
    void onSignInfoUpdate(LocSignData locSignData);
}
