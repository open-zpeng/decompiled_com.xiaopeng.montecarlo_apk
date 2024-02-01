package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsPpAccountProfileUpdateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAccountProfileUpdate;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAccountProfileUpdateImpl;
@IntfAuto(target = ICallBackWsPpAccountProfileUpdate.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsPpAccountProfileUpdateRouter extends ICallBackWsPpAccountProfileUpdateImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsPpAccountProfileUpdateRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsPpAccountProfileUpdateRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsPpAccountProfileUpdate mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsPpAccountProfileUpdate iCallBackWsPpAccountProfileUpdate) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsPpAccountProfileUpdateImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsPpAccountProfileUpdate;
    }

    protected CallBackWsPpAccountProfileUpdateRouter(String str, ICallBackWsPpAccountProfileUpdate iCallBackWsPpAccountProfileUpdate, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpAccountProfileUpdate);
    }

    protected CallBackWsPpAccountProfileUpdateRouter(String str, ICallBackWsPpAccountProfileUpdate iCallBackWsPpAccountProfileUpdate) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpAccountProfileUpdate);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAccountProfileUpdateImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAccountProfileUpdateImpl
    public void onRecvAck(GWsPpAccountProfileUpdateResponseParam gWsPpAccountProfileUpdateResponseParam) {
        ICallBackWsPpAccountProfileUpdate iCallBackWsPpAccountProfileUpdate = this.mObserver;
        if (iCallBackWsPpAccountProfileUpdate != null) {
            iCallBackWsPpAccountProfileUpdate.onRecvAck(gWsPpAccountProfileUpdateResponseParam);
        }
    }
}
