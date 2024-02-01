package com.autonavi.gbl.data.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CityItemInfo implements Serializable {
    public int belongedProvince;
    public int cityAdcode;
    public int cityLevel;
    public String cityName;
    public double cityX;
    public double cityY;
    public String initial;
    public String pinyin;

    public CityItemInfo() {
        this.belongedProvince = 0;
        this.cityX = 0.0d;
        this.cityY = 0.0d;
        this.cityName = "";
        this.cityLevel = 0;
        this.cityAdcode = 0;
        this.initial = "";
        this.pinyin = "";
    }

    public CityItemInfo(int i, double d, double d2, String str, int i2, int i3, String str2, String str3) {
        this.belongedProvince = i;
        this.cityX = d;
        this.cityY = d2;
        this.cityName = str;
        this.cityLevel = i2;
        this.cityAdcode = i3;
        this.initial = str2;
        this.pinyin = str3;
    }
}
