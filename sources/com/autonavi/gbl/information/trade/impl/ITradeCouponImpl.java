package com.autonavi.gbl.information.trade.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.TradeCoupon;
import com.autonavi.gbl.information.trade.model.ObtainCouponRequest;
import com.autonavi.gbl.information.trade.model.ObtainableCouponRequest;
import com.autonavi.gbl.information.trade.model.ObtainedCouponRequest;
import com.autonavi.gbl.information.trade.model.UsableCouponRequest;
import com.autonavi.gbl.information.trade.observer.impl.IObtainCouponObserverImpl;
import com.autonavi.gbl.information.trade.observer.impl.IObtainableCouponObserverImpl;
import com.autonavi.gbl.information.trade.observer.impl.IObtainedCouponObserverImpl;
import com.autonavi.gbl.information.trade.observer.impl.IUsableCouponObserverImpl;
import com.autonavi.gbl.util.model.TaskResult;
@IntfAuto(target = TradeCoupon.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ITradeCouponImpl {
    private static BindTable BIND_TABLE = new BindTable(ITradeCouponImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void abortAllNative(long j, ITradeCouponImpl iTradeCouponImpl);

    private static native void abortNative(long j, ITradeCouponImpl iTradeCouponImpl, long j2);

    private static native void destroyNativeObj(long j);

    private static native TaskResult request1Native(long j, ITradeCouponImpl iTradeCouponImpl, long j2, ObtainCouponRequest obtainCouponRequest, long j3, IObtainCouponObserverImpl iObtainCouponObserverImpl);

    private static native TaskResult request2Native(long j, ITradeCouponImpl iTradeCouponImpl, long j2, ObtainedCouponRequest obtainedCouponRequest, long j3, IObtainedCouponObserverImpl iObtainedCouponObserverImpl);

    private static native TaskResult request3Native(long j, ITradeCouponImpl iTradeCouponImpl, long j2, UsableCouponRequest usableCouponRequest, long j3, IUsableCouponObserverImpl iUsableCouponObserverImpl);

    private static native TaskResult requestNative(long j, ITradeCouponImpl iTradeCouponImpl, long j2, ObtainableCouponRequest obtainableCouponRequest, long j3, IObtainableCouponObserverImpl iObtainableCouponObserverImpl);

    public ITradeCouponImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ITradeCouponImpl) && getUID(this) == getUID((ITradeCouponImpl) obj);
    }

    private static long getUID(ITradeCouponImpl iTradeCouponImpl) {
        long cPtr = getCPtr(iTradeCouponImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ITradeCouponImpl iTradeCouponImpl) {
        if (iTradeCouponImpl == null) {
            return 0L;
        }
        return iTradeCouponImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public TaskResult request(ObtainableCouponRequest obtainableCouponRequest, IObtainableCouponObserverImpl iObtainableCouponObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestNative(j, this, 0L, obtainableCouponRequest, IObtainableCouponObserverImpl.getCPtr(iObtainableCouponObserverImpl), iObtainableCouponObserverImpl);
    }

    public TaskResult request(ObtainCouponRequest obtainCouponRequest, IObtainCouponObserverImpl iObtainCouponObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return request1Native(j, this, 0L, obtainCouponRequest, IObtainCouponObserverImpl.getCPtr(iObtainCouponObserverImpl), iObtainCouponObserverImpl);
    }

    public TaskResult request(ObtainedCouponRequest obtainedCouponRequest, IObtainedCouponObserverImpl iObtainedCouponObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return request2Native(j, this, 0L, obtainedCouponRequest, IObtainedCouponObserverImpl.getCPtr(iObtainedCouponObserverImpl), iObtainedCouponObserverImpl);
    }

    public TaskResult request(UsableCouponRequest usableCouponRequest, IUsableCouponObserverImpl iUsableCouponObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return request3Native(j, this, 0L, usableCouponRequest, IUsableCouponObserverImpl.getCPtr(iUsableCouponObserverImpl), iUsableCouponObserverImpl);
    }

    public void abort(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        abortNative(j2, this, j);
    }

    public void abortAll() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortAllNative(j, this);
    }
}
