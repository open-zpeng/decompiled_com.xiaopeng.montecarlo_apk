package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServicelistResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAuthcarServicelist;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServicelistImpl;
@IntfAuto(target = ICallBackWsAuthcarServicelist.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsAuthcarServicelistRouter extends ICallBackWsAuthcarServicelistImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsAuthcarServicelistRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsAuthcarServicelistRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsAuthcarServicelist mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsAuthcarServicelist iCallBackWsAuthcarServicelist) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsAuthcarServicelistImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsAuthcarServicelist;
    }

    protected CallBackWsAuthcarServicelistRouter(String str, ICallBackWsAuthcarServicelist iCallBackWsAuthcarServicelist, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAuthcarServicelist);
    }

    protected CallBackWsAuthcarServicelistRouter(String str, ICallBackWsAuthcarServicelist iCallBackWsAuthcarServicelist) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAuthcarServicelist);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServicelistImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServicelistImpl
    public void onRecvAck(GWsAuthcarServicelistResponseParam gWsAuthcarServicelistResponseParam) {
        ICallBackWsAuthcarServicelist iCallBackWsAuthcarServicelist = this.mObserver;
        if (iCallBackWsAuthcarServicelist != null) {
            iCallBackWsAuthcarServicelist.onRecvAck(gWsAuthcarServicelistResponseParam);
        }
    }
}
