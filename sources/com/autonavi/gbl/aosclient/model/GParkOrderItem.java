package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GParkOrderItem implements Serializable {
    public int cpCode;
    public String cpName;
    public String enterTime;
    public String licensePlate;
    public String orderId;
    public String parkName;
    public int status;
    public double totalFee;

    public GParkOrderItem() {
        this.cpCode = 0;
        this.cpName = "";
        this.orderId = "";
        this.parkName = "";
        this.totalFee = 0.0d;
        this.status = 0;
        this.licensePlate = "";
        this.enterTime = "";
    }

    public GParkOrderItem(int i, String str, String str2, String str3, double d, int i2, String str4, String str5) {
        this.cpCode = i;
        this.cpName = str;
        this.orderId = str2;
        this.parkName = str3;
        this.totalFee = d;
        this.status = i2;
        this.licensePlate = str4;
        this.enterTime = str5;
    }
}
