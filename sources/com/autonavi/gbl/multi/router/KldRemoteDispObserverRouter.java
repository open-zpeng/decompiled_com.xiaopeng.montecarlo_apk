package com.autonavi.gbl.multi.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.observer.IKldRemoteDispObserver;
import com.autonavi.gbl.multi.observer.impl.IKldRemoteDispObserverImpl;
@IntfAuto(target = IKldRemoteDispObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class KldRemoteDispObserverRouter extends IKldRemoteDispObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(KldRemoteDispObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(KldRemoteDispObserverRouter.class);
    private TypeHelper mHelper;
    private IKldRemoteDispObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IKldRemoteDispObserver iKldRemoteDispObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IKldRemoteDispObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iKldRemoteDispObserver;
    }

    protected KldRemoteDispObserverRouter(String str, IKldRemoteDispObserver iKldRemoteDispObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKldRemoteDispObserver);
    }

    protected KldRemoteDispObserverRouter(String str, IKldRemoteDispObserver iKldRemoteDispObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKldRemoteDispObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldRemoteDispObserverRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.IKldRemoteDispObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldRemoteDispObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldRemoteDispObserverImpl
    public void onRemoteDisplayCreated(int i, @DisplayType.DisplayType1 int i2) {
        IKldRemoteDispObserver iKldRemoteDispObserver = this.mObserver;
        if (iKldRemoteDispObserver != null) {
            iKldRemoteDispObserver.onRemoteDisplayCreated(i, i2);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldRemoteDispObserverImpl
    public void onRemoteDisplayDestroyed(int i, @DisplayType.DisplayType1 int i2) {
        IKldRemoteDispObserver iKldRemoteDispObserver = this.mObserver;
        if (iKldRemoteDispObserver != null) {
            iKldRemoteDispObserver.onRemoteDisplayDestroyed(i, i2);
        }
    }
}
