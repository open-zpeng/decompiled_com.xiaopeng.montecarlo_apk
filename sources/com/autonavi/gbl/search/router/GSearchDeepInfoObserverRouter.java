package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.SearchDeepInfoResult;
import com.autonavi.gbl.search.observer.IGSearchDeepInfoObserver;
import com.autonavi.gbl.search.observer.impl.IGSearchDeepInfoObserverImpl;
@IntfAuto(target = IGSearchDeepInfoObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GSearchDeepInfoObserverRouter extends IGSearchDeepInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(GSearchDeepInfoObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(GSearchDeepInfoObserverRouter.class);
    private TypeHelper mHelper;
    private IGSearchDeepInfoObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IGSearchDeepInfoObserver iGSearchDeepInfoObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IGSearchDeepInfoObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iGSearchDeepInfoObserver;
    }

    protected GSearchDeepInfoObserverRouter(String str, IGSearchDeepInfoObserver iGSearchDeepInfoObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchDeepInfoObserver);
    }

    protected GSearchDeepInfoObserverRouter(String str, IGSearchDeepInfoObserver iGSearchDeepInfoObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchDeepInfoObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.search.observer.impl.IGSearchDeepInfoObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IGSearchDeepInfoObserverImpl
    public void onGetDeepInfoResult(int i, int i2, SearchDeepInfoResult searchDeepInfoResult) {
        IGSearchDeepInfoObserver iGSearchDeepInfoObserver = this.mObserver;
        if (iGSearchDeepInfoObserver != null) {
            iGSearchDeepInfoObserver.onGetDeepInfoResult(i, i2, searchDeepInfoResult);
        }
    }
}
