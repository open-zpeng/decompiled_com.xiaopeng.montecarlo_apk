package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcCommonAgreementOrderQuickPayRequestData implements Serializable {
    public String amapOrderId;

    public WsTcCommonAgreementOrderQuickPayRequestData() {
        this.amapOrderId = "";
    }

    public WsTcCommonAgreementOrderQuickPayRequestData(String str) {
        this.amapOrderId = str;
    }
}
