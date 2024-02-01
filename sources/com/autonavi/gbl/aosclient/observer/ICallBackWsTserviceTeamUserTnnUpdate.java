package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamUserTnnUpdateResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamUserTnnUpdateRouter;
@IntfAuto(target = CallBackWsTserviceTeamUserTnnUpdateRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceTeamUserTnnUpdate {
    void onRecvAck(GWsTserviceTeamUserTnnUpdateResponseParam gWsTserviceTeamUserTnnUpdateResponseParam);
}
