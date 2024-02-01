package com.xiaopeng.montecarlo.navcore.account;

import androidx.annotation.NonNull;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.autonavi.gbl.user.account.AccountService;
import com.autonavi.gbl.user.account.model.AccountAosResult;
import com.autonavi.gbl.user.account.model.AccountCheckRequest;
import com.autonavi.gbl.user.account.model.AccountLogoutRequest;
import com.autonavi.gbl.user.account.model.AccountLogoutResult;
import com.autonavi.gbl.user.account.model.AccountProfile;
import com.autonavi.gbl.user.account.model.AccountProfileRequest;
import com.autonavi.gbl.user.account.model.AccountProfileResult;
import com.autonavi.gbl.user.account.model.AccountRegisterRequest;
import com.autonavi.gbl.user.account.model.AccountServiceParam;
import com.autonavi.gbl.user.account.model.AvatarRequest;
import com.autonavi.gbl.user.account.model.MobileLoginRequest;
import com.autonavi.gbl.user.account.model.QRCodeLoginConfirmRequest;
import com.autonavi.gbl.user.account.model.QRCodeLoginConfirmResult;
import com.autonavi.gbl.user.account.model.QRCodeLoginRequest;
import com.autonavi.gbl.user.account.model.QRCodeLoginResult;
import com.autonavi.gbl.user.account.model.VerificationCodeRequest;
import com.xiaopeng.montecarlo.navcore.event.AccountEvent;
import com.xiaopeng.montecarlo.root.account.AccountException;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class BLAccountServiceWrapper {
    private final PublishSubject<AccountEvent> mAccountEventPublishSubject = PublishSubject.create();
    private AccountService mAccountService;
    private static final BLAccountServiceWrapper sInstance = new BLAccountServiceWrapper();
    private static final L.Tag TAG = new L.Tag("blaccountser");

    private BLAccountServiceWrapper() {
    }

    @NonNull
    public static BLAccountServiceWrapper getInstance() {
        return sInstance;
    }

    public synchronized AccountService getAccountService() {
        if (this.mAccountService == null) {
            this.mAccountService = (AccountService) ServiceMgr.getServiceMgrInstance().getBLService(1);
            AccountServiceParam accountServiceParam = new AccountServiceParam();
            accountServiceParam.dataPath = RootUtil.SD_CARD_DIR_ACCOUNT_SERVICE_FILE_PATH;
            int init = this.mAccountService.init(accountServiceParam);
            this.mAccountService.addObserver(new DefaultAccountServiceObserver(this.mAccountEventPublishSubject));
            L.Tag tag = TAG;
            L.i(tag, "initAccountService: init result=" + init);
        }
        return this.mAccountService;
    }

    public int requestCheckAccountRegister(String str) {
        AccountCheckRequest accountCheckRequest = new AccountCheckRequest();
        accountCheckRequest.taskId = 1L;
        accountCheckRequest.mobileNum = str;
        return getAccountService().executeRequest(accountCheckRequest);
    }

    public int requestGetVerificationCode(String str) {
        VerificationCodeRequest verificationCodeRequest = new VerificationCodeRequest();
        verificationCodeRequest.targetValue = str;
        verificationCodeRequest.targetType = 2;
        verificationCodeRequest.codeType = 9;
        verificationCodeRequest.taskId = 2L;
        verificationCodeRequest.bindMode = true;
        verificationCodeRequest.skipNew = true;
        return getAccountService().executeRequest(verificationCodeRequest);
    }

    public int requestAccountRegister(String str, String str2) {
        AccountRegisterRequest accountRegisterRequest = new AccountRegisterRequest();
        accountRegisterRequest.code = str;
        accountRegisterRequest.mobileNum = str2;
        accountRegisterRequest.taskId = 3L;
        return getAccountService().executeRequest(accountRegisterRequest);
    }

    public int requestMobileLogin(String str, String str2) {
        MobileLoginRequest mobileLoginRequest = new MobileLoginRequest();
        mobileLoginRequest.code = str;
        mobileLoginRequest.mobileNum = str2;
        mobileLoginRequest.taskId = 4L;
        return getAccountService().executeRequest(mobileLoginRequest);
    }

    public int requestAccountProfile() {
        AccountProfileRequest accountProfileRequest = new AccountProfileRequest();
        accountProfileRequest.mode = -1L;
        return getAccountService().executeRequest(accountProfileRequest);
    }

    public int requestAvatar() {
        AvatarRequest avatarRequest = new AvatarRequest();
        avatarRequest.url = getAccountService().getUserData().avatar;
        return getAccountService().executeRequest(avatarRequest);
    }

    public String getUserId() {
        AccountProfile userData = getAccountService().getUserData();
        if (userData == null) {
            return null;
        }
        return userData.uid;
    }

    public void abortRequest(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bindmap abortRequest taskId = " + i);
        }
        getAccountService().abortRequest(i);
    }

    public Observable<AccountEvent> createGetQRCodeLoginRequest() {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.navcore.account.-$$Lambda$BLAccountServiceWrapper$UHUND2iTzO-wh1_q1r996aVSSHA
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                BLAccountServiceWrapper.this.lambda$createGetQRCodeLoginRequest$0$BLAccountServiceWrapper(observableEmitter);
            }
        });
    }

    public /* synthetic */ void lambda$createGetQRCodeLoginRequest$0$BLAccountServiceWrapper(final ObservableEmitter observableEmitter) throws Exception {
        int executeRequest = getAccountService().executeRequest(new QRCodeLoginRequest());
        L.Tag tag = TAG;
        L.i(tag, "createAccountProfileRequest response code:" + executeRequest);
        if (executeRequest != 0) {
            observableEmitter.onError(new AccountException(-1, "execute AccountProfileRequest fail error:" + executeRequest));
            return;
        }
        this.mAccountEventPublishSubject.subscribe(new DisposableObserver<AccountEvent>() { // from class: com.xiaopeng.montecarlo.navcore.account.BLAccountServiceWrapper.1
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(@NonNull Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(@NonNull AccountEvent accountEvent) {
                AccountAosResult accountAosResult = accountEvent.getAccountAosResult();
                if (accountAosResult == null) {
                    if (L.ENABLE) {
                        L.d(BLAccountServiceWrapper.TAG, "onAosAccountEvent accountAosResult is null");
                    }
                } else if (accountAosResult instanceof QRCodeLoginResult) {
                    observableEmitter.onNext(accountEvent);
                    dispose();
                }
            }
        });
    }

    public Observable<QRCodeLoginConfirmResult> createQRCodeLoginConfirmRequest(@NonNull final QRCodeLoginResult qRCodeLoginResult) {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.navcore.account.-$$Lambda$BLAccountServiceWrapper$TmMDdy4NaY1ijzmfIozNsBr4cWg
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                BLAccountServiceWrapper.this.lambda$createQRCodeLoginConfirmRequest$1$BLAccountServiceWrapper(qRCodeLoginResult, observableEmitter);
            }
        });
    }

    public /* synthetic */ void lambda$createQRCodeLoginConfirmRequest$1$BLAccountServiceWrapper(@NonNull QRCodeLoginResult qRCodeLoginResult, final ObservableEmitter observableEmitter) throws Exception {
        String str = qRCodeLoginResult.qrcode.id;
        QRCodeLoginConfirmRequest qRCodeLoginConfirmRequest = new QRCodeLoginConfirmRequest();
        qRCodeLoginConfirmRequest.qrcodeId = str;
        int executeRequest = getAccountService().executeRequest(qRCodeLoginConfirmRequest);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bindmap requestQRCodeLoginConfirm  taskid=" + qRCodeLoginConfirmRequest.taskId + "    -------response:" + executeRequest);
        }
        if (executeRequest != 0) {
            observableEmitter.onError(new AccountException(-1, "execute QRCodeLoginConfirmRequest fail error:" + executeRequest));
            return;
        }
        this.mAccountEventPublishSubject.subscribe(new BLAccountObserver() { // from class: com.xiaopeng.montecarlo.navcore.account.BLAccountServiceWrapper.2
            @Override // com.xiaopeng.montecarlo.navcore.account.BLAccountObserver
            public void onGetAccountResult(@NonNull AccountAosResult accountAosResult) {
                if (accountAosResult instanceof QRCodeLoginConfirmResult) {
                    L.i(BLAccountServiceWrapper.TAG, "execute QRCodeLoginConfirmRequest success! ");
                    observableEmitter.onNext((QRCodeLoginConfirmResult) accountAosResult);
                    dispose();
                }
            }
        });
    }

    public Observable<AccountProfileResult> createAccountProfileRequest() {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.navcore.account.-$$Lambda$BLAccountServiceWrapper$enc4JLyNg_4YV3f12asDuguofUc
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                BLAccountServiceWrapper.this.lambda$createAccountProfileRequest$2$BLAccountServiceWrapper(observableEmitter);
            }
        });
    }

    public /* synthetic */ void lambda$createAccountProfileRequest$2$BLAccountServiceWrapper(final ObservableEmitter observableEmitter) throws Exception {
        AccountProfileRequest accountProfileRequest = new AccountProfileRequest();
        accountProfileRequest.mode = -1L;
        int executeRequest = getAccountService().executeRequest(accountProfileRequest);
        L.Tag tag = TAG;
        L.i(tag, "createAccountProfileRequest response code:" + executeRequest);
        if (executeRequest != 0) {
            observableEmitter.onError(new RuntimeException("execute AccountProfileRequest fail error:" + executeRequest));
            return;
        }
        this.mAccountEventPublishSubject.subscribe(new BLAccountObserver() { // from class: com.xiaopeng.montecarlo.navcore.account.BLAccountServiceWrapper.3
            @Override // com.xiaopeng.montecarlo.navcore.account.BLAccountObserver
            public void onGetAccountResult(@io.reactivex.annotations.NonNull AccountAosResult accountAosResult) {
                if (accountAosResult instanceof AccountProfileResult) {
                    L.i(BLAccountServiceWrapper.TAG, "execute AccountProfileRequest success! ");
                    observableEmitter.onNext((AccountProfileResult) accountAosResult);
                    dispose();
                }
            }
        });
    }

    public Observable<Boolean> createLogoutRequest() {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.navcore.account.-$$Lambda$BLAccountServiceWrapper$fimmJ22y9cSt5q6EGqkJtFJFPsg
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                BLAccountServiceWrapper.this.lambda$createLogoutRequest$3$BLAccountServiceWrapper(observableEmitter);
            }
        });
    }

    public /* synthetic */ void lambda$createLogoutRequest$3$BLAccountServiceWrapper(final ObservableEmitter observableEmitter) throws Exception {
        int executeRequest = getAccountService().executeRequest(new AccountLogoutRequest());
        L.Tag tag = TAG;
        L.i(tag, "createLogoutRequest response code:" + executeRequest);
        if (executeRequest != 0) {
            observableEmitter.onNext(true);
        } else {
            this.mAccountEventPublishSubject.subscribe(new BLAccountObserver() { // from class: com.xiaopeng.montecarlo.navcore.account.BLAccountServiceWrapper.4
                @Override // com.xiaopeng.montecarlo.navcore.account.BLAccountObserver
                public void onGetAccountResult(@io.reactivex.annotations.NonNull AccountAosResult accountAosResult) {
                    if (accountAosResult instanceof AccountLogoutResult) {
                        L.Tag tag2 = BLAccountServiceWrapper.TAG;
                        L.i(tag2, "onGetAccountResult logout result code:" + accountAosResult.code);
                        if (accountAosResult.code == 1) {
                            observableEmitter.onNext(true);
                        } else {
                            observableEmitter.onNext(false);
                        }
                        dispose();
                    }
                }
            });
        }
    }
}
