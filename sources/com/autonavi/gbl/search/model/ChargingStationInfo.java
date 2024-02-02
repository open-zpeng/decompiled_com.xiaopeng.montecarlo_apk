package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ChargingStationInfo implements Serializable {
    public String brand_desc;
    public boolean charging_rating_flag_term;
    public boolean credit_zhima;
    public String cscf;
    public String current_ele_price;
    public String current_ser_price;
    public String fast_free;
    public String fast_total;
    public String num_fast;
    public String num_slow;
    public String park_category;
    public ArrayList<ChargingPriceSchedule> priceSchedules;
    public String slow_free;
    public String slow_total;

    public ChargingStationInfo() {
        this.charging_rating_flag_term = false;
        this.credit_zhima = false;
        this.slow_free = "";
        this.fast_free = "";
        this.slow_total = "";
        this.fast_total = "";
        this.brand_desc = "";
        this.cscf = "";
        this.num_slow = "";
        this.num_fast = "";
        this.current_ele_price = "";
        this.current_ser_price = "";
        this.park_category = "";
        this.priceSchedules = new ArrayList<>();
    }

    public ChargingStationInfo(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, ArrayList<ChargingPriceSchedule> arrayList) {
        this.charging_rating_flag_term = z;
        this.credit_zhima = z2;
        this.slow_free = str;
        this.fast_free = str2;
        this.slow_total = str3;
        this.fast_total = str4;
        this.brand_desc = str5;
        this.cscf = str6;
        this.num_slow = str7;
        this.num_fast = str8;
        this.current_ele_price = str9;
        this.current_ser_price = str10;
        this.park_category = str11;
        this.priceSchedules = arrayList;
    }
}
