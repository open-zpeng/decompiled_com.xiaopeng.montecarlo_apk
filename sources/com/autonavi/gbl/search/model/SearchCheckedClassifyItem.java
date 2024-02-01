package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchCheckedClassifyItem implements Serializable {
    public String id;
    public String name;
    public String value;

    public SearchCheckedClassifyItem() {
        this.id = "";
        this.value = "";
        this.name = "";
    }

    public SearchCheckedClassifyItem(String str, String str2, String str3) {
        this.id = str;
        this.value = str2;
        this.name = str3;
    }
}
