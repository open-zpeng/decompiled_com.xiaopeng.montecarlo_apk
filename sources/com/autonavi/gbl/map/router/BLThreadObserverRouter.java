package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.observer.IBLThreadObserver;
import com.autonavi.gbl.map.observer.impl.IBLThreadObserverImpl;
@IntfAuto(target = IBLThreadObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class BLThreadObserverRouter extends IBLThreadObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(BLThreadObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(BLThreadObserverRouter.class);
    private TypeHelper mHelper;
    private IBLThreadObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IBLThreadObserver iBLThreadObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IBLThreadObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iBLThreadObserver;
    }

    protected BLThreadObserverRouter(String str, IBLThreadObserver iBLThreadObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBLThreadObserver);
    }

    protected BLThreadObserverRouter(String str, IBLThreadObserver iBLThreadObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBLThreadObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.BLThreadObserverRouter.1
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
    @Override // com.autonavi.gbl.map.observer.impl.IBLThreadObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.BLThreadObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLThreadObserverImpl
    public void threadCallback(long j, byte b) {
        IBLThreadObserver iBLThreadObserver = this.mObserver;
        if (iBLThreadObserver != null) {
            iBLThreadObserver.threadCallback(j, b);
        }
    }
}
