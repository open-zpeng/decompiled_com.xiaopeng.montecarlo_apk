package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GTripodCompanyResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackTripodCompany;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackTripodCompanyImpl;
@IntfAuto(target = ICallBackTripodCompany.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackTripodCompanyRouter extends ICallBackTripodCompanyImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackTripodCompanyRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackTripodCompanyRouter.class);
    private TypeHelper mHelper;
    private ICallBackTripodCompany mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackTripodCompany iCallBackTripodCompany) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackTripodCompanyImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackTripodCompany;
    }

    protected CallBackTripodCompanyRouter(String str, ICallBackTripodCompany iCallBackTripodCompany, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackTripodCompany);
    }

    protected CallBackTripodCompanyRouter(String str, ICallBackTripodCompany iCallBackTripodCompany) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackTripodCompany);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackTripodCompanyRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackTripodCompanyImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackTripodCompanyRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackTripodCompanyImpl
    public void onRecvAck(GTripodCompanyResponseParam gTripodCompanyResponseParam) {
        ICallBackTripodCompany iCallBackTripodCompany = this.mObserver;
        if (iCallBackTripodCompany != null) {
            iCallBackTripodCompany.onRecvAck(gTripodCompanyResponseParam);
        }
    }
}
