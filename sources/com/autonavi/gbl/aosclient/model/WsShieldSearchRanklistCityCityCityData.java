package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistCityCityCityData implements Serializable {
    public String adCode;
    public String cityName;
    public String pinyin;

    public WsShieldSearchRanklistCityCityCityData() {
        this.cityName = "";
        this.adCode = "";
        this.pinyin = "";
    }

    public WsShieldSearchRanklistCityCityCityData(String str, String str2, String str3) {
        this.cityName = str;
        this.adCode = str2;
        this.pinyin = str3;
    }
}
