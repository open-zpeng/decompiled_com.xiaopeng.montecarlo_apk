package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GNavigationEtaqueryAckRouteList implements Serializable {
    public int end_idx;
    public ArrayList<GNavigationEtaqueryAckRouteListPath> path;
    public int start_idx;
    public int status;

    public GNavigationEtaqueryAckRouteList() {
        this.status = 0;
        this.end_idx = 0;
        this.start_idx = 0;
        this.path = new ArrayList<>();
    }

    public GNavigationEtaqueryAckRouteList(int i, int i2, int i3, ArrayList<GNavigationEtaqueryAckRouteListPath> arrayList) {
        this.status = i;
        this.end_idx = i2;
        this.start_idx = i3;
        this.path = arrayList;
    }
}
