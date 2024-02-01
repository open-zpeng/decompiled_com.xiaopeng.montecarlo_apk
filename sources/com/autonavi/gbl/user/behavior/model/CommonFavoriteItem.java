package com.autonavi.gbl.user.behavior.model;

import com.autonavi.gbl.user.behavior.model.FavoriteType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class CommonFavoriteItem implements Serializable {
    public String address;
    public String city_code;
    public String city_name;
    public String classification;
    @FavoriteType.FavoriteType1
    public int common_name;
    public String custom_name;
    public String item_id;
    public String name;
    public String newType;
    public String phone_numbers;
    public int point_x;
    public int point_x_arrive;
    public int point_y;
    public int point_y_arrive;
    public String tag;
    public long top_time;
    public String type;

    public CommonFavoriteItem() {
        this.item_id = "";
        this.name = "";
        this.common_name = 0;
        this.point_x = 0;
        this.point_y = 0;
        this.point_x_arrive = 0;
        this.point_y_arrive = 0;
        this.city_name = "";
        this.city_code = "";
        this.phone_numbers = "";
        this.tag = "";
        this.type = "";
        this.newType = "";
        this.custom_name = "";
        this.address = "";
        this.classification = "";
        this.top_time = 0L;
    }

    public CommonFavoriteItem(String str, String str2, @FavoriteType.FavoriteType1 int i, int i2, int i3, int i4, int i5, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j) {
        this.item_id = str;
        this.name = str2;
        this.common_name = i;
        this.point_x = i2;
        this.point_y = i3;
        this.point_x_arrive = i4;
        this.point_y_arrive = i5;
        this.city_name = str3;
        this.city_code = str4;
        this.phone_numbers = str5;
        this.tag = str6;
        this.type = str7;
        this.newType = str8;
        this.custom_name = str9;
        this.address = str10;
        this.classification = str11;
        this.top_time = j;
    }
}
