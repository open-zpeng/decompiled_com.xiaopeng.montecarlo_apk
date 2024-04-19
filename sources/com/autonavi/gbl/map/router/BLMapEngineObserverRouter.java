package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.model.MapFuncActiveParam;
import com.autonavi.gbl.map.observer.IBLMapEngineObserver;
import com.autonavi.gbl.map.observer.impl.IBLMapEngineObserverImpl;
@IntfAuto(target = IBLMapEngineObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class BLMapEngineObserverRouter extends IBLMapEngineObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(BLMapEngineObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(BLMapEngineObserverRouter.class);
    private TypeHelper mHelper;
    private IBLMapEngineObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IBLMapEngineObserver iBLMapEngineObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IBLMapEngineObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iBLMapEngineObserver;
    }

    protected BLMapEngineObserverRouter(String str, IBLMapEngineObserver iBLMapEngineObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBLMapEngineObserver);
    }

    protected BLMapEngineObserverRouter(String str, IBLMapEngineObserver iBLMapEngineObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBLMapEngineObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.BLMapEngineObserverRouter.1
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
    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.BLMapEngineObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineObserverImpl
    public void onMapRender(long j, int i) {
        IBLMapEngineObserver iBLMapEngineObserver = this.mObserver;
        if (iBLMapEngineObserver != null) {
            iBLMapEngineObserver.onMapRender(j, i);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineObserverImpl
    public void onMapOrthoRender(long j) {
        IBLMapEngineObserver iBLMapEngineObserver = this.mObserver;
        if (iBLMapEngineObserver != null) {
            iBLMapEngineObserver.onMapOrthoRender(j);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineObserverImpl
    public void onMapTransferParam(long j, int[] iArr) {
        IBLMapEngineObserver iBLMapEngineObserver = this.mObserver;
        if (iBLMapEngineObserver != null) {
            iBLMapEngineObserver.onMapTransferParam(j, iArr);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineObserverImpl
    public void onMapOfflineError(long j, String str, int i) {
        IBLMapEngineObserver iBLMapEngineObserver = this.mObserver;
        if (iBLMapEngineObserver != null) {
            iBLMapEngineObserver.onMapOfflineError(j, str, i);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineObserverImpl
    public void onMapAnimationFinished(long j) {
        IBLMapEngineObserver iBLMapEngineObserver = this.mObserver;
        if (iBLMapEngineObserver != null) {
            iBLMapEngineObserver.onMapAnimationFinished(j);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineObserverImpl
    public void onMapFunctionActivity(long j, MapFuncActiveParam mapFuncActiveParam) {
        IBLMapEngineObserver iBLMapEngineObserver = this.mObserver;
        if (iBLMapEngineObserver != null) {
            iBLMapEngineObserver.onMapFunctionActivity(j, mapFuncActiveParam);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineObserverImpl
    public void onMapViewDestroyed(long j) {
        IBLMapEngineObserver iBLMapEngineObserver = this.mObserver;
        if (iBLMapEngineObserver != null) {
            iBLMapEngineObserver.onMapViewDestroyed(j);
        }
    }
}
