package com.autonavi.gbl.activation.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.activation.model.ActivateErrorCode;
import com.autonavi.gbl.activation.observer.INetActivateObserver;
import com.autonavi.gbl.activation.observer.impl.INetActivateObserverImpl;
@IntfAuto(target = INetActivateObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class NetActivateObserverRouter extends INetActivateObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(NetActivateObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(NetActivateObserverRouter.class);
    private TypeHelper mHelper;
    private INetActivateObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, INetActivateObserver iNetActivateObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(INetActivateObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iNetActivateObserver;
    }

    protected NetActivateObserverRouter(String str, INetActivateObserver iNetActivateObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iNetActivateObserver);
    }

    protected NetActivateObserverRouter(String str, INetActivateObserver iNetActivateObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iNetActivateObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.activation.router.NetActivateObserverRouter.1
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
    @Override // com.autonavi.gbl.activation.observer.impl.INetActivateObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.activation.router.NetActivateObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.activation.observer.impl.INetActivateObserverImpl
    public void onNetActivateResponse(@ActivateErrorCode.ActivateErrorCode1 int i) {
        INetActivateObserver iNetActivateObserver = this.mObserver;
        if (iNetActivateObserver != null) {
            iNetActivateObserver.onNetActivateResponse(i);
        }
    }
}
