package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class DeepStationPoisList implements Serializable {
    public String address;
    public String child_shortname;
    public String name;
    public String poiid;
    public String type;
    public String x;
    public String y;

    public DeepStationPoisList() {
        this.poiid = "";
        this.name = "";
        this.address = "";
        this.child_shortname = "";
        this.x = "";
        this.y = "";
        this.type = "";
    }

    public DeepStationPoisList(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.poiid = str;
        this.name = str2;
        this.address = str3;
        this.child_shortname = str4;
        this.x = str5;
        this.y = str6;
        this.type = str7;
    }
}
