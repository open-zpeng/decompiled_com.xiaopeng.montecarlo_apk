package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GAddressPredictResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackAddressPredictRouter;
@IntfAuto(target = CallBackAddressPredictRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackAddressPredict {
    void onRecvAck(GAddressPredictResponseParam gAddressPredictResponseParam);
}
