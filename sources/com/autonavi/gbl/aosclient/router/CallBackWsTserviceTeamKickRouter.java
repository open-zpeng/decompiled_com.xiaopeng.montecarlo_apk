package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamKickResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamKick;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamKickImpl;
@IntfAuto(target = ICallBackWsTserviceTeamKick.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceTeamKickRouter extends ICallBackWsTserviceTeamKickImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceTeamKickRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceTeamKickRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceTeamKick mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceTeamKick iCallBackWsTserviceTeamKick) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceTeamKickImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceTeamKick;
    }

    protected CallBackWsTserviceTeamKickRouter(String str, ICallBackWsTserviceTeamKick iCallBackWsTserviceTeamKick, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamKick);
    }

    protected CallBackWsTserviceTeamKickRouter(String str, ICallBackWsTserviceTeamKick iCallBackWsTserviceTeamKick) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamKick);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamKickImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamKickImpl
    public void onRecvAck(GWsTserviceTeamKickResponseParam gWsTserviceTeamKickResponseParam) {
        ICallBackWsTserviceTeamKick iCallBackWsTserviceTeamKick = this.mObserver;
        if (iCallBackWsTserviceTeamKick != null) {
            iCallBackWsTserviceTeamKick.onRecvAck(gWsTserviceTeamKickResponseParam);
        }
    }
}
