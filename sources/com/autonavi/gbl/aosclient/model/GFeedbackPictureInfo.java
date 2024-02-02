package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GFeedbackPictureInfo implements Serializable {
    public String angle;
    public double lat;
    public double lon;
    public int type;

    public GFeedbackPictureInfo() {
        this.lon = 0.0d;
        this.lat = 0.0d;
        this.angle = "";
        this.type = 0;
    }

    public GFeedbackPictureInfo(double d, double d2, String str, int i) {
        this.lon = d;
        this.lat = d2;
        this.angle = str;
        this.type = i;
    }
}
