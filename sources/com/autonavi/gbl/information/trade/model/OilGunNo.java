package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class OilGunNo implements Serializable {
    public String code;
    public String name;

    public OilGunNo() {
        this.code = "";
        this.name = "";
    }

    public OilGunNo(String str, String str2) {
        this.code = str;
        this.name = str2;
    }
}
