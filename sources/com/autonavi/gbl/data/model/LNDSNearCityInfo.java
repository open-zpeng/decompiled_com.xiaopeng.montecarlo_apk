package com.autonavi.gbl.data.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LNDSNearCityInfo implements Serializable {
    public int priority;
    public int urId;
    public String version;

    public LNDSNearCityInfo() {
        this.urId = 0;
        this.priority = 0;
        this.version = "";
    }

    public LNDSNearCityInfo(int i, int i2, String str) {
        this.urId = i;
        this.priority = i2;
        this.version = str;
    }
}
