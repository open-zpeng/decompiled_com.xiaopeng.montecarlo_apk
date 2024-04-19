package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.autonavi.gbl.aosclient.model.BLAosCookie;
import com.autonavi.gbl.user.account.model.AccountProfile;
import com.autonavi.gbl.user.account.model.AccountProfileResult;
import com.autonavi.gbl.user.account.model.QRCodeLoginResult;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.account.CompositeRxAction;
import com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.aos.AosServiceWrapper;
import com.xiaopeng.montecarlo.navcore.event.AccountEvent;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IBizVehicleService;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.BizWeixinQrTicketResponse;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderException;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
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
import com.xiaopeng.montecarlo.stat.NaviGuiderStatUtil;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import io.reactivex.annotations.NonNull;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class LinkSeamlessNaviDataProvider extends BaseDataProvider<BaseResultData, LinkSeamlessRequestParam, BaseCallBack> {
    public static final int BIND_ERROR = 100;
    public static final int LOGIN_BY_AMAP_ERROR = 103;
    public static final int REQUEST_AMAP_ERROR = 104;
    public static final int REQUEST_ONE_SECOND_ERROR = 105;
    public static final int REQUEST_WECHAT_ERROR = 102;
    private static final L.Tag TAG = new L.Tag("LinkProvider");
    public static final int UNBIND_ERROR = 101;
    private ConcurrentHashMap<Integer, LinkSeamlessBaseData> mResponseMap = new ConcurrentHashMap<>();
    private IBizVehicleService mBizVehicleService = (IBizVehicleService) HttpClientManager.getInstance().getService(IBizVehicleService.class);
    private final CompositeRxAction mRxAction = new CompositeRxAction();

    private DataProviderResponse xpQuickLogin(LinkSeamlessRequestParam linkSeamlessRequestParam) {
        return null;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    protected String getErrorMessage(int i) {
        return null;
    }

    public void register() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public DataProviderResponse fetchDataDelegate(LinkSeamlessRequestParam linkSeamlessRequestParam) throws DataProviderException {
        switch (linkSeamlessRequestParam.getLinkSemalessType()) {
            case -1:
                return checkBindAMapStatus(linkSeamlessRequestParam);
            case 0:
                return getUserInfo(linkSeamlessRequestParam);
            case 1:
                return checkIsAmapAccount(linkSeamlessRequestParam);
            case 2:
            default:
                return null;
            case 3:
                return oneSecBindAmap(linkSeamlessRequestParam);
            case 4:
                return getWechatQrcode(linkSeamlessRequestParam);
            case 5:
                return unBindAmap(linkSeamlessRequestParam);
            case 6:
                return requestAmapQrcode(linkSeamlessRequestParam);
            case 7:
                return getAmapAccount(linkSeamlessRequestParam);
            case 8:
                return loginByAMapQRCode(linkSeamlessRequestParam);
            case 9:
                return bindAmap(linkSeamlessRequestParam);
        }
    }

    public void bindAmap(LinkSeamlessBindAmapParam linkSeamlessBindAmapParam, BaseCallBack baseCallBack) {
        doFetchData(linkSeamlessBindAmapParam, baseCallBack);
    }

    private DataProviderResponse bindAmap(final LinkSeamlessRequestParam linkSeamlessRequestParam) {
        if (L.ENABLE) {
            L.d(TAG, "bindmap");
        }
        if (!(linkSeamlessRequestParam instanceof LinkSeamlessBindAmapParam)) {
            throw new IllegalArgumentException("not LinkSeamlessBindAmapParam");
        }
        final LinkSeamlessBindAmapParam linkSeamlessBindAmapParam = (LinkSeamlessBindAmapParam) linkSeamlessRequestParam;
        this.mRxAction.addSubscription(AccountManager.getInstance().createBindAMapObservable(), new BaseAccountObserver<Boolean>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessNaviDataProvider.1
            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver
            public void onSuccess(@NonNull Boolean bool) {
                if (linkSeamlessBindAmapParam.isQuickLogin()) {
                    SettingStatUtil.sendStatDataMatchAmapAccountQuickBinded(1);
                } else {
                    SettingStatUtil.sendStatDataUnmatchAmapAccountQuickBinded(1);
                }
                AccountManager.getInstance().getAMapAccountInfoAndSync();
                LinkSeamlessBindStatusData linkSeamlessBindStatusData = new LinkSeamlessBindStatusData();
                linkSeamlessBindStatusData.setBind(true);
                linkSeamlessBindStatusData.setIsSuccess(true);
                linkSeamlessBindStatusData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
                LinkSeamlessNaviDataProvider.this.mResponseMap.put(Integer.valueOf(linkSeamlessRequestParam.getTaskId()), linkSeamlessBindStatusData);
                LinkSeamlessNaviDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }

            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver, io.reactivex.Observer
            public void onError(@NonNull Throwable th) {
                if (L.ENABLE) {
                    L.d(LinkSeamlessNaviDataProvider.TAG, "bindAmap  onFail");
                }
                if (linkSeamlessBindAmapParam.isQuickLogin()) {
                    SettingStatUtil.sendStatDataMatchAmapAccountQuickBinded(0);
                } else {
                    SettingStatUtil.sendStatDataUnmatchAmapAccountQuickBinded(0);
                }
                SettingStatUtil.sendStatDataBindAmap(3);
                LinkSeamlessBindStatusData linkSeamlessBindStatusData = new LinkSeamlessBindStatusData();
                linkSeamlessBindStatusData.setIsSuccess(false);
                linkSeamlessBindStatusData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
                LinkSeamlessNaviDataProvider.this.mResponseMap.put(Integer.valueOf(linkSeamlessRequestParam.getTaskId()), linkSeamlessBindStatusData);
                LinkSeamlessNaviDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }
        });
        lockParam(linkSeamlessRequestParam);
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        LinkSeamlessBindStatusData linkSeamlessBindStatusData = (LinkSeamlessBindStatusData) this.mResponseMap.remove(Integer.valueOf(linkSeamlessRequestParam.getTaskId()));
        if (linkSeamlessBindStatusData != null && linkSeamlessBindStatusData.isSuccess()) {
            linkSeamlessBindStatusData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
            dataProviderResponse.setResultData(linkSeamlessBindStatusData);
        } else {
            dataProviderResponse.setErrorCode(100);
        }
        return dataProviderResponse;
    }

    public void loginByAMapQRCode(LinkSeamlessLoginAmapByQrcodeParam linkSeamlessLoginAmapByQrcodeParam, BaseCallBack baseCallBack) {
        doFetchData(linkSeamlessLoginAmapByQrcodeParam, baseCallBack);
    }

    private DataProviderResponse loginByAMapQRCode(final LinkSeamlessRequestParam linkSeamlessRequestParam) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bindmap loginByAMapQRCode start  param  tashId:  " + linkSeamlessRequestParam.getTaskId() + "  ===>param object :  " + Integer.toHexString(linkSeamlessRequestParam.hashCode()));
        }
        if (!(linkSeamlessRequestParam instanceof LinkSeamlessLoginAmapByQrcodeParam)) {
            throw new IllegalArgumentException("not LinkSeamlessLoginAmapByQrcodeParam");
        }
        this.mRxAction.addSubscription(AccountManager.getInstance().queryAMapQRLoginResult((QRCodeLoginResult) ((LinkSeamlessLoginAmapByQrcodeParam) linkSeamlessRequestParam).getResult()), new BaseAccountObserver<Boolean>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessNaviDataProvider.2
            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver
            public void onSuccess(@NonNull Boolean bool) {
                BLAosCookie cookie = AosServiceWrapper.getInstance().getCookie();
                if (L.ENABLE) {
                    L.Tag tag2 = LinkSeamlessNaviDataProvider.TAG;
                    L.d(tag2, "bindmap  loginByAMapQRCode onSuccess ，blAosCookie=" + GsonUtil.toJson(cookie));
                }
                LinkSeamlessLoginAmapData linkSeamlessLoginAmapData = new LinkSeamlessLoginAmapData();
                if (cookie != null && !TextUtils.isEmpty(cookie.mCookie)) {
                    linkSeamlessLoginAmapData.setLogin(true);
                    LinkSeamlessNaviDataProvider.this.mResponseMap.put(Integer.valueOf(linkSeamlessRequestParam.getTaskId()), linkSeamlessLoginAmapData);
                    SettingStatUtil.sendStatDataUnmatchAmapAccountQuickBinded(2);
                } else {
                    linkSeamlessLoginAmapData.setLogin(false);
                    LinkSeamlessNaviDataProvider.this.mResponseMap.put(Integer.valueOf(linkSeamlessRequestParam.getTaskId()), linkSeamlessLoginAmapData);
                }
                linkSeamlessLoginAmapData.setIsSuccess(true);
                LinkSeamlessNaviDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }

            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver, io.reactivex.Observer
            public void onError(@NonNull Throwable th) {
                LinkSeamlessLoginAmapData linkSeamlessLoginAmapData = new LinkSeamlessLoginAmapData();
                linkSeamlessLoginAmapData.setIsSuccess(false);
                LinkSeamlessNaviDataProvider.this.mResponseMap.put(Integer.valueOf(linkSeamlessRequestParam.getTaskId()), linkSeamlessLoginAmapData);
                LinkSeamlessNaviDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }
        });
        lockParam(linkSeamlessRequestParam);
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "remove  param  tashId:" + linkSeamlessRequestParam.getTaskId() + "   =====>param object: " + Integer.toHexString(linkSeamlessRequestParam.hashCode()));
        }
        LinkSeamlessLoginAmapData linkSeamlessLoginAmapData = (LinkSeamlessLoginAmapData) this.mResponseMap.remove(Integer.valueOf(linkSeamlessRequestParam.getTaskId()));
        if (linkSeamlessLoginAmapData != null && linkSeamlessLoginAmapData.isSuccess()) {
            linkSeamlessLoginAmapData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
            dataProviderResponse.setResultData(linkSeamlessLoginAmapData);
        } else {
            dataProviderResponse.setErrorCode(103);
        }
        return dataProviderResponse;
    }

    public void getAmapAccount(LinkSeamlessGetAmapAccountParam linkSeamlessGetAmapAccountParam, BaseCallBack baseCallBack) {
        doFetchData(linkSeamlessGetAmapAccountParam, baseCallBack);
    }

    private DataProviderResponse getAmapAccount(final LinkSeamlessRequestParam linkSeamlessRequestParam) {
        if (L.ENABLE) {
            L.d(TAG, "bindmap getAmapAccount");
        }
        if (!(linkSeamlessRequestParam instanceof LinkSeamlessGetAmapAccountParam)) {
            throw new IllegalArgumentException("not LinkSeamlessGetAmapAccountParam");
        }
        final String[] strArr = {""};
        String blAccountProfile = SettingWrapper.getBlAccountProfile();
        if (!TextUtils.isEmpty(blAccountProfile)) {
            strArr[0] = ((AccountProfile) GsonUtil.fromJson(blAccountProfile, (Class<Object>) AccountProfile.class)).nickname;
        } else {
            this.mRxAction.addSubscription(AccountManager.getInstance().getAMapAccountInfo(), new BaseAccountObserver<AccountProfileResult>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessNaviDataProvider.3
                @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver
                public void onSuccess(@NonNull AccountProfileResult accountProfileResult) {
                    strArr[0] = accountProfileResult.profile.nickname;
                    LinkSeamlessNaviDataProvider.this.notifyParam(linkSeamlessRequestParam);
                }

                @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver, io.reactivex.Observer
                public void onError(@NonNull Throwable th) {
                    LinkSeamlessNaviDataProvider.this.notifyParam(linkSeamlessRequestParam);
                }
            });
            lockParam(linkSeamlessRequestParam);
        }
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        LinkSeamlessAmapAccountData linkSeamlessAmapAccountData = new LinkSeamlessAmapAccountData();
        linkSeamlessAmapAccountData.setNickName(strArr[0]);
        linkSeamlessAmapAccountData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
        dataProviderResponse.setResultData(linkSeamlessAmapAccountData);
        return dataProviderResponse;
    }

    public void requestAmapQrcode(LinkSeamlessGetAmapQrcodeParam linkSeamlessGetAmapQrcodeParam, BaseCallBack baseCallBack) {
        doFetchData(linkSeamlessGetAmapQrcodeParam, baseCallBack);
    }

    private DataProviderResponse requestAmapQrcode(final LinkSeamlessRequestParam linkSeamlessRequestParam) {
        if (L.ENABLE) {
            L.d(TAG, "requestAmapQrcode");
        }
        if (!(linkSeamlessRequestParam instanceof LinkSeamlessGetAmapQrcodeParam)) {
            throw new IllegalArgumentException("not LinkSeamlessGetAmapQrcodeParam");
        }
        this.mRxAction.addSubscription(AccountManager.getInstance().getAMapQRCode(), new BaseAccountObserver<AccountEvent>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessNaviDataProvider.4
            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver
            public void onSuccess(@NonNull AccountEvent accountEvent) {
                if (L.ENABLE) {
                    L.d(LinkSeamlessNaviDataProvider.TAG, "requestAmapQrcode  onSuccess");
                }
                LinkSeamlessAmapQrcodeData linkSeamlessAmapQrcodeData = new LinkSeamlessAmapQrcodeData();
                linkSeamlessAmapQrcodeData.setEvent(accountEvent);
                linkSeamlessAmapQrcodeData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
                linkSeamlessAmapQrcodeData.setIsSuccess(true);
                SettingStatUtil.sendStatDataDailogAmapQrcode();
                LinkSeamlessNaviDataProvider.this.mResponseMap.put(Integer.valueOf(linkSeamlessRequestParam.getTaskId()), linkSeamlessAmapQrcodeData);
                LinkSeamlessNaviDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }

            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver, io.reactivex.Observer
            public void onError(@NonNull Throwable th) {
                if (L.ENABLE) {
                    L.d(LinkSeamlessNaviDataProvider.TAG, "requestAmapQrcode  onFail");
                }
                LinkSeamlessAmapQrcodeData linkSeamlessAmapQrcodeData = new LinkSeamlessAmapQrcodeData();
                linkSeamlessAmapQrcodeData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
                linkSeamlessAmapQrcodeData.setIsSuccess(false);
                LinkSeamlessNaviDataProvider.this.mResponseMap.put(Integer.valueOf(linkSeamlessRequestParam.getTaskId()), linkSeamlessAmapQrcodeData);
                LinkSeamlessNaviDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }
        });
        lockParam(linkSeamlessRequestParam);
        LinkSeamlessAmapQrcodeData linkSeamlessAmapQrcodeData = (LinkSeamlessAmapQrcodeData) this.mResponseMap.remove(Integer.valueOf(linkSeamlessRequestParam.getTaskId()));
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        if (linkSeamlessAmapQrcodeData != null && linkSeamlessAmapQrcodeData.isSuccess()) {
            linkSeamlessAmapQrcodeData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
            dataProviderResponse.setResultData(linkSeamlessAmapQrcodeData);
        } else {
            dataProviderResponse.setErrorCode(104);
        }
        return dataProviderResponse;
    }

    public void unBindAmap(LinkSeamlessUnbindAmapParam linkSeamlessUnbindAmapParam, BaseCallBack baseCallBack) {
        doFetchData(linkSeamlessUnbindAmapParam, baseCallBack);
    }

    private DataProviderResponse unBindAmap(final LinkSeamlessRequestParam linkSeamlessRequestParam) {
        if (L.ENABLE) {
            L.d(TAG, "bindmap unBindAmap");
        }
        if (!(linkSeamlessRequestParam instanceof LinkSeamlessUnbindAmapParam)) {
            throw new IllegalArgumentException("not LinkSeamlessUnbindAmapParam");
        }
        this.mRxAction.addSubscription(AccountManager.getInstance().createUnBindAMapObservable(), new BaseAccountObserver<Boolean>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessNaviDataProvider.5
            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver
            public void onSuccess(@NonNull Boolean bool) {
                LinkSeamlessBindStatusData linkSeamlessBindStatusData = new LinkSeamlessBindStatusData();
                linkSeamlessBindStatusData.setBind(false);
                linkSeamlessBindStatusData.setIsSuccess(true);
                LinkSeamlessNaviDataProvider.this.mResponseMap.put(Integer.valueOf(linkSeamlessRequestParam.getTaskId()), linkSeamlessBindStatusData);
                LinkSeamlessNaviDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }

            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver, io.reactivex.Observer
            public void onError(@NonNull Throwable th) {
                if (L.ENABLE) {
                    L.d(LinkSeamlessNaviDataProvider.TAG, "bindmap unBindAmap error ");
                }
                LinkSeamlessBindStatusData linkSeamlessBindStatusData = new LinkSeamlessBindStatusData();
                linkSeamlessBindStatusData.setIsSuccess(false);
                LinkSeamlessNaviDataProvider.this.mResponseMap.put(Integer.valueOf(linkSeamlessRequestParam.getTaskId()), linkSeamlessBindStatusData);
                SettingStatUtil.sendStatDataBindAmap(7);
                LinkSeamlessNaviDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }
        });
        lockParam(linkSeamlessRequestParam);
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        LinkSeamlessBindStatusData linkSeamlessBindStatusData = (LinkSeamlessBindStatusData) this.mResponseMap.remove(Integer.valueOf(linkSeamlessRequestParam.getTaskId()));
        if (linkSeamlessBindStatusData != null && linkSeamlessBindStatusData.isSuccess()) {
            linkSeamlessBindStatusData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
            dataProviderResponse.setResultData(linkSeamlessBindStatusData);
        } else {
            dataProviderResponse.setErrorCode(101);
        }
        return dataProviderResponse;
    }

    public void getWechatQrcode(LinkSeamlessGetWechatQrcodeParam linkSeamlessGetWechatQrcodeParam, BaseCallBack baseCallBack) {
        doFetchData(linkSeamlessGetWechatQrcodeParam, baseCallBack);
    }

    private DataProviderResponse getWechatQrcode(LinkSeamlessRequestParam linkSeamlessRequestParam) {
        if (L.ENABLE) {
            L.d(TAG, "requestWechatQrcode");
        }
        if (!(linkSeamlessRequestParam instanceof LinkSeamlessGetWechatQrcodeParam)) {
            throw new IllegalArgumentException("not LinkSeamlessGetWechatQrcodeParam");
        }
        String string = DataSetHelper.AccountSet.getString(DataSetHelper.AccountSet.ACCOUNT_CONFIG_WECHAT_QRCODE, "");
        LinkSeamlessWechatQrCodeData linkSeamlessWechatQrCodeData = new LinkSeamlessWechatQrCodeData();
        if (TextUtils.isEmpty(string)) {
            BizWeixinQrTicketResponse weixinQrTicket = this.mBizVehicleService.getWeixinQrTicket();
            if (weixinQrTicket != null) {
                String qrTicket = weixinQrTicket.getQrTicket();
                if (qrTicket != null && !"null".equals(qrTicket)) {
                    if (L.ENABLE) {
                        L.Tag tag = TAG;
                        L.d(tag, "requestWechatQrcode onSuccess data:" + qrTicket);
                    }
                    string = saveWechatData(qrTicket);
                    linkSeamlessWechatQrCodeData.setIsSuccess(true);
                } else {
                    if (L.ENABLE) {
                        L.d(TAG, "requestWechatQrcode onFail  data  is null");
                    }
                    linkSeamlessWechatQrCodeData.setIsSuccess(false);
                }
            } else {
                if (L.ENABLE) {
                    L.d(TAG, "requestWechatQrcode onFail:  response is null");
                }
                linkSeamlessWechatQrCodeData.setIsSuccess(false);
            }
        } else {
            if (L.ENABLE) {
                L.d(TAG, "requestWechatQrcode is exist  in SQL");
            }
            linkSeamlessWechatQrCodeData.setIsSuccess(true);
        }
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        linkSeamlessWechatQrCodeData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
        if (linkSeamlessWechatQrCodeData.isSuccess()) {
            linkSeamlessWechatQrCodeData.setQrCode(string);
            dataProviderResponse.setResultData(linkSeamlessWechatQrCodeData);
        } else {
            dataProviderResponse.setErrorCode(102);
        }
        return dataProviderResponse;
    }

    private String saveWechatData(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Spanned fromHtml = Html.fromHtml(str);
        if (TextUtils.isEmpty(fromHtml)) {
            return "";
        }
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.ACCOUNT_CONFIG_WECHAT_QRCODE, fromHtml.toString());
        return fromHtml.toString();
    }

    public void oneSecBindAmap(LinkSeamlessOneSecBindParam linkSeamlessOneSecBindParam, BaseCallBack baseCallBack) {
        doFetchData(linkSeamlessOneSecBindParam, baseCallBack);
    }

    private DataProviderResponse oneSecBindAmap(final LinkSeamlessRequestParam linkSeamlessRequestParam) {
        if (L.ENABLE) {
            L.d(TAG, "oneSecBindAmap");
        }
        if (!(linkSeamlessRequestParam instanceof LinkSeamlessOneSecBindParam)) {
            throw new IllegalArgumentException("not LinkSeamlessOneSecBindParam");
        }
        this.mRxAction.addSubscription(AccountManager.getInstance().quickLogin(), new BaseAccountObserver<Boolean>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessNaviDataProvider.6
            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver
            public void onSuccess(@NonNull Boolean bool) {
                L.i(LinkSeamlessNaviDataProvider.TAG, "bindmap oneSecBindAmap---onSuccess");
                SettingStatUtil.sendStatDataMatchAmapAccountQuickBinded(1);
                AccountManager.getInstance().getAMapAccountInfoAndSync();
                LinkSeamlessLoginAmapData linkSeamlessLoginAmapData = new LinkSeamlessLoginAmapData();
                linkSeamlessLoginAmapData.setLogin(true);
                linkSeamlessLoginAmapData.setIsSuccess(true);
                linkSeamlessLoginAmapData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
                LinkSeamlessNaviDataProvider.this.mResponseMap.put(Integer.valueOf(linkSeamlessRequestParam.getTaskId()), linkSeamlessLoginAmapData);
                LinkSeamlessNaviDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }

            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver, io.reactivex.Observer
            public void onError(@NonNull Throwable th) {
                LinkSeamlessLoginAmapData linkSeamlessLoginAmapData = new LinkSeamlessLoginAmapData();
                linkSeamlessLoginAmapData.setIsSuccess(false);
                LinkSeamlessNaviDataProvider.this.mResponseMap.put(Integer.valueOf(linkSeamlessRequestParam.getTaskId()), linkSeamlessLoginAmapData);
                SettingStatUtil.sendStatDataMatchAmapAccountQuickBinded(0);
                LinkSeamlessNaviDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }
        });
        lockParam(linkSeamlessRequestParam);
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        LinkSeamlessLoginAmapData linkSeamlessLoginAmapData = (LinkSeamlessLoginAmapData) this.mResponseMap.remove(Integer.valueOf(linkSeamlessRequestParam.getTaskId()));
        if (linkSeamlessLoginAmapData != null && linkSeamlessLoginAmapData.isSuccess()) {
            linkSeamlessLoginAmapData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
            dataProviderResponse.setResultData(linkSeamlessLoginAmapData);
        } else {
            dataProviderResponse.setErrorCode(105);
        }
        return dataProviderResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyParam(LinkSeamlessRequestParam linkSeamlessRequestParam) {
        synchronized (linkSeamlessRequestParam) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "notify  param  tashId:" + linkSeamlessRequestParam.getTaskId() + "   =====>param object: " + Integer.toHexString(linkSeamlessRequestParam.hashCode()));
            }
            linkSeamlessRequestParam.notify();
        }
    }

    private void lockParam(LinkSeamlessRequestParam linkSeamlessRequestParam) {
        synchronized (linkSeamlessRequestParam) {
            try {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "lock    param  tashId:" + linkSeamlessRequestParam.getTaskId() + "   =====>param object: " + Integer.toHexString(linkSeamlessRequestParam.hashCode()));
                }
                linkSeamlessRequestParam.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void xpQuickLogin() {
        XPAccountServiceWrapper.getInstance().login();
    }

    public void checkIsAmapAccount(LinkSeamlessCheckIsAmapParam linkSeamlessCheckIsAmapParam, BaseCallBack baseCallBack) {
        doFetchData(linkSeamlessCheckIsAmapParam, baseCallBack);
    }

    private DataProviderResponse checkIsAmapAccount(final LinkSeamlessRequestParam linkSeamlessRequestParam) {
        if (L.ENABLE) {
            L.d(TAG, "checkIsAmapAccount");
        }
        if (!(linkSeamlessRequestParam instanceof LinkSeamlessCheckIsAmapParam)) {
            throw new IllegalArgumentException("not LinkSeamlessCheckIsAmapParam");
        }
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        LinkSeamlessIsAmapData linkSeamlessIsAmapData = new LinkSeamlessIsAmapData();
        this.mRxAction.addSubscription(AccountManager.getInstance().createCheckIsAMapObservable(), new BaseAccountObserver<Boolean>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessNaviDataProvider.7
            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver
            public void onSuccess(@NonNull Boolean bool) {
                LinkSeamlessNaviDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }

            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver, io.reactivex.Observer
            public void onError(@NonNull Throwable th) {
                LinkSeamlessNaviDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }
        });
        lockParam(linkSeamlessRequestParam);
        boolean isAMapAccount = SettingWrapper.isAMapAccount();
        NaviGuiderStatUtil.bIIsAmapAccount(isAMapAccount);
        linkSeamlessIsAmapData.setAccount(isAMapAccount);
        linkSeamlessIsAmapData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
        dataProviderResponse.setResultData(linkSeamlessIsAmapData);
        return dataProviderResponse;
    }

    public void getUserInfo(LinkSeamlessGetUserParam linkSeamlessGetUserParam, BaseCallBack baseCallBack) {
        doFetchData(linkSeamlessGetUserParam, baseCallBack);
    }

    private DataProviderResponse getUserInfo(LinkSeamlessRequestParam linkSeamlessRequestParam) {
        if (L.ENABLE) {
            L.d(TAG, "getUserInfo");
        }
        if (!(linkSeamlessRequestParam instanceof LinkSeamlessGetUserParam)) {
            throw new IllegalArgumentException("not LinkSeamlessGetUserParam");
        }
        XPAccountServiceWrapper xPAccountServiceWrapper = XPAccountServiceWrapper.getInstance();
        UserInfo userInfo = xPAccountServiceWrapper.getUserInfo();
        boolean isTempType = xPAccountServiceWrapper.isTempType();
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        LinkSeamlessUserInfoData linkSeamlessUserInfoData = new LinkSeamlessUserInfoData();
        if (userInfo != null) {
            linkSeamlessUserInfoData.setUserName(userInfo.getUserName());
        } else {
            linkSeamlessUserInfoData.setUserName("");
        }
        linkSeamlessUserInfoData.setTemp(isTempType);
        linkSeamlessUserInfoData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
        dataProviderResponse.setResultData(linkSeamlessUserInfoData);
        return dataProviderResponse;
    }

    public void checkBindAMapStatus(LinkSeamlessCheckBindParam linkSeamlessCheckBindParam, BaseCallBack baseCallBack) {
        doFetchData(linkSeamlessCheckBindParam, baseCallBack);
    }

    @VisibleForTesting
    protected DataProviderResponse checkBindAMapStatus(LinkSeamlessRequestParam linkSeamlessRequestParam) {
        if (L.ENABLE) {
            L.d(TAG, "checkBindAMapStatus");
        }
        if (!(linkSeamlessRequestParam instanceof LinkSeamlessCheckBindParam)) {
            throw new IllegalArgumentException("not LinkSeamlessCheckBindParam");
        }
        boolean bindAMapStatus = SettingWrapper.getBindAMapStatus();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "checkBindAMapStatus  isBind == " + bindAMapStatus);
        }
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        LinkSeamlessBindStatusData linkSeamlessBindStatusData = new LinkSeamlessBindStatusData();
        linkSeamlessBindStatusData.setBind(bindAMapStatus);
        linkSeamlessBindStatusData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
        dataProviderResponse.setResultData(linkSeamlessBindStatusData);
        return dataProviderResponse;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public void onFetchStart(LinkSeamlessRequestParam linkSeamlessRequestParam) {
        super.onFetchStart((LinkSeamlessNaviDataProvider) linkSeamlessRequestParam);
        if (linkSeamlessRequestParam.isSync()) {
            return;
        }
        updateTashId(linkSeamlessRequestParam);
    }

    private void updateTashId(LinkSeamlessRequestParam linkSeamlessRequestParam) {
        linkSeamlessRequestParam.setTaskId((int) System.currentTimeMillis());
    }

    public void unRegister() {
        this.mRxAction.unSubscribe();
    }
}
