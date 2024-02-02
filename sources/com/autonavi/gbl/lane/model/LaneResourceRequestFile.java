package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LANE_REQUREST_SOURCE;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneResourceRequestFile implements Serializable {
    @LANE_REQUREST_SOURCE.LANE_REQUREST_SOURCE1
    public int requestSource;
    public String resourceFile;

    public LaneResourceRequestFile() {
        this.requestSource = 0;
        this.resourceFile = "";
    }

    public LaneResourceRequestFile(@LANE_REQUREST_SOURCE.LANE_REQUREST_SOURCE1 int i, String str) {
        this.requestSource = i;
        this.resourceFile = str;
    }
}
