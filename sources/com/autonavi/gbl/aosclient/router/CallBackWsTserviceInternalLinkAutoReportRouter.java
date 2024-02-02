package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceInternalLinkAutoReportResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceInternalLinkAutoReport;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceInternalLinkAutoReportImpl;
@IntfAuto(target = ICallBackWsTserviceInternalLinkAutoReport.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceInternalLinkAutoReportRouter extends ICallBackWsTserviceInternalLinkAutoReportImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceInternalLinkAutoReportRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceInternalLinkAutoReportRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceInternalLinkAutoReport mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceInternalLinkAutoReport iCallBackWsTserviceInternalLinkAutoReport) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceInternalLinkAutoReportImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceInternalLinkAutoReport;
    }

    protected CallBackWsTserviceInternalLinkAutoReportRouter(String str, ICallBackWsTserviceInternalLinkAutoReport iCallBackWsTserviceInternalLinkAutoReport, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceInternalLinkAutoReport);
    }

    protected CallBackWsTserviceInternalLinkAutoReportRouter(String str, ICallBackWsTserviceInternalLinkAutoReport iCallBackWsTserviceInternalLinkAutoReport) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceInternalLinkAutoReport);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceInternalLinkAutoReportRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceInternalLinkAutoReportImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceInternalLinkAutoReportRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceInternalLinkAutoReportImpl
    public void onRecvAck(GWsTserviceInternalLinkAutoReportResponseParam gWsTserviceInternalLinkAutoReportResponseParam) {
        ICallBackWsTserviceInternalLinkAutoReport iCallBackWsTserviceInternalLinkAutoReport = this.mObserver;
        if (iCallBackWsTserviceInternalLinkAutoReport != null) {
            iCallBackWsTserviceInternalLinkAutoReport.onRecvAck(gWsTserviceInternalLinkAutoReportResponseParam);
        }
    }
}
