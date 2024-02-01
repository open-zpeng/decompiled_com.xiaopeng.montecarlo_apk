package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.LNDSNearCityInfo;
import com.autonavi.gbl.data.model.LndsNetWorkError;
import com.autonavi.gbl.data.router.LNDSNearCityListObserverRouter;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = LNDSNearCityListObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILNDSNearCityListObserver {
    boolean onNearCityRequestError(BigInteger bigInteger, @LndsNetWorkError.LndsNetWorkError1 int i);

    boolean onNearCityRequestSuccess(BigInteger bigInteger, ArrayList<LNDSNearCityInfo> arrayList);
}
