package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GLogUploadResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackLogUpload;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackLogUploadImpl;
@IntfAuto(target = ICallBackLogUpload.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackLogUploadRouter extends ICallBackLogUploadImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackLogUploadRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackLogUploadRouter.class);
    private TypeHelper mHelper;
    private ICallBackLogUpload mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackLogUpload iCallBackLogUpload) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackLogUploadImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackLogUpload;
    }

    protected CallBackLogUploadRouter(String str, ICallBackLogUpload iCallBackLogUpload, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackLogUpload);
    }

    protected CallBackLogUploadRouter(String str, ICallBackLogUpload iCallBackLogUpload) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackLogUpload);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackLogUploadImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackLogUploadImpl
    public void onRecvAck(GLogUploadResponseParam gLogUploadResponseParam) {
        ICallBackLogUpload iCallBackLogUpload = this.mObserver;
        if (iCallBackLogUpload != null) {
            iCallBackLogUpload.onRecvAck(gLogUploadResponseParam);
        }
    }
}
