package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.observer.ICarObserver;
import com.autonavi.gbl.map.layer.observer.impl.ICarObserverImpl;
@IntfAuto(target = ICarObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CarObserverRouter extends ICarObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(CarObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(CarObserverRouter.class);
    private TypeHelper mHelper;
    private ICarObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ICarObserver iCarObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICarObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCarObserver;
    }

    protected CarObserverRouter(String str, ICarObserver iCarObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCarObserver);
    }

    protected CarObserverRouter(String str, ICarObserver iCarObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCarObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.observer.impl.ICarObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.ICarObserverImpl
    public void onCarClick(CarLoc carLoc) {
        ICarObserver iCarObserver = this.mObserver;
        if (iCarObserver != null) {
            iCarObserver.onCarClick(carLoc);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.ICarObserverImpl
    public void onCarLocChange(CarLoc carLoc) {
        ICarObserver iCarObserver = this.mObserver;
        if (iCarObserver != null) {
            iCarObserver.onCarLocChange(carLoc);
        }
    }
}
