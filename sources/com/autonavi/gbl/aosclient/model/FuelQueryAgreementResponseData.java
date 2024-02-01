package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class FuelQueryAgreementResponseData implements Serializable {
    public String channelLogonId;
    public int payChannel;
    public String signTime;
    public int status;
    public String validTime;

    public FuelQueryAgreementResponseData() {
        this.payChannel = 0;
        this.status = 0;
        this.validTime = "";
        this.signTime = "";
        this.channelLogonId = "";
    }

    public FuelQueryAgreementResponseData(int i, int i2, String str, String str2, String str3) {
        this.payChannel = i;
        this.status = i2;
        this.validTime = str;
        this.signTime = str2;
        this.channelLogonId = str3;
    }
}
