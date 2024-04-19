package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsIcsLifeUserCouponListResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsIcsLifeUserCouponListRouter;
@IntfAuto(target = CallBackWsIcsLifeUserCouponListRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsIcsLifeUserCouponList {
    void onRecvAck(GWsIcsLifeUserCouponListResponseParam gWsIcsLifeUserCouponListResponseParam);
}
