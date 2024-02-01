package com.autonavi.gbl.user.account.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.account.AccountService;
import com.autonavi.gbl.user.account.model.AccountCheckRequest;
import com.autonavi.gbl.user.account.model.AccountLogoutRequest;
import com.autonavi.gbl.user.account.model.AccountProfile;
import com.autonavi.gbl.user.account.model.AccountProfileRequest;
import com.autonavi.gbl.user.account.model.AccountRegisterRequest;
import com.autonavi.gbl.user.account.model.AccountServiceParam;
import com.autonavi.gbl.user.account.model.AccountUnRegisterRequest;
import com.autonavi.gbl.user.account.model.AvatarRequest;
import com.autonavi.gbl.user.account.model.BindMobileRequest;
import com.autonavi.gbl.user.account.model.CarltdAuthInfoRequest;
import com.autonavi.gbl.user.account.model.CarltdBindRequest;
import com.autonavi.gbl.user.account.model.CarltdCheckBindRequest;
import com.autonavi.gbl.user.account.model.CarltdCheckTokenRequest;
import com.autonavi.gbl.user.account.model.CarltdLoginRequest;
import com.autonavi.gbl.user.account.model.CarltdQLoginRequest;
import com.autonavi.gbl.user.account.model.CarltdUnBindRequest;
import com.autonavi.gbl.user.account.model.MobileLoginRequest;
import com.autonavi.gbl.user.account.model.QRCodeLoginConfirmRequest;
import com.autonavi.gbl.user.account.model.QRCodeLoginRequest;
import com.autonavi.gbl.user.account.model.UnBindMobileRequest;
import com.autonavi.gbl.user.account.model.VerificationCodeRequest;
import com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = AccountService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IAccountServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IAccountServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int abortRequestNative(long j, IAccountServiceImpl iAccountServiceImpl, long j2);

    private static native int addObserverNative(long j, IAccountServiceImpl iAccountServiceImpl, long j2, IAccountServiceObserverImpl iAccountServiceObserverImpl);

    private static native int deleteUserDataNative(long j, IAccountServiceImpl iAccountServiceImpl);

    private static native void destroyNativeObj(long j);

    private static native int executeRequest10Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, AccountProfileRequest accountProfileRequest);

    private static native int executeRequest11Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, AvatarRequest avatarRequest);

    private static native int executeRequest12Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, CarltdCheckBindRequest carltdCheckBindRequest);

    private static native int executeRequest13Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, CarltdCheckTokenRequest carltdCheckTokenRequest);

    private static native int executeRequest14Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, CarltdBindRequest carltdBindRequest);

    private static native int executeRequest15Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, CarltdLoginRequest carltdLoginRequest);

    private static native int executeRequest16Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, CarltdQLoginRequest carltdQLoginRequest);

    private static native int executeRequest17Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, CarltdUnBindRequest carltdUnBindRequest);

    private static native int executeRequest18Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, CarltdAuthInfoRequest carltdAuthInfoRequest);

    private static native int executeRequest1Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, BindMobileRequest bindMobileRequest);

    private static native int executeRequest2Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, UnBindMobileRequest unBindMobileRequest);

    private static native int executeRequest3Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, VerificationCodeRequest verificationCodeRequest);

    private static native int executeRequest4Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, MobileLoginRequest mobileLoginRequest);

    private static native int executeRequest5Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, QRCodeLoginRequest qRCodeLoginRequest);

    private static native int executeRequest6Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, QRCodeLoginConfirmRequest qRCodeLoginConfirmRequest);

    private static native int executeRequest7Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, AccountLogoutRequest accountLogoutRequest);

    private static native int executeRequest8Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, AccountRegisterRequest accountRegisterRequest);

    private static native int executeRequest9Native(long j, IAccountServiceImpl iAccountServiceImpl, long j2, AccountUnRegisterRequest accountUnRegisterRequest);

    private static native int executeRequestNative(long j, IAccountServiceImpl iAccountServiceImpl, long j2, AccountCheckRequest accountCheckRequest);

    private static native boolean getCarLoginFlagNative(long j, IAccountServiceImpl iAccountServiceImpl);

    private static native int getUserDataNative(long j, IAccountServiceImpl iAccountServiceImpl, long j2, AccountProfile accountProfile);

    private static native String getVersionNative(long j, IAccountServiceImpl iAccountServiceImpl);

    private static native int initNative(long j, IAccountServiceImpl iAccountServiceImpl, long j2, AccountServiceParam accountServiceParam);

    private static native int isInitNative(long j, IAccountServiceImpl iAccountServiceImpl);

    private static native void logSwitchNative(long j, IAccountServiceImpl iAccountServiceImpl, int i);

    private static native void removeObserverNative(long j, IAccountServiceImpl iAccountServiceImpl, long j2, IAccountServiceObserverImpl iAccountServiceObserverImpl);

    private static native int saveUserDataNative(long j, IAccountServiceImpl iAccountServiceImpl, long j2, AccountProfile accountProfile);

    private static native void unInitNative(long j, IAccountServiceImpl iAccountServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IAccountServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IAccountServiceImpl) && getUID(this) == getUID((IAccountServiceImpl) obj);
    }

    private static long getUID(IAccountServiceImpl iAccountServiceImpl) {
        long cPtr = getCPtr(iAccountServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IAccountServiceImpl iAccountServiceImpl) {
        if (iAccountServiceImpl == null) {
            return 0L;
        }
        return iAccountServiceImpl.swigCPtr;
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

    public int init(AccountServiceParam accountServiceParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, accountServiceParam);
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

    public void logSwitch(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        logSwitchNative(j, this, i);
    }

    public int addObserver(IAccountServiceObserverImpl iAccountServiceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserverNative(j, this, IAccountServiceObserverImpl.getCPtr(iAccountServiceObserverImpl), iAccountServiceObserverImpl);
    }

    public void removeObserver(IAccountServiceObserverImpl iAccountServiceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeObserverNative(j, this, IAccountServiceObserverImpl.getCPtr(iAccountServiceObserverImpl), iAccountServiceObserverImpl);
    }

    public int executeRequest(AccountCheckRequest accountCheckRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequestNative(j, this, 0L, accountCheckRequest);
    }

    public int executeRequest(BindMobileRequest bindMobileRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest1Native(j, this, 0L, bindMobileRequest);
    }

    public int executeRequest(UnBindMobileRequest unBindMobileRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest2Native(j, this, 0L, unBindMobileRequest);
    }

    public int executeRequest(VerificationCodeRequest verificationCodeRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest3Native(j, this, 0L, verificationCodeRequest);
    }

    public int executeRequest(MobileLoginRequest mobileLoginRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest4Native(j, this, 0L, mobileLoginRequest);
    }

    public int executeRequest(QRCodeLoginRequest qRCodeLoginRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest5Native(j, this, 0L, qRCodeLoginRequest);
    }

    public int executeRequest(QRCodeLoginConfirmRequest qRCodeLoginConfirmRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest6Native(j, this, 0L, qRCodeLoginConfirmRequest);
    }

    public int executeRequest(AccountLogoutRequest accountLogoutRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest7Native(j, this, 0L, accountLogoutRequest);
    }

    public int executeRequest(AccountRegisterRequest accountRegisterRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest8Native(j, this, 0L, accountRegisterRequest);
    }

    public int executeRequest(AccountUnRegisterRequest accountUnRegisterRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest9Native(j, this, 0L, accountUnRegisterRequest);
    }

    public int executeRequest(AccountProfileRequest accountProfileRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest10Native(j, this, 0L, accountProfileRequest);
    }

    public int executeRequest(AvatarRequest avatarRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest11Native(j, this, 0L, avatarRequest);
    }

    public int executeRequest(CarltdCheckBindRequest carltdCheckBindRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest12Native(j, this, 0L, carltdCheckBindRequest);
    }

    public int executeRequest(CarltdCheckTokenRequest carltdCheckTokenRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest13Native(j, this, 0L, carltdCheckTokenRequest);
    }

    public int executeRequest(CarltdBindRequest carltdBindRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest14Native(j, this, 0L, carltdBindRequest);
    }

    public int executeRequest(CarltdLoginRequest carltdLoginRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest15Native(j, this, 0L, carltdLoginRequest);
    }

    public int executeRequest(CarltdQLoginRequest carltdQLoginRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest16Native(j, this, 0L, carltdQLoginRequest);
    }

    public int executeRequest(CarltdUnBindRequest carltdUnBindRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest17Native(j, this, 0L, carltdUnBindRequest);
    }

    public int executeRequest(CarltdAuthInfoRequest carltdAuthInfoRequest) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executeRequest18Native(j, this, 0L, carltdAuthInfoRequest);
    }

    public int abortRequest(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return abortRequestNative(j2, this, j);
    }

    public AccountProfile getUserData() {
        AccountProfile accountProfile = new AccountProfile();
        if (Integer.valueOf(getUserData(accountProfile)).intValue() == 0) {
            return accountProfile;
        }
        return null;
    }

    private int getUserData(AccountProfile accountProfile) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getUserDataNative(j, this, 0L, accountProfile);
    }

    public int deleteUserData() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return deleteUserDataNative(j, this);
    }

    public int saveUserData(AccountProfile accountProfile) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return saveUserDataNative(j, this, 0L, accountProfile);
    }

    public boolean getCarLoginFlag() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCarLoginFlagNative(j, this);
    }
}
