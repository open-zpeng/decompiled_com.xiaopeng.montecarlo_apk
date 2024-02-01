package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.search.model.ShelfSourceType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningTradePrice implements Serializable {
    public int buyCount;
    public DiningTradeDiscountCouponInfo couponInfo;
    public String originalId;
    @ShelfSourceType.ShelfSourceType1
    public int shelfSource;
    public String skuId;

    public DiningTradePrice() {
        this.originalId = "";
        this.skuId = "";
        this.buyCount = 1;
        this.shelfSource = -1;
        this.couponInfo = new DiningTradeDiscountCouponInfo();
    }

    public DiningTradePrice(String str, String str2, int i, @ShelfSourceType.ShelfSourceType1 int i2, DiningTradeDiscountCouponInfo diningTradeDiscountCouponInfo) {
        this.originalId = str;
        this.skuId = str2;
        this.buyCount = i;
        this.shelfSource = i2;
        this.couponInfo = diningTradeDiscountCouponInfo;
    }
}
