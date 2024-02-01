package com.autonavi.gbl.information.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.InformationService;
import com.autonavi.gbl.information.model.InformationInitParam;
import com.autonavi.gbl.information.nearby.impl.INearbyRecommendControlImpl;
import com.autonavi.gbl.information.trade.impl.ITradeControlImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = InformationService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IInformationServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IInformationServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native long getNearbyRecommendControlNative(long j, IInformationServiceImpl iInformationServiceImpl);

    private static native long getTradeControlNative(long j, IInformationServiceImpl iInformationServiceImpl);

    private static native String getVersionNative(long j, IInformationServiceImpl iInformationServiceImpl);

    private static native int initNative(long j, IInformationServiceImpl iInformationServiceImpl, long j2, InformationInitParam informationInitParam);

    private static native int isInitNative(long j, IInformationServiceImpl iInformationServiceImpl);

    private static native void unInitNative(long j, IInformationServiceImpl iInformationServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IInformationServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IInformationServiceImpl) && getUID(this) == getUID((IInformationServiceImpl) obj);
    }

    private static long getUID(IInformationServiceImpl iInformationServiceImpl) {
        long cPtr = getCPtr(iInformationServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IInformationServiceImpl iInformationServiceImpl) {
        if (iInformationServiceImpl == null) {
            return 0L;
        }
        return iInformationServiceImpl.swigCPtr;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        return this.swigCPtr;
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

    public int init(InformationInitParam informationInitParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, informationInitParam);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public String getVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVersionNative(j, this);
    }

    public ITradeControlImpl getTradeControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long tradeControlNative = getTradeControlNative(j, this);
        if (tradeControlNative == 0) {
            return null;
        }
        return new ITradeControlImpl(tradeControlNative, false);
    }

    public INearbyRecommendControlImpl getNearbyRecommendControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long nearbyRecommendControlNative = getNearbyRecommendControlNative(j, this);
        if (nearbyRecommendControlNative == 0) {
            return null;
        }
        return new INearbyRecommendControlImpl(nearbyRecommendControlNative, false);
    }
}
