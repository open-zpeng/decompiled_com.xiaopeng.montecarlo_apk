package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementOrderquickpayResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCommonAgreementOrderquickpay;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCommonAgreementOrderquickpayImpl;
@IntfAuto(target = ICallBackWsTcCommonAgreementOrderquickpay.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcCommonAgreementOrderquickpayRouter extends ICallBackWsTcCommonAgreementOrderquickpayImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcCommonAgreementOrderquickpayRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcCommonAgreementOrderquickpayRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcCommonAgreementOrderquickpay mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcCommonAgreementOrderquickpay iCallBackWsTcCommonAgreementOrderquickpay) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcCommonAgreementOrderquickpayImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcCommonAgreementOrderquickpay;
    }

    protected CallBackWsTcCommonAgreementOrderquickpayRouter(String str, ICallBackWsTcCommonAgreementOrderquickpay iCallBackWsTcCommonAgreementOrderquickpay, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcCommonAgreementOrderquickpay);
    }

    protected CallBackWsTcCommonAgreementOrderquickpayRouter(String str, ICallBackWsTcCommonAgreementOrderquickpay iCallBackWsTcCommonAgreementOrderquickpay) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcCommonAgreementOrderquickpay);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCommonAgreementOrderquickpayImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCommonAgreementOrderquickpayImpl
    public void onRecvAck(GWsTcCommonAgreementOrderquickpayResponseParam gWsTcCommonAgreementOrderquickpayResponseParam) {
        ICallBackWsTcCommonAgreementOrderquickpay iCallBackWsTcCommonAgreementOrderquickpay = this.mObserver;
        if (iCallBackWsTcCommonAgreementOrderquickpay != null) {
            iCallBackWsTcCommonAgreementOrderquickpay.onRecvAck(gWsTcCommonAgreementOrderquickpayResponseParam);
        }
    }
}
