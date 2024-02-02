package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PlanPrefInfo implements Serializable {
    public ArrayList<Integer> planPrefs;

    public PlanPrefInfo() {
        this.planPrefs = new ArrayList<>();
    }

    public PlanPrefInfo(ArrayList<Integer> arrayList) {
        this.planPrefs = arrayList;
    }
}
