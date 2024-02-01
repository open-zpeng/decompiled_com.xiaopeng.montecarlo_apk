package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RecommendLogoListItem implements Serializable {
    public String desc;
    public int exchange_type;
    public int id;
    public String list_logo;
    public int logo_status;
    public String name;
    public String normal_logo;
    public int value;
    public String weak_logo;

    public RecommendLogoListItem() {
        this.name = "";
        this.weak_logo = "";
        this.list_logo = "";
        this.value = 0;
        this.exchange_type = 0;
        this.logo_status = 0;
        this.normal_logo = "";
        this.id = 0;
        this.desc = "";
    }

    public RecommendLogoListItem(String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, String str5) {
        this.name = str;
        this.weak_logo = str2;
        this.list_logo = str3;
        this.value = i;
        this.exchange_type = i2;
        this.logo_status = i3;
        this.normal_logo = str4;
        this.id = i4;
        this.desc = str5;
    }
}
