package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementStatusResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCommonAgreementStatus;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCommonAgreementStatusImpl;
@IntfAuto(target = ICallBackWsTcCommonAgreementStatus.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcCommonAgreementStatusRouter extends ICallBackWsTcCommonAgreementStatusImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcCommonAgreementStatusRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcCommonAgreementStatusRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcCommonAgreementStatus mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcCommonAgreementStatus iCallBackWsTcCommonAgreementStatus) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcCommonAgreementStatusImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcCommonAgreementStatus;
    }

    protected CallBackWsTcCommonAgreementStatusRouter(String str, ICallBackWsTcCommonAgreementStatus iCallBackWsTcCommonAgreementStatus, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcCommonAgreementStatus);
    }

    protected CallBackWsTcCommonAgreementStatusRouter(String str, ICallBackWsTcCommonAgreementStatus iCallBackWsTcCommonAgreementStatus) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcCommonAgreementStatus);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTcCommonAgreementStatusRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCommonAgreementStatusImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTcCommonAgreementStatusRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCommonAgreementStatusImpl
    public void onRecvAck(GWsTcCommonAgreementStatusResponseParam gWsTcCommonAgreementStatusResponseParam) {
        ICallBackWsTcCommonAgreementStatus iCallBackWsTcCommonAgreementStatus = this.mObserver;
        if (iCallBackWsTcCommonAgreementStatus != null) {
            iCallBackWsTcCommonAgreementStatus.onRecvAck(gWsTcCommonAgreementStatusResponseParam);
        }
    }
}
