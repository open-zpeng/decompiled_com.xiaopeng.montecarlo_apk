package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcFuelCreateOrderExt implements Serializable {
    public String cpCode;
    public String fuelGrade;
    public int fuelType;
    public double liters;
    public String nozzle;
    public String orderName;
    public String poiId;
    public String srcType;
    public String storeId;

    public WsTcFuelCreateOrderExt() {
        this.poiId = "";
        this.fuelType = 0;
        this.fuelGrade = "";
        this.nozzle = "";
        this.liters = 0.0d;
        this.srcType = "";
        this.storeId = "";
        this.orderName = "";
        this.cpCode = "";
    }

    public WsTcFuelCreateOrderExt(String str, int i, String str2, String str3, double d, String str4, String str5, String str6, String str7) {
        this.poiId = str;
        this.fuelType = i;
        this.fuelGrade = str2;
        this.nozzle = str3;
        this.liters = d;
        this.srcType = str4;
        this.storeId = str5;
        this.orderName = str6;
        this.cpCode = str7;
    }
}
