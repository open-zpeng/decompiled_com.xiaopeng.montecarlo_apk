package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcCommonAgreementStatusRequestData implements Serializable {
    public int agreementType;
    public int bizType;
    public WsTcCommonAgreementStatusDataExt ext;
    public int payChannel;
    public int scene;

    public WsTcCommonAgreementStatusRequestData() {
        this.agreementType = 0;
        this.payChannel = 0;
        this.bizType = 0;
        this.scene = 0;
        this.ext = new WsTcCommonAgreementStatusDataExt();
    }

    public WsTcCommonAgreementStatusRequestData(int i, int i2, int i3, int i4, WsTcCommonAgreementStatusDataExt wsTcCommonAgreementStatusDataExt) {
        this.agreementType = i;
        this.payChannel = i2;
        this.bizType = i3;
        this.scene = i4;
        this.ext = wsTcCommonAgreementStatusDataExt;
    }
}
