package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneRequestSource;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneResourceRequestFile implements Serializable {
    @LaneRequestSource.LaneRequestSource1
    public int requestSource;
    public String resourceFile;

    public LaneResourceRequestFile() {
        this.requestSource = 0;
        this.resourceFile = "";
    }

    public LaneResourceRequestFile(@LaneRequestSource.LaneRequestSource1 int i, String str) {
        this.requestSource = i;
        this.resourceFile = str;
    }
}
