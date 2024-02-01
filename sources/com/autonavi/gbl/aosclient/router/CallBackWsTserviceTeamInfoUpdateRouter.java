package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamInfoUpdateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamInfoUpdate;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamInfoUpdateImpl;
@IntfAuto(target = ICallBackWsTserviceTeamInfoUpdate.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceTeamInfoUpdateRouter extends ICallBackWsTserviceTeamInfoUpdateImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceTeamInfoUpdateRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceTeamInfoUpdateRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceTeamInfoUpdate mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceTeamInfoUpdate iCallBackWsTserviceTeamInfoUpdate) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceTeamInfoUpdateImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceTeamInfoUpdate;
    }

    protected CallBackWsTserviceTeamInfoUpdateRouter(String str, ICallBackWsTserviceTeamInfoUpdate iCallBackWsTserviceTeamInfoUpdate, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamInfoUpdate);
    }

    protected CallBackWsTserviceTeamInfoUpdateRouter(String str, ICallBackWsTserviceTeamInfoUpdate iCallBackWsTserviceTeamInfoUpdate) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamInfoUpdate);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamInfoUpdateImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamInfoUpdateImpl
    public void onRecvAck(GWsTserviceTeamInfoUpdateResponseParam gWsTserviceTeamInfoUpdateResponseParam) {
        ICallBackWsTserviceTeamInfoUpdate iCallBackWsTserviceTeamInfoUpdate = this.mObserver;
        if (iCallBackWsTserviceTeamInfoUpdate != null) {
            iCallBackWsTserviceTeamInfoUpdate.onRecvAck(gWsTserviceTeamInfoUpdateResponseParam);
        }
    }
}
