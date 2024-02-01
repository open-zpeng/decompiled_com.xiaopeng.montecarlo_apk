package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OrderProductInformation implements Serializable {
    public TradePrice price;
    public long refundNumber;
    public long refundingNumber;
    public long reserveNumber;
    public ArrayList<String> rights;
    public String skuId;
    public String spuId;
    public String title;
    public long total;
    public long unUsedNumber;
    public long usedNumber;
    public String validDateDescription;

    public OrderProductInformation() {
        this.reserveNumber = 0L;
        this.refundNumber = 0L;
        this.refundingNumber = 0L;
        this.unUsedNumber = 0L;
        this.usedNumber = 0L;
        this.total = 0L;
        this.price = new TradePrice();
        this.spuId = "";
        this.skuId = "";
        this.title = "";
        this.validDateDescription = "";
        this.rights = new ArrayList<>();
    }

    public OrderProductInformation(long j, long j2, long j3, long j4, long j5, long j6, TradePrice tradePrice, String str, String str2, String str3, String str4, ArrayList<String> arrayList) {
        this.reserveNumber = j;
        this.refundNumber = j2;
        this.refundingNumber = j3;
        this.unUsedNumber = j4;
        this.usedNumber = j5;
        this.total = j6;
        this.price = tradePrice;
        this.spuId = str;
        this.skuId = str2;
        this.title = str3;
        this.validDateDescription = str4;
        this.rights = arrayList;
    }
}
