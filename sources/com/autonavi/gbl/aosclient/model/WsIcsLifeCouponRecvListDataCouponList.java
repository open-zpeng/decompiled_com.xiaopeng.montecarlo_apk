package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsIcsLifeCouponRecvListDataCouponList implements Serializable {
    public String actionUrl;
    public int activityId;
    public String activityName;
    public int amount;
    public int availableAt;
    public int couponId;
    public String couponName;
    public ArrayList<WsIcsLifeCouponRecvListCouponListDisRule> disRules;
    public String disRulesDesc;
    public int expireAt;
    public int industry;
    public int isBindAliPay;
    public int isDynamic;
    public int poiInvalid;
    public int recordId;
    public String refCode;
    public int scene;
    public int status;
    public int type;
    public int weight;

    public WsIcsLifeCouponRecvListDataCouponList() {
        this.couponId = 0;
        this.status = 0;
        this.type = 0;
        this.industry = 0;
        this.isBindAliPay = 0;
        this.actionUrl = "";
        this.disRules = new ArrayList<>();
        this.disRulesDesc = "";
        this.availableAt = 0;
        this.weight = 0;
        this.scene = 0;
        this.amount = 0;
        this.expireAt = 0;
        this.recordId = 0;
        this.refCode = "";
        this.activityId = 0;
        this.activityName = "";
        this.isDynamic = 0;
        this.poiInvalid = 0;
        this.couponName = "";
    }

    public WsIcsLifeCouponRecvListDataCouponList(int i, int i2, int i3, int i4, int i5, String str, ArrayList<WsIcsLifeCouponRecvListCouponListDisRule> arrayList, String str2, int i6, int i7, int i8, int i9, int i10, int i11, String str3, int i12, String str4, int i13, int i14, String str5) {
        this.couponId = i;
        this.status = i2;
        this.type = i3;
        this.industry = i4;
        this.isBindAliPay = i5;
        this.actionUrl = str;
        this.disRules = arrayList;
        this.disRulesDesc = str2;
        this.availableAt = i6;
        this.weight = i7;
        this.scene = i8;
        this.amount = i9;
        this.expireAt = i10;
        this.recordId = i11;
        this.refCode = str3;
        this.activityId = i12;
        this.activityName = str4;
        this.isDynamic = i13;
        this.poiInvalid = i14;
        this.couponName = str5;
    }
}
