package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamJoinResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamJoin;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamJoinImpl;
@IntfAuto(target = ICallBackWsTserviceTeamJoin.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceTeamJoinRouter extends ICallBackWsTserviceTeamJoinImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceTeamJoinRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceTeamJoinRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceTeamJoin mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceTeamJoin iCallBackWsTserviceTeamJoin) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceTeamJoinImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceTeamJoin;
    }

    protected CallBackWsTserviceTeamJoinRouter(String str, ICallBackWsTserviceTeamJoin iCallBackWsTserviceTeamJoin, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamJoin);
    }

    protected CallBackWsTserviceTeamJoinRouter(String str, ICallBackWsTserviceTeamJoin iCallBackWsTserviceTeamJoin) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamJoin);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamJoinImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamJoinImpl
    public void onRecvAck(GWsTserviceTeamJoinResponseParam gWsTserviceTeamJoinResponseParam) {
        ICallBackWsTserviceTeamJoin iCallBackWsTserviceTeamJoin = this.mObserver;
        if (iCallBackWsTserviceTeamJoin != null) {
            iCallBackWsTserviceTeamJoin.onRecvAck(gWsTserviceTeamJoinResponseParam);
        }
    }
}
