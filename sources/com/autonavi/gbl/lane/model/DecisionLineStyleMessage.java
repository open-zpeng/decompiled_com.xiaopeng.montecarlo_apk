package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.io.Serializable;
/* loaded from: classes.dex */
public class DecisionLineStyleMessage extends LanePlayerMessage implements Serializable {
    @LaneRenderScreen.LaneRenderScreen1
    public int renderID = 0;
    public DecisionLineStyleInfo decisionStyle = new DecisionLineStyleInfo();

    public DecisionLineStyleMessage() {
        this.type = 3;
    }
}
