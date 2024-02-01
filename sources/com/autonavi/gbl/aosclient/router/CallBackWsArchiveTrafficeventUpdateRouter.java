package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsArchiveTrafficeventUpdateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsArchiveTrafficeventUpdate;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsArchiveTrafficeventUpdateImpl;
@IntfAuto(target = ICallBackWsArchiveTrafficeventUpdate.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsArchiveTrafficeventUpdateRouter extends ICallBackWsArchiveTrafficeventUpdateImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsArchiveTrafficeventUpdateRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsArchiveTrafficeventUpdateRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsArchiveTrafficeventUpdate mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsArchiveTrafficeventUpdate iCallBackWsArchiveTrafficeventUpdate) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsArchiveTrafficeventUpdateImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsArchiveTrafficeventUpdate;
    }

    protected CallBackWsArchiveTrafficeventUpdateRouter(String str, ICallBackWsArchiveTrafficeventUpdate iCallBackWsArchiveTrafficeventUpdate, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsArchiveTrafficeventUpdate);
    }

    protected CallBackWsArchiveTrafficeventUpdateRouter(String str, ICallBackWsArchiveTrafficeventUpdate iCallBackWsArchiveTrafficeventUpdate) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsArchiveTrafficeventUpdate);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsArchiveTrafficeventUpdateImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsArchiveTrafficeventUpdateImpl
    public void onRecvAck(GWsArchiveTrafficeventUpdateResponseParam gWsArchiveTrafficeventUpdateResponseParam) {
        ICallBackWsArchiveTrafficeventUpdate iCallBackWsArchiveTrafficeventUpdate = this.mObserver;
        if (iCallBackWsArchiveTrafficeventUpdate != null) {
            iCallBackWsArchiveTrafficeventUpdate.onRecvAck(gWsArchiveTrafficeventUpdateResponseParam);
        }
    }
}
