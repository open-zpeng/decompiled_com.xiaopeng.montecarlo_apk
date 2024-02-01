package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.AuthTokenInfo;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServicelistResponseParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarTokenResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackAuthenticationRouter;
@IntfAuto(target = CallBackAuthenticationRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackAuthentication {
    default void onAuthcarTokenError(AuthTokenInfo authTokenInfo) {
    }

    default void onRecvAuthcarServerlist(GWsAuthcarServicelistResponseParam gWsAuthcarServicelistResponseParam) {
    }

    default void onRecvAuthcarToken(GWsAuthcarTokenResponseParam gWsAuthcarTokenResponseParam) {
    }
}
