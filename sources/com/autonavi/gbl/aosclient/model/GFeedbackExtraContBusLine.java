package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GFeedbackExtraContBusLine implements Serializable {
    public String end_station;
    public double latitude;
    public String line_desc;
    public int line_exist;
    public String line_id;
    public String line_name;
    public double longitude;
    public String next_station;
    public String start_station;

    public GFeedbackExtraContBusLine() {
        this.line_id = "";
        this.line_name = "";
        this.next_station = "";
        this.line_exist = -1;
        this.longitude = 0.0d;
        this.latitude = 0.0d;
        this.start_station = "";
        this.end_station = "";
        this.line_desc = "";
    }

    public GFeedbackExtraContBusLine(String str, String str2, String str3, int i, double d, double d2, String str4, String str5, String str6) {
        this.line_id = str;
        this.line_name = str2;
        this.next_station = str3;
        this.line_exist = i;
        this.longitude = d;
        this.latitude = d2;
        this.start_station = str4;
        this.end_station = str5;
        this.line_desc = str6;
    }
}
