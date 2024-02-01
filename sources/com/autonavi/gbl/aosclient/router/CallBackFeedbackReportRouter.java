package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GFeedbackReportResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackFeedbackReport;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackFeedbackReportImpl;
@IntfAuto(target = ICallBackFeedbackReport.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackFeedbackReportRouter extends ICallBackFeedbackReportImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackFeedbackReportRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackFeedbackReportRouter.class);
    private TypeHelper mHelper;
    private ICallBackFeedbackReport mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackFeedbackReport iCallBackFeedbackReport) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackFeedbackReportImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackFeedbackReport;
    }

    protected CallBackFeedbackReportRouter(String str, ICallBackFeedbackReport iCallBackFeedbackReport, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackFeedbackReport);
    }

    protected CallBackFeedbackReportRouter(String str, ICallBackFeedbackReport iCallBackFeedbackReport) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackFeedbackReport);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackFeedbackReportImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackFeedbackReportImpl
    public void onRecvAck(GFeedbackReportResponseParam gFeedbackReportResponseParam) {
        ICallBackFeedbackReport iCallBackFeedbackReport = this.mObserver;
        if (iCallBackFeedbackReport != null) {
            iCallBackFeedbackReport.onRecvAck(gFeedbackReportResponseParam);
        }
    }
}
