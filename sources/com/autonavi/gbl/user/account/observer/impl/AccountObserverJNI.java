package com.autonavi.gbl.user.account.observer.impl;

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
import com.autonavi.gbl.util.model.ErrorCode;
/* loaded from: classes2.dex */
public class AccountObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_0(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, AccountCheckResult accountCheckResult) {
        iAccountServiceObserverImpl.notify(i, i2, accountCheckResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_1(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, BindMobileResult bindMobileResult) {
        iAccountServiceObserverImpl.notify(i, i2, bindMobileResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_2(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, UnBindMobileResult unBindMobileResult) {
        iAccountServiceObserverImpl.notify(i, i2, unBindMobileResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_3(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, VerificationCodeResult verificationCodeResult) {
        iAccountServiceObserverImpl.notify(i, i2, verificationCodeResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_4(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, MobileLoginResult mobileLoginResult) {
        iAccountServiceObserverImpl.notify(i, i2, mobileLoginResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_5(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, QRCodeLoginResult qRCodeLoginResult) {
        iAccountServiceObserverImpl.notify(i, i2, qRCodeLoginResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_6(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, QRCodeLoginConfirmResult qRCodeLoginConfirmResult) {
        iAccountServiceObserverImpl.notify(i, i2, qRCodeLoginConfirmResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_7(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, AccountLogoutResult accountLogoutResult) {
        iAccountServiceObserverImpl.notify(i, i2, accountLogoutResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_8(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, AccountRegisterResult accountRegisterResult) {
        iAccountServiceObserverImpl.notify(i, i2, accountRegisterResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_9(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, AccountUnRegisterResult accountUnRegisterResult) {
        iAccountServiceObserverImpl.notify(i, i2, accountUnRegisterResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_10(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, AccountProfileResult accountProfileResult) {
        iAccountServiceObserverImpl.notify(i, i2, accountProfileResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_11(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, AvatarResult avatarResult) {
        iAccountServiceObserverImpl.notify(i, i2, avatarResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_12(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, CarltdCheckBindResult carltdCheckBindResult) {
        iAccountServiceObserverImpl.notify(i, i2, carltdCheckBindResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_13(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, CarltdCheckTokenResult carltdCheckTokenResult) {
        iAccountServiceObserverImpl.notify(i, i2, carltdCheckTokenResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_14(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, CarltdBindResult carltdBindResult) {
        iAccountServiceObserverImpl.notify(i, i2, carltdBindResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_15(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, CarltdLoginResult carltdLoginResult) {
        iAccountServiceObserverImpl.notify(i, i2, carltdLoginResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_16(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, CarltdQLoginResult carltdQLoginResult) {
        iAccountServiceObserverImpl.notify(i, i2, carltdQLoginResult);
    }

    public static void SwigDirector_IAccountServiceObserverImpl_notify__SWIG_17(IAccountServiceObserverImpl iAccountServiceObserverImpl, @ErrorCode.ErrorCode1 int i, int i2, CarltdUnBindResult carltdUnBindResult) {
        iAccountServiceObserverImpl.notify(i, i2, carltdUnBindResult);
    }
}
