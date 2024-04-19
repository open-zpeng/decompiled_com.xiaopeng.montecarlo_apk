package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GFeedbackReportResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackFeedbackReportRouter;
@IntfAuto(target = CallBackFeedbackReportRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackFeedbackReport {
    void onRecvAck(GFeedbackReportResponseParam gFeedbackReportResponseParam);
}
