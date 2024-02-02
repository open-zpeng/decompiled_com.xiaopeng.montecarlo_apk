package com.autonavi.gbl.guide.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NaviWeatherInfo implements Serializable {
    public long pathID;
    public ArrayList<WeatherInfo> weatherInfo;

    public NaviWeatherInfo() {
        this.weatherInfo = new ArrayList<>();
        this.pathID = 0L;
    }

    public NaviWeatherInfo(ArrayList<WeatherInfo> arrayList, long j) {
        this.weatherInfo = arrayList;
        this.pathID = j;
    }
}
