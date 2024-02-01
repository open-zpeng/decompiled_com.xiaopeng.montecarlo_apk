package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcPoiInfoDataProduct implements Serializable {
    public double price_sale;
    public String prod_type;
    public String spu_name;

    public WsTcPoiInfoDataProduct() {
        this.prod_type = "";
        this.spu_name = "";
        this.price_sale = 0.0d;
    }

    public WsTcPoiInfoDataProduct(String str, String str2, double d) {
        this.prod_type = str;
        this.spu_name = str2;
        this.price_sale = d;
    }
}
