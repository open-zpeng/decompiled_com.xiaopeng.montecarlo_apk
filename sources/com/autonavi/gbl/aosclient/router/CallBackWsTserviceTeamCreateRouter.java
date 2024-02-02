package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamCreateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamCreate;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamCreateImpl;
@IntfAuto(target = ICallBackWsTserviceTeamCreate.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceTeamCreateRouter extends ICallBackWsTserviceTeamCreateImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceTeamCreateRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceTeamCreateRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceTeamCreate mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceTeamCreate iCallBackWsTserviceTeamCreate) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceTeamCreateImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceTeamCreate;
    }

    protected CallBackWsTserviceTeamCreateRouter(String str, ICallBackWsTserviceTeamCreate iCallBackWsTserviceTeamCreate, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamCreate);
    }

    protected CallBackWsTserviceTeamCreateRouter(String str, ICallBackWsTserviceTeamCreate iCallBackWsTserviceTeamCreate) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamCreate);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamCreateRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamCreateImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamCreateRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamCreateImpl
    public void onRecvAck(GWsTserviceTeamCreateResponseParam gWsTserviceTeamCreateResponseParam) {
        ICallBackWsTserviceTeamCreate iCallBackWsTserviceTeamCreate = this.mObserver;
        if (iCallBackWsTserviceTeamCreate != null) {
            iCallBackWsTserviceTeamCreate.onRecvAck(gWsTserviceTeamCreateResponseParam);
        }
    }
}
