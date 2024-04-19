package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsCloudUploadResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsCloudUploadRouter;
@IntfAuto(target = CallBackWsCloudUploadRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsCloudUpload {
    void onRecvAck(GWsCloudUploadResponseParam gWsCloudUploadResponseParam);
}
