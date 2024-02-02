package com.autonavi.gbl.data.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class MergedStatusInfo implements Serializable {
    public int adcode;
    public boolean bMergedSate;
    public String cityName;
    public String costMergeTime;
    public String errType;
    public String errTypeDetill;
    public String packageType;
    public String updateType;
    public String url;

    public MergedStatusInfo() {
        this.bMergedSate = false;
        this.adcode = 0;
        this.cityName = "";
        this.packageType = "";
        this.errType = "";
        this.updateType = "";
        this.url = "";
        this.errTypeDetill = "";
        this.costMergeTime = "";
    }

    public MergedStatusInfo(boolean z, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.bMergedSate = z;
        this.adcode = i;
        this.cityName = str;
        this.packageType = str2;
        this.errType = str3;
        this.updateType = str4;
        this.url = str5;
        this.errTypeDetill = str6;
        this.costMergeTime = str7;
    }
}
