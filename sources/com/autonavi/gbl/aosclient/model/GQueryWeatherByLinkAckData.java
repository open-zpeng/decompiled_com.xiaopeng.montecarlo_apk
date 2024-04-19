package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GQueryWeatherByLinkAckData implements Serializable {
    public ArrayList<GQueryWeatherByLinkExtend> extend;
    public ArrayList<GQueryWeatherByLinkAckDataWeather> weathers;

    public GQueryWeatherByLinkAckData() {
        this.weathers = new ArrayList<>();
        this.extend = new ArrayList<>();
    }

    public GQueryWeatherByLinkAckData(ArrayList<GQueryWeatherByLinkAckDataWeather> arrayList, ArrayList<GQueryWeatherByLinkExtend> arrayList2) {
        this.weathers = arrayList;
        this.extend = arrayList2;
    }
}
