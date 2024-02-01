package com.autonavi.gbl.common.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class STTipsInfo implements Serializable {
    public ArrayList<STPoint> points;
    public ArrayList<STBaseTips> tipsList;

    public STTipsInfo() {
        this.points = new ArrayList<>();
        this.tipsList = new ArrayList<>();
    }

    public STTipsInfo(ArrayList<STPoint> arrayList, ArrayList<STBaseTips> arrayList2) {
        this.points = arrayList;
        this.tipsList = arrayList2;
    }
}
