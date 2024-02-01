package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcKoubeiOrderSubmitRequestDataAssetList implements Serializable {
    public int couponAmount;
    public String couponId;
    public String couponRecordId;
    public int discountAmount;
    public String exchangeArgs;
    public String idVal;
    public int type;

    public WsTcKoubeiOrderSubmitRequestDataAssetList() {
        this.couponAmount = 0;
        this.couponId = "";
        this.couponRecordId = "";
        this.discountAmount = 0;
        this.type = 0;
        this.idVal = "";
        this.exchangeArgs = "";
    }

    public WsTcKoubeiOrderSubmitRequestDataAssetList(int i, String str, String str2, int i2, int i3, String str3, String str4) {
        this.couponAmount = i;
        this.couponId = str;
        this.couponRecordId = str2;
        this.discountAmount = i2;
        this.type = i3;
        this.idVal = str3;
        this.exchangeArgs = str4;
    }
}
