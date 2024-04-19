package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsMapapiPoiCodepointResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsMapapiPoiCodepointRouter;
@IntfAuto(target = CallBackWsMapapiPoiCodepointRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsMapapiPoiCodepoint {
    void onRecvAck(GWsMapapiPoiCodepointResponseParam gWsMapapiPoiCodepointResponseParam);
}
