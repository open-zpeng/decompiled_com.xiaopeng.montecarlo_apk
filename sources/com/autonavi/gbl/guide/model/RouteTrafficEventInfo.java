package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RouteTrafficEventInfo implements Serializable {
    public String brief;
    public int id;
    public String sourceDesc;
    public int type;

    public RouteTrafficEventInfo() {
        this.id = 0;
        this.type = 0;
        this.brief = "";
        this.sourceDesc = "";
    }

    public RouteTrafficEventInfo(int i, int i2, String str, String str2) {
        this.id = i;
        this.type = i2;
        this.brief = str;
        this.sourceDesc = str2;
    }
}
