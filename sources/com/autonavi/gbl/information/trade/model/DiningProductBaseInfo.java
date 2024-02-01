package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningProductBaseInfo implements Serializable {
    public String id;
    public String imageUrl;
    public String name;

    public DiningProductBaseInfo() {
        this.imageUrl = "";
        this.name = "";
        this.id = "";
    }

    public DiningProductBaseInfo(String str, String str2, String str3) {
        this.imageUrl = str;
        this.name = str2;
        this.id = str3;
    }
}
