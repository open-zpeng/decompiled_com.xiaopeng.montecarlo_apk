package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcOrderDetailResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcOrderDetail;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcOrderDetailImpl;
@IntfAuto(target = ICallBackWsTcOrderDetail.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcOrderDetailRouter extends ICallBackWsTcOrderDetailImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcOrderDetailRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcOrderDetailRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcOrderDetail mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcOrderDetail iCallBackWsTcOrderDetail) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcOrderDetailImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcOrderDetail;
    }

    protected CallBackWsTcOrderDetailRouter(String str, ICallBackWsTcOrderDetail iCallBackWsTcOrderDetail, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcOrderDetail);
    }

    protected CallBackWsTcOrderDetailRouter(String str, ICallBackWsTcOrderDetail iCallBackWsTcOrderDetail) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcOrderDetail);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcOrderDetailImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcOrderDetailImpl
    public void onRecvAck(GWsTcOrderDetailResponseParam gWsTcOrderDetailResponseParam) {
        ICallBackWsTcOrderDetail iCallBackWsTcOrderDetail = this.mObserver;
        if (iCallBackWsTcOrderDetail != null) {
            iCallBackWsTcOrderDetail.onRecvAck(gWsTcOrderDetailResponseParam);
        }
    }
}
