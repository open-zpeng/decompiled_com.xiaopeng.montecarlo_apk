package com.autonavi.gbl.aosclient.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.BLAosServiceManager;
import com.autonavi.gbl.aosclient.model.BLAosCookie;
import com.autonavi.gbl.aosclient.model.BLAosInitParam;
import com.autonavi.gbl.aosclient.model.BLRequestBase;
import com.autonavi.gbl.aosclient.model.EForeBackGround;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServicelistResponseParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarTokenResponseParam;
import com.autonavi.gbl.aosclient.observer.impl.IBLAosCallBackImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.NetworkStatus;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = BLAosServiceManager.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class BLAosServiceManagerImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(BLAosServiceManagerImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int abortRequestNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl, long j2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void enableAlcFileUploadNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl, boolean z, String str);

    private static native long excuteRequestNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl, long j2, BLRequestBase bLRequestBase, long j3, IBLAosCallBackImpl iBLAosCallBackImpl);

    private static native void foreBackGroundNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl, int i);

    private static native GWsAuthcarServicelistResponseParam getAuthcarServerlistNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl);

    private static native GWsAuthcarTokenResponseParam getAuthcarTokenNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl);

    private static native BLAosCookie getCookieNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl);

    private static native boolean getRestEncryptDataNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl, String str, String[] strArr);

    private static native String getRestSignatureNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl, String str, String str2, String str3);

    private static native int getServiceIDNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl);

    private static native String getVersionNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl);

    private static native void initNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl, long j2, BLAosInitParam bLAosInitParam);

    private static native int isInitNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl);

    private static native void logSwitchNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl, int i);

    private static native void networkChangeNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl, int i);

    private static native void setCarInfoNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl, String str, String str2, String str3);

    private static native boolean setCookieNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl, long j2, BLAosCookie bLAosCookie);

    private static native void setLonLatNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl, int i, int i2);

    private static native void setScreenWithHeightNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl, short s, short s2);

    private static native void setUidNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl, String str);

    private static native void unInitNative(long j, BLAosServiceManagerImpl bLAosServiceManagerImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected BLAosServiceManagerImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof BLAosServiceManagerImpl) && getUID(this) == getUID((BLAosServiceManagerImpl) obj);
    }

    private static long getUID(BLAosServiceManagerImpl bLAosServiceManagerImpl) {
        long cPtr = getCPtr(bLAosServiceManagerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(BLAosServiceManagerImpl bLAosServiceManagerImpl) {
        if (bLAosServiceManagerImpl == null) {
            return 0L;
        }
        return bLAosServiceManagerImpl.swigCPtr;
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

    public BLAosServiceManagerImpl() {
        this(createNativeObj(), true);
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

    public void logSwitch(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        logSwitchNative(j, this, i);
    }

    public int getServiceID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getServiceIDNative(j, this);
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

    public void init(BLAosInitParam bLAosInitParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        initNative(j, this, 0L, bLAosInitParam);
    }

    public void networkChange(@NetworkStatus.NetworkStatus1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        networkChangeNative(j, this, i);
    }

    public void foreBackGround(@EForeBackGround.EForeBackGround1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        foreBackGroundNative(j, this, i);
    }

    public void enableAlcFileUpload(boolean z, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableAlcFileUploadNative(j, this, z, str);
    }

    public long excuteRequest(BLRequestBase bLRequestBase, IBLAosCallBackImpl iBLAosCallBackImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return excuteRequestNative(j, this, 0L, bLRequestBase, IBLAosCallBackImpl.getCPtr(iBLAosCallBackImpl), iBLAosCallBackImpl);
    }

    public int abortRequest(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return abortRequestNative(j2, this, j);
    }

    public BLAosCookie getCookie() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCookieNative(j, this);
    }

    public boolean setCookie(BLAosCookie bLAosCookie) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setCookieNative(j, this, 0L, bLAosCookie);
    }

    public GWsAuthcarServicelistResponseParam getAuthcarServerlist() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAuthcarServerlistNative(j, this);
    }

    public GWsAuthcarTokenResponseParam getAuthcarToken() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAuthcarTokenNative(j, this);
    }

    public void setUid(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setUidNative(j, this, str);
    }

    public void setScreenWithHeight(short s, short s2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setScreenWithHeightNative(j, this, s, s2);
    }

    public void setLonLat(int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setLonLatNative(j, this, i, i2);
    }

    public void setCarInfo(String str, String str2, String str3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarInfoNative(j, this, str, str2, str3);
    }

    public String getRestSignature(String str, String str2, String str3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRestSignatureNative(j, this, str, str2, str3);
    }

    public String getRestEncryptData(String str) {
        String[] strArr = new String[1];
        Boolean.valueOf(getRestEncryptData(str, strArr));
        return strArr[0];
    }

    private boolean getRestEncryptData(String str, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRestEncryptDataNative(j, this, str, strArr);
    }
}
