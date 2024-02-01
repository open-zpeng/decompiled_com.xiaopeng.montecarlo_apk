package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsShieldNavigationRoutepathrestorationResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsShieldNavigationRoutepathrestorationRouter;
@IntfAuto(target = CallBackWsShieldNavigationRoutepathrestorationRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsShieldNavigationRoutepathrestoration {
    void onRecvAck(GWsShieldNavigationRoutepathrestorationResponseParam gWsShieldNavigationRoutepathrestorationResponseParam);
}
