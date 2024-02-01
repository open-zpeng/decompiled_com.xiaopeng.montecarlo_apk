package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsFencingGroupsQueryData implements Serializable {
    public ArrayList<WsFencingGroupsQueryGroup> groups;
    public int total;
    public long updateTime;

    public WsFencingGroupsQueryData() {
        this.total = 0;
        this.updateTime = 0L;
        this.groups = new ArrayList<>();
    }

    public WsFencingGroupsQueryData(int i, long j, ArrayList<WsFencingGroupsQueryGroup> arrayList) {
        this.total = i;
        this.updateTime = j;
        this.groups = arrayList;
    }
}
