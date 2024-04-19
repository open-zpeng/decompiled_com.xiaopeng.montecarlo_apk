package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class AvoidJamDetail implements Serializable {
    public DetailCloudControl detailCloudControl;
    public long detailDist;
    public long detailSpeed;
    public long detailStatus;
    public long detailTime;
    public String strDetailRoadName;

    public AvoidJamDetail() {
        this.detailCloudControl = new DetailCloudControl();
        this.detailSpeed = 0L;
        this.detailTime = 0L;
        this.detailStatus = 0L;
        this.detailDist = 0L;
        this.strDetailRoadName = "";
    }

    public AvoidJamDetail(DetailCloudControl detailCloudControl, long j, long j2, long j3, long j4, String str) {
        this.detailCloudControl = detailCloudControl;
        this.detailSpeed = j;
        this.detailTime = j2;
        this.detailStatus = j3;
        this.detailDist = j4;
        this.strDetailRoadName = str;
    }
}
