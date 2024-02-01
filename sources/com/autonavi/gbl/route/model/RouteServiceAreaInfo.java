package com.autonavi.gbl.route.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class RouteServiceAreaInfo implements Serializable {
    public String name;
    public String poiID;
    public Coord2DDouble pos;
    public long remainDist;
    public long remainTime;
    public long sapaDetail;

    public RouteServiceAreaInfo() {
        this.remainDist = 0L;
        this.remainTime = 0L;
        this.name = "";
        this.poiID = "";
        this.pos = new Coord2DDouble();
        this.sapaDetail = 0L;
    }

    public RouteServiceAreaInfo(long j, long j2, String str, String str2, Coord2DDouble coord2DDouble, long j3) {
        this.remainDist = j;
        this.remainTime = j2;
        this.name = str;
        this.poiID = str2;
        this.pos = coord2DDouble;
        this.sapaDetail = j3;
    }
}
