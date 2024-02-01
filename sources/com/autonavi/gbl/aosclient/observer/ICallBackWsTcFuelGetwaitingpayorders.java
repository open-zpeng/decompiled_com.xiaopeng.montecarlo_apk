package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcFuelGetwaitingpayordersResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTcFuelGetwaitingpayordersRouter;
@IntfAuto(target = CallBackWsTcFuelGetwaitingpayordersRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTcFuelGetwaitingpayorders {
    void onRecvAck(GWsTcFuelGetwaitingpayordersResponseParam gWsTcFuelGetwaitingpayordersResponseParam);
}
