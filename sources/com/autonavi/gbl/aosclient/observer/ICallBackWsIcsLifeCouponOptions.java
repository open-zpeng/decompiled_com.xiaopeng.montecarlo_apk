package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsIcsLifeCouponOptionsResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsIcsLifeCouponOptionsRouter;
@IntfAuto(target = CallBackWsIcsLifeCouponOptionsRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsIcsLifeCouponOptions {
    void onRecvAck(GWsIcsLifeCouponOptionsResponseParam gWsIcsLifeCouponOptionsResponseParam);
}
