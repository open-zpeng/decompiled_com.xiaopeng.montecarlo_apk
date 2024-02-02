package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamInfoGetResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamInfoGetRouter;
@IntfAuto(target = CallBackWsTserviceTeamInfoGetRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceTeamInfoGet {
    void onRecvAck(GWsTserviceTeamInfoGetResponseParam gWsTserviceTeamInfoGetResponseParam);
}
