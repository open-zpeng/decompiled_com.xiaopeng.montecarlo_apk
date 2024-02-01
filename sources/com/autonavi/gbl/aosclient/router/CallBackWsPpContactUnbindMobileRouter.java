package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsPpContactUnbindMobileResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpContactUnbindMobile;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpContactUnbindMobileImpl;
@IntfAuto(target = ICallBackWsPpContactUnbindMobile.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsPpContactUnbindMobileRouter extends ICallBackWsPpContactUnbindMobileImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsPpContactUnbindMobileRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsPpContactUnbindMobileRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsPpContactUnbindMobile mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsPpContactUnbindMobile iCallBackWsPpContactUnbindMobile) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsPpContactUnbindMobileImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsPpContactUnbindMobile;
    }

    protected CallBackWsPpContactUnbindMobileRouter(String str, ICallBackWsPpContactUnbindMobile iCallBackWsPpContactUnbindMobile, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpContactUnbindMobile);
    }

    protected CallBackWsPpContactUnbindMobileRouter(String str, ICallBackWsPpContactUnbindMobile iCallBackWsPpContactUnbindMobile) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpContactUnbindMobile);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpContactUnbindMobileImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpContactUnbindMobileImpl
    public void onRecvAck(GWsPpContactUnbindMobileResponseParam gWsPpContactUnbindMobileResponseParam) {
        ICallBackWsPpContactUnbindMobile iCallBackWsPpContactUnbindMobile = this.mObserver;
        if (iCallBackWsPpContactUnbindMobile != null) {
            iCallBackWsPpContactUnbindMobile.onRecvAck(gWsPpContactUnbindMobileResponseParam);
        }
    }
}
