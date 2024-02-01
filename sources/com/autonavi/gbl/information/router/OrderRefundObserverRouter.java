package com.autonavi.gbl.information.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.model.OrderRefundDetailResult;
import com.autonavi.gbl.information.trade.model.OrderRefundPageResult;
import com.autonavi.gbl.information.trade.model.OrderRefundSubmitResult;
import com.autonavi.gbl.information.trade.observer.IOrderRefundObserver;
import com.autonavi.gbl.information.trade.observer.impl.IOrderRefundObserverImpl;
@IntfAuto(target = IOrderRefundObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class OrderRefundObserverRouter extends IOrderRefundObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(OrderRefundObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(OrderRefundObserverRouter.class);
    private TypeHelper mHelper;
    private IOrderRefundObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IOrderRefundObserver iOrderRefundObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IOrderRefundObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iOrderRefundObserver;
    }

    protected OrderRefundObserverRouter(String str, IOrderRefundObserver iOrderRefundObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iOrderRefundObserver);
    }

    protected OrderRefundObserverRouter(String str, IOrderRefundObserver iOrderRefundObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iOrderRefundObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.observer.impl.IOrderRefundObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IOrderRefundObserverImpl
    public void onResult(OrderRefundPageResult orderRefundPageResult) {
        IOrderRefundObserver iOrderRefundObserver = this.mObserver;
        if (iOrderRefundObserver != null) {
            iOrderRefundObserver.onResult(orderRefundPageResult);
        }
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IOrderRefundObserverImpl
    public void onResult(OrderRefundSubmitResult orderRefundSubmitResult) {
        IOrderRefundObserver iOrderRefundObserver = this.mObserver;
        if (iOrderRefundObserver != null) {
            iOrderRefundObserver.onResult(orderRefundSubmitResult);
        }
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IOrderRefundObserverImpl
    public void onResult(OrderRefundDetailResult orderRefundDetailResult) {
        IOrderRefundObserver iOrderRefundObserver = this.mObserver;
        if (iOrderRefundObserver != null) {
            iOrderRefundObserver.onResult(orderRefundDetailResult);
        }
    }
}
