package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.LNDSNearCityInfo;
import com.autonavi.gbl.data.model.LNDS_NETWORK_ERROR;
import com.autonavi.gbl.data.router.LNDSNearCityListObserverRouter;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = LNDSNearCityListObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILNDSNearCityListObserver {
    boolean onNearCityRequestError(BigInteger bigInteger, @LNDS_NETWORK_ERROR.LNDS_NETWORK_ERROR1 int i);

    boolean onNearCityRequestSuccess(BigInteger bigInteger, ArrayList<LNDSNearCityInfo> arrayList);
}
