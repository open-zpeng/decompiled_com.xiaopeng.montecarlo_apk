package com.autonavi.gbl.route.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ConsisRecoverSegmentInfo implements Serializable {
    public int begSegmentIdx;
    public int endSegmentIdx;
    public String offlineCustomId;
    public ArrayList<ConsisSegmentUnit> segs;

    public ConsisRecoverSegmentInfo() {
        this.offlineCustomId = "";
        this.begSegmentIdx = 0;
        this.endSegmentIdx = 0;
        this.segs = new ArrayList<>();
    }

    public ConsisRecoverSegmentInfo(String str, int i, int i2, ArrayList<ConsisSegmentUnit> arrayList) {
        this.offlineCustomId = str;
        this.begSegmentIdx = i;
        this.endSegmentIdx = i2;
        this.segs = arrayList;
    }
}
