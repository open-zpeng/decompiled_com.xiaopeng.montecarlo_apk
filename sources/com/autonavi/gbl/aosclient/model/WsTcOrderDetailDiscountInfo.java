package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcOrderDetailDiscountInfo implements Serializable {
    public String actIds;
    public String text;

    public WsTcOrderDetailDiscountInfo() {
        this.text = "";
        this.actIds = "";
    }

    public WsTcOrderDetailDiscountInfo(String str, String str2) {
        this.text = str;
        this.actIds = str2;
    }
}
