package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsIcsLifeCouponOptionsDataUseful implements Serializable {
    public int activityId;
    public String activityName;
    public int amount;
    public int availableAt;
    public long couponId;
    public String couponName;
    public String disAmount;
    public ArrayList<WsIcsLifeCouponOptionsUsefulDisRule> disRules;
    public String disRulesDesc;
    public int expireAt;
    public int industry;
    public long recordId;
    public String refCode;
    public int type;
    public int weight;

    public WsIcsLifeCouponOptionsDataUseful() {
        this.recordId = 0L;
        this.activityName = "";
        this.activityId = 0;
        this.couponName = "";
        this.couponId = 0L;
        this.industry = 0;
        this.type = 0;
        this.amount = 0;
        this.disRules = new ArrayList<>();
        this.disRulesDesc = "";
        this.availableAt = 0;
        this.expireAt = 0;
        this.weight = 0;
        this.refCode = "";
        this.disAmount = "";
    }

    public WsIcsLifeCouponOptionsDataUseful(long j, String str, int i, String str2, long j2, int i2, int i3, int i4, ArrayList<WsIcsLifeCouponOptionsUsefulDisRule> arrayList, String str3, int i5, int i6, int i7, String str4, String str5) {
        this.recordId = j;
        this.activityName = str;
        this.activityId = i;
        this.couponName = str2;
        this.couponId = j2;
        this.industry = i2;
        this.type = i3;
        this.amount = i4;
        this.disRules = arrayList;
        this.disRulesDesc = str3;
        this.availableAt = i5;
        this.expireAt = i6;
        this.weight = i7;
        this.refCode = str4;
        this.disAmount = str5;
    }
}
