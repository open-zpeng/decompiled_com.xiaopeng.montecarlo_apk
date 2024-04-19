package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.LndsNetWorkError;
import com.autonavi.gbl.data.router.LNDSDataVersionObserverRouter;
import java.math.BigInteger;
@IntfAuto(target = LNDSDataVersionObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILNDSDataVersionObserver {
    void onLNDSDataVersion(BigInteger bigInteger, @LndsNetWorkError.LndsNetWorkError1 int i, String str);
}
