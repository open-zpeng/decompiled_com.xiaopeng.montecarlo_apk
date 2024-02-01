package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchQllSuggestData implements Serializable {
    public String color;
    public String name;

    public SearchQllSuggestData() {
        this.color = "";
        this.name = "";
    }

    public SearchQllSuggestData(String str, String str2) {
        this.color = str;
        this.name = str2;
    }
}
