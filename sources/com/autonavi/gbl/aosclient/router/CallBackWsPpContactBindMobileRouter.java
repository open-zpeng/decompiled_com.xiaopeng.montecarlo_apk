package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsPpContactBindMobileResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpContactBindMobile;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpContactBindMobileImpl;
@IntfAuto(target = ICallBackWsPpContactBindMobile.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsPpContactBindMobileRouter extends ICallBackWsPpContactBindMobileImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsPpContactBindMobileRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsPpContactBindMobileRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsPpContactBindMobile mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsPpContactBindMobile iCallBackWsPpContactBindMobile) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsPpContactBindMobileImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsPpContactBindMobile;
    }

    protected CallBackWsPpContactBindMobileRouter(String str, ICallBackWsPpContactBindMobile iCallBackWsPpContactBindMobile, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpContactBindMobile);
    }

    protected CallBackWsPpContactBindMobileRouter(String str, ICallBackWsPpContactBindMobile iCallBackWsPpContactBindMobile) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpContactBindMobile);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpContactBindMobileImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpContactBindMobileImpl
    public void onRecvAck(GWsPpContactBindMobileResponseParam gWsPpContactBindMobileResponseParam) {
        ICallBackWsPpContactBindMobile iCallBackWsPpContactBindMobile = this.mObserver;
        if (iCallBackWsPpContactBindMobile != null) {
            iCallBackWsPpContactBindMobile.onRecvAck(gWsPpContactBindMobileResponseParam);
        }
    }
}
