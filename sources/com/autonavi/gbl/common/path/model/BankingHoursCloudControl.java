package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class BankingHoursCloudControl implements Serializable {
    public String strTime;
    public TipsCloudControl tipsControl;

    public BankingHoursCloudControl() {
        this.tipsControl = new TipsCloudControl();
        this.strTime = "";
    }

    public BankingHoursCloudControl(TipsCloudControl tipsCloudControl, String str) {
        this.tipsControl = tipsCloudControl;
        this.strTime = str;
    }
}
