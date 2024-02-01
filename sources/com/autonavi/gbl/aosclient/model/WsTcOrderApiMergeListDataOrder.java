package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcOrderApiMergeListDataOrder implements Serializable {
    public String amapOrderId;
    public int bizType;
    public String cpCode;
    public String currency;
    public String datasource;
    public long expireTime;
    public WsTcOrderApiMergeListOrderExt ext;
    public long gmtCreate;
    public long id;
    public String orderName;
    public int orderStatus;
    public String orderStatusDesc;
    public String poiId;
    public String poiName;
    public double priceOrder;
    public int reserveNo;
    public long reserveTime;
    public String scheme;
    public String thumbnail;
    public int userId;

    public WsTcOrderApiMergeListDataOrder() {
        this.bizType = 0;
        this.userId = 0;
        this.id = 0L;
        this.amapOrderId = "";
        this.orderName = "";
        this.orderStatus = 0;
        this.orderStatusDesc = "";
        this.cpCode = "";
        this.reserveTime = 0L;
        this.reserveNo = 0;
        this.currency = "";
        this.priceOrder = 0.0d;
        this.poiId = "";
        this.poiName = "";
        this.gmtCreate = 0L;
        this.datasource = "";
        this.ext = new WsTcOrderApiMergeListOrderExt();
        this.thumbnail = "";
        this.expireTime = 0L;
        this.scheme = "";
    }

    public WsTcOrderApiMergeListDataOrder(int i, int i2, long j, String str, String str2, int i3, String str3, String str4, long j2, int i4, String str5, double d, String str6, String str7, long j3, String str8, WsTcOrderApiMergeListOrderExt wsTcOrderApiMergeListOrderExt, String str9, long j4, String str10) {
        this.bizType = i;
        this.userId = i2;
        this.id = j;
        this.amapOrderId = str;
        this.orderName = str2;
        this.orderStatus = i3;
        this.orderStatusDesc = str3;
        this.cpCode = str4;
        this.reserveTime = j2;
        this.reserveNo = i4;
        this.currency = str5;
        this.priceOrder = d;
        this.poiId = str6;
        this.poiName = str7;
        this.gmtCreate = j3;
        this.datasource = str8;
        this.ext = wsTcOrderApiMergeListOrderExt;
        this.thumbnail = str9;
        this.expireTime = j4;
        this.scheme = str10;
    }
}
