package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsArchiveTrafficeventUpdateResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsArchiveTrafficeventUpdateRouter;
@IntfAuto(target = CallBackWsArchiveTrafficeventUpdateRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsArchiveTrafficeventUpdate {
    void onRecvAck(GWsArchiveTrafficeventUpdateResponseParam gWsArchiveTrafficeventUpdateResponseParam);
}
