package com.autonavi.gbl.data.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class HotUpdateCheckParam implements Serializable {
    public String strTbtVersion;

    public HotUpdateCheckParam() {
        this.strTbtVersion = "";
    }

    public HotUpdateCheckParam(String str) {
        this.strTbtVersion = str;
    }
}
