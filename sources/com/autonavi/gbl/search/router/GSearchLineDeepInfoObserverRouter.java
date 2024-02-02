package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.SearchLineDeepInfoResult;
import com.autonavi.gbl.search.observer.IGSearchLineDeepInfoObserver;
import com.autonavi.gbl.search.observer.impl.IGSearchLineDeepInfoObserverImpl;
import com.autonavi.gbl.util.model.EGErr;
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
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.router.GSearchLineDeepInfoObserverRouter.1
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
    @Override // com.autonavi.gbl.search.observer.impl.IGSearchLineDeepInfoObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.router.GSearchLineDeepInfoObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IGSearchLineDeepInfoObserverImpl
    public void onGetLineDeepInfoResult(int i, @EGErr.EGErr1 int i2, SearchLineDeepInfoResult searchLineDeepInfoResult) {
        IGSearchLineDeepInfoObserver iGSearchLineDeepInfoObserver = this.mObserver;
        if (iGSearchLineDeepInfoObserver != null) {
            iGSearchLineDeepInfoObserver.onGetLineDeepInfoResult(i, i2, searchLineDeepInfoResult);
        }
    }
}
