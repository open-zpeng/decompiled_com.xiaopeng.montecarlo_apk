package com.autonavi.gbl.information.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.model.OrderDetailResult;
import com.autonavi.gbl.information.trade.observer.IOrderDetailObserver;
import com.autonavi.gbl.information.trade.observer.impl.IOrderDetailObserverImpl;
@IntfAuto(target = IOrderDetailObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class OrderDetailObserverRouter extends IOrderDetailObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(OrderDetailObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(OrderDetailObserverRouter.class);
    private TypeHelper mHelper;
    private IOrderDetailObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IOrderDetailObserver iOrderDetailObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IOrderDetailObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iOrderDetailObserver;
    }

    protected OrderDetailObserverRouter(String str, IOrderDetailObserver iOrderDetailObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iOrderDetailObserver);
    }

    protected OrderDetailObserverRouter(String str, IOrderDetailObserver iOrderDetailObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iOrderDetailObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.observer.impl.IOrderDetailObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IOrderDetailObserverImpl
    public void onResult(OrderDetailResult orderDetailResult) {
        IOrderDetailObserver iOrderDetailObserver = this.mObserver;
        if (iOrderDetailObserver != null) {
            iOrderDetailObserver.onResult(orderDetailResult);
        }
    }
}
