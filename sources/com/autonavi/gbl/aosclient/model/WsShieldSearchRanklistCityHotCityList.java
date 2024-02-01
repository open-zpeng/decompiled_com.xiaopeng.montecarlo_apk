package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistCityHotCityList implements Serializable {
    public String adCode;
    public String cityName;
    public String content;
    public String image;

    public WsShieldSearchRanklistCityHotCityList() {
        this.adCode = "";
        this.cityName = "";
        this.content = "";
        this.image = "";
    }

    public WsShieldSearchRanklistCityHotCityList(String str, String str2, String str3, String str4) {
        this.adCode = str;
        this.cityName = str2;
        this.content = str3;
        this.image = str4;
    }
}
