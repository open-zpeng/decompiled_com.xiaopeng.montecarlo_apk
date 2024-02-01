package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcOrderListResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTcOrderListRouter;
@IntfAuto(target = CallBackWsTcOrderListRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTcOrderList {
    void onRecvAck(GWsTcOrderListResponseParam gWsTcOrderListResponseParam);
}
