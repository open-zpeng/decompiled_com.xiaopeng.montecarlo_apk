package com.xiaopeng.montecarlo.navcore.setting;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.autonavi.gbl.layer.model.BizRouteType;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class SettingBLManager {
    private IMapDelegate mMapDelegate;
    private static final SettingBLManager sINSTANCE = new SettingBLManager();
    private static final L.Tag TAG = new L.Tag("SettingBLManager");

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SettingBLType {
    }

    public void resetBLDefaultSetting(Context context) {
    }

    private SettingBLManager() {
    }

    @NonNull
    public static SettingBLManager getInstance() {
        return sINSTANCE;
    }

    public static boolean isRadarEnableInNavigation() {
        return !TBTManager.getInstance().isSimulateGuidance() && (TBTManager.getInstance().getCurrentStatus() != 1 || SettingWrapper.isOpenRadar());
    }

    public boolean deleteUserDatas() {
        return FavoriteDataManager.getInstance().deleteUserData() >= 0;
    }

    public void setMapDelegate(IMapDelegate iMapDelegate) {
        this.mMapDelegate = iMapDelegate;
    }

    public void setTrafficState() {
        boolean isRealTimeTraffic = SettingWrapper.isRealTimeTraffic();
        IMapDelegate iMapDelegate = this.mMapDelegate;
        if (iMapDelegate != null) {
            iMapDelegate.setTrafficState(isRealTimeTraffic);
            this.mMapDelegate.updateTrafficLayerState();
        }
        if (TBTManager.getInstance().isMiniMapEnable()) {
            Intent intent = new Intent();
            intent.setClassName(ContextUtils.getContext().getPackageName(), "com.xiaopeng.montecarlo.service.minimap.MiniMapService");
            intent.setAction("com.xiaopeng.montecarlo.minimap.ACTION_REALTIME_TRAFFIC_CHANGE");
            intent.putExtra("realtime_traffic_state", isRealTimeTraffic);
            ContextUtils.getContext().startService(intent);
            L.i(TAG, "MiniMapService startService ACTION_REALTIME_TRAFFIC_CHANGE in setting_real_time_traffic_switch_btn");
        }
    }

    public void initPlayStyle() {
        TBTManager.getInstance().setPlayStyle(1);
    }

    public void setCruiseBroadcast() {
        CarServiceManager.XPolitDriveMode xPolitDriveMode = CarServiceManager.getInstance().getXPolitDriveMode();
        boolean z = CarServiceManager.XPolitDriveMode.XPOLIT_DRIVE_MODE_ACC == xPolitDriveMode || CarServiceManager.XPolitDriveMode.XPOLIT_DRIVE_MODE_LCC == xPolitDriveMode;
        boolean isCruiseElectronicEyeBroadcast = SettingWrapper.isCruiseElectronicEyeBroadcast();
        L.Tag tag = TAG;
        L.i(tag, "setCruiseBroadcast isAccLccOn:" + z + ", isCruiseElectronicEyeBroadcast:" + isCruiseElectronicEyeBroadcast);
        if (z) {
            TBTManager.getInstance().setCruiseAheadTraffic(true);
            if (isCruiseElectronicEyeBroadcast) {
                TBTManager.getInstance().setCruiseOpenCamera(3);
                return;
            } else {
                TBTManager.getInstance().setCruiseOpenCamera(2);
                return;
            }
        }
        boolean isCruiseAheadTraffict = SettingWrapper.isCruiseAheadTraffict();
        boolean isCruiseSafetyBroadcast = SettingWrapper.isCruiseSafetyBroadcast();
        L.Tag tag2 = TAG;
        L.i(tag2, "setCruiseBroadcast isCruiseAheadTraffict:" + isCruiseAheadTraffict + ", isCruiseSafetyBroadcast:" + isCruiseSafetyBroadcast);
        if (isCruiseAheadTraffict) {
            TBTManager.getInstance().setCruiseAheadTraffic(true);
        } else {
            TBTManager.getInstance().setCruiseAheadTraffic(false);
        }
        if (isCruiseElectronicEyeBroadcast && isCruiseSafetyBroadcast) {
            TBTManager.getInstance().setCruiseOpenCamera(3);
        } else if (isCruiseElectronicEyeBroadcast && !isCruiseSafetyBroadcast) {
            TBTManager.getInstance().setCruiseOpenCamera(1);
        } else if (!isCruiseElectronicEyeBroadcast && isCruiseSafetyBroadcast) {
            TBTManager.getInstance().setCruiseOpenCamera(2);
        } else {
            TBTManager.getInstance().setCruiseOpenCamera(0);
        }
    }

    public void setDayNightMode() {
        boolean isDayNightModeAuto = SettingWrapper.isDayNightModeAuto();
        boolean isDayNightModeDay = SettingWrapper.isDayNightModeDay();
        boolean isDayNightModeNight = SettingWrapper.isDayNightModeNight();
        if (isDayNightModeAuto) {
            if (L.ENABLE) {
                L.d(TAG, "open DAY_NIGHT_MODE_AUTO");
            }
        } else if (isDayNightModeDay) {
            TBTManager.getInstance().setDayNightMode(1);
            if (L.ENABLE) {
                L.d(TAG, "open DayNightMode_DAY");
            }
        } else if (isDayNightModeNight) {
            TBTManager.getInstance().setDayNightMode(0);
            if (L.ENABLE) {
                L.d(TAG, "open DAY_NIGHT_MODE_NIGHT");
            }
        }
    }

    public void setRadarState() {
        int currentStatus = TBTManager.getInstance().getCurrentStatus();
        if ((currentStatus == 1 || currentStatus == 2) && TBTManager.getInstance().isMiniMapEnable()) {
            Intent intent = new Intent();
            intent.setClassName(ContextUtils.getContext().getPackageName(), "com.xiaopeng.montecarlo.service.minimap.MiniMapService");
            intent.setAction("com.xiaopeng.montecarlo.minimap.ACTION_RADAR_STATUS_CHANGE");
            ContextUtils.getContext().startService(intent);
            L.i(TAG, "MiniMapService startService ACTION_RADAR_STATUS_CHANGE in setRadarState");
        }
    }

    public void setAlternativePathLabelVisible(boolean z) {
        IMapDelegate iMapDelegate = this.mMapDelegate;
        if (iMapDelegate != null) {
            iMapDelegate.setBizRouteOverlayVisible(BizRouteType.BizRouteTypeGuideLabel, z);
        }
    }

    public void setVehicleId(String str) {
        TBTManager.getInstance().setVehicleId(str);
    }

    public void setETARestriction() {
        TBTManager.getInstance().setETARestriction(SettingWrapper.isOpenPlateSwitch());
    }
}
