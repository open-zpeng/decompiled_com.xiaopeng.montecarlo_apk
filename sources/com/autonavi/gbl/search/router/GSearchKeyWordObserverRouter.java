package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.SearchKeywordResult;
import com.autonavi.gbl.search.observer.IGSearchKeyWordObserver;
import com.autonavi.gbl.search.observer.impl.IGSearchKeyWordObserverImpl;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = IGSearchKeyWordObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GSearchKeyWordObserverRouter extends IGSearchKeyWordObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(GSearchKeyWordObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(GSearchKeyWordObserverRouter.class);
    private TypeHelper mHelper;
    private IGSearchKeyWordObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IGSearchKeyWordObserver iGSearchKeyWordObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IGSearchKeyWordObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iGSearchKeyWordObserver;
    }

    protected GSearchKeyWordObserverRouter(String str, IGSearchKeyWordObserver iGSearchKeyWordObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchKeyWordObserver);
    }

    protected GSearchKeyWordObserverRouter(String str, IGSearchKeyWordObserver iGSearchKeyWordObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchKeyWordObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.router.GSearchKeyWordObserverRouter.1
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
    @Override // com.autonavi.gbl.search.observer.impl.IGSearchKeyWordObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.router.GSearchKeyWordObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IGSearchKeyWordObserverImpl
    public void onGetKeyWordResult(int i, @EGErr.EGErr1 int i2, SearchKeywordResult searchKeywordResult) {
        IGSearchKeyWordObserver iGSearchKeyWordObserver = this.mObserver;
        if (iGSearchKeyWordObserver != null) {
            iGSearchKeyWordObserver.onGetKeyWordResult(i, i2, searchKeywordResult);
        }
    }
}
