package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsMapapiAutoSwitchResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsMapapiAutoSwitchRouter;
@IntfAuto(target = CallBackWsMapapiAutoSwitchRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsMapapiAutoSwitch {
    void onRecvAck(GWsMapapiAutoSwitchResponseParam gWsMapapiAutoSwitchResponseParam);
}
