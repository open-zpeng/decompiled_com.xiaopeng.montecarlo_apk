package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcCommonAgreementStatusResponseData implements Serializable {
    public String agreementNo;
    public int agreementStatus;
    public int payChannel;
    public String payLogonId;
    public int uid;

    public WsTcCommonAgreementStatusResponseData() {
        this.agreementNo = "";
        this.payLogonId = "";
        this.uid = 0;
        this.payChannel = 0;
        this.agreementStatus = 0;
    }

    public WsTcCommonAgreementStatusResponseData(String str, String str2, int i, int i2, int i3) {
        this.agreementNo = str;
        this.payLogonId = str2;
        this.uid = i;
        this.payChannel = i2;
        this.agreementStatus = i3;
    }
}
