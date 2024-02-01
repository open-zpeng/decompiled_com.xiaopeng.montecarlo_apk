package com.autonavi.gbl.multi.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.display.model.DisplayType;
import com.autonavi.gbl.multi.display.observer.IRemoteDisplayObserver;
import com.autonavi.gbl.multi.display.observer.impl.IRemoteDisplayObserverImpl;
@IntfAuto(target = IRemoteDisplayObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RemoteDisplayObserverRouter extends IRemoteDisplayObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(RemoteDisplayObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(RemoteDisplayObserverRouter.class);
    private TypeHelper mHelper;
    private IRemoteDisplayObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IRemoteDisplayObserver iRemoteDisplayObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IRemoteDisplayObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iRemoteDisplayObserver;
    }

    protected RemoteDisplayObserverRouter(String str, IRemoteDisplayObserver iRemoteDisplayObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRemoteDisplayObserver);
    }

    protected RemoteDisplayObserverRouter(String str, IRemoteDisplayObserver iRemoteDisplayObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRemoteDisplayObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.display.observer.impl.IRemoteDisplayObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.display.observer.impl.IRemoteDisplayObserverImpl
    public void onRemoteDisplayCreated(int i, @DisplayType.DisplayType1 int i2) {
        IRemoteDisplayObserver iRemoteDisplayObserver = this.mObserver;
        if (iRemoteDisplayObserver != null) {
            iRemoteDisplayObserver.onRemoteDisplayCreated(i, i2);
        }
    }

    @Override // com.autonavi.gbl.multi.display.observer.impl.IRemoteDisplayObserverImpl
    public void onRemoteDisplayDestroyed(int i, @DisplayType.DisplayType1 int i2) {
        IRemoteDisplayObserver iRemoteDisplayObserver = this.mObserver;
        if (iRemoteDisplayObserver != null) {
            iRemoteDisplayObserver.onRemoteDisplayDestroyed(i, i2);
        }
    }
}
