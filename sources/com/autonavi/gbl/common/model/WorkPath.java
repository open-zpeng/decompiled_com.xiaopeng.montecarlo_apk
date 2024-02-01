package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WorkPath implements Serializable {
    public String cache;
    public String continueNavi;
    public String navi;
    public String res;

    public WorkPath() {
        this.navi = "";
        this.res = "";
        this.cache = "";
        this.continueNavi = "";
    }

    public WorkPath(String str, String str2, String str3, String str4) {
        this.navi = str;
        this.res = str2;
        this.cache = str3;
        this.continueNavi = str4;
    }
}
