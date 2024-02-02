package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
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
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsAuthcarServiceProvisionRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServiceProvisionImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsAuthcarServiceProvisionRouter.2
        }));
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
