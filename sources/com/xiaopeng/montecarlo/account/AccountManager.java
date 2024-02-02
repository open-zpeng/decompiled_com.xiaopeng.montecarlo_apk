package com.xiaopeng.montecarlo.account;

import android.app.Application;
import android.os.Looper;
import android.text.TextUtils;
import com.autonavi.gbl.aosclient.model.GCarLtdCheckTokenResponseParam;
import com.autonavi.gbl.user.account.model.AccountProfileResult;
import com.autonavi.gbl.user.account.model.QRCodeLoginResult;
import com.xiaopeng.montecarlo.InitializerManager;
import com.xiaopeng.montecarlo.account.sync.AccIncreDataSupervision;
import com.xiaopeng.montecarlo.account.sync.AccountSessionManager;
import com.xiaopeng.montecarlo.account.sync.FavoriteSyncUtil;
import com.xiaopeng.montecarlo.account.sync.IAccountSync;
import com.xiaopeng.montecarlo.account.sync.IncrementDataManager;
import com.xiaopeng.montecarlo.account.sync.SettingOperation;
import com.xiaopeng.montecarlo.account.sync.datahelper.BlAccountDataSyncHelper;
import com.xiaopeng.montecarlo.account.sync.datahelper.BlFavDataManager;
import com.xiaopeng.montecarlo.account.sync.datahelper.XpFavDataManager;
import com.xiaopeng.montecarlo.account.sync.scheduler.BlAccountDataSyncScheduler;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.account.AccountContext;
import com.xiaopeng.montecarlo.navcore.account.AccountStore;
import com.xiaopeng.montecarlo.navcore.account.BLAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.account.XpUserData;
import com.xiaopeng.montecarlo.navcore.amap.LinkAMapWrapper;
import com.xiaopeng.montecarlo.navcore.amap.base.LinkAMapError;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataResponseCode;
import com.xiaopeng.montecarlo.navcore.event.AccountEvent;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviGetBoundAccountsResponse;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.account.AccountException;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.httpclient.constants.HttpConst;
import com.xiaopeng.montecarlo.root.network.IXPNetworkListener;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.mapscene.MapStateObserver;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecorator;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class AccountManager {
    private static final int ACCOUNT_INIT_FAILED = 3;
    private static final int ACCOUNT_INIT_IN_PROCESS = 1;
    private static final int ACCOUNT_INIT_SUCCEED = 2;
    private static final int ACCOUNT_NOT_READY_TO_INIT = 0;
    private static final long BL_COOKIE_REFRESH_INTERVAL = 82800000;
    private static final L.Tag TAG = new L.Tag("AccountManager");
    private static final AccountManager sInstance = new AccountManager();
    private AccountSessionManager mAccountSessionManager;
    private BlAccountDataSyncScheduler mBlAccountDataSyncScheduler;
    private XpUserData mCurrentXpUserData;
    private PublishSubject<Boolean> mInitDispatcher;
    private AccIncreDataSupervision mSupervision;
    private final IThreadOperation mThreadOperation = new IThreadOperation() { // from class: com.xiaopeng.montecarlo.account.AccountManager.1
        @Override // com.xiaopeng.montecarlo.account.IThreadOperation
        public void interruptThread() {
            WorkThreadUtil.getInstance().getAccountSyncThread().interruptThread(0);
        }

        @Override // com.xiaopeng.montecarlo.account.IThreadOperation
        public boolean isThreadInterrupted() {
            return WorkThreadUtil.getInstance().getAccountSyncThread().isThreadInterrupted(0);
        }

        @Override // com.xiaopeng.montecarlo.account.IThreadOperation
        public void resumeThread() {
            WorkThreadUtil.getInstance().getAccountSyncThread().resumeThread(0);
        }

        @Override // com.xiaopeng.montecarlo.account.IThreadOperation
        public Looper getLooper() {
            return WorkThreadUtil.getInstance().getAccountSyncThread().getLooper();
        }
    };
    private final LinkAMapWrapper mLinkAMapWrapper = new LinkAMapWrapper();
    private final CompositeRxAction mOperationsHolder = new CompositeRxAction();
    private final PublishSubject<Boolean> mPublishSubject = PublishSubject.create();
    private volatile int mAccountInitState = 0;
    private final Observer mXPAccountChangeObserver = new Observer() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$FpcmqOHoQXoDTOfUz--osVHEUOI
        @Override // java.util.Observer
        public final void update(Observable observable, Object obj) {
            AccountManager.this.lambda$new$0$AccountManager(observable, obj);
        }
    };
    private final IXPNetworkListener mIXPNetworkListener = new IXPNetworkListener() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$v0A7HpvU1XwWQWKIzluhl5TKrio
        @Override // com.xiaopeng.montecarlo.root.network.IXPNetworkListener
        public final void onNetworkChanged(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
            AccountManager.this.lambda$new$1$AccountManager(xPNetworkType, z);
        }
    };
    private final CarServiceManager.IXPCarStateListener mCarStateListener = new CarServiceManager.IXPCarStateListener() { // from class: com.xiaopeng.montecarlo.account.AccountManager.2
        @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
        public void onIgStatusChange(int i) {
            if (i == 1 && AccountManager.this.isAccountInitFinished() && SettingWrapper.getBindAMapStatus() && !AccountStore.getInstance().isCurrentXpLoginAMap()) {
                L.i(AccountManager.TAG, "onPmStatusChange current xp is amap account,but has not login amap!");
                AccountStore.getInstance().setAMapAccountLogout();
                AccountManager.this.startAccountInit();
            }
        }
    };

    public AccIncreDataSupervision getSupervision() {
        return this.mSupervision;
    }

    public /* synthetic */ void lambda$new$0$AccountManager(Observable observable, Object obj) {
        if (obj instanceof UserInfo) {
            UserInfo userInfo = (UserInfo) obj;
            UserInfo.InfoType infoType = userInfo.getInfoType();
            UserInfo.UserType userType = userInfo.getUserType();
            L.Tag tag = TAG;
            L.i(tag, "mXPAccountChangeObserver update infoType = " + infoType + ", userType = " + userType);
            if (infoType == UserInfo.InfoType.CHANGED) {
                SettingStatUtil.sendStatDataMsgLoginXPAccount(UserInfo.UserType.TEMP != userType);
                this.mCurrentXpUserData = AccountStore.getInstance().getXpAccountInfo(userInfo.getUserId());
                this.mCurrentXpUserData.setSid("");
                this.mCurrentXpUserData.setOpenId("");
                AccountStore.getInstance().resetCurrentXpAMapInfo();
                AccountStore.getInstance().resetXpAccountInfo();
                L.i(TAG, "bindmap change account start~");
                startAccountInit();
                SettingOperation.initAccountSettingState();
            }
        }
    }

    public /* synthetic */ void lambda$new$1$AccountManager(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "bindmap mIXPNetworkListener onNetworkChanaged isConnect=" + z + ",mAccountInitState:" + this.mAccountInitState);
        if (z) {
            getInitDispatcher().onNext(true);
        }
    }

    private AccountManager() {
    }

    public static AccountManager getInstance() {
        return sInstance;
    }

    public void init(Application application) {
        XpFavDataManager.getInstance().init(application);
        BlFavDataManager.getInstance().init(application);
        this.mBlAccountDataSyncScheduler = new BlAccountDataSyncScheduler(this.mThreadOperation);
        this.mBlAccountDataSyncScheduler.setBlAccountDataSyncHelper(new BlAccountDataSyncHelper());
        this.mSupervision = new AccIncreDataSupervision();
        this.mSupervision.init();
        XPAccountServiceWrapper.getInstance().initAccount(application);
        this.mAccountSessionManager = new AccountSessionManager();
        this.mAccountSessionManager.initAccountSessionManager(this.mThreadOperation, this.mBlAccountDataSyncScheduler);
        this.mCurrentXpUserData = AccountStore.getInstance().getCurrentXpAccountInfo();
        AccountObservable.getInstance().addObserver(this.mXPAccountChangeObserver);
        XPNetworkManager.INSTANCE.addNetworkListener(this.mIXPNetworkListener);
        CarServiceManager.getInstance().addCarStateListener(this.mCarStateListener);
        L.i(TAG, "AccountManager init finished");
    }

    public void unInit() {
        XPAccountServiceWrapper.getInstance().unInitAccount();
        this.mBlAccountDataSyncScheduler.close();
        this.mAccountSessionManager.release();
        this.mSupervision.unInit();
        IncrementDataManager.getInstance().release();
        AccountObservable.getInstance().deleteObserver(this.mXPAccountChangeObserver);
        XPNetworkManager.INSTANCE.removeNetworkListener(this.mIXPNetworkListener);
        CarServiceManager.getInstance().removeCarStateListener(this.mCarStateListener);
        PublishSubject<Boolean> publishSubject = this.mInitDispatcher;
        if (publishSubject != null) {
            publishSubject.onComplete();
            this.mInitDispatcher = null;
        }
    }

    public void setMapDelegate(IMapDelegate iMapDelegate) {
        AccountContext.getInstance().setMapDelegate(iMapDelegate);
    }

    public void setMainContext(MainContext mainContext) {
        XPAccountServiceWrapper.getInstance().setContextInterface(mainContext);
    }

    public IAccountSync getAccountSyncSession() {
        return this.mAccountSessionManager.getCurrentSession();
    }

    private synchronized PublishSubject<Boolean> getInitDispatcher() {
        if (this.mInitDispatcher == null) {
            this.mInitDispatcher = PublishSubject.create();
            this.mInitDispatcher.debounce(1L, TimeUnit.SECONDS).subscribe(new DisposableObserver<Boolean>() { // from class: com.xiaopeng.montecarlo.account.AccountManager.3
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(@NonNull Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(@NonNull Boolean bool) {
                    if (AccountManager.this.mAccountInitState == 0 || AccountManager.this.mAccountInitState == 2) {
                        return;
                    }
                    AccountManager.this.startAccountInit();
                }
            });
        }
        return this.mInitDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAccountInitFinished() {
        return this.mAccountInitState == 3 || this.mAccountInitState == 2;
    }

    public void registerAMapAccountUnbindObserver(io.reactivex.Observer<Boolean> observer) {
        this.mPublishSubject.subscribeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void setAMapLogin() {
        if (this.mAccountSessionManager != null) {
            L.i(TAG, "bindmap setAMapLogin~~");
            this.mAccountSessionManager.initBlScheduler();
        }
    }

    public synchronized void startAccountInit() {
        if (InitializerManager.getInstance().isBLInitialized() && this.mCurrentXpUserData != null) {
            this.mOperationsHolder.unSubscribe();
            this.mAccountInitState = 1;
            String userId = XPAccountServiceWrapper.getInstance().getUserId();
            if (!"-1".equals(userId) && !TextUtils.equals(SettingWrapper.getTargetAccountUserId(), userId)) {
                AccountStore.getInstance().resetXpAccountInfo();
                AccountStore.getInstance().resetCurrentXpAMapInfo();
            }
            String lastAccountSid = SettingWrapper.getLastAccountSid();
            String lastAccountOpenId = SettingWrapper.getLastAccountOpenId();
            String accountOpenId = SettingWrapper.getAccountOpenId();
            String accountSid = SettingWrapper.getAccountSid();
            L.Tag tag = TAG;
            L.i(tag, "**** startAccountInit ***** xpUid=" + userId + "| lastOpenId=" + lastAccountOpenId + "| openId=" + accountOpenId + "| lastSid=" + lastAccountSid + "| sid=" + accountSid);
            this.mCurrentXpUserData.setOpenId(accountOpenId);
            this.mCurrentXpUserData.setSid(accountSid);
            this.mOperationsHolder.addSubscription(this.mLinkAMapWrapper.createXpLogoutObservable(lastAccountSid, lastAccountOpenId, accountOpenId).compose(applyRetryWithNetError()).onErrorResumeNext(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$SfaniOv_MmG6O_rtOuxqVN69nl0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource just;
                    Throwable th = (Throwable) obj;
                    just = io.reactivex.Observable.just(true);
                    return just;
                }
            }).flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$UdkXKZz3e-I4dqKfoebek-VDO34
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return AccountManager.this.lambda$startAccountInit$4$AccountManager((Boolean) obj);
                }
            }), new DisposableObserver<Boolean>() { // from class: com.xiaopeng.montecarlo.account.AccountManager.4
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(@NonNull Boolean bool) {
                    L.i(AccountManager.TAG, "***  AccountInit finished ***  ");
                    AccountManager.this.mAccountInitState = 2;
                    dispose();
                }

                @Override // io.reactivex.Observer
                public void onError(@NonNull Throwable th) {
                    L.Tag tag2 = AccountManager.TAG;
                    L.e(tag2, "*** AccountInit failed:" + th);
                    if (!(th instanceof AccountException) || !AccountDataResponseCode.isNeedReLogin(((AccountException) th).getCode())) {
                        AccountManager.this.mAccountInitState = 3;
                        return;
                    }
                    AccountStore.getInstance().clearCurrentXpAccountInfo();
                    AccountManager.this.startAccountInit();
                }
            });
            return;
        }
        L.i(TAG, "****  startAccountInit bl is not initialized!");
    }

    public /* synthetic */ ObservableSource lambda$startAccountInit$4$AccountManager(Boolean bool) throws Exception {
        AccountStore.getInstance().clearLastXpAccountInfo();
        if (AccountStore.getInstance().isLastAMapAccountLogin()) {
            return createLogoutAMapAccountObservable().compose(applyRetry()).flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$dz5Lr0FM9XSoK950ya_K5s9-m9E
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return AccountManager.this.lambda$null$3$AccountManager((Boolean) obj);
                }
            });
        }
        L.i(TAG, "no last login AMap Account info ,skip logout amap!");
        return createLoginRelatedProcess(this.mCurrentXpUserData);
    }

    public /* synthetic */ ObservableSource lambda$null$3$AccountManager(Boolean bool) throws Exception {
        return createLoginRelatedProcess(this.mCurrentXpUserData);
    }

    private io.reactivex.Observable<Boolean> createLoginRelatedProcess(@NonNull final XpUserData xpUserData) {
        io.reactivex.Observable flatMap;
        if (!XPAccountServiceWrapper.getInstance().isTempType()) {
            if (!TextUtils.isEmpty(xpUserData.getOpenId()) && !TextUtils.isEmpty(xpUserData.getSid())) {
                L.i(TAG, "current xp account is login ,skip login , start createCheckBindAMapStatus ");
                flatMap = this.mLinkAMapWrapper.checkBindAMapStatusFromXP(xpUserData).compose(applyRetry());
            } else {
                flatMap = this.mLinkAMapWrapper.createXpLoginObservable().compose(applyRetry()).flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$qaK47_pa8ls5nrK5uIM2OpQ7hGE
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return AccountManager.this.lambda$createLoginRelatedProcess$5$AccountManager(xpUserData, (Map) obj);
                    }
                });
            }
            return flatMap.flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$P5rO3J39CPNqgz8_UQ2Rcq6dXHc
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return AccountManager.this.lambda$createLoginRelatedProcess$7$AccountManager((Integer) obj);
                }
            });
        }
        L.i(TAG, "current Account is temp , do nothing~");
        return io.reactivex.Observable.just(true);
    }

    public /* synthetic */ ObservableSource lambda$createLoginRelatedProcess$5$AccountManager(@NonNull XpUserData xpUserData, Map map) throws Exception {
        xpUserData.setOpenId((String) map.get(HttpConst.XP_CLIENT_XP_NAVI_OPENID_KEY));
        xpUserData.setSid((String) map.get(HttpConst.XP_CLIENT_XP_NAVI_SID_KEY));
        SettingWrapper.saveAccountSid((String) map.get(HttpConst.XP_CLIENT_XP_NAVI_SID_KEY));
        SettingWrapper.saveAccountOpenId((String) map.get(HttpConst.XP_CLIENT_XP_NAVI_OPENID_KEY));
        L.Tag tag = TAG;
        L.i(tag, "***** bindmap loginXpServer success sid= " + SettingWrapper.getAccountSid() + "，openId= " + SettingWrapper.getAccountOpenId());
        XPAccountServiceWrapper.getInstance().invokeXpMapLoginCallback();
        return this.mLinkAMapWrapper.checkBindAMapStatusFromXP(xpUserData).compose(applyRetry());
    }

    public /* synthetic */ ObservableSource lambda$createLoginRelatedProcess$7$AccountManager(Integer num) throws Exception {
        if (handlerAMapBindState(num)) {
            if (AccountStore.getInstance().isCurrentXpLoginAMap()) {
                L.i(TAG, "bindmap current AMap account is logged in,skip login~");
                setAMapLogin();
                refreshAMapAccountCookie();
                return io.reactivex.Observable.just(true);
            }
            L.i(TAG, "bindmap current account is bound to amap, prepare to login amap~");
            return createAMapLoginObservable().flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$hnJY85Xjwo-zlfG0hL37Zo8FxVE
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return AccountManager.this.lambda$null$6$AccountManager((AccountProfileResult) obj);
                }
            });
        }
        return createCheckIsAMapObservable().compose(applyRetry());
    }

    public /* synthetic */ ObservableSource lambda$null$6$AccountManager(AccountProfileResult accountProfileResult) throws Exception {
        L.i(TAG, "bindmap aMap login success ~~");
        setAMapLogin();
        getInstance().getAccountSyncSession().startSync(55);
        return io.reactivex.Observable.just(true);
    }

    public synchronized io.reactivex.Observable<Integer> createCheckBindAMapStatusObservable(@NonNull final XpUserData xpUserData) {
        if (XPAccountServiceWrapper.getInstance().isTempType()) {
            L.Tag tag = TAG;
            L.d(tag, "bindmap  checkBindAMapStatus userType=" + XPAccountServiceWrapper.getInstance().getUserType());
            return io.reactivex.Observable.error(new AccountException(-1, "currentAccount is temp!"));
        }
        if (xpUserData != null && !TextUtils.isEmpty(xpUserData.getOpenId()) && !TextUtils.isEmpty(xpUserData.getSid())) {
            return this.mLinkAMapWrapper.checkBindAMapStatusFromXP(xpUserData).flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$33j1ElTX8JzqwmGNNqxqih1lNq0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return AccountManager.this.lambda$createCheckBindAMapStatusObservable$8$AccountManager((Integer) obj);
                }
            }).doOnError(new Consumer() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$45lVZfwdZjc0NJQDv3zn7JlpmLU
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    AccountManager.this.lambda$createCheckBindAMapStatusObservable$9$AccountManager(xpUserData, (Throwable) obj);
                }
            });
        }
        return io.reactivex.Observable.error(LinkAMapError.newAccountException(310));
    }

    public /* synthetic */ ObservableSource lambda$createCheckBindAMapStatusObservable$8$AccountManager(Integer num) throws Exception {
        handlerAMapBindState(num);
        return io.reactivex.Observable.just(num);
    }

    public /* synthetic */ void lambda$createCheckBindAMapStatusObservable$9$AccountManager(@NonNull XpUserData xpUserData, Throwable th) throws Exception {
        L.Tag tag = TAG;
        L.i(tag, "createCheckBindAMapStatusObservable do on error:" + th);
        if (th instanceof AccountException) {
            AccountException accountException = (AccountException) th;
            int code = accountException.getCode();
            if (isAccountInitFinished() && xpUserData.isCurrentLoginUser()) {
                if (AccountDataResponseCode.isNeedReLogin(code)) {
                    AccountStore.getInstance().clearCurrentXpAccountInfo();
                    startAccountInit();
                } else if (code == 11081120) {
                    Object errorResponseData = accountException.getErrorResponseData();
                    if (errorResponseData instanceof NaviGetBoundAccountsResponse) {
                        String sid = ((NaviGetBoundAccountsResponse) errorResponseData).getSid();
                        if (TextUtils.isEmpty(sid)) {
                            return;
                        }
                        SettingWrapper.saveAccountSid(sid);
                        xpUserData.setSid(sid);
                    }
                }
            }
        }
    }

    public synchronized io.reactivex.Observable<Boolean> createBindAMapObservable() {
        return this.mLinkAMapWrapper.bindAMap().flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$8rif7jyZ0Nc2bL0i7EE3c9eSlTE
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AccountManager.lambda$createBindAMapObservable$10((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$createBindAMapObservable$10(Boolean bool) throws Exception {
        L.Tag tag = TAG;
        L.i(tag, "createBindAMapObservable bind success getCarLoginFlag:" + BLAccountServiceWrapper.getInstance().getAccountService().getCarLoginFlag());
        AccountStore.getInstance().setCurrentXpAccountBindAMap();
        AccountStore.getInstance().setCurrentXpAccountLoginAMap();
        SettingStatUtil.sendStatDataBindAmap(1);
        return io.reactivex.Observable.just(bool);
    }

    public synchronized io.reactivex.Observable<Boolean> createUnBindAMapObservable() {
        return this.mLinkAMapWrapper.unbindAMap().flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$YGVf31qrJlfUFHQlr8V0zdI0VDI
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AccountManager.this.lambda$createUnBindAMapObservable$11$AccountManager((Boolean) obj);
            }
        });
    }

    public /* synthetic */ ObservableSource lambda$createUnBindAMapObservable$11$AccountManager(Boolean bool) throws Exception {
        L.Tag tag = TAG;
        L.i(tag, "bindmap unBindAmap onSuccess  getCarLoginFlag:" + BLAccountServiceWrapper.getInstance().getAccountService().getCarLoginFlag());
        SettingStatUtil.sendStatDataBindAmap(6);
        SettingWrapper.saveBindAMapStatus(false);
        SettingWrapper.setBindAMapStatusValue(1);
        logoutAMapAccount();
        FavoriteSyncUtil.resetHomeCompanyConflictStatus();
        return io.reactivex.Observable.just(bool);
    }

    public io.reactivex.Observable<Boolean> createCheckIsAMapObservable() {
        return this.mLinkAMapWrapper.createCheckIsAMapObservable().flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$NedHPWMl33tzFBmBsq2JeY50Spo
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AccountManager.lambda$createCheckIsAMapObservable$12((GCarLtdCheckTokenResponseParam) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$createCheckIsAMapObservable$12(GCarLtdCheckTokenResponseParam gCarLtdCheckTokenResponseParam) throws Exception {
        if (L.ENABLE) {
            L.d(TAG, "每次进入无缝导航都请求 bindmap GCarLtdCheckTokenResponseParam =" + GsonUtil.toJson(gCarLtdCheckTokenResponseParam));
        }
        boolean z = false;
        if (gCarLtdCheckTokenResponseParam.isAmap == 1) {
            L.i(TAG, " bindmap checkIsAMapAccount amap server find xp account is registered");
            z = true;
        }
        SettingWrapper.saveAMapCheckToken(GsonUtil.toJson(gCarLtdCheckTokenResponseParam));
        SettingWrapper.saveIsAMapAccount(z);
        L.i(TAG, "***** bindmap createCheckIsAMapObservable success isAMapAccount:" + z);
        return io.reactivex.Observable.just(Boolean.valueOf(z));
    }

    public io.reactivex.Observable<Boolean> quickLogin() {
        return this.mLinkAMapWrapper.quickLogin().flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$olJ5TA07uMfjK4iBokFL2hehfps
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AccountManager.lambda$quickLogin$13((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$quickLogin$13(Boolean bool) throws Exception {
        AccountStore.getInstance().setCurrentXpAccountBindAMap();
        return io.reactivex.Observable.just(true);
    }

    public io.reactivex.Observable<AccountProfileResult> createAMapLoginObservable() {
        L.i(TAG, "*** bindmap start handlerAmapSilentLogin *****");
        return quickLogin().compose(applyRetry()).flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$rGzagIZqrQ7TzcEFJhNk-QA8kk4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AccountManager.this.lambda$createAMapLoginObservable$14$AccountManager((Boolean) obj);
            }
        });
    }

    public /* synthetic */ ObservableSource lambda$createAMapLoginObservable$14$AccountManager(Boolean bool) throws Exception {
        L.i(TAG, "*** bindmap handlerAmapSilentLogin start getAccountProfile *****");
        return getAMapAccountInfo().compose(applyRetry());
    }

    public io.reactivex.Observable<AccountProfileResult> getAMapAccountInfo() {
        return this.mLinkAMapWrapper.getAMapAccountInfo().flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$3AgKaNOg6cFMGBKOtf75Gz3IAEg
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AccountManager.lambda$getAMapAccountInfo$15((AccountProfileResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$getAMapAccountInfo$15(AccountProfileResult accountProfileResult) throws Exception {
        String json = GsonUtil.toJson(accountProfileResult.profile);
        if (!TextUtils.isEmpty(json)) {
            SettingWrapper.setBlAccountProfile(json);
        }
        AccountStore.getInstance().setCurrentXpAccountLoginAMap();
        SettingWrapper.setBlCookieLastTime(System.currentTimeMillis());
        return io.reactivex.Observable.just(accountProfileResult);
    }

    public io.reactivex.Observable<Boolean> createLogoutAMapAccountObservable() {
        L.i(TAG, "*** bindmap start handlerLogoutAMap *****");
        return this.mLinkAMapWrapper.createLogoutAMapAccountObservable().flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$6yJmvjYE8GjYcJcKFuNs-3v1M6g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AccountManager.lambda$createLogoutAMapAccountObservable$16((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$createLogoutAMapAccountObservable$16(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            L.i(TAG, "***** bindmap handlerLogoutAMap success");
            AccountStore.getInstance().setAMapAccountLogout();
            return io.reactivex.Observable.just(true);
        }
        L.i(TAG, "***** bindmap handlerLogoutAMap error");
        return io.reactivex.Observable.error(LinkAMapError.newAccountException(317));
    }

    public io.reactivex.Observable<AccountEvent> getAMapQRCode() {
        return this.mLinkAMapWrapper.getAMapQRCode();
    }

    public io.reactivex.Observable<Boolean> queryAMapQRLoginResult(QRCodeLoginResult qRCodeLoginResult) {
        return this.mLinkAMapWrapper.loginByAMapQRCode(qRCodeLoginResult).flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$9vIA5FbcKcpMGzCbJ5aGsASIqhU
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AccountManager.this.lambda$queryAMapQRLoginResult$17$AccountManager((Boolean) obj);
            }
        });
    }

    public /* synthetic */ ObservableSource lambda$queryAMapQRLoginResult$17$AccountManager(Boolean bool) throws Exception {
        getAMapAccountInfoAndSync();
        return io.reactivex.Observable.just(true);
    }

    public <T> ObservableTransformer<T, T> applyRetryWithNetError() {
        return new ObservableTransformer() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$ywv2CwZR8LFlXt9NcPWgDCmJRwg
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource apply(io.reactivex.Observable observable) {
                ObservableSource retryWhen;
                retryWhen = observable.retryWhen(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$UxAJN1oNGkIEqYYrhdr2onwEvN8
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return AccountManager.lambda$null$19((io.reactivex.Observable) obj);
                    }
                });
                return retryWhen;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$null$19(io.reactivex.Observable observable) throws Exception {
        L.i(TAG, "bindmap applyRetryWithNetError create retry logic ");
        final AtomicInteger atomicInteger = new AtomicInteger();
        return observable.take(2147483647L).flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$Hh2Qa2RNDJ1UbrcoNCZEG1y6MFk
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AccountManager.lambda$null$18(atomicInteger, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$null$18(AtomicInteger atomicInteger, Throwable th) throws Exception {
        int incrementAndGet = atomicInteger.incrementAndGet();
        boolean z = th instanceof AccountException ? !AccountDataResponseCode.isServerSessionError(((AccountException) th).getCode()) : true;
        L.Tag tag = TAG;
        L.i(tag, "********** bindmap applyRetryWithNetError needRetry:" + z + ",  try again count =>>" + incrementAndGet + "  error:" + th.toString());
        if (z) {
            return io.reactivex.Observable.timer(incrementAndGet < 12 ? (incrementAndGet - 1) * 20 : (incrementAndGet % 10) * RouteChargeDecorator.TYPE_SELECTED_KEEPER, TimeUnit.SECONDS);
        }
        return io.reactivex.Observable.error(th);
    }

    public <T> ObservableTransformer<T, T> applyRetry() {
        return new ObservableTransformer() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$JvGA9a_r3ZCjo-2pHBrsAkjcJKU
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource apply(io.reactivex.Observable observable) {
                return AccountManager.this.lambda$applyRetry$23$AccountManager(observable);
            }
        };
    }

    public /* synthetic */ ObservableSource lambda$applyRetry$23$AccountManager(io.reactivex.Observable observable) {
        return observable.retryWhen(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$wI7xONjkK-vV822uUDbMVT2wZWc
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AccountManager.this.lambda$null$22$AccountManager((io.reactivex.Observable) obj);
            }
        });
    }

    public /* synthetic */ ObservableSource lambda$null$22$AccountManager(io.reactivex.Observable observable) throws Exception {
        L.i(TAG, "bindmap applyRetry create retry logic ");
        final AtomicInteger atomicInteger = new AtomicInteger();
        return observable.take(2147483647L).flatMap(new Function() { // from class: com.xiaopeng.montecarlo.account.-$$Lambda$AccountManager$MsDVuqVDaSBeydmYfUnBx9bf0vU
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AccountManager.this.lambda$null$21$AccountManager(atomicInteger, (Throwable) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ io.reactivex.ObservableSource lambda$null$21$AccountManager(java.util.concurrent.atomic.AtomicInteger r6, java.lang.Throwable r7) throws java.lang.Exception {
        /*
            r5 = this;
            int r6 = r6.incrementAndGet()
            boolean r0 = r7 instanceof com.xiaopeng.montecarlo.root.account.AccountException
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L3d
            r0 = r7
            com.xiaopeng.montecarlo.root.account.AccountException r0 = (com.xiaopeng.montecarlo.root.account.AccountException) r0
            int r3 = r0.getCode()
            boolean r4 = com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataResponseCode.isNeedReLogin(r3)
            if (r4 == 0) goto L18
            goto L3e
        L18:
            r4 = 11081120(0xa915a0, float:1.5527956E-38)
            if (r3 != r4) goto L3d
            java.lang.Object r0 = r0.getErrorResponseData()
            boolean r3 = r0 instanceof com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviGetBoundAccountsResponse
            if (r3 == 0) goto L3d
            com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviGetBoundAccountsResponse r0 = (com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviGetBoundAccountsResponse) r0
            java.lang.String r0 = r0.getSid()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L3e
            com.xiaopeng.montecarlo.navcore.account.XpUserData r3 = r5.mCurrentXpUserData
            if (r3 == 0) goto L3e
            com.xiaopeng.montecarlo.navcore.setting.SettingWrapper.saveAccountSid(r0)
            com.xiaopeng.montecarlo.navcore.account.XpUserData r1 = r5.mCurrentXpUserData
            r1.setSid(r0)
        L3d:
            r1 = r2
        L3e:
            com.xiaopeng.montecarlo.root.util.L$Tag r0 = com.xiaopeng.montecarlo.account.AccountManager.TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "********** bindmap applyRetry needRetry:"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r4 = ",  try again count =>>"
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = "  error:"
            r3.append(r4)
            java.lang.String r4 = r7.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.xiaopeng.montecarlo.root.util.L.i(r0, r3)
            if (r1 == 0) goto L7e
            r7 = 12
            if (r6 >= r7) goto L72
            int r6 = r6 - r2
            int r6 = r6 * 20
            goto L76
        L72:
            int r6 = r6 % 10
            int r6 = r6 * 240
        L76:
            long r6 = (long) r6
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            io.reactivex.Observable r6 = io.reactivex.Observable.timer(r6, r0)
            return r6
        L7e:
            io.reactivex.Observable r6 = io.reactivex.Observable.error(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.account.AccountManager.lambda$null$21$AccountManager(java.util.concurrent.atomic.AtomicInteger, java.lang.Throwable):io.reactivex.ObservableSource");
    }

    public void getAMapAccountInfoAndSync() {
        this.mOperationsHolder.addSubscription(getAMapAccountInfo(), new BaseAccountObserver<AccountProfileResult>() { // from class: com.xiaopeng.montecarlo.account.AccountManager.5
            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver
            public void onSuccess(@NonNull AccountProfileResult accountProfileResult) {
                L.i(AccountManager.TAG, "*****  getAMapAccountInfoAndSync success start sync");
                AccountManager.getInstance().getAccountSyncSession().startSync(55);
            }
        });
    }

    public void logoutAMapAccount() {
        this.mOperationsHolder.addSubscription(createLogoutAMapAccountObservable(), new BaseAccountObserver<Boolean>() { // from class: com.xiaopeng.montecarlo.account.AccountManager.6
            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver
            public void onSuccess(@NonNull Boolean bool) {
                L.i(AccountManager.TAG, "logoutAMapAccount success");
            }
        });
    }

    private synchronized boolean handlerAMapBindState(@NonNull Integer num) {
        boolean z;
        L.Tag tag = TAG;
        L.i(tag, "bindmap checkBindAmapStatus success handlerAMapBindState state=" + num);
        z = num.intValue() == 0;
        if (SettingWrapper.getBindAMapStatus() && !z) {
            L.i(TAG, "bindmap checkBindAmapStatus now it is unbind!!");
            this.mPublishSubject.onNext(true);
            AccountStore.getInstance().setAMapAccountLogout();
        }
        SettingWrapper.saveBindAMapStatus(z);
        if (!SettingWrapper.getFistBindAmap() && z) {
            SettingWrapper.saveFirstBindAmap(true);
        }
        MapStateObserver.getInstance().notifyRefreshGifGuider();
        return z;
    }

    private void refreshAMapAccountCookie() {
        long blCookieLastTime = SettingWrapper.getBlCookieLastTime();
        L.Tag tag = TAG;
        L.i(tag, "bindmap syncFavorite BL cookie refresh lasttime = " + blCookieLastTime);
        if (System.currentTimeMillis() - blCookieLastTime > BL_COOKIE_REFRESH_INTERVAL) {
            getAMapAccountInfoAndSync();
        }
    }
}
