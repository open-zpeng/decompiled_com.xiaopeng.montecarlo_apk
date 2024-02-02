package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GFeedbackExtraContribute implements Serializable {
    public ArrayList<GFeedbackExtraContBusLine> bus_lines;
    public double latitude;
    public double longitude;
    public int place_exist;
    public String taskId;

    public GFeedbackExtraContribute() {
        this.taskId = "";
        this.place_exist = 0;
        this.longitude = 0.0d;
        this.latitude = 0.0d;
        this.bus_lines = new ArrayList<>();
    }

    public GFeedbackExtraContribute(String str, int i, double d, double d2, ArrayList<GFeedbackExtraContBusLine> arrayList) {
        this.taskId = str;
        this.place_exist = i;
        this.longitude = d;
        this.latitude = d2;
        this.bus_lines = arrayList;
    }
}
