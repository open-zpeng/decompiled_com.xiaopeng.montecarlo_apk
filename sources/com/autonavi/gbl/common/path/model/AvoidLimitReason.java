package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AvoidLimitReason implements Serializable {
    public ArrayList<LimitPointInfo> limitPointList;
    public ArrayList<String> roadNameList;

    public AvoidLimitReason() {
        this.roadNameList = new ArrayList<>();
        this.limitPointList = new ArrayList<>();
    }

    public AvoidLimitReason(ArrayList<String> arrayList, ArrayList<LimitPointInfo> arrayList2) {
        this.roadNameList = arrayList;
        this.limitPointList = arrayList2;
    }
}
