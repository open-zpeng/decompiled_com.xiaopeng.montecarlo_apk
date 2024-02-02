package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamQuitResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamQuit;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamQuitImpl;
@IntfAuto(target = ICallBackWsTserviceTeamQuit.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceTeamQuitRouter extends ICallBackWsTserviceTeamQuitImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceTeamQuitRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceTeamQuitRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceTeamQuit mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceTeamQuit iCallBackWsTserviceTeamQuit) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceTeamQuitImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceTeamQuit;
    }

    protected CallBackWsTserviceTeamQuitRouter(String str, ICallBackWsTserviceTeamQuit iCallBackWsTserviceTeamQuit, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamQuit);
    }

    protected CallBackWsTserviceTeamQuitRouter(String str, ICallBackWsTserviceTeamQuit iCallBackWsTserviceTeamQuit) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamQuit);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamQuitRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamQuitImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamQuitRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamQuitImpl
    public void onRecvAck(GWsTserviceTeamQuitResponseParam gWsTserviceTeamQuitResponseParam) {
        ICallBackWsTserviceTeamQuit iCallBackWsTserviceTeamQuit = this.mObserver;
        if (iCallBackWsTserviceTeamQuit != null) {
            iCallBackWsTserviceTeamQuit.onRecvAck(gWsTserviceTeamQuitResponseParam);
        }
    }
}
