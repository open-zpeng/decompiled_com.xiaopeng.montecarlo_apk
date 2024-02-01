package com.autonavi.gbl.ehp.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.ehp.router.EHPOutputObserverRouter;
@IntfAuto(target = EHPOutputObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IEHPOutputObserver {
    void output(String str, byte[] bArr);
}
