package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsShieldAsbpApiUploadResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsShieldAsbpApiUploadRouter;
@IntfAuto(target = CallBackWsShieldAsbpApiUploadRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsShieldAsbpApiUpload {
    void onRecvAck(GWsShieldAsbpApiUploadResponseParam gWsShieldAsbpApiUploadResponseParam);
}
