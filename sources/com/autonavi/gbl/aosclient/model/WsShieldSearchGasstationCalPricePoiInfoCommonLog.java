package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPricePoiInfoCommonLog implements Serializable {
    public String adcode;
    public String business;
    public String gsid;
    public int isCpt;
    public String poi_name;
    public String poiid;
    public String t_tag;
    public String test_id;
    public String typecode;

    public WsShieldSearchGasstationCalPricePoiInfoCommonLog() {
        this.poiid = "";
        this.typecode = "";
        this.test_id = "";
        this.gsid = "";
        this.business = "";
        this.t_tag = "";
        this.poi_name = "";
        this.adcode = "";
        this.isCpt = 0;
    }

    public WsShieldSearchGasstationCalPricePoiInfoCommonLog(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        this.poiid = str;
        this.typecode = str2;
        this.test_id = str3;
        this.gsid = str4;
        this.business = str5;
        this.t_tag = str6;
        this.poi_name = str7;
        this.adcode = str8;
        this.isCpt = i;
    }
}
