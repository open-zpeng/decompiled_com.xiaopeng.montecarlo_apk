package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcCarServiceSubmitResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCarServiceSubmit;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCarServiceSubmitImpl;
@IntfAuto(target = ICallBackWsTcCarServiceSubmit.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcCarServiceSubmitRouter extends ICallBackWsTcCarServiceSubmitImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcCarServiceSubmitRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcCarServiceSubmitRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcCarServiceSubmit mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcCarServiceSubmit iCallBackWsTcCarServiceSubmit) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcCarServiceSubmitImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcCarServiceSubmit;
    }

    protected CallBackWsTcCarServiceSubmitRouter(String str, ICallBackWsTcCarServiceSubmit iCallBackWsTcCarServiceSubmit, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcCarServiceSubmit);
    }

    protected CallBackWsTcCarServiceSubmitRouter(String str, ICallBackWsTcCarServiceSubmit iCallBackWsTcCarServiceSubmit) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcCarServiceSubmit);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCarServiceSubmitImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCarServiceSubmitImpl
    public void onRecvAck(GWsTcCarServiceSubmitResponseParam gWsTcCarServiceSubmitResponseParam) {
        ICallBackWsTcCarServiceSubmit iCallBackWsTcCarServiceSubmit = this.mObserver;
        if (iCallBackWsTcCarServiceSubmit != null) {
            iCallBackWsTcCarServiceSubmit.onRecvAck(gWsTcCarServiceSubmitResponseParam);
        }
    }
}
