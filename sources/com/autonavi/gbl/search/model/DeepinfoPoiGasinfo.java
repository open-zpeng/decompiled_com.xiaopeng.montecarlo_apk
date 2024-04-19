package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class DeepinfoPoiGasinfo implements Serializable {
    public String price;
    public String type;

    public DeepinfoPoiGasinfo() {
        this.type = "";
        this.price = "";
    }

    public DeepinfoPoiGasinfo(String str, String str2) {
        this.type = str;
        this.price = str2;
    }
}
