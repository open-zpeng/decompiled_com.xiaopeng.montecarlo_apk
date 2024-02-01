package com.autonavi.gbl.user.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
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
import com.autonavi.gbl.user.account.observer.IAccountServiceObserver;
import com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl;
@IntfAuto(target = IAccountServiceObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class AccountServiceObserverRouter extends IAccountServiceObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(AccountServiceObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(AccountServiceObserverRouter.class);
    private TypeHelper mHelper;
    private IAccountServiceObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IAccountServiceObserver iAccountServiceObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IAccountServiceObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iAccountServiceObserver;
    }

    protected AccountServiceObserverRouter(String str, IAccountServiceObserver iAccountServiceObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iAccountServiceObserver);
    }

    protected AccountServiceObserverRouter(String str, IAccountServiceObserver iAccountServiceObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iAccountServiceObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, AccountCheckResult accountCheckResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, accountCheckResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, BindMobileResult bindMobileResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, bindMobileResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, UnBindMobileResult unBindMobileResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, unBindMobileResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, VerificationCodeResult verificationCodeResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, verificationCodeResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, MobileLoginResult mobileLoginResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, mobileLoginResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, QRCodeLoginResult qRCodeLoginResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, qRCodeLoginResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, QRCodeLoginConfirmResult qRCodeLoginConfirmResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, qRCodeLoginConfirmResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, AccountLogoutResult accountLogoutResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, accountLogoutResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, AccountRegisterResult accountRegisterResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, accountRegisterResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, AccountUnRegisterResult accountUnRegisterResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, accountUnRegisterResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, AccountProfileResult accountProfileResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, accountProfileResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, AvatarResult avatarResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, avatarResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, CarltdCheckBindResult carltdCheckBindResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, carltdCheckBindResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, CarltdCheckTokenResult carltdCheckTokenResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, carltdCheckTokenResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, CarltdBindResult carltdBindResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, carltdBindResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, CarltdLoginResult carltdLoginResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, carltdLoginResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, CarltdQLoginResult carltdQLoginResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, carltdQLoginResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, CarltdUnBindResult carltdUnBindResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, carltdUnBindResult);
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl
    public void notify(int i, int i2, CarltdAuthInfoResult carltdAuthInfoResult) {
        IAccountServiceObserver iAccountServiceObserver = this.mObserver;
        if (iAccountServiceObserver != null) {
            iAccountServiceObserver.notify(i, i2, carltdAuthInfoResult);
        }
    }
}
