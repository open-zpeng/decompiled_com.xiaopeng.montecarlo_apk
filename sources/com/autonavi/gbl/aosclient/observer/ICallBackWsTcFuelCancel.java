package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcFuelCancelResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTcFuelCancelRouter;
@IntfAuto(target = CallBackWsTcFuelCancelRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTcFuelCancel {
    void onRecvAck(GWsTcFuelCancelResponseParam gWsTcFuelCancelResponseParam);
}
