package com.autonavi.gbl.information.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.model.FuelOrderDetailResult;
import com.autonavi.gbl.information.trade.model.FuelTradePriceResult;
import com.autonavi.gbl.information.trade.model.FuelTradeSubmitResult;
import com.autonavi.gbl.information.trade.observer.IFuelTradeObserver;
import com.autonavi.gbl.information.trade.observer.impl.IFuelTradeObserverImpl;
@IntfAuto(target = IFuelTradeObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class FuelTradeObserverRouter extends IFuelTradeObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(FuelTradeObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(FuelTradeObserverRouter.class);
    private TypeHelper mHelper;
    private IFuelTradeObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IFuelTradeObserver iFuelTradeObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IFuelTradeObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iFuelTradeObserver;
    }

    protected FuelTradeObserverRouter(String str, IFuelTradeObserver iFuelTradeObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iFuelTradeObserver);
    }

    protected FuelTradeObserverRouter(String str, IFuelTradeObserver iFuelTradeObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iFuelTradeObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.observer.impl.IFuelTradeObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IFuelTradeObserverImpl
    public void onResult(FuelTradePriceResult fuelTradePriceResult) {
        IFuelTradeObserver iFuelTradeObserver = this.mObserver;
        if (iFuelTradeObserver != null) {
            iFuelTradeObserver.onResult(fuelTradePriceResult);
        }
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IFuelTradeObserverImpl
    public void onResult(FuelTradeSubmitResult fuelTradeSubmitResult) {
        IFuelTradeObserver iFuelTradeObserver = this.mObserver;
        if (iFuelTradeObserver != null) {
            iFuelTradeObserver.onResult(fuelTradeSubmitResult);
        }
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IFuelTradeObserverImpl
    public void onResult(FuelOrderDetailResult fuelOrderDetailResult) {
        IFuelTradeObserver iFuelTradeObserver = this.mObserver;
        if (iFuelTradeObserver != null) {
            iFuelTradeObserver.onResult(fuelOrderDetailResult);
        }
    }
}
