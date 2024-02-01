package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamUserStatusResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamUserStatusRouter;
@IntfAuto(target = CallBackWsTserviceTeamUserStatusRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceTeamUserStatus {
    void onRecvAck(GWsTserviceTeamUserStatusResponseParam gWsTserviceTeamUserStatusResponseParam);
}
