package com.xiaopeng.montecarlo.navcore.xptbt;

import android.provider.Settings;
import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.bean.sr.MuteType;
import com.xiaopeng.montecarlo.navcore.bean.sr.SrMuteNaviTtsStrategyInfo;
import com.xiaopeng.montecarlo.navcore.configurationmodule.ConfigurationModuleManager;
import com.xiaopeng.montecarlo.navcore.configurationmodule.constants.WebConfigurationEnum;
import com.xiaopeng.montecarlo.navcore.configurationmodule.listener.SrMuteNaviTtsStrategyConfigListener;
import com.xiaopeng.montecarlo.navcore.setting.ISettingChangeNotify;
import com.xiaopeng.montecarlo.navcore.setting.SettingBLManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.bean.BroadcastMaskBean;
import com.xiaopeng.montecarlo.navcore.xptbt.bean.BroadcastStyleBean;
import com.xiaopeng.montecarlo.navcore.xptbt.bean.NgpBroadcastPlayListBean;
import com.xiaopeng.montecarlo.navcore.xptbt.bean.NgpBroadcastStyleBean;
import com.xiaopeng.montecarlo.navcore.xptbt.bean.NgpBroadcastTypeBean;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
/* loaded from: classes3.dex */
public class TTSManager implements CarServiceManager.IXPCarStateListener {
    private static final String ASSETS_JSON_DATA = "broadcast_style.json";
    public static final int DETAIL_BROADCAST_MODE = 1;
    private static final String NGP_BROADCAST_DETAIL_TYPE = "type_ngp_detail";
    private static final String NGP_BROADCAST_JSON_DATA = "ngp_broadcast_style.json";
    private static final int NGP_BROADCAST_MODE_DETAIL = 1;
    private static final int NGP_BROADCAST_MODE_SIMPLE = 0;
    private static final String NGP_BROADCAST_SIMPLE_TYPE = "type_ngp_simple";
    public static final int NORMAL_BROADCAST_MODE = 2;
    private static final String TYPE_EXPL_ACC_BROADCAST = "type_expl_acc";
    private static final String TYPE_EXPL_BROADCAST = "type_expl";
    private static final String TYPE_NAVI_ACC_NORMAL_BROADCAST = "type_navi_acc_normal";
    private static final String TYPE_NAVI_ACC_ULTRA_SIMPLE_BROADCAST = "type_navi_acc_ultra_simple";
    private static final String TYPE_NAVI_NORMAL_BROADCAST = "type_navi_normal";
    private static final String TYPE_NAVI_ULTRA_SIMPLE_BROADCAST = "type_navi_ultra_simple";
    public static final int ULTRA_SIMPLE_BROADCAST_MODE = 3;
    private static BroadcastStyleBean sBroadcastStyleBean;
    private static List<Integer> sExplAccList;
    private static List<Integer> sExplList;
    private static boolean sIsInited;
    private static List<Integer> sNaviAccNormalList;
    private static List<Integer> sNaviAccUltraSimpleList;
    private static List<Integer> sNaviNormalList;
    private static List<Integer> sNaviUltraSimpleList;
    private static NgpBroadcastStyleBean sNgpBroadcastStyleBean;
    private static List<NgpBroadcastTypeBean> sNgpDetailList;
    private static List<NgpBroadcastTypeBean> sNgpSimpleList;
    private SrMuteNaviTtsStrategyConfigListener mConfigListener;
    private int mCurrentBroadcastStyle;
    private SrMuteNaviTtsStrategyInfo mMutNavTtsStrInfo;
    private SystemTTSContentObserver mSystemTTSContentObserver;
    private static final L.Tag TAG = new L.Tag("TTSManager");
    private static TTSManager sTTSManager = new TTSManager();
    private boolean mIsAccLccOn = false;
    private boolean mIsIgnoreTTSOnStartGuide = false;
    private int mNgpBroadCastType = 1;
    private ISettingChangeNotify mSettingChangeNotify = new ISettingChangeNotify() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.TTSManager.1
        @Override // com.xiaopeng.montecarlo.navcore.setting.ISettingChangeNotify
        public void onPlayStyleChange(int i) {
            if (1 == i || 2 == i || 3 == i) {
                L.Tag tag = TTSManager.TAG;
                L.i(tag, "change broadcast style from " + TTSManager.this.mCurrentBroadcastStyle + " to " + i);
                TTSManager.this.mCurrentBroadcastStyle = i;
                return;
            }
            L.w(TTSManager.TAG, "invalid broadcast style");
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface BroadcastStyleType {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onBCMDriveSeatStateChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onDrivingModeChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnduranceMileageModeChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnergyRecycleLevelChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onGearLevelChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onHVACPowerModeChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmConnectionStateChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapDisplayStateChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapFpsChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapSizeChange(int i, int i2) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIgStatusChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onImuNavDataChange(float[] fArr) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onRawCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXpuNedcStatusChange(int i) {
    }

    static {
        sIsInited = false;
        if (readConfigFile()) {
            parseMaskList();
            sIsInited = true;
        }
    }

    public static TTSManager getInstance() {
        return sTTSManager;
    }

    private static boolean readConfigFile() {
        NgpBroadcastStyleBean ngpBroadcastStyleBean;
        sBroadcastStyleBean = (BroadcastStyleBean) GsonUtil.fromJson(FileUtil.loadFromAssets(ASSETS_JSON_DATA), (Class<Object>) BroadcastStyleBean.class);
        sNgpBroadcastStyleBean = (NgpBroadcastStyleBean) GsonUtil.fromJson(FileUtil.loadFromAssets(NGP_BROADCAST_JSON_DATA), (Class<Object>) NgpBroadcastStyleBean.class);
        BroadcastStyleBean broadcastStyleBean = sBroadcastStyleBean;
        if (broadcastStyleBean == null || TextUtils.isEmpty(broadcastStyleBean.getVersion()) || (ngpBroadcastStyleBean = sNgpBroadcastStyleBean) == null || TextUtils.isEmpty(ngpBroadcastStyleBean.getVersion())) {
            L.Tag tag = TAG;
            L.w(tag, "initAssetsData fatal. BroadcastStyleBean:" + sBroadcastStyleBean);
            return false;
        }
        L.i(TAG, "readConfigFile success");
        return true;
    }

    private static void parseMaskList() {
        for (BroadcastMaskBean broadcastMaskBean : sBroadcastStyleBean.getData()) {
            if (TYPE_NAVI_NORMAL_BROADCAST.equals(broadcastMaskBean.getType())) {
                sNaviNormalList = broadcastMaskBean.getPlayList();
            } else if (TYPE_NAVI_ACC_NORMAL_BROADCAST.equals(broadcastMaskBean.getType())) {
                sNaviAccNormalList = broadcastMaskBean.getPlayList();
            } else if (TYPE_NAVI_ULTRA_SIMPLE_BROADCAST.equals(broadcastMaskBean.getType())) {
                sNaviUltraSimpleList = broadcastMaskBean.getPlayList();
            } else if (TYPE_NAVI_ACC_ULTRA_SIMPLE_BROADCAST.equals(broadcastMaskBean.getType())) {
                sNaviAccUltraSimpleList = broadcastMaskBean.getPlayList();
            } else if (TYPE_EXPL_BROADCAST.equals(broadcastMaskBean.getType())) {
                sExplList = broadcastMaskBean.getPlayList();
            } else if (TYPE_EXPL_ACC_BROADCAST.equals(broadcastMaskBean.getType())) {
                sExplAccList = broadcastMaskBean.getPlayList();
            }
        }
        for (NgpBroadcastPlayListBean ngpBroadcastPlayListBean : sNgpBroadcastStyleBean.getData()) {
            if (NGP_BROADCAST_DETAIL_TYPE.equals(ngpBroadcastPlayListBean.getType())) {
                sNgpDetailList = ngpBroadcastPlayListBean.getPlayList();
            } else if (NGP_BROADCAST_SIMPLE_TYPE.equals(ngpBroadcastPlayListBean.getType())) {
                sNgpSimpleList = ngpBroadcastPlayListBean.getPlayList();
            }
        }
    }

    public int getCurrentBroadcastStyle() {
        return this.mCurrentBroadcastStyle;
    }

    public int getCurrentNgpBroadcastStyle() {
        return this.mNgpBroadCastType;
    }

    public boolean filterTtsByMode(int i, int i2, String str) {
        if (!sIsInited) {
            L.i(TAG, "filterTtsByMode, not init yet");
            return true;
        }
        boolean filterNavTtsByMode = filterNavTtsByMode(i, i2, str);
        return (filterNavTtsByMode && CarFeatureManager.INSTANCE.isNgpTTSFilterBySoundTypeEnable()) ? filterNgpTtsByMode(i, i2) : filterNavTtsByMode;
    }

    private boolean filterNavTtsByMode(int i, int i2, String str) {
        if (isNeedSrMuteNaviTts(i, i2)) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "filterTtsByMode mute navi tts type:" + i + ",subType:" + i2);
            }
            return false;
        } else if (i < 10000 || (TBTManager.getInstance().getCurrentStatus() != 2 && SRNaviManager.getInstance().isLaneEnabled() && SRNaviManager.getInstance().isXpuShowSREnabled())) {
            if (TBTManager.getInstance().getCurrentStatus() == 1) {
                if (isIgnoreTTSOnStartGuide() && NavCoreUtil.isStartNaviTTS(str)) {
                    return false;
                }
                int i3 = this.mCurrentBroadcastStyle;
                if (2 == i3) {
                    if (this.mIsAccLccOn) {
                        List<Integer> list = sNaviAccNormalList;
                        if (list != null && list.contains(Integer.valueOf(i))) {
                            return true;
                        }
                    } else {
                        List<Integer> list2 = sNaviNormalList;
                        if (list2 != null && list2.contains(Integer.valueOf(i))) {
                            return true;
                        }
                    }
                } else if (3 == i3) {
                    if (this.mIsAccLccOn) {
                        List<Integer> list3 = sNaviAccUltraSimpleList;
                        if (list3 != null && list3.contains(Integer.valueOf(i))) {
                            return true;
                        }
                    } else {
                        List<Integer> list4 = sNaviUltraSimpleList;
                        if (list4 != null && list4.contains(Integer.valueOf(i))) {
                            return true;
                        }
                    }
                } else if (1 == i3) {
                    return true;
                }
            } else if (TBTManager.getInstance().getCurrentStatus() == 2) {
                if (!NavCoreUtil.isExploreNeedPlayTTS(str)) {
                    return false;
                }
                if (this.mIsAccLccOn) {
                    List<Integer> list5 = sExplAccList;
                    if (list5 != null && list5.contains(Integer.valueOf(i))) {
                        return true;
                    }
                } else {
                    List<Integer> list6 = sExplList;
                    if (list6 != null && list6.contains(Integer.valueOf(i))) {
                        return true;
                    }
                }
            } else if (TBTManager.getInstance().getCurrentStatus() == 0) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    private boolean filterNgpTtsByMode(int i, int i2) {
        if (SRNaviManager.getInstance().isNgpState()) {
            int i3 = this.mNgpBroadCastType;
            if (1 == i3) {
                return filterNgpTtsByMode(i, i2, sNgpDetailList);
            }
            if (i3 == 0) {
                return filterNgpTtsByMode(i, i2, sNgpSimpleList);
            }
            return true;
        }
        return true;
    }

    private boolean filterNgpTtsByMode(int i, int i2, List<NgpBroadcastTypeBean> list) {
        for (NgpBroadcastTypeBean ngpBroadcastTypeBean : list) {
            if (i == ngpBroadcastTypeBean.getSoundType().intValue() && (CollectionUtils.isEmpty(ngpBroadcastTypeBean.getSubSoundType()) || ngpBroadcastTypeBean.getSubSoundType().contains(Integer.valueOf(i2)))) {
                return true;
            }
        }
        return false;
    }

    private boolean isNeedSrMuteNaviTts(int i, int i2) {
        if (this.mMutNavTtsStrInfo == null || !SRNaviManager.getInstance().isNgpState()) {
            return false;
        }
        List<MuteType> muteTypes = this.mMutNavTtsStrInfo.getMuteTypes();
        if (CollectionUtils.isNotEmpty(muteTypes)) {
            for (MuteType muteType : muteTypes) {
                List<Integer> subTypes = muteType.getSubTypes();
                if (i == muteType.getType().intValue()) {
                    if (CollectionUtils.isEmpty(subTypes)) {
                        if (L.ENABLE) {
                            L.Tag tag = TAG;
                            L.d(tag, "isNeedSrMuteNaviTts mute by type:" + i);
                        }
                        return true;
                    } else if (subTypes.contains(Integer.valueOf(i2))) {
                        if (L.ENABLE) {
                            L.Tag tag2 = TAG;
                            L.d(tag2, "isNeedSrMuteNaviTts mute by subType,type:" + i + ",subType:" + i2);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public void init() {
        this.mCurrentBroadcastStyle = SettingWrapper.getCurrentBroadcastStyle();
        CarServiceManager.XPolitDriveMode xPolitDriveMode = CarServiceManager.getInstance().getXPolitDriveMode();
        this.mIsAccLccOn = CarServiceManager.XPolitDriveMode.XPOLIT_DRIVE_MODE_ACC == xPolitDriveMode || CarServiceManager.XPolitDriveMode.XPOLIT_DRIVE_MODE_LCC == xPolitDriveMode;
        L.Tag tag = TAG;
        L.i(tag, "init mCurrentBroadcastStyle:" + this.mCurrentBroadcastStyle + ",mIsAccLccOn:" + this.mIsAccLccOn);
        SettingWrapper.addSettingChangeListener(this.mSettingChangeNotify);
        CarServiceManager.getInstance().addCarStateListener(this);
        initSrMuteNaviTtsLevel();
        this.mConfigListener = new SrMuteNaviTtsStrategyConfigListener();
        ConfigurationModuleManager.getInstance().registerWebConfigurationListener(this.mConfigListener);
        this.mNgpBroadCastType = Settings.System.getInt(ContextUtils.getContext().getContentResolver(), SystemTTSContentObserver.KEY_NGP_BROADCAST_TYPE, 1);
        this.mSystemTTSContentObserver = new SystemTTSContentObserver(UiHandlerUtil.getInstance());
        ContextUtils.getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor(SystemTTSContentObserver.KEY_NGP_BROADCAST_TYPE), true, this.mSystemTTSContentObserver);
    }

    private void initSrMuteNaviTtsLevel() {
        SrMuteNaviTtsStrategyInfo srMuteNaviTtsStrategyInfo = (SrMuteNaviTtsStrategyInfo) ConfigurationModuleManager.getInstance().getConfigurationFromDatabase(WebConfigurationEnum.SR_MUTE_NAVI_TTS_STRATEGY, SrMuteNaviTtsStrategyInfo.class);
        if (srMuteNaviTtsStrategyInfo != null) {
            L.i(TAG, "initSrMuteNaviTtsLevel strategy changed with db setting");
            this.mMutNavTtsStrInfo = srMuteNaviTtsStrategyInfo;
        }
        SrMuteNaviTtsStrategyInfo srMuteNaviTtsStrategyInfo2 = this.mMutNavTtsStrInfo;
        String srMuteNaviTtsStrategyInfo3 = srMuteNaviTtsStrategyInfo2 == null ? "null" : srMuteNaviTtsStrategyInfo2.toString();
        L.Tag tag = TAG;
        L.i(tag, "initSrMuteNaviTtsLevel mMutNavTtsStrInfo:" + srMuteNaviTtsStrategyInfo3);
    }

    public void onNgpBroadCastTypeChanged(int i) {
        if (i != this.mNgpBroadCastType) {
            this.mNgpBroadCastType = i;
        }
    }

    public boolean isIgnoreTTSOnStartGuide() {
        return this.mIsIgnoreTTSOnStartGuide;
    }

    public void setIsGuideStartIgnoreTTS(boolean z) {
        this.mIsIgnoreTTSOnStartGuide = z;
    }

    public void updateSrMuteNaviTts(SrMuteNaviTtsStrategyInfo srMuteNaviTtsStrategyInfo) {
        L.Tag tag = TAG;
        L.i(tag, "updateSrMuteNaviTts muteInfo:" + srMuteNaviTtsStrategyInfo);
        this.mMutNavTtsStrInfo = srMuteNaviTtsStrategyInfo;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXPolitDriveModeStatusChange(CarServiceManager.XPolitDriveMode xPolitDriveMode) {
        updateAccLccStatus();
    }

    private void updateAccLccStatus() {
        CarServiceManager.XPolitDriveMode xPolitDriveMode = CarServiceManager.getInstance().getXPolitDriveMode();
        this.mIsAccLccOn = CarServiceManager.XPolitDriveMode.XPOLIT_DRIVE_MODE_ACC == xPolitDriveMode || CarServiceManager.XPolitDriveMode.XPOLIT_DRIVE_MODE_LCC == xPolitDriveMode;
        L.Tag tag = TAG;
        L.i(tag, "onAccLccStatusChange mIsAccLccOn:" + this.mIsAccLccOn);
        SettingBLManager.getInstance().setCruiseBroadcast();
    }
}
