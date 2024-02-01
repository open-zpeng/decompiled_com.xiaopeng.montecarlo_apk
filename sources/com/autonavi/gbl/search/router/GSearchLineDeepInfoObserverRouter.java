package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.SearchLineDeepInfoResult;
import com.autonavi.gbl.search.observer.IGSearchLineDeepInfoObserver;
import com.autonavi.gbl.search.observer.impl.IGSearchLineDeepInfoObserverImpl;
@IntfAuto(target = IGSearchLineDeepInfoObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GSearchLineDeepInfoObserverRouter extends IGSearchLineDeepInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(GSearchLineDeepInfoObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(GSearchLineDeepInfoObserverRouter.class);
    private TypeHelper mHelper;
    private IGSearchLineDeepInfoObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IGSearchLineDeepInfoObserver iGSearchLineDeepInfoObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IGSearchLineDeepInfoObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iGSearchLineDeepInfoObserver;
    }

    protected GSearchLineDeepInfoObserverRouter(String str, IGSearchLineDeepInfoObserver iGSearchLineDeepInfoObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchLineDeepInfoObserver);
    }

    protected GSearchLineDeepInfoObserverRouter(String str, IGSearchLineDeepInfoObserver iGSearchLineDeepInfoObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchLineDeepInfoObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.search.observer.impl.IGSearchLineDeepInfoObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IGSearchLineDeepInfoObserverImpl
    public void onGetLineDeepInfoResult(int i, int i2, SearchLineDeepInfoResult searchLineDeepInfoResult) {
        IGSearchLineDeepInfoObserver iGSearchLineDeepInfoObserver = this.mObserver;
        if (iGSearchLineDeepInfoObserver != null) {
            iGSearchLineDeepInfoObserver.onGetLineDeepInfoResult(i, i2, searchLineDeepInfoResult);
        }
    }
}
