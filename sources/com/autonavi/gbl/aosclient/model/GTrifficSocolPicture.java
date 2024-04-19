package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GTrifficSocolPicture implements Serializable {
    public String socol_picture;
    public double x;
    public double y;

    public GTrifficSocolPicture() {
        this.x = 0.0d;
        this.y = 0.0d;
        this.socol_picture = "";
    }

    public GTrifficSocolPicture(double d, double d2, String str) {
        this.x = d;
        this.y = d2;
        this.socol_picture = str;
    }
}
