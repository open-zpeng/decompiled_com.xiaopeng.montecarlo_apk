package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class DeepStationEntranceInfo implements Serializable {
    public String guide_info;
    public String name;
    public String poiid;
    public String reco_code;
    public String reco_info;
    public String rel_poiid;

    public DeepStationEntranceInfo() {
        this.reco_code = "";
        this.reco_info = "";
        this.guide_info = "";
        this.name = "";
        this.poiid = "";
        this.rel_poiid = "";
    }

    public DeepStationEntranceInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this.reco_code = str;
        this.reco_info = str2;
        this.guide_info = str3;
        this.name = str4;
        this.poiid = str5;
        this.rel_poiid = str6;
    }
}
