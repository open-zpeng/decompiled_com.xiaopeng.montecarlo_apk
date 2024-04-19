package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GFeedbackDescEditDes implements Serializable {
    public String address;
    public String name;
    public String new_line;
    public String nonexistentlines;
    public String ownline;
    public String tel;

    public GFeedbackDescEditDes() {
        this.address = "";
        this.tel = "";
        this.nonexistentlines = "";
        this.new_line = "";
        this.name = "";
        this.ownline = "";
    }

    public GFeedbackDescEditDes(String str, String str2, String str3, String str4, String str5, String str6) {
        this.address = str;
        this.tel = str2;
        this.nonexistentlines = str3;
        this.new_line = str4;
        this.name = str5;
        this.ownline = str6;
    }
}
