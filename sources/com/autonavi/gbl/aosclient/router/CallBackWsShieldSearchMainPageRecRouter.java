package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchMainPageRecResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldSearchMainPageRec;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchMainPageRecImpl;
@IntfAuto(target = ICallBackWsShieldSearchMainPageRec.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsShieldSearchMainPageRecRouter extends ICallBackWsShieldSearchMainPageRecImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsShieldSearchMainPageRecRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsShieldSearchMainPageRecRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsShieldSearchMainPageRec mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsShieldSearchMainPageRec iCallBackWsShieldSearchMainPageRec) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsShieldSearchMainPageRecImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsShieldSearchMainPageRec;
    }

    protected CallBackWsShieldSearchMainPageRecRouter(String str, ICallBackWsShieldSearchMainPageRec iCallBackWsShieldSearchMainPageRec, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsShieldSearchMainPageRec);
    }

    protected CallBackWsShieldSearchMainPageRecRouter(String str, ICallBackWsShieldSearchMainPageRec iCallBackWsShieldSearchMainPageRec) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsShieldSearchMainPageRec);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchMainPageRecImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchMainPageRecImpl
    public void onRecvAck(GWsShieldSearchMainPageRecResponseParam gWsShieldSearchMainPageRecResponseParam) {
        ICallBackWsShieldSearchMainPageRec iCallBackWsShieldSearchMainPageRec = this.mObserver;
        if (iCallBackWsShieldSearchMainPageRec != null) {
            iCallBackWsShieldSearchMainPageRec.onRecvAck(gWsShieldSearchMainPageRecResponseParam);
        }
    }
}
