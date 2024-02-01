package com.autonavi.gbl.activation.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
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
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.activation.observer.impl.INetActivateObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.activation.observer.impl.INetActivateObserverImpl
    public void onNetActivateResponse(int i) {
        INetActivateObserver iNetActivateObserver = this.mObserver;
        if (iNetActivateObserver != null) {
            iNetActivateObserver.onNetActivateResponse(i);
        }
    }
}
