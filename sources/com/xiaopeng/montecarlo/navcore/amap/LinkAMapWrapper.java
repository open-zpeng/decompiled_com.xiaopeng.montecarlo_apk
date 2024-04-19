package com.xiaopeng.montecarlo.navcore.amap;

import android.text.TextUtils;
import com.autonavi.gbl.aosclient.model.GCarLtdBindRequestParam;
import com.autonavi.gbl.aosclient.model.GCarLtdBindResponseParam;
import com.autonavi.gbl.aosclient.model.GCarLtdCheckTokenResponseParam;
import com.autonavi.gbl.aosclient.model.GCarLtdQuickLoginRequestParam;
import com.autonavi.gbl.aosclient.model.GCarLtdQuickLoginResponseParam;
import com.autonavi.gbl.aosclient.model.GCarLtdUnbindResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdBind;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdCheckToken;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdQuickLogin;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdUnbind;
import com.autonavi.gbl.user.account.model.AccountProfileResult;
import com.autonavi.gbl.user.account.model.QRCodeLoginConfirmResult;
import com.autonavi.gbl.user.account.model.QRCodeLoginResult;
import com.xiaopeng.montecarlo.navcore.account.BLAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.account.ICallback;
import com.xiaopeng.montecarlo.navcore.account.IError;
import com.xiaopeng.montecarlo.navcore.amap.LinkAMapWrapper;
import com.xiaopeng.montecarlo.navcore.amap.base.LinkAMapError;
import com.xiaopeng.montecarlo.navcore.amap.base.LinkAMapUtils;
import com.xiaopeng.montecarlo.navcore.aos.AosServiceWrapper;
import com.xiaopeng.montecarlo.navcore.event.AccountEvent;
import com.xiaopeng.montecarlo.root.account.AccountException;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
/* loaded from: classes2.dex */
public class LinkAMapWrapper extends LinkAMapUtils {
    private static final L.Tag TAG = new L.Tag("AccountLinkAMapWrapper");

    /* renamed from: com.xiaopeng.montecarlo.navcore.amap.LinkAMapWrapper$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements ICallback<String, IError> {
        final /* synthetic */ ObservableEmitter val$emitter;

        AnonymousClass1(ObservableEmitter observableEmitter) {
            this.val$emitter = observableEmitter;
        }

