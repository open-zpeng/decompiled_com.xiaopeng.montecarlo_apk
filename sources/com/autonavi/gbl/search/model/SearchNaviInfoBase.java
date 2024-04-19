package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchNaviInfoBase implements Serializable {
    public String address;
    public String geometry;
    public String name;
    public String navigation;
    public String new_type;
    public String poiid;
    public String rel_type;
    public String shortname;
    public String x;
    public String y;

    public SearchNaviInfoBase() {
        this.poiid = "";
        this.name = "";
        this.address = "";
        this.geometry = "";
        this.new_type = "";
        this.x = "";
        this.y = "";
        this.navigation = "";
        this.shortname = "";
        this.rel_type = "";
    }

    public SearchNaviInfoBase(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.poiid = str;
        this.name = str2;
        this.address = str3;
        this.geometry = str4;
        this.new_type = str5;
        this.x = str6;
        this.y = str7;
        this.navigation = str8;
        this.shortname = str9;
        this.rel_type = str10;
    }
}
