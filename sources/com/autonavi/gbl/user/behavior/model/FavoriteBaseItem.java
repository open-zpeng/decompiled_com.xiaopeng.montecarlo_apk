package com.autonavi.gbl.user.behavior.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class FavoriteBaseItem implements Serializable {
    public String item_id;
    public String name;
    public String poiid;
    public int point_x;
    public int point_y;

    public FavoriteBaseItem() {
        this.poiid = "";
        this.item_id = "";
        this.name = "";
        this.point_x = 0;
        this.point_y = 0;
    }

    public FavoriteBaseItem(String str, String str2, String str3, int i, int i2) {
        this.poiid = str;
        this.item_id = str2;
        this.name = str3;
        this.point_x = i;
        this.point_y = i2;
    }
}
