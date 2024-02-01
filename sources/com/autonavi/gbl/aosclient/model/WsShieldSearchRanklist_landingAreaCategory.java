package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingAreaCategory implements Serializable {
    public int area_type;
    public String area_value;
    public ArrayList<WsShieldSearchRanklist_landingCategoryCategory> category;
    public int checked;
    public int is_current;
    public String location_current_text;
    public String name;
    public WsShieldSearchRanklist_landingParseValueClass parse_value;

    public WsShieldSearchRanklist_landingAreaCategory() {
        this.name = "";
        this.area_type = 0;
        this.area_value = "";
        this.checked = 0;
        this.is_current = 0;
        this.location_current_text = "";
        this.parse_value = new WsShieldSearchRanklist_landingParseValueClass();
        this.category = new ArrayList<>();
    }

    public WsShieldSearchRanklist_landingAreaCategory(String str, int i, String str2, int i2, int i3, String str3, WsShieldSearchRanklist_landingParseValueClass wsShieldSearchRanklist_landingParseValueClass, ArrayList<WsShieldSearchRanklist_landingCategoryCategory> arrayList) {
        this.name = str;
        this.area_type = i;
        this.area_value = str2;
        this.checked = i2;
        this.is_current = i3;
        this.location_current_text = str3;
        this.parse_value = wsShieldSearchRanklist_landingParseValueClass;
        this.category = arrayList;
    }
}
