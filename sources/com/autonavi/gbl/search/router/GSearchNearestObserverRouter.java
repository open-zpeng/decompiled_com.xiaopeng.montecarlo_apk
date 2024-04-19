package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.SearchNearestResult;
import com.autonavi.gbl.search.observer.IGSearchNearestObserver;
import com.autonavi.gbl.search.observer.impl.IGSearchNearestObserverImpl;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = IGSearchNearestObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GSearchNearestObserverRouter extends IGSearchNearestObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(GSearchNearestObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(GSearchNearestObserverRouter.class);
    private TypeHelper mHelper;
    private IGSearchNearestObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IGSearchNearestObserver iGSearchNearestObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IGSearchNearestObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iGSearchNearestObserver;
    }

    protected GSearchNearestObserverRouter(String str, IGSearchNearestObserver iGSearchNearestObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchNearestObserver);
    }

    protected GSearchNearestObserverRouter(String str, IGSearchNearestObserver iGSearchNearestObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchNearestObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.router.GSearchNearestObserverRouter.1
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
    @Override // com.autonavi.gbl.search.observer.impl.IGSearchNearestObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.router.GSearchNearestObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IGSearchNearestObserverImpl
    public void onGetNearestResult(int i, @EGErr.EGErr1 int i2, SearchNearestResult searchNearestResult) {
        IGSearchNearestObserver iGSearchNearestObserver = this.mObserver;
        if (iGSearchNearestObserver != null) {
            iGSearchNearestObserver.onGetNearestResult(i, i2, searchNearestResult);
        }
    }
}
