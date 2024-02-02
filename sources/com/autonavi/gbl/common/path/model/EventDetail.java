package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class EventDetail implements Serializable {
    public DetailCloudControl detailControl;
    public long eventID;

    public EventDetail() {
        this.detailControl = new DetailCloudControl();
        this.eventID = 0L;
    }

    public EventDetail(DetailCloudControl detailCloudControl, long j) {
        this.detailControl = detailCloudControl;
        this.eventID = j;
    }
}
