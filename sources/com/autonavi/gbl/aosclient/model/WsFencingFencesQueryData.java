package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsFencingFencesQueryData implements Serializable {
    public String batch;
    public ArrayList<WsFencingFencesQueryFence> fences;
    public ArrayList<String> groupids;
    public int total;
    public long updateTime;

    public WsFencingFencesQueryData() {
        this.updateTime = 0L;
        this.total = 0;
        this.batch = "";
        this.groupids = new ArrayList<>();
        this.fences = new ArrayList<>();
    }

    public WsFencingFencesQueryData(long j, int i, String str, ArrayList<String> arrayList, ArrayList<WsFencingFencesQueryFence> arrayList2) {
        this.updateTime = j;
        this.total = i;
        this.batch = str;
        this.groupids = arrayList;
        this.fences = arrayList2;
    }
}
