package com.xiaopeng.montecarlo.navcore.powerdistance.route;

import androidx.annotation.NonNull;
import com.xiaopeng.lib.bughunter.anr.UILooperObserver;
import com.xiaopeng.montecarlo.navcore.powerdistance.OnlineKHolder;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PdExternalData;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PowerDisDataProvider;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PowerDisRequestParam;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PowerDisResultData;
import com.xiaopeng.montecarlo.navcore.powerdistance.route.IRoutePdContract;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class RoutePdPresenter implements BaseCallBack<PowerDisRequestParam, PowerDisResultData>, IRoutePdContract.Presenter, PowerDisDataProvider.IProviderExternalListener {
    private static final L.Tag TAG = new L.Tag("RoutePdPresenter");
    private static final int UPDATE_ONLINE_DATA_ASYNC_TIMEOUT = 5000;
    private PowerDisDataProvider mDataProvider = new PowerDisDataProvider();
    private IRoutePdContract.LogicView mLogicView;

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public boolean isLegal() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataCache(@NonNull PowerDisResultData powerDisResultData) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchComplete(PowerDisRequestParam powerDisRequestParam) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchStart(PowerDisRequestParam powerDisRequestParam) {
    }

    public RoutePdPresenter(IRoutePdContract.LogicView logicView, boolean z) {
        this.mLogicView = logicView;
        this.mDataProvider.setCallBack(this);
        this.mDataProvider.setSync(z);
        this.mDataProvider.setIProviderExternalListener(this);
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.route.IRoutePdContract.Presenter
    public void close() {
        this.mDataProvider.close();
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.route.IRoutePdContract.Presenter
    public void refreshOnlineK(int i, int i2, int i3, IVariantPath iVariantPath, IPathResult iPathResult, boolean z) {
        if (z) {
            this.mDataProvider.refreshOnlineK(i, i2, i3, iVariantPath, iPathResult, UILooperObserver.ANR_TRIGGER_TIME, new PdExternalData(0));
        } else {
            this.mDataProvider.refreshOnlineK(i, i2, i3, iVariantPath, iPathResult, UILooperObserver.ANR_TRIGGER_TIME);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.route.IRoutePdContract.Presenter
    public void refreshWithOfflineK(int i, int i2, int i3, IVariantPath iVariantPath, IPathResult iPathResult) {
        refreshWithOfflineK(i, i2, i3, iVariantPath, iPathResult, false);
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.route.IRoutePdContract.Presenter
    public void refreshWithOfflineK(int i, int i2, int i3, IVariantPath iVariantPath, IPathResult iPathResult, boolean z) {
        this.mDataProvider.refreshWithOfflineK(i, i2, i3, iVariantPath, iPathResult);
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataFetched(@NonNull PowerDisResultData powerDisResultData) {
        int paramType = powerDisResultData.getParamType();
        if (paramType != 0) {
            if (paramType != 1) {
                return;
            }
            this.mLogicView.onUpdateRemainDis(powerDisResultData.getRemainDis(), powerDisResultData.getCostDis());
            return;
        }
        OnlineKHolder onlineKHolder = new OnlineKHolder();
        onlineKHolder.setK(powerDisResultData.getK());
        this.mLogicView.onSuccess(onlineKHolder.getK());
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onError(int i, @NonNull String str) {
        L.Tag tag = TAG;
        L.d(tag, " onError errorCode:" + i + " errorMessage:" + str);
        this.mLogicView.onError();
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PowerDisDataProvider.IProviderExternalListener
    public void onExternalData(PdExternalData pdExternalData) {
        this.mLogicView.onExternalDataFetched(pdExternalData);
    }
}
