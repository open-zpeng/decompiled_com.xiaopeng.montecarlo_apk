package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GPaymentBindAlipayResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackPaymentBindAlipayRouter;
@IntfAuto(target = CallBackPaymentBindAlipayRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackPaymentBindAlipay {
    void onRecvAck(GPaymentBindAlipayResponseParam gPaymentBindAlipayResponseParam);
}
