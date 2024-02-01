package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GPaymentBindAlipayResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackPaymentBindAlipay;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackPaymentBindAlipayImpl;
@IntfAuto(target = ICallBackPaymentBindAlipay.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackPaymentBindAlipayRouter extends ICallBackPaymentBindAlipayImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackPaymentBindAlipayRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackPaymentBindAlipayRouter.class);
    private TypeHelper mHelper;
    private ICallBackPaymentBindAlipay mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackPaymentBindAlipay iCallBackPaymentBindAlipay) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackPaymentBindAlipayImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackPaymentBindAlipay;
    }

    protected CallBackPaymentBindAlipayRouter(String str, ICallBackPaymentBindAlipay iCallBackPaymentBindAlipay, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackPaymentBindAlipay);
    }

    protected CallBackPaymentBindAlipayRouter(String str, ICallBackPaymentBindAlipay iCallBackPaymentBindAlipay) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackPaymentBindAlipay);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackPaymentBindAlipayImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackPaymentBindAlipayImpl
    public void onRecvAck(GPaymentBindAlipayResponseParam gPaymentBindAlipayResponseParam) {
        ICallBackPaymentBindAlipay iCallBackPaymentBindAlipay = this.mObserver;
        if (iCallBackPaymentBindAlipay != null) {
            iCallBackPaymentBindAlipay.onRecvAck(gPaymentBindAlipayResponseParam);
        }
    }
}
