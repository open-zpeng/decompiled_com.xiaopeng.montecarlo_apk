package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.SearchSuggestResult;
import com.autonavi.gbl.search.observer.IGSearchSuggestionObserver;
import com.autonavi.gbl.search.observer.impl.IGSearchSuggestionObserverImpl;
@IntfAuto(target = IGSearchSuggestionObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GSearchSuggestionObserverRouter extends IGSearchSuggestionObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(GSearchSuggestionObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(GSearchSuggestionObserverRouter.class);
    private TypeHelper mHelper;
    private IGSearchSuggestionObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IGSearchSuggestionObserver iGSearchSuggestionObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IGSearchSuggestionObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iGSearchSuggestionObserver;
    }

    protected GSearchSuggestionObserverRouter(String str, IGSearchSuggestionObserver iGSearchSuggestionObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchSuggestionObserver);
    }

    protected GSearchSuggestionObserverRouter(String str, IGSearchSuggestionObserver iGSearchSuggestionObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchSuggestionObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.search.observer.impl.IGSearchSuggestionObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IGSearchSuggestionObserverImpl
    public void onGetSuggestionResult(int i, int i2, SearchSuggestResult searchSuggestResult) {
        IGSearchSuggestionObserver iGSearchSuggestionObserver = this.mObserver;
        if (iGSearchSuggestionObserver != null) {
            iGSearchSuggestionObserver.onGetSuggestionResult(i, i2, searchSuggestResult);
        }
    }
}
