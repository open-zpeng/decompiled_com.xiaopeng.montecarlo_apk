package com.autonavi.gbl.guide.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DriveReport implements Serializable {
    public NaviStatisticsInfo blNaviStatisticsInfo;
    public ArrayList<DriveEvent> driverEventList;
    public int vehicleType;

    public DriveReport() {
        this.vehicleType = 0;
        this.driverEventList = new ArrayList<>();
        this.blNaviStatisticsInfo = new NaviStatisticsInfo();
    }

    public DriveReport(int i, ArrayList<DriveEvent> arrayList, NaviStatisticsInfo naviStatisticsInfo) {
        this.vehicleType = i;
        this.driverEventList = arrayList;
        this.blNaviStatisticsInfo = naviStatisticsInfo;
    }
}
