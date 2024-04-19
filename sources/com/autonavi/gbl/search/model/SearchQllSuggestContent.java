package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchQllSuggestContent implements Serializable {
    public int adcode;
    public String city;
    public String query;

    public SearchQllSuggestContent() {
        this.city = "";
        this.adcode = -1;
        this.query = "";
    }

    public SearchQllSuggestContent(String str, int i, String str2) {
        this.city = str;
        this.adcode = i;
        this.query = str2;
    }
}
