package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GCancelSignPayResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackCancelSignPayRouter;
@IntfAuto(target = CallBackCancelSignPayRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackCancelSignPay {
    void onRecvAck(GCancelSignPayResponseParam gCancelSignPayResponseParam);
}
