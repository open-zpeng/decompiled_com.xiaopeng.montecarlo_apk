package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GMojiWeatherForecast implements Serializable {
    public String conditionDay;
    public String conditionNight;
    public String dateDesc;
    public String iconDay;
    public int iconDayNum;
    public String iconNight;
    public int iconNightNum;
    public String predictDate;
    public int tempHigh;
    public int tempLow;

    public GMojiWeatherForecast() {
        this.tempHigh = 0;
        this.tempLow = 0;
        this.iconDayNum = 0;
        this.iconNightNum = 0;
        this.iconDay = "";
        this.iconNight = "";
        this.conditionDay = "";
        this.conditionNight = "";
        this.predictDate = "";
        this.dateDesc = "";
    }

    public GMojiWeatherForecast(int i, int i2, int i3, int i4, String str, String str2, String str3, String str4, String str5, String str6) {
        this.tempHigh = i;
        this.tempLow = i2;
        this.iconDayNum = i3;
        this.iconNightNum = i4;
        this.iconDay = str;
        this.iconNight = str2;
        this.conditionDay = str3;
        this.conditionNight = str4;
        this.predictDate = str5;
        this.dateDesc = str6;
    }
}
