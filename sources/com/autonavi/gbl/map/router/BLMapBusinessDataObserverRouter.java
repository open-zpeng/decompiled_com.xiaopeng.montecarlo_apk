package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.observer.IBLMapBusinessDataObserver;
import com.autonavi.gbl.map.observer.impl.IBLMapBusinessDataObserverImpl;
@IntfAuto(target = IBLMapBusinessDataObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class BLMapBusinessDataObserverRouter extends IBLMapBusinessDataObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(BLMapBusinessDataObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(BLMapBusinessDataObserverRouter.class);
    private TypeHelper mHelper;
    private IBLMapBusinessDataObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IBLMapBusinessDataObserver iBLMapBusinessDataObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IBLMapBusinessDataObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iBLMapBusinessDataObserver;
    }

    protected BLMapBusinessDataObserverRouter(String str, IBLMapBusinessDataObserver iBLMapBusinessDataObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBLMapBusinessDataObserver);
    }

    protected BLMapBusinessDataObserverRouter(String str, IBLMapBusinessDataObserver iBLMapBusinessDataObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBLMapBusinessDataObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.observer.impl.IBLMapBusinessDataObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapBusinessDataObserverImpl
    public boolean onBusinessDataObserver(int i, long j, long j2) {
        IBLMapBusinessDataObserver iBLMapBusinessDataObserver = this.mObserver;
        if (iBLMapBusinessDataObserver != null) {
            return iBLMapBusinessDataObserver.onBusinessDataObserver(i, j, j2);
        }
        return false;
    }
}
