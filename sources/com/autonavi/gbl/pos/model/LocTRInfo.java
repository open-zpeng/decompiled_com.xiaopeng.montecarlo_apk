package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DInt32;
import com.autonavi.gbl.common.path.model.Formway;
import com.autonavi.gbl.pos.model.LocAirOverheadType;
import com.autonavi.gbl.pos.model.LocDataType;
import com.autonavi.gbl.pos.model.LocDriveSceneType;
import com.autonavi.gbl.pos.model.LocMoveStatus;
import com.autonavi.gbl.pos.model.LocRecognitionType;
import com.autonavi.gbl.pos.model.LocSatelliteQualityType;
import com.autonavi.gbl.pos.model.LocSlopeType;
import com.autonavi.gbl.pos.model.LocTrajectoryType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocTRInfo implements Serializable {
    public float accuracy;
    @LocAirOverheadType.LocAirOverheadType1
    public int airOverheadType;
    public float alt;
    public float course;
    @LocDataType.LocDataType1
    public int dataType;
    @LocDriveSceneType.LocDriveSceneType1
    public int driveSceneType;
    @Formway.Formway1
    public int formway;
    public GPSDatetime gpsDateTime;
    public BigInteger linkId;
    @LocMoveStatus.LocMoveStatus1
    public int moveStatus;
    public String offlineDataVersion;
    public Coord3DInt32 pos;
    public float pulseSpeed;
    public boolean pulseValueValid;
    @LocRecognitionType.LocRecognitionType1
    public int recognitionType;
    public float roadCourse;
    @LocSatelliteQualityType.LocSatelliteQualityType1
    public int satelliteQualityType;
    public float slopeAngle;
    @LocSlopeType.LocSlopeType1
    public int slopeType;
    public boolean slopeValueValid;
    public float speed;
    public BigInteger tickTime;
    @LocTrajectoryType.LocTrajectoryType1
    public int trajectoryType;

    public LocTRInfo() {
        this.dataType = 0;
        this.tickTime = new BigInteger("0");
        this.trajectoryType = 0;
        this.pos = new Coord3DInt32();
        this.course = 0.0f;
        this.speed = 0.0f;
        this.alt = 0.0f;
        this.accuracy = 0.0f;
        this.recognitionType = 0;
        this.linkId = new BigInteger("0");
        this.roadCourse = 0.0f;
        this.formway = -1;
        this.slopeType = 0;
        this.driveSceneType = 0;
        this.satelliteQualityType = 0;
        this.moveStatus = 0;
        this.pulseValueValid = false;
        this.pulseSpeed = 0.0f;
        this.slopeValueValid = false;
        this.slopeAngle = 0.0f;
        this.airOverheadType = 0;
        this.gpsDateTime = new GPSDatetime();
        this.offlineDataVersion = "";
    }

    public LocTRInfo(@LocDataType.LocDataType1 int i, BigInteger bigInteger, @LocTrajectoryType.LocTrajectoryType1 int i2, Coord3DInt32 coord3DInt32, float f, float f2, float f3, float f4, @LocRecognitionType.LocRecognitionType1 int i3, BigInteger bigInteger2, float f5, @Formway.Formway1 int i4, @LocSlopeType.LocSlopeType1 int i5, @LocDriveSceneType.LocDriveSceneType1 int i6, @LocSatelliteQualityType.LocSatelliteQualityType1 int i7, @LocMoveStatus.LocMoveStatus1 int i8, boolean z, float f6, boolean z2, float f7, @LocAirOverheadType.LocAirOverheadType1 int i9, GPSDatetime gPSDatetime, String str) {
        this.dataType = i;
        this.tickTime = bigInteger;
        this.trajectoryType = i2;
        this.pos = coord3DInt32;
        this.course = f;
        this.speed = f2;
        this.alt = f3;
        this.accuracy = f4;
        this.recognitionType = i3;
        this.linkId = bigInteger2;
        this.roadCourse = f5;
        this.formway = i4;
        this.slopeType = i5;
        this.driveSceneType = i6;
        this.satelliteQualityType = i7;
        this.moveStatus = i8;
        this.pulseValueValid = z;
        this.pulseSpeed = f6;
        this.slopeValueValid = z2;
        this.slopeAngle = f7;
        this.airOverheadType = i9;
        this.gpsDateTime = gPSDatetime;
        this.offlineDataVersion = str;
    }
}
