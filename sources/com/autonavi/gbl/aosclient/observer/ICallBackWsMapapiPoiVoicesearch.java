package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsMapapiPoiVoicesearchResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsMapapiPoiVoicesearchRouter;
@IntfAuto(target = CallBackWsMapapiPoiVoicesearchRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsMapapiPoiVoicesearch {
    void onRecvAck(GWsMapapiPoiVoicesearchResponseParam gWsMapapiPoiVoicesearchResponseParam);
}
