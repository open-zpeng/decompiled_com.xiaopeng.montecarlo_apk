package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.io.Serializable;
/* loaded from: classes.dex */
public class DecisionDirectionStyleMessage extends LanePlayerMessage implements Serializable {
    @LaneRenderScreen.LaneRenderScreen1
    public int renderID = 0;
    public DecisionDirectionStyle directionStyle = new DecisionDirectionStyle();

    public DecisionDirectionStyleMessage() {
        this.type = 4;
    }
}
