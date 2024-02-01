package com.autonavi.gbl.activation.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.activation.AuthenticationService;
import com.autonavi.gbl.activation.model.AuthenticationFunctionInfo;
import com.autonavi.gbl.activation.model.AuthenticationGoodsInfo;
import com.autonavi.gbl.activation.model.AuthenticationStatus;
import com.autonavi.gbl.activation.observer.impl.IAuthenticationObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = AuthenticationService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IAuthenticationServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IAuthenticationServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean addObserverNative(long j, IAuthenticationServiceImpl iAuthenticationServiceImpl, long j2, IAuthenticationObserverImpl iAuthenticationObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native void getFunctionInfoNative(long j, IAuthenticationServiceImpl iAuthenticationServiceImpl, ArrayList<AuthenticationFunctionInfo> arrayList);

    private static native void getGoodsInfoByIdNative(long j, IAuthenticationServiceImpl iAuthenticationServiceImpl, int i, ArrayList<AuthenticationGoodsInfo> arrayList);

    private static native void getGoodsInfoNative(long j, IAuthenticationServiceImpl iAuthenticationServiceImpl, ArrayList<AuthenticationGoodsInfo> arrayList);

    private static native int getPaymentStatusNative(long j, IAuthenticationServiceImpl iAuthenticationServiceImpl, int i);

    private static native String getVersionNative(long j, IAuthenticationServiceImpl iAuthenticationServiceImpl);

    private static native int initNative(long j, IAuthenticationServiceImpl iAuthenticationServiceImpl);

    private static native int isInitNative(long j, IAuthenticationServiceImpl iAuthenticationServiceImpl);

    private static native void logSwitchNative(long j, IAuthenticationServiceImpl iAuthenticationServiceImpl, int i);

    private static native boolean removeObserverNative(long j, IAuthenticationServiceImpl iAuthenticationServiceImpl, long j2, IAuthenticationObserverImpl iAuthenticationObserverImpl);

    private static native int syncRequestNative(long j, IAuthenticationServiceImpl iAuthenticationServiceImpl);

    private static native void unInitNative(long j, IAuthenticationServiceImpl iAuthenticationServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IAuthenticationServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IAuthenticationServiceImpl) && getUID(this) == getUID((IAuthenticationServiceImpl) obj);
    }

    private static long getUID(IAuthenticationServiceImpl iAuthenticationServiceImpl) {
        long cPtr = getCPtr(iAuthenticationServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IAuthenticationServiceImpl iAuthenticationServiceImpl) {
        if (iAuthenticationServiceImpl == null) {
            return 0L;
        }
        return iAuthenticationServiceImpl.swigCPtr;
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

    public int init() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    public String getVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVersionNative(j, this);
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

    public ArrayList<AuthenticationGoodsInfo> getGoodsInfo() {
        ArrayList<AuthenticationGoodsInfo> arrayList = new ArrayList<>();
        getGoodsInfo(arrayList);
        return arrayList;
    }

    private void getGoodsInfo(ArrayList<AuthenticationGoodsInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getGoodsInfoNative(j, this, arrayList);
    }

    public ArrayList<AuthenticationFunctionInfo> getFunctionInfo() {
        ArrayList<AuthenticationFunctionInfo> arrayList = new ArrayList<>();
        getFunctionInfo(arrayList);
        return arrayList;
    }

    private void getFunctionInfo(ArrayList<AuthenticationFunctionInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getFunctionInfoNative(j, this, arrayList);
    }

    public ArrayList<AuthenticationGoodsInfo> getGoodsInfoById(int i) {
        ArrayList<AuthenticationGoodsInfo> arrayList = new ArrayList<>();
        getGoodsInfoById(i, arrayList);
        return arrayList;
    }

    private void getGoodsInfoById(int i, ArrayList<AuthenticationGoodsInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getGoodsInfoByIdNative(j, this, i, arrayList);
    }

    @AuthenticationStatus.AuthenticationStatus1
    public int getPaymentStatus(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPaymentStatusNative(j, this, i);
    }

    public boolean addObserver(IAuthenticationObserverImpl iAuthenticationObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserverNative(j, this, IAuthenticationObserverImpl.getCPtr(iAuthenticationObserverImpl), iAuthenticationObserverImpl);
    }

    public boolean removeObserver(IAuthenticationObserverImpl iAuthenticationObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeObserverNative(j, this, IAuthenticationObserverImpl.getCPtr(iAuthenticationObserverImpl), iAuthenticationObserverImpl);
    }

    public int syncRequest() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return syncRequestNative(j, this);
    }
}
