package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneSideLineInfoMessage extends LanePlayerMessage implements Serializable {
    @LaneRenderScreen.LaneRenderScreen1
    public int renderID = 0;
    public LaneSideLineInfo line = new LaneSideLineInfo();

    public LaneSideLineInfoMessage() {
        this.type = 9;
    }
}
