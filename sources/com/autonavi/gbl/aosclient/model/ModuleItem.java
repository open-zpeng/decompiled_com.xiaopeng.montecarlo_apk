package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ModuleItem implements Serializable {
    public String bg;
    public String card_type;
    public ItemDesc desc;
    public String measure;
    public String name;
    public String schema;
    public ItemSubtitle subtitle;
    public String title;
    public String unit;
    public int unread_city_num;

    public ModuleItem() {
        this.name = "";
        this.card_type = "";
        this.title = "";
        this.measure = "";
        this.unread_city_num = 0;
        this.unit = "";
        this.schema = "";
        this.bg = "";
        this.desc = new ItemDesc();
        this.subtitle = new ItemSubtitle();
    }

    public ModuleItem(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, ItemDesc itemDesc, ItemSubtitle itemSubtitle) {
        this.name = str;
        this.card_type = str2;
        this.title = str3;
        this.measure = str4;
        this.unread_city_num = i;
        this.unit = str5;
        this.schema = str6;
        this.bg = str7;
        this.desc = itemDesc;
        this.subtitle = itemSubtitle;
    }
}
