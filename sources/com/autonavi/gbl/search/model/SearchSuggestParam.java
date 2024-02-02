package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchSuggestParam implements Serializable {
    public boolean adcode;
    public String category;
    public int city;
    public String datatype;
    public String geoobj;
    public String keyword;
    public String need_vir;
    public boolean need_xy;
    public int offlineAdminCode;
    public int offlineResultMaxCount;
    public Coord2DDouble poi_loc;
    public int session;
    public String siv;
    public String stepid;
    public int sugType;
    public String superid;
    public String user_city;
    public Coord2DDouble user_loc;
    public String version;

    public SearchSuggestParam() {
        this.keyword = "";
        this.poi_loc = new Coord2DDouble();
        this.sugType = 0;
        this.city = -1;
        this.datatype = "poi";
        this.adcode = true;
        this.user_loc = new Coord2DDouble();
        this.category = "";
        this.geoobj = "";
        this.session = -1;
        this.stepid = "";
        this.user_city = "";
        this.need_vir = "";
        this.need_xy = false;
        this.superid = "";
        this.version = "";
        this.siv = "";
        this.offlineAdminCode = 0;
        this.offlineResultMaxCount = 20;
    }

    public SearchSuggestParam(String str, Coord2DDouble coord2DDouble, int i, int i2, String str2, boolean z, Coord2DDouble coord2DDouble2, String str3, String str4, int i3, String str5, String str6, String str7, boolean z2, String str8, String str9, String str10, int i4, int i5) {
        this.keyword = str;
        this.poi_loc = coord2DDouble;
        this.sugType = i;
        this.city = i2;
        this.datatype = str2;
        this.adcode = z;
        this.user_loc = coord2DDouble2;
        this.category = str3;
        this.geoobj = str4;
        this.session = i3;
        this.stepid = str5;
        this.user_city = str6;
        this.need_vir = str7;
        this.need_xy = z2;
        this.superid = str8;
        this.version = str9;
        this.siv = str10;
        this.offlineAdminCode = i4;
        this.offlineResultMaxCount = i5;
    }
}
