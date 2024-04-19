package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GCouponrecvlistResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackCouponrecvlistRouter;
@IntfAuto(target = CallBackCouponrecvlistRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackCouponrecvlist {
    void onRecvAck(GCouponrecvlistResponseParam gCouponrecvlistResponseParam);
}
