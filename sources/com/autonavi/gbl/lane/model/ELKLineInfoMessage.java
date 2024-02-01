package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ELKLineInfoMessage extends LanePlayerMessage implements Serializable {
    @LaneRenderScreen.LaneRenderScreen1
    public int renderID = 0;
    public ELKLineInfo line = new ELKLineInfo();

    public ELKLineInfoMessage() {
        this.type = 15;
    }
}
