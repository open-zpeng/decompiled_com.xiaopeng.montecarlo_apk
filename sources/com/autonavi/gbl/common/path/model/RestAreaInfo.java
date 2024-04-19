package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class RestAreaInfo implements Serializable {
    public Coord2DDouble pos;
    public long remainDist;
    public long remainTime;
    public String serviceName;
    public String servicePOIID;

    public RestAreaInfo() {
        this.remainDist = 0L;
        this.remainTime = 0L;
        this.serviceName = "";
        this.servicePOIID = "";
        this.pos = new Coord2DDouble();
    }

    public RestAreaInfo(long j, long j2, String str, String str2, Coord2DDouble coord2DDouble) {
        this.remainDist = j;
        this.remainTime = j2;
        this.serviceName = str;
        this.servicePOIID = str2;
        this.pos = coord2DDouble;
    }
}
