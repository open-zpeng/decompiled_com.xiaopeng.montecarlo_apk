package com.autonavi.gbl.information.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.model.ObtainCouponResult;
import com.autonavi.gbl.information.trade.observer.IObtainCouponObserver;
import com.autonavi.gbl.information.trade.observer.impl.IObtainCouponObserverImpl;
@IntfAuto(target = IObtainCouponObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ObtainCouponObserverRouter extends IObtainCouponObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ObtainCouponObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ObtainCouponObserverRouter.class);
    private TypeHelper mHelper;
    private IObtainCouponObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IObtainCouponObserver iObtainCouponObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IObtainCouponObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iObtainCouponObserver;
    }

    protected ObtainCouponObserverRouter(String str, IObtainCouponObserver iObtainCouponObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iObtainCouponObserver);
    }

    protected ObtainCouponObserverRouter(String str, IObtainCouponObserver iObtainCouponObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iObtainCouponObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.observer.impl.IObtainCouponObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IObtainCouponObserverImpl
    public void onResult(ObtainCouponResult obtainCouponResult) {
        IObtainCouponObserver iObtainCouponObserver = this.mObserver;
        if (iObtainCouponObserver != null) {
            iObtainCouponObserver.onResult(obtainCouponResult);
        }
    }
}
