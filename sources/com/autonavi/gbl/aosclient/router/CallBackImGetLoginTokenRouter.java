package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GImGetLoginTokenResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackImGetLoginToken;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackImGetLoginTokenImpl;
@IntfAuto(target = ICallBackImGetLoginToken.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackImGetLoginTokenRouter extends ICallBackImGetLoginTokenImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackImGetLoginTokenRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackImGetLoginTokenRouter.class);
    private TypeHelper mHelper;
    private ICallBackImGetLoginToken mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackImGetLoginToken iCallBackImGetLoginToken) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackImGetLoginTokenImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackImGetLoginToken;
    }

    protected CallBackImGetLoginTokenRouter(String str, ICallBackImGetLoginToken iCallBackImGetLoginToken, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackImGetLoginToken);
    }

    protected CallBackImGetLoginTokenRouter(String str, ICallBackImGetLoginToken iCallBackImGetLoginToken) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackImGetLoginToken);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackImGetLoginTokenImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackImGetLoginTokenImpl
    public void onRecvAck(GImGetLoginTokenResponseParam gImGetLoginTokenResponseParam) {
        ICallBackImGetLoginToken iCallBackImGetLoginToken = this.mObserver;
        if (iCallBackImGetLoginToken != null) {
            iCallBackImGetLoginToken.onRecvAck(gImGetLoginTokenResponseParam);
        }
    }
}
