package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchChargeProvider implements Serializable {
    public String id;
    public String name;

    public SearchChargeProvider() {
        this.name = "";
        this.id = "";
    }

    public SearchChargeProvider(String str, String str2) {
        this.name = str;
        this.id = str2;
    }
}
