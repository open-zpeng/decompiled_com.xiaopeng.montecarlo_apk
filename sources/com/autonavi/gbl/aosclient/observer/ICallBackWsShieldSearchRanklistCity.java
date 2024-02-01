package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistCityResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsShieldSearchRanklistCityRouter;
@IntfAuto(target = CallBackWsShieldSearchRanklistCityRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsShieldSearchRanklistCity {
    void onRecvAck(GWsShieldSearchRanklistCityResponseParam gWsShieldSearchRanklistCityResponseParam);
}
