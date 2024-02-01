package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsFeedbackReviewReportResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsFeedbackReviewReportRouter;
@IntfAuto(target = CallBackWsFeedbackReviewReportRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsFeedbackReviewReport {
    void onRecvAck(GWsFeedbackReviewReportResponseParam gWsFeedbackReviewReportResponseParam);
}
