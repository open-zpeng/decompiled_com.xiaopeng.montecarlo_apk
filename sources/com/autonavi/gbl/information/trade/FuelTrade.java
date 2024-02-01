package com.autonavi.gbl.information.trade;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.impl.IFuelTradeImpl;
import com.autonavi.gbl.information.trade.model.FuelTradePrice;
import com.autonavi.gbl.information.trade.model.FuelTradeSubmit;
import com.autonavi.gbl.information.trade.observer.IFuelTradeObserver;
import com.autonavi.gbl.information.trade.observer.impl.IFuelTradeObserverImpl;
import com.autonavi.gbl.util.model.TaskResult;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IFuelTradeImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class FuelTrade extends Trade {
    private static String PACKAGE = ReflexTool.PN(FuelTrade.class);
    private IFuelTradeImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected FuelTrade(long j, boolean z) {
        this(new IFuelTradeImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(FuelTrade.class, this, this.mControl);
        }
    }

    public FuelTrade(IFuelTradeImpl iFuelTradeImpl) {
        super(iFuelTradeImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iFuelTradeImpl);
    }

    private void $constructor(IFuelTradeImpl iFuelTradeImpl) {
        if (iFuelTradeImpl != null) {
            this.mControl = iFuelTradeImpl;
            this.mTargetId = String.format("FuelTrade_%s_%d", String.valueOf(IFuelTradeImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.Trade
    public IFuelTradeImpl getControl() {
        return this.mControl;
    }

    public void addObserver(IFuelTradeObserver iFuelTradeObserver) {
        TypeHelper typeHelper;
        try {
            Method method = FuelTrade.class.getMethod("addObserver", IFuelTradeObserver.class);
            IFuelTradeObserverImpl iFuelTradeObserverImpl = null;
            if (iFuelTradeObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iFuelTradeObserverImpl = (IFuelTradeObserverImpl) typeHelper.transfer(method, 0, iFuelTradeObserver);
            }
            IFuelTradeImpl iFuelTradeImpl = this.mControl;
            if (iFuelTradeImpl != null) {
                iFuelTradeImpl.addObserver(iFuelTradeObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeObserver(IFuelTradeObserver iFuelTradeObserver) {
        TypeHelper typeHelper;
        try {
            Method method = FuelTrade.class.getMethod("removeObserver", IFuelTradeObserver.class);
            IFuelTradeObserverImpl iFuelTradeObserverImpl = null;
            if (iFuelTradeObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iFuelTradeObserverImpl = (IFuelTradeObserverImpl) typeHelper.transfer(method, 0, iFuelTradeObserver);
            }
            IFuelTradeImpl iFuelTradeImpl = this.mControl;
            if (iFuelTradeImpl != null) {
                iFuelTradeImpl.removeObserver(iFuelTradeObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iFuelTradeObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public TaskResult request(FuelTradePrice fuelTradePrice) {
        IFuelTradeImpl iFuelTradeImpl = this.mControl;
        if (iFuelTradeImpl != null) {
            return iFuelTradeImpl.request(fuelTradePrice);
        }
        return null;
    }

    public TaskResult request(FuelTradeSubmit fuelTradeSubmit) {
        IFuelTradeImpl iFuelTradeImpl = this.mControl;
        if (iFuelTradeImpl != null) {
            return iFuelTradeImpl.request(fuelTradeSubmit);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.Trade
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    @Override // com.autonavi.gbl.information.trade.Trade
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.Trade
    public void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.information.trade.observer.IFuelTradeObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((IFuelTradeObserver) it.next());
            }
        }
        super.clean();
    }

    @Override // com.autonavi.gbl.information.trade.Trade
    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
