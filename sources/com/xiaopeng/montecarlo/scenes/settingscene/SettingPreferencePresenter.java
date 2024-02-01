package com.xiaopeng.montecarlo.scenes.settingscene;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.bridge.LinkSeamlessNaviBridge;
import com.xiaopeng.montecarlo.bridge.SettingLicencePlateBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.setcarlogo.SetCarLogoPresenter;
import com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract;
import com.xiaopeng.montecarlo.scenes.settingscene.dataprovider.SettingDataProvider;
import com.xiaopeng.montecarlo.scenes.settingscene.dataprovider.SettingRequestParam;
import com.xiaopeng.montecarlo.scenes.settingscene.dataprovider.SettingResultData;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
/* loaded from: classes3.dex */
public class SettingPreferencePresenter extends BasePresenter implements ISettingContract.Presenter, BaseCallBack<SettingRequestParam, SettingResultData> {
    public static final String ALTERNATE_ROUTE_CHANGE_TYPE = "alternative_route_change_type";
    public static final String DELETE_USER_DATA = "delete_user_data";
    public static final String OVERVIEW_CHANGE_TYPE = "overview_change_type";
    public static final int REQUEST_CODE_CHANGE_LICENCE_PLATE = 2;
    public static final int REQUEST_CODE_CHANGE_LICENCE_PLATE_FROM_RESTRICT = 4;
    public static final int REQUEST_CODE_MAP_DOWNLOAD = 5;
    public static final int REQUEST_CODE_NAVI_GUIDER = 3;
    public static final int REQUEST_CODE_SET_CAR_LOGO = 6;
    public static final String ROUTE_CHANGE_TYPE = "route_change_type";
    private static final L.Tag TAG = new L.Tag("SettingPreferencePresenter");
    private int mInitSettingPreferenceValue;
    private boolean mIsDeleteUserData;
    private String mLastLicencePlate;
    private ISettingContract.LogicView mLogicView;
    private SettingDataProvider mSettingDataProvider;
    @VisibleForTesting
    protected int mSettingPreferenceValue;

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataCache(@NonNull SettingResultData settingResultData) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchComplete(SettingRequestParam settingRequestParam) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchStart(SettingRequestParam settingRequestParam) {
    }

    public int getSettingPreferenceValue() {
        return this.mSettingPreferenceValue;
    }

    public SettingPreferencePresenter(ISettingContract.LogicView logicView) {
        this.mLogicView = logicView;
        ISettingContract.LogicView logicView2 = this.mLogicView;
        if (logicView2 != null) {
            logicView2.setPresenter(this);
        }
        this.mSettingDataProvider = new SettingDataProvider();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
        if (L.ENABLE) {
            L.d(TAG, "onResume");
        }
        SettingStatUtil.sendStatDataExposure();
        SettingStatUtil.sendStatData2Foreground();
        this.mIsDeleteUserData = false;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
        if (L.ENABLE) {
            L.d(TAG, "onPause");
        }
        this.mLogicView.unBindView();
        SettingStatUtil.sendStatData2Background();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        super.onDestroy();
        if (L.ENABLE) {
            L.d(TAG, "onDestroy");
        }
        SettingStatUtil.sendStatDataExit();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
    }

    public void onCreate() {
        if (L.ENABLE) {
            L.d(TAG, "onCreate");
        }
        int allSettingValue = this.mSettingDataProvider.getAllSettingValue();
        this.mSettingPreferenceValue = allSettingValue;
        this.mInitSettingPreferenceValue = allSettingValue;
        this.mLastLicencePlate = this.mSettingDataProvider.getLicensePlate();
        ISettingContract.BindViewParam bindViewParam = new ISettingContract.BindViewParam();
        bindViewParam.mBindXPAccountStatus = this.mSettingDataProvider.getBindAMapStatus();
        bindViewParam.mIsXPAccountLog = this.mSettingDataProvider.isXPAccountLogin();
        bindViewParam.mLicencePlate = this.mLastLicencePlate;
        bindViewParam.mMapContent = this.mSettingDataProvider.getMapNumContent();
        bindViewParam.mValue = this.mInitSettingPreferenceValue;
        this.mLogicView.bindView(bindViewParam);
    }

