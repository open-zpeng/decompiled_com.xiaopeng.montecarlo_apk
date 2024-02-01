package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GQueryWeatherByLinkReqItem implements Serializable {
    public long endTime;
    public ArrayList<GQueryWeatherByLinkExtend> extend;
    public long filterStrategy;
    public long handleStrategy;
    public ArrayList<Long> linkids;
    public long starttime;

    public GQueryWeatherByLinkReqItem() {
        this.linkids = new ArrayList<>();
        this.starttime = 0L;
        this.endTime = 0L;
        this.filterStrategy = 0L;
        this.handleStrategy = 0L;
        this.extend = new ArrayList<>();
    }

    public GQueryWeatherByLinkReqItem(ArrayList<Long> arrayList, long j, long j2, long j3, long j4, ArrayList<GQueryWeatherByLinkExtend> arrayList2) {
        this.linkids = arrayList;
        this.starttime = j;
        this.endTime = j2;
        this.filterStrategy = j3;
        this.handleStrategy = j4;
        this.extend = arrayList2;
    }
}
