package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.SearchAroundRecommendResult;
import com.autonavi.gbl.search.observer.IGSearchAroundRecommendObserver;
import com.autonavi.gbl.search.observer.impl.IGSearchAroundRecommendObserverImpl;
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
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.search.observer.impl.IGSearchAroundRecommendObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IGSearchAroundRecommendObserverImpl
    public void onGetAroundRecommendResult(int i, int i2, SearchAroundRecommendResult searchAroundRecommendResult) {
        IGSearchAroundRecommendObserver iGSearchAroundRecommendObserver = this.mObserver;
        if (iGSearchAroundRecommendObserver != null) {
            iGSearchAroundRecommendObserver.onGetAroundRecommendResult(i, i2, searchAroundRecommendResult);
        }
    }
}
