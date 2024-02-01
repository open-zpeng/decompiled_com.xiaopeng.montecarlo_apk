package com.autonavi.gbl.guide.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CruisePredictiveLane implements Serializable {
    public ArrayList<Integer> actionList;
    public long linkId;
    public String linkName;

    public CruisePredictiveLane() {
        this.actionList = new ArrayList<>();
        this.linkId = 0L;
        this.linkName = "";
    }

    public CruisePredictiveLane(ArrayList<Integer> arrayList, long j, String str) {
        this.actionList = arrayList;
        this.linkId = j;
        this.linkName = str;
    }
}
