package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcOrderDetailGoodsExt implements Serializable {
    public String cpName;
    public String cpTel;
    public double directDiscount;
    public String fuelGrade;
    public String fuelType;
    public String liters;
    public String nozzle;
    public double priceDiscount;
    public String priceUnit;
    public double serviceFee;
    public String srcType;
    public String storeId;
    public int syncPeriod;

    public WsTcOrderDetailGoodsExt() {
        this.nozzle = "";
        this.priceUnit = "";
        this.fuelType = "";
        this.liters = "";
        this.cpTel = "";
        this.storeId = "";
        this.fuelGrade = "";
        this.priceDiscount = 0.0d;
        this.srcType = "";
        this.serviceFee = 0.0d;
        this.cpName = "";
        this.directDiscount = 0.0d;
        this.syncPeriod = 0;
    }

    public WsTcOrderDetailGoodsExt(String str, String str2, String str3, String str4, String str5, String str6, String str7, double d, String str8, double d2, String str9, double d3, int i) {
        this.nozzle = str;
        this.priceUnit = str2;
        this.fuelType = str3;
        this.liters = str4;
        this.cpTel = str5;
        this.storeId = str6;
        this.fuelGrade = str7;
        this.priceDiscount = d;
        this.srcType = str8;
        this.serviceFee = d2;
        this.cpName = str9;
        this.directDiscount = d3;
        this.syncPeriod = i;
    }
}
