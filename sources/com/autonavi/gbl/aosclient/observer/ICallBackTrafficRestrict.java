package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GTrafficRestrictResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackTrafficRestrictRouter;
@IntfAuto(target = CallBackTrafficRestrictRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackTrafficRestrict {
    void onRecvAck(GTrafficRestrictResponseParam gTrafficRestrictResponseParam);
}
