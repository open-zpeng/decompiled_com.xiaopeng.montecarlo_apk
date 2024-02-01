package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GQuerybylinksResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackQuerybylinksRouter;
@IntfAuto(target = CallBackQuerybylinksRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackQuerybylinks {
    void onRecvAck(GQuerybylinksResponseParam gQuerybylinksResponseParam);
}
