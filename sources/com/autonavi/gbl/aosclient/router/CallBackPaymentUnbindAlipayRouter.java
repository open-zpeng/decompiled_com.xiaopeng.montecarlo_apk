package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GPaymentUnbindAlipayResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackPaymentUnbindAlipay;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackPaymentUnbindAlipayImpl;
@IntfAuto(target = ICallBackPaymentUnbindAlipay.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackPaymentUnbindAlipayRouter extends ICallBackPaymentUnbindAlipayImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackPaymentUnbindAlipayRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackPaymentUnbindAlipayRouter.class);
    private TypeHelper mHelper;
    private ICallBackPaymentUnbindAlipay mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackPaymentUnbindAlipay iCallBackPaymentUnbindAlipay) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackPaymentUnbindAlipayImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackPaymentUnbindAlipay;
    }

    protected CallBackPaymentUnbindAlipayRouter(String str, ICallBackPaymentUnbindAlipay iCallBackPaymentUnbindAlipay, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackPaymentUnbindAlipay);
    }

    protected CallBackPaymentUnbindAlipayRouter(String str, ICallBackPaymentUnbindAlipay iCallBackPaymentUnbindAlipay) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackPaymentUnbindAlipay);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackPaymentUnbindAlipayImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackPaymentUnbindAlipayImpl
    public void onRecvAck(GPaymentUnbindAlipayResponseParam gPaymentUnbindAlipayResponseParam) {
        ICallBackPaymentUnbindAlipay iCallBackPaymentUnbindAlipay = this.mObserver;
        if (iCallBackPaymentUnbindAlipay != null) {
            iCallBackPaymentUnbindAlipay.onRecvAck(gPaymentUnbindAlipayResponseParam);
        }
    }
}
