package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GCarLtdBindResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdBind;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdBindImpl;
@IntfAuto(target = ICallBackCarLtdBind.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackCarLtdBindRouter extends ICallBackCarLtdBindImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackCarLtdBindRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackCarLtdBindRouter.class);
    private TypeHelper mHelper;
    private ICallBackCarLtdBind mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackCarLtdBind iCallBackCarLtdBind) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackCarLtdBindImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackCarLtdBind;
    }

    protected CallBackCarLtdBindRouter(String str, ICallBackCarLtdBind iCallBackCarLtdBind, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCarLtdBind);
    }

    protected CallBackCarLtdBindRouter(String str, ICallBackCarLtdBind iCallBackCarLtdBind) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCarLtdBind);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackCarLtdBindRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdBindImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackCarLtdBindRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdBindImpl
    public void onRecvAck(GCarLtdBindResponseParam gCarLtdBindResponseParam) {
        ICallBackCarLtdBind iCallBackCarLtdBind = this.mObserver;
        if (iCallBackCarLtdBind != null) {
            iCallBackCarLtdBind.onRecvAck(gCarLtdBindResponseParam);
        }
    }
}
