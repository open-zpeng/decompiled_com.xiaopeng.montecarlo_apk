package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsMapapiLinkidsResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiLinkids;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiLinkidsImpl;
@IntfAuto(target = ICallBackWsMapapiLinkids.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsMapapiLinkidsRouter extends ICallBackWsMapapiLinkidsImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsMapapiLinkidsRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsMapapiLinkidsRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsMapapiLinkids mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsMapapiLinkids iCallBackWsMapapiLinkids) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsMapapiLinkidsImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsMapapiLinkids;
    }

    protected CallBackWsMapapiLinkidsRouter(String str, ICallBackWsMapapiLinkids iCallBackWsMapapiLinkids, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiLinkids);
    }

    protected CallBackWsMapapiLinkidsRouter(String str, ICallBackWsMapapiLinkids iCallBackWsMapapiLinkids) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiLinkids);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiLinkidsImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiLinkidsImpl
    public void onRecvAck(GWsMapapiLinkidsResponseParam gWsMapapiLinkidsResponseParam) {
        ICallBackWsMapapiLinkids iCallBackWsMapapiLinkids = this.mObserver;
        if (iCallBackWsMapapiLinkids != null) {
            iCallBackWsMapapiLinkids.onRecvAck(gWsMapapiLinkidsResponseParam);
        }
    }
}
