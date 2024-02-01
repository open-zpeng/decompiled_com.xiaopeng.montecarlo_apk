package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPriceDataPriceInfo implements Serializable {
    public String btn_text;
    public String discount_price;
    public String discount_price_simple;
    public String input_price;
    public String litre;
    public String litre_simple;
    public String oil_type;
    public String price;
    public String price_simple;
    public String service_fee;
    public String service_fee_simple;
    public String show_discount_price_simple;
    public String text;
    public String unit_price;

    public WsShieldSearchGasstationCalPriceDataPriceInfo() {
        this.input_price = "";
        this.price = "";
        this.discount_price = "";
        this.oil_type = "";
        this.litre = "";
        this.btn_text = "";
        this.price_simple = "";
        this.discount_price_simple = "";
        this.show_discount_price_simple = "";
        this.litre_simple = "";
        this.text = "";
        this.unit_price = "";
        this.service_fee_simple = "";
        this.service_fee = "";
    }

    public WsShieldSearchGasstationCalPriceDataPriceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.input_price = str;
        this.price = str2;
        this.discount_price = str3;
        this.oil_type = str4;
        this.litre = str5;
        this.btn_text = str6;
        this.price_simple = str7;
        this.discount_price_simple = str8;
        this.show_discount_price_simple = str9;
        this.litre_simple = str10;
        this.text = str11;
        this.unit_price = str12;
        this.service_fee_simple = str13;
        this.service_fee = str14;
    }
}
