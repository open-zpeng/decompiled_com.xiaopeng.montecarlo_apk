package com.autonavi.gbl.information.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.model.ObtainedCouponResult;
import com.autonavi.gbl.information.trade.observer.IObtainedCouponObserver;
import com.autonavi.gbl.information.trade.observer.impl.IObtainedCouponObserverImpl;
@IntfAuto(target = IObtainedCouponObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ObtainedCouponObserverRouter extends IObtainedCouponObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ObtainedCouponObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ObtainedCouponObserverRouter.class);
    private TypeHelper mHelper;
    private IObtainedCouponObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IObtainedCouponObserver iObtainedCouponObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IObtainedCouponObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iObtainedCouponObserver;
    }

    protected ObtainedCouponObserverRouter(String str, IObtainedCouponObserver iObtainedCouponObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iObtainedCouponObserver);
    }

    protected ObtainedCouponObserverRouter(String str, IObtainedCouponObserver iObtainedCouponObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iObtainedCouponObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.observer.impl.IObtainedCouponObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IObtainedCouponObserverImpl
    public void onResult(ObtainedCouponResult obtainedCouponResult) {
        IObtainedCouponObserver iObtainedCouponObserver = this.mObserver;
        if (iObtainedCouponObserver != null) {
            iObtainedCouponObserver.onResult(obtainedCouponResult);
        }
    }
}
