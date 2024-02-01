package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LanePlayerOpenMessageType;
import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneOpenMessage extends LanePlayerMessage implements Serializable {
    @LanePlayerOpenMessageType.LanePlayerOpenMessageType1
    public int openType = 0;
    @LaneRenderScreen.LaneRenderScreen1
    public int renderID = 0;
    public boolean open = false;

    public LaneOpenMessage() {
        this.type = 7;
    }
}
