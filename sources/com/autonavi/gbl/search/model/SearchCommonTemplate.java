package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchCommonTemplate implements Serializable {
    public int id;
    public String name;
    public String type;
    public int typeId;

    public SearchCommonTemplate() {
        this.id = -1;
        this.typeId = -1;
        this.type = "";
        this.name = "";
    }

    public SearchCommonTemplate(int i, int i2, String str, String str2) {
        this.id = i;
        this.typeId = i2;
        this.type = str;
        this.name = str2;
    }
}
