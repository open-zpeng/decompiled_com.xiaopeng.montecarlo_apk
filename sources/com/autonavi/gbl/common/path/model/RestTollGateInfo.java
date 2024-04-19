package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class RestTollGateInfo implements Serializable {
    public String TollGateName;
    public Coord2DDouble pos;
    public long remainDist;
    public long remainTime;

    public RestTollGateInfo() {
        this.remainDist = 0L;
        this.remainTime = 0L;
        this.TollGateName = "";
        this.pos = new Coord2DDouble();
    }

    public RestTollGateInfo(long j, long j2, String str, Coord2DDouble coord2DDouble) {
        this.remainDist = j;
        this.remainTime = j2;
        this.TollGateName = str;
        this.pos = coord2DDouble;
    }
}
