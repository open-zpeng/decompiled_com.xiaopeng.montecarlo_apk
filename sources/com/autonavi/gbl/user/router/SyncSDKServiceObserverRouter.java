package com.autonavi.gbl.user.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.user.syncsdk.model.SyncEventType;
import com.autonavi.gbl.user.syncsdk.model.SyncRet;
import com.autonavi.gbl.user.syncsdk.observer.ISyncSDKServiceObserver;
import com.autonavi.gbl.user.syncsdk.observer.impl.ISyncSDKServiceObserverImpl;
@IntfAuto(target = ISyncSDKServiceObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class SyncSDKServiceObserverRouter extends ISyncSDKServiceObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(SyncSDKServiceObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(SyncSDKServiceObserverRouter.class);
    private TypeHelper mHelper;
    private ISyncSDKServiceObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ISyncSDKServiceObserver iSyncSDKServiceObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ISyncSDKServiceObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iSyncSDKServiceObserver;
    }

    protected SyncSDKServiceObserverRouter(String str, ISyncSDKServiceObserver iSyncSDKServiceObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSyncSDKServiceObserver);
    }

    protected SyncSDKServiceObserverRouter(String str, ISyncSDKServiceObserver iSyncSDKServiceObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSyncSDKServiceObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.user.syncsdk.observer.impl.ISyncSDKServiceObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.user.syncsdk.observer.impl.ISyncSDKServiceObserverImpl
    public void notify(@SyncEventType.SyncEventType1 int i, @SyncRet.SyncRet1 int i2) {
        ISyncSDKServiceObserver iSyncSDKServiceObserver = this.mObserver;
        if (iSyncSDKServiceObserver != null) {
            iSyncSDKServiceObserver.notify(i, i2);
        }
    }
}
