package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistLandingResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldSearchRanklistLanding;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistLandingImpl;
@IntfAuto(target = ICallBackWsShieldSearchRanklistLanding.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsShieldSearchRanklistLandingRouter extends ICallBackWsShieldSearchRanklistLandingImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsShieldSearchRanklistLandingRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsShieldSearchRanklistLandingRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsShieldSearchRanklistLanding mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsShieldSearchRanklistLanding iCallBackWsShieldSearchRanklistLanding) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsShieldSearchRanklistLandingImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsShieldSearchRanklistLanding;
    }

    protected CallBackWsShieldSearchRanklistLandingRouter(String str, ICallBackWsShieldSearchRanklistLanding iCallBackWsShieldSearchRanklistLanding, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsShieldSearchRanklistLanding);
    }

    protected CallBackWsShieldSearchRanklistLandingRouter(String str, ICallBackWsShieldSearchRanklistLanding iCallBackWsShieldSearchRanklistLanding) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsShieldSearchRanklistLanding);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistLandingImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistLandingImpl
    public void onRecvAck(GWsShieldSearchRanklistLandingResponseParam gWsShieldSearchRanklistLandingResponseParam) {
        ICallBackWsShieldSearchRanklistLanding iCallBackWsShieldSearchRanklistLanding = this.mObserver;
        if (iCallBackWsShieldSearchRanklistLanding != null) {
            iCallBackWsShieldSearchRanklistLanding.onRecvAck(gWsShieldSearchRanklistLandingResponseParam);
        }
    }
}
