package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalPoiRankMethod implements Serializable {
    public ArrayList<WsShieldSearchRanklistPortalAreaCategory> category;
    public String checked_name;
    public ArrayList<String> checkedrouter;

    public WsShieldSearchRanklistPortalPoiRankMethod() {
        this.checked_name = "";
        this.checkedrouter = new ArrayList<>();
        this.category = new ArrayList<>();
    }

    public WsShieldSearchRanklistPortalPoiRankMethod(String str, ArrayList<String> arrayList, ArrayList<WsShieldSearchRanklistPortalAreaCategory> arrayList2) {
        this.checked_name = str;
        this.checkedrouter = arrayList;
        this.category = arrayList2;
    }
}
