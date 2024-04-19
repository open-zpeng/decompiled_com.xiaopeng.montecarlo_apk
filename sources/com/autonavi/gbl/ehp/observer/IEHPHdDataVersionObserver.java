package com.autonavi.gbl.ehp.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.ehp.router.EHPHdDataVersionObserverRouter;
@IntfAuto(target = EHPHdDataVersionObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IEHPHdDataVersionObserver {
    void onHdDataVersion(String str);
}
