package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcFuelCreateData implements Serializable {
    public String amapOrderId;
    public String payString;
    public int pollMills;
    public int pollNum;

    public WsTcFuelCreateData() {
        this.amapOrderId = "";
        this.pollMills = 0;
        this.payString = "";
        this.pollNum = 0;
    }

    public WsTcFuelCreateData(String str, int i, String str2, int i2) {
        this.amapOrderId = str;
        this.pollMills = i;
        this.payString = str2;
        this.pollNum = i2;
    }
}
