package com.autonavi.gbl.guide.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LightBarDetail implements Serializable {
    public int finishDistance;
    public long pathID;
    public int restDistance;
    public ArrayList<TmcInfoData> tmcInfoData;
    public int totalDistance;

    public LightBarDetail() {
        this.pathID = 0L;
        this.totalDistance = 0;
        this.restDistance = 0;
        this.finishDistance = 0;
        this.tmcInfoData = new ArrayList<>();
    }

    public LightBarDetail(long j, int i, int i2, int i3, ArrayList<TmcInfoData> arrayList) {
        this.pathID = j;
        this.totalDistance = i;
        this.restDistance = i2;
        this.finishDistance = i3;
        this.tmcInfoData = arrayList;
    }
}
