package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcCommonAgreementOrderQuickPayResponseData implements Serializable {
    public String amapOrderId;
    public int pollMills;
    public int pollNum;

    public WsTcCommonAgreementOrderQuickPayResponseData() {
        this.amapOrderId = "";
        this.pollMills = 0;
        this.pollNum = 0;
    }

    public WsTcCommonAgreementOrderQuickPayResponseData(String str, int i, int i2) {
        this.amapOrderId = str;
        this.pollMills = i;
        this.pollNum = i2;
    }
}
