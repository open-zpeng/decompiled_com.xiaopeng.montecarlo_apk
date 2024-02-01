package com.autonavi.gbl.util.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.model.RuntimeInfo;
import com.autonavi.gbl.util.observer.IRuntimeInfoObserver;
import com.autonavi.gbl.util.observer.impl.RuntimeInfoObserverImpl;
@IntfAuto(target = IRuntimeInfoObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RuntimeInfoObserverRouter extends RuntimeInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(RuntimeInfoObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(RuntimeInfoObserverRouter.class);
    private TypeHelper mHelper;
    private IRuntimeInfoObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IRuntimeInfoObserver iRuntimeInfoObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RuntimeInfoObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iRuntimeInfoObserver;
    }

    protected RuntimeInfoObserverRouter(String str, IRuntimeInfoObserver iRuntimeInfoObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRuntimeInfoObserver);
    }

    protected RuntimeInfoObserverRouter(String str, IRuntimeInfoObserver iRuntimeInfoObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRuntimeInfoObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.util.observer.impl.RuntimeInfoObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.util.observer.impl.RuntimeInfoObserverImpl
    public void onRuntimeInfoResponse(RuntimeInfo runtimeInfo) {
        IRuntimeInfoObserver iRuntimeInfoObserver = this.mObserver;
        if (iRuntimeInfoObserver != null) {
            iRuntimeInfoObserver.onRuntimeInfoResponse(runtimeInfo);
        }
    }
}
