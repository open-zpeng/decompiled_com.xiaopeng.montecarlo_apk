package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistPortalResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsShieldSearchRanklistPortalRouter;
@IntfAuto(target = CallBackWsShieldSearchRanklistPortalRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsShieldSearchRanklistPortal {
    void onRecvAck(GWsShieldSearchRanklistPortalResponseParam gWsShieldSearchRanklistPortalResponseParam);
}
