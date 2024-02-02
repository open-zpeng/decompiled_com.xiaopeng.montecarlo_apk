package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GNavigationEtaqueryReqElecConstListRangeSlope implements Serializable {
    public String down;
    public String up;

    public GNavigationEtaqueryReqElecConstListRangeSlope() {
        this.up = "";
        this.down = "";
    }

    public GNavigationEtaqueryReqElecConstListRangeSlope(String str, String str2) {
        this.up = str;
        this.down = str2;
    }
}
