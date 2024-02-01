package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GPaymentUnbindAlipayResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackPaymentUnbindAlipayRouter;
@IntfAuto(target = CallBackPaymentUnbindAlipayRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackPaymentUnbindAlipay {
    void onRecvAck(GPaymentUnbindAlipayResponseParam gPaymentUnbindAlipayResponseParam);
}
