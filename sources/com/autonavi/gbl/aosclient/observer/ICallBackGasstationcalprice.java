package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GGasstationcalpriceResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackGasstationcalpriceRouter;
@IntfAuto(target = CallBackGasstationcalpriceRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackGasstationcalprice {
    void onRecvAck(GGasstationcalpriceResponseParam gGasstationcalpriceResponseParam);
}
