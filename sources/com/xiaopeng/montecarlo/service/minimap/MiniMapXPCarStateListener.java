package com.xiaopeng.montecarlo.service.minimap;

import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
/* loaded from: classes3.dex */
public class MiniMapXPCarStateListener implements CarServiceManager.IXPCarStateListener {
    private MiniMapServiceHelper mMiniMapServiceHelper;

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onBCMDriveSeatStateChange(int i) {
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
    public void onImuNavDataChange(float[] fArr) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onRawCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXPolitDriveModeStatusChange(CarServiceManager.XPolitDriveMode xPolitDriveMode) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXpuNedcStatusChange(int i) {
    }

    public MiniMapXPCarStateListener(MiniMapServiceHelper miniMapServiceHelper) {
        this.mMiniMapServiceHelper = miniMapServiceHelper;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onCarSpeedChange(float f) {
        if (f <= 1.0f || !TBTManager.getInstance().isMiniMapEnable()) {
            return;
        }
        RootUtil.updateMapOperationTimeTick();
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmConnectionStateChange(final boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapXPCarStateListener.1
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    return;
                }
                MiniMapXPCarStateListener.this.mMiniMapServiceHelper.updateMiniMapDisplayState(false);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapDisplayStateChange(final boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapXPCarStateListener.2
            @Override // java.lang.Runnable
            public void run() {
                MiniMapXPCarStateListener.this.mMiniMapServiceHelper.updateMiniMapDisplayState(z);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapSizeChange(final int i, final int i2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapXPCarStateListener.3
            @Override // java.lang.Runnable
            public void run() {
                MiniMapXPCarStateListener.this.mMiniMapServiceHelper.updateMiniMapSize(i, i2);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapFpsChange(final int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapXPCarStateListener.4
            @Override // java.lang.Runnable
            public void run() {
                MiniMapXPCarStateListener.this.mMiniMapServiceHelper.updateFps(i);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapImageTypeChange(final int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapXPCarStateListener.5
            @Override // java.lang.Runnable
            public void run() {
                MiniMapXPCarStateListener.this.mMiniMapServiceHelper.updateMapImageType(i);
            }
        });
    }
}
