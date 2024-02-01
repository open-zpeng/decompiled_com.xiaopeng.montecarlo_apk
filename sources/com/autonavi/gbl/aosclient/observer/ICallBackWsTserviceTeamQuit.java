package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamQuitResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamQuitRouter;
@IntfAuto(target = CallBackWsTserviceTeamQuitRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceTeamQuit {
    void onRecvAck(GWsTserviceTeamQuitResponseParam gWsTserviceTeamQuitResponseParam);
}
