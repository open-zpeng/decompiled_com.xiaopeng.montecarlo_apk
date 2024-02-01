package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchCategoryInfoBase implements Serializable {
    public int checked;
    public String name;
    public String params;
    public String type;

    public SearchCategoryInfoBase() {
        this.checked = -1;
        this.name = "";
        this.params = "";
        this.type = "";
    }

    public SearchCategoryInfoBase(int i, String str, String str2, String str3) {
        this.checked = i;
        this.name = str;
        this.params = str2;
        this.type = str3;
    }
}
