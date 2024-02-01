package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.io.Serializable;
/* loaded from: classes.dex */
public class SRRangeFilterParamMessage extends LanePlayerMessage implements Serializable {
    @LaneRenderScreen.LaneRenderScreen1
    public int renderID = 0;
    public LaneSRRangeFilterParam filterParam = new LaneSRRangeFilterParam();

    public SRRangeFilterParamMessage() {
        this.type = 16;
    }
}
