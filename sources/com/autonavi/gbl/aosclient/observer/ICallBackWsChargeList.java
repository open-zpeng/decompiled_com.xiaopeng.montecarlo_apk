package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsChargeListResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsChargeListRouter;
@IntfAuto(target = CallBackWsChargeListRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsChargeList {
    void onRecvAck(GWsChargeListResponseParam gWsChargeListResponseParam);
}
