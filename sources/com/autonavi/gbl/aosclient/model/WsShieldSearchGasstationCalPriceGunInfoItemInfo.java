package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPriceGunInfoItemInfo implements Serializable {
    public ArrayList<WsShieldSearchGasstationCalPriceGunNumInfo> gun_num_info;
    public int need_fold;
    public String oil_category;
    public String oil_price;
    public String oil_type;

    public WsShieldSearchGasstationCalPriceGunInfoItemInfo() {
        this.oil_category = "";
        this.oil_type = "";
        this.oil_price = "";
        this.gun_num_info = new ArrayList<>();
        this.need_fold = 0;
    }

    public WsShieldSearchGasstationCalPriceGunInfoItemInfo(String str, String str2, String str3, ArrayList<WsShieldSearchGasstationCalPriceGunNumInfo> arrayList, int i) {
        this.oil_category = str;
        this.oil_type = str2;
        this.oil_price = str3;
        this.gun_num_info = arrayList;
        this.need_fold = i;
    }
}
