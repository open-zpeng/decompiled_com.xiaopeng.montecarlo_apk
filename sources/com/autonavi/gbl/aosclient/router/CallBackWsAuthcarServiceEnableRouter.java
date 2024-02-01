package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServiceEnableResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAuthcarServiceEnable;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServiceEnableImpl;
@IntfAuto(target = ICallBackWsAuthcarServiceEnable.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsAuthcarServiceEnableRouter extends ICallBackWsAuthcarServiceEnableImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsAuthcarServiceEnableRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsAuthcarServiceEnableRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsAuthcarServiceEnable mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsAuthcarServiceEnable iCallBackWsAuthcarServiceEnable) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsAuthcarServiceEnableImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsAuthcarServiceEnable;
    }

    protected CallBackWsAuthcarServiceEnableRouter(String str, ICallBackWsAuthcarServiceEnable iCallBackWsAuthcarServiceEnable, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAuthcarServiceEnable);
    }

    protected CallBackWsAuthcarServiceEnableRouter(String str, ICallBackWsAuthcarServiceEnable iCallBackWsAuthcarServiceEnable) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAuthcarServiceEnable);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServiceEnableImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAuthcarServiceEnableImpl
    public void onRecvAck(GWsAuthcarServiceEnableResponseParam gWsAuthcarServiceEnableResponseParam) {
        ICallBackWsAuthcarServiceEnable iCallBackWsAuthcarServiceEnable = this.mObserver;
        if (iCallBackWsAuthcarServiceEnable != null) {
            iCallBackWsAuthcarServiceEnable.onRecvAck(gWsAuthcarServiceEnableResponseParam);
        }
    }
}
