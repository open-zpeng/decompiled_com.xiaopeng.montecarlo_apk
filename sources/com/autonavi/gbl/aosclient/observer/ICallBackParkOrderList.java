package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GParkOrderListResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackParkOrderListRouter;
@IntfAuto(target = CallBackParkOrderListRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackParkOrderList {
    void onRecvAck(GParkOrderListResponseParam gParkOrderListResponseParam);
}
