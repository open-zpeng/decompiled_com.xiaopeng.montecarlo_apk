package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GQueryPersentWeatherAckData implements Serializable {
    public ArrayList<GQueryWeatherByLinkExtend> extend;
    public ArrayList<GQueryPersentWeatherItem> weathers;

    public GQueryPersentWeatherAckData() {
        this.weathers = new ArrayList<>();
        this.extend = new ArrayList<>();
    }

    public GQueryPersentWeatherAckData(ArrayList<GQueryPersentWeatherItem> arrayList, ArrayList<GQueryWeatherByLinkExtend> arrayList2) {
        this.weathers = arrayList;
        this.extend = arrayList2;
    }
}
