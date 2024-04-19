package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsFeedbackReviewGetResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsFeedbackReviewGetRouter;
@IntfAuto(target = CallBackWsFeedbackReviewGetRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsFeedbackReviewGet {
    void onRecvAck(GWsFeedbackReviewGetResponseParam gWsFeedbackReviewGetResponseParam);
}
