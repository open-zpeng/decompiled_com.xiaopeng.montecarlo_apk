package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamInfoUpdateResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamInfoUpdateRouter;
@IntfAuto(target = CallBackWsTserviceTeamInfoUpdateRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceTeamInfoUpdate {
    void onRecvAck(GWsTserviceTeamInfoUpdateResponseParam gWsTserviceTeamInfoUpdateResponseParam);
}
