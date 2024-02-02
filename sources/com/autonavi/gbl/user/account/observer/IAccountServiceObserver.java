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
import com.autonavi.gbl.util.model.ErrorCode;
@IntfAuto(target = AccountServiceObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IAccountServiceObserver {
    void notify(@ErrorCode.ErrorCode1 int i, int i2, AccountCheckResult accountCheckResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, AccountLogoutResult accountLogoutResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, AccountProfileResult accountProfileResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, AccountRegisterResult accountRegisterResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, AccountUnRegisterResult accountUnRegisterResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, AvatarResult avatarResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, BindMobileResult bindMobileResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, CarltdBindResult carltdBindResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, CarltdCheckBindResult carltdCheckBindResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, CarltdCheckTokenResult carltdCheckTokenResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, CarltdLoginResult carltdLoginResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, CarltdQLoginResult carltdQLoginResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, CarltdUnBindResult carltdUnBindResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, MobileLoginResult mobileLoginResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, QRCodeLoginConfirmResult qRCodeLoginConfirmResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, QRCodeLoginResult qRCodeLoginResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, UnBindMobileResult unBindMobileResult);

    void notify(@ErrorCode.ErrorCode1 int i, int i2, VerificationCodeResult verificationCodeResult);
}
