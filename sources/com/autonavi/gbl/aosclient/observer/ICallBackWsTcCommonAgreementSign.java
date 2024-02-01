package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementSignResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTcCommonAgreementSignRouter;
@IntfAuto(target = CallBackWsTcCommonAgreementSignRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTcCommonAgreementSign {
    void onRecvAck(GWsTcCommonAgreementSignResponseParam gWsTcCommonAgreementSignResponseParam);
}
