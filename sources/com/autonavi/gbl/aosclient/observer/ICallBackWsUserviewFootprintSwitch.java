package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintSwitchResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsUserviewFootprintSwitchRouter;
@IntfAuto(target = CallBackWsUserviewFootprintSwitchRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsUserviewFootprintSwitch {
    void onRecvAck(GWsUserviewFootprintSwitchResponseParam gWsUserviewFootprintSwitchResponseParam);
}
