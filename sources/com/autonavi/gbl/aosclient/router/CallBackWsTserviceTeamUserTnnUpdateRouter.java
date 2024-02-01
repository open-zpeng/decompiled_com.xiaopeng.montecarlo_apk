package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamUserTnnUpdateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamUserTnnUpdate;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamUserTnnUpdateImpl;
@IntfAuto(target = ICallBackWsTserviceTeamUserTnnUpdate.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceTeamUserTnnUpdateRouter extends ICallBackWsTserviceTeamUserTnnUpdateImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceTeamUserTnnUpdateRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceTeamUserTnnUpdateRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceTeamUserTnnUpdate mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceTeamUserTnnUpdate iCallBackWsTserviceTeamUserTnnUpdate) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceTeamUserTnnUpdateImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceTeamUserTnnUpdate;
    }

    protected CallBackWsTserviceTeamUserTnnUpdateRouter(String str, ICallBackWsTserviceTeamUserTnnUpdate iCallBackWsTserviceTeamUserTnnUpdate, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamUserTnnUpdate);
    }

    protected CallBackWsTserviceTeamUserTnnUpdateRouter(String str, ICallBackWsTserviceTeamUserTnnUpdate iCallBackWsTserviceTeamUserTnnUpdate) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamUserTnnUpdate);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamUserTnnUpdateImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamUserTnnUpdateImpl
    public void onRecvAck(GWsTserviceTeamUserTnnUpdateResponseParam gWsTserviceTeamUserTnnUpdateResponseParam) {
        ICallBackWsTserviceTeamUserTnnUpdate iCallBackWsTserviceTeamUserTnnUpdate = this.mObserver;
        if (iCallBackWsTserviceTeamUserTnnUpdate != null) {
            iCallBackWsTserviceTeamUserTnnUpdate.onRecvAck(gWsTserviceTeamUserTnnUpdateResponseParam);
        }
    }
}
