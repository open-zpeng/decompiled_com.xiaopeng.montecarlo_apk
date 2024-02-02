package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GVoicePath implements Serializable {
    public String color;
    public String length;
    public String statusdesc;
    public String traveltime;

    public GVoicePath() {
        this.color = "";
        this.length = "";
        this.statusdesc = "";
        this.traveltime = "";
    }

    public GVoicePath(String str, String str2, String str3, String str4) {
        this.color = str;
        this.length = str2;
        this.statusdesc = str3;
        this.traveltime = str4;
    }
}
