package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcKoubeiOrderSubmitResponseData implements Serializable {
    public String amapOrderId;
    public String payString;
    public int pollMills;
    public int pollNums;

    public WsTcKoubeiOrderSubmitResponseData() {
        this.amapOrderId = "";
        this.pollNums = 0;
        this.pollMills = 0;
        this.payString = "";
    }

    public WsTcKoubeiOrderSubmitResponseData(String str, int i, int i2, String str2) {
        this.amapOrderId = str;
        this.pollNums = i;
        this.pollMills = i2;
        this.payString = str2;
    }
}
