package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class STAvoidJamDetail extends STDetail implements Serializable {
    public long detailSpeed = 0;
    public long detailTime = 0;
    public long detailStatus = 0;
    public long detailDist = 0;
    public String strDetailRoadName = "";
    public Coord2DDouble pos2D = new Coord2DDouble();
    public Coord3DDouble pos3D = new Coord3DDouble();

    public STAvoidJamDetail() {
        this.detailCategory = 1;
    }
}
