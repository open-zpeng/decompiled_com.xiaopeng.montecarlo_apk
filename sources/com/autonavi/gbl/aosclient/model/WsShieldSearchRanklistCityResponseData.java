package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistCityResponseData implements Serializable {
    public ArrayList<WsShieldSearchRanklistCityDataCity> cities;
    public WsShieldSearchRanklistCityDataHotCity hot_cities;

    public WsShieldSearchRanklistCityResponseData() {
        this.cities = new ArrayList<>();
        this.hot_cities = new WsShieldSearchRanklistCityDataHotCity();
    }

    public WsShieldSearchRanklistCityResponseData(ArrayList<WsShieldSearchRanklistCityDataCity> arrayList, WsShieldSearchRanklistCityDataHotCity wsShieldSearchRanklistCityDataHotCity) {
        this.cities = arrayList;
        this.hot_cities = wsShieldSearchRanklistCityDataHotCity;
    }
}
