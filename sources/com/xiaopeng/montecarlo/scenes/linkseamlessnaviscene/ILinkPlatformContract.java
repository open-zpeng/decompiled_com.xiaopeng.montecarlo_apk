package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene;

import com.autonavi.gbl.user.account.model.AccountAosResult;
import com.xiaopeng.montecarlo.base.IBaseLogicView;
import com.xiaopeng.montecarlo.base.IBasePresenter;
import com.xiaopeng.montecarlo.navcore.event.AccountEvent;
/* loaded from: classes2.dex */
public interface ILinkPlatformContract {

    /* loaded from: classes2.dex */
    public interface LogicView extends IBaseLogicView<LinkPlatformPresent> {
        void onAmapAccountSuccess(String str);

        void onAmapQrCodeSuccess(AccountEvent accountEvent);

        void onBindAmapFailed();

        void onBindAmapSuccess(boolean z);

        void onCheckBindAMapStatusSuccess(boolean z);

        void onCheckIsAmapAccountSuccess(boolean z);

        void onDataFetchTimeout();

        void onGetUserInfoSuccess(String str, boolean z);

        void onLoginAMapFail();

        void onLoginAmapSuccess(boolean z, boolean z2);

        void onLoginSuccess(String str, boolean z);

        void onRequestWechatFailed();

        void onStateActive();

        void onStateImmersion();

        void onUnbindAmapFailed();

        void onWechatQrCodeSuccess(String str);
    }

    /* loaded from: classes2.dex */
    public interface Presenter extends IBasePresenter {
        void bindAmap(boolean z);

        void checkBindAMapStatus();

        void checkIsAmapAccount();

        void exitSence();

        void getAmapAccount();

        void getUserInfo();

        void initData(int i);

        void loginByAMapQRCode(AccountAosResult accountAosResult);

        void oneSecBindAmap();

        void requestAmapQrcode();

        void requestWechatQrcode();

        void unBindAmap();

        void xpQuickLogin();
    }
}
