package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsMiniappCarVipGwResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMiniappCarVipGw;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMiniappCarVipGwImpl;
@IntfAuto(target = ICallBackWsMiniappCarVipGw.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsMiniappCarVipGwRouter extends ICallBackWsMiniappCarVipGwImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsMiniappCarVipGwRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsMiniappCarVipGwRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsMiniappCarVipGw mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsMiniappCarVipGw iCallBackWsMiniappCarVipGw) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsMiniappCarVipGwImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsMiniappCarVipGw;
    }

    protected CallBackWsMiniappCarVipGwRouter(String str, ICallBackWsMiniappCarVipGw iCallBackWsMiniappCarVipGw, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMiniappCarVipGw);
    }

    protected CallBackWsMiniappCarVipGwRouter(String str, ICallBackWsMiniappCarVipGw iCallBackWsMiniappCarVipGw) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMiniappCarVipGw);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMiniappCarVipGwImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMiniappCarVipGwImpl
    public void onRecvAck(GWsMiniappCarVipGwResponseParam gWsMiniappCarVipGwResponseParam) {
        ICallBackWsMiniappCarVipGw iCallBackWsMiniappCarVipGw = this.mObserver;
        if (iCallBackWsMiniappCarVipGw != null) {
            iCallBackWsMiniappCarVipGw.onRecvAck(gWsMiniappCarVipGwResponseParam);
        }
    }
}
