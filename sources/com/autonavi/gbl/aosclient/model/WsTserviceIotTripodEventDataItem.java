package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTserviceIotTripodEventDataItem implements Serializable {
    public String createTime;
    public int duration;
    public String location;

    public WsTserviceIotTripodEventDataItem() {
        this.createTime = "";
        this.duration = 0;
        this.location = "";
    }

    public WsTserviceIotTripodEventDataItem(String str, int i, String str2) {
        this.createTime = str;
        this.duration = i;
        this.location = str2;
    }
}
