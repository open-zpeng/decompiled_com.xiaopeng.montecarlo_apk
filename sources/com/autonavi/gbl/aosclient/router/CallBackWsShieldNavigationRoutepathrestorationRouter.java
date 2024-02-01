package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsShieldNavigationRoutepathrestorationResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldNavigationRoutepathrestoration;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldNavigationRoutepathrestorationImpl;
@IntfAuto(target = ICallBackWsShieldNavigationRoutepathrestoration.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsShieldNavigationRoutepathrestorationRouter extends ICallBackWsShieldNavigationRoutepathrestorationImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsShieldNavigationRoutepathrestorationRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsShieldNavigationRoutepathrestorationRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsShieldNavigationRoutepathrestoration mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsShieldNavigationRoutepathrestoration iCallBackWsShieldNavigationRoutepathrestoration) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsShieldNavigationRoutepathrestorationImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsShieldNavigationRoutepathrestoration;
    }

    protected CallBackWsShieldNavigationRoutepathrestorationRouter(String str, ICallBackWsShieldNavigationRoutepathrestoration iCallBackWsShieldNavigationRoutepathrestoration, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsShieldNavigationRoutepathrestoration);
    }

    protected CallBackWsShieldNavigationRoutepathrestorationRouter(String str, ICallBackWsShieldNavigationRoutepathrestoration iCallBackWsShieldNavigationRoutepathrestoration) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsShieldNavigationRoutepathrestoration);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldNavigationRoutepathrestorationImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldNavigationRoutepathrestorationImpl
    public void onRecvAck(GWsShieldNavigationRoutepathrestorationResponseParam gWsShieldNavigationRoutepathrestorationResponseParam) {
        ICallBackWsShieldNavigationRoutepathrestoration iCallBackWsShieldNavigationRoutepathrestoration = this.mObserver;
        if (iCallBackWsShieldNavigationRoutepathrestoration != null) {
            iCallBackWsShieldNavigationRoutepathrestoration.onRecvAck(gWsShieldNavigationRoutepathrestorationResponseParam);
        }
    }
}
