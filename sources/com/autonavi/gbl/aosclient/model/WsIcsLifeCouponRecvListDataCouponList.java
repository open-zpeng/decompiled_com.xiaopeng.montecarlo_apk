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
    public String couponId;
    public String couponName;
    public ArrayList<WsIcsLifeCouponRecvListCouponListDisRule> disRules;
    public String disRulesDesc;
    public int expireAt;
    public WsIcsLifeCouponRecvListDataCouponListExtInfo extInfo;
    public int industry;
    public int isBindAliPay;
    public int isDynamic;
    public int poiInvalid;
    public long recordId;
    public String refCode;
    public int scene;
    public int status;
    public int type;
    public int weight;

    public WsIcsLifeCouponRecvListDataCouponList() {
        this.couponId = "";
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
        this.recordId = 0L;
        this.refCode = "";
        this.activityId = 0;
        this.activityName = "";
        this.isDynamic = 0;
        this.poiInvalid = 0;
        this.couponName = "";
        this.extInfo = new WsIcsLifeCouponRecvListDataCouponListExtInfo();
    }

    public WsIcsLifeCouponRecvListDataCouponList(String str, int i, int i2, int i3, int i4, String str2, ArrayList<WsIcsLifeCouponRecvListCouponListDisRule> arrayList, String str3, int i5, int i6, int i7, int i8, int i9, long j, String str4, int i10, String str5, int i11, int i12, String str6, WsIcsLifeCouponRecvListDataCouponListExtInfo wsIcsLifeCouponRecvListDataCouponListExtInfo) {
        this.couponId = str;
        this.status = i;
        this.type = i2;
        this.industry = i3;
        this.isBindAliPay = i4;
        this.actionUrl = str2;
        this.disRules = arrayList;
        this.disRulesDesc = str3;
        this.availableAt = i5;
        this.weight = i6;
        this.scene = i7;
        this.amount = i8;
        this.expireAt = i9;
        this.recordId = j;
        this.refCode = str4;
        this.activityId = i10;
        this.activityName = str5;
        this.isDynamic = i11;
        this.poiInvalid = i12;
        this.couponName = str6;
        this.extInfo = wsIcsLifeCouponRecvListDataCouponListExtInfo;
    }
}
