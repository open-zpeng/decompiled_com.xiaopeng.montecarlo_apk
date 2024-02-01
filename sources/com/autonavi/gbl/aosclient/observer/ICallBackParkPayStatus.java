package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GParkPayStatusResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackParkPayStatusRouter;
@IntfAuto(target = CallBackParkPayStatusRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackParkPayStatus {
    void onRecvAck(GParkPayStatusResponseParam gParkPayStatusResponseParam);
}
