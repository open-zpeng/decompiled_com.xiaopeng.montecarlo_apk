package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.autonavi.gbl.user.account.model.AccountAosResult;
import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.state.IStateListener;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessNaviDataProvider;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessRequestParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LoginCallback;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessAmapAccountData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessAmapQrcodeData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBindStatusData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessIsAmapData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessLoginAmapData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessUserInfoData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessWechatQrCodeData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessBindAmapParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessCheckBindParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessCheckIsAmapParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessGetAmapAccountParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessGetAmapQrcodeParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessGetUserParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessGetWechatQrcodeParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessLoginAmapByQrcodeParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessOneSecBindParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessUnbindAmapParam;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.stat.MapStateChangeStatUtil;
import com.xiaopeng.montecarlo.stat.NaviGuiderStatUtil;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import java.util.Observable;
/* loaded from: classes3.dex */
public class LinkPlatformPresent extends BasePresenter implements ILinkPlatformContract.Presenter, BaseCallBack<LinkSeamlessRequestParam, LinkSeamlessBaseData>, LoginCallback, IStateListener {
    private static final L.Tag TAG = new L.Tag("LinkPlatformPresent");
    private LinkSeamlessNaviDataProvider mDataProvider;
    private ILinkPlatformContract.LogicView mLogicView;
    private int mPlatformType;

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataCache(@NonNull LinkSeamlessBaseData linkSeamlessBaseData) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchComplete(LinkSeamlessRequestParam linkSeamlessRequestParam) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchStart(LinkSeamlessRequestParam linkSeamlessRequestParam) {
    }

    public LinkPlatformPresent(@NonNull ILinkPlatformContract.LogicView logicView) {
        this.mLogicView = logicView;
        this.mLogicView.setPresenter(this);
        this.mDataProvider = new LinkSeamlessNaviDataProvider();
        registerAccountObserver();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
        L.i(TAG, "onResume");
        StateManager.getInstance().addListener(this);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
        L.i(TAG, "onPause");
        StateManager.getInstance().removeListener(this);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        super.onDestroy();
        this.mDataProvider.unRegister();
        unRegisterAccountObserver();
    }

    private void registerAccountObserver() {
        AccountObservable.getInstance().addObserver(this);
    }

