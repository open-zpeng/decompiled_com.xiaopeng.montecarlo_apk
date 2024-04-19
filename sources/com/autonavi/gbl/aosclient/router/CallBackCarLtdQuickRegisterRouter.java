package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GCarLtdQuickRegisterResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdQuickRegister;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdQuickRegisterImpl;
@IntfAuto(target = ICallBackCarLtdQuickRegister.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackCarLtdQuickRegisterRouter extends ICallBackCarLtdQuickRegisterImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackCarLtdQuickRegisterRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackCarLtdQuickRegisterRouter.class);
    private TypeHelper mHelper;
    private ICallBackCarLtdQuickRegister mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackCarLtdQuickRegister iCallBackCarLtdQuickRegister) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackCarLtdQuickRegisterImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackCarLtdQuickRegister;
    }

    protected CallBackCarLtdQuickRegisterRouter(String str, ICallBackCarLtdQuickRegister iCallBackCarLtdQuickRegister, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCarLtdQuickRegister);
    }

    protected CallBackCarLtdQuickRegisterRouter(String str, ICallBackCarLtdQuickRegister iCallBackCarLtdQuickRegister) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCarLtdQuickRegister);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackCarLtdQuickRegisterRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdQuickRegisterImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackCarLtdQuickRegisterRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdQuickRegisterImpl
    public void onRecvAck(GCarLtdQuickRegisterResponseParam gCarLtdQuickRegisterResponseParam) {
        ICallBackCarLtdQuickRegister iCallBackCarLtdQuickRegister = this.mObserver;
        if (iCallBackCarLtdQuickRegister != null) {
            iCallBackCarLtdQuickRegister.onRecvAck(gCarLtdQuickRegisterResponseParam);
        }
    }
}
