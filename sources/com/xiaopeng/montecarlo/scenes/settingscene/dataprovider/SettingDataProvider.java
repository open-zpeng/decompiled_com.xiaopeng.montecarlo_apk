package com.xiaopeng.montecarlo.scenes.settingscene.dataprovider;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.navcore.account.AccountStore;
import com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingBLManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderException;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class SettingDataProvider extends BaseDataProvider<SettingResultData, SettingRequestParam, BaseCallBack> {
    public static final int DEL_USER_DATA_ERROR = 4105;
    private static final L.Tag TAG = new L.Tag("SettingDataProvider");
    private ConcurrentHashMap<Integer, DataProviderResponse> mResultMap = new ConcurrentHashMap<>();
    @VisibleForTesting
    protected ConcurrentHashMap mKeyMap = null;

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    protected String getErrorMessage(int i) {
        return null;
    }

    public SettingDataProvider() {
        initKeyMap();
    }

    private void initKeyMap() {
        this.mKeyMap = new ConcurrentHashMap();
        this.mKeyMap.put(0, 1);
        this.mKeyMap.put(1, 2);
        this.mKeyMap.put(2, 4);
        this.mKeyMap.put(3, 8);
        this.mKeyMap.put(4, 16);
        this.mKeyMap.put(5, 32);
        this.mKeyMap.put(20, 1048576);
        this.mKeyMap.put(21, 2097152);
        this.mKeyMap.put(22, 4194304);
        this.mKeyMap.put(6, 64);
        this.mKeyMap.put(7, 128);
        this.mKeyMap.put(8, 256);
        this.mKeyMap.put(9, 512);
        this.mKeyMap.put(10, 1024);
        this.mKeyMap.put(11, 2048);
        this.mKeyMap.put(12, 4096);
        this.mKeyMap.put(13, 8192);
        this.mKeyMap.put(14, 16384);
        this.mKeyMap.put(15, 32768);
        this.mKeyMap.put(23, 8388608);
        this.mKeyMap.put(16, 65536);
        this.mKeyMap.put(17, 131072);
        this.mKeyMap.put(18, 262144);
        this.mKeyMap.put(19, 524288);
        this.mKeyMap.put(24, 16777216);
    }

    public int getKey(int i) {
        return ((Integer) this.mKeyMap.get(Integer.valueOf(i))).intValue();
    }

    public boolean isXPAccountLogin() {
        return XPAccountServiceWrapper.getInstance().isLoginXp();
    }

    public boolean getBindAMapStatus() {
        return SettingWrapper.getBindAMapStatus();
    }

    public String getLicensePlate() {
        return SettingWrapper.getLicensePlate();
    }

    public int getAllSettingValue() {
        return SettingWrapper.getAllSettingValue();
    }

    public int getDefaultState() {
        return SettingWrapper.getDefaultState();
    }

    public int resetDefaultSetting() {
        return SettingWrapper.resetDefaultSetting();
    }

    public void saveSettingPreference(int i) {
        SettingWrapper.saveSettingPreference(i);
    }

    public int getItemGroupSelectedValue(String str) {
        return SettingWrapper.getItemGroupSelectedValue(str);
    }

    public long getMapDownloadSize() {
        return MapDataManager.getInstance().getAllProvinceDataSize();
    }

    public String getVersionName() {
        return RootUtil.getVersionName();
    }

    public String getMapNumContent() {
        return MapDataManager.getInstance().getMapNumAndLaneMapNumContent();
    }

    public void deleteUserDatas(@NonNull SettingRequestParam settingRequestParam, @NonNull BaseCallBack baseCallBack) {
        doFetchData(settingRequestParam, baseCallBack);
    }

    private DataProviderResponse fetchDeleteUserData() {
        boolean deleteUserDatas = SettingBLManager.getInstance().deleteUserDatas();
        if (!SettingWrapper.getBindAMapStatus()) {
            SettingWrapper.saveFirstBindAmap(false);
        }
        SettingWrapper.saveGuideFistTimeShow(-1L, 1);
        SettingWrapper.resetSeamlessGuideNextShow();
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        if (deleteUserDatas) {
            SettingResultData settingResultData = new SettingResultData();
            settingResultData.mSettingType = 0;
            dataProviderResponse.setResultData(settingResultData);
        } else {
            dataProviderResponse.setErrorCode(DEL_USER_DATA_ERROR);
        }
        return dataProviderResponse;
    }

    public void requestBindAMap(SettingRequestParam settingRequestParam, BaseCallBack baseCallBack) {
        doFetchData(settingRequestParam, baseCallBack);
    }

    private DataProviderResponse fetchRequestBindAMapData(final SettingRequestParam settingRequestParam) {
        if (settingRequestParam == null) {
            throw new IllegalArgumentException();
        }
        if (settingRequestParam.getSettingType() == 1) {
            L.i(TAG, "Account requestBindAMapStatus start");
            AccountManager.getInstance().createCheckBindAMapStatusObservable(AccountStore.getInstance().getCurrentXpAccountInfo()).subscribe(new BaseAccountObserver<Integer>() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.dataprovider.SettingDataProvider.1
                @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver, io.reactivex.Observer
                public void onComplete() {
                }

                @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver
                public void onSuccess(@NonNull Integer num) {
                    L.Tag tag = SettingDataProvider.TAG;
                    L.i(tag, "Account requestBindAMapStatus onSuccess=" + num);
                    DataProviderResponse dataProviderResponse = new DataProviderResponse();
                    SettingResultData settingResultData = new SettingResultData();
                    settingResultData.setBindReulst(num.intValue() == 0);
                    settingResultData.setType(settingRequestParam.mSettingType);
                    dataProviderResponse.setResultData(settingResultData);
                    SettingDataProvider.this.mResultMap.put(Integer.valueOf(settingRequestParam.mTaskId), dataProviderResponse);
                    synchronized (settingRequestParam) {
                        settingRequestParam.notify();
                    }
                }

                @Override // com.xiaopeng.montecarlo.navcore.account.BaseAccountObserver, io.reactivex.Observer
                public void onError(@NonNull Throwable th) {
                    L.Tag tag = SettingDataProvider.TAG;
                    L.w(tag, "Account requestBindAMapStatus IError=" + th);
                    DataProviderResponse dataProviderResponse = new DataProviderResponse();
                    dataProviderResponse.setErrorCode(1);
                    SettingDataProvider.this.mResultMap.put(Integer.valueOf(settingRequestParam.mTaskId), dataProviderResponse);
                    synchronized (settingRequestParam) {
                        settingRequestParam.notify();
                    }
                }
            });
            DataProviderResponse remove = this.mResultMap.remove(Integer.valueOf(settingRequestParam.mTaskId));
            if (remove != null) {
                return remove;
            }
            synchronized (settingRequestParam) {
                try {
                    settingRequestParam.wait();
                } catch (InterruptedException e) {
                    L.Tag tag = TAG;
                    L.e(tag, "bind amap  wait error=" + e.toString());
                    e.printStackTrace();
                }
            }
            return this.mResultMap.remove(Integer.valueOf(settingRequestParam.mTaskId));
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public DataProviderResponse fetchDataDelegate(SettingRequestParam settingRequestParam) throws DataProviderException {
        int i = settingRequestParam.mSettingType;
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return fetchRequestBindAMapData(settingRequestParam);
        }
        return fetchDeleteUserData();
    }
}
