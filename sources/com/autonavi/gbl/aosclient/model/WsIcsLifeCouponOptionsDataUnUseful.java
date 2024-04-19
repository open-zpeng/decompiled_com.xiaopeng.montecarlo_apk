package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsIcsLifeCouponOptionsDataUnUseful implements Serializable {
    public int activityId;
    public String activityName;
    public int amount;
    public int availableAt;
    public int couponId;
    public String couponName;
    public String disAmount;
    public ArrayList<WsIcsLifeCouponOptionsUsefulDisRule> disRules;
    public String disRulesDesc;
    public int expireAt;
    public int industry;
    public String note;
    public int recordId;
    public String refCode;
    public int type;
    public int weight;

    public WsIcsLifeCouponOptionsDataUnUseful() {
        this.recordId = 0;
        this.activityName = "";
        this.activityId = 0;
        this.couponName = "";
        this.couponId = 0;
        this.industry = 0;
        this.type = 0;
        this.amount = 0;
        this.disRules = new ArrayList<>();
        this.disRulesDesc = "";
        this.availableAt = 0;
        this.expireAt = 0;
        this.weight = 0;
        this.refCode = "";
        this.note = "";
        this.disAmount = "";
    }

    public WsIcsLifeCouponOptionsDataUnUseful(int i, String str, int i2, String str2, int i3, int i4, int i5, int i6, ArrayList<WsIcsLifeCouponOptionsUsefulDisRule> arrayList, String str3, int i7, int i8, int i9, String str4, String str5, String str6) {
        this.recordId = i;
        this.activityName = str;
        this.activityId = i2;
        this.couponName = str2;
        this.couponId = i3;
        this.industry = i4;
        this.type = i5;
        this.amount = i6;
        this.disRules = arrayList;
        this.disRulesDesc = str3;
        this.availableAt = i7;
        this.expireAt = i8;
        this.weight = i9;
        this.refCode = str4;
        this.note = str5;
        this.disAmount = str6;
    }
}
