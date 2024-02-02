package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamJoinResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamJoinRouter;
@IntfAuto(target = CallBackWsTserviceTeamJoinRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceTeamJoin {
    void onRecvAck(GWsTserviceTeamJoinResponseParam gWsTserviceTeamJoinResponseParam);
}
