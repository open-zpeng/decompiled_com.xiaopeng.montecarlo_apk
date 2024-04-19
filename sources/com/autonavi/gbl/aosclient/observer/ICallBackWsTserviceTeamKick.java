package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamKickResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamKickRouter;
@IntfAuto(target = CallBackWsTserviceTeamKickRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceTeamKick {
    void onRecvAck(GWsTserviceTeamKickResponseParam gWsTserviceTeamKickResponseParam);
}
