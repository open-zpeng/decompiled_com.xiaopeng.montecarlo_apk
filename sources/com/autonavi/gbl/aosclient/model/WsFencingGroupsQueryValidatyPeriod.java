package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsFencingGroupsQueryValidatyPeriod implements Serializable {
    public String start;
    public String stop;

    public WsFencingGroupsQueryValidatyPeriod() {
        this.start = "";
        this.stop = "";
    }

    public WsFencingGroupsQueryValidatyPeriod(String str, String str2) {
        this.start = str;
        this.stop = str2;
    }
}
