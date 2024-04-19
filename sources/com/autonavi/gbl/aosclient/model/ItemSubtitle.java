package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ItemSubtitle implements Serializable {
    public String color;
    public String size;
    public String text;

    public ItemSubtitle() {
        this.text = "";
        this.size = "";
        this.color = "";
    }

    public ItemSubtitle(String str, String str2, String str3) {
        this.text = str;
        this.size = str2;
        this.color = str3;
    }
}
