package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistPortalResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldSearchRanklistPortal;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistPortalImpl;
@IntfAuto(target = ICallBackWsShieldSearchRanklistPortal.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsShieldSearchRanklistPortalRouter extends ICallBackWsShieldSearchRanklistPortalImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsShieldSearchRanklistPortalRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsShieldSearchRanklistPortalRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsShieldSearchRanklistPortal mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsShieldSearchRanklistPortal iCallBackWsShieldSearchRanklistPortal) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsShieldSearchRanklistPortalImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsShieldSearchRanklistPortal;
    }

    protected CallBackWsShieldSearchRanklistPortalRouter(String str, ICallBackWsShieldSearchRanklistPortal iCallBackWsShieldSearchRanklistPortal, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsShieldSearchRanklistPortal);
    }

    protected CallBackWsShieldSearchRanklistPortalRouter(String str, ICallBackWsShieldSearchRanklistPortal iCallBackWsShieldSearchRanklistPortal) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsShieldSearchRanklistPortal);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistPortalImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistPortalImpl
    public void onRecvAck(GWsShieldSearchRanklistPortalResponseParam gWsShieldSearchRanklistPortalResponseParam) {
        ICallBackWsShieldSearchRanklistPortal iCallBackWsShieldSearchRanklistPortal = this.mObserver;
        if (iCallBackWsShieldSearchRanklistPortal != null) {
            iCallBackWsShieldSearchRanklistPortal.onRecvAck(gWsShieldSearchRanklistPortalResponseParam);
        }
    }
}
