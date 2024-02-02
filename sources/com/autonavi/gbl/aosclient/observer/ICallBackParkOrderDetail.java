package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GParkOrderDetailResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackParkOrderDetailRouter;
@IntfAuto(target = CallBackParkOrderDetailRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackParkOrderDetail {
    void onRecvAck(GParkOrderDetailResponseParam gParkOrderDetailResponseParam);
}
