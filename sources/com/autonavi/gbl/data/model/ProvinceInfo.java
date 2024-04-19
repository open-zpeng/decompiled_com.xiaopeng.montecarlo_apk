package com.autonavi.gbl.data.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ProvinceInfo implements Serializable {
    public ArrayList<CityItemInfo> cityInfoList;
    public int provAdcode;
    public String provInitial;
    public int provLevel;
    public String provName;
    public String provPinyin;
    public double provX;
    public double provY;

    public ProvinceInfo() {
        this.provName = "";
        this.provLevel = 0;
        this.provAdcode = 0;
        this.provX = 0.0d;
        this.provY = 0.0d;
        this.provInitial = "";
        this.provPinyin = "";
        this.cityInfoList = new ArrayList<>();
    }

    public ProvinceInfo(String str, int i, int i2, double d, double d2, String str2, String str3, ArrayList<CityItemInfo> arrayList) {
        this.provName = str;
        this.provLevel = i;
        this.provAdcode = i2;
        this.provX = d;
        this.provY = d2;
        this.provInitial = str2;
        this.provPinyin = str3;
        this.cityInfoList = arrayList;
    }
}
