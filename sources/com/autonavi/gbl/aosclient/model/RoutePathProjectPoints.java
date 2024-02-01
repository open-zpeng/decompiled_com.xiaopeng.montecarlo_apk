package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RoutePathProjectPoints implements Serializable {
    public int path_idx;
    public ArrayList<RouteViaProjInfo> via_proj_info;

    public RoutePathProjectPoints() {
        this.path_idx = 0;
        this.via_proj_info = new ArrayList<>();
    }

    public RoutePathProjectPoints(int i, ArrayList<RouteViaProjInfo> arrayList) {
        this.path_idx = i;
        this.via_proj_info = arrayList;
    }
}
