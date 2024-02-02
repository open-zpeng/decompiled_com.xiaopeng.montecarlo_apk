package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchParkInOutInfo implements Serializable {
    public String entExitId;
    public String keytype;
    public double x;
    public double y;

    public SearchParkInOutInfo() {
        this.x = 0.0d;
        this.y = 0.0d;
        this.keytype = "";
        this.entExitId = "";
    }

    public SearchParkInOutInfo(double d, double d2, String str, String str2) {
        this.x = d;
        this.y = d2;
        this.keytype = str;
        this.entExitId = str2;
    }
}
