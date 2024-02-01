package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.io.Serializable;
/* loaded from: classes.dex */
public class SRObjectsMessage extends LanePlayerMessage implements Serializable {
    @LaneRenderScreen.LaneRenderScreen1
    public int renderID = 0;
    public SimplifiedSRObjects srData = new SimplifiedSRObjects();

    public SRObjectsMessage() {
        this.type = 1;
    }
}
