package com.autonavi.gbl.user.usertrack.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class CarNaviData implements Serializable {
    public int avgSpeed;
    public String avgSpeedDesc;
    public String avgSpeedUnit;
    public int distance;
    public int duration;
    public int maxSpeed;
    public String maxSpeedDesc;
    public String maxSpeedUnit;

    public CarNaviData() {
        this.duration = 0;
        this.distance = 0;
        this.avgSpeed = 0;
        this.maxSpeed = 0;
        this.avgSpeedDesc = "";
        this.avgSpeedUnit = "";
        this.maxSpeedDesc = "";
        this.maxSpeedUnit = "";
    }

    public CarNaviData(int i, int i2, int i3, int i4, String str, String str2, String str3, String str4) {
        this.duration = i;
        this.distance = i2;
        this.avgSpeed = i3;
        this.maxSpeed = i4;
        this.avgSpeedDesc = str;
        this.avgSpeedUnit = str2;
        this.maxSpeedDesc = str3;
        this.maxSpeedUnit = str4;
    }
}
