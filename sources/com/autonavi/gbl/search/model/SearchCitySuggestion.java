package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchCitySuggestion implements Serializable {
    public String adcode;
    public String areacode;
    public String ename;
    public String name;
    public int total;

    public SearchCitySuggestion() {
        this.name = "";
        this.ename = "";
        this.adcode = "";
        this.areacode = "";
        this.total = 0;
    }

    public SearchCitySuggestion(String str, String str2, String str3, String str4, int i) {
        this.name = str;
        this.ename = str2;
        this.adcode = str3;
        this.areacode = str4;
        this.total = i;
    }
}
