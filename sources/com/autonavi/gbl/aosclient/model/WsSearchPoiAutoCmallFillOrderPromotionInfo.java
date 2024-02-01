package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsSearchPoiAutoCmallFillOrderPromotionInfo implements Serializable {
    public int cancelUseCoupon;
    public boolean has_coupon_list;
    public String schema;
    public WsSearchPoiAutoCmallFillOrderPromotionInfoSelected selected;

    public WsSearchPoiAutoCmallFillOrderPromotionInfo() {
        this.has_coupon_list = false;
        this.cancelUseCoupon = 0;
        this.schema = "";
        this.selected = new WsSearchPoiAutoCmallFillOrderPromotionInfoSelected();
    }

    public WsSearchPoiAutoCmallFillOrderPromotionInfo(boolean z, int i, String str, WsSearchPoiAutoCmallFillOrderPromotionInfoSelected wsSearchPoiAutoCmallFillOrderPromotionInfoSelected) {
        this.has_coupon_list = z;
        this.cancelUseCoupon = i;
        this.schema = str;
        this.selected = wsSearchPoiAutoCmallFillOrderPromotionInfoSelected;
    }
}
