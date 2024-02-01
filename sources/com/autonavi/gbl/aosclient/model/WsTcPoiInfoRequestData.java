package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcPoiInfoRequestData implements Serializable {
    public int cardScene;
    public String endTime;
    public WsTcPoiInfoDataPoiInfo poi_info;
    public WsTcPoiInfoDataProduct products;

    public WsTcPoiInfoRequestData() {
        this.poi_info = new WsTcPoiInfoDataPoiInfo();
        this.endTime = "";
        this.products = new WsTcPoiInfoDataProduct();
        this.cardScene = 1;
    }

    public WsTcPoiInfoRequestData(WsTcPoiInfoDataPoiInfo wsTcPoiInfoDataPoiInfo, String str, WsTcPoiInfoDataProduct wsTcPoiInfoDataProduct, int i) {
        this.poi_info = wsTcPoiInfoDataPoiInfo;
        this.endTime = str;
        this.products = wsTcPoiInfoDataProduct;
        this.cardScene = i;
    }
}
