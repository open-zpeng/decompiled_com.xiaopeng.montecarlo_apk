package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MobileDestination implements Serializable {
    public double dAngle;
    public String floor;
    public String name;
    public int naviExtCode;
    public String parentId;
    public String parentRel;
    public String poiId;
    public int type;
    public String typeCode;

    public MobileDestination() {
        this.type = 0;
        this.name = "";
        this.poiId = "";
        this.typeCode = "";
        this.parentRel = "";
        this.parentId = "";
        this.floor = "";
        this.naviExtCode = 0;
        this.dAngle = 0.0d;
    }

    public MobileDestination(int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, double d) {
        this.type = i;
        this.name = str;
        this.poiId = str2;
        this.typeCode = str3;
        this.parentRel = str4;
        this.parentId = str5;
        this.floor = str6;
        this.naviExtCode = i2;
        this.dAngle = d;
    }
}
