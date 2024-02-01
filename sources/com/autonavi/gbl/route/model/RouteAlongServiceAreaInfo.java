package com.autonavi.gbl.route.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class RouteAlongServiceAreaInfo implements Serializable {
    public ArrayList<RouteServiceAreaInfo> areaList;
    public long pathID;

    public RouteAlongServiceAreaInfo() {
        this.pathID = 0L;
        this.areaList = new ArrayList<>();
    }

    public RouteAlongServiceAreaInfo(long j, ArrayList<RouteServiceAreaInfo> arrayList) {
        this.pathID = j;
        this.areaList = arrayList;
    }
}
