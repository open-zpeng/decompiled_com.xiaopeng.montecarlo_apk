package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcPoiInfoDataPoiInfo implements Serializable {
    public String averagecost;
    public String bizType;
    public String name;
    public String poiid;
    public String star;
    public String tag;
    public double x;
    public double y;

    public WsTcPoiInfoDataPoiInfo() {
        this.poiid = "";
        this.name = "";
        this.averagecost = "";
        this.star = "";
        this.tag = "";
        this.x = 0.0d;
        this.y = 0.0d;
        this.bizType = "";
    }

    public WsTcPoiInfoDataPoiInfo(String str, String str2, String str3, String str4, String str5, double d, double d2, String str6) {
        this.poiid = str;
        this.name = str2;
        this.averagecost = str3;
        this.star = str4;
        this.tag = str5;
        this.x = d;
        this.y = d2;
        this.bizType = str6;
    }
}
