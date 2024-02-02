package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GCarLtdQuickLoginResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdQuickLogin;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdQuickLoginImpl;
@IntfAuto(target = ICallBackCarLtdQuickLogin.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackCarLtdQuickLoginRouter extends ICallBackCarLtdQuickLoginImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackCarLtdQuickLoginRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackCarLtdQuickLoginRouter.class);
    private TypeHelper mHelper;
    private ICallBackCarLtdQuickLogin mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackCarLtdQuickLogin iCallBackCarLtdQuickLogin) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackCarLtdQuickLoginImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackCarLtdQuickLogin;
    }

    protected CallBackCarLtdQuickLoginRouter(String str, ICallBackCarLtdQuickLogin iCallBackCarLtdQuickLogin, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCarLtdQuickLogin);
    }

    protected CallBackCarLtdQuickLoginRouter(String str, ICallBackCarLtdQuickLogin iCallBackCarLtdQuickLogin) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCarLtdQuickLogin);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackCarLtdQuickLoginRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdQuickLoginImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackCarLtdQuickLoginRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdQuickLoginImpl
    public void onRecvAck(GCarLtdQuickLoginResponseParam gCarLtdQuickLoginResponseParam) {
        ICallBackCarLtdQuickLogin iCallBackCarLtdQuickLogin = this.mObserver;
        if (iCallBackCarLtdQuickLogin != null) {
            iCallBackCarLtdQuickLogin.onRecvAck(gCarLtdQuickLoginResponseParam);
        }
    }
}
