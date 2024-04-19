package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.SearchAroundRecommendResult;
import com.autonavi.gbl.search.observer.IGSearchAroundRecommendObserver;
import com.autonavi.gbl.search.observer.impl.IGSearchAroundRecommendObserverImpl;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = IGSearchAroundRecommendObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GSearchAroundRecommendObserverRouter extends IGSearchAroundRecommendObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(GSearchAroundRecommendObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(GSearchAroundRecommendObserverRouter.class);
    private TypeHelper mHelper;
    private IGSearchAroundRecommendObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IGSearchAroundRecommendObserver iGSearchAroundRecommendObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IGSearchAroundRecommendObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iGSearchAroundRecommendObserver;
    }

    protected GSearchAroundRecommendObserverRouter(String str, IGSearchAroundRecommendObserver iGSearchAroundRecommendObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchAroundRecommendObserver);
    }

    protected GSearchAroundRecommendObserverRouter(String str, IGSearchAroundRecommendObserver iGSearchAroundRecommendObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchAroundRecommendObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.router.GSearchAroundRecommendObserverRouter.1
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
    @Override // com.autonavi.gbl.search.observer.impl.IGSearchAroundRecommendObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.router.GSearchAroundRecommendObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IGSearchAroundRecommendObserverImpl
    public void onGetAroundRecommendResult(int i, @EGErr.EGErr1 int i2, SearchAroundRecommendResult searchAroundRecommendResult) {
        IGSearchAroundRecommendObserver iGSearchAroundRecommendObserver = this.mObserver;
        if (iGSearchAroundRecommendObserver != null) {
            iGSearchAroundRecommendObserver.onGetAroundRecommendResult(i, i2, searchAroundRecommendResult);
        }
    }
}
