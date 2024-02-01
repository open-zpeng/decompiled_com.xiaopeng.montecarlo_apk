package com.xiaopeng.montecarlo.views.dialog;

import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider;
import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderException;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessRequestParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBindStatusData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessLoginAmapData;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessBindAmapParam;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessOneSecBindParam;
import com.xiaopeng.montecarlo.stat.SearchStatUtil;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import io.reactivex.annotations.NonNull;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class DialogDataProvider extends BaseDataProvider<BaseResultData, LinkSeamlessRequestParam, BaseCallBack> implements IDialogDataProvider {
    public static final int BIND_ERROR = 100;
    private static final L.Tag TAG = new L.Tag("DialogDataProvider");
    private ConcurrentHashMap<Integer, LinkSeamlessBaseData> mResponseMap = new ConcurrentHashMap<>();

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    protected String getErrorMessage(int i) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public DataProviderResponse fetchDataDelegate(LinkSeamlessRequestParam linkSeamlessRequestParam) throws DataProviderException {
        int linkSemalessType = linkSeamlessRequestParam.getLinkSemalessType();
        if (linkSemalessType != 3) {
            if (linkSemalessType != 9) {
                return null;
            }
            return bindAmap(linkSeamlessRequestParam);
        }
        return oneSecBindAmap(linkSeamlessRequestParam);
    }

    private void lockParam(BaseParameter baseParameter) {
        synchronized (baseParameter) {
            try {
                baseParameter.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private DataProviderResponse oneSecBindAmap(final LinkSeamlessRequestParam linkSeamlessRequestParam) {
        L.d(TAG, "oneSecBindAmap");
        if (!(linkSeamlessRequestParam instanceof LinkSeamlessOneSecBindParam)) {
            throw new IllegalArgumentException("not LinkSeamlessOneSecBindParam");
        }
        AccountManager.getInstance().quickLogin().subscribe(new BaseAccountObserver<Boolean>() { // from class: com.xiaopeng.montecarlo.views.dialog.DialogDataProvider.1
            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver
            public void onSuccess(@NonNull Boolean bool) {
                L.d(DialogDataProvider.TAG, "oneSecBindAmap---onSuccess");
                AccountManager.getInstance().getAMapAccountInfoAndSync();
                LinkSeamlessLoginAmapData linkSeamlessLoginAmapData = new LinkSeamlessLoginAmapData();
                linkSeamlessLoginAmapData.setLogin(true);
                DialogDataProvider.this.mResponseMap.put(Integer.valueOf(linkSeamlessRequestParam.getTaskId()), linkSeamlessLoginAmapData);
                DialogDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }

            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver, io.reactivex.Observer
            public void onError(@NonNull Throwable th) {
                L.d(DialogDataProvider.TAG, "oneSecBindAmap---onFail");
                DialogDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }
        });
        lockParam(linkSeamlessRequestParam);
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        LinkSeamlessLoginAmapData linkSeamlessLoginAmapData = (LinkSeamlessLoginAmapData) this.mResponseMap.remove(Integer.valueOf(linkSeamlessRequestParam.getTaskId()));
        linkSeamlessLoginAmapData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
        dataProviderResponse.setResultData(linkSeamlessLoginAmapData);
        return dataProviderResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyParam(BaseParameter baseParameter) {
        synchronized (baseParameter) {
            baseParameter.notify();
        }
    }

    @Override // com.xiaopeng.montecarlo.views.dialog.IDialogDataProvider
    public void fetchSecBindAMap(BaseCallBack baseCallBack) {
        LinkSeamlessOneSecBindParam linkSeamlessOneSecBindParam = new LinkSeamlessOneSecBindParam();
        linkSeamlessOneSecBindParam.setLinkSemalessType(3);
        linkSeamlessOneSecBindParam.setSync(false);
        doFetchData(linkSeamlessOneSecBindParam, baseCallBack);
    }

    @Override // com.xiaopeng.montecarlo.views.dialog.IDialogDataProvider
    public void bindAmap(LinkSeamlessBindAmapParam linkSeamlessBindAmapParam, BaseCallBack baseCallBack) {
        doFetchData(linkSeamlessBindAmapParam, baseCallBack);
    }

    private DataProviderResponse bindAmap(final LinkSeamlessRequestParam linkSeamlessRequestParam) {
        if (L.ENABLE) {
            L.d(TAG, "bindAmap");
        }
        if (!(linkSeamlessRequestParam instanceof LinkSeamlessBindAmapParam)) {
            throw new IllegalArgumentException("not LinkSeamlessBindAmapParam");
        }
        AccountManager.getInstance().createBindAMapObservable().subscribe(new BaseAccountObserver<Boolean>() { // from class: com.xiaopeng.montecarlo.views.dialog.DialogDataProvider.2
            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver
            public void onSuccess(@NonNull Boolean bool) {
                SearchStatUtil.biMatchQuickBinded(1);
                AccountManager.getInstance().getAMapAccountInfoAndSync();
                LinkSeamlessBindStatusData linkSeamlessBindStatusData = new LinkSeamlessBindStatusData();
                linkSeamlessBindStatusData.setBind(true);
                linkSeamlessBindStatusData.setIsSuccess(true);
                linkSeamlessBindStatusData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
                DialogDataProvider.this.mResponseMap.put(Integer.valueOf(linkSeamlessRequestParam.getTaskId()), linkSeamlessBindStatusData);
                DialogDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }

            @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver, io.reactivex.Observer
            public void onError(@NonNull Throwable th) {
                if (L.ENABLE) {
                    L.d(DialogDataProvider.TAG, "bindAmap  onFail");
                }
                SearchStatUtil.biMatchQuickBinded(0);
                SettingStatUtil.sendStatDataBindAmap(3);
                LinkSeamlessBindStatusData linkSeamlessBindStatusData = new LinkSeamlessBindStatusData();
                linkSeamlessBindStatusData.setIsSuccess(false);
                linkSeamlessBindStatusData.setParamType(linkSeamlessRequestParam.getLinkSemalessType());
                DialogDataProvider.this.mResponseMap.put(Integer.valueOf(linkSeamlessRequestParam.getTaskId()), linkSeamlessBindStatusData);
                DialogDataProvider.this.notifyParam(linkSeamlessRequestParam);
            }
        });
        lockParam(linkSeamlessRequestParam);
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        LinkSeamlessBindStatusData linkSeamlessBindStatusData = (LinkSeamlessBindStatusData) this.mResponseMap.remove(Integer.valueOf(linkSeamlessRequestParam.getTaskId()));
        if (linkSeamlessBindStatusData.isSuccess()) {
            dataProviderResponse.setResultData(linkSeamlessBindStatusData);
        } else {
            dataProviderResponse.setErrorCode(100);
        }
        return dataProviderResponse;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public void onFetchStart(LinkSeamlessRequestParam linkSeamlessRequestParam) {
        super.onFetchStart((DialogDataProvider) linkSeamlessRequestParam);
        if (linkSeamlessRequestParam.isSync()) {
            return;
        }
        linkSeamlessRequestParam.setTaskId((int) System.currentTimeMillis());
    }
}
