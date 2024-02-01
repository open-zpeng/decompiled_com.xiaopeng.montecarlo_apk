package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcAlscOrderCancelResponseData implements Serializable {
    public String amapOrderId;
    public boolean result;

    public WsTcAlscOrderCancelResponseData() {
        this.amapOrderId = "";
        this.result = false;
    }

    public WsTcAlscOrderCancelResponseData(String str, boolean z) {
        this.amapOrderId = str;
        this.result = z;
    }
}
