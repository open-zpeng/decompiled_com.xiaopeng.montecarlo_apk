package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneResourceResponse implements Serializable {
    public LaneResourceInfo resource;

    public LaneResourceResponse() {
        this.resource = new LaneResourceInfo();
    }

    public LaneResourceResponse(LaneResourceInfo laneResourceInfo) {
        this.resource = laneResourceInfo;
    }
}
