package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GCarLtdUnbindResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdUnbind;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdUnbindImpl;
@IntfAuto(target = ICallBackCarLtdUnbind.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackCarLtdUnbindRouter extends ICallBackCarLtdUnbindImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackCarLtdUnbindRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackCarLtdUnbindRouter.class);
    private TypeHelper mHelper;
    private ICallBackCarLtdUnbind mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackCarLtdUnbind iCallBackCarLtdUnbind) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackCarLtdUnbindImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackCarLtdUnbind;
    }

    protected CallBackCarLtdUnbindRouter(String str, ICallBackCarLtdUnbind iCallBackCarLtdUnbind, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCarLtdUnbind);
    }

    protected CallBackCarLtdUnbindRouter(String str, ICallBackCarLtdUnbind iCallBackCarLtdUnbind) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCarLtdUnbind);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackCarLtdUnbindRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdUnbindImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackCarLtdUnbindRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdUnbindImpl
    public void onRecvAck(GCarLtdUnbindResponseParam gCarLtdUnbindResponseParam) {
        ICallBackCarLtdUnbind iCallBackCarLtdUnbind = this.mObserver;
        if (iCallBackCarLtdUnbind != null) {
            iCallBackCarLtdUnbind.onRecvAck(gCarLtdUnbindResponseParam);
        }
    }
}
