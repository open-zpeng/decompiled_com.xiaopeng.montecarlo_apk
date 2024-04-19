package com.xiaopeng.montecarlo.navcore.amap.base;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.account.ICallback;
import com.xiaopeng.montecarlo.navcore.account.IError;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.account.XpUserData;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataResponseCode;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.BoundAccountInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.INaviUserSessionService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviLoginRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviGetBoundAccountsResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviLoginResponse;
import com.xiaopeng.montecarlo.root.account.AccountException;
import com.xiaopeng.montecarlo.root.httpclient.constants.HttpConst;
import com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
/* loaded from: classes2.dex */
public class LinkAMapUtils {
    private static final L.Tag TAG = new L.Tag("AccountLinkAMapUtils");
    Scheduler mChildThreadScheduler = Schedulers.from(WorkThreadUtil.getInstance().getCachedThreadPool());
    private final INaviUserSessionService mNaviUserSessionService = (INaviUserSessionService) HttpClientManager.getInstance().getService(INaviUserSessionService.class);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void requestXPAuthCode(@NonNull ICallback<String, IError> iCallback) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bindmap request xpauthcode +Thread=" + Thread.currentThread());
        }
        XPAccountServiceWrapper.getInstance().asyncGetOAuthCode(iCallback);
    }

    public Observable<Map<String, String>> createXpLoginObservable() {
        L.i(TAG, "*** bindmap start loginXpServer ***** ");
        return Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.navcore.amap.base.-$$Lambda$LinkAMapUtils$xfbGID94mn0VnMpPveifyU9hRX0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                LinkAMapUtils.this.lambda$createXpLoginObservable$0$LinkAMapUtils(observableEmitter);
            }
        }).flatMap(new Function() { // from class: com.xiaopeng.montecarlo.navcore.amap.base.-$$Lambda$LinkAMapUtils$x8A7N-LtG-XZRHzHWCmT2JN15XU
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return LinkAMapUtils.this.lambda$createXpLoginObservable$1$LinkAMapUtils((String) obj);
            }
        }).compose(applySchedulers());
    }

    public /* synthetic */ void lambda$createXpLoginObservable$0$LinkAMapUtils(final ObservableEmitter observableEmitter) throws Exception {
        XPAccountServiceWrapper.getInstance().getOAuthCode(HttpConst.APP_ID_VALUE, new ICallback<String, IError>() { // from class: com.xiaopeng.montecarlo.navcore.amap.base.LinkAMapUtils.1
            @Override // com.xiaopeng.montecarlo.navcore.account.ICallback
            public void onSuccess(String str) {
                L.Tag tag = LinkAMapUtils.TAG;
                L.i(tag, "***** loginXpServer authCode:" + str);
                observableEmitter.onNext(str);
            }

            @Override // com.xiaopeng.montecarlo.navcore.account.ICallback
            public void onFail(IError iError) {
                observableEmitter.onError(new AccountException(iError.getCode(), iError.getMessage()));
            }
        });
    }

    public /* synthetic */ ObservableSource lambda$createXpLoginObservable$1$LinkAMapUtils(String str) throws Exception {
        NaviLoginResponse login = this.mNaviUserSessionService.login(new NaviLoginRequest().setCode(str));
        if (login == null) {
            return Observable.error(new AccountException(315, "loginXpServer fail!"));
        }
        HashMap hashMap = new HashMap();
        hashMap.put(HttpConst.XP_CLIENT_XP_NAVI_SID_KEY, login.getSid());
        hashMap.put(HttpConst.XP_CLIENT_XP_NAVI_OPENID_KEY, login.getOpenId());
        return Observable.just(hashMap);
    }

    public Observable<Boolean> createXpLogoutObservable(final String str, final String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            if (str2.equals(str3)) {
                L.e(TAG, "***** bindmap logoutXMapServer last openid equals current, cancel logout!!!");
            } else {
                L.i(TAG, "*** bindmap start logoutXMapServer *****");
                return Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.navcore.amap.base.-$$Lambda$LinkAMapUtils$aZc5vG8tWqE-cI5uZ5TvFbZYHmk
                    @Override // io.reactivex.ObservableOnSubscribe
                    public final void subscribe(ObservableEmitter observableEmitter) {
                        LinkAMapUtils.this.lambda$createXpLogoutObservable$2$LinkAMapUtils(str, str2, observableEmitter);
                    }
                }).compose(applySchedulers());
            }
        } else {
            L.e(TAG, "***** bindmap logoutXMapServer userid/sid is empty, cancel logout!!!");
        }
        return Observable.just(true);
    }

    public /* synthetic */ void lambda$createXpLogoutObservable$2$LinkAMapUtils(String str, String str2, ObservableEmitter observableEmitter) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpConst.XP_CLIENT_XP_NAVI_SID_KEY, str);
        hashMap.put(HttpConst.XP_CLIENT_XP_NAVI_OPENID_KEY, str2);
        Boolean logout = this.mNaviUserSessionService.logout(hashMap);
        if (logout != null && logout.booleanValue()) {
            L.i(TAG, "***** logoutXMapServer success");
            observableEmitter.onNext(true);
            return;
        }
        L.i(TAG, "***** logoutXMapServer failed");
        observableEmitter.onError(LinkAMapError.newAccountException(319));
    }

    public Observable<Integer> checkBindAMapStatusFromXP(@NonNull final XpUserData xpUserData) {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.navcore.amap.base.-$$Lambda$LinkAMapUtils$9mShBXwY6iJJbRme1c9PbaLB118
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                LinkAMapUtils.this.lambda$checkBindAMapStatusFromXP$3$LinkAMapUtils(xpUserData, observableEmitter);
            }
        }).compose(applySchedulers());
    }

    public /* synthetic */ void lambda$checkBindAMapStatusFromXP$3$LinkAMapUtils(@NonNull XpUserData xpUserData, ObservableEmitter observableEmitter) throws Exception {
        L.Tag tag = TAG;
        L.i(tag, "*** bindmap start checkBindAMapStatusFromXP *****   =>>sid = " + xpUserData.getSid() + " | openId = " + xpUserData.getOpenId());
        HashMap hashMap = new HashMap();
        hashMap.put(HttpConst.XP_CLIENT_XP_NAVI_SID_KEY, xpUserData.getSid());
        hashMap.put(HttpConst.XP_CLIENT_XP_NAVI_OPENID_KEY, xpUserData.getOpenId());
        ResponseWrapper<NaviGetBoundAccountsResponse> boundAccounts = this.mNaviUserSessionService.getBoundAccounts(hashMap);
        int responseCode = boundAccounts.getResponseCode();
        if (responseCode != 200) {
            AccountException newAccountException = AccountDataResponseCode.newAccountException(responseCode);
            newAccountException.setErrorResponseData(boundAccounts.getData());
            observableEmitter.onError(newAccountException);
            return;
        }
        for (BoundAccountInfo boundAccountInfo : (List) Optional.of(boundAccounts).map(new java.util.function.Function() { // from class: com.xiaopeng.montecarlo.navcore.amap.base.-$$Lambda$6zgCzUDw17jo6DOnvkUKYGMos6Y
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (NaviGetBoundAccountsResponse) ((ResponseWrapper) obj).getData();
            }
        }).map(new java.util.function.Function() { // from class: com.xiaopeng.montecarlo.navcore.amap.base.-$$Lambda$wXV3MBjmBwbZfr7lWDw314tXOOU
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((NaviGetBoundAccountsResponse) obj).getAccounts();
            }
        }).orElse(Collections.emptyList())) {
            if (7 == boundAccountInfo.getThirdType().intValue()) {
                L.Tag tag2 = TAG;
                L.i(tag2, "***** bindmap checkBindAMapStatus onSuccess state=" + boundAccountInfo.getState());
                observableEmitter.onNext(boundAccountInfo.getState());
                return;
            }
        }
        observableEmitter.onNext(-1);
    }

    protected <T> ObservableTransformer<T, T> applySchedulers() {
        return new ObservableTransformer() { // from class: com.xiaopeng.montecarlo.navcore.amap.base.-$$Lambda$LinkAMapUtils$ikca86PcFqY0DAHxf-jc-9uiqvE
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource apply(Observable observable) {
                return LinkAMapUtils.this.lambda$applySchedulers$4$LinkAMapUtils(observable);
            }
        };
    }

    public /* synthetic */ ObservableSource lambda$applySchedulers$4$LinkAMapUtils(Observable observable) {
        return observable.subscribeOn(this.mChildThreadScheduler).observeOn(AndroidSchedulers.mainThread());
    }
}
