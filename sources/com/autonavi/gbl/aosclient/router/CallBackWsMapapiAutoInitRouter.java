package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsMapapiAutoInitResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiAutoInit;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiAutoInitImpl;
@IntfAuto(target = ICallBackWsMapapiAutoInit.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsMapapiAutoInitRouter extends ICallBackWsMapapiAutoInitImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsMapapiAutoInitRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsMapapiAutoInitRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsMapapiAutoInit mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsMapapiAutoInit iCallBackWsMapapiAutoInit) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsMapapiAutoInitImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsMapapiAutoInit;
    }

    protected CallBackWsMapapiAutoInitRouter(String str, ICallBackWsMapapiAutoInit iCallBackWsMapapiAutoInit, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiAutoInit);
    }

    protected CallBackWsMapapiAutoInitRouter(String str, ICallBackWsMapapiAutoInit iCallBackWsMapapiAutoInit) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiAutoInit);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiAutoInitImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiAutoInitImpl
    public void onRecvAck(GWsMapapiAutoInitResponseParam gWsMapapiAutoInitResponseParam) {
        ICallBackWsMapapiAutoInit iCallBackWsMapapiAutoInit = this.mObserver;
        if (iCallBackWsMapapiAutoInit != null) {
            iCallBackWsMapapiAutoInit.onRecvAck(gWsMapapiAutoInitResponseParam);
        }
    }
}
