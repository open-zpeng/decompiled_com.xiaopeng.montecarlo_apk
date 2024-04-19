package com.xiaopeng.montecarlo.views.dialog;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessRequestParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBindStatusData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessLoginAmapData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessBindAmapParam;
/* loaded from: classes3.dex */
public class DialogPresenter implements BaseCallBack<LinkSeamlessRequestParam, LinkSeamlessBaseData> {
    private static final L.Tag TAG = new L.Tag("DialogPresenter");
    private IDialogDataProvider mDataProvider = new DialogDataProvider();
    private XBindAmapDialog mDialog;

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public boolean isLegal() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataCache(@NonNull LinkSeamlessBaseData linkSeamlessBaseData) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchComplete(LinkSeamlessRequestParam linkSeamlessRequestParam) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchStart(LinkSeamlessRequestParam linkSeamlessRequestParam) {
    }

    public DialogPresenter(XBindAmapDialog xBindAmapDialog) {
        this.mDialog = xBindAmapDialog;
    }

    public void secBindAMap() {
        this.mDataProvider.fetchSecBindAMap(this);
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataFetched(@NonNull LinkSeamlessBaseData linkSeamlessBaseData) {
        LinkSeamlessBindStatusData linkSeamlessBindStatusData;
        int paramType = linkSeamlessBaseData.getParamType();
        if (paramType == 3) {
            if (L.ENABLE) {
                L.d(TAG, "onOneSecBindSuccess");
            }
            if (((LinkSeamlessLoginAmapData) linkSeamlessBaseData).isLogin()) {
                bindAmap();
            }
        } else if (paramType == 9 && (linkSeamlessBindStatusData = (LinkSeamlessBindStatusData) linkSeamlessBaseData) != null && linkSeamlessBindStatusData.isBind()) {
            this.mDialog.onSuccessBindAMap();
        }
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onError(int i, @NonNull String str) {
        if (i != 100) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "errprCode: " + i);
            }
            this.mDialog.onFailBindAMap();
        }
    }

    private void bindAmap() {
        LinkSeamlessBindAmapParam linkSeamlessBindAmapParam = new LinkSeamlessBindAmapParam(true);
        linkSeamlessBindAmapParam.setSync(false);
        linkSeamlessBindAmapParam.setLinkSemalessType(9);
        this.mDataProvider.bindAmap(linkSeamlessBindAmapParam, this);
    }
}
