package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkQRCodeContract;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessNaviDataProvider;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessRequestParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessAmapQrcodeData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessWechatQrCodeData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessGetAmapQrcodeParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessGetWechatQrcodeParam;
/* loaded from: classes2.dex */
public class LinkQRCodePresenter implements ILinkQRCodeContract.Presenter, BaseCallBack<LinkSeamlessRequestParam, LinkSeamlessBaseData> {
    private static final L.Tag TAG = new L.Tag("LinkQRCodePresenter");
    private LinkSeamlessNaviDataProvider mDataProvider = new LinkSeamlessNaviDataProvider();
    private ILinkQRCodeContract.LogicView mLogicView;

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public boolean isLegal() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataCache(@NonNull LinkSeamlessBaseData linkSeamlessBaseData) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onError(int i, @NonNull String str) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchComplete(LinkSeamlessRequestParam linkSeamlessRequestParam) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchStart(LinkSeamlessRequestParam linkSeamlessRequestParam) {
    }

    public LinkQRCodePresenter(ILinkQRCodeContract.LogicView logicView) {
        this.mLogicView = logicView;
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkQRCodeContract.Presenter
    public void requestAmapQRCode() {
        LinkSeamlessGetAmapQrcodeParam linkSeamlessGetAmapQrcodeParam = new LinkSeamlessGetAmapQrcodeParam();
        linkSeamlessGetAmapQrcodeParam.setSync(false);
        linkSeamlessGetAmapQrcodeParam.setLinkSemalessType(6);
        this.mDataProvider.requestAmapQrcode(linkSeamlessGetAmapQrcodeParam, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkQRCodeContract.Presenter
    public void requestWechatQRCode() {
        LinkSeamlessGetWechatQrcodeParam linkSeamlessGetWechatQrcodeParam = new LinkSeamlessGetWechatQrcodeParam();
        linkSeamlessGetWechatQrcodeParam.setSync(true);
        linkSeamlessGetWechatQrcodeParam.setLinkSemalessType(4);
        this.mDataProvider.getWechatQrcode(linkSeamlessGetWechatQrcodeParam, this);
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataFetched(@NonNull LinkSeamlessBaseData linkSeamlessBaseData) {
        int paramType = linkSeamlessBaseData.getParamType();
        if (paramType == 4) {
            this.mLogicView.onWechatQRCodeSuccess(((LinkSeamlessWechatQrCodeData) linkSeamlessBaseData).getQrCode());
        } else if (paramType != 6) {
        } else {
            this.mLogicView.onAmapQRCodeSuccess(((LinkSeamlessAmapQrcodeData) linkSeamlessBaseData).getEvent());
        }
    }
}
