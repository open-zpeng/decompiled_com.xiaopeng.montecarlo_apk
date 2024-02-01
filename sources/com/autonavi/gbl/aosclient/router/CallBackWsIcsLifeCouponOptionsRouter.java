package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsIcsLifeCouponOptionsResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsIcsLifeCouponOptions;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsIcsLifeCouponOptionsImpl;
@IntfAuto(target = ICallBackWsIcsLifeCouponOptions.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsIcsLifeCouponOptionsRouter extends ICallBackWsIcsLifeCouponOptionsImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsIcsLifeCouponOptionsRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsIcsLifeCouponOptionsRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsIcsLifeCouponOptions mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsIcsLifeCouponOptions iCallBackWsIcsLifeCouponOptions) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsIcsLifeCouponOptionsImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsIcsLifeCouponOptions;
    }

    protected CallBackWsIcsLifeCouponOptionsRouter(String str, ICallBackWsIcsLifeCouponOptions iCallBackWsIcsLifeCouponOptions, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsIcsLifeCouponOptions);
    }

    protected CallBackWsIcsLifeCouponOptionsRouter(String str, ICallBackWsIcsLifeCouponOptions iCallBackWsIcsLifeCouponOptions) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsIcsLifeCouponOptions);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsIcsLifeCouponOptionsImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsIcsLifeCouponOptionsImpl
    public void onRecvAck(GWsIcsLifeCouponOptionsResponseParam gWsIcsLifeCouponOptionsResponseParam) {
        ICallBackWsIcsLifeCouponOptions iCallBackWsIcsLifeCouponOptions = this.mObserver;
        if (iCallBackWsIcsLifeCouponOptions != null) {
            iCallBackWsIcsLifeCouponOptions.onRecvAck(gWsIcsLifeCouponOptionsResponseParam);
        }
    }
}
