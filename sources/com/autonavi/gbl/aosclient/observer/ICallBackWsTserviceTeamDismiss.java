package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamDismissResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamDismissRouter;
@IntfAuto(target = CallBackWsTserviceTeamDismissRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceTeamDismiss {
    void onRecvAck(GWsTserviceTeamDismissResponseParam gWsTserviceTeamDismissResponseParam);
}
