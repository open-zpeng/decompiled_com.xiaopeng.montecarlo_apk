package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GFeedbackDescReDes implements Serializable {
    public String des;
    public String desc;
    public String lineid;
    public String suboption;
    public String subtype;
    public String time;
    public String type;

    public GFeedbackDescReDes() {
        this.des = "";
        this.desc = "";
        this.type = "";
        this.subtype = "";
        this.suboption = "";
        this.time = "";
        this.lineid = "";
    }

    public GFeedbackDescReDes(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.des = str;
        this.desc = str2;
        this.type = str3;
        this.subtype = str4;
        this.suboption = str5;
        this.time = str6;
        this.lineid = str7;
    }
}
