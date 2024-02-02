package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.LNDS_NETWORK_ERROR;
import com.autonavi.gbl.data.router.LNDSDataVersionObserverRouter;
import java.math.BigInteger;
@IntfAuto(target = LNDSDataVersionObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILNDSDataVersionObserver {
    void onLNDSDataVersion(BigInteger bigInteger, @LNDS_NETWORK_ERROR.LNDS_NETWORK_ERROR1 int i, String str);
}
