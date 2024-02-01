package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RoutepathrestorationPointInfo implements Serializable {
    public int idx;
    public String lat;
    public String lon;
    public int type;

    public RoutepathrestorationPointInfo() {
        this.idx = 0;
        this.type = 0;
        this.lon = "";
        this.lat = "";
    }

    public RoutepathrestorationPointInfo(int i, int i2, String str, String str2) {
        this.idx = i;
        this.type = i2;
        this.lon = str;
        this.lat = str2;
    }
}
