package com.autonavi.gbl.pos.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LocMMFeedbackInfo implements Serializable {
    public int count;
    public ArrayList<LocFeedbackNode> feedbackNodes;
    public boolean gpsOnRoad;
    public boolean hasMapData;
    public BigInteger ticktime;
    public double toRoadEndDist;
    public double toRoadStartDist;
    public boolean viaductStartFlag;

    public LocMMFeedbackInfo() {
        this.ticktime = new BigInteger("0");
        this.count = 0;
        this.toRoadStartDist = 0.0d;
        this.toRoadEndDist = 0.0d;
        this.feedbackNodes = new ArrayList<>();
        this.viaductStartFlag = false;
        this.hasMapData = false;
        this.gpsOnRoad = false;
    }

    public LocMMFeedbackInfo(BigInteger bigInteger, int i, double d, double d2, ArrayList<LocFeedbackNode> arrayList, boolean z, boolean z2, boolean z3) {
        this.ticktime = bigInteger;
        this.count = i;
        this.toRoadStartDist = d;
        this.toRoadEndDist = d2;
        this.feedbackNodes = arrayList;
        this.viaductStartFlag = z;
        this.hasMapData = z2;
        this.gpsOnRoad = z3;
    }
}
