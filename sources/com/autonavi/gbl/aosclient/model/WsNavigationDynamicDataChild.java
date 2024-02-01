package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataChild implements Serializable {
    public String brand_charge;
    public String building_status;
    public String id;
    public String name;
    public String noonTime;
    public String parent;
    public String parent_id;
    public String pay_type;
    public String price_gas_pack;
    public String sunriseTime;
    public String sunsetTime;
    public String tag_category;
    public String type;
    public String userNickname;
    public String x;
    public String y;

    public WsNavigationDynamicDataChild() {
        this.parent = "";
        this.building_status = "";
        this.parent_id = "";
        this.name = "";
        this.x = "";
        this.tag_category = "";
        this.y = "";
        this.pay_type = "";
        this.price_gas_pack = "";
        this.id = "";
        this.brand_charge = "";
        this.type = "";
        this.sunriseTime = "";
        this.noonTime = "";
        this.sunsetTime = "";
        this.userNickname = "";
    }

    public WsNavigationDynamicDataChild(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        this.parent = str;
        this.building_status = str2;
        this.parent_id = str3;
        this.name = str4;
        this.x = str5;
        this.tag_category = str6;
        this.y = str7;
        this.pay_type = str8;
        this.price_gas_pack = str9;
        this.id = str10;
        this.brand_charge = str11;
        this.type = str12;
        this.sunriseTime = str13;
        this.noonTime = str14;
        this.sunsetTime = str15;
        this.userNickname = str16;
    }
}
