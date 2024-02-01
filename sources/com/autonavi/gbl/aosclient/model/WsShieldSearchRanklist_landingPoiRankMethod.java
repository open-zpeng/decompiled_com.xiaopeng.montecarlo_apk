package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingPoiRankMethod implements Serializable {
    public ArrayList<WsShieldSearchRanklist_landingAreaCategory> category;
    public String checked_name;
    public ArrayList<String> checkedrouter;

    public WsShieldSearchRanklist_landingPoiRankMethod() {
        this.checked_name = "";
        this.checkedrouter = new ArrayList<>();
        this.category = new ArrayList<>();
    }

    public WsShieldSearchRanklist_landingPoiRankMethod(String str, ArrayList<String> arrayList, ArrayList<WsShieldSearchRanklist_landingAreaCategory> arrayList2) {
        this.checked_name = str;
        this.checkedrouter = arrayList;
        this.category = arrayList2;
    }
}
