package com.autonavi.gbl.information.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.model.DiningTradePriceResult;
import com.autonavi.gbl.information.trade.model.DiningTradeSubmitResult;
import com.autonavi.gbl.information.trade.observer.IDiningTradeObserver;
import com.autonavi.gbl.information.trade.observer.impl.IDiningTradeObserverImpl;
@IntfAuto(target = IDiningTradeObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class DiningTradeObserverRouter extends IDiningTradeObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(DiningTradeObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(DiningTradeObserverRouter.class);
    private TypeHelper mHelper;
    private IDiningTradeObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IDiningTradeObserver iDiningTradeObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IDiningTradeObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iDiningTradeObserver;
    }

    protected DiningTradeObserverRouter(String str, IDiningTradeObserver iDiningTradeObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDiningTradeObserver);
    }

    protected DiningTradeObserverRouter(String str, IDiningTradeObserver iDiningTradeObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDiningTradeObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.observer.impl.IDiningTradeObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IDiningTradeObserverImpl
    public void onResult(DiningTradePriceResult diningTradePriceResult) {
        IDiningTradeObserver iDiningTradeObserver = this.mObserver;
        if (iDiningTradeObserver != null) {
            iDiningTradeObserver.onResult(diningTradePriceResult);
        }
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IDiningTradeObserverImpl
    public void onResult(DiningTradeSubmitResult diningTradeSubmitResult) {
        IDiningTradeObserver iDiningTradeObserver = this.mObserver;
        if (iDiningTradeObserver != null) {
            iDiningTradeObserver.onResult(diningTradeSubmitResult);
        }
    }
}
