package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class UserReportInfo implements Serializable {
    public String info;
    public int time;

    public UserReportInfo() {
        this.info = "";
        this.time = 0;
    }

    public UserReportInfo(String str, int i) {
        this.info = str;
        this.time = i;
    }
}
