package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPriceResponseData implements Serializable {
    public String banner_info;
    public WsShieldSearchGasstationCalPriceDiscountInfo discount_info;
    public ArrayList<WsShieldSearchGasstationCalPriceDiscountPriceInfo> discount_price_info;
    public WsShieldSearchGasstationCalPriceDataGunInfo gun_info;
    public String message_info;
    public WsShieldSearchGasstationCalPriceDataPoiInfo poi_info;
    public WsShieldSearchGasstationCalPriceDataPriceInfo price_info;
    public WsShieldSearchGasstationCalPriceSourceInfo source_info;

    public WsShieldSearchGasstationCalPriceResponseData() {
        this.poi_info = new WsShieldSearchGasstationCalPriceDataPoiInfo();
        this.gun_info = new WsShieldSearchGasstationCalPriceDataGunInfo();
        this.discount_price_info = new ArrayList<>();
        this.price_info = new WsShieldSearchGasstationCalPriceDataPriceInfo();
        this.source_info = new WsShieldSearchGasstationCalPriceSourceInfo();
        this.banner_info = "";
        this.discount_info = new WsShieldSearchGasstationCalPriceDiscountInfo();
        this.message_info = "";
    }

    public WsShieldSearchGasstationCalPriceResponseData(WsShieldSearchGasstationCalPriceDataPoiInfo wsShieldSearchGasstationCalPriceDataPoiInfo, WsShieldSearchGasstationCalPriceDataGunInfo wsShieldSearchGasstationCalPriceDataGunInfo, ArrayList<WsShieldSearchGasstationCalPriceDiscountPriceInfo> arrayList, WsShieldSearchGasstationCalPriceDataPriceInfo wsShieldSearchGasstationCalPriceDataPriceInfo, WsShieldSearchGasstationCalPriceSourceInfo wsShieldSearchGasstationCalPriceSourceInfo, String str, WsShieldSearchGasstationCalPriceDiscountInfo wsShieldSearchGasstationCalPriceDiscountInfo, String str2) {
        this.poi_info = wsShieldSearchGasstationCalPriceDataPoiInfo;
        this.gun_info = wsShieldSearchGasstationCalPriceDataGunInfo;
        this.discount_price_info = arrayList;
        this.price_info = wsShieldSearchGasstationCalPriceDataPriceInfo;
        this.source_info = wsShieldSearchGasstationCalPriceSourceInfo;
        this.banner_info = str;
        this.discount_info = wsShieldSearchGasstationCalPriceDiscountInfo;
        this.message_info = str2;
    }
}
