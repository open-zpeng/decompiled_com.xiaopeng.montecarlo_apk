package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServicelistResponseParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarTokenResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackAuthentication;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackAuthenticationImpl;
@IntfAuto(target = ICallBackAuthentication.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackAuthenticationRouter extends ICallBackAuthenticationImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackAuthenticationRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackAuthenticationRouter.class);
    private TypeHelper mHelper;
    private ICallBackAuthentication mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackAuthentication iCallBackAuthentication) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackAuthenticationImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackAuthentication;
    }

    protected CallBackAuthenticationRouter(String str, ICallBackAuthentication iCallBackAuthentication, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackAuthentication);
    }

    protected CallBackAuthenticationRouter(String str, ICallBackAuthentication iCallBackAuthentication) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackAuthentication);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackAuthenticationRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackAuthenticationImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackAuthenticationRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackAuthenticationImpl
    public void onRecvAuthcarServerlist(GWsAuthcarServicelistResponseParam gWsAuthcarServicelistResponseParam) {
        ICallBackAuthentication iCallBackAuthentication = this.mObserver;
        if (iCallBackAuthentication != null) {
            iCallBackAuthentication.onRecvAuthcarServerlist(gWsAuthcarServicelistResponseParam);
        }
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackAuthenticationImpl
    public void onRecvAuthcarToken(GWsAuthcarTokenResponseParam gWsAuthcarTokenResponseParam) {
        ICallBackAuthentication iCallBackAuthentication = this.mObserver;
        if (iCallBackAuthentication != null) {
            iCallBackAuthentication.onRecvAuthcarToken(gWsAuthcarTokenResponseParam);
        }
    }
}
