package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcCarServiceSubmitCarServiceOrder implements Serializable {
    public String cardNo;
    public String merchantPhone;
    public String mobile;
    public String poiId;
    public double priceOrder;
    public double priceOrig;
    public String reserveNo;
    public String serviceId;
    public String serviceName;
    public String serviceType;
    public String shopName;

    public WsTcCarServiceSubmitCarServiceOrder() {
        this.reserveNo = "";
        this.priceOrder = 0.0d;
        this.priceOrig = 0.0d;
        this.poiId = "";
        this.shopName = "";
        this.serviceType = "";
        this.serviceId = "";
        this.serviceName = "";
        this.cardNo = "";
        this.merchantPhone = "";
        this.mobile = "";
    }

    public WsTcCarServiceSubmitCarServiceOrder(String str, double d, double d2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.reserveNo = str;
        this.priceOrder = d;
        this.priceOrig = d2;
        this.poiId = str2;
        this.shopName = str3;
        this.serviceType = str4;
        this.serviceId = str5;
        this.serviceName = str6;
        this.cardNo = str7;
        this.merchantPhone = str8;
        this.mobile = str9;
    }
}
