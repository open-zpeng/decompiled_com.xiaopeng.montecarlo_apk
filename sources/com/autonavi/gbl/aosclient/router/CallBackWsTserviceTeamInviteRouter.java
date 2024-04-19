package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamInviteResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamInvite;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamInviteImpl;
@IntfAuto(target = ICallBackWsTserviceTeamInvite.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceTeamInviteRouter extends ICallBackWsTserviceTeamInviteImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceTeamInviteRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceTeamInviteRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceTeamInvite mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceTeamInvite iCallBackWsTserviceTeamInvite) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceTeamInviteImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceTeamInvite;
    }

    protected CallBackWsTserviceTeamInviteRouter(String str, ICallBackWsTserviceTeamInvite iCallBackWsTserviceTeamInvite, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamInvite);
    }

    protected CallBackWsTserviceTeamInviteRouter(String str, ICallBackWsTserviceTeamInvite iCallBackWsTserviceTeamInvite) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamInvite);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamInviteRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamInviteImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamInviteRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamInviteImpl
    public void onRecvAck(GWsTserviceTeamInviteResponseParam gWsTserviceTeamInviteResponseParam) {
        ICallBackWsTserviceTeamInvite iCallBackWsTserviceTeamInvite = this.mObserver;
        if (iCallBackWsTserviceTeamInvite != null) {
            iCallBackWsTserviceTeamInvite.onRecvAck(gWsTserviceTeamInviteResponseParam);
        }
    }
}
