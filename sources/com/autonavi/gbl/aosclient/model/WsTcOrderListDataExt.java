package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcOrderListDataExt implements Serializable {
    public String cpOrderId;
    public String refuelLiter;
    public String srcType;

    public WsTcOrderListDataExt() {
        this.refuelLiter = "";
        this.cpOrderId = "";
        this.srcType = "";
    }

    public WsTcOrderListDataExt(String str, String str2, String str3) {
        this.refuelLiter = str;
        this.cpOrderId = str2;
        this.srcType = str3;
    }
}
