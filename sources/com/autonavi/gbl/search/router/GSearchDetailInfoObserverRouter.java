package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.SearchDetailInfoResult;
import com.autonavi.gbl.search.observer.IGSearchDetailInfoObserver;
import com.autonavi.gbl.search.observer.impl.IGSearchDetailInfoObserverImpl;
@IntfAuto(target = IGSearchDetailInfoObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GSearchDetailInfoObserverRouter extends IGSearchDetailInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(GSearchDetailInfoObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(GSearchDetailInfoObserverRouter.class);
    private TypeHelper mHelper;
    private IGSearchDetailInfoObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IGSearchDetailInfoObserver iGSearchDetailInfoObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IGSearchDetailInfoObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iGSearchDetailInfoObserver;
    }

    protected GSearchDetailInfoObserverRouter(String str, IGSearchDetailInfoObserver iGSearchDetailInfoObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchDetailInfoObserver);
    }

    protected GSearchDetailInfoObserverRouter(String str, IGSearchDetailInfoObserver iGSearchDetailInfoObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchDetailInfoObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.search.observer.impl.IGSearchDetailInfoObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IGSearchDetailInfoObserverImpl
    public void onGetDetailInfoResult(int i, int i2, SearchDetailInfoResult searchDetailInfoResult) {
        IGSearchDetailInfoObserver iGSearchDetailInfoObserver = this.mObserver;
        if (iGSearchDetailInfoObserver != null) {
            iGSearchDetailInfoObserver.onGetDetailInfoResult(i, i2, searchDetailInfoResult);
        }
    }
}
