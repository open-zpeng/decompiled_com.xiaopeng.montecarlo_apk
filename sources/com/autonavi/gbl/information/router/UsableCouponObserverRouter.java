package com.autonavi.gbl.information.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.model.UsableCouponResult;
import com.autonavi.gbl.information.trade.observer.IUsableCouponObserver;
import com.autonavi.gbl.information.trade.observer.impl.IUsableCouponObserverImpl;
@IntfAuto(target = IUsableCouponObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class UsableCouponObserverRouter extends IUsableCouponObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(UsableCouponObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(UsableCouponObserverRouter.class);
    private TypeHelper mHelper;
    private IUsableCouponObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IUsableCouponObserver iUsableCouponObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IUsableCouponObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iUsableCouponObserver;
    }

    protected UsableCouponObserverRouter(String str, IUsableCouponObserver iUsableCouponObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iUsableCouponObserver);
    }

    protected UsableCouponObserverRouter(String str, IUsableCouponObserver iUsableCouponObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iUsableCouponObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.observer.impl.IUsableCouponObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IUsableCouponObserverImpl
    public void onResult(UsableCouponResult usableCouponResult) {
        IUsableCouponObserver iUsableCouponObserver = this.mObserver;
        if (iUsableCouponObserver != null) {
            iUsableCouponObserver.onResult(usableCouponResult);
        }
    }
}
