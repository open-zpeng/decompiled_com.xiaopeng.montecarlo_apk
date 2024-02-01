package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsSdsFilesResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsSdsFilesRouter;
@IntfAuto(target = CallBackWsSdsFilesRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsSdsFiles {
    void onRecvAck(GWsSdsFilesResponseParam gWsSdsFilesResponseParam);
}
