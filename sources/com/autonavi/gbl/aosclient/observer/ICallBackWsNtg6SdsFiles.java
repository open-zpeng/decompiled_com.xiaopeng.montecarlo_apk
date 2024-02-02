package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsNtg6SdsFilesResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsNtg6SdsFilesRouter;
@IntfAuto(target = CallBackWsNtg6SdsFilesRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsNtg6SdsFiles {
    void onRecvAck(GWsNtg6SdsFilesResponseParam gWsNtg6SdsFilesResponseParam);
}
