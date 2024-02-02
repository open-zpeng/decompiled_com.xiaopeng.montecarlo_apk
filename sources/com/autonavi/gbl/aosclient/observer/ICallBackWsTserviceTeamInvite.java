package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamInviteResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamInviteRouter;
@IntfAuto(target = CallBackWsTserviceTeamInviteRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceTeamInvite {
    void onRecvAck(GWsTserviceTeamInviteResponseParam gWsTserviceTeamInviteResponseParam);
}
