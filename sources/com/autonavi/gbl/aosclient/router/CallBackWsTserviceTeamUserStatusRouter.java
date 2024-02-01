package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamUserStatusResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamUserStatus;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamUserStatusImpl;
@IntfAuto(target = ICallBackWsTserviceTeamUserStatus.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceTeamUserStatusRouter extends ICallBackWsTserviceTeamUserStatusImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceTeamUserStatusRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceTeamUserStatusRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceTeamUserStatus mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceTeamUserStatus iCallBackWsTserviceTeamUserStatus) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceTeamUserStatusImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceTeamUserStatus;
    }

    protected CallBackWsTserviceTeamUserStatusRouter(String str, ICallBackWsTserviceTeamUserStatus iCallBackWsTserviceTeamUserStatus, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamUserStatus);
    }

    protected CallBackWsTserviceTeamUserStatusRouter(String str, ICallBackWsTserviceTeamUserStatus iCallBackWsTserviceTeamUserStatus) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamUserStatus);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamUserStatusImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamUserStatusImpl
    public void onRecvAck(GWsTserviceTeamUserStatusResponseParam gWsTserviceTeamUserStatusResponseParam) {
        ICallBackWsTserviceTeamUserStatus iCallBackWsTserviceTeamUserStatus = this.mObserver;
        if (iCallBackWsTserviceTeamUserStatus != null) {
            iCallBackWsTserviceTeamUserStatus.onRecvAck(gWsTserviceTeamUserStatusResponseParam);
        }
    }
}
