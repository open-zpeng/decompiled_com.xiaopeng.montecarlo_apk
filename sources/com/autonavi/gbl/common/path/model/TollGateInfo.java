package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TollGateInfo implements Serializable {
    public ArrayList<Integer> laneTypes;

    public TollGateInfo() {
        this.laneTypes = new ArrayList<>();
    }

    public TollGateInfo(ArrayList<Integer> arrayList) {
        this.laneTypes = arrayList;
    }
}
