package com.autonavi.gbl.common.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.observer.IThreadObserver;
import com.autonavi.gbl.common.observer.impl.IThreadObserverImpl;
@IntfAuto(target = IThreadObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ThreadObserverRouter extends IThreadObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ThreadObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ThreadObserverRouter.class);
    private TypeHelper mHelper;
    private IThreadObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IThreadObserver iThreadObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IThreadObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iThreadObserver;
    }

    protected ThreadObserverRouter(String str, IThreadObserver iThreadObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iThreadObserver);
    }

    protected ThreadObserverRouter(String str, IThreadObserver iThreadObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iThreadObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.router.ThreadObserverRouter.1
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
    @Override // com.autonavi.gbl.common.observer.impl.IThreadObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.router.ThreadObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.common.observer.impl.IThreadObserverImpl
    public void threadCallback(long j, byte b) {
        IThreadObserver iThreadObserver = this.mObserver;
        if (iThreadObserver != null) {
            iThreadObserver.threadCallback(j, b);
        }
    }
}
