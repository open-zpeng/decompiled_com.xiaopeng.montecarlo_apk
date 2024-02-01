package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsFencingFencesQueryGeometry implements Serializable {
    public ArrayList<Double> point;
    public String type;

    public WsFencingFencesQueryGeometry() {
        this.type = "";
        this.point = new ArrayList<>();
    }

    public WsFencingFencesQueryGeometry(String str, ArrayList<Double> arrayList) {
        this.type = str;
        this.point = arrayList;
    }
}
