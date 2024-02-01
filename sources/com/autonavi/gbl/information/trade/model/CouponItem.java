package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CouponItem implements Serializable {
    public int beginDate;
    public int endDate;
    public long recordId;
    public String title;

    public CouponItem() {
        this.title = "";
        this.recordId = -1L;
        this.beginDate = 0;
        this.endDate = 0;
    }

    public CouponItem(String str, long j, int i, int i2) {
        this.title = str;
        this.recordId = j;
        this.beginDate = i;
        this.endDate = i2;
    }
}
