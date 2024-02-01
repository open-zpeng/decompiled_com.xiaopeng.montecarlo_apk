package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.SearchAlongWayResult;
import com.autonavi.gbl.search.observer.IGSearchAlongWayObserver;
import com.autonavi.gbl.search.observer.impl.IGSearchAlongWayObserverImpl;
@IntfAuto(target = IGSearchAlongWayObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GSearchAlongWayObserverRouter extends IGSearchAlongWayObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(GSearchAlongWayObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(GSearchAlongWayObserverRouter.class);
    private TypeHelper mHelper;
    private IGSearchAlongWayObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IGSearchAlongWayObserver iGSearchAlongWayObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IGSearchAlongWayObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iGSearchAlongWayObserver;
    }

    protected GSearchAlongWayObserverRouter(String str, IGSearchAlongWayObserver iGSearchAlongWayObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchAlongWayObserver);
    }

    protected GSearchAlongWayObserverRouter(String str, IGSearchAlongWayObserver iGSearchAlongWayObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchAlongWayObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.search.observer.impl.IGSearchAlongWayObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IGSearchAlongWayObserverImpl
    public void onGetAlongWayResult(int i, int i2, SearchAlongWayResult searchAlongWayResult) {
        IGSearchAlongWayObserver iGSearchAlongWayObserver = this.mObserver;
        if (iGSearchAlongWayObserver != null) {
            iGSearchAlongWayObserver.onGetAlongWayResult(i, i2, searchAlongWayResult);
        }
    }
}
