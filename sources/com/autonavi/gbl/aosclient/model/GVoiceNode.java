package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GVoiceNode implements Serializable {
    public String description;
    public String length;
    public String roadname;
    public String state;

    public GVoiceNode() {
        this.state = "";
        this.description = "";
        this.length = "";
        this.roadname = "";
    }

    public GVoiceNode(String str, String str2, String str3, String str4) {
        this.state = str;
        this.description = str2;
        this.length = str3;
        this.roadname = str4;
    }
}
