package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DeepCharging implements Serializable {
    public String business;
    public ArrayList<DeepChargeInfo> chargeInfo;
    public String charge_src_name;
    public ArrayList<DeepChargingPrice> chargingPrice;
    public String cscf;
    public DeepChargingPrice currentChargingPrice;
    public String national_standard;
    public int num_fast;
    public int num_slow;
    public String pay_type;
    public String price_parking;
    public String src_id;
    public String src_type;

    public DeepCharging() {
        this.chargeInfo = new ArrayList<>();
        this.national_standard = "";
        this.pay_type = "";
        this.num_fast = 0;
        this.business = "";
        this.num_slow = 0;
        this.src_id = "";
        this.src_type = "";
        this.charge_src_name = "";
        this.cscf = "";
        this.price_parking = "";
        this.chargingPrice = new ArrayList<>();
        this.currentChargingPrice = new DeepChargingPrice();
    }

    public DeepCharging(ArrayList<DeepChargeInfo> arrayList, String str, String str2, int i, String str3, int i2, String str4, String str5, String str6, String str7, String str8, ArrayList<DeepChargingPrice> arrayList2, DeepChargingPrice deepChargingPrice) {
        this.chargeInfo = arrayList;
        this.national_standard = str;
        this.pay_type = str2;
        this.num_fast = i;
        this.business = str3;
        this.num_slow = i2;
        this.src_id = str4;
        this.src_type = str5;
        this.charge_src_name = str6;
        this.cscf = str7;
        this.price_parking = str8;
        this.chargingPrice = arrayList2;
        this.currentChargingPrice = deepChargingPrice;
    }
}
