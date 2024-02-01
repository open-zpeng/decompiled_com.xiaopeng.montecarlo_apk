package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsCloudUploadResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsCloudUpload;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsCloudUploadImpl;
@IntfAuto(target = ICallBackWsCloudUpload.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsCloudUploadRouter extends ICallBackWsCloudUploadImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsCloudUploadRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsCloudUploadRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsCloudUpload mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsCloudUpload iCallBackWsCloudUpload) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsCloudUploadImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsCloudUpload;
    }

    protected CallBackWsCloudUploadRouter(String str, ICallBackWsCloudUpload iCallBackWsCloudUpload, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsCloudUpload);
    }

    protected CallBackWsCloudUploadRouter(String str, ICallBackWsCloudUpload iCallBackWsCloudUpload) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsCloudUpload);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsCloudUploadImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsCloudUploadImpl
    public void onRecvAck(GWsCloudUploadResponseParam gWsCloudUploadResponseParam) {
        ICallBackWsCloudUpload iCallBackWsCloudUpload = this.mObserver;
        if (iCallBackWsCloudUpload != null) {
            iCallBackWsCloudUpload.onRecvAck(gWsCloudUploadResponseParam);
        }
    }
}
