package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GParkServiceResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackParkServiceRouter;
@IntfAuto(target = CallBackParkServiceRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackParkService {
    void onRecvAck(GParkServiceResponseParam gParkServiceResponseParam);
}
