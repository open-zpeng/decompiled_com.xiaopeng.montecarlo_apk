package com.autonavi.gbl.guide.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NaviCongestionInfo implements Serializable {
    public ArrayList<NaviCongestionDetailInfo> congestionInfos;
    public CongestExtend extend;
    public long pathID;
    public long totalRemainDist;
    public long totalTimeOfSeconds;
    public boolean unobstructed;

    public NaviCongestionInfo() {
        this.pathID = 0L;
        this.totalTimeOfSeconds = 0L;
        this.totalRemainDist = 0L;
        this.unobstructed = false;
        this.congestionInfos = new ArrayList<>();
        this.extend = new CongestExtend();
    }

    public NaviCongestionInfo(long j, long j2, long j3, boolean z, ArrayList<NaviCongestionDetailInfo> arrayList, CongestExtend congestExtend) {
        this.pathID = j;
        this.totalTimeOfSeconds = j2;
        this.totalRemainDist = j3;
        this.unobstructed = z;
        this.congestionInfos = arrayList;
        this.extend = congestExtend;
    }
}
