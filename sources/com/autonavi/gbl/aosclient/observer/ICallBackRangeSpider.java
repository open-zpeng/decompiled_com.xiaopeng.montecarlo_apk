package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GRangeSpiderResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackRangeSpiderRouter;
@IntfAuto(target = CallBackRangeSpiderRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackRangeSpider {
    void onRecvAck(GRangeSpiderResponseParam gRangeSpiderResponseParam);
}
