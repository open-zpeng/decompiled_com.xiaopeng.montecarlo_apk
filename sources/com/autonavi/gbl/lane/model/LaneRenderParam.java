package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneRenderParam implements Serializable {
    @LaneRenderScreen.LaneRenderScreen1
    public int screen;

    public LaneRenderParam() {
        this.screen = 0;
    }

    public LaneRenderParam(@LaneRenderScreen.LaneRenderScreen1 int i) {
        this.screen = i;
    }
}
