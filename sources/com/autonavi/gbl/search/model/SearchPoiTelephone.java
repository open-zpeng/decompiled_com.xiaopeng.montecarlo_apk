package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPoiTelephone implements Serializable {
    public String name;
    public String part;
    public String tel;

    public SearchPoiTelephone() {
        this.name = "";
        this.tel = "";
        this.part = "";
    }

    public SearchPoiTelephone(String str, String str2, String str3) {
        this.name = str;
        this.tel = str2;
        this.part = str3;
    }
}
