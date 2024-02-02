package com.xiaopeng.montecarlo.navcore.account;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.xiaopeng.montecarlo.navcore.event.AccountEvent;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.account.AMapAccountLoginObservable;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryResult;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP;
import io.reactivex.subjects.PublishSubject;
import org.greenrobot.eventbus.EventBus;
/* loaded from: classes2.dex */
public class DefaultAccountServiceObserver implements IAccountServiceObserver {
    public static final int TASK_ID_REQUEST_ACCOUNT_REGISTER = 3;
    public static final int TASK_ID_REQUEST_CHECK_ACCOUNT_REGISTER = 1;
    public static final int TASK_ID_REQUEST_GET_VERIFICATION_CODE = 2;
    public static final int TASK_ID_REQUEST_GQR_CODE_LOGIN = 5;
    public static final int TASK_ID_REQUEST_MOBILE_LOGIN = 4;
    public static final int TASK_ID_REQUEST_QRCODE_LOGIN_CONFIRM = 6;
    private final PublishSubject<AccountEvent> mAccountEventPublishSubject;
    @Nullable
    private QRCodeLoginResult mQrCodeLoginResult;
    @NonNull
    L.Tag mTAG = new L.Tag("DefAccountSer");
    private int mQRCodeLoginTryAgain = 0;
    private String mLastProfile = "";

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(int i, int i2, AccountUnRegisterResult accountUnRegisterResult) {
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(int i, int i2, BindMobileResult bindMobileResult) {
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(int i, int i2, CarltdBindResult carltdBindResult) {
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(int i, int i2, CarltdCheckBindResult carltdCheckBindResult) {
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(int i, int i2, CarltdCheckTokenResult carltdCheckTokenResult) {
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(int i, int i2, CarltdLoginResult carltdLoginResult) {
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(int i, int i2, CarltdQLoginResult carltdQLoginResult) {
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(int i, int i2, CarltdUnBindResult carltdUnBindResult) {
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(int i, int i2, UnBindMobileResult unBindMobileResult) {
    }

    public DefaultAccountServiceObserver(@NonNull PublishSubject<AccountEvent> publishSubject) {
        this.mAccountEventPublishSubject = publishSubject;
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(@ErrorCode.ErrorCode1 int i, int i2, @Nullable AccountCheckResult accountCheckResult) {
        String json = GsonUtil.toJson(accountCheckResult);
        if (accountCheckResult != null && !TextUtils.isEmpty(accountCheckResult.result)) {
            Boolean.parseBoolean(accountCheckResult.result);
        }
        if (L.ENABLE) {
            L.Tag tag = this.mTAG;
            L.d(tag, "accountCheckResult errCode = [" + i + "], taskId = [" + i2 + "], accountCheckResult = [" + json + "]");
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(@ErrorCode.ErrorCode1 int i, int i2, @Nullable VerificationCodeResult verificationCodeResult) {
        String json = GsonUtil.toJson(verificationCodeResult);
        if (verificationCodeResult != null && !TextUtils.isEmpty(verificationCodeResult.result)) {
            Boolean.parseBoolean(verificationCodeResult.result);
        }
        EventBus.getDefault().post(new AccountEvent(verificationCodeResult));
        if (L.ENABLE) {
            L.Tag tag = this.mTAG;
            L.d(tag, "verificationCodeResult errCode = [" + i + "], taskId = [" + i2 + "], verificationCodeResult = [" + json + "]");
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(@ErrorCode.ErrorCode1 int i, int i2, @Nullable MobileLoginResult mobileLoginResult) {
        if (mobileLoginResult == null) {
            if (L.ENABLE) {
                L.d(this.mTAG, "mobileLoginResult is null");
                return;
            }
            return;
        }
        String json = GsonUtil.toJson(mobileLoginResult);
        if (!TextUtils.isEmpty(mobileLoginResult.result)) {
            Boolean.parseBoolean(mobileLoginResult.result);
        }
        if (L.ENABLE) {
            L.Tag tag = this.mTAG;
            L.d(tag, "mobileLoginResult errCode = [" + i + "], taskId = [" + i2 + "], result = [" + json + "]");
        }
        if (mobileLoginResult.code == 1 && L.ENABLE) {
            L.d(this.mTAG, "success login");
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(@ErrorCode.ErrorCode1 int i, int i2, @Nullable final QRCodeLoginResult qRCodeLoginResult) {
        final AccountEvent accountEvent = new AccountEvent(qRCodeLoginResult);
        if (qRCodeLoginResult == null) {
            if (L.ENABLE) {
                L.d(this.mTAG, "QRCodeLoginResult is null");
            }
            EventBus.getDefault().post(accountEvent);
            this.mAccountEventPublishSubject.onNext(accountEvent);
        } else if (qRCodeLoginResult.code == 1) {
            byte[] bArr = qRCodeLoginResult.qrcode.data.buffer;
            BitmapFactoryXP.decodeByteArrayAsync(bArr, 0, bArr.length, new BitmapFactoryXP.IDecodeResultListener() { // from class: com.xiaopeng.montecarlo.navcore.account.DefaultAccountServiceObserver.1
                @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
                public void onComplete() {
                }

                @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
                public void onDecodeSuccess(BitmapFactoryResult bitmapFactoryResult) {
                    if (bitmapFactoryResult.mBitmap == null || bitmapFactoryResult.mBitmap.isRecycled()) {
                        L.w(DefaultAccountServiceObserver.this.mTAG, "r.mBitmap error");
                        return;
                    }
                    accountEvent.setBitmap(bitmapFactoryResult.mBitmap);
                    DefaultAccountServiceObserver.this.mQrCodeLoginResult = qRCodeLoginResult;
                    EventBus.getDefault().post(accountEvent);
                    DefaultAccountServiceObserver.this.mAccountEventPublishSubject.onNext(accountEvent);
                }
            });
        } else {
            EventBus.getDefault().post(accountEvent);
            this.mAccountEventPublishSubject.onNext(accountEvent);
        }
    }

    @Nullable
    private Bitmap getPicFromBytes(@Nullable byte[] bArr, @Nullable BitmapFactory.Options options) {
        if (bArr != null) {
            if (options != null) {
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            }
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(@ErrorCode.ErrorCode1 int i, int i2, @Nullable QRCodeLoginConfirmResult qRCodeLoginConfirmResult) {
        if (qRCodeLoginConfirmResult == null) {
            if (L.ENABLE) {
                L.d(this.mTAG, "QRCodeLoginConfirmResult is null");
                return;
            }
            return;
        }
        String json = GsonUtil.toJson(qRCodeLoginConfirmResult);
        AccountEvent accountEvent = new AccountEvent(qRCodeLoginConfirmResult);
        if (L.ENABLE) {
            L.d(this.mTAG, "bindmap QRCodeLoginConfirmResult errCode = [" + i + "], taskId = [" + i2 + "], result = [" + json + "]");
        }
        if (i == 800) {
            this.mQRCodeLoginTryAgain = 0;
            if (L.ENABLE) {
                L.d(this.mTAG, "QRCode login success");
            }
            accountEvent.setStatus(1);
        } else {
            accountEvent.setStatus(2);
            this.mQRCodeLoginTryAgain++;
            if (L.ENABLE) {
                L.d(this.mTAG, " QRCode login try again times=" + this.mQRCodeLoginTryAgain);
            }
        }
        EventBus.getDefault().post(accountEvent);
        this.mAccountEventPublishSubject.onNext(accountEvent);
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(@ErrorCode.ErrorCode1 int i, int i2, AccountLogoutResult accountLogoutResult) {
        String json = GsonUtil.toJson(accountLogoutResult);
        if (L.ENABLE) {
            L.Tag tag = this.mTAG;
            L.d(tag, "bindmap accountLogoutResult errCode = [" + i + "], taskId = [" + i2 + "], accountLogoutResult = [" + json + "]");
        }
        if (accountLogoutResult != null && accountLogoutResult.code == 1) {
            this.mLastProfile = "";
            SettingWrapper.setAmapLoginStatus(false);
        }
        AccountEvent accountEvent = new AccountEvent(accountLogoutResult);
        EventBus.getDefault().post(accountEvent);
        this.mAccountEventPublishSubject.onNext(accountEvent);
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(@ErrorCode.ErrorCode1 int i, int i2, AccountRegisterResult accountRegisterResult) {
        String json = GsonUtil.toJson(accountRegisterResult);
        if (L.ENABLE) {
            L.Tag tag = this.mTAG;
            L.d(tag, "accountRegisterResult errCode = [" + i + "], taskId = [" + i2 + "], accountRegisterResult = [" + json + "]");
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(@ErrorCode.ErrorCode1 int i, int i2, AccountProfileResult accountProfileResult) {
        String json = GsonUtil.toJson(accountProfileResult);
        if (accountProfileResult != null && accountProfileResult.code == 1) {
            String json2 = GsonUtil.toJson(accountProfileResult.profile);
            if (accountProfileResult.profile != null && !this.mLastProfile.equals(json2)) {
                this.mLastProfile = json2;
                if (!TextUtils.isEmpty(json2)) {
                    L.Tag tag = this.mTAG;
                    L.i(tag, "notify profile json = " + json2);
                    SettingWrapper.setBlAccountProfile(json2);
                    SettingWrapper.setAmapLoginStatus(true);
                    SettingWrapper.saveBindAMapStatus(true);
                    XPAccountServiceWrapper.getInstance().invokeAmapQuickLoginCallback();
                }
            }
            AMapAccountLoginObservable.getInstance().changed();
            AMapAccountLoginObservable.getInstance().notifyObservers();
        }
        AccountEvent accountEvent = new AccountEvent(accountProfileResult);
        EventBus.getDefault().post(accountEvent);
        this.mAccountEventPublishSubject.onNext(accountEvent);
        if (L.ENABLE) {
            L.Tag tag2 = this.mTAG;
            L.d(tag2, "accountProfileResult errCode = [" + i + "], taskId = [" + i2 + "], accountProfileResult = [" + json + "]");
        }
    }

    @Override // com.autonavi.gbl.user.account.observer.IAccountServiceObserver
    public void notify(@ErrorCode.ErrorCode1 int i, int i2, AvatarResult avatarResult) {
        String json = GsonUtil.toJson(avatarResult);
        if (L.ENABLE) {
            L.Tag tag = this.mTAG;
            L.d(tag, "avatarResult errCode = [" + i + "], taskId = [" + i2 + "], avatarResult = [" + json + "]");
        }
    }
}
