package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GTrafficEventCommentResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackTrafficEventCommentRouter;
@IntfAuto(target = CallBackTrafficEventCommentRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackTrafficEventComment {
    void onRecvAck(GTrafficEventCommentResponseParam gTrafficEventCommentResponseParam);
}
