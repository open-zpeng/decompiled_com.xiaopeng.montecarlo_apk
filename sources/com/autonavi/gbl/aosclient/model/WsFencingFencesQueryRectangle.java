package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsFencingFencesQueryRectangle implements Serializable {
    public ArrayList<Double> max;
    public ArrayList<Double> min;

    public WsFencingFencesQueryRectangle() {
        this.min = new ArrayList<>();
        this.max = new ArrayList<>();
    }

    public WsFencingFencesQueryRectangle(ArrayList<Double> arrayList, ArrayList<Double> arrayList2) {
        this.min = arrayList;
        this.max = arrayList2;
    }
}
