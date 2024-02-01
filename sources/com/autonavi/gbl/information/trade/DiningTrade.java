package com.autonavi.gbl.information.trade;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.impl.IDiningTradeImpl;
import com.autonavi.gbl.information.trade.model.DiningTradePrice;
import com.autonavi.gbl.information.trade.model.DiningTradeSubmit;
import com.autonavi.gbl.information.trade.observer.IDiningTradeObserver;
import com.autonavi.gbl.information.trade.observer.impl.IDiningTradeObserverImpl;
import com.autonavi.gbl.util.model.TaskResult;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IDiningTradeImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class DiningTrade extends Trade {
    private static String PACKAGE = ReflexTool.PN(DiningTrade.class);
    private IDiningTradeImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected DiningTrade(long j, boolean z) {
        this(new IDiningTradeImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(DiningTrade.class, this, this.mControl);
        }
    }

    public DiningTrade(IDiningTradeImpl iDiningTradeImpl) {
        super(iDiningTradeImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iDiningTradeImpl);
    }

    private void $constructor(IDiningTradeImpl iDiningTradeImpl) {
        if (iDiningTradeImpl != null) {
            this.mControl = iDiningTradeImpl;
            this.mTargetId = String.format("DiningTrade_%s_%d", String.valueOf(IDiningTradeImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.Trade
    public IDiningTradeImpl getControl() {
        return this.mControl;
    }

    public void addObserver(IDiningTradeObserver iDiningTradeObserver) {
        TypeHelper typeHelper;
        try {
            Method method = DiningTrade.class.getMethod("addObserver", IDiningTradeObserver.class);
            IDiningTradeObserverImpl iDiningTradeObserverImpl = null;
            if (iDiningTradeObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iDiningTradeObserverImpl = (IDiningTradeObserverImpl) typeHelper.transfer(method, 0, iDiningTradeObserver);
            }
            IDiningTradeImpl iDiningTradeImpl = this.mControl;
            if (iDiningTradeImpl != null) {
                iDiningTradeImpl.addObserver(iDiningTradeObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeObserver(IDiningTradeObserver iDiningTradeObserver) {
        TypeHelper typeHelper;
        try {
            Method method = DiningTrade.class.getMethod("removeObserver", IDiningTradeObserver.class);
            IDiningTradeObserverImpl iDiningTradeObserverImpl = null;
            if (iDiningTradeObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iDiningTradeObserverImpl = (IDiningTradeObserverImpl) typeHelper.transfer(method, 0, iDiningTradeObserver);
            }
            IDiningTradeImpl iDiningTradeImpl = this.mControl;
            if (iDiningTradeImpl != null) {
                iDiningTradeImpl.removeObserver(iDiningTradeObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iDiningTradeObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public TaskResult request(DiningTradePrice diningTradePrice) {
        IDiningTradeImpl iDiningTradeImpl = this.mControl;
        if (iDiningTradeImpl != null) {
            return iDiningTradeImpl.request(diningTradePrice);
        }
        return null;
    }

    public TaskResult request(DiningTradeSubmit diningTradeSubmit) {
        IDiningTradeImpl iDiningTradeImpl = this.mControl;
        if (iDiningTradeImpl != null) {
            return iDiningTradeImpl.request(diningTradeSubmit);
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
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.information.trade.observer.IDiningTradeObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((IDiningTradeObserver) it.next());
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
