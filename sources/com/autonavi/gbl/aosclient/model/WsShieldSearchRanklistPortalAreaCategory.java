package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalAreaCategory implements Serializable {
    public int area_type;
    public String area_value;
    public ArrayList<WsShieldSearchRanklistPortalCategoryCategory> category;
    public int checked;
    public int is_current;
    public String location_current_text;
    public String name;
    public WsShieldSearchRanklistPortalParseValueClass parse_value;

    public WsShieldSearchRanklistPortalAreaCategory() {
        this.name = "";
        this.area_type = 0;
        this.area_value = "";
        this.checked = 0;
        this.is_current = 0;
        this.location_current_text = "";
        this.parse_value = new WsShieldSearchRanklistPortalParseValueClass();
        this.category = new ArrayList<>();
    }

    public WsShieldSearchRanklistPortalAreaCategory(String str, int i, String str2, int i2, int i3, String str3, WsShieldSearchRanklistPortalParseValueClass wsShieldSearchRanklistPortalParseValueClass, ArrayList<WsShieldSearchRanklistPortalCategoryCategory> arrayList) {
        this.name = str;
        this.area_type = i;
        this.area_value = str2;
        this.checked = i2;
        this.is_current = i3;
        this.location_current_text = str3;
        this.parse_value = wsShieldSearchRanklistPortalParseValueClass;
        this.category = arrayList;
    }
}
