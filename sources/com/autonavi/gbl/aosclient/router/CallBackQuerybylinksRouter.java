package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GQuerybylinksResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackQuerybylinks;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackQuerybylinksImpl;
@IntfAuto(target = ICallBackQuerybylinks.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackQuerybylinksRouter extends ICallBackQuerybylinksImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackQuerybylinksRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackQuerybylinksRouter.class);
    private TypeHelper mHelper;
    private ICallBackQuerybylinks mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackQuerybylinks iCallBackQuerybylinks) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackQuerybylinksImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackQuerybylinks;
    }

    protected CallBackQuerybylinksRouter(String str, ICallBackQuerybylinks iCallBackQuerybylinks, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackQuerybylinks);
    }

    protected CallBackQuerybylinksRouter(String str, ICallBackQuerybylinks iCallBackQuerybylinks) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackQuerybylinks);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackQuerybylinksImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackQuerybylinksImpl
    public void onRecvAck(GQuerybylinksResponseParam gQuerybylinksResponseParam) {
        ICallBackQuerybylinks iCallBackQuerybylinks = this.mObserver;
        if (iCallBackQuerybylinks != null) {
            iCallBackQuerybylinks.onRecvAck(gQuerybylinksResponseParam);
        }
    }
}
