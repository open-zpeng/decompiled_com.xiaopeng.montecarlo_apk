package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamQrResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamQr;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamQrImpl;
@IntfAuto(target = ICallBackWsTserviceTeamQr.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceTeamQrRouter extends ICallBackWsTserviceTeamQrImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceTeamQrRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceTeamQrRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceTeamQr mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceTeamQr iCallBackWsTserviceTeamQr) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceTeamQrImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceTeamQr;
    }

    protected CallBackWsTserviceTeamQrRouter(String str, ICallBackWsTserviceTeamQr iCallBackWsTserviceTeamQr, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamQr);
    }

    protected CallBackWsTserviceTeamQrRouter(String str, ICallBackWsTserviceTeamQr iCallBackWsTserviceTeamQr) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamQr);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamQrImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamQrImpl
    public void onRecvAck(GWsTserviceTeamQrResponseParam gWsTserviceTeamQrResponseParam) {
        ICallBackWsTserviceTeamQr iCallBackWsTserviceTeamQr = this.mObserver;
        if (iCallBackWsTserviceTeamQr != null) {
            iCallBackWsTserviceTeamQr.onRecvAck(gWsTserviceTeamQrResponseParam);
        }
    }
}
