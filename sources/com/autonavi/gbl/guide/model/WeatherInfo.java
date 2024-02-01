package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WeatherInfo implements Serializable {
    public int alertLevelID;
    public String alertLevelName;
    public int distanceToCar;
    public int weatherID;
    public String weatherName;

    public WeatherInfo() {
        this.weatherName = "";
        this.alertLevelName = "";
        this.weatherID = 0;
        this.alertLevelID = 0;
        this.distanceToCar = 0;
    }

    public WeatherInfo(String str, String str2, int i, int i2, int i3) {
        this.weatherName = str;
        this.alertLevelName = str2;
        this.weatherID = i;
        this.alertLevelID = i2;
        this.distanceToCar = i3;
    }
}
