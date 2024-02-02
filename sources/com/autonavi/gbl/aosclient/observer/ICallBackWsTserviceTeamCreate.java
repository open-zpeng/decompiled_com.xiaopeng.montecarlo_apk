package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamCreateResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamCreateRouter;
@IntfAuto(target = CallBackWsTserviceTeamCreateRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceTeamCreate {
    void onRecvAck(GWsTserviceTeamCreateResponseParam gWsTserviceTeamCreateResponseParam);
}
