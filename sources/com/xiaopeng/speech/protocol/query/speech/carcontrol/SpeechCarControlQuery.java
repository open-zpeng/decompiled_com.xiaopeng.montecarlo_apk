package com.xiaopeng.speech.protocol.query.speech.carcontrol;

import com.xiaopeng.speech.SpeechQuery;
import com.xiaopeng.speech.annotation.QueryAnnotation;
import com.xiaopeng.speech.protocol.event.query.speech.SpeechCarControlEvent;
/* loaded from: classes3.dex */
public class SpeechCarControlQuery extends SpeechQuery<ISpeechCarControlQueryCaller> {
    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.LAMP_REARFOG)
    public boolean getRearFogLamp(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getRearFogLamp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.LAMP_NEAR)
    public boolean getNearLampState(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getNearLampState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.LAMP_LOCATION)
    public boolean getLocationLampState(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getLocationLampState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.LAMP_FAR)
    public boolean getFarLampState(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getFarLampState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.LAMP_HEADGROUP)
    public int getHeadLampGroup(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getHeadLampGroup();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.LAMP_INNER)
    public boolean getInternalLight(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getInternalLight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.BRAKE_WARN)
    public boolean getEmergencyBrakeWarning(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getEmergencyBrakeWarning();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.ATWS_STATE)
    public int getATWSState(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getATWSState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.OLED_STATE)
    public int getOled(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getOled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.LIGHTMEHOME_STATE)
    public int getLightMeHome(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getLightMeHome();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.LOCK_DRIVE_AUTIO)
    public boolean getDriveAutoLock(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getDriveAutoLock();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.LOCK_PARKING_AUTIO)
    public boolean getParkingAutoUnlock(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getParkingAutoUnlock();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.LOCK_STATE)
    public boolean getDoorLockState(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getDoorLockState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.TRUNK_STATE)
    public int getTrunk(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getTrunk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.TRUNK_OPENNER_STATE)
    public int getTrunkOpennerState(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getTrunkOpennerStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.MODE_WELCOME_STATE)
    public boolean getChairWelcomeMode(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getChairWelcomeMode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.BELT_ELECTRIC_STATE)
    public boolean getElectricSeatBelt(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getElectricSeatBelt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.BELT_REARSEAT_STATE)
    public boolean getRearSeatBeltWarning(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getRearSeatBeltWarning();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.LOCK_UNLOCK_RESPONSE)
    public int getUnlockResponse(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getUnlockResponse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.DOOR_STATE)
    public int[] getDoorsState(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getDoorsState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.WINDOW_STATE)
    public float[] getWindowsState(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getWindowsState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.SEAT_DIRECTION)
    public int[] getChairDirection(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getChairDirection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.SEAT_ERROR)
    public boolean getSeatErrorState(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getSeatErrorState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.SEAT_POSITION)
    public int[] getChairLocationValue(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getChairLocationValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.PASSENGER_SEAT_POSITION)
    public int[] getPassengerChairLocationValue(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getPassengerChairLocationValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.SEAT_WELCOME_MODE_STATE)
    public boolean getWelcomeModeBackStatus(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getWelcomeModeBackStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.DRIVE_MODE)
    public int getDrivingMode(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getDrivingMode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.STEER_EPS)
    public int getSteeringWheelEPS(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getSteeringWheelEPS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.ICM_VOLUME_WARN)
    public int getIcmAlarmVolume(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getIcmAlarmVolume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.SPEED_LIMIT_STATE)
    public boolean getSpeedLimitWarningSwitch(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getSpeedLimitWarningSwitch();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.SPEED_LIMIT_VALUE)
    public int getSpeedLimitWarningValue(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getSpeedLimitWarningValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.METER_A)
    public double getMeterMileageA(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getMeterMileageA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.METER_B)
    public double getMeterMileageB(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getMeterMileageB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.METER_TOTAL)
    public double getDriveTotalMileage(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getDriveTotalMileage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.METER_LAST_CHARGE)
    public double getLastChargeMileage(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getLastChargeMileage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.METER_LAST_START)
    public double getLastStartUpMileage(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getLastStartUpMileage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.FRONT_COLLISION_STATE)
    public int getFrontCollisionSecurity(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getFrontCollisionSecurity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.METER_LIMIT_INTEL)
    public int getIntelligentSpeedLimit(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getIntelligentSpeedLimit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.LANE_CHANGE_ASSIST_STATE)
    public int getLaneChangeAssist(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getLaneChangeAssist();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.WARN_SIDE_REVER_STATE)
    public int getSideReversingWarning(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getSideReversingWarning();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.WARN_LANE_DEPARTURE_STATE)
    public int getLaneDepartureWarning(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getLaneDepartureWarning();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.WARN_BLIND_AREA_STATE)
    public int getBlindAreaDetectionWarning(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getBlindAreaDetectionWarning();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.WARN_RADAR_SLOW_STATE)
    public boolean getRadarWarningVoiceStatus(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getRadarWarningVoiceStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.RECYCLE_LV)
    public int getEnergyRecycleLevel(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getEnergyRecycleLevel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.SHIFT_STATE)
    public int getShiftStatus(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getShiftStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.SEAT_MAIN_HUMAN_STATE)
    public int getDriverSeatStatus(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getDriverSeatStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.SEAT_PASSENGER_HUMAN_STATE)
    public int getPassengerSeatStatus(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getPassengerSeatStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.ROTATION_STEER)
    public double getSteerWheelRotationAngle(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getSteerWheelRotationAngle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.SPEED_CAR)
    public double getCarSpeed(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getCarSpeed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.ICM_STATE)
    public boolean getIcmConnectionState(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getIcmConnectionState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.IG_STATE)
    public int getBCMIgStatus(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getBCMIgStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.ICM_WIND_MODE)
    public int getICMWindBlowMode(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getICMWindBlowMode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.ICM_DRIVER_TEMP)
    public double getICMDriverTempValue(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getICMDriverTempValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.ICM_WIND_LV)
    public int getICMWindLevel(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getICMWindLevel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.IS_CAR_TRIP)
    public boolean isCarTrip(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).isCarTrip();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.GET_WIPER_LEVEL)
    public int getWiperInterval(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getWiperInterval();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.GET_TIRE_PRESSURE)
    public float[] getTirePressureAll(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getTirePressureAll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.GET_TIRE_PRESSURE_WARNINGS)
    public int[] getAllTirePressureWarnings(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getAllTirePressureWarnings();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.ACC_STATE)
    public int getACCStatus(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getACCStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.LCC_STATE)
    public int getLCCStatus(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getLCCStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.WINDOW_LOCK_STATE)
    public int getWindowLockStatus(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getWindowLockStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.GET_STATUS_LOW_SOC)
    public int getLowSocStatus(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getLowSocStatus();
    }

    protected int getRiseSpeakerStatus(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getRiseSpeakerStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.GET_CRUISE_CONTROL_STATUS)
    public int getCruiseControlStatus(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getCruiseActive();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.GET_SYSTEM_FAULT_WARN_LAMP_STATUS)
    public int getSystemFaultWarnLampStatus(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getSystemFaultWarnLampStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechCarControlEvent.GET_ABNORMAL_TIRE_PRESSURE_STATUS)
    public int getAbnormalTirePressureState(String str, String str2) {
        return ((ISpeechCarControlQueryCaller) this.mQueryCaller).getAbnormalTirePressureState();
    }
}
