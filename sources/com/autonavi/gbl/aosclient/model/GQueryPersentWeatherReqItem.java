package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GQueryPersentWeatherReqItem implements Serializable {
    public ArrayList<Integer> adcodes;
    public ArrayList<GQueryWeatherByLinkExtend> extend;
    public ArrayList<Long> links;
    public ArrayList<GQueryPersentWeatherReqItemPoint> points;
    public long returnStrategy;
    public int type;

    public GQueryPersentWeatherReqItem() {
        this.type = 0;
        this.points = new ArrayList<>();
        this.links = new ArrayList<>();
        this.adcodes = new ArrayList<>();
        this.returnStrategy = 0L;
        this.extend = new ArrayList<>();
    }

    public GQueryPersentWeatherReqItem(int i, ArrayList<GQueryPersentWeatherReqItemPoint> arrayList, ArrayList<Long> arrayList2, ArrayList<Integer> arrayList3, long j, ArrayList<GQueryWeatherByLinkExtend> arrayList4) {
        this.type = i;
        this.points = arrayList;
        this.links = arrayList2;
        this.adcodes = arrayList3;
        this.returnStrategy = j;
        this.extend = arrayList4;
    }
}
