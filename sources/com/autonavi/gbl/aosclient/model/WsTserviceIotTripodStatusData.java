package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTserviceIotTripodStatusData implements Serializable {
    public int battery;
    public int duration;
    public String location;
    public int status;

    public WsTserviceIotTripodStatusData() {
        this.duration = 0;
        this.location = "";
        this.status = 0;
        this.battery = -1;
    }

    public WsTserviceIotTripodStatusData(int i, String str, int i2, int i3) {
        this.duration = i;
        this.location = str;
        this.status = i2;
        this.battery = i3;
    }
}
