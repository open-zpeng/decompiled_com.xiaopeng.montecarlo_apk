package com.autonavi.gbl.user.account.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.user.account.model.AccountCheckResult;
import com.autonavi.gbl.user.account.model.AccountLogoutResult;
import com.autonavi.gbl.user.account.model.AccountProfileResult;
import com.autonavi.gbl.user.account.model.AccountRegisterResult;
import com.autonavi.gbl.user.account.model.AccountUnRegisterResult;
import com.autonavi.gbl.user.account.model.AvatarResult;
import com.autonavi.gbl.user.account.model.BindMobileResult;
import com.autonavi.gbl.user.account.model.CarltdBindResult;
import com.autonavi.gbl.user.account.model.CarltdCheckBindResult;
import com.autonavi.gbl.user.account.model.CarltdCheckTokenResult;
import com.autonavi.gbl.user.account.model.CarltdLoginResult;
import com.autonavi.gbl.user.account.model.CarltdQLoginResult;
import com.autonavi.gbl.user.account.model.CarltdUnBindResult;
import com.autonavi.gbl.user.account.model.MobileLoginResult;
import com.autonavi.gbl.user.account.model.QRCodeLoginConfirmResult;
import com.autonavi.gbl.user.account.model.QRCodeLoginResult;
import com.autonavi.gbl.user.account.model.UnBindMobileResult;
import com.autonavi.gbl.user.account.model.VerificationCodeResult;
import com.autonavi.gbl.user.account.observer.IAccountServiceObserver;
import com.autonavi.gbl.util.model.ErrorCode;
@IntfAuto(target = IAccountServiceObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IAccountServiceObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IAccountServiceObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IAccountServiceObserverImpl_change_ownership(IAccountServiceObserverImpl iAccountServiceObserverImpl, long j, boolean z);

    private static native void IAccountServiceObserverImpl_director_connect(IAccountServiceObserverImpl iAccountServiceObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void notify10Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, AccountProfileResult accountProfileResult);

    private static native void notify11Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, AvatarResult avatarResult);

    private static native void notify12Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, CarltdCheckBindResult carltdCheckBindResult);

    private static native void notify13Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, CarltdCheckTokenResult carltdCheckTokenResult);

    private static native void notify14Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, CarltdBindResult carltdBindResult);

    private static native void notify15Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, CarltdLoginResult carltdLoginResult);

    private static native void notify16Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, CarltdQLoginResult carltdQLoginResult);

    private static native void notify17Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, CarltdUnBindResult carltdUnBindResult);

    private static native void notify1Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, BindMobileResult bindMobileResult);

    private static native void notify2Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, UnBindMobileResult unBindMobileResult);

    private static native void notify3Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, VerificationCodeResult verificationCodeResult);

    private static native void notify4Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, MobileLoginResult mobileLoginResult);

    private static native void notify5Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, QRCodeLoginResult qRCodeLoginResult);

    private static native void notify6Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, QRCodeLoginConfirmResult qRCodeLoginConfirmResult);

    private static native void notify7Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, AccountLogoutResult accountLogoutResult);

    private static native void notify8Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, AccountRegisterResult accountRegisterResult);

    private static native void notify9Native(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, AccountUnRegisterResult accountUnRegisterResult);

    private static native void notifyNative(long j, IAccountServiceObserverImpl iAccountServiceObserverImpl, int i, int i2, long j2, AccountCheckResult accountCheckResult);

    public IAccountServiceObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IAccountServiceObserverImpl) && getUID(this) == getUID((IAccountServiceObserverImpl) obj);
    }

    private static long getUID(IAccountServiceObserverImpl iAccountServiceObserverImpl) {
        long cPtr = getCPtr(iAccountServiceObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IAccountServiceObserverImpl iAccountServiceObserverImpl) {
        if (iAccountServiceObserverImpl == null) {
            return 0L;
        }
        return iAccountServiceObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
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
        IAccountServiceObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IAccountServiceObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, AccountCheckResult accountCheckResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyNative(j, this, i, i2, 0L, accountCheckResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, BindMobileResult bindMobileResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify1Native(j, this, i, i2, 0L, bindMobileResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, UnBindMobileResult unBindMobileResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify2Native(j, this, i, i2, 0L, unBindMobileResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, VerificationCodeResult verificationCodeResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify3Native(j, this, i, i2, 0L, verificationCodeResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, MobileLoginResult mobileLoginResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify4Native(j, this, i, i2, 0L, mobileLoginResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, QRCodeLoginResult qRCodeLoginResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify5Native(j, this, i, i2, 0L, qRCodeLoginResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, QRCodeLoginConfirmResult qRCodeLoginConfirmResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify6Native(j, this, i, i2, 0L, qRCodeLoginConfirmResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, AccountLogoutResult accountLogoutResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify7Native(j, this, i, i2, 0L, accountLogoutResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, AccountRegisterResult accountRegisterResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify8Native(j, this, i, i2, 0L, accountRegisterResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, AccountUnRegisterResult accountUnRegisterResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify9Native(j, this, i, i2, 0L, accountUnRegisterResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, AccountProfileResult accountProfileResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify10Native(j, this, i, i2, 0L, accountProfileResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, AvatarResult avatarResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify11Native(j, this, i, i2, 0L, avatarResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, CarltdCheckBindResult carltdCheckBindResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify12Native(j, this, i, i2, 0L, carltdCheckBindResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, CarltdCheckTokenResult carltdCheckTokenResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify13Native(j, this, i, i2, 0L, carltdCheckTokenResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, CarltdBindResult carltdBindResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify14Native(j, this, i, i2, 0L, carltdBindResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, CarltdLoginResult carltdLoginResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify15Native(j, this, i, i2, 0L, carltdLoginResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, CarltdQLoginResult carltdQLoginResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify16Native(j, this, i, i2, 0L, carltdQLoginResult);
    }

    public void notify(@ErrorCode.ErrorCode1 int i, int i2, CarltdUnBindResult carltdUnBindResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify17Native(j, this, i, i2, 0L, carltdUnBindResult);
    }

    public IAccountServiceObserverImpl() {
        this(createNativeObj(), true);
        AccountObserverJNI.swig_jni_init();
        IAccountServiceObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
