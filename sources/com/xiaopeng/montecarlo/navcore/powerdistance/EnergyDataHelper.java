package com.xiaopeng.montecarlo.navcore.powerdistance;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PowerDisDataProvider;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PowerDisRequestParam;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PowerDisResultData;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes2.dex */
public class EnergyDataHelper implements BaseCallBack<PowerDisRequestParam, PowerDisResultData> {
    private static final L.Tag TAG = new L.Tag("EnergyDataHelper");
    private List<EnergyInfo> mEnergyInfoList = null;
    private final PowerDisDataProvider mDataProvider = new PowerDisDataProvider();

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public boolean isLegal() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataCache(@NonNull PowerDisResultData powerDisResultData) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onError(int i, @NonNull String str) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchComplete(PowerDisRequestParam powerDisRequestParam) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchStart(PowerDisRequestParam powerDisRequestParam) {
    }

    public EnergyDataHelper() {
        this.mDataProvider.setCallBack(this);
    }

    public void close() {
        this.mDataProvider.close();
    }

    public List<EnergyInfo> getEnergyInfoList() {
        return this.mEnergyInfoList;
    }

    public void initOfflineData() {
        this.mDataProvider.initOfflineData();
    }

    public void updateOfflineData() {
        this.mDataProvider.updateOfflineData();
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataFetched(@NonNull PowerDisResultData powerDisResultData) {
        int paramType = powerDisResultData.getParamType();
        if (paramType == 2 || paramType == 3) {
            this.mEnergyInfoList = powerDisResultData.getEnergyInfoList();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "onDataFetched mEnergyInfoList: " + GsonUtil.toJson(this.mEnergyInfoList));
            }
        }
    }
}
