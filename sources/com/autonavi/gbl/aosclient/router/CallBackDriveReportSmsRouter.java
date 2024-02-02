package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GDriveReportSmsResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackDriveReportSms;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackDriveReportSmsImpl;
@IntfAuto(target = ICallBackDriveReportSms.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackDriveReportSmsRouter extends ICallBackDriveReportSmsImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackDriveReportSmsRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackDriveReportSmsRouter.class);
    private TypeHelper mHelper;
    private ICallBackDriveReportSms mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackDriveReportSms iCallBackDriveReportSms) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackDriveReportSmsImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackDriveReportSms;
    }

    protected CallBackDriveReportSmsRouter(String str, ICallBackDriveReportSms iCallBackDriveReportSms, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackDriveReportSms);
    }

    protected CallBackDriveReportSmsRouter(String str, ICallBackDriveReportSms iCallBackDriveReportSms) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackDriveReportSms);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackDriveReportSmsRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackDriveReportSmsImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackDriveReportSmsRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackDriveReportSmsImpl
    public void onRecvAck(GDriveReportSmsResponseParam gDriveReportSmsResponseParam) {
        ICallBackDriveReportSms iCallBackDriveReportSms = this.mObserver;
        if (iCallBackDriveReportSms != null) {
            iCallBackDriveReportSms.onRecvAck(gDriveReportSmsResponseParam);
        }
    }
}
