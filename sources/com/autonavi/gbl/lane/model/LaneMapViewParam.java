package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneMapViewParam implements Serializable {
    public String dayStyleName;
    public String iconsName;
    public int mapEngineId;
    public String nightStyleName;

    public LaneMapViewParam() {
        this.mapEngineId = 0;
        this.dayStyleName = "";
        this.nightStyleName = "";
        this.iconsName = "";
    }

    public LaneMapViewParam(int i, String str, String str2, String str3) {
        this.mapEngineId = i;
        this.dayStyleName = str;
        this.nightStyleName = str2;
        this.iconsName = str3;
    }
}
