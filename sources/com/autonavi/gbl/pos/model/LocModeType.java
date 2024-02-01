package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.ELaneAlgType;
import com.autonavi.gbl.pos.model.LocType;
import com.autonavi.gbl.pos.model.LocWorkMode;
import com.autonavi.gbl.pos.model.PlatformType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocModeType implements Serializable {
    public int funcs;
    @ELaneAlgType.ELaneAlgType1
    public int laneAlgType;
    public String locStorageForOverwrite;
    @LocType.LocType1
    public int locType;
    public LocMountAngle mountAngle;
    public int onlineDataLimit;
    @PlatformType.PlatformType1
    public int platformType;
    public LocSensorOption sensorOption;
    public int signalTypes;
    public BigInteger sysInitTime;
    @LocWorkMode.LocWorkMode1
    public int workMode;

    public LocModeType() {
        this.locType = 0;
        this.funcs = 8848576;
        this.mountAngle = new LocMountAngle();
        this.sensorOption = new LocSensorOption();
        this.signalTypes = 0;
        this.platformType = 1;
        this.laneAlgType = 0;
        this.workMode = 0;
        this.sysInitTime = new BigInteger("0");
        this.onlineDataLimit = 1024;
        this.locStorageForOverwrite = "";
    }

    public LocModeType(@LocType.LocType1 int i, int i2, LocMountAngle locMountAngle, LocSensorOption locSensorOption, int i3, @PlatformType.PlatformType1 int i4, @ELaneAlgType.ELaneAlgType1 int i5, @LocWorkMode.LocWorkMode1 int i6, BigInteger bigInteger, int i7, String str) {
        this.locType = i;
        this.funcs = i2;
        this.mountAngle = locMountAngle;
        this.sensorOption = locSensorOption;
        this.signalTypes = i3;
        this.platformType = i4;
        this.laneAlgType = i5;
        this.workMode = i6;
        this.sysInitTime = bigInteger;
        this.onlineDataLimit = i7;
        this.locStorageForOverwrite = str;
    }
}
