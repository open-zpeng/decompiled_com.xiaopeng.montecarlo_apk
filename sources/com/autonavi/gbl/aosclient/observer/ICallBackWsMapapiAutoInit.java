package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsMapapiAutoInitResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsMapapiAutoInitRouter;
@IntfAuto(target = CallBackWsMapapiAutoInitRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsMapapiAutoInit {
    void onRecvAck(GWsMapapiAutoInitResponseParam gWsMapapiAutoInitResponseParam);
}
