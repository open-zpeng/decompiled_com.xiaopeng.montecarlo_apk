package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class DetailPoi implements Serializable {
    public String address;
    public String anchor;
    public DetailBaseInfo baseinfo;
    public String citycode;
    public int iPoiType;
    public String iconType;
    public String iconURL;
    public String minizoom;
    public String mmainkey;
    public String msubkey;
    public String name;
    public String pguid;
    public String poiSrc;
    public Coord2DDouble point;
    public String render_rank;
    public String tel;

    public DetailPoi() {
        this.pguid = "";
        this.point = new Coord2DDouble();
        this.tel = "";
        this.name = "";
        this.address = "";
        this.citycode = "";
        this.iconURL = "";
        this.poiSrc = "";
        this.mmainkey = "";
        this.msubkey = "";
        this.render_rank = "";
        this.minizoom = "";
        this.anchor = "";
        this.iconType = "";
        this.iPoiType = 0;
        this.baseinfo = new DetailBaseInfo();
    }

    public DetailPoi(String str, Coord2DDouble coord2DDouble, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, DetailBaseInfo detailBaseInfo) {
        this.pguid = str;
        this.point = coord2DDouble;
        this.tel = str2;
        this.name = str3;
        this.address = str4;
        this.citycode = str5;
        this.iconURL = str6;
        this.poiSrc = str7;
        this.mmainkey = str8;
        this.msubkey = str9;
        this.render_rank = str10;
        this.minizoom = str11;
        this.anchor = str12;
        this.iconType = str13;
        this.iPoiType = i;
        this.baseinfo = detailBaseInfo;
    }
}
