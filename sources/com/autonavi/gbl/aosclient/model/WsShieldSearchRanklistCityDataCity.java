package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistCityDataCity implements Serializable {
    public ArrayList<WsShieldSearchRanklistCityCityCityData> cityData;
    public String sectionName;

    public WsShieldSearchRanklistCityDataCity() {
        this.sectionName = "";
        this.cityData = new ArrayList<>();
    }

    public WsShieldSearchRanklistCityDataCity(String str, ArrayList<WsShieldSearchRanklistCityCityCityData> arrayList) {
        this.sectionName = str;
        this.cityData = arrayList;
    }
}
