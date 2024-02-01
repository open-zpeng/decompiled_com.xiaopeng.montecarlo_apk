package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcCommonAgreementSignResponseData implements Serializable {
    public String agreementString;
    public String subCode;
    public String subMsg;
    public boolean success;

    public WsTcCommonAgreementSignResponseData() {
        this.agreementString = "";
        this.subMsg = "";
        this.subCode = "";
        this.success = false;
    }

    public WsTcCommonAgreementSignResponseData(String str, String str2, String str3, boolean z) {
        this.agreementString = str;
        this.subMsg = str2;
        this.subCode = str3;
        this.success = z;
    }
}
