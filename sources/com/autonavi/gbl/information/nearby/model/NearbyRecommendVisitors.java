package com.autonavi.gbl.information.nearby.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NearbyRecommendVisitors implements Serializable {
    public ArrayList<String> descriptions;

    public NearbyRecommendVisitors() {
        this.descriptions = new ArrayList<>();
    }

    public NearbyRecommendVisitors(ArrayList<String> arrayList) {
        this.descriptions = arrayList;
    }
}
