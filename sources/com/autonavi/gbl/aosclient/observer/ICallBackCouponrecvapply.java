package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GCouponrecvapplyResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackCouponrecvapplyRouter;
@IntfAuto(target = CallBackCouponrecvapplyRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackCouponrecvapply {
    void onRecvAck(GCouponrecvapplyResponseParam gCouponrecvapplyResponseParam);
}
