package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchClassifyDetailCategory implements Serializable {
    public String alias;
    public String name;
    public String value;

    public SearchClassifyDetailCategory() {
        this.alias = "";
        this.name = "";
        this.value = "";
    }

    public SearchClassifyDetailCategory(String str, String str2, String str3) {
        this.alias = str;
        this.name = str2;
        this.value = str3;
    }
}
