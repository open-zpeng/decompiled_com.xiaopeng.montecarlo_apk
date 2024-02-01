package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsSearchPoiAutoCmallFillOrderDataMeta implements Serializable {
    public String alsc_order_reqstr;
    public String city_id;
    public String industry;
    public boolean is_need_bind_alipay;
    public String store_id;

    public WsSearchPoiAutoCmallFillOrderDataMeta() {
        this.is_need_bind_alipay = false;
        this.alsc_order_reqstr = "";
        this.store_id = "";
        this.city_id = "";
        this.industry = "";
    }

    public WsSearchPoiAutoCmallFillOrderDataMeta(boolean z, String str, String str2, String str3, String str4) {
        this.is_need_bind_alipay = z;
        this.alsc_order_reqstr = str;
        this.store_id = str2;
        this.city_id = str3;
        this.industry = str4;
    }
}