    public void unRegisterAccountObserver() {
        AccountObservable.getInstance().deleteObserver(this);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.Presenter
    public void initData(int i) {
        this.mPlatformType = i;
        if (258 == i) {
            this.mDataProvider.register();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.Presenter
    public void getUserInfo() {
        if (L.ENABLE) {
            L.d(TAG, "getUserInfo");
        }
        LinkSeamlessGetUserParam linkSeamlessGetUserParam = new LinkSeamlessGetUserParam();
        linkSeamlessGetUserParam.setLinkSemalessType(0);
        linkSeamlessGetUserParam.setSync(true);
        this.mDataProvider.getUserInfo(linkSeamlessGetUserParam, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.Presenter
    public void xpQuickLogin() {
        if (L.ENABLE) {
            L.d(TAG, "xpQuickLogin");
        }
        NaviGuiderStatUtil.loginXpAccountBtn();
        this.mDataProvider.xpQuickLogin();
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.Presenter
    public void requestAmapQrcode() {
        LinkSeamlessGetAmapQrcodeParam linkSeamlessGetAmapQrcodeParam = new LinkSeamlessGetAmapQrcodeParam();
        linkSeamlessGetAmapQrcodeParam.setSync(false);
        linkSeamlessGetAmapQrcodeParam.setLinkSemalessType(6);
        this.mDataProvider.requestAmapQrcode(linkSeamlessGetAmapQrcodeParam, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.Presenter
    public void requestWechatQrcode() {
        L.d(TAG, "requestWechatQrcode");
        LinkSeamlessGetWechatQrcodeParam linkSeamlessGetWechatQrcodeParam = new LinkSeamlessGetWechatQrcodeParam();
        linkSeamlessGetWechatQrcodeParam.setSync(true);
        linkSeamlessGetWechatQrcodeParam.setLinkSemalessType(4);
        this.mDataProvider.getWechatQrcode(linkSeamlessGetWechatQrcodeParam, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.Presenter
    public void unBindAmap() {
        LinkSeamlessUnbindAmapParam linkSeamlessUnbindAmapParam = new LinkSeamlessUnbindAmapParam();
        linkSeamlessUnbindAmapParam.setLinkSemalessType(5);
        linkSeamlessUnbindAmapParam.setSync(false);
        this.mDataProvider.unBindAmap(linkSeamlessUnbindAmapParam, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.Presenter
    public void oneSecBindAmap() {
        if (L.ENABLE) {
            L.d(TAG, "oneSecBindAmap");
        }
        LinkSeamlessOneSecBindParam linkSeamlessOneSecBindParam = new LinkSeamlessOneSecBindParam();
        linkSeamlessOneSecBindParam.setLinkSemalessType(3);
        linkSeamlessOneSecBindParam.setSync(false);
        this.mDataProvider.oneSecBindAmap(linkSeamlessOneSecBindParam, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.Presenter
    public void checkIsAmapAccount() {
        if (L.ENABLE) {
            L.d(TAG, "checkIsAmapAccount");
        }
        LinkSeamlessCheckIsAmapParam linkSeamlessCheckIsAmapParam = new LinkSeamlessCheckIsAmapParam();
        linkSeamlessCheckIsAmapParam.setLinkSemalessType(1);
        linkSeamlessCheckIsAmapParam.setSync(true);
        this.mDataProvider.checkIsAmapAccount(linkSeamlessCheckIsAmapParam, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.Presenter
    public void checkBindAMapStatus() {
        if (L.ENABLE) {
            L.d(TAG, "checkBindAMapStatus");
        }
        LinkSeamlessCheckBindParam linkSeamlessCheckBindParam = new LinkSeamlessCheckBindParam();
        linkSeamlessCheckBindParam.setLinkSemalessType(-1);
        linkSeamlessCheckBindParam.setSync(true);
        this.mDataProvider.checkBindAMapStatus(linkSeamlessCheckBindParam, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.Presenter
    public void exitSence() {
        this.mLogicView.setReturnResult(new Bundle());
        this.mLogicView.goBack();
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.Presenter
    public void getAmapAccount() {
        LinkSeamlessGetAmapAccountParam linkSeamlessGetAmapAccountParam = new LinkSeamlessGetAmapAccountParam();
        linkSeamlessGetAmapAccountParam.setSync(true);
        linkSeamlessGetAmapAccountParam.setLinkSemalessType(7);
        this.mDataProvider.getAmapAccount(linkSeamlessGetAmapAccountParam, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.Presenter
    public void loginByAMapQRCode(AccountAosResult accountAosResult) {
        LinkSeamlessLoginAmapByQrcodeParam linkSeamlessLoginAmapByQrcodeParam = new LinkSeamlessLoginAmapByQrcodeParam(accountAosResult);
        linkSeamlessLoginAmapByQrcodeParam.setSync(false);
        linkSeamlessLoginAmapByQrcodeParam.setLinkSemalessType(8);
        this.mDataProvider.loginByAMapQRCode(linkSeamlessLoginAmapByQrcodeParam, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.Presenter
    public void bindAmap(boolean z) {
        LinkSeamlessBindAmapParam linkSeamlessBindAmapParam = new LinkSeamlessBindAmapParam(z);
        linkSeamlessBindAmapParam.setSync(false);
        linkSeamlessBindAmapParam.setLinkSemalessType(9);
        this.mDataProvider.bindAmap(linkSeamlessBindAmapParam, this);
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataFetched(@NonNull LinkSeamlessBaseData linkSeamlessBaseData) {
        switch (linkSeamlessBaseData.getParamType()) {
            case -1:
                LinkSeamlessBindStatusData linkSeamlessBindStatusData = (LinkSeamlessBindStatusData) linkSeamlessBaseData;
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "onCheckBindAMapStatusSuccess:  " + linkSeamlessBindStatusData.isBind());
                }
                this.mLogicView.onCheckBindAMapStatusSuccess(linkSeamlessBindStatusData.isBind());
                return;
            case 0:
                LinkSeamlessUserInfoData linkSeamlessUserInfoData = (LinkSeamlessUserInfoData) linkSeamlessBaseData;
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, "onGetUserInfoSuccess：" + linkSeamlessUserInfoData.getUserName());
                }
                this.mLogicView.onGetUserInfoSuccess(linkSeamlessUserInfoData.getUserName(), linkSeamlessUserInfoData.isTemp());
                return;
            case 1:
                LinkSeamlessIsAmapData linkSeamlessIsAmapData = (LinkSeamlessIsAmapData) linkSeamlessBaseData;
                if (L.ENABLE) {
                    L.Tag tag3 = TAG;
                    L.d(tag3, "onCheckIsAmapAccountSuccess: " + linkSeamlessIsAmapData.isAccount());
                }
                this.mLogicView.onCheckIsAmapAccountSuccess(linkSeamlessIsAmapData.isAccount());
                return;
            case 2:
            default:
                return;
            case 3:
                if (L.ENABLE) {
                    L.d(TAG, "onOneSecBindSuccess");
                }
                this.mLogicView.onLoginAmapSuccess(((LinkSeamlessLoginAmapData) linkSeamlessBaseData).isLogin(), true);
                return;
            case 4:
                if (L.ENABLE) {
                    L.d(TAG, "onWechatQrCodeSuccess");
                }
                this.mLogicView.onWechatQrCodeSuccess(((LinkSeamlessWechatQrCodeData) linkSeamlessBaseData).getQrCode());
                return;
            case 5:
                this.mLogicView.onCheckBindAMapStatusSuccess(((LinkSeamlessBindStatusData) linkSeamlessBaseData).isBind());
                return;
            case 6:
                this.mLogicView.onAmapQrCodeSuccess(((LinkSeamlessAmapQrcodeData) linkSeamlessBaseData).getEvent());
                return;
            case 7:
                this.mLogicView.onAmapAccountSuccess(((LinkSeamlessAmapAccountData) linkSeamlessBaseData).getNickName());
                return;
            case 8:
                this.mLogicView.onLoginAmapSuccess(((LinkSeamlessLoginAmapData) linkSeamlessBaseData).isLogin(), false);
                return;
            case 9:
                this.mLogicView.onBindAmapSuccess(((LinkSeamlessBindStatusData) linkSeamlessBaseData).isBind());
                return;
        }
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onError(int i, @NonNull String str) {
        if (i != 105) {
            if (i != 600) {
                switch (i) {
                    case 100:
                        break;
                    case 101:
                        this.mLogicView.onUnbindAmapFailed();
                        return;
                    case 102:
                        this.mLogicView.onRequestWechatFailed();
                        return;
                    case 103:
                        this.mLogicView.onLoginAMapFail();
                        return;
                    default:
                        if (L.ENABLE) {
                            L.Tag tag = TAG;
                            L.d(tag, "errprCode: " + i);
                            return;
                        }
                        return;
                }
            } else {
                this.mLogicView.onDataFetchTimeout();
                return;
            }
        }
        this.mLogicView.onBindAmapFailed();
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public boolean isLegal() {
        return this.mLogicView.isSceneLegal();
    }

    @Override // com.xiaopeng.montecarlo.navcore.state.IStateListener
    public void onStateChange(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onStateChange state:" + i);
        }
        ILinkPlatformContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            MapStateChangeStatUtil.sendStatData(logicView.getMainContext(), i);
            if (i == 0) {
                this.mLogicView.onStateActive();
            } else if (i == 1) {
                this.mLogicView.onStateImmersion();
            }
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        UserInfo userInfo = (UserInfo) obj;
        if (userInfo == null || userInfo.getInfoType() != UserInfo.InfoType.CHANGED) {
            return;
        }
        String userName = userInfo.getUserName();
        UserInfo.UserType userType = userInfo.getUserType();
        SettingStatUtil.sendStatDataMsgLoginXPAccount(userType != UserInfo.UserType.TEMP);
        this.mLogicView.onLoginSuccess(userName, userType == UserInfo.UserType.TEMP);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        if (speechNaviEvent.what == 312) {
            L.Tag tag = TAG;
            L.i(tag, "SPEECH_ROUTE_NEW_DEST_WITH_VIAS, isSceneLegal:" + this.mLogicView.isSceneLegal());
            if (this.mLogicView.isSceneLegal()) {
                this.mLogicView.getSpeechEventBizHelper().routeNewDestWithVias(this.mLogicView.getMainContext().getCurrentScene(), speechNaviEvent);
                return true;
            }
        }
        return false;
    }
}
