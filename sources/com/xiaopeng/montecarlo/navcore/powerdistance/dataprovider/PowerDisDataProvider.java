package com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.DumpEnergyInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.RoadSeqStageInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IAssistantPowerService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.AssistantPowerDumpEnergyRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.AssistantPowerKRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.AssistantPowerKResponse;
import com.xiaopeng.montecarlo.navcore.powerdistance.EnergyInfo;
import com.xiaopeng.montecarlo.navcore.powerdistance.PowerDisUtil;
import com.xiaopeng.montecarlo.navcore.powerdistance.PowerDistanceManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.dataprovider.BackgroundDataProvider;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderException;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.NumberParseUtil;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PowerDisDataProvider extends BackgroundDataProvider<PowerDisResultData, PowerDisRequestParam, BaseCallBack> {
    private static final long DAY_MILLIS = 86400000;
    private static final L.Tag TAG = new L.Tag("PowerDisDataProvider");
    private BaseCallBack mCallBack;
    private IProviderExternalListener mIProviderExternalListener;
    private Disposable mSendDisposable = null;
    private IAssistantPowerService mAssistantLocationService = (IAssistantPowerService) HttpClientManager.getInstance().getService(IAssistantPowerService.class);

    /* loaded from: classes2.dex */
    public interface IProviderExternalListener {
        void onExternalData(PdExternalData pdExternalData);
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    protected String getErrorMessage(int i) {
        return null;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public void onFetchStart(PowerDisRequestParam powerDisRequestParam) {
    }

    public void setCallBack(BaseCallBack baseCallBack) {
        this.mCallBack = baseCallBack;
    }

    public void setIProviderExternalListener(IProviderExternalListener iProviderExternalListener) {
        this.mIProviderExternalListener = iProviderExternalListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public DataProviderResponse fetchDataDelegate(PowerDisRequestParam powerDisRequestParam) throws DataProviderException {
        if (powerDisRequestParam == null) {
            throw new DataProviderException("param is null");
        }
        int paramType = powerDisRequestParam.getParamType();
        if (paramType != 0) {
            if (paramType != 1) {
                if (paramType != 2) {
                    if (paramType == 3) {
                        return handleUpdateOfflineData(powerDisRequestParam);
                    }
                    throw new DataProviderException("param type error");
                }
                return handleInitOfflineData(powerDisRequestParam);
            }
            return handleRefreshWithOfflineK(powerDisRequestParam);
        }
        return handleRefreshOnlineK(powerDisRequestParam);
    }

    public void refreshOnlineK(int i, int i2, int i3, IVariantPath iVariantPath, IPathResult iPathResult, long j) {
        refreshOnlineK(i, i2, i3, iVariantPath, iPathResult, j, null);
    }

    public void refreshOnlineK(int i, int i2, int i3, IVariantPath iVariantPath, IPathResult iPathResult, long j, PdExternalData pdExternalData) {
        PowerDisRequestParam externalData = new PowerDisRequestParam().setParamType(0).setStartSegIndex(i).setStartLinkIndex(i2).setDisToTarget(i3).setPath(iVariantPath).setPathResult(iPathResult).setExternalData(pdExternalData);
        externalData.setTimeout(j);
        doFetchData(externalData, this.mCallBack);
    }

    public void refreshOnlineK(int i, int i2, int i3, IVariantPath iVariantPath, IPathResult iPathResult) {
        refreshOnlineK(i, i2, i3, iVariantPath, iPathResult, BaseParameter.DEFAULT_TIMEOUT);
    }

    private DataProviderResponse handleRefreshOnlineK(PowerDisRequestParam powerDisRequestParam) {
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        PowerDisResultData powerDisResultData = new PowerDisResultData();
        dataProviderResponse.setResultData(powerDisResultData);
        powerDisResultData.setExternalData(powerDisRequestParam.getExternalData());
        IVariantPath path = powerDisRequestParam.getPath();
        IPathResult pathResult = powerDisRequestParam.getPathResult();
        if (path != null && pathResult != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateRemainDis  refreshOnlineK--");
            sb.append(" mPathId:  " + path.getPathId());
            sb.append(" mStartSegIndex:  " + powerDisRequestParam.getStartSegIndex());
            sb.append(" mStartLinkIndex:  " + powerDisRequestParam.getStartLinkIndex());
            sb.append(" mDisToTarget:  " + powerDisRequestParam.getDisToTarget());
            sb.append(" mPath:  " + powerDisRequestParam.getPath());
            sb.append(" mPathResult:  " + powerDisRequestParam.getPathResult());
            sb.append(" callThread:  " + Thread.currentThread().getName());
            L.i(TAG, sb.toString());
            List<RoadSeqStageInfo> stageList = PowerDisUtil.getStageList(powerDisRequestParam.getStartSegIndex(), powerDisRequestParam.getStartLinkIndex(), powerDisRequestParam.getDisToTarget(), path, pathResult, powerDisRequestParam.getExternalData());
            IProviderExternalListener iProviderExternalListener = this.mIProviderExternalListener;
            if (iProviderExternalListener != null) {
                iProviderExternalListener.onExternalData(powerDisRequestParam.getExternalData());
            }
            if (CollectionUtils.isNotEmpty(stageList)) {
                AssistantPowerKResponse calculateK = this.mAssistantLocationService.calculateK(new AssistantPowerKRequest().setUserId(0L).setStages(stageList).setVin(RootUtil.getVin()).setTs(Long.valueOf(System.currentTimeMillis())));
                if (calculateK != null) {
                    double doubleValue = calculateK.getK().doubleValue();
                    if (L.ENABLE) {
                        L.Tag tag = TAG;
                        L.d(tag, "handleRefreshOnlineK -stageLis1:-" + GsonUtil.toJson(stageList));
                    }
                    L.Tag tag2 = TAG;
                    L.i(tag2, " handleRefreshOnlineK originalK:" + doubleValue + ", param request type:" + powerDisRequestParam.getParamType());
                    PowerDistanceManager.getInstance().addKValue(path.getPathId(), doubleValue);
                    powerDisResultData.setK(doubleValue);
                    powerDisResultData.setParamType(powerDisRequestParam.getParamType());
                    return dataProviderResponse;
                }
            }
        }
        if (powerDisRequestParam.getParamType() == 0) {
            dataProviderResponse.setErrorCode(-1);
        } else {
            dataProviderResponse.setErrorCode(100);
        }
        return dataProviderResponse;
    }

    public void refreshWithOfflineK(int i, int i2, int i3, IVariantPath iVariantPath, IPathResult iPathResult) {
        doFetchData(new PowerDisRequestParam().setParamType(1).setStartSegIndex(i).setStartLinkIndex(i2).setDisToTarget(i3).setPath(iVariantPath).setPathResult(iPathResult), this.mCallBack);
    }

    private DataProviderResponse handleRefreshWithOfflineK(PowerDisRequestParam powerDisRequestParam) {
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        PowerDisResultData powerDisResultData = new PowerDisResultData();
        dataProviderResponse.setResultData(powerDisResultData);
        powerDisResultData.setParamType(powerDisRequestParam.getParamType());
        IVariantPath path = powerDisRequestParam.getPath();
        IPathResult pathResult = powerDisRequestParam.getPathResult();
        int remainDis = (path == null || pathResult == null) ? 0 : PowerDisUtil.getRemainDis(powerDisRequestParam.getStartSegIndex(), powerDisRequestParam.getStartLinkIndex(), powerDisRequestParam.getDisToTarget(), path, pathResult);
        powerDisResultData.setRemainDis(remainDis > 0 ? remainDis : 0);
        powerDisResultData.setCostDis(CarServiceManager.getInstance().getCarRemainDistance() - remainDis);
        return dataProviderResponse;
    }

    public void initOfflineData() {
        doFetchData(new PowerDisRequestParam().setParamType(2), this.mCallBack);
    }

    public void updateOfflineData() {
        doFetchData(new PowerDisRequestParam().setParamType(3), this.mCallBack);
    }

    private DataProviderResponse handleInitOfflineData(PowerDisRequestParam powerDisRequestParam) {
        String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.POWER_DIS_ENERGY, "");
        List<EnergyInfo> fromJson = !TextUtils.isEmpty(string) ? fromJson(string) : null;
        if (System.currentTimeMillis() - DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.POWER_DIS_LAST_UPDATE_TIME, 0L) > 86400000) {
            fromJson = getEnergyInfoListFromNet();
        }
        if (fromJson == null) {
            fromJson = fromJson(FileUtil.loadFromAssets("energy.json"));
        }
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        PowerDisResultData powerDisResultData = new PowerDisResultData();
        powerDisResultData.setParamType(powerDisRequestParam.getParamType());
        powerDisResultData.setEnergyInfoList(fromJson);
        dataProviderResponse.setResultData(powerDisResultData);
        return dataProviderResponse;
    }

    private DataProviderResponse handleUpdateOfflineData(PowerDisRequestParam powerDisRequestParam) {
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        List<EnergyInfo> energyInfoListFromNet = getEnergyInfoListFromNet();
        if (energyInfoListFromNet != null) {
            PowerDisResultData powerDisResultData = new PowerDisResultData();
            powerDisResultData.setParamType(powerDisRequestParam.getParamType());
            powerDisResultData.setEnergyInfoList(energyInfoListFromNet);
            dataProviderResponse.setResultData(powerDisResultData);
        } else {
            dataProviderResponse.setErrorCode(400);
        }
        return dataProviderResponse;
    }

    private List<EnergyInfo> getEnergyInfoListFromNet() {
        List<DumpEnergyInfo> dumpenergy = this.mAssistantLocationService.dumpenergy(new AssistantPowerDumpEnergyRequest().setUserId(0L).setVin(RootUtil.getVin()).setTs(Long.valueOf(System.currentTimeMillis())));
        String json = GsonUtil.toJson(dumpenergy);
        L.Tag tag = TAG;
        L.v(tag, "handleOfflineData  data:" + json);
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isNotEmpty(dumpenergy)) {
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.POWER_DIS_ENERGY, json);
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.POWER_DIS_LAST_UPDATE_TIME, System.currentTimeMillis());
            for (DumpEnergyInfo dumpEnergyInfo : dumpenergy) {
                arrayList.add(dumpEnergyInfo2EnergyInfo(dumpEnergyInfo));
            }
        }
        return arrayList;
    }

    private List<EnergyInfo> fromJson(String str) {
        ArrayList arrayList = new ArrayList();
        for (DumpEnergyInfo dumpEnergyInfo : (List) GsonUtil.fromJson(str, new TypeToken<List<DumpEnergyInfo>>() { // from class: com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PowerDisDataProvider.1
        }.getType())) {
            arrayList.add(dumpEnergyInfo2EnergyInfo(dumpEnergyInfo));
        }
        return arrayList;
    }

    private EnergyInfo dumpEnergyInfo2EnergyInfo(DumpEnergyInfo dumpEnergyInfo) {
        EnergyInfo energyInfo = new EnergyInfo();
        energyInfo.setAirConditionOnK(NumberParseUtil.parseFloat(dumpEnergyInfo.getAirConditionOnK()));
        energyInfo.setAirConditionOffK(NumberParseUtil.parseFloat(dumpEnergyInfo.getAirConditionOffK()));
        String range = dumpEnergyInfo.getRange();
        if (range != null) {
            String[] split = range.split(",");
            if (split.length == 2) {
                String substring = split[0].substring(1);
                String substring2 = split[1].substring(0, split[1].length() - 1);
                try {
                    int parseInt = Integer.parseInt(substring);
                    int parseInt2 = Integer.parseInt(substring2);
                    energyInfo.setRangeStart(parseInt);
                    energyInfo.setRangeEnd(parseInt2);
                } catch (NumberFormatException e) {
                    if ("+∞".equals(substring2)) {
                        energyInfo.setRangeEnd(Integer.MAX_VALUE);
                    } else {
                        L.printStackTrace(TAG, e);
                    }
                }
            }
        }
        return energyInfo;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    protected void onSubscribe(Disposable disposable) {
        close();
        this.mSendDisposable = disposable;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BackgroundDataProvider
    public void addRef(PowerDisRequestParam powerDisRequestParam) {
        if (powerDisRequestParam == null || powerDisRequestParam.getPathResult() == null) {
            return;
        }
        powerDisRequestParam.getPathResult().addRef();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BackgroundDataProvider
    public void delRef(PowerDisRequestParam powerDisRequestParam) {
        if (powerDisRequestParam == null || powerDisRequestParam.getPathResult() == null) {
            return;
        }
        powerDisRequestParam.getPathResult().delRef();
    }

    public void close() {
        Disposable disposable = this.mSendDisposable;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.mSendDisposable.dispose();
        this.mSendDisposable = null;
    }
}
