package com.autonavi.gbl.route.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.route.model.ChargingStationID;
import com.autonavi.gbl.route.observer.IChargingStationIDObserver;
import java.util.ArrayList;
@IntfAuto(target = IChargingStationIDObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IChargingStationIDObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IChargingStationIDObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IChargingStationIDObserverImpl_change_ownership(IChargingStationIDObserverImpl iChargingStationIDObserverImpl, long j, boolean z);

    private static native void IChargingStationIDObserverImpl_director_connect(IChargingStationIDObserverImpl iChargingStationIDObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onChargingStationIDUpdatedNative(long j, IChargingStationIDObserverImpl iChargingStationIDObserverImpl, ArrayList<ChargingStationID> arrayList);

    public IChargingStationIDObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IChargingStationIDObserverImpl) && getUID(this) == getUID((IChargingStationIDObserverImpl) obj);
    }

    private static long getUID(IChargingStationIDObserverImpl iChargingStationIDObserverImpl) {
        long cPtr = getCPtr(iChargingStationIDObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IChargingStationIDObserverImpl iChargingStationIDObserverImpl) {
        if (iChargingStationIDObserverImpl == null) {
            return 0L;
        }
        return iChargingStationIDObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        IChargingStationIDObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IChargingStationIDObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onChargingStationIDUpdated(ArrayList<ChargingStationID> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onChargingStationIDUpdatedNative(j, this, arrayList);
    }

    public IChargingStationIDObserverImpl() {
        this(createNativeObj(), true);
        RouteObserverJNI.swig_jni_init();
        IChargingStationIDObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
