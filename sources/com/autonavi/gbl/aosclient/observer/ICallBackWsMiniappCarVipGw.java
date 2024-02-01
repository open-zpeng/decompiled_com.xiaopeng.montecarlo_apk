package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsMiniappCarVipGwResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsMiniappCarVipGwRouter;
@IntfAuto(target = CallBackWsMiniappCarVipGwRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsMiniappCarVipGw {
    void onRecvAck(GWsMiniappCarVipGwResponseParam gWsMiniappCarVipGwResponseParam);
}
