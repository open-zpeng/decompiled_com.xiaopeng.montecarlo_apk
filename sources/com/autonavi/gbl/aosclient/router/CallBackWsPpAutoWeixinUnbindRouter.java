package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinUnbindResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAutoWeixinUnbind;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinUnbindImpl;
@IntfAuto(target = ICallBackWsPpAutoWeixinUnbind.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsPpAutoWeixinUnbindRouter extends ICallBackWsPpAutoWeixinUnbindImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsPpAutoWeixinUnbindRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsPpAutoWeixinUnbindRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsPpAutoWeixinUnbind mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsPpAutoWeixinUnbind iCallBackWsPpAutoWeixinUnbind) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsPpAutoWeixinUnbindImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsPpAutoWeixinUnbind;
    }

    protected CallBackWsPpAutoWeixinUnbindRouter(String str, ICallBackWsPpAutoWeixinUnbind iCallBackWsPpAutoWeixinUnbind, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpAutoWeixinUnbind);
    }

    protected CallBackWsPpAutoWeixinUnbindRouter(String str, ICallBackWsPpAutoWeixinUnbind iCallBackWsPpAutoWeixinUnbind) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpAutoWeixinUnbind);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinUnbindImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinUnbindImpl
    public void onRecvAck(GWsPpAutoWeixinUnbindResponseParam gWsPpAutoWeixinUnbindResponseParam) {
        ICallBackWsPpAutoWeixinUnbind iCallBackWsPpAutoWeixinUnbind = this.mObserver;
        if (iCallBackWsPpAutoWeixinUnbind != null) {
            iCallBackWsPpAutoWeixinUnbind.onRecvAck(gWsPpAutoWeixinUnbindResponseParam);
        }
    }
}
