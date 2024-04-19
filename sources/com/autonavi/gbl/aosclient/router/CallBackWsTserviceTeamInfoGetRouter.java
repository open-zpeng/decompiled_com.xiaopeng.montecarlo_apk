package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamInfoGetResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamInfoGet;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamInfoGetImpl;
@IntfAuto(target = ICallBackWsTserviceTeamInfoGet.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceTeamInfoGetRouter extends ICallBackWsTserviceTeamInfoGetImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceTeamInfoGetRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceTeamInfoGetRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceTeamInfoGet mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceTeamInfoGet iCallBackWsTserviceTeamInfoGet) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceTeamInfoGetImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceTeamInfoGet;
    }

    protected CallBackWsTserviceTeamInfoGetRouter(String str, ICallBackWsTserviceTeamInfoGet iCallBackWsTserviceTeamInfoGet, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamInfoGet);
    }

    protected CallBackWsTserviceTeamInfoGetRouter(String str, ICallBackWsTserviceTeamInfoGet iCallBackWsTserviceTeamInfoGet) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamInfoGet);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamInfoGetRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamInfoGetImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamInfoGetRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamInfoGetImpl
    public void onRecvAck(GWsTserviceTeamInfoGetResponseParam gWsTserviceTeamInfoGetResponseParam) {
        ICallBackWsTserviceTeamInfoGet iCallBackWsTserviceTeamInfoGet = this.mObserver;
        if (iCallBackWsTserviceTeamInfoGet != null) {
            iCallBackWsTserviceTeamInfoGet.onRecvAck(gWsTserviceTeamInfoGetResponseParam);
        }
    }
}
