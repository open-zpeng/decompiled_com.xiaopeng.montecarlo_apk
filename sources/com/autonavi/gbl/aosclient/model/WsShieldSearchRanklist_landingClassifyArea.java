package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingClassifyArea implements Serializable {
    public ArrayList<WsShieldSearchRanklist_landingAreaCategory> category;
    public int checked;
    public String checked_name;
    public ArrayList<String> checkedrouter;
    public String name;
    public WsShieldSearchRanklist_landingParseValueClass parse_value;

    public WsShieldSearchRanklist_landingClassifyArea() {
        this.checked = 0;
        this.name = "";
        this.parse_value = new WsShieldSearchRanklist_landingParseValueClass();
        this.category = new ArrayList<>();
        this.checkedrouter = new ArrayList<>();
        this.checked_name = "";
    }

    public WsShieldSearchRanklist_landingClassifyArea(int i, String str, WsShieldSearchRanklist_landingParseValueClass wsShieldSearchRanklist_landingParseValueClass, ArrayList<WsShieldSearchRanklist_landingAreaCategory> arrayList, ArrayList<String> arrayList2, String str2) {
        this.checked = i;
        this.name = str;
        this.parse_value = wsShieldSearchRanklist_landingParseValueClass;
        this.category = arrayList;
        this.checkedrouter = arrayList2;
        this.checked_name = str2;
    }
}
