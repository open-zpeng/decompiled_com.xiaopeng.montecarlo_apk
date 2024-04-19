package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcOrderDetailCredentialInfoItem implements Serializable {
    public String admissionCertificate;
    public String qrCode;
    public String qrUrl;

    public WsTcOrderDetailCredentialInfoItem() {
        this.qrUrl = "";
        this.qrCode = "";
        this.admissionCertificate = "";
    }

    public WsTcOrderDetailCredentialInfoItem(String str, String str2, String str3) {
        this.qrUrl = str;
        this.qrCode = str2;
        this.admissionCertificate = str3;
    }
}
