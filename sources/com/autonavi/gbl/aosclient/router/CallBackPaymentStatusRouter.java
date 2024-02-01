package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GPaymentStatusResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackPaymentStatus;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackPaymentStatusImpl;
@IntfAuto(target = ICallBackPaymentStatus.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackPaymentStatusRouter extends ICallBackPaymentStatusImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackPaymentStatusRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackPaymentStatusRouter.class);
    private TypeHelper mHelper;
    private ICallBackPaymentStatus mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackPaymentStatus iCallBackPaymentStatus) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackPaymentStatusImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackPaymentStatus;
    }

    protected CallBackPaymentStatusRouter(String str, ICallBackPaymentStatus iCallBackPaymentStatus, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackPaymentStatus);
    }

    protected CallBackPaymentStatusRouter(String str, ICallBackPaymentStatus iCallBackPaymentStatus) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackPaymentStatus);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackPaymentStatusImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackPaymentStatusImpl
    public void onRecvAck(GPaymentStatusResponseParam gPaymentStatusResponseParam) {
        ICallBackPaymentStatus iCallBackPaymentStatus = this.mObserver;
        if (iCallBackPaymentStatus != null) {
            iCallBackPaymentStatus.onRecvAck(gPaymentStatusResponseParam);
        }
    }
}
