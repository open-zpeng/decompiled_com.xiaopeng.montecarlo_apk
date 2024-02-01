package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsAuthcarTokenResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAuthcarToken;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarTokenImpl;
@IntfAuto(target = ICallBackWsAuthcarToken.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsAuthcarTokenRouter extends ICallBackWsAuthcarTokenImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsAuthcarTokenRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsAuthcarTokenRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsAuthcarToken mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsAuthcarToken iCallBackWsAuthcarToken) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsAuthcarTokenImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsAuthcarToken;
    }

    protected CallBackWsAuthcarTokenRouter(String str, ICallBackWsAuthcarToken iCallBackWsAuthcarToken, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAuthcarToken);
    }

    protected CallBackWsAuthcarTokenRouter(String str, ICallBackWsAuthcarToken iCallBackWsAuthcarToken) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAuthcarToken);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarTokenImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarTokenImpl
    public void onRecvAck(GWsAuthcarTokenResponseParam gWsAuthcarTokenResponseParam) {
        ICallBackWsAuthcarToken iCallBackWsAuthcarToken = this.mObserver;
        if (iCallBackWsAuthcarToken != null) {
            iCallBackWsAuthcarToken.onRecvAck(gWsAuthcarTokenResponseParam);
        }
    }
}
