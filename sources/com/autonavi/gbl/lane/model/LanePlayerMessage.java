package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LanePlayerMessageType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LanePlayerMessage implements Serializable {
    @LanePlayerMessageType.LanePlayerMessageType1
    public int type;

    public LanePlayerMessage() {
        this.type = 0;
    }

    public LanePlayerMessage(@LanePlayerMessageType.LanePlayerMessageType1 int i) {
        this.type = i;
    }
}
