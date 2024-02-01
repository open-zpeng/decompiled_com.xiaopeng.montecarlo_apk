package com.autonavi.gbl.route.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.route.RouteConsisAdditionService;
import com.autonavi.gbl.route.model.ConsisPathBinaryData;
import com.autonavi.gbl.route.observer.impl.IRouteConsisAdditionObserverImpl;
import com.autonavi.gbl.util.model.BinaryStream;
import com.autonavi.gbl.util.model.DateTime;
@IntfAuto(target = RouteConsisAdditionService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IRouteConsisAdditionServiceImpl {
    private static BindTable BIND_TABLE = new BindTable(IRouteConsisAdditionServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addRouteConsisAdditionObserverNative(long j, IRouteConsisAdditionServiceImpl iRouteConsisAdditionServiceImpl, long j2, IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native void removeRouteConsisAdditionObserverNative(long j, IRouteConsisAdditionServiceImpl iRouteConsisAdditionServiceImpl, long j2, IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl);

    private static native void setRoutePlanTimeNative(long j, IRouteConsisAdditionServiceImpl iRouteConsisAdditionServiceImpl, long j2, DateTime dateTime);

    private static native long syncOnlinePathToMultiSource1Native(long j, IRouteConsisAdditionServiceImpl iRouteConsisAdditionServiceImpl, long j2, ConsisPathBinaryData consisPathBinaryData, long j3, BinaryStream binaryStream);

    private static native long syncOnlinePathToMultiSourceNative(long j, IRouteConsisAdditionServiceImpl iRouteConsisAdditionServiceImpl, long j2, ConsisPathBinaryData consisPathBinaryData, long j3, BinaryStream binaryStream, long j4);

    public IRouteConsisAdditionServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IRouteConsisAdditionServiceImpl) && getUID(this) == getUID((IRouteConsisAdditionServiceImpl) obj);
    }

    private static long getUID(IRouteConsisAdditionServiceImpl iRouteConsisAdditionServiceImpl) {
        long cPtr = getCPtr(iRouteConsisAdditionServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IRouteConsisAdditionServiceImpl iRouteConsisAdditionServiceImpl) {
        if (iRouteConsisAdditionServiceImpl == null) {
            return 0L;
        }
        return iRouteConsisAdditionServiceImpl.swigCPtr;
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

    public void addRouteConsisAdditionObserver(IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addRouteConsisAdditionObserverNative(j, this, IRouteConsisAdditionObserverImpl.getCPtr(iRouteConsisAdditionObserverImpl), iRouteConsisAdditionObserverImpl);
    }

    public void removeRouteConsisAdditionObserver(IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeRouteConsisAdditionObserverNative(j, this, IRouteConsisAdditionObserverImpl.getCPtr(iRouteConsisAdditionObserverImpl), iRouteConsisAdditionObserverImpl);
    }

    public void setRoutePlanTime(DateTime dateTime) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRoutePlanTimeNative(j, this, 0L, dateTime);
    }

    public long syncOnlinePathToMultiSource(ConsisPathBinaryData consisPathBinaryData, BinaryStream binaryStream, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return syncOnlinePathToMultiSourceNative(j2, this, 0L, consisPathBinaryData, 0L, binaryStream, j);
    }

    public long syncOnlinePathToMultiSource(ConsisPathBinaryData consisPathBinaryData, BinaryStream binaryStream) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return syncOnlinePathToMultiSource1Native(j, this, 0L, consisPathBinaryData, 0L, binaryStream);
    }
}
