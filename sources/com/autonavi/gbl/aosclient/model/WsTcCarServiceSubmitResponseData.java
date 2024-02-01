package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcCarServiceSubmitResponseData implements Serializable {
    public String amapOrderId;
    public String cardOrderId;
    public String payString;
    public int pollMills;
    public int pollNum;

    public WsTcCarServiceSubmitResponseData() {
        this.pollMills = 0;
        this.pollNum = 0;
        this.amapOrderId = "";
        this.cardOrderId = "";
        this.payString = "";
    }

    public WsTcCarServiceSubmitResponseData(int i, int i2, String str, String str2, String str3) {
        this.pollMills = i;
        this.pollNum = i2;
        this.amapOrderId = str;
        this.cardOrderId = str2;
        this.payString = str3;
    }
}
