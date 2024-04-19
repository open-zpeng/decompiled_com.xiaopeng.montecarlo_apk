package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamQrResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamQrRouter;
@IntfAuto(target = CallBackWsTserviceTeamQrRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceTeamQr {
    void onRecvAck(GWsTserviceTeamQrResponseParam gWsTserviceTeamQrResponseParam);
}
