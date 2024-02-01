package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GParkOrderDetailResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackParkOrderDetail;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackParkOrderDetailImpl;
@IntfAuto(target = ICallBackParkOrderDetail.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackParkOrderDetailRouter extends ICallBackParkOrderDetailImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackParkOrderDetailRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackParkOrderDetailRouter.class);
    private TypeHelper mHelper;
    private ICallBackParkOrderDetail mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackParkOrderDetail iCallBackParkOrderDetail) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackParkOrderDetailImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackParkOrderDetail;
    }

    protected CallBackParkOrderDetailRouter(String str, ICallBackParkOrderDetail iCallBackParkOrderDetail, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackParkOrderDetail);
    }

    protected CallBackParkOrderDetailRouter(String str, ICallBackParkOrderDetail iCallBackParkOrderDetail) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackParkOrderDetail);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackParkOrderDetailImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackParkOrderDetailImpl
    public void onRecvAck(GParkOrderDetailResponseParam gParkOrderDetailResponseParam) {
        ICallBackParkOrderDetail iCallBackParkOrderDetail = this.mObserver;
        if (iCallBackParkOrderDetail != null) {
            iCallBackParkOrderDetail.onRecvAck(gParkOrderDetailResponseParam);
        }
    }
}
