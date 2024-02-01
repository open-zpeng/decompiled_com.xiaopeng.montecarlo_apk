package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GNavigationEtaqueryReqStartEnd implements Serializable {
    public ArrayList<GNavigationEtaqueryReqStartPoints> points;

    public GNavigationEtaqueryReqStartEnd() {
        this.points = new ArrayList<>();
    }

    public GNavigationEtaqueryReqStartEnd(ArrayList<GNavigationEtaqueryReqStartPoints> arrayList) {
        this.points = arrayList;
    }
}
