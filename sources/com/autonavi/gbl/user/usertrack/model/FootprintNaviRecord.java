package com.autonavi.gbl.user.usertrack.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class FootprintNaviRecord implements Serializable {
    public String actualDest;
    public boolean arrived;
    public CarNaviData carNavi;
    public String destination;
    public String month;
    public int monthActTimes;
    public int monthDistance;
    public String naviId;
    public String origin;

    public FootprintNaviRecord() {
        this.arrived = false;
        this.monthActTimes = 0;
        this.monthDistance = 0;
        this.month = "";
        this.origin = "";
        this.destination = "";
        this.actualDest = "";
        this.naviId = "";
        this.carNavi = new CarNaviData();
    }

    public FootprintNaviRecord(boolean z, int i, int i2, String str, String str2, String str3, String str4, String str5, CarNaviData carNaviData) {
        this.arrived = z;
        this.monthActTimes = i;
        this.monthDistance = i2;
        this.month = str;
        this.origin = str2;
        this.destination = str3;
        this.actualDest = str4;
        this.naviId = str5;
        this.carNavi = carNaviData;
    }
}
