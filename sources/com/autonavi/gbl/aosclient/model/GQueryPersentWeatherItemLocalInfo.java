package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GQueryPersentWeatherItemLocalInfo implements Serializable {
    public int adcode;
    public String city;
    public String district;
    public String province;

    public GQueryPersentWeatherItemLocalInfo() {
        this.province = "";
        this.city = "";
        this.district = "";
        this.adcode = 0;
    }

    public GQueryPersentWeatherItemLocalInfo(String str, String str2, String str3, int i) {
        this.province = str;
        this.city = str2;
        this.district = str3;
        this.adcode = i;
    }
}
