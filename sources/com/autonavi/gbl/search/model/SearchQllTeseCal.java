package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchQllTeseCal implements Serializable {
    public String query;
    public String type;
    public int valid;

    public SearchQllTeseCal() {
        this.type = "";
        this.valid = -1;
        this.query = "";
    }

    public SearchQllTeseCal(String str, int i, String str2) {
        this.type = str;
        this.valid = i;
        this.query = str2;
    }
}
