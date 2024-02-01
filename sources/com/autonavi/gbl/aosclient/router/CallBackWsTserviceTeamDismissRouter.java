package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamDismissResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamDismiss;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamDismissImpl;
@IntfAuto(target = ICallBackWsTserviceTeamDismiss.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceTeamDismissRouter extends ICallBackWsTserviceTeamDismissImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceTeamDismissRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceTeamDismissRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceTeamDismiss mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceTeamDismiss iCallBackWsTserviceTeamDismiss) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceTeamDismissImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceTeamDismiss;
    }

    protected CallBackWsTserviceTeamDismissRouter(String str, ICallBackWsTserviceTeamDismiss iCallBackWsTserviceTeamDismiss, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamDismiss);
    }

    protected CallBackWsTserviceTeamDismissRouter(String str, ICallBackWsTserviceTeamDismiss iCallBackWsTserviceTeamDismiss) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamDismiss);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamDismissImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamDismissImpl
    public void onRecvAck(GWsTserviceTeamDismissResponseParam gWsTserviceTeamDismissResponseParam) {
        ICallBackWsTserviceTeamDismiss iCallBackWsTserviceTeamDismiss = this.mObserver;
        if (iCallBackWsTserviceTeamDismiss != null) {
            iCallBackWsTserviceTeamDismiss.onRecvAck(gWsTserviceTeamDismissResponseParam);
        }
    }
}
