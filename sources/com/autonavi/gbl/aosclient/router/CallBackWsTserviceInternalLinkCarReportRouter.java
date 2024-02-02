package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceInternalLinkCarReportResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceInternalLinkCarReport;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceInternalLinkCarReportImpl;
@IntfAuto(target = ICallBackWsTserviceInternalLinkCarReport.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceInternalLinkCarReportRouter extends ICallBackWsTserviceInternalLinkCarReportImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceInternalLinkCarReportRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceInternalLinkCarReportRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceInternalLinkCarReport mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceInternalLinkCarReport iCallBackWsTserviceInternalLinkCarReport) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceInternalLinkCarReportImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceInternalLinkCarReport;
    }

    protected CallBackWsTserviceInternalLinkCarReportRouter(String str, ICallBackWsTserviceInternalLinkCarReport iCallBackWsTserviceInternalLinkCarReport, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceInternalLinkCarReport);
    }

    protected CallBackWsTserviceInternalLinkCarReportRouter(String str, ICallBackWsTserviceInternalLinkCarReport iCallBackWsTserviceInternalLinkCarReport) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceInternalLinkCarReport);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceInternalLinkCarReportRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceInternalLinkCarReportImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceInternalLinkCarReportRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceInternalLinkCarReportImpl
    public void onRecvAck(GWsTserviceInternalLinkCarReportResponseParam gWsTserviceInternalLinkCarReportResponseParam) {
        ICallBackWsTserviceInternalLinkCarReport iCallBackWsTserviceInternalLinkCarReport = this.mObserver;
        if (iCallBackWsTserviceInternalLinkCarReport != null) {
            iCallBackWsTserviceInternalLinkCarReport.onRecvAck(gWsTserviceInternalLinkCarReportResponseParam);
        }
    }
}
