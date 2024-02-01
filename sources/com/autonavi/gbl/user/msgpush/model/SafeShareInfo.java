package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SafeShareInfo implements Serializable {
    public String reportId;

    public SafeShareInfo() {
        this.reportId = "";
    }

    public SafeShareInfo(String str) {
        this.reportId = str;
    }
}
