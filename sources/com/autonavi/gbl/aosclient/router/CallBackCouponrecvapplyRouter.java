package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GCouponrecvapplyResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCouponrecvapply;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCouponrecvapplyImpl;
@IntfAuto(target = ICallBackCouponrecvapply.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackCouponrecvapplyRouter extends ICallBackCouponrecvapplyImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackCouponrecvapplyRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackCouponrecvapplyRouter.class);
    private TypeHelper mHelper;
    private ICallBackCouponrecvapply mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackCouponrecvapply iCallBackCouponrecvapply) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackCouponrecvapplyImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackCouponrecvapply;
    }

    protected CallBackCouponrecvapplyRouter(String str, ICallBackCouponrecvapply iCallBackCouponrecvapply, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCouponrecvapply);
    }

    protected CallBackCouponrecvapplyRouter(String str, ICallBackCouponrecvapply iCallBackCouponrecvapply) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCouponrecvapply);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCouponrecvapplyImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCouponrecvapplyImpl
    public void onRecvAck(GCouponrecvapplyResponseParam gCouponrecvapplyResponseParam) {
        ICallBackCouponrecvapply iCallBackCouponrecvapply = this.mObserver;
        if (iCallBackCouponrecvapply != null) {
            iCallBackCouponrecvapply.onRecvAck(gCouponrecvapplyResponseParam);
        }
    }
}
