package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.util.model.DateTime;
import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningRefundTimeInfo implements Serializable {
    public String description;
    public DateTime timeInfo;

    public DiningRefundTimeInfo() {
        this.timeInfo = new DateTime();
        this.description = "";
    }

    public DiningRefundTimeInfo(DateTime dateTime, String str) {
        this.timeInfo = dateTime;
        this.description = str;
    }
}
