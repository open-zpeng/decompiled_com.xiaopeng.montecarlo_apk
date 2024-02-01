package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcKoubeiOrderSubmitResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTcKoubeiOrderSubmitRouter;
@IntfAuto(target = CallBackWsTcKoubeiOrderSubmitRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTcKoubeiOrderSubmit {
    void onRecvAck(GWsTcKoubeiOrderSubmitResponseParam gWsTcKoubeiOrderSubmitResponseParam);
}
