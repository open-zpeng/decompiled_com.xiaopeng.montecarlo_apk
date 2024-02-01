package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LDWLineStyleMessage extends LanePlayerMessage implements Serializable {
    @LaneRenderScreen.LaneRenderScreen1
    public int renderID = 0;
    public LDWLineStyle style = new LDWLineStyle();

    public LDWLineStyleMessage() {
        this.type = 12;
    }
}
