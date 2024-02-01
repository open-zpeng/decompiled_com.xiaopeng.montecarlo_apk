package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GParkServiceResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackParkService;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackParkServiceImpl;
@IntfAuto(target = ICallBackParkService.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackParkServiceRouter extends ICallBackParkServiceImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackParkServiceRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackParkServiceRouter.class);
    private TypeHelper mHelper;
    private ICallBackParkService mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackParkService iCallBackParkService) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackParkServiceImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackParkService;
    }

    protected CallBackParkServiceRouter(String str, ICallBackParkService iCallBackParkService, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackParkService);
    }

    protected CallBackParkServiceRouter(String str, ICallBackParkService iCallBackParkService) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackParkService);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackParkServiceImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackParkServiceImpl
    public void onRecvAck(GParkServiceResponseParam gParkServiceResponseParam) {
        ICallBackParkService iCallBackParkService = this.mObserver;
        if (iCallBackParkService != null) {
            iCallBackParkService.onRecvAck(gParkServiceResponseParam);
        }
    }
}
