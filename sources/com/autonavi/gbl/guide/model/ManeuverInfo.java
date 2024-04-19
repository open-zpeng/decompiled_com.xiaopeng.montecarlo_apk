package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.guide.model.ManeuverType;
import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ManeuverInfo implements Serializable {
    public BinaryStream dataBuf;
    public long maneuverID;
    public long pathID;
    public long segmentIndex;
    @ManeuverType.ManeuverType1
    public int type;

    public ManeuverInfo() {
        this.type = 0;
        this.pathID = 0L;
        this.segmentIndex = 0L;
        this.maneuverID = 0L;
        this.dataBuf = new BinaryStream();
    }

    public ManeuverInfo(@ManeuverType.ManeuverType1 int i, long j, long j2, long j3, BinaryStream binaryStream) {
        this.type = i;
        this.pathID = j;
        this.segmentIndex = j2;
        this.maneuverID = j3;
        this.dataBuf = binaryStream;
    }
}
