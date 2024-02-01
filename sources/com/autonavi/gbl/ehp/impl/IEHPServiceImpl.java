package com.autonavi.gbl.ehp.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.ehp.EHPService;
import com.autonavi.gbl.ehp.model.EHPCar2XEvent;
import com.autonavi.gbl.ehp.model.EHPConfigType;
import com.autonavi.gbl.ehp.model.EHPInitParam;
import com.autonavi.gbl.ehp.observer.impl.IEHPHdDataVersionObserverImpl;
import com.autonavi.gbl.ehp.observer.impl.IEHPOutputObserverImpl;
import com.autonavi.gbl.ehp.observer.impl.IGEhpAdasDataCallbackImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.NetworkStatus;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = EHPService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IEHPServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IEHPServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean abortAdasDataAllRequestNative(long j, IEHPServiceImpl iEHPServiceImpl);

    private static native boolean abortAdasDataRequestNative(long j, IEHPServiceImpl iEHPServiceImpl, long j2);

    private static native boolean addHdDataVersionObserverNative(long j, IEHPServiceImpl iEHPServiceImpl, long j2, IEHPHdDataVersionObserverImpl iEHPHdDataVersionObserverImpl);

    private static native boolean addOutputObserverNative(long j, IEHPServiceImpl iEHPServiceImpl, long j2, IEHPOutputObserverImpl iEHPOutputObserverImpl);

    private static native boolean clearOutputObserverNative(long j, IEHPServiceImpl iEHPServiceImpl);

    private static native void destroyNativeObj(long j);

    private static native String getEngineVersionNative();

    private static native String getVersionNative(long j, IEHPServiceImpl iEHPServiceImpl);

    private static native boolean initNative(long j, IEHPServiceImpl iEHPServiceImpl, long j2, EHPInitParam eHPInitParam);

    private static native void inputInterDomainMessageNative(long j, IEHPServiceImpl iEHPServiceImpl, String str);

    private static native void inputMsgNative(long j, IEHPServiceImpl iEHPServiceImpl, String str);

    private static native boolean isAutoUpdateRouteNative(long j, IEHPServiceImpl iEHPServiceImpl);

    private static native int isInitNative(long j, IEHPServiceImpl iEHPServiceImpl);

    private static native void logSwitchNative(long j, IEHPServiceImpl iEHPServiceImpl, int i);

    private static native boolean removeHdDataVersionObserverNative(long j, IEHPServiceImpl iEHPServiceImpl, long j2, IEHPHdDataVersionObserverImpl iEHPHdDataVersionObserverImpl);

    private static native boolean removeOutputObserverNative(long j, IEHPServiceImpl iEHPServiceImpl, long j2, IEHPOutputObserverImpl iEHPOutputObserverImpl);

    private static native void resetPredictiveTreeNative(long j, IEHPServiceImpl iEHPServiceImpl);

    private static native long sendAdasDataRequestNative(long j, IEHPServiceImpl iEHPServiceImpl, long j2, IGEhpAdasDataCallbackImpl iGEhpAdasDataCallbackImpl);

    private static native boolean setAutoUpdateRouteNative(long j, IEHPServiceImpl iEHPServiceImpl, boolean z);

    private static native boolean setConfigValueNative(long j, IEHPServiceImpl iEHPServiceImpl, int i, int i2);

    private static native boolean setSensorErrorNative(long j, IEHPServiceImpl iEHPServiceImpl, boolean z);

    private static native void unInitNative(long j, IEHPServiceImpl iEHPServiceImpl);

    private static native boolean updateCar2XEventsNative(long j, IEHPServiceImpl iEHPServiceImpl, ArrayList<EHPCar2XEvent> arrayList);

    private static native void updateNetworkStatusNative(long j, IEHPServiceImpl iEHPServiceImpl, int i);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IEHPServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IEHPServiceImpl) && getUID(this) == getUID((IEHPServiceImpl) obj);
    }

    private static long getUID(IEHPServiceImpl iEHPServiceImpl) {
        long cPtr = getCPtr(iEHPServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IEHPServiceImpl iEHPServiceImpl) {
        if (iEHPServiceImpl == null) {
            return 0L;
        }
        return iEHPServiceImpl.swigCPtr;
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

    public static String getEngineVersion() {
        return getEngineVersionNative();
    }

    public String getVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVersionNative(j, this);
    }

    public boolean init(EHPInitParam eHPInitParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, eHPInitParam);
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

    public void logSwitch(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        logSwitchNative(j, this, i);
    }

    public void updateNetworkStatus(@NetworkStatus.NetworkStatus1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateNetworkStatusNative(j, this, i);
    }

    public void resetPredictiveTree() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetPredictiveTreeNative(j, this);
    }

    public boolean addOutputObserver(IEHPOutputObserverImpl iEHPOutputObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addOutputObserverNative(j, this, IEHPOutputObserverImpl.getCPtr(iEHPOutputObserverImpl), iEHPOutputObserverImpl);
    }

    public boolean removeOutputObserver(IEHPOutputObserverImpl iEHPOutputObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeOutputObserverNative(j, this, IEHPOutputObserverImpl.getCPtr(iEHPOutputObserverImpl), iEHPOutputObserverImpl);
    }

    public boolean clearOutputObserver() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return clearOutputObserverNative(j, this);
    }

    public boolean addHdDataVersionObserver(IEHPHdDataVersionObserverImpl iEHPHdDataVersionObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addHdDataVersionObserverNative(j, this, IEHPHdDataVersionObserverImpl.getCPtr(iEHPHdDataVersionObserverImpl), iEHPHdDataVersionObserverImpl);
    }

    public boolean removeHdDataVersionObserver(IEHPHdDataVersionObserverImpl iEHPHdDataVersionObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeHdDataVersionObserverNative(j, this, IEHPHdDataVersionObserverImpl.getCPtr(iEHPHdDataVersionObserverImpl), iEHPHdDataVersionObserverImpl);
    }

    public void inputMsg(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        inputMsgNative(j, this, str);
    }

    public void inputInterDomainMessage(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        inputInterDomainMessageNative(j, this, str);
    }

    public boolean setAutoUpdateRoute(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setAutoUpdateRouteNative(j, this, z);
    }

    public boolean isAutoUpdateRoute() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isAutoUpdateRouteNative(j, this);
    }

    public long sendAdasDataRequest(IGEhpAdasDataCallbackImpl iGEhpAdasDataCallbackImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendAdasDataRequestNative(j, this, IGEhpAdasDataCallbackImpl.getCPtr(iGEhpAdasDataCallbackImpl), iGEhpAdasDataCallbackImpl);
    }

    public boolean abortAdasDataRequest(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return abortAdasDataRequestNative(j2, this, j);
    }

    public boolean abortAdasDataAllRequest() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return abortAdasDataAllRequestNative(j, this);
    }

    public boolean updateCar2XEvents(ArrayList<EHPCar2XEvent> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateCar2XEventsNative(j, this, arrayList);
    }

    public boolean setConfigValue(@EHPConfigType.EHPConfigType1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setConfigValueNative(j, this, i, i2);
    }

    public boolean setSensorError(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setSensorErrorNative(j, this, z);
    }
}
