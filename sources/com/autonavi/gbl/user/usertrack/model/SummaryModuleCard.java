package com.autonavi.gbl.user.usertrack.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SummaryModuleCard implements Serializable {
    public int measure;
    public String name;
    public String title;
    public String unit;

    public SummaryModuleCard() {
        this.measure = 0;
        this.name = "";
        this.title = "";
        this.unit = "";
    }

    public SummaryModuleCard(int i, String str, String str2, String str3) {
        this.measure = i;
        this.name = str;
        this.title = str2;
        this.unit = str3;
    }
}
