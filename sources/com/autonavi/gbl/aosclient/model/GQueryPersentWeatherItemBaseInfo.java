package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GQueryPersentWeatherItemBaseInfo implements Serializable {
    public ArrayList<Integer> adcodes;
    public int humidity;
    public ArrayList<Long> links;
    public ArrayList<GQueryPersentWeatherReqItemPoint> points;
    public int temperature;
    public long updateTime;
    public int weatherId;
    public String weatherName;

    public GQueryPersentWeatherItemBaseInfo() {
        this.points = new ArrayList<>();
        this.links = new ArrayList<>();
        this.adcodes = new ArrayList<>();
        this.weatherName = "";
        this.weatherId = 0;
        this.temperature = 0;
        this.humidity = 0;
        this.updateTime = 0L;
    }

    public GQueryPersentWeatherItemBaseInfo(ArrayList<GQueryPersentWeatherReqItemPoint> arrayList, ArrayList<Long> arrayList2, ArrayList<Integer> arrayList3, String str, int i, int i2, int i3, long j) {
        this.points = arrayList;
        this.links = arrayList2;
        this.adcodes = arrayList3;
        this.weatherName = str;
        this.weatherId = i;
        this.temperature = i2;
        this.humidity = i3;
        this.updateTime = j;
    }
}
