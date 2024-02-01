package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPriceDataGunInfo implements Serializable {
    public ArrayList<WsShieldSearchGasstationCalPriceGunInfoItemInfo> item_info;
    public String oil_type_title;
    public String sub_title;
    public String title;

    public WsShieldSearchGasstationCalPriceDataGunInfo() {
        this.title = "";
        this.sub_title = "";
        this.oil_type_title = "";
        this.item_info = new ArrayList<>();
    }

    public WsShieldSearchGasstationCalPriceDataGunInfo(String str, String str2, String str3, ArrayList<WsShieldSearchGasstationCalPriceGunInfoItemInfo> arrayList) {
        this.title = str;
        this.sub_title = str2;
        this.oil_type_title = str3;
        this.item_info = arrayList;
    }
}
