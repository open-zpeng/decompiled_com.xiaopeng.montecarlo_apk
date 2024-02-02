package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsShieldAsbpApiUploadResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldAsbpApiUpload;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldAsbpApiUploadImpl;
@IntfAuto(target = ICallBackWsShieldAsbpApiUpload.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsShieldAsbpApiUploadRouter extends ICallBackWsShieldAsbpApiUploadImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsShieldAsbpApiUploadRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsShieldAsbpApiUploadRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsShieldAsbpApiUpload mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsShieldAsbpApiUpload iCallBackWsShieldAsbpApiUpload) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsShieldAsbpApiUploadImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsShieldAsbpApiUpload;
    }

    protected CallBackWsShieldAsbpApiUploadRouter(String str, ICallBackWsShieldAsbpApiUpload iCallBackWsShieldAsbpApiUpload, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsShieldAsbpApiUpload);
    }

    protected CallBackWsShieldAsbpApiUploadRouter(String str, ICallBackWsShieldAsbpApiUpload iCallBackWsShieldAsbpApiUpload) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsShieldAsbpApiUpload);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsShieldAsbpApiUploadRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldAsbpApiUploadImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsShieldAsbpApiUploadRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldAsbpApiUploadImpl
    public void onRecvAck(GWsShieldAsbpApiUploadResponseParam gWsShieldAsbpApiUploadResponseParam) {
        ICallBackWsShieldAsbpApiUpload iCallBackWsShieldAsbpApiUpload = this.mObserver;
        if (iCallBackWsShieldAsbpApiUpload != null) {
            iCallBackWsShieldAsbpApiUpload.onRecvAck(gWsShieldAsbpApiUploadResponseParam);
        }
    }
}
