package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GLogUploadResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackLogUploadRouter;
@IntfAuto(target = CallBackLogUploadRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackLogUpload {
    void onRecvAck(GLogUploadResponseParam gLogUploadResponseParam);
}
