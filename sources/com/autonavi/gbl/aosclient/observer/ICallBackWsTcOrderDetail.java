package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcOrderDetailResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTcOrderDetailRouter;
@IntfAuto(target = CallBackWsTcOrderDetailRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTcOrderDetail {
    void onRecvAck(GWsTcOrderDetailResponseParam gWsTcOrderDetailResponseParam);
}
