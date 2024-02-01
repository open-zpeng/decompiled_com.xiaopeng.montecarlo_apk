package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CarStyleMessage extends LanePlayerMessage implements Serializable {
    @LaneRenderScreen.LaneRenderScreen1
    public int renderID = 0;
    public CarStyleInfo carStyle = new CarStyleInfo();

    public CarStyleMessage() {
        this.type = 2;
    }
}
