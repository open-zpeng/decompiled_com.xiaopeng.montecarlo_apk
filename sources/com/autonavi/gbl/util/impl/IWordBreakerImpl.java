package com.autonavi.gbl.util.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.WordBreaker;
import com.autonavi.gbl.util.observer.impl.IWordBreakAdapterImpl;
@IntfAuto(target = WordBreaker.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IWordBreakerImpl {
    private static BindTable BIND_TABLE = new BindTable(IWordBreakerImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long getInstanceNative();

    private static native void setAdapterNative(long j, IWordBreakerImpl iWordBreakerImpl, long j2, IWordBreakAdapterImpl iWordBreakAdapterImpl);

    public IWordBreakerImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IWordBreakerImpl) && getUID(this) == getUID((IWordBreakerImpl) obj);
    }

    private static long getUID(IWordBreakerImpl iWordBreakerImpl) {
        long cPtr = getCPtr(iWordBreakerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IWordBreakerImpl iWordBreakerImpl) {
        if (iWordBreakerImpl == null) {
            return 0L;
        }
        return iWordBreakerImpl.swigCPtr;
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
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0L;
        }
    }

    public static IWordBreakerImpl getInstance() {
        long instanceNative = getInstanceNative();
        if (instanceNative == 0) {
            return null;
        }
        return new IWordBreakerImpl(instanceNative, false);
    }

    public void setAdapter(IWordBreakAdapterImpl iWordBreakAdapterImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setAdapterNative(j, this, IWordBreakAdapterImpl.getCPtr(iWordBreakAdapterImpl), iWordBreakAdapterImpl);
    }
}
