package com.autonavi.gbl.user.forcast.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.forcast.ForcastService;
import com.autonavi.gbl.user.forcast.model.ArrivedType;
import com.autonavi.gbl.user.forcast.model.EnergyCollect;
import com.autonavi.gbl.user.forcast.model.EnergyPoint;
import com.autonavi.gbl.user.forcast.model.ForcastArrivedParam;
import com.autonavi.gbl.user.forcast.model.ForcastInitParam;
import com.autonavi.gbl.user.forcast.model.OftenArrivedItem;
import com.autonavi.gbl.user.forcast.model.RoadType;
import com.autonavi.gbl.user.forcast.observer.impl.IForcastServiceObserverImpl;
import com.autonavi.gbl.user.model.UserLoginInfo;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = ForcastService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IForcastServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IForcastServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int addEnergyPointNative(long j, IForcastServiceImpl iForcastServiceImpl, int i, long j2, EnergyPoint energyPoint);

    private static native int addLocalArrivedDataNative(long j, IForcastServiceImpl iForcastServiceImpl, int i, long j2, OftenArrivedItem oftenArrivedItem);

    private static native int addObserverNative(long j, IForcastServiceImpl iForcastServiceImpl, long j2, IForcastServiceObserverImpl iForcastServiceObserverImpl);

    private static native int delLocalArrivedDataNative(long j, IForcastServiceImpl iForcastServiceImpl, int i, String str);

    private static native void destroyNativeObj(long j);

    private static native int getArrivedDataListNative(long j, IForcastServiceImpl iForcastServiceImpl, int i, ArrayList<OftenArrivedItem> arrayList);

    private static native int getEnergyCollectionNative(long j, IForcastServiceImpl iForcastServiceImpl, int i, int i2, long j2, EnergyCollect energyCollect);

    private static native int getOnlineForcastArrivedDataNative(long j, IForcastServiceImpl iForcastServiceImpl, long j2, ForcastArrivedParam forcastArrivedParam);

    private static native String getVersionNative(long j, IForcastServiceImpl iForcastServiceImpl);

    private static native int initNative(long j, IForcastServiceImpl iForcastServiceImpl, long j2, ForcastInitParam forcastInitParam);

    private static native int isInitNative(long j, IForcastServiceImpl iForcastServiceImpl);

    private static native void removeObserverNative(long j, IForcastServiceImpl iForcastServiceImpl, long j2, IForcastServiceObserverImpl iForcastServiceObserverImpl);

    private static native int setLoginInfoNative(long j, IForcastServiceImpl iForcastServiceImpl, long j2, UserLoginInfo userLoginInfo);

    private static native int topArrivedDataNative(long j, IForcastServiceImpl iForcastServiceImpl, String str);

    private static native void unInitNative(long j, IForcastServiceImpl iForcastServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IForcastServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IForcastServiceImpl) && getUID(this) == getUID((IForcastServiceImpl) obj);
    }

    private static long getUID(IForcastServiceImpl iForcastServiceImpl) {
        long cPtr = getCPtr(iForcastServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IForcastServiceImpl iForcastServiceImpl) {
        if (iForcastServiceImpl == null) {
            return 0L;
        }
        return iForcastServiceImpl.swigCPtr;
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

    public int setLoginInfo(UserLoginInfo userLoginInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLoginInfoNative(j, this, 0L, userLoginInfo);
    }

    public int init(ForcastInitParam forcastInitParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, forcastInitParam);
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

    public int addObserver(IForcastServiceObserverImpl iForcastServiceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserverNative(j, this, IForcastServiceObserverImpl.getCPtr(iForcastServiceObserverImpl), iForcastServiceObserverImpl);
    }

    public void removeObserver(IForcastServiceObserverImpl iForcastServiceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeObserverNative(j, this, IForcastServiceObserverImpl.getCPtr(iForcastServiceObserverImpl), iForcastServiceObserverImpl);
    }

    public int getOnlineForcastArrivedData(ForcastArrivedParam forcastArrivedParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getOnlineForcastArrivedDataNative(j, this, 0L, forcastArrivedParam);
    }

    public ArrayList<OftenArrivedItem> getArrivedDataList(@ArrivedType.ArrivedType1 int i) {
        ArrayList<OftenArrivedItem> arrayList = new ArrayList<>();
        if (Integer.valueOf(getArrivedDataList(i, arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getArrivedDataList(@ArrivedType.ArrivedType1 int i, ArrayList<OftenArrivedItem> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getArrivedDataListNative(j, this, i, arrayList);
    }

    public int addLocalArrivedData(@ArrivedType.ArrivedType1 int i, OftenArrivedItem oftenArrivedItem) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addLocalArrivedDataNative(j, this, i, 0L, oftenArrivedItem);
    }

    public int delLocalArrivedData(@ArrivedType.ArrivedType1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return delLocalArrivedDataNative(j, this, i, str);
    }

    public int topArrivedData(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return topArrivedDataNative(j, this, str);
    }

    public int addEnergyPoint(@RoadType.RoadType1 int i, EnergyPoint energyPoint) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addEnergyPointNative(j, this, i, 0L, energyPoint);
    }

    public EnergyCollect getEnergyCollection(@RoadType.RoadType1 int i, int i2) {
        EnergyCollect energyCollect = new EnergyCollect();
        if (Integer.valueOf(getEnergyCollection(i, i2, energyCollect)).intValue() == 0) {
            return energyCollect;
        }
        return null;
    }

    private int getEnergyCollection(@RoadType.RoadType1 int i, int i2, EnergyCollect energyCollect) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getEnergyCollectionNative(j, this, i, i2, 0L, energyCollect);
    }
}
