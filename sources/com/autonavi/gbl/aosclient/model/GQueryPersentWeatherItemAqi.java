package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GQueryPersentWeatherItemAqi implements Serializable {
    public String aqiQualityLevel;
    public int pm10;
    public int pm25;
    public int value;

    public GQueryPersentWeatherItemAqi() {
        this.aqiQualityLevel = "";
        this.value = 0;
        this.pm25 = 0;
        this.pm10 = 0;
    }

    public GQueryPersentWeatherItemAqi(String str, int i, int i2, int i3) {
        this.aqiQualityLevel = str;
        this.value = i;
        this.pm25 = i2;
        this.pm10 = i3;
    }
}
