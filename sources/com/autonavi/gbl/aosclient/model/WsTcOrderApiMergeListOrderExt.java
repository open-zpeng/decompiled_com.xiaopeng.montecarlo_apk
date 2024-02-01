package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcOrderApiMergeListOrderExt implements Serializable {
    public String categoryGroup;
    public long checkInDate;
    public boolean delFlag;
    public String delText;
    public long expireTime;
    public boolean invoiceFlag;
    public boolean isComment;
    public String itemCategory;
    public String jumpUrl;
    public String latitude;
    public String longitude;
    public int refuelLiter;
    public long reserveTime;
    public String schema;
    public long showTime;

    public WsTcOrderApiMergeListOrderExt() {
        this.schema = "";
        this.latitude = "";
        this.refuelLiter = 0;
        this.longitude = "";
        this.invoiceFlag = false;
        this.expireTime = 0L;
        this.reserveTime = 0L;
        this.categoryGroup = "";
        this.jumpUrl = "";
        this.isComment = false;
        this.itemCategory = "";
        this.delText = "";
        this.delFlag = false;
        this.checkInDate = 0L;
        this.showTime = 0L;
    }

    public WsTcOrderApiMergeListOrderExt(String str, String str2, int i, String str3, boolean z, long j, long j2, String str4, String str5, boolean z2, String str6, String str7, boolean z3, long j3, long j4) {
        this.schema = str;
        this.latitude = str2;
        this.refuelLiter = i;
        this.longitude = str3;
        this.invoiceFlag = z;
        this.expireTime = j;
        this.reserveTime = j2;
        this.categoryGroup = str4;
        this.jumpUrl = str5;
        this.isComment = z2;
        this.itemCategory = str6;
        this.delText = str7;
        this.delFlag = z3;
        this.checkInDate = j3;
        this.showTime = j4;
    }
}
