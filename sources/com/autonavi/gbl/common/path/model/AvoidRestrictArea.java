package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DFloat;
import com.autonavi.gbl.common.model.Coord3DFloat;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AvoidRestrictArea implements Serializable {
    public boolean bIsVaild;
    public int distance;
    public String policyName;
    public Coord2DFloat pos2D;
    public Coord3DFloat pos3D;
    public short priority;
    public String roadName;
    public short type;

    public AvoidRestrictArea() {
        this.bIsVaild = false;
        this.pos2D = new Coord2DFloat();
        this.pos3D = new Coord3DFloat();
        this.roadName = "";
        this.policyName = "";
        this.distance = 0;
        this.type = (short) 0;
        this.priority = (short) 0;
    }

    public AvoidRestrictArea(boolean z, Coord2DFloat coord2DFloat, Coord3DFloat coord3DFloat, String str, String str2, int i, short s, short s2) {
        this.bIsVaild = z;
        this.pos2D = coord2DFloat;
        this.pos3D = coord3DFloat;
        this.roadName = str;
        this.policyName = str2;
        this.distance = i;
        this.type = s;
        this.priority = s2;
    }
}
