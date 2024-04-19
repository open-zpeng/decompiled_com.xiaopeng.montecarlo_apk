package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementStatusResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTcCommonAgreementStatusRouter;
@IntfAuto(target = CallBackWsTcCommonAgreementStatusRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTcCommonAgreementStatus {
    void onRecvAck(GWsTcCommonAgreementStatusResponseParam gWsTcCommonAgreementStatusResponseParam);
}
