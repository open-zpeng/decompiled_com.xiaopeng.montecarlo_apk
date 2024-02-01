package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceRequestIpResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceRequestIp;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceRequestIpImpl;
@IntfAuto(target = ICallBackWsTserviceRequestIp.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceRequestIpRouter extends ICallBackWsTserviceRequestIpImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceRequestIpRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceRequestIpRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceRequestIp mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceRequestIp iCallBackWsTserviceRequestIp) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceRequestIpImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceRequestIp;
    }

    protected CallBackWsTserviceRequestIpRouter(String str, ICallBackWsTserviceRequestIp iCallBackWsTserviceRequestIp, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceRequestIp);
    }

    protected CallBackWsTserviceRequestIpRouter(String str, ICallBackWsTserviceRequestIp iCallBackWsTserviceRequestIp) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceRequestIp);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceRequestIpImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceRequestIpImpl
    public void onRecvAck(GWsTserviceRequestIpResponseParam gWsTserviceRequestIpResponseParam) {
        ICallBackWsTserviceRequestIp iCallBackWsTserviceRequestIp = this.mObserver;
        if (iCallBackWsTserviceRequestIp != null) {
            iCallBackWsTserviceRequestIp.onRecvAck(gWsTserviceRequestIpResponseParam);
        }
    }
}
