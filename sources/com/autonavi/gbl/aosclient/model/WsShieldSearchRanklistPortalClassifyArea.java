package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalClassifyArea implements Serializable {
    public ArrayList<WsShieldSearchRanklistPortalAreaCategory> category;
    public int checked;
    public String checked_name;
    public ArrayList<String> checkedrouter;
    public String name;
    public WsShieldSearchRanklistPortalParseValueClass parse_value;

    public WsShieldSearchRanklistPortalClassifyArea() {
        this.checked = 0;
        this.name = "";
        this.parse_value = new WsShieldSearchRanklistPortalParseValueClass();
        this.category = new ArrayList<>();
        this.checkedrouter = new ArrayList<>();
        this.checked_name = "";
    }

    public WsShieldSearchRanklistPortalClassifyArea(int i, String str, WsShieldSearchRanklistPortalParseValueClass wsShieldSearchRanklistPortalParseValueClass, ArrayList<WsShieldSearchRanklistPortalAreaCategory> arrayList, ArrayList<String> arrayList2, String str2) {
        this.checked = i;
        this.name = str;
        this.parse_value = wsShieldSearchRanklistPortalParseValueClass;
        this.category = arrayList;
        this.checkedrouter = arrayList2;
        this.checked_name = str2;
    }
}
