package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GPaymentStatusResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackPaymentStatusRouter;
@IntfAuto(target = CallBackPaymentStatusRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackPaymentStatus {
    void onRecvAck(GPaymentStatusResponseParam gPaymentStatusResponseParam);
}
