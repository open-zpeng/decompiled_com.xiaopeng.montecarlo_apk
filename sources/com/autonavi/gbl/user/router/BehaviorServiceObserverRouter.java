package com.autonavi.gbl.user.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.user.behavior.model.FavoriteType;
import com.autonavi.gbl.user.behavior.model.SimpleFavoriteItem;
import com.autonavi.gbl.user.behavior.observer.IBehaviorServiceObserver;
import com.autonavi.gbl.user.behavior.observer.impl.IBehaviorServiceObserverImpl;
import com.autonavi.gbl.user.syncsdk.model.SyncEventType;
import com.autonavi.gbl.user.syncsdk.model.SyncRet;
import java.util.ArrayList;
@IntfAuto(target = IBehaviorServiceObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class BehaviorServiceObserverRouter extends IBehaviorServiceObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(BehaviorServiceObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(BehaviorServiceObserverRouter.class);
    private TypeHelper mHelper;
    private IBehaviorServiceObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IBehaviorServiceObserver iBehaviorServiceObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IBehaviorServiceObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iBehaviorServiceObserver;
    }

    protected BehaviorServiceObserverRouter(String str, IBehaviorServiceObserver iBehaviorServiceObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBehaviorServiceObserver);
    }

    protected BehaviorServiceObserverRouter(String str, IBehaviorServiceObserver iBehaviorServiceObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBehaviorServiceObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.router.BehaviorServiceObserverRouter.1
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
    @Override // com.autonavi.gbl.user.behavior.observer.impl.IBehaviorServiceObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.router.BehaviorServiceObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.user.behavior.observer.impl.IBehaviorServiceObserverImpl
    public void notify(@SyncEventType.SyncEventType1 int i, @SyncRet.SyncRet1 int i2) {
        IBehaviorServiceObserver iBehaviorServiceObserver = this.mObserver;
        if (iBehaviorServiceObserver != null) {
            iBehaviorServiceObserver.notify(i, i2);
        }
    }

    @Override // com.autonavi.gbl.user.behavior.observer.impl.IBehaviorServiceObserverImpl
    public void notify(@FavoriteType.FavoriteType1 int i, ArrayList<SimpleFavoriteItem> arrayList, boolean z) {
        IBehaviorServiceObserver iBehaviorServiceObserver = this.mObserver;
        if (iBehaviorServiceObserver != null) {
            iBehaviorServiceObserver.notify(i, arrayList, z);
        }
    }
}
