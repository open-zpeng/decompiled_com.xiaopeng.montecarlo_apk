package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.PoiCmallDetailSearchResult;
import com.autonavi.gbl.search.observer.IPoiCmallDetailSearchObserver;
import com.autonavi.gbl.search.observer.impl.IPoiCmallDetailSearchObserverImpl;
@IntfAuto(target = IPoiCmallDetailSearchObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PoiCmallDetailSearchObserverRouter extends IPoiCmallDetailSearchObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(PoiCmallDetailSearchObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(PoiCmallDetailSearchObserverRouter.class);
    private TypeHelper mHelper;
    private IPoiCmallDetailSearchObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IPoiCmallDetailSearchObserver iPoiCmallDetailSearchObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPoiCmallDetailSearchObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPoiCmallDetailSearchObserver;
    }

    protected PoiCmallDetailSearchObserverRouter(String str, IPoiCmallDetailSearchObserver iPoiCmallDetailSearchObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPoiCmallDetailSearchObserver);
    }

    protected PoiCmallDetailSearchObserverRouter(String str, IPoiCmallDetailSearchObserver iPoiCmallDetailSearchObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPoiCmallDetailSearchObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.search.observer.impl.IPoiCmallDetailSearchObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IPoiCmallDetailSearchObserverImpl
    public void onGetPoiCmallDetailResult(int i, int i2, PoiCmallDetailSearchResult poiCmallDetailSearchResult) {
        IPoiCmallDetailSearchObserver iPoiCmallDetailSearchObserver = this.mObserver;
        if (iPoiCmallDetailSearchObserver != null) {
            iPoiCmallDetailSearchObserver.onGetPoiCmallDetailResult(i, i2, poiCmallDetailSearchResult);
        }
    }
}
