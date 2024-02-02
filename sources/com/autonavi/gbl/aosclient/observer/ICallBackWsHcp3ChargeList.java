package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsHcp3ChargeListResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsHcp3ChargeListRouter;
@IntfAuto(target = CallBackWsHcp3ChargeListRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsHcp3ChargeList {
    void onRecvAck(GWsHcp3ChargeListResponseParam gWsHcp3ChargeListResponseParam);
}
