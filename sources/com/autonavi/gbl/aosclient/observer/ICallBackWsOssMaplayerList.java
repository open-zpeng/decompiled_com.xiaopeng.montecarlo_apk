package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsOssMaplayerListResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsOssMaplayerListRouter;
@IntfAuto(target = CallBackWsOssMaplayerListRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsOssMaplayerList {
    void onRecvAck(GWsOssMaplayerListResponseParam gWsOssMaplayerListResponseParam);
}
