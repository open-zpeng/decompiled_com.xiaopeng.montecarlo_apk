package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LDWLineInfoMessage extends LanePlayerMessage implements Serializable {
    @LaneRenderScreen.LaneRenderScreen1
    public int renderID = 0;
    public LDWLineInfo line = new LDWLineInfo();

    public LDWLineInfoMessage() {
        this.type = 13;
    }
}
