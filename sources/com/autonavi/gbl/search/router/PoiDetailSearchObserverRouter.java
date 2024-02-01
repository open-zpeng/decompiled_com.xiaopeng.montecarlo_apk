package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.PoiDetailSearchResult;
import com.autonavi.gbl.search.observer.IPoiDetailSearchObserver;
import com.autonavi.gbl.search.observer.impl.IPoiDetailSearchObserverImpl;
@IntfAuto(target = IPoiDetailSearchObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PoiDetailSearchObserverRouter extends IPoiDetailSearchObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(PoiDetailSearchObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(PoiDetailSearchObserverRouter.class);
    private TypeHelper mHelper;
    private IPoiDetailSearchObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IPoiDetailSearchObserver iPoiDetailSearchObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPoiDetailSearchObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPoiDetailSearchObserver;
    }

    protected PoiDetailSearchObserverRouter(String str, IPoiDetailSearchObserver iPoiDetailSearchObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPoiDetailSearchObserver);
    }

    protected PoiDetailSearchObserverRouter(String str, IPoiDetailSearchObserver iPoiDetailSearchObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPoiDetailSearchObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.search.observer.impl.IPoiDetailSearchObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IPoiDetailSearchObserverImpl
    public void onGetPoiDetailResult(int i, int i2, PoiDetailSearchResult poiDetailSearchResult) {
        IPoiDetailSearchObserver iPoiDetailSearchObserver = this.mObserver;
        if (iPoiDetailSearchObserver != null) {
            iPoiDetailSearchObserver.onGetPoiDetailResult(i, i2, poiDetailSearchResult);
        }
    }
}
