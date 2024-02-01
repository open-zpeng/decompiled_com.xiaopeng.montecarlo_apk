package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcCarServiceOrderCancelResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCarServiceOrderCancel;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCarServiceOrderCancelImpl;
@IntfAuto(target = ICallBackWsTcCarServiceOrderCancel.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcCarServiceOrderCancelRouter extends ICallBackWsTcCarServiceOrderCancelImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcCarServiceOrderCancelRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcCarServiceOrderCancelRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcCarServiceOrderCancel mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcCarServiceOrderCancel iCallBackWsTcCarServiceOrderCancel) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcCarServiceOrderCancelImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcCarServiceOrderCancel;
    }

    protected CallBackWsTcCarServiceOrderCancelRouter(String str, ICallBackWsTcCarServiceOrderCancel iCallBackWsTcCarServiceOrderCancel, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcCarServiceOrderCancel);
    }

    protected CallBackWsTcCarServiceOrderCancelRouter(String str, ICallBackWsTcCarServiceOrderCancel iCallBackWsTcCarServiceOrderCancel) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcCarServiceOrderCancel);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCarServiceOrderCancelImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCarServiceOrderCancelImpl
    public void onRecvAck(GWsTcCarServiceOrderCancelResponseParam gWsTcCarServiceOrderCancelResponseParam) {
        ICallBackWsTcCarServiceOrderCancel iCallBackWsTcCarServiceOrderCancel = this.mObserver;
        if (iCallBackWsTcCarServiceOrderCancel != null) {
            iCallBackWsTcCarServiceOrderCancel.onRecvAck(gWsTcCarServiceOrderCancelResponseParam);
        }
    }
}
