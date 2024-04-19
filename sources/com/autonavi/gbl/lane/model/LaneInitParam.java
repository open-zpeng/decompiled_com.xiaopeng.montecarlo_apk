package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LndsSourceDataMode;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneInitParam implements Serializable {
    @LndsSourceDataMode.LndsSourceDataMode1
    public int dataMode;
    public boolean offlineDebug;

    public LaneInitParam() {
        this.offlineDebug = false;
        this.dataMode = 0;
    }

    public LaneInitParam(boolean z, @LndsSourceDataMode.LndsSourceDataMode1 int i) {
        this.offlineDebug = z;
        this.dataMode = i;
    }
}
