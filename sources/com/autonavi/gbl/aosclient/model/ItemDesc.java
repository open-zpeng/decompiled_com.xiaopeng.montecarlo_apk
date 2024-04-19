package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ItemDesc implements Serializable {
    public String bg_color;
    public String color;
    public String text;

    public ItemDesc() {
        this.text = "";
        this.color = "";
        this.bg_color = "";
    }

    public ItemDesc(String str, String str2, String str3) {
        this.text = str;
        this.color = str2;
        this.bg_color = str3;
    }
}
