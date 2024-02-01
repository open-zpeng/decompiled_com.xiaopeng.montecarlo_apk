package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GCancelSignPayResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCancelSignPay;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCancelSignPayImpl;
@IntfAuto(target = ICallBackCancelSignPay.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackCancelSignPayRouter extends ICallBackCancelSignPayImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackCancelSignPayRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackCancelSignPayRouter.class);
    private TypeHelper mHelper;
    private ICallBackCancelSignPay mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackCancelSignPay iCallBackCancelSignPay) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackCancelSignPayImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackCancelSignPay;
    }

    protected CallBackCancelSignPayRouter(String str, ICallBackCancelSignPay iCallBackCancelSignPay, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCancelSignPay);
    }

    protected CallBackCancelSignPayRouter(String str, ICallBackCancelSignPay iCallBackCancelSignPay) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCancelSignPay);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCancelSignPayImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCancelSignPayImpl
    public void onRecvAck(GCancelSignPayResponseParam gCancelSignPayResponseParam) {
        ICallBackCancelSignPay iCallBackCancelSignPay = this.mObserver;
        if (iCallBackCancelSignPay != null) {
            iCallBackCancelSignPay.onRecvAck(gCancelSignPayResponseParam);
        }
    }
}
