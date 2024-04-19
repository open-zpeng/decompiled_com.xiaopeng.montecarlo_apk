package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class NaviInfoPanel implements Serializable {
    public int maneuverID;
    public int nextRoadNameLinkIdx;
    public int nextRoadNameSegIdx;
    public String nextRouteName;
    public TimeAndDist segmentRemain;
    public int split;

    public NaviInfoPanel() {
        this.maneuverID = 0;
        this.segmentRemain = new TimeAndDist();
        this.nextRouteName = "";
        this.nextRoadNameSegIdx = 0;
        this.nextRoadNameLinkIdx = 0;
        this.split = 0;
    }

    public NaviInfoPanel(int i, TimeAndDist timeAndDist, String str, int i2, int i3, int i4) {
        this.maneuverID = i;
        this.segmentRemain = timeAndDist;
        this.nextRouteName = str;
        this.nextRoadNameSegIdx = i2;
        this.nextRoadNameLinkIdx = i3;
        this.split = i4;
    }
}
