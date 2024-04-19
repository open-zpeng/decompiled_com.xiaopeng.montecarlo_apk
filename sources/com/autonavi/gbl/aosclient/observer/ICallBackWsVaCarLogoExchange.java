package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsVaCarLogoExchangeResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsVaCarLogoExchangeRouter;
@IntfAuto(target = CallBackWsVaCarLogoExchangeRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsVaCarLogoExchange {
    void onRecvAck(GWsVaCarLogoExchangeResponseParam gWsVaCarLogoExchangeResponseParam);
}