        @Override // com.xiaopeng.montecarlo.navcore.account.ICallback
        public void onSuccess(String str) {
            if (L.ENABLE) {
                L.Tag tag = LinkAMapWrapper.TAG;
                L.d(tag, "bindmap xauthcode success authCode:" + str);
            }
            GCarLtdBindRequestParam gCarLtdBindRequestParam = new GCarLtdBindRequestParam();
            gCarLtdBindRequestParam.authId = str;
            AosServiceWrapper aosServiceWrapper = AosServiceWrapper.getInstance();
            final ObservableEmitter observableEmitter = this.val$emitter;
            aosServiceWrapper.requestCarLtdBind(gCarLtdBindRequestParam, new ICallBackCarLtdBind() { // from class: com.xiaopeng.montecarlo.navcore.amap.-$$Lambda$LinkAMapWrapper$1$lug-ChU0O724y5ySIQRqeMqu3Kk
                @Override // com.autonavi.gbl.aosclient.observer.ICallBackCarLtdBind
                public final void onRecvAck(GCarLtdBindResponseParam gCarLtdBindResponseParam) {
                    LinkAMapWrapper.AnonymousClass1.lambda$onSuccess$0(ObservableEmitter.this, gCarLtdBindResponseParam);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$onSuccess$0(ObservableEmitter observableEmitter, GCarLtdBindResponseParam gCarLtdBindResponseParam) {
            if (gCarLtdBindResponseParam != null) {
                if (L.ENABLE) {
                    L.Tag tag = LinkAMapWrapper.TAG;
                    L.d(tag, "bindmap  bind AMap 返回值param= " + GsonUtil.toJson(gCarLtdBindResponseParam));
                }
                if (gCarLtdBindResponseParam.code == 1) {
                    L.i(LinkAMapWrapper.TAG, "**** bindmap bindAMap success ");
                    observableEmitter.onNext(true);
                    observableEmitter.onComplete();
                    return;
                }
                observableEmitter.onError(LinkAMapError.newAccountException(304));
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.account.ICallback
        public void onFail(IError iError) {
            this.val$emitter.onError(new AccountException(iError.getCode(), iError.getMessage()));
        }
    }

    public Observable<Boolean> bindAMap() {
        L.i(TAG, "*** bindmap bindAMap start ****");
        return Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.navcore.amap.-$$Lambda$LinkAMapWrapper$QiG52fNb_oUn52fTJlsQkS8jVGU
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                LinkAMapWrapper.this.lambda$bindAMap$0$LinkAMapWrapper(observableEmitter);
            }
        });
    }

    public /* synthetic */ void lambda$bindAMap$0$LinkAMapWrapper(ObservableEmitter observableEmitter) throws Exception {
        requestXPAuthCode(new AnonymousClass1(observableEmitter));
    }

    /* renamed from: com.xiaopeng.montecarlo.navcore.amap.LinkAMapWrapper$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass2 implements ICallback<String, IError> {
        final /* synthetic */ ObservableEmitter val$emitter;

        AnonymousClass2(ObservableEmitter observableEmitter) {
            this.val$emitter = observableEmitter;
        }

        @Override // com.xiaopeng.montecarlo.navcore.account.ICallback
        public void onSuccess(String str) {
            if (L.ENABLE) {
                L.Tag tag = LinkAMapWrapper.TAG;
                L.d(tag, "bindmap unBindAMap getOAuthCode auth info= " + str);
            }
            AosServiceWrapper aosServiceWrapper = AosServiceWrapper.getInstance();
            final ObservableEmitter observableEmitter = this.val$emitter;
            aosServiceWrapper.requestCarLtdUBind(str, new ICallBackCarLtdUnbind() { // from class: com.xiaopeng.montecarlo.navcore.amap.-$$Lambda$LinkAMapWrapper$2$SvEnT9fBUXZ14eySNI3qDELjYpw
                @Override // com.autonavi.gbl.aosclient.observer.ICallBackCarLtdUnbind
                public final void onRecvAck(GCarLtdUnbindResponseParam gCarLtdUnbindResponseParam) {
                    LinkAMapWrapper.AnonymousClass2.lambda$onSuccess$0(ObservableEmitter.this, gCarLtdUnbindResponseParam);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$onSuccess$0(ObservableEmitter observableEmitter, GCarLtdUnbindResponseParam gCarLtdUnbindResponseParam) {
            if (L.ENABLE) {
                L.Tag tag = LinkAMapWrapper.TAG;
                L.d(tag, "bindmap  unbind param = " + GsonUtil.toJson(gCarLtdUnbindResponseParam));
            }
            if (gCarLtdUnbindResponseParam.code == 1) {
                L.i(LinkAMapWrapper.TAG, "*** bindmap unBindAmap success ");
                observableEmitter.onNext(true);
                observableEmitter.onComplete();
                return;
            }
            observableEmitter.onError(new AccountException(301, gCarLtdUnbindResponseParam.message));
        }

        @Override // com.xiaopeng.montecarlo.navcore.account.ICallback
        public void onFail(IError iError) {
            this.val$emitter.onError(new AccountException(iError.getCode(), iError.getMessage()));
        }
    }

    public Observable<Boolean> unbindAMap() {
        L.i(TAG, "*** bindmap unBindAmap start ****");
        return Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.navcore.amap.-$$Lambda$LinkAMapWrapper$YKoy3reSTIXyQK11MTE5RSAH6qM
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                LinkAMapWrapper.this.lambda$unbindAMap$1$LinkAMapWrapper(observableEmitter);
            }
        });
    }

    public /* synthetic */ void lambda$unbindAMap$1$LinkAMapWrapper(ObservableEmitter observableEmitter) throws Exception {
        requestXPAuthCode(new AnonymousClass2(observableEmitter));
    }

    public Observable<AccountEvent> getAMapQRCode() {
        return BLAccountServiceWrapper.getInstance().createGetQRCodeLoginRequest().flatMap(new Function() { // from class: com.xiaopeng.montecarlo.navcore.amap.-$$Lambda$LinkAMapWrapper$wslwFHChHwuffAfiCPbGg8fyzwA
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return LinkAMapWrapper.lambda$getAMapQRCode$2((AccountEvent) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$getAMapQRCode$2(AccountEvent accountEvent) throws Exception {
        if (accountEvent.getBitmap() != null) {
            return Observable.just(accountEvent);
        }
        return Observable.error(LinkAMapError.newAccountException(305));
    }

    public Observable<Boolean> loginByAMapQRCode(QRCodeLoginResult qRCodeLoginResult) {
        L.i(TAG, "*** bindmap loginByAMapQRCode check start ****");
        return BLAccountServiceWrapper.getInstance().createQRCodeLoginConfirmRequest(qRCodeLoginResult).flatMap(new Function() { // from class: com.xiaopeng.montecarlo.navcore.amap.-$$Lambda$LinkAMapWrapper$Erg7w7oKmwBotnYZaXk--xHEGu0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return LinkAMapWrapper.lambda$loginByAMapQRCode$3((QRCodeLoginConfirmResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$loginByAMapQRCode$3(QRCodeLoginConfirmResult qRCodeLoginConfirmResult) throws Exception {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bindmap  onAosAccountEvent QRCodeLoginConfirmResult qrCode result= " + GsonUtil.toJson(qRCodeLoginConfirmResult));
        }
        if (qRCodeLoginConfirmResult.code == 1) {
            L.i(TAG, "*** bindmap loginByAMapQRCode check success ");
            return Observable.just(true);
        }
        return Observable.error(LinkAMapError.newAccountException(309));
    }

    /* renamed from: com.xiaopeng.montecarlo.navcore.amap.LinkAMapWrapper$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass3 implements ICallback<String, IError> {
        final /* synthetic */ ObservableEmitter val$emitter;

        AnonymousClass3(ObservableEmitter observableEmitter) {
            this.val$emitter = observableEmitter;
        }

        @Override // com.xiaopeng.montecarlo.navcore.account.ICallback
        public void onSuccess(String str) {
            L.Tag tag = LinkAMapWrapper.TAG;
            L.i(tag, "bindmap quickLogin getOAuthCode auth info= " + str);
            AosServiceWrapper aosServiceWrapper = AosServiceWrapper.getInstance();
            final ObservableEmitter observableEmitter = this.val$emitter;
            aosServiceWrapper.requestCarLtdCheckToken(str, new ICallBackCarLtdCheckToken() { // from class: com.xiaopeng.montecarlo.navcore.amap.-$$Lambda$LinkAMapWrapper$3$Yth7c2hw8jZsR_HM0eLB9Tqc2mM
                @Override // com.autonavi.gbl.aosclient.observer.ICallBackCarLtdCheckToken
                public final void onRecvAck(GCarLtdCheckTokenResponseParam gCarLtdCheckTokenResponseParam) {
                    LinkAMapWrapper.AnonymousClass3.lambda$onSuccess$2(ObservableEmitter.this, gCarLtdCheckTokenResponseParam);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$onSuccess$2(final ObservableEmitter observableEmitter, GCarLtdCheckTokenResponseParam gCarLtdCheckTokenResponseParam) {
            if (L.ENABLE) {
                L.Tag tag = LinkAMapWrapper.TAG;
                L.d(tag, "bindmap  quickLogin check-token onReceivedAck params= " + GsonUtil.toJson(gCarLtdCheckTokenResponseParam));
            }
            final GCarLtdQuickLoginRequestParam gCarLtdQuickLoginRequestParam = new GCarLtdQuickLoginRequestParam();
            gCarLtdQuickLoginRequestParam.authId = gCarLtdCheckTokenResponseParam.auth_id;
            gCarLtdQuickLoginRequestParam.mTimeOut = 3000L;
            gCarLtdQuickLoginRequestParam.source = AosServiceWrapper.AOS_SERVICE_SOURCE;
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.amap.-$$Lambda$LinkAMapWrapper$3$9cT7ia9IePeXZ9K-owFAvdpwvSg
                @Override // java.lang.Runnable
                public final void run() {
                    AosServiceWrapper.getInstance().requestCarLtdQuickLogin(GCarLtdQuickLoginRequestParam.this, new ICallBackCarLtdQuickLogin() { // from class: com.xiaopeng.montecarlo.navcore.amap.-$$Lambda$LinkAMapWrapper$3$Ljbk2g68sEB_p-Nb8c8mNybir9s
                        @Override // com.autonavi.gbl.aosclient.observer.ICallBackCarLtdQuickLogin
                        public final void onRecvAck(GCarLtdQuickLoginResponseParam gCarLtdQuickLoginResponseParam) {
                            LinkAMapWrapper.AnonymousClass3.lambda$null$0(ObservableEmitter.this, gCarLtdQuickLoginResponseParam);
                        }
                    });
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$null$0(ObservableEmitter observableEmitter, GCarLtdQuickLoginResponseParam gCarLtdQuickLoginResponseParam) {
            if (L.ENABLE) {
                L.Tag tag = LinkAMapWrapper.TAG;
                L.d(tag, "bindmap  quickLogin onReceivedAck param= " + GsonUtil.toJson(gCarLtdQuickLoginResponseParam));
            }
            if (gCarLtdQuickLoginResponseParam == null || gCarLtdQuickLoginResponseParam.code != 1) {
                L.Tag tag2 = LinkAMapWrapper.TAG;
                L.e(tag2, "bindmap  quick login fail param = " + GsonUtil.toJson(gCarLtdQuickLoginResponseParam));
                observableEmitter.onError(LinkAMapError.newAccountException(303));
            } else {
                L.i(LinkAMapWrapper.TAG, "***** bindmap handlerAmapSilentLogin quickLogin onSuccess");
                observableEmitter.onNext(true);
                observableEmitter.onComplete();
            }
            if (L.ENABLE) {
                L.d(LinkAMapWrapper.TAG, "bindmap  quick login end");
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.account.ICallback
        public void onFail(IError iError) {
            this.val$emitter.onError(new AccountException(iError.getCode(), iError.getMessage()));
        }
    }

    public /* synthetic */ void lambda$quickLogin$4$LinkAMapWrapper(ObservableEmitter observableEmitter) throws Exception {
        requestXPAuthCode(new AnonymousClass3(observableEmitter));
    }

    public Observable<Boolean> quickLogin() {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.navcore.amap.-$$Lambda$LinkAMapWrapper$eJTRyZl8TgB1ICfiR2D8bQfxBs4
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                LinkAMapWrapper.this.lambda$quickLogin$4$LinkAMapWrapper(observableEmitter);
            }
        });
    }

    public Observable<AccountProfileResult> getAMapAccountInfo() {
        return BLAccountServiceWrapper.getInstance().createAccountProfileRequest().flatMap(new Function() { // from class: com.xiaopeng.montecarlo.navcore.amap.-$$Lambda$LinkAMapWrapper$nsOND_DbXTckEV-a0HEBV6QX_Y0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return LinkAMapWrapper.lambda$getAMapAccountInfo$5((AccountProfileResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$getAMapAccountInfo$5(AccountProfileResult accountProfileResult) throws Exception {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "***** bindmap  onAosAccountEvent AccountProfileResult  = " + GsonUtil.toJson(accountProfileResult));
        }
        if (accountProfileResult.profile != null) {
            if (TextUtils.isEmpty(accountProfileResult.profile.uid)) {
                return Observable.error(LinkAMapError.newAccountException(307));
            }
            L.i(TAG, "***** handlerAmapSilentLogin getAccountProfile success");
            return Observable.just(accountProfileResult);
        }
        return Observable.error(LinkAMapError.newAccountException(308));
    }

    public Observable<Boolean> createLogoutAMapAccountObservable() {
        return BLAccountServiceWrapper.getInstance().createLogoutRequest();
    }

    /* renamed from: com.xiaopeng.montecarlo.navcore.amap.LinkAMapWrapper$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass4 implements ICallback<String, IError> {
        final /* synthetic */ ObservableEmitter val$emitter;

        AnonymousClass4(ObservableEmitter observableEmitter) {
            this.val$emitter = observableEmitter;
        }

        @Override // com.xiaopeng.montecarlo.navcore.account.ICallback
        public void onSuccess(String str) {
            L.Tag tag = LinkAMapWrapper.TAG;
            L.i(tag, "bindmap  checkIsAMapAccount  get AuthCode : " + str);
            AosServiceWrapper aosServiceWrapper = AosServiceWrapper.getInstance();
            final ObservableEmitter observableEmitter = this.val$emitter;
            aosServiceWrapper.requestCarLtdCheckToken(str, new ICallBackCarLtdCheckToken() { // from class: com.xiaopeng.montecarlo.navcore.amap.-$$Lambda$LinkAMapWrapper$4$mmGSsUVDFE-nSOlm6zBebziGw2s
                @Override // com.autonavi.gbl.aosclient.observer.ICallBackCarLtdCheckToken
                public final void onRecvAck(GCarLtdCheckTokenResponseParam gCarLtdCheckTokenResponseParam) {
                    LinkAMapWrapper.AnonymousClass4.lambda$onSuccess$0(ObservableEmitter.this, gCarLtdCheckTokenResponseParam);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$onSuccess$0(ObservableEmitter observableEmitter, GCarLtdCheckTokenResponseParam gCarLtdCheckTokenResponseParam) {
            if (L.ENABLE) {
                L.Tag tag = LinkAMapWrapper.TAG;
                L.i(tag, "bindmap  checkIsAMapAccount  gCarLtdCheckTokenResponseParam= " + GsonUtil.toJson(gCarLtdCheckTokenResponseParam));
            }
            if (gCarLtdCheckTokenResponseParam != null) {
                L.i(LinkAMapWrapper.TAG, "***** bindmap createCheckIsAMap onSuccess");
                observableEmitter.onNext(gCarLtdCheckTokenResponseParam);
                observableEmitter.onComplete();
                return;
            }
            observableEmitter.onError(LinkAMapError.newAccountException(306));
        }

        @Override // com.xiaopeng.montecarlo.navcore.account.ICallback
        public void onFail(IError iError) {
            L.i(LinkAMapWrapper.TAG, "***** bindmap  checkIsAMapAccount onFail");
            this.val$emitter.onError(new AccountException(iError.getCode(), iError.getMessage()));
        }
    }

    public Observable<GCarLtdCheckTokenResponseParam> createCheckIsAMapObservable() {
        L.i(TAG, "*** bindmap start createCheckIsAMap  ***** ");
        return Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.navcore.amap.-$$Lambda$LinkAMapWrapper$ElzUsFYhSQIy8YrpmBmXfvR9XtA
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                LinkAMapWrapper.this.lambda$createCheckIsAMapObservable$6$LinkAMapWrapper(observableEmitter);
            }
        });
    }

    public /* synthetic */ void lambda$createCheckIsAMapObservable$6$LinkAMapWrapper(ObservableEmitter observableEmitter) throws Exception {
        requestXPAuthCode(new AnonymousClass4(observableEmitter));
    }
}
