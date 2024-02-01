package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsVaCarLogoSelectResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsVaCarLogoSelectRouter;
@IntfAuto(target = CallBackWsVaCarLogoSelectRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsVaCarLogoSelect {
    void onRecvAck(GWsVaCarLogoSelectResponseParam gWsVaCarLogoSelectResponseParam);
}
