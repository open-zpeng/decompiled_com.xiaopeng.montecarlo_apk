package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GQRCodeConfirmResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackQRCodeConfirmRouter;
@IntfAuto(target = CallBackQRCodeConfirmRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackQRCodeConfirm {
    void onRecvAck(GQRCodeConfirmResponseParam gQRCodeConfirmResponseParam);
}
