package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GroupTimeRange implements Serializable {
    public TimeRangeBl endTime;
    public TimeRangeBl startTime;

    public GroupTimeRange() {
        this.startTime = new TimeRangeBl();
        this.endTime = new TimeRangeBl();
    }

    public GroupTimeRange(TimeRangeBl timeRangeBl, TimeRangeBl timeRangeBl2) {
        this.startTime = timeRangeBl;
        this.endTime = timeRangeBl2;
    }
}
