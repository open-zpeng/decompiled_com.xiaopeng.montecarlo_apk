package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GImGetAppuidResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackImGetAppuid;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackImGetAppuidImpl;
@IntfAuto(target = ICallBackImGetAppuid.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackImGetAppuidRouter extends ICallBackImGetAppuidImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackImGetAppuidRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackImGetAppuidRouter.class);
    private TypeHelper mHelper;
    private ICallBackImGetAppuid mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackImGetAppuid iCallBackImGetAppuid) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackImGetAppuidImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackImGetAppuid;
    }

    protected CallBackImGetAppuidRouter(String str, ICallBackImGetAppuid iCallBackImGetAppuid, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackImGetAppuid);
    }

    protected CallBackImGetAppuidRouter(String str, ICallBackImGetAppuid iCallBackImGetAppuid) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackImGetAppuid);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackImGetAppuidImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackImGetAppuidImpl
    public void onRecvAck(GImGetAppuidResponseParam gImGetAppuidResponseParam) {
        ICallBackImGetAppuid iCallBackImGetAppuid = this.mObserver;
        if (iCallBackImGetAppuid != null) {
            iCallBackImGetAppuid.onRecvAck(gImGetAppuidResponseParam);
        }
    }
}
