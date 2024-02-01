package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GNavigationEtaqueryResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackNavigationEtaquery;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackNavigationEtaqueryImpl;
@IntfAuto(target = ICallBackNavigationEtaquery.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackNavigationEtaqueryRouter extends ICallBackNavigationEtaqueryImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackNavigationEtaqueryRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackNavigationEtaqueryRouter.class);
    private TypeHelper mHelper;
    private ICallBackNavigationEtaquery mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackNavigationEtaquery iCallBackNavigationEtaquery) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackNavigationEtaqueryImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackNavigationEtaquery;
    }

    protected CallBackNavigationEtaqueryRouter(String str, ICallBackNavigationEtaquery iCallBackNavigationEtaquery, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackNavigationEtaquery);
    }

    protected CallBackNavigationEtaqueryRouter(String str, ICallBackNavigationEtaquery iCallBackNavigationEtaquery) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackNavigationEtaquery);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackNavigationEtaqueryImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackNavigationEtaqueryImpl
    public void onRecvAck(GNavigationEtaqueryResponseParam gNavigationEtaqueryResponseParam) {
        ICallBackNavigationEtaquery iCallBackNavigationEtaquery = this.mObserver;
        if (iCallBackNavigationEtaquery != null) {
            iCallBackNavigationEtaquery.onRecvAck(gNavigationEtaqueryResponseParam);
        }
    }
}
