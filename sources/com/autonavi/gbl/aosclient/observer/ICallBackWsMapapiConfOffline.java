package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsMapapiConfOfflineResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsMapapiConfOfflineRouter;
@IntfAuto(target = CallBackWsMapapiConfOfflineRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsMapapiConfOffline {
    void onRecvAck(GWsMapapiConfOfflineResponseParam gWsMapapiConfOfflineResponseParam);
}
