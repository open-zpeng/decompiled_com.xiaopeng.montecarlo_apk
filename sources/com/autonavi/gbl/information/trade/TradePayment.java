package com.autonavi.gbl.information.trade;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.impl.ITradePaymentImpl;
import com.autonavi.gbl.information.trade.model.AgreementStatusRequest;
import com.autonavi.gbl.information.trade.observer.IAgreementStatusObserver;
import com.autonavi.gbl.information.trade.observer.impl.IAgreementStatusObserverImpl;
import com.autonavi.gbl.util.model.TaskResult;
import com.lzy.okgo.model.Progress;
@IntfAuto(target = ITradePaymentImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class TradePayment {
    private static String PACKAGE = ReflexTool.PN(TradePayment.class);
    private ITradePaymentImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected TradePayment(long j, boolean z) {
        this(new ITradePaymentImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(TradePayment.class, this, this.mControl);
        }
    }

    public TradePayment(ITradePaymentImpl iTradePaymentImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iTradePaymentImpl);
    }

    private void $constructor(ITradePaymentImpl iTradePaymentImpl) {
        if (iTradePaymentImpl != null) {
            this.mControl = iTradePaymentImpl;
            this.mTargetId = String.format("TradePayment_%s_%d", String.valueOf(ITradePaymentImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ITradePaymentImpl getControl() {
        return this.mControl;
    }

    public TaskResult request(AgreementStatusRequest agreementStatusRequest, IAgreementStatusObserver iAgreementStatusObserver) {
        TypeHelper typeHelper;
        try {
            IAgreementStatusObserverImpl iAgreementStatusObserverImpl = (iAgreementStatusObserver == null || (typeHelper = this.mTypeHelper) == null) ? null : (IAgreementStatusObserverImpl) typeHelper.transfer(TradePayment.class.getMethod(Progress.REQUEST, AgreementStatusRequest.class, IAgreementStatusObserver.class), 1, iAgreementStatusObserver);
            ITradePaymentImpl iTradePaymentImpl = this.mControl;
            if (iTradePaymentImpl != null) {
                return iTradePaymentImpl.request(agreementStatusRequest, iAgreementStatusObserverImpl);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void abort(int i) {
        ITradePaymentImpl iTradePaymentImpl = this.mControl;
        if (iTradePaymentImpl != null) {
            iTradePaymentImpl.abort(i);
        }
    }

    public void abortAll() {
        ITradePaymentImpl iTradePaymentImpl = this.mControl;
        if (iTradePaymentImpl != null) {
            iTradePaymentImpl.abortAll();
        }
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

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
