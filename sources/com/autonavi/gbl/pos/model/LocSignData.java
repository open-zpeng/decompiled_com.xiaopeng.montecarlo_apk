package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
/* loaded from: classes2.dex */
public class LocSignData {
    public LocAcce3d acce3D;
    public LocAirPressure airPressure;
    public LocAllFusionPos allFusionPos;
    @LocDataType.LocDataType1
    public int dataType;
    public LocDoorIn doorIn;
    public LocDrPos drPos;
    public LocDriveComfort driveComfot;
    public LocDriveEvent driveEvent;
    public LocDriveMode driveMode;
    public LocDriveSig driveSig;
    public LocECompass eCompass;
    public LocGnss gnss;
    public LocGnssMeasurement gnssMeasurement;
    public LocGpgsv gpgsv;
    public LocGyro gyro;
    public LocLight light;
    public LocTRInfo locTRInfo;
    public LocVision locVision;
    public LocVisualObj locVisualObj;
    public LocW4M locW4M;
    public LocW4MTR locW4MTR;
    public LocMagnetic magnetic;
    public LocNema nema;
    public LocOrientation orientation;
    public LocPulse pulse;
    public LocSpeedometer speedometer;
    public LocVDRInfo vdr;
    public LocVDRSignal vdrSignal;
    public LocVisionLocate vision;

    public LocSignData() {
        this.dataType = 0;
        this.eCompass = new LocECompass();
        this.gyro = new LocGyro();
        this.pulse = new LocPulse();
        this.acce3D = new LocAcce3d();
        this.gnss = new LocGnss();
        this.airPressure = new LocAirPressure();
        this.drPos = new LocDrPos();
        this.gpgsv = new LocGpgsv();
        this.doorIn = new LocDoorIn();
        this.driveMode = new LocDriveMode();
        this.driveSig = new LocDriveSig();
        this.driveEvent = new LocDriveEvent();
        this.driveComfot = new LocDriveComfort();
        this.locW4M = new LocW4M();
        this.locW4MTR = new LocW4MTR();
        this.locTRInfo = new LocTRInfo();
        this.magnetic = new LocMagnetic();
        this.vdrSignal = new LocVDRSignal();
        this.light = new LocLight();
        this.vdr = new LocVDRInfo();
        this.gnssMeasurement = new LocGnssMeasurement();
        this.orientation = new LocOrientation();
        this.nema = new LocNema();
        this.speedometer = new LocSpeedometer();
        this.vision = new LocVisionLocate();
        this.locVision = new LocVision();
        this.locVisualObj = new LocVisualObj();
        this.allFusionPos = new LocAllFusionPos();
    }

    public LocSignData(@LocDataType.LocDataType1 int i, LocECompass locECompass, LocGyro locGyro, LocPulse locPulse, LocAcce3d locAcce3d, LocGnss locGnss, LocAirPressure locAirPressure, LocDrPos locDrPos, LocGpgsv locGpgsv, LocDoorIn locDoorIn, LocDriveMode locDriveMode, LocDriveSig locDriveSig, LocDriveEvent locDriveEvent, LocDriveComfort locDriveComfort, LocW4M locW4M, LocW4MTR locW4MTR, LocTRInfo locTRInfo, LocMagnetic locMagnetic, LocVDRSignal locVDRSignal, LocLight locLight, LocVDRInfo locVDRInfo, LocGnssMeasurement locGnssMeasurement, LocOrientation locOrientation, LocNema locNema, LocSpeedometer locSpeedometer, LocVisionLocate locVisionLocate, LocVision locVision, LocVisualObj locVisualObj, LocAllFusionPos locAllFusionPos) {
        this.dataType = i;
        this.eCompass = locECompass;
        this.gyro = locGyro;
        this.pulse = locPulse;
        this.acce3D = locAcce3d;
        this.gnss = locGnss;
        this.airPressure = locAirPressure;
        this.drPos = locDrPos;
        this.gpgsv = locGpgsv;
        this.doorIn = locDoorIn;
        this.driveMode = locDriveMode;
        this.driveSig = locDriveSig;
        this.driveEvent = locDriveEvent;
        this.driveComfot = locDriveComfort;
        this.locW4M = locW4M;
        this.locW4MTR = locW4MTR;
        this.locTRInfo = locTRInfo;
        this.magnetic = locMagnetic;
        this.vdrSignal = locVDRSignal;
        this.light = locLight;
        this.vdr = locVDRInfo;
        this.gnssMeasurement = locGnssMeasurement;
        this.orientation = locOrientation;
        this.nema = locNema;
        this.speedometer = locSpeedometer;
        this.vision = locVisionLocate;
        this.locVision = locVision;
        this.locVisualObj = locVisualObj;
        this.allFusionPos = locAllFusionPos;
    }
}
