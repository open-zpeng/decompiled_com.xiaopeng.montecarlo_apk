package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.ElecInfoConfig;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchAlongWayParam implements Serializable {
    public int adcode;
    public String auto_attr_filter;
    public String category;
    public int contentoptions;
    public String custom;
    public String custom_and;
    public ElecInfoConfig elec;
    public int eta_flag;
    public int eta_type;
    public String geoline;
    public ArrayList<SearchRoadId> guideRoads;
    public String keyword;
    public String linkid;
    public int linkid_format;
    public int linkid_type;
    public int navi_scene;
    public int navi_type;
    public boolean need_eta;
    public boolean need_gasprice;
    public boolean need_naviinfo;
    public String offlineCustom;
    public int route_range;
    public String routepoints;
    public int specialSearch;
    public Coord2DDouble user_loc;
    public String viaingeoline;
    public String viainlinkid;

    public SearchAlongWayParam() {
        this.keyword = "";
        this.route_range = -1;
        this.category = "";
        this.need_gasprice = false;
        this.need_naviinfo = false;
        this.need_eta = false;
        this.eta_type = -1;
        this.eta_flag = -1;
        this.routepoints = "";
        this.geoline = "";
        this.custom = "";
        this.custom_and = "";
        this.auto_attr_filter = "";
        this.linkid = "";
        this.linkid_format = 0;
        this.linkid_type = -1;
        this.viaingeoline = "";
        this.viainlinkid = "";
        this.navi_scene = 1;
        this.navi_type = 2;
        this.elec = new ElecInfoConfig();
        this.contentoptions = 0;
        this.adcode = 0;
        this.specialSearch = 0;
        this.user_loc = new Coord2DDouble();
        this.guideRoads = new ArrayList<>();
        this.offlineCustom = "";
    }

    public SearchAlongWayParam(String str, int i, String str2, boolean z, boolean z2, boolean z3, int i2, int i3, String str3, String str4, String str5, String str6, String str7, String str8, int i4, int i5, String str9, String str10, int i6, int i7, ElecInfoConfig elecInfoConfig, int i8, int i9, int i10, Coord2DDouble coord2DDouble, ArrayList<SearchRoadId> arrayList, String str11) {
        this.keyword = str;
        this.route_range = i;
        this.category = str2;
        this.need_gasprice = z;
        this.need_naviinfo = z2;
        this.need_eta = z3;
        this.eta_type = i2;
        this.eta_flag = i3;
        this.routepoints = str3;
        this.geoline = str4;
        this.custom = str5;
        this.custom_and = str6;
        this.auto_attr_filter = str7;
        this.linkid = str8;
        this.linkid_format = i4;
        this.linkid_type = i5;
        this.viaingeoline = str9;
        this.viainlinkid = str10;
        this.navi_scene = i6;
        this.navi_type = i7;
        this.elec = elecInfoConfig;
        this.contentoptions = i8;
        this.adcode = i9;
        this.specialSearch = i10;
        this.user_loc = coord2DDouble;
        this.guideRoads = arrayList;
        this.offlineCustom = str11;
    }
}
