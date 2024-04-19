package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcOrderListResponseData implements Serializable {
    public String amapOrderId;
    public String currency;
    public WsTcOrderListDataExt ext;
    public String gmtCreate;
    public String goodsTbUrl;
    public String orderName;
    public int orderStatus;
    public String orderStatusDesc;
    public String poiId;
    public String poiName;
    public double priceOrder;
    public double refundFee;
    public int reserveNo;
    public double reserveTime;

    public WsTcOrderListResponseData() {
        this.amapOrderId = "";
        this.orderName = "";
        this.orderStatus = 0;
        this.orderStatusDesc = "";
        this.reserveNo = 0;
        this.currency = "";
        this.priceOrder = 0.0d;
        this.reserveTime = 0.0d;
        this.goodsTbUrl = "";
        this.poiId = "";
        this.poiName = "";
        this.ext = new WsTcOrderListDataExt();
        this.refundFee = 0.0d;
        this.gmtCreate = "";
    }

    public WsTcOrderListResponseData(String str, String str2, int i, String str3, int i2, String str4, double d, double d2, String str5, String str6, String str7, WsTcOrderListDataExt wsTcOrderListDataExt, double d3, String str8) {
        this.amapOrderId = str;
        this.orderName = str2;
        this.orderStatus = i;
        this.orderStatusDesc = str3;
        this.reserveNo = i2;
        this.currency = str4;
        this.priceOrder = d;
        this.reserveTime = d2;
        this.goodsTbUrl = str5;
        this.poiId = str6;
        this.poiName = str7;
        this.ext = wsTcOrderListDataExt;
        this.refundFee = d3;
        this.gmtCreate = str8;
    }
}
