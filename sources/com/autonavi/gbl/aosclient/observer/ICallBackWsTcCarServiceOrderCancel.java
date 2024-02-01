package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcCarServiceOrderCancelResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTcCarServiceOrderCancelRouter;
@IntfAuto(target = CallBackWsTcCarServiceOrderCancelRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTcCarServiceOrderCancel {
    void onRecvAck(GWsTcCarServiceOrderCancelResponseParam gWsTcCarServiceOrderCancelResponseParam);
}
