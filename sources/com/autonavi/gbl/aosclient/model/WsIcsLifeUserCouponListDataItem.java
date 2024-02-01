package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsIcsLifeUserCouponListDataItem implements Serializable {
    public String actionUrl;
    public double amount;
    public int availableAt;
    public int bizType;
    public String cp;
    public String description;
    public int discount;
    public int expireAt;
    public int id;
    public String name;
    public long recordId;
    public String ruleText;
    public int status;
    public String stepRules;
    public String synopsis;
    public int type;

    public WsIcsLifeUserCouponListDataItem() {
        this.id = 0;
        this.name = "";
        this.type = 0;
        this.status = 0;
        this.cp = "";
        this.bizType = 0;
        this.actionUrl = "";
        this.recordId = 0L;
        this.synopsis = "";
        this.amount = 0.0d;
        this.stepRules = "";
        this.discount = 0;
        this.availableAt = 0;
        this.expireAt = 0;
        this.ruleText = "";
        this.description = "";
    }

    public WsIcsLifeUserCouponListDataItem(int i, String str, int i2, int i3, String str2, int i4, String str3, long j, String str4, double d, String str5, int i5, int i6, int i7, String str6, String str7) {
        this.id = i;
        this.name = str;
        this.type = i2;
        this.status = i3;
        this.cp = str2;
        this.bizType = i4;
        this.actionUrl = str3;
        this.recordId = j;
        this.synopsis = str4;
        this.amount = d;
        this.stepRules = str5;
        this.discount = i5;
        this.availableAt = i6;
        this.expireAt = i7;
        this.ruleText = str6;
        this.description = str7;
    }
}
