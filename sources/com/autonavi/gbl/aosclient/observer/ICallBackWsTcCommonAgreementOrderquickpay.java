package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementOrderquickpayResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTcCommonAgreementOrderquickpayRouter;
@IntfAuto(target = CallBackWsTcCommonAgreementOrderquickpayRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTcCommonAgreementOrderquickpay {
    void onRecvAck(GWsTcCommonAgreementOrderquickpayResponseParam gWsTcCommonAgreementOrderquickpayResponseParam);
}
