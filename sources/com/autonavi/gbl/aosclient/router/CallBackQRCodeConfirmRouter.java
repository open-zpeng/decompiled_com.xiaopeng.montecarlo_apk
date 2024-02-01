package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GQRCodeConfirmResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackQRCodeConfirm;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackQRCodeConfirmImpl;
@IntfAuto(target = ICallBackQRCodeConfirm.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackQRCodeConfirmRouter extends ICallBackQRCodeConfirmImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackQRCodeConfirmRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackQRCodeConfirmRouter.class);
    private TypeHelper mHelper;
    private ICallBackQRCodeConfirm mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackQRCodeConfirm iCallBackQRCodeConfirm) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackQRCodeConfirmImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackQRCodeConfirm;
    }

    protected CallBackQRCodeConfirmRouter(String str, ICallBackQRCodeConfirm iCallBackQRCodeConfirm, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackQRCodeConfirm);
    }

    protected CallBackQRCodeConfirmRouter(String str, ICallBackQRCodeConfirm iCallBackQRCodeConfirm) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackQRCodeConfirm);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackQRCodeConfirmImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackQRCodeConfirmImpl
    public void onRecvAck(GQRCodeConfirmResponseParam gQRCodeConfirmResponseParam) {
        ICallBackQRCodeConfirm iCallBackQRCodeConfirm = this.mObserver;
        if (iCallBackQRCodeConfirm != null) {
            iCallBackQRCodeConfirm.onRecvAck(gQRCodeConfirmResponseParam);
        }
    }
}
