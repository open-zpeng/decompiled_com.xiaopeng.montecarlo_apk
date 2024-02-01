package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class DispatchInfo implements Serializable {
    public String desc;
    public long eventType;
    public Coord2DDouble pos2D;
    public Coord3DDouble pos3D;
    public String title;

    public DispatchInfo() {
        this.pos2D = new Coord2DDouble();
        this.pos3D = new Coord3DDouble();
        this.title = "";
        this.desc = "";
        this.eventType = 0L;
    }

    public DispatchInfo(Coord2DDouble coord2DDouble, Coord3DDouble coord3DDouble, String str, String str2, long j) {
        this.pos2D = coord2DDouble;
        this.pos3D = coord3DDouble;
        this.title = str;
        this.desc = str2;
        this.eventType = j;
    }
}
