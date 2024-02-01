package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.PoiShopListSearchResult;
import com.autonavi.gbl.search.observer.IPoiShopListSearchObserver;
import com.autonavi.gbl.search.observer.impl.IPoiShopListSearchObserverImpl;
@IntfAuto(target = IPoiShopListSearchObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PoiShopListSearchObserverRouter extends IPoiShopListSearchObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(PoiShopListSearchObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(PoiShopListSearchObserverRouter.class);
    private TypeHelper mHelper;
    private IPoiShopListSearchObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IPoiShopListSearchObserver iPoiShopListSearchObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPoiShopListSearchObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPoiShopListSearchObserver;
    }

    protected PoiShopListSearchObserverRouter(String str, IPoiShopListSearchObserver iPoiShopListSearchObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPoiShopListSearchObserver);
    }

    protected PoiShopListSearchObserverRouter(String str, IPoiShopListSearchObserver iPoiShopListSearchObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPoiShopListSearchObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.search.observer.impl.IPoiShopListSearchObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IPoiShopListSearchObserverImpl
    public void onGetPoiShopListResult(int i, int i2, PoiShopListSearchResult poiShopListSearchResult) {
        IPoiShopListSearchObserver iPoiShopListSearchObserver = this.mObserver;
        if (iPoiShopListSearchObserver != null) {
            iPoiShopListSearchObserver.onGetPoiShopListResult(i, i2, poiShopListSearchResult);
        }
    }
}
