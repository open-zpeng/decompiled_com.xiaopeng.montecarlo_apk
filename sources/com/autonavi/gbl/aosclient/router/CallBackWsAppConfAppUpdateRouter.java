package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsAppConfAppUpdateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAppConfAppUpdate;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAppConfAppUpdateImpl;
@IntfAuto(target = ICallBackWsAppConfAppUpdate.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsAppConfAppUpdateRouter extends ICallBackWsAppConfAppUpdateImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsAppConfAppUpdateRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsAppConfAppUpdateRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsAppConfAppUpdate mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsAppConfAppUpdate iCallBackWsAppConfAppUpdate) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsAppConfAppUpdateImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsAppConfAppUpdate;
    }

    protected CallBackWsAppConfAppUpdateRouter(String str, ICallBackWsAppConfAppUpdate iCallBackWsAppConfAppUpdate, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAppConfAppUpdate);
    }

    protected CallBackWsAppConfAppUpdateRouter(String str, ICallBackWsAppConfAppUpdate iCallBackWsAppConfAppUpdate) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAppConfAppUpdate);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAppConfAppUpdateImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAppConfAppUpdateImpl
    public void onRecvAck(GWsAppConfAppUpdateResponseParam gWsAppConfAppUpdateResponseParam) {
        ICallBackWsAppConfAppUpdate iCallBackWsAppConfAppUpdate = this.mObserver;
        if (iCallBackWsAppConfAppUpdate != null) {
            iCallBackWsAppConfAppUpdate.onRecvAck(gWsAppConfAppUpdateResponseParam);
        }
    }
}
