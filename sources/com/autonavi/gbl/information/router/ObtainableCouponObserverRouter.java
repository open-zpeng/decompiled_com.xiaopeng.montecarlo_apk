package com.autonavi.gbl.information.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.model.ObtainableCouponResult;
import com.autonavi.gbl.information.trade.observer.IObtainableCouponObserver;
import com.autonavi.gbl.information.trade.observer.impl.IObtainableCouponObserverImpl;
@IntfAuto(target = IObtainableCouponObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ObtainableCouponObserverRouter extends IObtainableCouponObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ObtainableCouponObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ObtainableCouponObserverRouter.class);
    private TypeHelper mHelper;
    private IObtainableCouponObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IObtainableCouponObserver iObtainableCouponObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IObtainableCouponObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iObtainableCouponObserver;
    }

    protected ObtainableCouponObserverRouter(String str, IObtainableCouponObserver iObtainableCouponObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iObtainableCouponObserver);
    }

    protected ObtainableCouponObserverRouter(String str, IObtainableCouponObserver iObtainableCouponObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iObtainableCouponObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.observer.impl.IObtainableCouponObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IObtainableCouponObserverImpl
    public void onResult(ObtainableCouponResult obtainableCouponResult) {
        IObtainableCouponObserver iObtainableCouponObserver = this.mObserver;
        if (iObtainableCouponObserver != null) {
            iObtainableCouponObserver.onResult(obtainableCouponResult);
        }
    }
}