    public void modifySettingPreference(int i, boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "modifySettingPreference key = [" + i + "], status = [" + z + "]");
        }
        this.mSettingPreferenceValue = SettingWrapper.modifySettingPreference(this.mSettingPreferenceValue, this.mSettingDataProvider.getKey(i), z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetDefaultSetting() {
        if (L.ENABLE) {
            L.d(TAG, "resetDefaultSetting");
        }
        resetDefaultSettingView();
        saveSettingPreference();
        this.mLogicView.getMainContext().getMapView().updateCarLocIcon();
        if (TBTManager.getInstance().isMiniMapEnable()) {
            Intent intent = new Intent();
            intent.setClassName(ContextUtils.getContext().getPackageName(), "com.xiaopeng.montecarlo.service.minimap.MiniMapService");
            intent.setAction("com.xiaopeng.montecarlo.minimap.ACTION_CAR_ICON_CHANGE");
            ContextUtils.getContext().startService(intent);
            L.i(TAG, "MiniMapService startService ACTION_CAR_ICON_CHANGE in resetDefaultSetting");
        }
        if (MapDataManager.getInstance().getAutoDownloadManager() != null) {
            MapDataManager.getInstance().getAutoDownloadManager().onAutoDownloadSwitchChanged(false);
        }
        this.mLogicView.enableCharge(true);
    }

    protected void resetDefaultSettingView() {
        this.mSettingPreferenceValue = this.mSettingDataProvider.resetDefaultSetting();
        this.mLogicView.resetView(this.mSettingPreferenceValue);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void saveSettingPreference() {
        this.mSettingDataProvider.saveSettingPreference(this.mSettingPreferenceValue);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void refreshSettingView() {
        this.mSettingPreferenceValue = SettingWrapper.getAllSettingValue();
        this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingPreferencePresenter.1
            @Override // java.lang.Runnable
            public void run() {
                SettingPreferencePresenter.this.mLogicView.resetView(SettingPreferencePresenter.this.mSettingPreferenceValue);
            }
        });
    }

    public void deleteUserData() {
        SettingRequestParam settingRequestParam = new SettingRequestParam();
        settingRequestParam.setSettingType(0);
        this.mSettingDataProvider.deleteUserDatas(settingRequestParam, this);
        this.mIsDeleteUserData = true;
    }

    public void exitScene() {
        boolean z;
        String str;
        int i = this.mSettingPreferenceValue;
        if (i != this.mInitSettingPreferenceValue) {
            this.mSettingDataProvider.saveSettingPreference(i);
        }
        String licensePlate = this.mSettingDataProvider.getLicensePlate();
        boolean z2 = true;
        if ((licensePlate != null && (str = this.mLastLicencePlate) != null && licensePlate.equals(str)) || (licensePlate == null && this.mLastLicencePlate == null)) {
            if (L.ENABLE) {
                L.d(TAG, "licence plate no change ");
            }
            z = false;
        } else {
            if (L.ENABLE) {
                L.d(TAG, "licence plate  change ");
            }
            z = true;
        }
        L.i(TAG, "setting change from:" + this.mInitSettingPreferenceValue + " to " + this.mSettingPreferenceValue);
        if (!isRouteSettingStatusChange(this.mSettingPreferenceValue, this.mInitSettingPreferenceValue) && !z) {
            z2 = false;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(ROUTE_CHANGE_TYPE, z2);
        if (!z2) {
            bundle.putBoolean(ALTERNATE_ROUTE_CHANGE_TYPE, isRadarStatusChange(this.mSettingPreferenceValue, this.mInitSettingPreferenceValue));
        }
        bundle.putBoolean(DELETE_USER_DATA, this.mIsDeleteUserData);
        bundle.putBoolean(OVERVIEW_CHANGE_TYPE, isOverViewStatusChange(this.mSettingPreferenceValue, this.mInitSettingPreferenceValue));
        this.mLogicView.setReturnResult(bundle);
        this.mLogicView.goBack();
    }

    public void toggleLicencePlate(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mLogicView.controlRestrictSwitchView(false);
            return;
        }
        this.mLogicView.updateLicencePlate(str, false);
        this.mLogicView.controlRestrictSwitchView(SettingWrapper.isOpenPlateSwitch());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBackResult(int i, Bundle bundle) {
        if (i == 2) {
            this.mLogicView.updateLicencePlate(bundle.getString(SettingLicencePlatePresenter.KEY_SAVE_LICENCE_PLATE), false);
        } else if (i == 4) {
            String string = bundle.getString(SettingLicencePlatePresenter.KEY_SAVE_LICENCE_PLATE);
            if (TextUtils.isEmpty(string)) {
                this.mLogicView.controlRestrictSwitchView(false);
                return;
            }
            this.mLogicView.updateLicencePlate(string, false);
            this.mLogicView.controlRestrictSwitchView(true);
        } else if (i == 3) {
            this.mLogicView.updateNaviGuider();
        } else if (i == 5) {
            this.mLogicView.updateMapDownloadSize(getMapDownloadSize());
            if (bundle.getBoolean("key_need_exit_settings", false)) {
                exitScene();
            }
        } else if (i == 6) {
            if (bundle.getBoolean("key_need_exit_settings", false)) {
                exitScene();
            } else if (bundle.getBoolean(SetCarLogoPresenter.KEY_CAR_LOGO_CHANGE, false)) {
                this.mLogicView.updateCarLogo();
            }
        }
    }

    public void routeToPlateSceneFromRestrict() {
        this.mLogicView.startScene(new SettingLicencePlateBridge().setStartMode(1), 4);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.Presenter
    public void routeToScene(StatusConst.Mode mode) {
        if (mode == StatusConst.Mode.SETTING_LICENCE_PLATE) {
            this.mLogicView.startScene(new SettingLicencePlateBridge().setStartMode(1), 2);
        } else if (mode == StatusConst.Mode.LINK_SEAMLESS_NAVI) {
            Bundle bundle = new Bundle();
            bundle.putInt(LinkSeamlessNaviBridge.KEY_FROM_WHERE, 0);
            this.mLogicView.startScene(new LinkSeamlessNaviBridge().setBundle(bundle), 3);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        int i = speechNaviEvent.what;
        if (i == 100) {
            L.i(TAG, "SPEECH_OPEN_FAVORITE");
            this.mLogicView.getSpeechEventBizHelper().openFavoriteInSetting(this);
        } else if (i == 103) {
            L.i(TAG, "SPEECH_OPEN_SETTINGS");
            this.mLogicView.getSpeechEventBizHelper().openSettings(this);
        } else if (i == 1100) {
            L.i(TAG, "SPEECH_SETTING_REFRESH_ALL");
            this.mLogicView.getSpeechEventBizHelper().refreshAllSettings(this);
        } else if (i == 105) {
            L.i(TAG, "SPEECH_OPEN_SETTING_LICENCE_PLATE");
            this.mLogicView.getSpeechEventBizHelper().openSettingLicencePlate(this);
            return true;
        } else if (i == 106) {
            L.i(TAG, "SPEECH_OPEN_LINK_SEAMLESS_NAVI");
            this.mLogicView.getSpeechEventBizHelper().openLinkSeamlessNavi(this);
            return true;
        }
        return false;
    }

    public void executeSpeechCmdOpenSettingLicencePlate() {
        routeToScene(StatusConst.Mode.SETTING_LICENCE_PLATE);
    }

    public void executeSpeechCmdOpenLinkSeamlessNavi() {
        routeToScene(StatusConst.Mode.LINK_SEAMLESS_NAVI);
    }

    public void executeSpeechCmdOpenSettings() {
        SpeechStatProxy.getInstance().sendStatDataForSpeech(10, 0);
    }

    public void executeSpeechCmdOpenFavorite() {
        exitScene();
    }

    public void executeSpeechCmdRefreshAll() {
        this.mSettingPreferenceValue = SettingWrapper.getAllSettingValue();
        this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingPreferencePresenter.2
            @Override // java.lang.Runnable
            public void run() {
                SettingPreferencePresenter.this.mLogicView.resetView(SettingPreferencePresenter.this.mSettingPreferenceValue);
            }
        });
    }

    public void checkBindAmapStatus() {
        SettingRequestParam settingRequestParam = new SettingRequestParam();
        settingRequestParam.setSettingType(1);
        if (XPAccountServiceWrapper.getInstance().isLoginXp()) {
            if (L.ENABLE) {
                L.d(TAG, "bindmap  checkBindAMapStatus start ");
            }
            if (!SettingWrapper.getBindAMapStatus()) {
                if (L.ENABLE) {
                    L.d(TAG, "bindmap   checkBindAMapStatus unbind,  ");
                    return;
                }
                return;
            }
            this.mSettingDataProvider.requestBindAMap(settingRequestParam, this);
        }
    }

    private boolean isOverViewStatusChange(int i, int i2) {
        int itemGroupSelectedValue = this.mSettingDataProvider.getItemGroupSelectedValue(DataSetHelper.AccountSet.KEY_SETTING_MAP_OVERVIEW);
        if ((i & itemGroupSelectedValue) != (i2 & itemGroupSelectedValue)) {
            if (L.ENABLE) {
                L.d(TAG, "isOverViewStatusChange true");
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean isRadarStatusChange(int i, int i2) {
        int itemGroupSelectedValue = this.mSettingDataProvider.getItemGroupSelectedValue(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_ROUTE_RADER);
        if ((i & itemGroupSelectedValue) != (i2 & itemGroupSelectedValue)) {
            if (L.ENABLE) {
                L.d(TAG, "isRadarStatusChange true");
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean isRouteSettingStatusChange(int i, int i2) {
        int itemGroupSelectedValue = this.mSettingDataProvider.getItemGroupSelectedValue(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_ROUTE);
        int i3 = i & itemGroupSelectedValue;
        int i4 = itemGroupSelectedValue & i2;
        int itemGroupSelectedValue2 = this.mSettingDataProvider.getItemGroupSelectedValue(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_AVOID_RESTRICTION_ROUTE);
        int i5 = i & itemGroupSelectedValue2;
        int i6 = i2 & itemGroupSelectedValue2;
        if (i3 == i4 && i5 == i6) {
            return false;
        }
        if (L.ENABLE) {
            L.d(TAG, "isRouteSettingStatusChange true");
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isXPAccountLogin() {
        return this.mSettingDataProvider.isXPAccountLogin();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getBindAMapStatus() {
        return this.mSettingDataProvider.getBindAMapStatus();
    }

    protected String getLicensePlate() {
        return this.mSettingDataProvider.getLicensePlate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getMapDownloadSize() {
        return this.mSettingDataProvider.getMapDownloadSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getVersionName() {
        return this.mSettingDataProvider.getVersionName();
    }

    protected int getKey(int i) {
        return this.mSettingDataProvider.getKey(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAccountGuest() {
        return XPAccountServiceWrapper.getInstance().getUserType() == UserInfo.UserType.TEMP;
    }

    protected void setMapDownloadAuto(boolean z) {
        if (MapDataManager.getInstance().getAutoDownloadManager() != null) {
            MapDataManager.getInstance().getAutoDownloadManager().onAutoDownloadSwitchChanged(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataFetched(@NonNull SettingResultData settingResultData) {
        ISettingContract.LogicView logicView;
        int type = settingResultData.getType();
        if (type != 0) {
            if (type == 1 && (logicView = this.mLogicView) != null) {
                logicView.updateNaviGuider();
                return;
            }
            return;
        }
        ISettingContract.LogicView logicView2 = this.mLogicView;
        if (logicView2 != null) {
            logicView2.updateLicencePlate(getLicensePlate(), true);
            this.mLogicView.onDelUserData(true);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onError(int i, @NonNull String str) {
        if (i == 4105) {
            this.mLogicView.onDelUserData(false);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public boolean isLegal() {
        return this.mLogicView.isSceneLegal();
    }
}
