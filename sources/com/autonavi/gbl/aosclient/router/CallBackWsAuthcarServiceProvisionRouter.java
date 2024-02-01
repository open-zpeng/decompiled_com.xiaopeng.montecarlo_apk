package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServiceProvisionResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAuthcarServiceProvision;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServiceProvisionImpl;
@IntfAuto(target = ICallBackWsAuthcarServiceProvision.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsAuthcarServiceProvisionRouter extends ICallBackWsAuthcarServiceProvisionImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsAuthcarServiceProvisionRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsAuthcarServiceProvisionRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsAuthcarServiceProvision mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsAuthcarServiceProvision iCallBackWsAuthcarServiceProvision) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsAuthcarServiceProvisionImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsAuthcarServiceProvision;
    }

    protected CallBackWsAuthcarServiceProvisionRouter(String str, ICallBackWsAuthcarServiceProvision iCallBackWsAuthcarServiceProvision, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAuthcarServiceProvision);
    }

    protected CallBackWsAuthcarServiceProvisionRouter(String str, ICallBackWsAuthcarServiceProvision iCallBackWsAuthcarServiceProvision) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAuthcarServiceProvision);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServiceProvisionImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServiceProvisionImpl
    public void onRecvAck(GWsAuthcarServiceProvisionResponseParam gWsAuthcarServiceProvisionResponseParam) {
        ICallBackWsAuthcarServiceProvision iCallBackWsAuthcarServiceProvision = this.mObserver;
        if (iCallBackWsAuthcarServiceProvision != null) {
            iCallBackWsAuthcarServiceProvision.onRecvAck(gWsAuthcarServiceProvisionResponseParam);
        }
    }
}
