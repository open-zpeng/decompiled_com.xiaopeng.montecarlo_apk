package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class IotTripodCompanyData implements Serializable {
    public String company;
    public String sn;

    public IotTripodCompanyData() {
        this.sn = "";
        this.company = "";
    }

    public IotTripodCompanyData(String str, String str2) {
        this.sn = str;
        this.company = str2;
    }
}
