package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneSideLineStyleMessage extends LanePlayerMessage implements Serializable {
    @LaneRenderScreen.LaneRenderScreen1
    public int renderID = 0;
    public LaneSideLineStyle style = new LaneSideLineStyle();

    public LaneSideLineStyleMessage() {
        this.type = 8;
    }
}
