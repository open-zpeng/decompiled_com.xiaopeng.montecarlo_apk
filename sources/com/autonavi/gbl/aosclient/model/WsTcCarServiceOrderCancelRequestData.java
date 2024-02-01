package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcCarServiceOrderCancelRequestData implements Serializable {
    public String amapOrderId;

    public WsTcCarServiceOrderCancelRequestData() {
        this.amapOrderId = "";
    }

    public WsTcCarServiceOrderCancelRequestData(String str) {
        this.amapOrderId = str;
    }
}
