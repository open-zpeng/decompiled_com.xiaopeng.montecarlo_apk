package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class HolidayCloudControl implements Serializable {
    public TipsCloudControl tipsControl;

    public HolidayCloudControl() {
        this.tipsControl = new TipsCloudControl();
    }

    public HolidayCloudControl(TipsCloudControl tipsCloudControl) {
        this.tipsControl = tipsCloudControl;
    }
}
