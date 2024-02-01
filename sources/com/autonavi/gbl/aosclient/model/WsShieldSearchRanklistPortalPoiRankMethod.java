package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalPoiRankMethod implements Serializable {
    public ArrayList<WsShieldSearchRanklistPortalAreaCategory> category;
    public String checked_name;
    public ArrayList<String> checkedrouter;
    public String name;
    public WsShieldSearchRanklistPortalParseValue parse_value;

    public WsShieldSearchRanklistPortalPoiRankMethod() {
        this.checked_name = "";
        this.checkedrouter = new ArrayList<>();
        this.name = "";
        this.parse_value = new WsShieldSearchRanklistPortalParseValue();
        this.category = new ArrayList<>();
    }

    public WsShieldSearchRanklistPortalPoiRankMethod(String str, ArrayList<String> arrayList, String str2, WsShieldSearchRanklistPortalParseValue wsShieldSearchRanklistPortalParseValue, ArrayList<WsShieldSearchRanklistPortalAreaCategory> arrayList2) {
        this.checked_name = str;
        this.checkedrouter = arrayList;
        this.name = str2;
        this.parse_value = wsShieldSearchRanklistPortalParseValue;
        this.category = arrayList2;
    }
}
