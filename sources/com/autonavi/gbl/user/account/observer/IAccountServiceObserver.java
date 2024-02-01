package com.autonavi.gbl.user.account.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.user.account.model.AccountCheckResult;
import com.autonavi.gbl.user.account.model.AccountLogoutResult;
import com.autonavi.gbl.user.account.model.AccountProfileResult;
import com.autonavi.gbl.user.account.model.AccountRegisterResult;
import com.autonavi.gbl.user.account.model.AccountUnRegisterResult;
import com.autonavi.gbl.user.account.model.AvatarResult;
import com.autonavi.gbl.user.account.model.BindMobileResult;
import com.autonavi.gbl.user.account.model.CarltdAuthInfoResult;
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
import com.autonavi.gbl.user.router.AccountServiceObserverRouter;
@IntfAuto(target = AccountServiceObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IAccountServiceObserver {
    default void notify(int i, int i2, AccountCheckResult accountCheckResult) {
    }

    default void notify(int i, int i2, AccountLogoutResult accountLogoutResult) {
    }

    default void notify(int i, int i2, AccountProfileResult accountProfileResult) {
    }

    default void notify(int i, int i2, AccountRegisterResult accountRegisterResult) {
    }

    default void notify(int i, int i2, AccountUnRegisterResult accountUnRegisterResult) {
    }

    default void notify(int i, int i2, AvatarResult avatarResult) {
    }

    default void notify(int i, int i2, BindMobileResult bindMobileResult) {
    }

    default void notify(int i, int i2, CarltdAuthInfoResult carltdAuthInfoResult) {
    }

    default void notify(int i, int i2, CarltdBindResult carltdBindResult) {
    }

    default void notify(int i, int i2, CarltdCheckBindResult carltdCheckBindResult) {
    }

    default void notify(int i, int i2, CarltdCheckTokenResult carltdCheckTokenResult) {
    }

    default void notify(int i, int i2, CarltdLoginResult carltdLoginResult) {
    }

    default void notify(int i, int i2, CarltdQLoginResult carltdQLoginResult) {
    }

    default void notify(int i, int i2, CarltdUnBindResult carltdUnBindResult) {
    }

    default void notify(int i, int i2, MobileLoginResult mobileLoginResult) {
    }

    default void notify(int i, int i2, QRCodeLoginConfirmResult qRCodeLoginConfirmResult) {
    }

    default void notify(int i, int i2, QRCodeLoginResult qRCodeLoginResult) {
    }

    default void notify(int i, int i2, UnBindMobileResult unBindMobileResult) {
    }

    default void notify(int i, int i2, VerificationCodeResult verificationCodeResult) {
    }
}
