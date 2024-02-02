package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GNavigationEtaqueryReqRoute implements Serializable {
    public String option;
    public int strategy;

    public GNavigationEtaqueryReqRoute() {
        this.option = "";
        this.strategy = 0;
    }

    public GNavigationEtaqueryReqRoute(String str, int i) {
        this.option = str;
        this.strategy = i;
    }
}
