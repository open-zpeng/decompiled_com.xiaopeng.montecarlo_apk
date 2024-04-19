package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistLandingResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsShieldSearchRanklistLandingRouter;
@IntfAuto(target = CallBackWsShieldSearchRanklistLandingRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsShieldSearchRanklistLanding {
    void onRecvAck(GWsShieldSearchRanklistLandingResponseParam gWsShieldSearchRanklistLandingResponseParam);
}
