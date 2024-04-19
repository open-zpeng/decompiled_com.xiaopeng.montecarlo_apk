package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsTcOrderDetailOrder implements Serializable {
    public String amapOrderId;
    public int bizType;
    public int cancelType;
    public ArrayList<WsTcOrderDetailCredentialInfoItem> credentialInfo;
    public String currency;
    public WsTcOrderDetailDiscountInfo discountInfo;
    public int gmtCreate;
    public String invoiceId;
    public int invoiceMode;
    public int invoiceStatus;
    public int orderStatus;
    public String orderStatusDesc;
    public int payTime;
    public int payType;
    public double priceOrder;
    public double priceReceivable;
    public int reserveNo;
    public int reserveTime;
    public ArrayList<String> unSubscribeType;

    public WsTcOrderDetailOrder() {
        this.amapOrderId = "";
        this.bizType = 0;
        this.orderStatus = 0;
        this.orderStatusDesc = "";
        this.reserveTime = 0;
        this.gmtCreate = 0;
        this.reserveNo = 0;
        this.currency = "";
        this.priceReceivable = 0.0d;
        this.priceOrder = 0.0d;
        this.payType = 0;
        this.payTime = 0;
        this.cancelType = 0;
        this.invoiceId = "";
        this.invoiceStatus = 0;
        this.invoiceMode = 0;
        this.unSubscribeType = new ArrayList<>();
        this.credentialInfo = new ArrayList<>();
        this.discountInfo = new WsTcOrderDetailDiscountInfo();
    }

    public WsTcOrderDetailOrder(String str, int i, int i2, String str2, int i3, int i4, int i5, String str3, double d, double d2, int i6, int i7, int i8, String str4, int i9, int i10, ArrayList<String> arrayList, ArrayList<WsTcOrderDetailCredentialInfoItem> arrayList2, WsTcOrderDetailDiscountInfo wsTcOrderDetailDiscountInfo) {
        this.amapOrderId = str;
        this.bizType = i;
        this.orderStatus = i2;
        this.orderStatusDesc = str2;
        this.reserveTime = i3;
        this.gmtCreate = i4;
        this.reserveNo = i5;
        this.currency = str3;
        this.priceReceivable = d;
        this.priceOrder = d2;
        this.payType = i6;
        this.payTime = i7;
        this.cancelType = i8;
        this.invoiceId = str4;
        this.invoiceStatus = i9;
        this.invoiceMode = i10;
        this.unSubscribeType = arrayList;
        this.credentialInfo = arrayList2;
        this.discountInfo = wsTcOrderDetailDiscountInfo;
    }
}
