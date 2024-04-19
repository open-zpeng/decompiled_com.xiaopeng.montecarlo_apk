package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsCommerceInfraChargeRecordsWaitingEnableResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsCommerceInfraChargeRecordsWaitingEnable;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl;
@IntfAuto(target = ICallBackWsCommerceInfraChargeRecordsWaitingEnable.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsCommerceInfraChargeRecordsWaitingEnableRouter extends ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsCommerceInfraChargeRecordsWaitingEnableRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsCommerceInfraChargeRecordsWaitingEnableRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsCommerceInfraChargeRecordsWaitingEnable mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsCommerceInfraChargeRecordsWaitingEnable iCallBackWsCommerceInfraChargeRecordsWaitingEnable) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsCommerceInfraChargeRecordsWaitingEnable;
    }

    protected CallBackWsCommerceInfraChargeRecordsWaitingEnableRouter(String str, ICallBackWsCommerceInfraChargeRecordsWaitingEnable iCallBackWsCommerceInfraChargeRecordsWaitingEnable, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsCommerceInfraChargeRecordsWaitingEnable);
    }

    protected CallBackWsCommerceInfraChargeRecordsWaitingEnableRouter(String str, ICallBackWsCommerceInfraChargeRecordsWaitingEnable iCallBackWsCommerceInfraChargeRecordsWaitingEnable) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsCommerceInfraChargeRecordsWaitingEnable);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsCommerceInfraChargeRecordsWaitingEnableRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsCommerceInfraChargeRecordsWaitingEnableRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsCommerceInfraChargeRecordsWaitingEnableImpl
    public void onRecvAck(GWsCommerceInfraChargeRecordsWaitingEnableResponseParam gWsCommerceInfraChargeRecordsWaitingEnableResponseParam) {
        ICallBackWsCommerceInfraChargeRecordsWaitingEnable iCallBackWsCommerceInfraChargeRecordsWaitingEnable = this.mObserver;
        if (iCallBackWsCommerceInfraChargeRecordsWaitingEnable != null) {
            iCallBackWsCommerceInfraChargeRecordsWaitingEnable.onRecvAck(gWsCommerceInfraChargeRecordsWaitingEnableResponseParam);
        }
    }
}
