package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsMapapiLinkidsResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsMapapiLinkidsRouter;
@IntfAuto(target = CallBackWsMapapiLinkidsRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsMapapiLinkids {
    void onRecvAck(GWsMapapiLinkidsResponseParam gWsMapapiLinkidsResponseParam);
}
