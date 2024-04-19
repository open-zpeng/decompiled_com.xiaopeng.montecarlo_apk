package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintSummaryResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsUserviewFootprintSummaryRouter;
@IntfAuto(target = CallBackWsUserviewFootprintSummaryRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsUserviewFootprintSummary {
    void onRecvAck(GWsUserviewFootprintSummaryResponseParam gWsUserviewFootprintSummaryResponseParam);
}
