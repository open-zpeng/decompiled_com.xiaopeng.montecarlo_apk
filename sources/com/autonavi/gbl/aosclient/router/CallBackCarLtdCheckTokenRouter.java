package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GCarLtdCheckTokenResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdCheckToken;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdCheckTokenImpl;
@IntfAuto(target = ICallBackCarLtdCheckToken.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackCarLtdCheckTokenRouter extends ICallBackCarLtdCheckTokenImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackCarLtdCheckTokenRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackCarLtdCheckTokenRouter.class);
    private TypeHelper mHelper;
    private ICallBackCarLtdCheckToken mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackCarLtdCheckToken iCallBackCarLtdCheckToken) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackCarLtdCheckTokenImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackCarLtdCheckToken;
    }

    protected CallBackCarLtdCheckTokenRouter(String str, ICallBackCarLtdCheckToken iCallBackCarLtdCheckToken, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCarLtdCheckToken);
    }

    protected CallBackCarLtdCheckTokenRouter(String str, ICallBackCarLtdCheckToken iCallBackCarLtdCheckToken) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCarLtdCheckToken);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackCarLtdCheckTokenRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdCheckTokenImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackCarLtdCheckTokenRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdCheckTokenImpl
    public void onRecvAck(GCarLtdCheckTokenResponseParam gCarLtdCheckTokenResponseParam) {
        ICallBackCarLtdCheckToken iCallBackCarLtdCheckToken = this.mObserver;
        if (iCallBackCarLtdCheckToken != null) {
            iCallBackCarLtdCheckToken.onRecvAck(gCarLtdCheckTokenResponseParam);
        }
    }
}
