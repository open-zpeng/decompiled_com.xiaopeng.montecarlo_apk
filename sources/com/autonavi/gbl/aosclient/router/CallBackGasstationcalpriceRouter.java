package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GGasstationcalpriceResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackGasstationcalprice;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackGasstationcalpriceImpl;
@IntfAuto(target = ICallBackGasstationcalprice.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackGasstationcalpriceRouter extends ICallBackGasstationcalpriceImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackGasstationcalpriceRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackGasstationcalpriceRouter.class);
    private TypeHelper mHelper;
    private ICallBackGasstationcalprice mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackGasstationcalprice iCallBackGasstationcalprice) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackGasstationcalpriceImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackGasstationcalprice;
    }

    protected CallBackGasstationcalpriceRouter(String str, ICallBackGasstationcalprice iCallBackGasstationcalprice, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackGasstationcalprice);
    }

    protected CallBackGasstationcalpriceRouter(String str, ICallBackGasstationcalprice iCallBackGasstationcalprice) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackGasstationcalprice);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackGasstationcalpriceRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackGasstationcalpriceImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackGasstationcalpriceRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackGasstationcalpriceImpl
    public void onRecvAck(GGasstationcalpriceResponseParam gGasstationcalpriceResponseParam) {
        ICallBackGasstationcalprice iCallBackGasstationcalprice = this.mObserver;
        if (iCallBackGasstationcalprice != null) {
            iCallBackGasstationcalprice.onRecvAck(gGasstationcalpriceResponseParam);
        }
    }
}
