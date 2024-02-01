package com.autonavi.gbl.information.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.model.OrderCancelResult;
import com.autonavi.gbl.information.trade.observer.ICancelOrderObserver;
import com.autonavi.gbl.information.trade.observer.impl.ICancelOrderObserverImpl;
@IntfAuto(target = ICancelOrderObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CancelOrderObserverRouter extends ICancelOrderObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(CancelOrderObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(CancelOrderObserverRouter.class);
    private TypeHelper mHelper;
    private ICancelOrderObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ICancelOrderObserver iCancelOrderObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICancelOrderObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCancelOrderObserver;
    }

    protected CancelOrderObserverRouter(String str, ICancelOrderObserver iCancelOrderObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCancelOrderObserver);
    }

    protected CancelOrderObserverRouter(String str, ICancelOrderObserver iCancelOrderObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCancelOrderObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.observer.impl.ICancelOrderObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.ICancelOrderObserverImpl
    public void onResult(OrderCancelResult orderCancelResult) {
        ICancelOrderObserver iCancelOrderObserver = this.mObserver;
        if (iCancelOrderObserver != null) {
            iCancelOrderObserver.onResult(orderCancelResult);
        }
    }
}
