package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcAlscOrderCancelResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcAlscOrderCancel;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcAlscOrderCancelImpl;
@IntfAuto(target = ICallBackWsTcAlscOrderCancel.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcAlscOrderCancelRouter extends ICallBackWsTcAlscOrderCancelImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcAlscOrderCancelRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcAlscOrderCancelRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcAlscOrderCancel mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcAlscOrderCancel iCallBackWsTcAlscOrderCancel) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcAlscOrderCancelImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcAlscOrderCancel;
    }

    protected CallBackWsTcAlscOrderCancelRouter(String str, ICallBackWsTcAlscOrderCancel iCallBackWsTcAlscOrderCancel, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcAlscOrderCancel);
    }

    protected CallBackWsTcAlscOrderCancelRouter(String str, ICallBackWsTcAlscOrderCancel iCallBackWsTcAlscOrderCancel) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcAlscOrderCancel);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcAlscOrderCancelImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcAlscOrderCancelImpl
    public void onRecvAck(GWsTcAlscOrderCancelResponseParam gWsTcAlscOrderCancelResponseParam) {
        ICallBackWsTcAlscOrderCancel iCallBackWsTcAlscOrderCancel = this.mObserver;
        if (iCallBackWsTcAlscOrderCancel != null) {
            iCallBackWsTcAlscOrderCancel.onRecvAck(gWsTcAlscOrderCancelResponseParam);
        }
    }
}
