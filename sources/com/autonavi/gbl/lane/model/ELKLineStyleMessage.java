package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ELKLineStyleMessage extends LanePlayerMessage implements Serializable {
    @LaneRenderScreen.LaneRenderScreen1
    public int renderID = 0;
    public ELKLineStyle style = new ELKLineStyle();

    public ELKLineStyleMessage() {
        this.type = 14;
    }
}
