package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsVaCarLogoResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsVaCarLogoRouter;
@IntfAuto(target = CallBackWsVaCarLogoRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsVaCarLogo {
    void onRecvAck(GWsVaCarLogoResponseParam gWsVaCarLogoResponseParam);
}
