package com.autonavi.gbl.information.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.model.OrderWaitingResult;
import com.autonavi.gbl.information.trade.observer.IWaitingOrderObserver;
import com.autonavi.gbl.information.trade.observer.impl.IWaitingOrderObserverImpl;
@IntfAuto(target = IWaitingOrderObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class WaitingOrderObserverRouter extends IWaitingOrderObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(WaitingOrderObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(WaitingOrderObserverRouter.class);
    private TypeHelper mHelper;
    private IWaitingOrderObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IWaitingOrderObserver iWaitingOrderObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IWaitingOrderObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iWaitingOrderObserver;
    }

    protected WaitingOrderObserverRouter(String str, IWaitingOrderObserver iWaitingOrderObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iWaitingOrderObserver);
    }

    protected WaitingOrderObserverRouter(String str, IWaitingOrderObserver iWaitingOrderObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iWaitingOrderObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.observer.impl.IWaitingOrderObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IWaitingOrderObserverImpl
    public void onResult(OrderWaitingResult orderWaitingResult) {
        IWaitingOrderObserver iWaitingOrderObserver = this.mObserver;
        if (iWaitingOrderObserver != null) {
            iWaitingOrderObserver.onResult(orderWaitingResult);
        }
    }
}
