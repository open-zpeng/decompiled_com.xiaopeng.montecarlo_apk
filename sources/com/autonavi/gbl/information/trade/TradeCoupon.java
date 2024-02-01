package com.autonavi.gbl.information.trade;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.impl.ITradeCouponImpl;
import com.autonavi.gbl.information.trade.model.ObtainCouponRequest;
import com.autonavi.gbl.information.trade.model.ObtainableCouponRequest;
import com.autonavi.gbl.information.trade.model.ObtainedCouponRequest;
import com.autonavi.gbl.information.trade.model.UsableCouponRequest;
import com.autonavi.gbl.information.trade.observer.IObtainCouponObserver;
import com.autonavi.gbl.information.trade.observer.IObtainableCouponObserver;
import com.autonavi.gbl.information.trade.observer.IObtainedCouponObserver;
import com.autonavi.gbl.information.trade.observer.IUsableCouponObserver;
import com.autonavi.gbl.information.trade.observer.impl.IObtainCouponObserverImpl;
import com.autonavi.gbl.information.trade.observer.impl.IObtainableCouponObserverImpl;
import com.autonavi.gbl.information.trade.observer.impl.IObtainedCouponObserverImpl;
import com.autonavi.gbl.information.trade.observer.impl.IUsableCouponObserverImpl;
import com.autonavi.gbl.util.model.TaskResult;
import com.lzy.okgo.model.Progress;
@IntfAuto(target = ITradeCouponImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class TradeCoupon {
    private static String PACKAGE = ReflexTool.PN(TradeCoupon.class);
    private ITradeCouponImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected TradeCoupon(long j, boolean z) {
        this(new ITradeCouponImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(TradeCoupon.class, this, this.mControl);
        }
    }

    public TradeCoupon(ITradeCouponImpl iTradeCouponImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iTradeCouponImpl);
    }

    private void $constructor(ITradeCouponImpl iTradeCouponImpl) {
        if (iTradeCouponImpl != null) {
            this.mControl = iTradeCouponImpl;
            this.mTargetId = String.format("TradeCoupon_%s_%d", String.valueOf(ITradeCouponImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ITradeCouponImpl getControl() {
        return this.mControl;
    }

    public TaskResult request(ObtainableCouponRequest obtainableCouponRequest, IObtainableCouponObserver iObtainableCouponObserver) {
        TypeHelper typeHelper;
        try {
            IObtainableCouponObserverImpl iObtainableCouponObserverImpl = (iObtainableCouponObserver == null || (typeHelper = this.mTypeHelper) == null) ? null : (IObtainableCouponObserverImpl) typeHelper.transfer(TradeCoupon.class.getMethod(Progress.REQUEST, ObtainableCouponRequest.class, IObtainableCouponObserver.class), 1, iObtainableCouponObserver);
            ITradeCouponImpl iTradeCouponImpl = this.mControl;
            if (iTradeCouponImpl != null) {
                return iTradeCouponImpl.request(obtainableCouponRequest, iObtainableCouponObserverImpl);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public TaskResult request(ObtainCouponRequest obtainCouponRequest, IObtainCouponObserver iObtainCouponObserver) {
        TypeHelper typeHelper;
        try {
            IObtainCouponObserverImpl iObtainCouponObserverImpl = (iObtainCouponObserver == null || (typeHelper = this.mTypeHelper) == null) ? null : (IObtainCouponObserverImpl) typeHelper.transfer(TradeCoupon.class.getMethod(Progress.REQUEST, ObtainCouponRequest.class, IObtainCouponObserver.class), 1, iObtainCouponObserver);
            ITradeCouponImpl iTradeCouponImpl = this.mControl;
            if (iTradeCouponImpl != null) {
                return iTradeCouponImpl.request(obtainCouponRequest, iObtainCouponObserverImpl);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public TaskResult request(ObtainedCouponRequest obtainedCouponRequest, IObtainedCouponObserver iObtainedCouponObserver) {
        TypeHelper typeHelper;
        try {
            IObtainedCouponObserverImpl iObtainedCouponObserverImpl = (iObtainedCouponObserver == null || (typeHelper = this.mTypeHelper) == null) ? null : (IObtainedCouponObserverImpl) typeHelper.transfer(TradeCoupon.class.getMethod(Progress.REQUEST, ObtainedCouponRequest.class, IObtainedCouponObserver.class), 1, iObtainedCouponObserver);
            ITradeCouponImpl iTradeCouponImpl = this.mControl;
            if (iTradeCouponImpl != null) {
                return iTradeCouponImpl.request(obtainedCouponRequest, iObtainedCouponObserverImpl);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public TaskResult request(UsableCouponRequest usableCouponRequest, IUsableCouponObserver iUsableCouponObserver) {
        TypeHelper typeHelper;
        try {
            IUsableCouponObserverImpl iUsableCouponObserverImpl = (iUsableCouponObserver == null || (typeHelper = this.mTypeHelper) == null) ? null : (IUsableCouponObserverImpl) typeHelper.transfer(TradeCoupon.class.getMethod(Progress.REQUEST, UsableCouponRequest.class, IUsableCouponObserver.class), 1, iUsableCouponObserver);
            ITradeCouponImpl iTradeCouponImpl = this.mControl;
            if (iTradeCouponImpl != null) {
                return iTradeCouponImpl.request(usableCouponRequest, iUsableCouponObserverImpl);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void abort(long j) {
        ITradeCouponImpl iTradeCouponImpl = this.mControl;
        if (iTradeCouponImpl != null) {
            iTradeCouponImpl.abort(j);
        }
    }

    public void abortAll() {
        ITradeCouponImpl iTradeCouponImpl = this.mControl;
        if (iTradeCouponImpl != null) {
            iTradeCouponImpl.abortAll();
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
