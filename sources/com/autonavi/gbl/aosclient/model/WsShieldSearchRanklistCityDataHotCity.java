package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistCityDataHotCity implements Serializable {
    public ArrayList<WsShieldSearchRanklistCityHotCityList> list;
    public String title;

    public WsShieldSearchRanklistCityDataHotCity() {
        this.title = "";
        this.list = new ArrayList<>();
    }

    public WsShieldSearchRanklistCityDataHotCity(String str, ArrayList<WsShieldSearchRanklistCityHotCityList> arrayList) {
        this.title = str;
        this.list = arrayList;
    }
}
