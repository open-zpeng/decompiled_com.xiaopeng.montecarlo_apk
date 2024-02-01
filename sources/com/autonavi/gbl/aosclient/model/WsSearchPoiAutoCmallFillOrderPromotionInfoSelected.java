package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsSearchPoiAutoCmallFillOrderPromotionInfoSelected implements Serializable {
    public long activity_card_no;
    public long activity_code;
    public int amount;
    public String exchange_args;
    public String id_value;
    public String out_id;

    public WsSearchPoiAutoCmallFillOrderPromotionInfoSelected() {
        this.id_value = "";
        this.out_id = "";
        this.activity_card_no = 0L;
        this.amount = 0;
        this.activity_code = 0L;
        this.exchange_args = "";
    }

    public WsSearchPoiAutoCmallFillOrderPromotionInfoSelected(String str, String str2, long j, int i, long j2, String str3) {
        this.id_value = str;
        this.out_id = str2;
        this.activity_card_no = j;
        this.amount = i;
        this.activity_code = j2;
        this.exchange_args = str3;
    }
}
