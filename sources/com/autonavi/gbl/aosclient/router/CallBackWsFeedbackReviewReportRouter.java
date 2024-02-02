package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsFeedbackReviewReportResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsFeedbackReviewReport;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFeedbackReviewReportImpl;
@IntfAuto(target = ICallBackWsFeedbackReviewReport.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsFeedbackReviewReportRouter extends ICallBackWsFeedbackReviewReportImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsFeedbackReviewReportRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsFeedbackReviewReportRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsFeedbackReviewReport mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsFeedbackReviewReport iCallBackWsFeedbackReviewReport) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsFeedbackReviewReportImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsFeedbackReviewReport;
    }

    protected CallBackWsFeedbackReviewReportRouter(String str, ICallBackWsFeedbackReviewReport iCallBackWsFeedbackReviewReport, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsFeedbackReviewReport);
    }

    protected CallBackWsFeedbackReviewReportRouter(String str, ICallBackWsFeedbackReviewReport iCallBackWsFeedbackReviewReport) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsFeedbackReviewReport);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsFeedbackReviewReportRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFeedbackReviewReportImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsFeedbackReviewReportRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFeedbackReviewReportImpl
    public void onRecvAck(GWsFeedbackReviewReportResponseParam gWsFeedbackReviewReportResponseParam) {
        ICallBackWsFeedbackReviewReport iCallBackWsFeedbackReviewReport = this.mObserver;
        if (iCallBackWsFeedbackReviewReport != null) {
            iCallBackWsFeedbackReviewReport.onRecvAck(gWsFeedbackReviewReportResponseParam);
        }
    }
}
