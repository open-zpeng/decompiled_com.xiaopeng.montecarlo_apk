package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.guide.model.ManeuverType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ManeuverInfo implements Serializable {
    public long maneuverID;
    public ManeuverBuffer manuverbuffer;
    public long pathID;
    public long segmentIndex;
    @ManeuverType.ManeuverType1
    public int type;

    public ManeuverInfo() {
        this.type = 0;
        this.pathID = 0L;
        this.segmentIndex = 0L;
        this.maneuverID = 0L;
        this.manuverbuffer = new ManeuverBuffer();
    }

    public ManeuverInfo(@ManeuverType.ManeuverType1 int i, long j, long j2, long j3, ManeuverBuffer maneuverBuffer) {
        this.type = i;
        this.pathID = j;
        this.segmentIndex = j2;
        this.maneuverID = j3;
        this.manuverbuffer = maneuverBuffer;
    }
}
