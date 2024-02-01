package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.util.model.DateTime;
import java.io.Serializable;
/* loaded from: classes.dex */
public class OrderTimeInformation implements Serializable {
    public DateTime createTime;
    public DateTime expireTime;
    public DateTime modifiedTime;
    public DateTime payTime;

    public OrderTimeInformation() {
        this.createTime = new DateTime();
        this.modifiedTime = new DateTime();
        this.payTime = new DateTime();
        this.expireTime = new DateTime();
    }

    public OrderTimeInformation(DateTime dateTime, DateTime dateTime2, DateTime dateTime3, DateTime dateTime4) {
        this.createTime = dateTime;
        this.modifiedTime = dateTime2;
        this.payTime = dateTime3;
        this.expireTime = dateTime4;
    }
}
