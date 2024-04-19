package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GHttpGetPostResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackHttpGetPostRouter;
@IntfAuto(target = CallBackHttpGetPostRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackHttpGetPost {
    void onRecvAck(GHttpGetPostResponseParam gHttpGetPostResponseParam);
}
