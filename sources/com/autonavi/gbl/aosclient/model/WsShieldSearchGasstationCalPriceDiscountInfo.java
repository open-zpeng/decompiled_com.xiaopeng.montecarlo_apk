package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPriceDiscountInfo implements Serializable {
    public int activityCardNo;
    public String coupon_business;
    public int coupon_count;
    public WsShieldSearchGasstationCalPriceCouponOrderParam coupon_order_param;
    public String coupon_param;
    public String coupon_price;
    public String discount_money;
    public String optimal_rec;
    public String show_discount_money;

    public WsShieldSearchGasstationCalPriceDiscountInfo() {
        this.coupon_count = 0;
        this.coupon_param = "";
        this.coupon_business = "";
        this.coupon_price = "";
        this.activityCardNo = 0;
        this.coupon_order_param = new WsShieldSearchGasstationCalPriceCouponOrderParam();
        this.optimal_rec = "";
        this.discount_money = "";
        this.show_discount_money = "";
    }

    public WsShieldSearchGasstationCalPriceDiscountInfo(int i, String str, String str2, String str3, int i2, WsShieldSearchGasstationCalPriceCouponOrderParam wsShieldSearchGasstationCalPriceCouponOrderParam, String str4, String str5, String str6) {
        this.coupon_count = i;
        this.coupon_param = str;
        this.coupon_business = str2;
        this.coupon_price = str3;
        this.activityCardNo = i2;
        this.coupon_order_param = wsShieldSearchGasstationCalPriceCouponOrderParam;
        this.optimal_rec = str4;
        this.discount_money = str5;
        this.show_discount_money = str6;
    }
}
