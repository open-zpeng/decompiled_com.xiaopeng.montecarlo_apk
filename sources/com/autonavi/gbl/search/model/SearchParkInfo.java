package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchParkInfo implements Serializable {
    public String charge;
    public String geometry;
    public ArrayList<SearchParkInOutInfo> inoutInfo;
    public String nightCharge;
    public ArrayList<Coord2DDouble> points;
    public String prc_c_d_e;
    public String tag_category;

    public SearchParkInfo() {
        this.geometry = "";
        this.charge = "";
        this.prc_c_d_e = "";
        this.nightCharge = "";
        this.tag_category = "";
        this.points = new ArrayList<>();
        this.inoutInfo = new ArrayList<>();
    }

    public SearchParkInfo(String str, String str2, String str3, String str4, String str5, ArrayList<Coord2DDouble> arrayList, ArrayList<SearchParkInOutInfo> arrayList2) {
        this.geometry = str;
        this.charge = str2;
        this.prc_c_d_e = str3;
        this.nightCharge = str4;
        this.tag_category = str5;
        this.points = arrayList;
        this.inoutInfo = arrayList2;
    }
}
