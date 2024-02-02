package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GQueryWeatherByLinkAckDataWeather implements Serializable {
    public ArrayList<Integer> adcodes;
    public int alertLevelId;
    public String alertLevelName;
    public ArrayList<Long> linkids;
    public int temperature;
    public long time;
    public int weatherId;
    public String weatherName;

    public GQueryWeatherByLinkAckDataWeather() {
        this.weatherId = 0;
        this.weatherName = "";
        this.temperature = 0;
        this.linkids = new ArrayList<>();
        this.adcodes = new ArrayList<>();
        this.time = 0L;
        this.alertLevelId = 0;
        this.alertLevelName = "";
    }

    public GQueryWeatherByLinkAckDataWeather(int i, String str, int i2, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2, long j, int i3, String str2) {
        this.weatherId = i;
        this.weatherName = str;
        this.temperature = i2;
        this.linkids = arrayList;
        this.adcodes = arrayList2;
        this.time = j;
        this.alertLevelId = i3;
        this.alertLevelName = str2;
    }
}
