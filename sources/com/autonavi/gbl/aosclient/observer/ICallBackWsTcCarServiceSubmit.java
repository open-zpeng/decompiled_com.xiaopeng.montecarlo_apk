package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcCarServiceSubmitResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTcCarServiceSubmitRouter;
@IntfAuto(target = CallBackWsTcCarServiceSubmitRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTcCarServiceSubmit {
    void onRecvAck(GWsTcCarServiceSubmitResponseParam gWsTcCarServiceSubmitResponseParam);
}
