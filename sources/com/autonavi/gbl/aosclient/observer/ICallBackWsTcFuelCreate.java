package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcFuelCreateResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTcFuelCreateRouter;
@IntfAuto(target = CallBackWsTcFuelCreateRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTcFuelCreate {
    void onRecvAck(GWsTcFuelCreateResponseParam gWsTcFuelCreateResponseParam);
}
