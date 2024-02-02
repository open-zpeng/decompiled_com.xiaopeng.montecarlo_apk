package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.CEtaRequestReponseParam;
import com.autonavi.gbl.aosclient.router.CallBackEtaRequestRouter;
@IntfAuto(target = CallBackEtaRequestRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackEtaRequest {
    void onRecvAck(CEtaRequestReponseParam cEtaRequestReponseParam);
}
