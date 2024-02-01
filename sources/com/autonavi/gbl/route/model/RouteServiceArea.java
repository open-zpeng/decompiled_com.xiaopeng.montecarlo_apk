package com.autonavi.gbl.route.model;

import java.io.Serializable;
@Deprecated
/* loaded from: classes2.dex */
public class RouteServiceArea implements Serializable {
    public String name;
    public long pathID;
    public String poiID;
    public long sapaDetail;

    public RouteServiceArea() {
        this.pathID = 0L;
        this.name = "";
        this.poiID = "";
        this.sapaDetail = 0L;
    }

    public RouteServiceArea(long j, String str, String str2, long j2) {
        this.pathID = j;
        this.name = str;
        this.poiID = str2;
        this.sapaDetail = j2;
    }
}
