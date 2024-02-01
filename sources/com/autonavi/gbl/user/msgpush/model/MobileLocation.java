package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MobileLocation implements Serializable {
    public int mode;
    public String name;
    public String poiId;
    public int type;
    public String typeCode;

    public MobileLocation() {
        this.type = 0;
        this.mode = 0;
        this.name = "";
        this.poiId = "";
        this.typeCode = "";
    }

    public MobileLocation(int i, int i2, String str, String str2, String str3) {
        this.type = i;
        this.mode = i2;
        this.name = str;
        this.poiId = str2;
        this.typeCode = str3;
    }
}
