package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceDatainterflowGetResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceDatainterflowGet;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceDatainterflowGetImpl;
@IntfAuto(target = ICallBackWsTserviceDatainterflowGet.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceDatainterflowGetRouter extends ICallBackWsTserviceDatainterflowGetImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceDatainterflowGetRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceDatainterflowGetRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceDatainterflowGet mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceDatainterflowGet iCallBackWsTserviceDatainterflowGet) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceDatainterflowGetImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceDatainterflowGet;
    }

    protected CallBackWsTserviceDatainterflowGetRouter(String str, ICallBackWsTserviceDatainterflowGet iCallBackWsTserviceDatainterflowGet, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceDatainterflowGet);
    }

    protected CallBackWsTserviceDatainterflowGetRouter(String str, ICallBackWsTserviceDatainterflowGet iCallBackWsTserviceDatainterflowGet) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceDatainterflowGet);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceDatainterflowGetImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceDatainterflowGetImpl
    public void onRecvAck(GWsTserviceDatainterflowGetResponseParam gWsTserviceDatainterflowGetResponseParam) {
        ICallBackWsTserviceDatainterflowGet iCallBackWsTserviceDatainterflowGet = this.mObserver;
        if (iCallBackWsTserviceDatainterflowGet != null) {
            iCallBackWsTserviceDatainterflowGet.onRecvAck(gWsTserviceDatainterflowGetResponseParam);
        }
    }
}
