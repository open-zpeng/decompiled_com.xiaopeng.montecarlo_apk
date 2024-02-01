package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcKoubeiOrderSubmitRequestDataItemList implements Serializable {
    public String amount;
    public int buyQuantity;
    public String discountAmount;
    public String itemId;
    public String skuId;
    public String skuPrice;

    public WsTcKoubeiOrderSubmitRequestDataItemList() {
        this.amount = "";
        this.buyQuantity = 0;
        this.discountAmount = "";
        this.itemId = "";
        this.skuId = "";
        this.skuPrice = "";
    }

    public WsTcKoubeiOrderSubmitRequestDataItemList(String str, int i, String str2, String str3, String str4, String str5) {
        this.amount = str;
        this.buyQuantity = i;
        this.discountAmount = str2;
        this.itemId = str3;
        this.skuId = str4;
        this.skuPrice = str5;
    }
}
