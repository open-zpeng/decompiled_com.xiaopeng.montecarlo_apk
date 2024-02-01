package com.xiaopeng.montecarlo.root.carservice;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.carservice.ICarService;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class CarServiceWrapper {
    public static final int ICM_CONTINUE_ICON = 8;
    public static final int ICM_DESTINATION_ICON = 12;
    public static final int ICM_ENTRY_RING_ICON = 9;
    public static final int ICM_LEAVE_RING_ICON = 10;
    public static final int ICM_TOLL_GATE_ICON = 11;
    public static final int ICM_TUNNEL_ICON = 13;
    public static final int ICM_TURN_HARD_LEFT_ICON = 5;
    public static final int ICM_TURN_HARD_RIGHT_ICON = 6;
    public static final int ICM_TURN_LEFT_ICON = 1;
    public static final int ICM_TURN_LEFT_ROUND_ICON = 7;
    public static final int ICM_TURN_RIGHT_ICON = 2;
    public static final int ICM_TURN_SLIGHT_LEFT_ICON = 3;
    public static final int ICM_TURN_SLIGHT_RIGHT_ICON = 4;
    private static final L.Tag TAG = new L.Tag("CarServiceWrapper");
    private ICarService mCarService;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CarServiceWrapper(@NonNull ICarService iCarService) {
        this.mCarService = iCarService;
    }

    public void connectSystemCarService() {
        this.mCarService.init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        this.mCarService.release();
    }

    public boolean isCarServiceAvailable() {
        return this.mCarService.isCarServiceAvailable();
    }

    public int getCarNedcRemainDistance() {
        return this.mCarService.getCarNedcRemainDistance();
    }

    public int getCarWltpRemainDistance() {
        return this.mCarService.getCarWltpRemainDistance();
    }

    public int getCarCltcRemainDistance() {
        return this.mCarService.getCarCltcRemainDistance();
    }

    public int getEnduranceMileageMode() {
        return this.mCarService.getEnduranceMileageMode();
    }

    public void setEnduranceMileageMode(int i) {
        this.mCarService.setEnduranceMileageMode(i);
    }

    public float getBatteryPercent() {
        return this.mCarService.getBatteryPercent();
    }

    public float getCarSpeed() {
        return this.mCarService.getCarSpeed();
    }

    public void setNaviDestInfo(String str) {
        this.mCarService.setNaviDestInfo(str);
    }

    public void setNaviDestType(int i) {
        this.mCarService.setNaviDestType(i);
    }

    public void setNaviRemainDistance(int i) {
        this.mCarService.setNaviRemainDistance(i);
    }

    public void setNaviRemainTime(int i) {
        this.mCarService.setNaviRemainTime(i);
    }

    public void setNaviPathId(int i) {
        this.mCarService.setNaviPathId(i);
    }

    public void setNaviType(int i) {
        this.mCarService.setNaviType(i);
    }

    public void setNaviKValue(float f) {
        this.mCarService.setNaviKValue(f);
    }

    public boolean isAccOnByStatus() {
        return this.mCarService.isAccOnByStatus();
    }

    public boolean isLccOnByXPilotStatus() {
        return this.mCarService.isLccOnByXPilotStatus();
    }

    public boolean getHVACPowerMode() {
        return this.mCarService.isHVACPowerModeOn();
    }

    public int getIgStatus() {
        return this.mCarService.getIgStatus();
    }

    public int getDriveSeatState() {
        return this.mCarService.getDriveSeatState();
    }

    public int getFarLampState() {
        return this.mCarService.getFarLampState();
    }

    public int getNearLampState() {
        return this.mCarService.getNearLampState();
    }

    public int getGearLevel() {
        return this.mCarService.getGearLevel();
    }

    public void setWeatherInfo(byte[] bArr) {
        this.mCarService.setWeatherInfo(bArr);
    }

    public void setNavigationInfo(byte[] bArr) {
        this.mCarService.setNavigationInfo(bArr);
    }

    public String getHardwareCarType() {
        return this.mCarService.getHardwareCarType();
    }

    public String getXpCduType() {
        return this.mCarService.getXpCduType();
    }

    public String getHardwareCarStage() {
        return this.mCarService.getHardwareCarStage();
    }

    public void setRoadAttributes(int i, int i2) {
        this.mCarService.setRoadAttributes(i, i2);
    }

    public void sendNaviLoadLinkType(int i) {
        this.mCarService.sendNaviLoadLinkType(i);
    }

    public void setDetailRoadClass(int i) {
        this.mCarService.setDetailRoadClass(i);
    }

    public void setListener(ICarService.ICarStateListener iCarStateListener) {
        this.mCarService.registerObserver(iCarStateListener);
    }

    public void reInit(ICarService iCarService) {
        if (this.mCarService != null) {
            release();
            this.mCarService = null;
        }
        this.mCarService = iCarService;
    }

    public String getServiceName() {
        return this.mCarService.getServiceName();
    }

    public boolean getIcmConnectionState() {
        return this.mCarService.getIcmConnectionState();
    }

    public void setIcmNavigationBmp(byte[] bArr) {
        this.mCarService.setIcmNavigationBmp(bArr);
    }

    public void setGpsReset(int i) {
        this.mCarService.setGpsReset(i);
    }

    public boolean getIcmMapDisplayState() {
        return this.mCarService.getIcmMapDisplayState();
    }

    public int getIcmMapWidth() {
        return this.mCarService.getIcmMapWidth();
    }

    public int getIcmMapHeight() {
        return this.mCarService.getIcmMapHeight();
    }

    public int getIcmMapFps() {
        return this.mCarService.getIcmMapFps();
    }

    public int getIcmMapImageType() {
        return this.mCarService.getIcmMapImageType();
    }

    public boolean isTboxApnConnected() {
        return this.mCarService.isApnConnected();
    }

    public int getScuModeIndex() {
        return this.mCarService.getScuModeIndex();
    }

    public boolean isNGPOn() {
        return this.mCarService.isNGPOn();
    }

    public void setFakeData(String str, String str2) {
        this.mCarService.setFakeData(str, str2);
    }

    public ICarService getCarService() {
        return this.mCarService;
    }

    public int getNedcSwitchStatus() {
        return this.mCarService.getNedcSwitchStatus();
    }

    public int getCruiseSpeed() {
        return this.mCarService.getCruiseSpeed();
    }

    public int getScuQuitNgpOddStatus() {
        return this.mCarService.getScuQuitNgpOddStatus();
    }

    public int getScuNgpOpeButtonStatus() {
        return this.mCarService.getScuNgpOpeButtonStatus();
    }

    public void setScuNgpOpeButtonStatus(int i) {
        this.mCarService.setScuNgpOpeButtonStatus(i);
    }

    public int getScuNgpLcTips1Status() {
        return this.mCarService.getScuNgpLcTips1Status();
    }

    public int getScuNgpInfoTips1Status() {
        return this.mCarService.getScuNgpInfoTips1Status();
    }

    public int getScuNgpTipsWindowStatus() {
        return this.mCarService.getScuNgpTipsWindowStatus();
    }

    public void setScuNgpTipsWindowStatus(int i) {
        this.mCarService.setScuNgpTipsWindowStatus(i);
    }

    public int sendSrRdCdu2XpuNgpTrajectoryV2Data(byte[] bArr) {
        return this.mCarService.sendSrRdCdu2XpuNgpTrajectoryV2Data(bArr);
    }

    public void stopNaviRoutingInfoRequest(long j) {
        this.mCarService.stopNaviRoutingInfoRequest(j);
    }

    public void updateNaviPathNaviRoutingInfoRequest(long j) {
        this.mCarService.updateNaviPathNaviRoutingInfoRequest(j);
    }

    public void setICarXPUDataCallBack(ICarService.ICarXPUDataCallBack iCarXPUDataCallBack) {
        this.mCarService.setICarXPUDataCallBack(iCarXPUDataCallBack);
    }

    public void swtichTBOXGpsLog(boolean z) {
        this.mCarService.swtichTBOXGpsLog(z);
    }

    public boolean isTBOXGpsLogOperSucceed() {
        return this.mCarService.isTBOXGpsLogOperSucceed();
    }

    public void setCurrentRoadSpeedLimit(int i) {
        this.mCarService.setCurrentRoadSpeedLimit(i);
    }

    public void setCurrentElectronicEyeSpeedLimitAndDistance(int i, int i2) {
        this.mCarService.setCurrentElectronicEyeSpeedLimitAndDistance(i, i2);
    }

    public void setIntelligentSpeedLimitValue(int i) {
        this.mCarService.setIntelligentSpeedLimitValue(i);
    }

    public int getBcmPowerMode() {
        return this.mCarService.getBcmPowerMode();
    }

    public int getFactoryMode() {
        return this.mCarService.getFactoryMode();
    }

    public void setNaviRoadConnectAttrib(int i) {
        this.mCarService.setNaviRoadConnectAttrib(i);
    }

    public void setNaviDangerAreaRDInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.mCarService.setNaviDangerAreaRDInfo(i, i2, i3, i4, i5, i6, i7);
    }

    public void setEventInfoRD(int i) {
        this.mCarService.setEventInfoRD(i);
    }
}
