package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GDriveReportUploadResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackDriveReportUpload;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackDriveReportUploadImpl;
@IntfAuto(target = ICallBackDriveReportUpload.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackDriveReportUploadRouter extends ICallBackDriveReportUploadImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackDriveReportUploadRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackDriveReportUploadRouter.class);
    private TypeHelper mHelper;
    private ICallBackDriveReportUpload mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackDriveReportUpload iCallBackDriveReportUpload) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackDriveReportUploadImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackDriveReportUpload;
    }

    protected CallBackDriveReportUploadRouter(String str, ICallBackDriveReportUpload iCallBackDriveReportUpload, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackDriveReportUpload);
    }

    protected CallBackDriveReportUploadRouter(String str, ICallBackDriveReportUpload iCallBackDriveReportUpload) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackDriveReportUpload);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackDriveReportUploadRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackDriveReportUploadImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackDriveReportUploadRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackDriveReportUploadImpl
    public void onRecvAck(GDriveReportUploadResponseParam gDriveReportUploadResponseParam) {
        ICallBackDriveReportUpload iCallBackDriveReportUpload = this.mObserver;
        if (iCallBackDriveReportUpload != null) {
            iCallBackDriveReportUpload.onRecvAck(gDriveReportUploadResponseParam);
        }
    }
}
