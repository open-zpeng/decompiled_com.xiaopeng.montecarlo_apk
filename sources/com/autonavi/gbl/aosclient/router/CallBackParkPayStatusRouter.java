package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GParkPayStatusResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackParkPayStatus;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackParkPayStatusImpl;
@IntfAuto(target = ICallBackParkPayStatus.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackParkPayStatusRouter extends ICallBackParkPayStatusImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackParkPayStatusRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackParkPayStatusRouter.class);
    private TypeHelper mHelper;
    private ICallBackParkPayStatus mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackParkPayStatus iCallBackParkPayStatus) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackParkPayStatusImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackParkPayStatus;
    }

    protected CallBackParkPayStatusRouter(String str, ICallBackParkPayStatus iCallBackParkPayStatus, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackParkPayStatus);
    }

    protected CallBackParkPayStatusRouter(String str, ICallBackParkPayStatus iCallBackParkPayStatus) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackParkPayStatus);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackParkPayStatusRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackParkPayStatusImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackParkPayStatusRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackParkPayStatusImpl
    public void onRecvAck(GParkPayStatusResponseParam gParkPayStatusResponseParam) {
        ICallBackParkPayStatus iCallBackParkPayStatus = this.mObserver;
        if (iCallBackParkPayStatus != null) {
            iCallBackParkPayStatus.onRecvAck(gParkPayStatusResponseParam);
        }
    }
}
